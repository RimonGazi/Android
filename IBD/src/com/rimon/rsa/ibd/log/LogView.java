package com.rimon.rsa.ibd.log;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.android.rsa.googlecludeprint.PrintDialogActivity;
import com.rimon.rsa.ibd.database.DBAdapter;
import com.rimon.rsa.ibd.delete.DeleteLogView;
import com.rimon.rsa.ibd.export.DatabaseToExcell;
import com.rimon.rsa.ibd.export.FileSaveFragment;
import com.rimon.rsa.ibd.export.PatientData;
import com.rimon.rsa.ibd.main.Dialog;
import com.rimon.rsa.ibd.main.NetworkAndDialog;
import com.rimon.rsa.ibd.pdf.PDFPatientQuestion;
import com.rimon.rsa.mental.R;

@SuppressLint("SimpleDateFormat")
public class LogView extends SherlockActivity implements PrintCallback,
		ExportCallback, FileSaveFragment.Callbacks, SaveCallback {
	private DBAdapter adapter;
	private PatientData patientData;
	private ExpendableAdapter expendableAdapter;
	private LinearLayout layout;
	private TextView tvMessage;
	private ExpandableListView expandableListView;
	private String print_file_name;
	private ImageButton btn_delete;
	private boolean isSave;
	private String save_file_name;
	private String xml_file_name = "";
	private String xml_absulate_path = "";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		tvMessage = new TextView(LogView.this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log);
		actionberSetUp();
		layout = (LinearLayout) findViewById(R.id.remove_layout);
		btn_delete = (ImageButton) findViewById(R.id.imageButton_log_delete);
		btn_delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(LogView.this, DeleteLogView.class));

			}
		});

		adapter = new DBAdapter(this);
		adapter.openReadableDatabase();
		if (adapter.getAllCursor().getCount() > 0) {
			expandableListView = (ExpandableListView) findViewById(R.id.expandableListView_log);

			expendableAdapter = new ExpendableAdapter(adapter.getAllCursor(),
					LogView.this);
			expandableListView.setAdapter(expendableAdapter);

			if (tvMessage.getParent() != null) {
				layout.removeView(tvMessage);
			}

		} else {

			tvMessage.setText("No result found");

			tvMessage.setGravity(Gravity.CENTER);
			tvMessage.setTextAppearance(this,
					android.R.style.TextAppearance_Large);
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT);
			tvMessage.setLayoutParams(params);
			tvMessage.setTextColor(getResources().getColor(
					R.color.setting_line_color));
			if (tvMessage.getParent() == null) {
				layout.addView(tvMessage);
				btn_delete.setEnabled(false);
			}

		}

	}

	private void callSave() {

		android.app.FragmentManager fragManager = getFragmentManager();

		String file_extention = "";
		if (isSave) {
			file_extention = getResources().getString(
					R.string.file_extension_pdf);
		} else {
			file_extention = getResources().getString(
					R.string.file_extension_xml);
		}

		FileSaveFragment fsf = FileSaveFragment.newInstance(file_extention,
				R.string.alert_ok, R.string.alert_cancel,
				R.string.alert_file_save_as, R.string.hint_filename_unadorned,
				R.drawable.save);
		fsf.show(fragManager,
				getResources().getString(R.string.tag_fragment_FileSave));
	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {
		boolean canSave = true;

		// Catch the really stupid case.
		if (absolutePath == null || absolutePath.length() == 0
				|| absolutePath.equals(null) || absolutePath.equals("")
				|| fileName == null || fileName.length() == 0) {
			canSave = false;
			Toast.makeText(LogView.this, "Invalid file name", Toast.LENGTH_LONG)
					.show();

		}

		// Do we have a filename if the extension is thrown away?
		if (canSave) {
			// String copyName = FileSaveFragment.NameNoExtension(fileName);

			if (fileName.contains(".")) {
				canSave = false;
				Toast.makeText(LogView.this,
						"Enter only file name, no extention", Toast.LENGTH_LONG)
						.show();
			}
		}

		// Allow only alpha-numeric names. Simplify dealing with reserved path
		// characters.
		if (canSave) {
			if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
				canSave = false;
				Toast.makeText(LogView.this,
						"File name should be only AlphaNumeric",
						Toast.LENGTH_LONG).show();
			}
		}

		// No overwrite of an existing file.
		if (canSave) {
			if (FileSaveFragment.FileExists(absolutePath, fileName)) {
				canSave = false;
				Toast.makeText(LogView.this, "Same file name exit",
						Toast.LENGTH_LONG).show();
			}
		}

		return canSave;
	}

	@Override
	public void onConfirmSave(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {

			if (isSave) {
				this.save_file_name = absolutePath + "/" + fileName
						+ getResources().getString(R.string.file_extension_pdf);
				new SavePdfAsyncTask().execute("");
			} else {

				fileName += getResources().getString(
						R.string.file_extension_xml);
				xml_file_name = fileName;
				xml_absulate_path = absolutePath;
				new ExportXMLAsyncTask().execute("");

			}
		}

	}

	@Override
	public void exportCallback(PatientData patientData) {
		this.patientData = patientData;
		isSave = false;
		callSave();
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

		tv_title.setText("Patient List");
	}

	class printAsyncTask extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(LogView.this);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("wait\n .....");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {

			PDFPatientQuestion pdfPatientQuestion = new PDFPatientQuestion(
					getApplicationContext(), patientData);

			print_file_name = pdfPatientQuestion.getSavePath();

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

			if ((pDialog != null) && (pDialog.isShowing())) {
				pDialog.dismiss();
			}

			File file = new File(print_file_name);
			Intent printIntent = new Intent(LogView.this,
					PrintDialogActivity.class);
			printIntent.setDataAndType(Uri.fromFile(file), "application/pdf");
			printIntent.putExtra("title",
					"Outpatient Brief Mental Health Review");
			printIntent.putExtra("file_name", print_file_name);
			startActivity(printIntent);
		}
	}

	@Override
	public void printCallback(PatientData patientData) {
		this.patientData = patientData;
		if (NetworkAndDialog.isNetworkAvailable(LogView.this)) {
			new printAsyncTask().execute("");
		} else {

			NetworkAndDialog.DialogShow(
					"Network connection not available, Please try later",
					LogView.this);
		}

	}

	@Override
	public void saveCallback(PatientData patientData) {
		this.patientData = patientData;
		isSave = true;
		callSave();
	}

	class SavePdfAsyncTask extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(LogView.this);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("wait\n .....");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {

			PDFPatientQuestion patientQuestion = new PDFPatientQuestion(
					LogView.this, patientData);

			patientQuestion.SavePdfFile(save_file_name);
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

			if ((pDialog != null) && (pDialog.isShowing())) {
				pDialog.dismiss();
			}
			Dialog.DialogShow("File saved.", LogView.this);

		}
	}

	class ExportXMLAsyncTask extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(LogView.this);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("wait\n .....");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {

			DatabaseToExcell excell = new DatabaseToExcell();
			excell.exportToExcel(patientData, xml_file_name, xml_absulate_path,
					LogView.this);

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

			if ((pDialog != null) && (pDialog.isShowing())) {
				pDialog.dismiss();
			}
			Dialog.DialogShow("Export Complete.", LogView.this);

		}
	}

}
