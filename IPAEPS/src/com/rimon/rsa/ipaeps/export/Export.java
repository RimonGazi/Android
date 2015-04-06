package com.rimon.rsa.ipaeps.export;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.actionbar.CustomActionBar;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.filesave.FileSaveFragment;
import com.rimon.rsa.ipaeps.patientlog.PatientLog;

public class Export extends SherlockFragmentActivity implements
		FileSaveFragment.Callbacks {
	private RadioGroup rg_export;
	private Button btn_export;

	@Override
	protected void onCreate(Bundle arg0) {

		super.onCreate(arg0);
		setContentView(R.layout.export_main);
		actionberSetUp();
		btn_export = (Button) findViewById(R.id.btn_export);
		rg_export = (RadioGroup) findViewById(R.id.rg_export);
		btn_export.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (rg_export.getCheckedRadioButtonId() != -1) {
					if (rg_export.getCheckedRadioButtonId() == R.id.rb_certain_e) {
						startActivity(new Intent(Export.this, PatientLog.class));
					} else {
						callSaveDiglog();
					}
				} else {
					Toast.makeText(Export.this,
							getResources().getString(R.string.invalid_input),
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	private void actionberSetUp() {

		CustomActionBar customActionBar = new CustomActionBar(Export.this);
		customActionBar.setupActionBarWithBack(getSupportActionBar(),
				R.drawable.ic_excel_p, R.string.export_3);

	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {

		if (absolutePath == null || absolutePath.length() == 0
				|| absolutePath.equals(null) || absolutePath.equals("")
				|| fileName == null || fileName.length() == 0) {

			Toast.makeText(Export.this, "Invalid file name", Toast.LENGTH_LONG)
					.show();
			return false;

		} else if (fileName.contains(".")) {
			// Do we have a filename if the extension is thrown away?
			// String copyName = FileSaveFragment.NameNoExtension(fileName);

			Toast.makeText(Export.this, "Enter only file name, no extention",
					Toast.LENGTH_LONG).show();
			return false;
		} else if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
			// Allow only alpha-numeric names. Simplify dealing with reserved
			// path
			// characters.
			Toast.makeText(Export.this,
					"File name should be only AlphaNumeric", Toast.LENGTH_LONG)
					.show();
			return false;
		} else if (FileSaveFragment.FileExists(absolutePath, fileName)) {
			// No overwrite of an existing file.
			Toast.makeText(Export.this, "Same file name exit",
					Toast.LENGTH_LONG).show();
			return false;
		} else {
			return true;
		}

	}

	public void onConfirmSave(String absolutePath, String fileName) {
		Cursor dataCursor = null;
		if (absolutePath != null && fileName != null) {

			if (rg_export.getCheckedRadioButtonId() == R.id.rb_all_e) {
				dataCursor = (DatabaseCreator
						.getPpPatientDBOpenHelper(Export.this))
						.getAllPatientCursor();
				if (dataCursor.getCount() > 0) {
					(new ExportAsyncTask(Export.this, absolutePath, fileName
							+ getResources().getString(
									R.string.file_extension_xml), dataCursor))
							.execute("");
				} else {
					Toast.makeText(
							this,
							getResources()
									.getString(
											R.string.there_no_patient_inforamtion_in_database),
							Toast.LENGTH_LONG).show();
				}

			} else if (rg_export.getCheckedRadioButtonId() == R.id.rb_new_e) {

				dataCursor = (DatabaseCreator
						.getPpPatientDBOpenHelper(Export.this))
						.getAllPatientCursorFromExport(false);

				if (dataCursor.getCount() > 0) {
					(new ExportAsyncTask(Export.this,

					absolutePath, fileName
							+ getResources().getString(
									R.string.file_extension_xml), dataCursor))
							.execute("");

				} else {

					Toast.makeText(
							Export.this,
							getResources()
									.getString(
											R.string.there_no_new_patient_inforamtion_in_database),
							Toast.LENGTH_LONG).show();
				}

			}
		}
	}

	private void callSaveDiglog() {

		FileSaveFragment fsf = FileSaveFragment.newInstance(getResources()
				.getString(R.string.file_extension_xml), R.string.alert_ok,
				R.string.alert_cancel, R.string.alert_file_save_as,
				R.string.hint_filename_unadorned, R.drawable.ic_save);
		fsf.setCancelable(false);
		fsf.show(getSupportFragmentManager(),
				getResources().getString(R.string.export_2));

	}
}