package net.sistransitomobile.cnh;

import net.sistransitomobile.appobject.AppObject;
import net.sistransitomobile.fragment.CNHFragmentCallBack;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class CnhHttpResultAnysTask extends AsyncTask<String, Integer, String> {
	public ProgressDialog pDialog;
	private Context context;
	private String cnh_url;
	public CNHFragmentCallBack listener;
	private String cnh_result = null;
	private CnhFormat cnhFormat;

	public CnhHttpResultAnysTask(final CNHFragmentCallBack listener,
			Context context, String cnh_url) {
		this.context = context;
		this.cnh_url = cnh_url;
		this.listener = listener;
		pDialog = null;
		pDialog = new ProgressDialog(this.context,AlertDialog.THEME_HOLO_LIGHT);
		pDialog.setMax(100);
		pDialog.setCancelable(false);
		pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						listener.CallBack(null);
						cancel(true);

					}
				});
		pDialog.setMessage("Carregando\n .....");

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pDialog.show();
	}

	@Override
	protected String doInBackground(String... arg0) {
		try {
			cnh_result = AppObject.getHttpClient().executeHttpGet(cnh_url);
			cnhFormat = new CnhFormat(cnh_result, context);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		pDialog.setProgress(values[0]);
	}

	@Override
	protected void onPostExecute(String result) {
		if ((pDialog != null) && (pDialog.isShowing())) {
			pDialog.dismiss();
		}
		listener.CallBack(cnhFormat);
		super.onPostExecute(result);

	}
}