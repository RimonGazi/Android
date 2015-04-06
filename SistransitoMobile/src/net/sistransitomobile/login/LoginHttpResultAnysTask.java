package net.sistransitomobile.login;

import net.isstransitomobile.autoEquipmentEntry.AutoEquipmentEntryJsonTask;
import net.sistransitomobile.appobject.AppObject;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

public class LoginHttpResultAnysTask extends AsyncTask<String, Integer, String> {
	public ProgressDialog pDialog;
	private String jsonText = null;
	private LogJsonFormat logJsonFormat;
	private String url;
	public FragmentCallBackLogin listener;
	private final String autoEntry_ulr = "http://www.sistransito.net/movel/dosis.pl?op=equipamentos";
	private String autoEntry = "";
	private AutoEquipmentEntryJsonTask entryJsonTask;
	private Context context;

	public LoginHttpResultAnysTask(final FragmentCallBackLogin listener,
			Context context, String url) {
		this.context = context;

		this.url = url;
		this.listener = listener;
		pDialog = null;
		pDialog = new ProgressDialog(context, AlertDialog.THEME_HOLO_LIGHT);
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
			jsonText = AppObject.getHttpClient().executeHttpGet(url);
			logJsonFormat = new LogJsonFormat(jsonText);
			Log.d("Loginnnnnnnnnnnnnnnnnnnnnnn", " sdd" + jsonText);
			autoEntry = AppObject.getHttpClient().executeHttpGet(autoEntry_ulr);
			Log.d("Loginnnnnnnnnnnnnnnnnnnnnnn", " sdd" + jsonText);
			entryJsonTask = new AutoEquipmentEntryJsonTask(autoEntry, context);
			entryJsonTask.prepareEntry();

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		listener.CallBack(logJsonFormat);
		super.onPostExecute(result);
	}
}