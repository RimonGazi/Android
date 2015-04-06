package net.isstransitomobile.autoEquipmentEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class AutoEquipmentEntry {
	private String DESCRICAO, MARCA, MODELO, VALIDADE;

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public String getMARCA() {
		return MARCA;
	}

	public String getMODELO() {
		return MODELO;
	}

	public String getVALIDADE() {
		return VALIDADE;
	}

	public AutoEquipmentEntry(String dESCRICAO, String mARCA, String mODELO,
			String vALIDADE) {
		super();
		DESCRICAO = dESCRICAO;
		MARCA = mARCA;
		MODELO = mODELO;
		VALIDADE = vALIDADE;
	}

	

}
