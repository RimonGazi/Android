package net.sistransitomobile.login;

import org.json.JSONException;
import org.json.JSONObject;

public class LogJsonFormat {

	// "success":1,
	// "nome":"Gazi",
	// "matricula":"57211200",
	// "nome_orgao":"Detran",
	// "codigo_orgao":"41100",
	// "status":"1"

	private String nome, matricula, nome_orgao, codigo_orgao, status;
	private boolean IsSuccess = false;

	public LogJsonFormat(String json) {

		setJsonFormat(json);
	}

	private void setJsonFormat(String json) {
		JSONObject jsonObject = null;

		int success = 10;
		final int SUCCESS = 1;

		try {
			jsonObject = new JSONObject(json);
			success = jsonObject.getInt("success");

			if (success == SUCCESS) {
				IsSuccess = true;
				nome = jsonObject.getString("nome");
				matricula = jsonObject.getString("matricula");
				nome_orgao = jsonObject.getString("nome_orgao");

				codigo_orgao = jsonObject.getString("codigo_orgao");
				status = jsonObject.getString("status");

			} else {
				IsSuccess = false;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome_orgao() {
		return nome_orgao;
	}

	public String getCodigo_orgao() {
		return codigo_orgao;
	}

	public String getStatus() {
		return status;
	}

	public boolean isIsSuccess() {
		return IsSuccess;
	}
}
