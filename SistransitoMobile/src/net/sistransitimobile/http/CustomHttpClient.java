package net.sistransitimobile.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.util.Log;

public class CustomHttpClient {
	// private final String POST_URL = "http://sistransito.net/api/placa.php";
	public final String NORMAL = "NORMAL";
	public final int HTTP_TIMEOUT = 30 * 1000;
	private HttpClient mHttpClient;
	public String plate, model, cor;

	private HttpClient getHttpClient() {
		if (mHttpClient == null) {
			mHttpClient = new DefaultHttpClient();
			final HttpParams params = mHttpClient.getParams();
			HttpConnectionParams.setConnectionTimeout(params, HTTP_TIMEOUT);
			HttpConnectionParams.setSoTimeout(params, HTTP_TIMEOUT);
			ConnManagerParams.setTimeout(params, HTTP_TIMEOUT);
		}
		return mHttpClient;
	}

	// public PlacaRawFormat executeHttpPost(Context context, String
	// placaString) {
	//
	// ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
	// postParameters.add(new BasicNameValuePair("plateNumber", placaString));
	//
	// String jsonText = null;
	//
	// PlacaRawFormat placaRawFormat = null;
	// CreatePlacaRawDataFromJson createPlacaRawData;
	// try {
	//
	// HttpClient client = getHttpClient();
	//
	// HttpPost request = new HttpPost(POST_URL);
	//
	// UrlEncodedFormEntity formEntity;
	//
	// formEntity = new UrlEncodedFormEntity(
	//
	// postParameters);
	//
	// request.setEntity(formEntity);
	//
	// HttpResponse response = client.execute(request);
	//
	// HttpEntity entity = response.getEntity();
	// jsonText = EntityUtils.toString(entity, HTTP.UTF_8);
	// Log.d("jsontext............................	", jsonText.toString()
	// + "JSON");
	//
	// if (jsonText != null && !((jsonText.trim()).equals(""))) {
	// createPlacaRawData = new CreatePlacaRawDataFromJson(jsonText,
	// context);
	// placaRawFormat = createPlacaRawData.getPlacaRawFormat();
	// return placaRawFormat;
	// }
	// } catch (UnsupportedEncodingException e) {
	//
	// e.printStackTrace();
	// } catch (ClientProtocolException e) {
	//
	// e.printStackTrace();
	// } catch (IOException e) {
	//
	// e.printStackTrace();
	// }
	//
	// return placaRawFormat;
	//
	// }

	public String executeHttpPost(Context context,
			ArrayList<NameValuePair> postParameters, String url) {
		String jsonText = "";

		try {

			HttpClient client = getHttpClient();

			HttpPost request = new HttpPost(url);

			UrlEncodedFormEntity formEntity;

			formEntity = new UrlEncodedFormEntity(

			postParameters);

			request.setEntity(formEntity);

			HttpResponse response = client.execute(request);

			HttpEntity entity = response.getEntity();
			jsonText = EntityUtils.toString(entity, HTTP.UTF_8);
			Log.d("jsontext............................	", jsonText.toString()
					+ "JSON");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return jsonText;

	}

	public String executeHttpGet(String url) throws Exception {
		String jsonText = null;

		try {
			HttpClient client = getHttpClient();

			HttpGet request = new HttpGet();

			request.setURI(new URI(url));

			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			jsonText = EntityUtils.toString(entity, HTTP.UTF_8);
			Log.d("jsontext............................	", jsonText.toString()
					+ "JSON");

		} catch (Exception e) {

		}
		return jsonText;
	}

}
