package com.rimon.rsa.ipaeps.export;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.customtextandcolor.CustomTextAndColor;
import com.rimon.rsa.ipaeps.excel.DatabaseToExcell;

public class ExportAsyncTask extends AsyncTask<String, String, String> {
	private Context context;
	private ProgressDialog pDialog;
	private String fileName;
	private String path;
	private Cursor dataCursor;
	private CustomTextAndColor customTextAndColor;

	public ExportAsyncTask(Context context, String path, String fileName,
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
		if (dataCursor != null) {
			
			int id[] = databaseToExcell
					.exportToExcelWithMultipleCursor(dataCursor);
			for (int i = 0; i < id.length; i++) {
				(DatabaseCreator.getPpPatientDBOpenHelper(context))
						.updateExportStatus(id[i], true);
			}
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

	}
}
