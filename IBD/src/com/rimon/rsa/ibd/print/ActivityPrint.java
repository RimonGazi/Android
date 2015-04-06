package com.rimon.rsa.ibd.print;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
import com.rimon.rsa.ibd.export.FileSaveFragment;
import com.rimon.rsa.ibd.main.Dialog;
import com.rimon.rsa.ibd.main.NetworkAndDialog;
import com.rimon.rsa.ibd.pdf.PDF;
import com.rimon.rsa.mental.R;

@SuppressLint("SimpleDateFormat")
public class ActivityPrint extends SherlockActivity implements
		PrintCallbackPrint, FileSaveFragment.Callbacks {
	private ExpandableListView expandableListView;
	private DBAdapter dbAdapter;
	private LinearLayout layout;
	private TextView tvMessage;
	private PrintExpendableAdapter adapter;
	private String file_name = "";
	private boolean isPrint = false;

	private String print_file_name;

	private PrintResultData data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.print_log);

		tvMessage = new TextView(ActivityPrint.this);
		dbAdapter = new DBAdapter(ActivityPrint.this);
		dbAdapter.openReadableDatabase();
		layout = (LinearLayout) findViewById(R.id.print_layout);
		expandableListView = (ExpandableListView) findViewById(R.id.expandableListView_print);

		if (dbAdapter.getAllCursor().getCount() > 0) {
			if (tvMessage.getParent() != null) {
				layout.removeView(tvMessage);
			}
			adapter = new PrintExpendableAdapter(dbAdapter.getAllCursor(),
					ActivityPrint.this);
			expandableListView.setAdapter(adapter);
			
		} else {

			addNoResultFind();
		}
		actionberSetUp();
		expandableListView = (ExpandableListView) findViewById(R.id.expandableListView_print);

	}

	@Override
	public void printCallback(PrintResultData data, Boolean print) {
		this.data = data;
		isPrint = print;
		if (print) {
			if (NetworkAndDialog.isNetworkAvailable(ActivityPrint.this)) {
				new SavePdfAsyncTask().execute("");

			} else {

				NetworkAndDialog.DialogShow(
						"Network connection not available, Please try later",
						ActivityPrint.this);
			}

		} else {
			android.app.FragmentManager fragManager = getFragmentManager();

			FileSaveFragment fsf = FileSaveFragment.newInstance(getResources()
					.getString(R.string.file_extension_pdf), R.string.alert_ok,
					R.string.alert_cancel, R.string.alert_file_save_as,
					R.string.hint_filename_unadorned, R.drawable.save);
			fsf.show(fragManager,
					getResources().getString(R.string.tag_fragment_FileSave));
		}
	}

	public void addNoResultFind() {
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

		tv_title.setText("Patient Score List");
	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {
		boolean canSave = true;

		// Catch the really stupid case.
		if (absolutePath == null || absolutePath.length() == 0
				|| absolutePath.equals(null) || absolutePath.equals("")
				|| fileName == null || fileName.length() == 0) {
			canSave = false;
			Toast.makeText(ActivityPrint.this, "Invalid file name",
					Toast.LENGTH_LONG).show();

		}

		// Do we have a filename if the extension is thrown away?
		if (canSave) {
			// String copyName = FileSaveFragment.NameNoExtension(fileName);

			if (fileName.contains(".")) {
				canSave = false;
				Toast.makeText(ActivityPrint.this,
						"Enter only file name, no extention", Toast.LENGTH_LONG)
						.show();
			}
		}

		// Allow only alpha-numeric names. Simplify dealing with reserved path
		// characters.
		if (canSave) {
			if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
				canSave = false;
				Toast.makeText(ActivityPrint.this,
						"File name should be only AlphaNumeric",
						Toast.LENGTH_LONG).show();
			}
		}

		// No overwrite of an existing file.
		if (canSave) {
			if (FileSaveFragment.FileExists(absolutePath, fileName)) {
				canSave = false;
				Toast.makeText(ActivityPrint.this, "Same file name exit",
						Toast.LENGTH_LONG).show();
			}
		}

		return canSave;
	}

	@Override
	public void onConfirmSave(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {
			this.file_name = absolutePath + "/" + fileName
					+ getResources().getString(R.string.file_extension_pdf);
			new SavePdfAsyncTask().execute("");

		}

	}

	@SuppressWarnings("unused")
	private void callSave() {
		android.app.FragmentManager fragManager = getFragmentManager();

		FileSaveFragment fsf = FileSaveFragment.newInstance(getResources()
				.getString(R.string.file_extension_xml), R.string.alert_ok,
				R.string.alert_cancel, R.string.alert_file_save_as,
				R.string.hint_filename_unadorned, R.drawable.save);
		fsf.show(fragManager,
				getResources().getString(R.string.tag_fragment_FileSave));
	}

	class SavePdfAsyncTask extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(ActivityPrint.this);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("wait\n .....");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			PDF pdf = new PDF(ActivityPrint.this, data);

			if (isPrint) {

				print_file_name = pdf.getSavePath();

				Log.d("PPPPPPPPPPPPPPP", print_file_name);

			} else {
				pdf.SavePdf(file_name);
			}
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
			if (isPrint) {

				Calendar c = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
				SimpleDateFormat stf = new SimpleDateFormat("hh:mm a");

				String time = " ( Time : " + stf.format(c.getTime());
				time += ", Date : " + sdf.format(c.getTime()) + " )";

				File file = new File(print_file_name);
				Intent printIntent = new Intent(ActivityPrint.this,
						PrintDialogActivity.class);
				printIntent.setDataAndType(Uri.fromFile(file),
						"application/pdf");
				printIntent.putExtra("title", "Patient Result" + time);

				printIntent.putExtra("file_name", print_file_name);
				startActivity(printIntent);

			} else {
				Dialog.DialogShow("File saved.", ActivityPrint.this);
			}

		}
	}
}
