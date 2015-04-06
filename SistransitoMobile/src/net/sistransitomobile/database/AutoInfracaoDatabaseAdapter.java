package net.sistransitomobile.database;

import net.sistransito.timeandime.TimeAndIme;
import net.sistransitomobile.autode.AutoDeData;
import net.sqlcipher.database.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class AutoInfracaoDatabaseAdapter {
	private TimeAndIme ime;
	private SQLiteDatabase database;
	private AutoInfracaoDatabaseHelper databaseHelper;

	public AutoInfracaoDatabaseAdapter(Context context) {
		ime = new TimeAndIme(context);
		databaseHelper = new AutoInfracaoDatabaseHelper(context);
		database = databaseHelper.getReadableDatabase(ime.getIME());
	}

	public AutoDeData getAutodeDataFromPlaca(String placa) {

		Cursor myCursor = this.database.query(
				AutoInfracaoDatabaseHelper.TABLE_NAME, null,
				AutoInfracaoDatabaseHelper.PLATE + "=?", new String[] { placa
						+ "" }, null, null, null);

		if (myCursor.getCount() > 0) {
			AutoDeData autode_data = new AutoDeData();
			myCursor.moveToFirst();
			autode_data.setAutoDeDataFromCursor(myCursor);
			myCursor.close();
			return autode_data;
		} else {
			myCursor.close();
			return null;
		}
	}

	public boolean isSamePlacaExit(String placa) {
		Cursor myCursor = this.database.query(
				AutoInfracaoDatabaseHelper.TABLE_NAME, null,
				AutoInfracaoDatabaseHelper.PLATE + "=?", new String[] { placa
						+ "" }, null, null, null);
		if (myCursor.getCount() > 0) {
			myCursor.close();
			return true;
		} else {
			myCursor.close();
			return false;
		}
	}

	public void close() {
		database.close();
	}

	public boolean setData(AutoDeData data) {
		ContentValues values = new ContentValues();
		values.put(AutoInfracaoDatabaseHelper.PLATE, data.getPlate());
		values.put(AutoInfracaoDatabaseHelper.MODEL, data.getModel());
		values.put(AutoInfracaoDatabaseHelper.COR_DO_VEICULO,
				data.getCor_do_veiculo());
		values.put(AutoInfracaoDatabaseHelper.ESPECIE, data.getEspecie());
		values.put(AutoInfracaoDatabaseHelper.CATEGORIA, data.getCategoria());
		values.put(AutoInfracaoDatabaseHelper.IDENTIFICATION_DO_CONDUCTOR,
				data.getIdentification_do_conductor());
		values.put(AutoInfracaoDatabaseHelper.CNH_PPD, data.getCnh_ppd());
		values.put(AutoInfracaoDatabaseHelper.CPF, data.getCpf());
		values.put(AutoInfracaoDatabaseHelper.INFRACAO, data.getInfracao());
		values.put(AutoInfracaoDatabaseHelper.ENQUADRA, data.getEnquadra());
		values.put(AutoInfracaoDatabaseHelper.DESDOB, data.getDesdob());
		values.put(AutoInfracaoDatabaseHelper.ART, data.getArt());
		values.put(AutoInfracaoDatabaseHelper.CODIGO_DO_MUNICIPIO,
				data.getCodigo_do_municipio());
		values.put(AutoInfracaoDatabaseHelper.MUNICIPIO, data.getMunicipio());
		values.put(AutoInfracaoDatabaseHelper.UF, data.getUf());
		values.put(AutoInfracaoDatabaseHelper.LOCAL, data.getLocal());
		values.put(AutoInfracaoDatabaseHelper.DATA, data.getData());
		values.put(AutoInfracaoDatabaseHelper.HORA, data.getHora());
		values.put(AutoInfracaoDatabaseHelper.DESCRICAO, data.getDescricao());
		values.put(AutoInfracaoDatabaseHelper.MARCA, data.getMarca());
		values.put(AutoInfracaoDatabaseHelper.MODELO, data.getModelo());
		values.put(AutoInfracaoDatabaseHelper.NUMERO_DE_SERIE,
				data.getNumero_de_serie());
		values.put(AutoInfracaoDatabaseHelper.MEDICO_REALIZADA,
				data.getMedico_realizada());
		values.put(AutoInfracaoDatabaseHelper.VALOR_CONSIDERADA,
				data.getValor_considerada());
		values.put(AutoInfracaoDatabaseHelper.N_DA_AMOSTRA,
				data.getN_da_amostra());
		values.put(AutoInfracaoDatabaseHelper.CLRV, data.getClrv());
		values.put(AutoInfracaoDatabaseHelper.CNH, data.getCnh());
		values.put(AutoInfracaoDatabaseHelper.PPD, data.getPpd());
		values.put(AutoInfracaoDatabaseHelper.RETENCAO, data.getRetencao());
		values.put(AutoInfracaoDatabaseHelper.REMOCAO, data.getRemocao());
		values.put(AutoInfracaoDatabaseHelper.OBSERVACAO, data.getObservacao());
		values.put(AutoInfracaoDatabaseHelper.IDETIFICACAO_EMBRACADOR,
				data.getIdetificacao_embracador());
		values.put(AutoInfracaoDatabaseHelper.CNPJ_CPF_EMBRACADOR,
				data.getCnpj_cpf_embracador());
		values.put(AutoInfracaoDatabaseHelper.IDENTIFICACAO_DO_TRANSPORTADFOR,
				data.getIdentificacao_do_transportadfor());
		values.put(AutoInfracaoDatabaseHelper.CNPJ_CPF_TRANSPORTADFOR,
				data.getCnpj_cpf_transportadfor());
		values.put(AutoInfracaoDatabaseHelper.NUMERO_AUTO,
				data.getNumero_auto());
		long insert = this.database.insert(
				AutoInfracaoDatabaseHelper.TABLE_NAME, null, values);
		return insert > 0;
	}

	public Cursor getAllAutoDeCursor() {
		Cursor myCursor = database.query(AutoInfracaoDatabaseHelper.TABLE_NAME,
				null, null, null, null, null,
				AutoInfracaoDatabaseHelper.COLUMN_ID + " DESC");
		return myCursor;

	}
}
