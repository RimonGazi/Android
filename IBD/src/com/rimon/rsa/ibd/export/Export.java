package com.rimon.rsa.ibd.export;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.rimon.rsa.ibd.database.DBAdapter;
import com.rimon.rsa.ibd.database.DBHelper;
import com.rimon.rsa.ibd.log.LogView;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.Dialog;
import com.rimon.rsa.mental.R;

public class Export extends SherlockActivity implements
		OnCheckedChangeListener, FileSaveFragment.Callbacks {
	private CheckBox cb_new_data, cb_all_data, cb_certain_data;
	private Button btn_export;
	private DBAdapter adapter;
	private Cursor cursor;
	private String path, name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		actionberSetUp();
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);

		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.export);
		adapter = new DBAdapter(Export.this);

		cb_new_data = (CheckBox) findViewById(R.id.cb_new_p_data);
		cb_new_data.setOnCheckedChangeListener(this);
		cb_certain_data = (CheckBox) findViewById(R.id.cb_certain_p_data);
		cb_certain_data.setOnCheckedChangeListener(this);
		cb_all_data = (CheckBox) findViewById(R.id.cb_all_p_data);
		cb_all_data.setOnCheckedChangeListener(this);
		btn_export = (Button) findViewById(R.id.btn_export);

		btn_export.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (cb_all_data.isChecked()) {

					adapter.openWriteableDatabase();
					cursor = adapter.getAllCursor();
					if (cursor.getCount() > 0) {
						callSave();

					} else {
						Dialog.DialogShow("There are no data to export.",
								Export.this);
					}

				} else if (cb_new_data.isChecked()) {

					adapter.openWriteableDatabase();
					cursor = adapter.getNewPatientCursor();
					if (cursor.getCount() > 0) {
						callSave();

					} else {
						Dialog.DialogShow("There are no new data to export.",
								Export.this);
					}

				} else if (cb_certain_data.isChecked()) {
					startActivity(new Intent(Export.this, LogView.class));
					cb_certain_data.setChecked(false);

				} else {
					Dialog.DialogShow("Select at least one option.",
							Export.this);
				}
			}
		});

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

		tv_title.setText(getResources().getString(R.string.export));
	}

	@Override
	public void onCheckedChanged(CompoundButton v, boolean ischecked) {
		if (ischecked) {
			switch (v.getId()) {
			case R.id.cb_new_p_data:
				cb_certain_data.setChecked(false);
				cb_all_data.setChecked(false);
				break;
			case R.id.cb_certain_p_data:
				cb_new_data.setChecked(false);
				cb_all_data.setChecked(false);
				break;
			case R.id.cb_all_p_data:
				cb_new_data.setChecked(false);
				cb_certain_data.setChecked(false);
				break;

			}
		}

	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {
		boolean canSave = true;

		// Catch the really stupid case.
		if (absolutePath == null || absolutePath.length() == 0
				|| absolutePath.equals(null) || absolutePath.equals("")
				|| fileName == null || fileName.length() == 0) {
			canSave = false;
			Toast.makeText(Export.this, "Invalid file name", Toast.LENGTH_LONG)
					.show();

		}

		// Do we have a filename if the extension is thrown away?
		if (canSave) {
			// String copyName = FileSaveFragment.NameNoExtension(fileName);

			if (fileName.contains(".")) {
				canSave = false;
				Toast.makeText(Export.this,
						"Enter only file name, no extention", Toast.LENGTH_LONG)
						.show();
			}
		}

		// Allow only alpha-numeric names. Simplify dealing with reserved path
		// characters.
		if (canSave) {
			if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
				canSave = false;
				Toast.makeText(Export.this,
						"File name should be only AlphaNumeric",
						Toast.LENGTH_LONG).show();
			}
		}

		// No overwrite of an existing file.
		if (canSave) {
			if (FileSaveFragment.FileExists(absolutePath, fileName)) {
				canSave = false;
				Toast.makeText(Export.this, "Same file name exit",
						Toast.LENGTH_LONG).show();
			}
		}

		return canSave;
	}

	@Override
	public void onConfirmSave(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {

			name = fileName
					+ getResources().getString(R.string.file_extension_xml);
			path = absolutePath;
			new ExportAsyncTask().execute("");

		}

	}

	private void callSave() {

		android.app.FragmentManager fragManager = getFragmentManager();

		FileSaveFragment fsf = FileSaveFragment.newInstance(getResources()
				.getString(R.string.file_extension_xml), R.string.alert_ok,
				R.string.alert_cancel, R.string.alert_file_save_as,
				R.string.hint_filename_unadorned, R.drawable.save);
		fsf.show(fragManager,
				getResources().getString(R.string.tag_fragment_FileSave));
	}

	class ExportAsyncTask extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(Export.this);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("wait\n .....");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			DatabaseToExcell excell = new DatabaseToExcell();

			excell.exportToExcel(cursor, name, path, Export.this);

			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			pDialog.setProgress(Integer.parseInt(values[0]));
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			cursor.moveToFirst();
			do {
				if ((cursor.getString(cursor
						.getColumnIndex(DBHelper.EXPORT_STATUS)))
						.equals(ConstantValues.export_status_false)) {
					adapter.updateData(cursor.getString(cursor
							.getColumnIndex(DBHelper.ID_FIELD)));
				}

			} while (cursor.moveToNext());

			if ((pDialog != null) && (pDialog.isShowing())) {
				pDialog.dismiss();
			}
			cursor.close();
			adapter.close();
			cb_all_data.setChecked(false);
			cb_new_data.setChecked(false);
			Dialog.DialogShow("Export Complete.", Export.this);

		}
	}

}
