package net.sistransitomobile.placa.data;

import net.sistransitomobile.appobject.AppObject;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.fragment.FragmentCallBack;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class PlacaHttpResultAnysTask extends AsyncTask<String, Integer, String> {
	public ProgressDialog pDialog;
	private String jsonText = null;
	private Context context;
	private boolean isOffline;
	private PlacaRawFormat placaRawFormat;
	private String placa;
	public FragmentCallBack listener;
	private CreatePlacaRawDataFromJson createPlacaRawData;
	private final String URL = "http://sistransito.net/movel/dosis.pl?op=placa&p=";

	public PlacaHttpResultAnysTask(final FragmentCallBack listener,
			Context context, final boolean isOffline, String placa) {
		this.context = context;
		this.isOffline = isOffline;
		this.placa = placa;
		this.listener = listener;
		pDialog = null;
		pDialog = new ProgressDialog(context);
		pDialog.setMax(100);
		pDialog.setCancelable(false);
		pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						listener.CallBack(null, isOffline);
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

		if (isOffline) {
			placaRawFormat=(DatabaseCreator.getPrepopulatedDBOpenHelper(context)).getPlacaData(placa);
			
			(DatabaseCreator.getPlacaSearchDatabaseAdapter(context))
			.insertPlacaSearchData(placaRawFormat);
		} else {

			try {
				jsonText = AppObject.getHttpClient().executeHttpGet(URL+placa);

				createPlacaRawData = new CreatePlacaRawDataFromJson(jsonText,
						context);
				placaRawFormat = createPlacaRawData.getPlacaRawFormat();
				(DatabaseCreator.getPlacaSearchDatabaseAdapter(context))
						.insertPlacaSearchData(placaRawFormat);

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		listener.CallBack(placaRawFormat, isOffline);
		super.onPostExecute(result);
	}
}