package net.sistransitomobile.placa.data;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class CreatePlacaRawDataFromJson {
	private PlacaRawFormat placaRawFormat;

	public CreatePlacaRawDataFromJson(String data, Context context) {
		setPlacaRawFormat(data);
		placaRawFormat = new PlacaRawFormat(context);
		setPlacaRawFormat(data);
	}

	public PlacaRawFormat getPlacaRawFormat() {
		return placaRawFormat;
	}

	public void setPlacaRawFormat(String data) {
		JSONObject jsonObject;

		int success = 10;
		final int SUCCESS = 1;

		try {
			jsonObject = new JSONObject(data);
			success = jsonObject.getInt("success");

			if (success == SUCCESS) {

				try {

					placaRawFormat.setPLATE(jsonObject.getString("placa"));

					placaRawFormat.setMODEL(jsonObject.getString("modelo"));

					placaRawFormat.setCOLOR(jsonObject.getString("cor"));

					placaRawFormat.setTYPE(jsonObject.getString("tipo"));

					placaRawFormat.setLICENSE_YEAR(jsonObject
							.getString("ano_licenciamento"));

					placaRawFormat.setLICENSE_DATE(jsonObject
							.getString("data_licenciamento"));

					placaRawFormat.setLICENSE_STATUS(jsonObject
							.getString("status_licenciamento"));

					placaRawFormat.setIPVA(jsonObject.getString("ipva"));

					placaRawFormat.setINSURANCE(jsonObject.getString("seguro"));

					placaRawFormat.setINFRACTIONS(jsonObject
							.getString("infracoes"));
					placaRawFormat.setRESTRICTIONS(jsonObject
							.getString("restricoes"));

				} catch (Exception e) {

				}

			} else {
				placaRawFormat = null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
