package com.rimon.rsa.ipaeps.patientlogdelete;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.actionbar.CustomActionBar;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpPatientDBOpenHelper;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.filesave.FileSaveFragment;

public class PatientLogDelete extends SherlockFragmentActivity implements
		OnClickListener, OnCheckedChangeListener {
	private ExpandableListView expandableListView_log;
	private LogDeleteExpendableAdapter logExpendableAdapter;
	private RelativeLayout log_layout, relative_layout_menu;
	private PpPatientDBOpenHelper ppPatientDBOpenHelper;
	private CheckBox cb_check_all;
	private Button btn_delete;
	private ProgressDialog pDialog = null;

	private void actionberSetUp() {

		CustomActionBar customActionBar = new CustomActionBar(
				PatientLogDelete.this);
		customActionBar.setupActionBarWithBack(getSupportActionBar(),
				R.drawable.ic_log_p, R.string.patient_log_list);

	}

	private void callSaveDiglog(String file_extention) {

		FileSaveFragment fsf = FileSaveFragment.newInstance(file_extention,
				R.string.alert_ok, R.string.alert_cancel,
				R.string.alert_file_save_as, R.string.hint_filename_unadorned,
				R.drawable.ic_save);
		fsf.setCancelable(false);
		fsf.show(getSupportFragmentManager(),
				getResources().getString(R.string.tag_fragment_FileSave));
	}

	public void onCallBack(boolean isPrint, boolean isSave, boolean isExport,
			String data) {
		if (isPrint) {
			Toast.makeText(this, "print", Toast.LENGTH_SHORT).show();
		} else if (isSave) {
			callSaveDiglog(getResources()
					.getString(R.string.file_extension_pdf));
			Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
		} else if (isExport) {
			callSaveDiglog(getResources()
					.getString(R.string.file_extension_xml));
			Toast.makeText(this, "Export", Toast.LENGTH_SHORT).show();
		}
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.log_delete_main);
		btn_delete = (Button) findViewById(R.id.btn_delete);
		btn_delete.setOnClickListener(this);
		cb_check_all = (CheckBox) findViewById(R.id.cb_check_all);
		cb_check_all.setOnCheckedChangeListener(this);
		btn_delete.setTypeface(AppObject.getCurrentFont(this));
		cb_check_all.setTypeface(AppObject.getCurrentFont(this));

		actionberSetUp();
		addAdapter();

	}

	private void addAdapter() {
		ppPatientDBOpenHelper = DatabaseCreator.getPpPatientDBOpenHelper(this);
		if (checkView()) {
			setAdapter();
		} else {
			setMessage();
		}
	}

	private boolean checkView() {
		if (ppPatientDBOpenHelper.getAllPatientCursor().getCount() > 0) {
			return true;
		} else {
			return false;
		}

	}

	private void setAdapter() {
		logExpendableAdapter = new LogDeleteExpendableAdapter(
				ppPatientDBOpenHelper.getAllPatientCursor(), this);
		expandableListView_log = ((ExpandableListView) findViewById(R.id.expandableListView_log));
		expandableListView_log.setAdapter(logExpendableAdapter);
		expandableListView_log
				.setOnGroupClickListener(new OnGroupClickListener() {
					@Override
					public boolean onGroupClick(ExpandableListView parent,
							View v, int groupPosition, long id) {
						return false; // This way the expander cannot be
										// collapsed
					}
				});
		btn_delete.setEnabled(true);
		cb_check_all.setEnabled(true);
	}

	private void setMessage() {

		log_layout = ((RelativeLayout) findViewById(R.id.log_delete_layout));
		log_layout.removeView(expandableListView_log);
		relative_layout_menu = (RelativeLayout) findViewById(R.id.relative_layout_menu);
		log_layout.removeView(relative_layout_menu);
		View localView = getLayoutInflater().inflate(
				R.layout.title_text_view_layout, null);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		log_layout.addView(localView, params);
		btn_delete.setEnabled(false);
		cb_check_all.setEnabled(false);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_delete:
			(new DeleteData()).execute("");
			break;

		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (buttonView.getId() == R.id.cb_check_all) {
			if (isChecked) {

				if (checkView()) {
					LogDeleteExpendableAdapter.chnageState = true;
					for (int i = 0; i < LogDeleteExpendableAdapter.selectedStatus.length; i++) {
						LogDeleteExpendableAdapter.selectedStatus[i] = true;
					}
					logExpendableAdapter.notifyDataSetChanged();
				}

			} else {
				for (int i = 0; i < LogDeleteExpendableAdapter.selectedStatus.length; i++) {
					LogDeleteExpendableAdapter.selectedStatus[i] = false;
				}
				logExpendableAdapter.notifyDataSetChanged();
			}
		}

	}

	class DeleteData extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(PatientLogDelete.this,
					AlertDialog.THEME_HOLO_LIGHT);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage(getResources().getString(R.string.deleting));
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			ArrayList<String> list = new ArrayList<String>();

			for (int i = 0; i < LogDeleteExpendableAdapter.idNumber.length; i++) {
				if (!((LogDeleteExpendableAdapter.idNumber[i]).equals(""))) {
					list.add(LogDeleteExpendableAdapter.idNumber[i]);
				}
			}
			if (list.size() > 0) {

				String deleteIdFields[] = new String[list.size()];
				deleteIdFields = list.toArray(deleteIdFields);

				for (int i = 0; i < deleteIdFields.length; i++) {
					if (ppPatientDBOpenHelper
							.deleteDataFromIdField(deleteIdFields[i])) {

					}
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
			logExpendableAdapter.notifyDataSetChanged();
			super.onPostExecute(result);
			addAdapter();
		}
	}
}
