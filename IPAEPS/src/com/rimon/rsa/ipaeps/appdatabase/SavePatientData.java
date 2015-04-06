package com.rimon.rsa.ipaeps.appdatabase;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.rimon.rsa.ipaeps.R;

public class SavePatientData extends AsyncTask<String, String, String> {
	private Context context;
	private ProgressDialog pDialog;
	private PpPatientDBOpenHelper dbOpenHelper;
	private boolean isSave;

	public SavePatientData(Context context) {
		this.context = context;
		dbOpenHelper = DatabaseCreator.getPpPatientDBOpenHelper(context);

	}

	@Override
	protected void onPreExecute() {

		super.onPreExecute();
		pDialog = null;
		pDialog = new ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT);
		pDialog.setMax(100);
		pDialog.setCancelable(false);
		pDialog.setMessage("Saving\n .....");
		pDialog.show();
	}

	@Override
	protected String doInBackground(String... params) {
		isSave = dbOpenHelper.savePatientData();
		return null;
	}

	@Override
	protected void onProgressUpdate(String... values) {
		super.onProgressUpdate(values);
		pDialog.setProgress(Integer.parseInt(values[0]));
	}

	@Override
	protected void onPostExecute(String result) {
		if ((pDialog != null) && (pDialog.isShowing())) {
			pDialog.dismiss();
		}

		if (isSave) {
			// Toast.makeText(
			// context,
			// context.getResources().getString(
			// R.string.patient_data_saved_successfully),
			// Toast.LENGTH_LONG).show();
			//
			// AppConstants.setDefaultDAtaAll();
		} else {
			Toast.makeText(
					context,
					context.getResources().getString(
							R.string.patient_data_not_saved), Toast.LENGTH_LONG)
					.show();

		}

	}

}
