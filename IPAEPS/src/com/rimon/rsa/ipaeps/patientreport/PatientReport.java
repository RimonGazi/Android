package com.rimon.rsa.ipaeps.patientreport;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.actionbar.CustomActionBar;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpPatientDBOpenHelper;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.filesave.FileSaveFragment;
import com.rimon.rsa.ipaeps.googleCoudePrint.PrintAsyncTask;

public class PatientReport extends SherlockFragmentActivity implements
		PateintListener, FileSaveFragment.Callbacks, AnyDialogListener {
	private ExpandableListView expandableListView_log;
	private PatientReportExpendableAdapter logExpendableAdapter;
	private RelativeLayout log_layout;
	private PpPatientDBOpenHelper ppPatientDBOpenHelper;
	private Cursor dataCursor;
	private AnyDiaglogFragmentForActivity diaglogFragment;
	private Bundle bundle;
	private List<String> list;
	private int selected;
	private boolean isSingleDiaglog = true;
	private ReportModuleSettingData moduleSettingData;

	private void actionberSetUp() {
		CustomActionBar customActionBar = new CustomActionBar(
				PatientReport.this);
		customActionBar.setupActionBarWithBack(getSupportActionBar(),
				R.drawable.ic_report_p, R.string.patient_report_2);
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

	@Override
	public void onCallBack(boolean isPrint, boolean isSave, Cursor dataCursor) {
		this.dataCursor = dataCursor;
		if (isSave) {
			showDialog(R.array.report_selected, R.id.btn_save,
					R.string.what_would_you_like_to_save, "");

		} else if (isPrint) {
			showDialog(R.array.report_selected, R.id.btn_print,
					R.string.what_would_you_like_to_print, "");
		}
	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {

		if (absolutePath == null || absolutePath.length() == 0
				|| absolutePath.equals(null) || absolutePath.equals("")
				|| fileName == null || fileName.length() == 0) {

			Toast.makeText(PatientReport.this, "Invalid file name",
					Toast.LENGTH_LONG).show();
			return false;

		} else if (fileName.contains(".")) {
			// Do we have a filename if the extension is thrown away?
			// String copyName = FileSaveFragment.NameNoExtension(fileName);

			Toast.makeText(PatientReport.this,
					"Enter only file name, no extention", Toast.LENGTH_LONG)
					.show();
			return false;
		} else if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
			// Allow only alpha-numeric names. Simplify dealing with reserved
			// path
			// characters.
			Toast.makeText(PatientReport.this,
					"File name should be only AlphaNumeric", Toast.LENGTH_LONG)
					.show();
			return false;
		} else if (FileSaveFragment.FileExists(absolutePath, fileName)) {
			// No overwrite of an existing file.
			Toast.makeText(PatientReport.this, "Same file name exit",
					Toast.LENGTH_LONG).show();
			return false;
		} else {
			return true;
		}

	}

	public void onConfirmSave(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {
			if (selected == 0) {
				moduleSettingData = new ReportAllMoudle();

			}
			(new SaveReportPdfAsyncTask(PatientReport.this, absolutePath
					+ File.separator + fileName
					+ getResources().getString(R.string.file_extension_pdf),
					dataCursor, moduleSettingData)).execute("");

		}
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.log_main);

		actionberSetUp();
		list = Arrays.asList(getResources().getStringArray(
				R.array.report_selected));
		diaglogFragment = new AnyDiaglogFragmentForActivity();
		bundle = new Bundle();
		ppPatientDBOpenHelper = DatabaseCreator.getPpPatientDBOpenHelper(this);
		if (ppPatientDBOpenHelper.getAllPatientCursor().getCount() > 0) {
			logExpendableAdapter = new PatientReportExpendableAdapter(
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

	private void showDialog(int array_id, int view_id, int title_id,
			String previous_selection) {
		if (isSingleDiaglog) {
			isSingleDiaglog = false;
			bundle.putInt(AppConstants.DIAGLOG_ARRAY_ID, array_id);
			bundle.putInt(AppConstants.DIAGLOG_VIEW_ID, view_id);
			bundle.putInt(AppConstants.DIAGLOG_TITLE_ID, title_id);
			bundle.putString(AppConstants.DIAGLOG_PREVIOUS_SELECTION,
					previous_selection);

			diaglogFragment.setArguments(bundle);
			diaglogFragment.show(getSupportFragmentManager(), "diaglog");

		}
	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		if (R.id.btn_save == view_id) {
			Log.d("llllllllllllll", selected_item);
			Log.d("llllllllllllll", list.indexOf(selected_item)+"");
			
			callSaveDiglog(getResources()
					.getString(R.string.file_extension_pdf));

		} else if (R.id.btn_print == view_id) {

			(new PrintAsyncTask(PatientReport.this, Environment
					.getExternalStorageDirectory().toString()
					+ File.separator
					+ getResources().getString(R.string.print_temp_file),
					dataCursor)).execute("");
		}

	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;
	}
}
