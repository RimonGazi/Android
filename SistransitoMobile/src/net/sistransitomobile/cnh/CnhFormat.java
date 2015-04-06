package net.sistransitomobile.cnh;

import net.sistransitomobile.main.R;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class CnhFormat {
	private Context context;

	private String result_final;
	private boolean warrningStatus;
	private String nome = "", data_nascimento = "", registro = "", uf = "",
			validade = "", pontos = "", obs = "";

	public CnhFormat(String cnh_result, Context context) {
		setCnhFormat(cnh_result);
		this.context = context;

	}

	private void setCnhFormat(String cnh_result) {
		int success = 10;
		if (cnh_result.equals("") || (cnh_result == null)) {
			result_final = context.getResources().getString(
					R.string.no_result_found);

		} else {
			try {
				JSONObject jsonObject2 = new JSONObject(cnh_result);
				success = jsonObject2.getInt("success");

				if (success == 1) {
					nome = jsonObject2.getString("nome");
					data_nascimento = (jsonObject2.getString("data_nascimento"));
					registro = jsonObject2.getString("registro");
					uf = jsonObject2.getString("uf");
					validade = jsonObject2.getString("validade");
					pontos = jsonObject2.getString("pontos");
					obs = jsonObject2.getString("obs");
					result_final = "\nNome : " + nome + "\nData nascimento : "
							+ data_nascimento + "\nRegistro : " + registro
							+ "\nUF : " + uf + "\nValidade : " + validade
							+ "\nPontos : " + pontos + "\nOBS : " + obs + "\n";

					if (obs.equalsIgnoreCase("Ativa")) {
						warrningStatus = false;

					} else {
						warrningStatus = true;
					}

				} else if (success != 1) {
					result_final = "Nenhum dado retornado";
					warrningStatus = false;
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}

	public String getCnhFormat() {
		return result_final;
	}

	public SpannableString getCnhFormatSpanable() {
		SpannableString spannableresult = new SpannableString(result_final);

		if (warrningStatus) {
			int position = result_final.indexOf(obs);
			spannableresult.setSpan(new ForegroundColorSpan(Color.RED),
					position, (position + obs.length()), 0);
		}
		return spannableresult;
	}

	public boolean getWarrningStatus() {
		return warrningStatus;
	}

	private boolean getDatabseVibrate() {
		return false;
	}

	private boolean getDatabseRingtone() {
		return false;
	}

	public void setWarrning() {
		if (getWarrningStatus()) {
			if (getDatabseVibrate()) {
				// vibrate
			}
			if (getDatabseRingtone()) {
				// ringj
			}
		}

	}
}
