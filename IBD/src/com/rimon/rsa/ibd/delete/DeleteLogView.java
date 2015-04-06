package com.rimon.rsa.ibd.delete;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.rimon.rsa.ibd.database.DBAdapter;
import com.rimon.rsa.ibd.database.DBHelper;
import com.rimon.rsa.mental.R;

public class DeleteLogView extends SherlockActivity implements OnClickListener {

	ExpandableListView expandableListView;
	RemoveExpendableAdapter removeExpendableAdapter;
	DBAdapter dbAdapter;
	ProgressDialog pDialog = null;
	ImageButton allCheckButton, allCancleButton, deleteButton;
	LinearLayout layout;
	private TextView tvMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		tvMessage = new TextView(DeleteLogView.this);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.delete_main);
		actionberSetUp();
		allCheckButton = (ImageButton) findViewById(R.id.imageButton1);
		allCancleButton = (ImageButton) findViewById(R.id.imageButton2);
		deleteButton = (ImageButton) findViewById(R.id.imageButton3);
		allCheckButton.setOnClickListener(this);
		allCancleButton.setOnClickListener(this);
		deleteButton.setOnClickListener(this);
		expandableListView = (ExpandableListView) findViewById(R.id.remove_expandableListView);
		layout = (LinearLayout) findViewById(R.id.log_layout);
		dbAdapter = new DBAdapter(DeleteLogView.this);
		dbAdapter.openWriteableDatabase();
		if (dbAdapter.getAllCursor().getCount() > 0) {
			if (tvMessage.getParent() != null) {
				layout.removeView(tvMessage);
			}
			removeExpendableAdapter = new RemoveExpendableAdapter(
					dbAdapter.getAllCursor(), DeleteLogView.this);
			expandableListView.setAdapter(removeExpendableAdapter);
		} else {

			addNoResultTitle();
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageButton1:
			if (dbAdapter.getAllCursor().getCount() > 0) {
				RemoveExpendableAdapter.chnageState = true;
				for (int i = 0; i < RemoveExpendableAdapter.selectedStatus.length; i++) {
					RemoveExpendableAdapter.selectedStatus[i] = true;
				}
				removeExpendableAdapter.notifyDataSetChanged();
			}
			break;
		case R.id.imageButton2:
			if (dbAdapter.getAllCursor().getCount() > 0) {
				RemoveExpendableAdapter.chnageState = true;
				for (int i = 0; i < RemoveExpendableAdapter.selectedStatus.length; i++) {
					RemoveExpendableAdapter.selectedStatus[i] = false;
				}
				removeExpendableAdapter.notifyDataSetChanged();
			}

			break;
		case R.id.imageButton3:
			if (dbAdapter.getAllCursor().getCount() > 0) {
				new DeleteData().execute("");
				removeExpendableAdapter.notifyDataSetChanged();
			}
			break;

		}

	}

	class DeleteData extends AsyncTask<String, String, String> {

		long value;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(DeleteLogView.this);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("Deleting\n .....");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			ArrayList<String> list = new ArrayList<String>();

			for (int i = 0; i < RemoveExpendableAdapter.idNumber.length; i++) {
				if (!((RemoveExpendableAdapter.idNumber[i]).equals(""))) {
					list.add(RemoveExpendableAdapter.idNumber[i]);
				}
			}
			if (list.size() > 0) {

				String deleteIdFields[] = new String[list.size()];
				deleteIdFields = list.toArray(deleteIdFields);
				for (int i = 0; i < deleteIdFields.length; i++) {
					value = dbAdapter.deleteData(DBHelper.TABLE_NAME_PATIENT,
							DBHelper.ID_FIELD + "=?",
							new String[] { deleteIdFields[i] });
				}
			}

			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			// pDialog.setProgress(Integer.parseInt(values[0]));
		}

		@Override
		protected void onPostExecute(String result) {
			if ((pDialog.isShowing()) || (pDialog != null)) {
				pDialog.dismiss();
				pDialog = null;
			}
			removeExpendableAdapter.notifyDataSetChanged();
			super.onPostExecute(result);
			if (dbAdapter.getAllCursor().getCount() > 0) {
				removeExpendableAdapter = new RemoveExpendableAdapter(
						dbAdapter.getAllCursor(), DeleteLogView.this);
				expandableListView.setAdapter(removeExpendableAdapter);
			} else {
				addNoResultTitle();
			}
		}

	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
		dbAdapter.close();
	}

	private void actionberSetUp() {
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View view = getLayoutInflater().inflate(R.layout.custom_action_bar,
				null);
		getSupportActionBar().setCustomView(
				view,
				new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
						ActionBar.LayoutParams.MATCH_PARENT));
		ImageButton back = (ImageButton) view.findViewById(R.id.back);
		TextView tv_title = (TextView) view.findViewById(R.id.actionber_tv);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});

		tv_title.setText("" + "Delete Patient information");
	}

	public void addNoResultTitle() {
		tvMessage.setText("No result found");

		tvMessage.setGravity(Gravity.CENTER);
		tvMessage.setTextAppearance(this, android.R.style.TextAppearance_Large);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		tvMessage.setLayoutParams(params);
		tvMessage.setTextColor(getResources().getColor(
				R.color.setting_line_color));
		if (tvMessage.getParent() == null) {
			layout.addView(tvMessage);
		}
	}
}
