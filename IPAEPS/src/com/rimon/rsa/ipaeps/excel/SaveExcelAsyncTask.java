package com.rimon.rsa.ipaeps.excel;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.customtextandcolor.CustomTextAndColor;

public class SaveExcelAsyncTask extends AsyncTask<String, String, String> {
	private Context context;
	private ProgressDialog pDialog;
	private String fileName;
	private String path;
	private Cursor dataCursor;
	CustomTextAndColor customTextAndColor;

	public SaveExcelAsyncTask(Context context, String path, String fileName,
			Cursor dataCursor) {
		this.context = context;
		this.fileName = fileName;
		this.dataCursor = dataCursor;
		this.path = path;
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
		DatabaseToExcell databaseToExcell = new DatabaseToExcell(context, path,
				fileName);
		databaseToExcell.exportToExcelWithSingleCursor(dataCursor);

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
	}
}
