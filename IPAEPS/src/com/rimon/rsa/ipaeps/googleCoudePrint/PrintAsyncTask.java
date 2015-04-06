package com.rimon.rsa.ipaeps.googleCoudePrint;

import java.io.File;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.customtextandcolor.CustomTextAndColor;
import com.rimon.rsa.ipaeps.pdf.AllPatientQuestionPdf;

public class PrintAsyncTask extends AsyncTask<String, String, String> {
	private Context context;
	private ProgressDialog pDialog;
	private String saveAs;
	private Cursor dataCursor;
	CustomTextAndColor customTextAndColor;

	public PrintAsyncTask(Context context, String saveAs, Cursor dataCursor) {
		this.context = context;
		this.saveAs = saveAs;
		this.dataCursor = dataCursor;

		customTextAndColor = new CustomTextAndColor(context.getResources()
				.getColor(R.color.setting_line_color),
				AppObject.getCurrentFont(context));

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pDialog = null;
		pDialog = new ProgressDialog(context, AlertDialog.THEME_HOLO_LIGHT);
		pDialog.setTitle("");
		pDialog.setMessage(customTextAndColor.setTextColor(context
				.getResources().getString(R.string.saving)));
		pDialog.setMax(100);
		pDialog.setCancelable(false);
		pDialog.show();

	}

	@Override
	protected String doInBackground(String... arg0) {
		AllPatientQuestionPdf allPatientQuestionPdf = new AllPatientQuestionPdf(
				context);
		allPatientQuestionPdf.SavePdf(saveAs, dataCursor);

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

		File file = new File(saveAs);
		Log.d("print AAAAAAAAAAAAAAAAAAA", saveAs);
		Intent printIntent = new Intent(context, PrintDialogActivity.class);
		printIntent.setDataAndType(Uri.fromFile(file), "application/pdf");
		printIntent.putExtra(AppConstants.DIAGLOG_TITLE_ID, context
				.getResources().getString(R.string.print_title_string));
		printIntent.putExtra(AppConstants.DIAGLOG_FILE, saveAs);
		context.startActivity(printIntent);

	}
}
