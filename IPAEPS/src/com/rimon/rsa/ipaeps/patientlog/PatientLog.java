package com.rimon.rsa.ipaeps.patientlog;

import java.io.File;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.actionbar.CustomActionBar;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpPatientDBOpenHelper;
import com.rimon.rsa.ipaeps.excel.SaveExcelAsyncTask;
import com.rimon.rsa.ipaeps.filesave.FileSaveFragment;
import com.rimon.rsa.ipaeps.googleCoudePrint.PrintAsyncTask;
import com.rimon.rsa.ipaeps.pdf.SavePdfAsyncTask;

public class PatientLog extends SherlockFragmentActivity implements
		LogListener, FileSaveFragment.Callbacks {
	private ExpandableListView expandableListView_log;
	private LogExpendableAdapter logExpendableAdapter;
	private RelativeLayout log_layout;
	private PpPatientDBOpenHelper ppPatientDBOpenHelper;
	private boolean isSavePdf, isExport;
	private Cursor dataCursor;

	private void actionberSetUp() {

		CustomActionBar customActionBar = new CustomActionBar(PatientLog.this);
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
			Cursor dataCursor) {
		this.dataCursor = dataCursor;
		this.isSavePdf = isSave;
		this.isExport = isExport;

		if (isSave) {

			callSaveDiglog(getResources()
					.getString(R.string.file_extension_pdf));

		} else if (isExport) {

			callSaveDiglog(getResources()
					.getString(R.string.file_extension_xml));

		} else if (isPrint) {
			(new PrintAsyncTask(PatientLog.this, Environment
					.getExternalStorageDirectory().toString()
					+ File.separator
					+ getResources().getString(R.string.print_temp_file),
					dataCursor)).execute("");
		}
	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {

		if (absolutePath == null || absolutePath.length() == 0
				|| absolutePath.equals(null) || absolutePath.equals("")
				|| fileName == null || fileName.length() == 0) {

			Toast.makeText(PatientLog.this, "Invalid file name",
					Toast.LENGTH_LONG).show();
			return false;

		} else if (fileName.contains(".")) {
			// Do we have a filename if the extension is thrown away?
			// String copyName = FileSaveFragment.NameNoExtension(fileName);

			Toast.makeText(PatientLog.this,
					"Enter only file name, no extention", Toast.LENGTH_LONG)
					.show();
			return false;
		} else if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
			// Allow only alpha-numeric names. Simplify dealing with reserved
			// path
			// characters.
			Toast.makeText(PatientLog.this,
					"File name should be only AlphaNumeric", Toast.LENGTH_LONG)
					.show();
			return false;
		} else if (FileSaveFragment.FileExists(absolutePath, fileName)) {
			// No overwrite of an existing file.
			Toast.makeText(PatientLog.this, "Same file name exit",
					Toast.LENGTH_LONG).show();
			return false;
		} else {
			return true;
		}

	}

	public void onConfirmSave(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {

			if (isSavePdf) {
				(new SavePdfAsyncTask(PatientLog.this,
						absolutePath
								+ File.separator
								+ fileName
								+ getResources().getString(
										R.string.file_extension_pdf),
						dataCursor)).execute("");
			} else if (isExport) {
				(new SaveExcelAsyncTask(PatientLog.this,

				absolutePath,
						fileName
								+ getResources().getString(
										R.string.file_extension_xml),
						dataCursor)).execute("");
			}
		}
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.log_main);
		actionberSetUp();
		ppPatientDBOpenHelper = DatabaseCreator.getPpPatientDBOpenHelper(this);
		if (ppPatientDBOpenHelper.getAllPatientCursor().getCount() > 0) {
			logExpendableAdapter = new LogExpendableAdapter(
					ppPatientDBOpenHelper.getAllPatientCursor(), this);
			expandableListView_log = ((ExpandableListView) findViewById(R.id.expandableListView_log));
			expandableListView_log.setAdapter(logExpendableAdapter);
			return;
		} else {
			log_layout = ((RelativeLayout) findViewById(R.id.log_layout));
			log_layout.removeView(expandableListView_log);

			View localView = getLayoutInflater().inflate(
					R.layout.title_text_view_layout, null);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT);
			params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
			log_layout.addView(localView, params);
		}
	}
}
