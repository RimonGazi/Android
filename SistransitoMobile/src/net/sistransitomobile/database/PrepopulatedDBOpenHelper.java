package net.sistransitomobile.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;

import net.isstransitomobile.autoEquipmentEntry.AutoEquipmentEntry;
import net.sistransitomobile.placa.data.PlacaRawFormat;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PrepopulatedDBOpenHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "sitransitoctb.db";
	public static String DB_PATH;
	private SQLiteDatabase database;
	private Context context;

	// off_veiculos

	public static final String TABLE_NAME = "off_veiculos";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_PLACA = "placa";
	public static final String COLUMN_MODELO = "modelo";
	public static final String COLUMN_COR = "cor";
	public static final String COLUMN_TIPO = "tipo";
	public static final String COLUMN_ANO_LICENCIAMENTO = "ano_licenciamento";
	public static final String COLUMN_DATA_LICENCIAMENTO = "data_licenciamento";
	public static final String COLUMN_STATUS_LICENCIAMENTO = "status_licenciamento";
	public static final String COLUMN_IPVA = "ipva";
	public static final String COLUMN_SEGURO = "seguro";
	public static final String COLUMN_STATUS = "status";
	public static final String COLUMN_INFRACOES = "infracoes";
	public static final String COLUMN_RESTRICOES = "restricoes";
	public static final String COLUMN_DATE = "date";

	// infracoes

	public static final String TABLE_NAME_INFRACOES = "enquadramento";
	public static final String INFRACOES_INFRACOES = "infracao";
	public static final String INFRACOES_ENQUADRA = "enquadramento";
	public static final String INFRACOES_DESDOB = "desdobramento";
	public static final String INFRACOES_ART = "artigo";
	public static final String INFERACOES_OBSERVACAO = "observacao";

	// municipios
	public static final String TABLE_NAME_MUNICIPIOS = "municipios";
	public static final String MUNICIPIOS_MUNICIPIOS = "municipio";
	public static final String MUNICIPIOS_COD = "cod";
	public static final String MUNICIPIOS_UF = "uf";

	// AutoEquipamentoEntry
	public static final String AutoEquipamentoEntry_TABLE_NAME = "auto_equipamento";
	public static final String AutoEquipamentoEntry_COLUMN_DESCRICAO = "descricao";
	public static final String AutoEquipamentoEntry_COLUMN_MARCA = "marca";
	public static final String AutoEquipamentoEntry_COLUMN_MODELO = "modelo";
	public static final String AutoEquipamentoEntry_COLUMN_VALIDADE = "validade";

	public PrepopulatedDBOpenHelper(Context context) {
		super(context, DB_NAME, null, 1);
		this.context = context;
		DB_PATH = context.getDatabasePath(DB_NAME).toString();
		this.database = openDatabase();

	}

	public SQLiteDatabase getDatabase() {
		return this.database;
	}

	public SQLiteDatabase openDatabase() {
		String path = DB_PATH + DB_NAME;
		if (database == null) {
			createDatabase();
			database = SQLiteDatabase.openDatabase(path, null,
					SQLiteDatabase.OPEN_READWRITE);
		}
		return database;
	}

	private void createDatabase() {
		boolean dbExists = checkDB();
		if (!dbExists) {
			this.getReadableDatabase();
			Log.e(getClass().getName(),
					"Database doesn't exist. Copying database from assets...");
			copyDatabase();
		} else {
			Log.e(getClass().getName(), "Database already exists");
		}
	}

	private void copyDatabase() {
		try {
			InputStream dbInputStream = context.getAssets().open(DB_NAME);
			String path = DB_PATH + DB_NAME;
			OutputStream dbOutputStream = new FileOutputStream(path);
			byte[] buffer = new byte[4096];
			int readCount = 0;
			while ((readCount = dbInputStream.read(buffer)) > 0) {
				dbOutputStream.write(buffer, 0, readCount);
			}

			dbInputStream.close();
			dbOutputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean checkDB() {
		String path = DB_PATH + DB_NAME;
		File file = new File(path);
		if (file.exists()) {
			Log.e(getClass().getName(), "Database already exists");
			return true;
		}
		Log.e(getClass().getName(), "Database does not exists");
		return false;
	}

	public synchronized void close() {
		if (this.database != null) {
			this.database.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	// autocomplete infracao
	public Cursor getInfracaoCoursor() {
		Cursor myCursor = this.database.query(TABLE_NAME_INFRACOES, null, null,
				null, null, null, null);
		myCursor.moveToFirst();
		return myCursor;

	}

	// autocomplete municipio
	public Cursor getMunicipioCursor() {
		Cursor myCursor = this.database.query(TABLE_NAME_MUNICIPIOS, null,
				null, null, null, null, null);
		myCursor.moveToFirst();
		return myCursor;
	}

	// off line placa
	@SuppressLint("DefaultLocale")
	public PlacaRawFormat getPlacaData(String placa) {

		PlacaRawFormat placaRawFormat = new PlacaRawFormat(context);
		Cursor myCursor = database
				.query(TABLE_NAME, null, COLUMN_PLACA + "=?",
						new String[] { placa.toLowerCase(Locale.US) }, null,
						null, null);
		if (myCursor.getCount() <= 0) {
			myCursor = database.query(TABLE_NAME, null, COLUMN_PLACA + "=?",
					new String[] { placa.toUpperCase(Locale.US) }, null, null,
					null);
		}

		if (myCursor.getCount() > 0) {
			myCursor.moveToFirst();
			placaRawFormat.setPLATE(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_PLACA)));

			placaRawFormat.setMODEL(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_MODELO)));

			placaRawFormat.setCOLOR(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_COR)));

			placaRawFormat.setTYPE(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_TIPO)));

			placaRawFormat.setLICENSE_YEAR(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_ANO_LICENCIAMENTO)));

			placaRawFormat.setLICENSE_DATE(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_DATA_LICENCIAMENTO)));

			placaRawFormat.setLICENSE_STATUS(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_STATUS_LICENCIAMENTO)));

			placaRawFormat.setIPVA(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_IPVA)));

			placaRawFormat.setINSURANCE(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_SEGURO)));

			placaRawFormat.setINFRACTIONS(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_INFRACOES)));
			placaRawFormat.setRESTRICTIONS(myCursor.getString(myCursor
					.getColumnIndex(COLUMN_RESTRICOES)));
			myCursor.close();
		} else {
			myCursor.close();
			return null;
		}

		return placaRawFormat;
	}

	// AutoEquipamentoEntry

	public Cursor getAutoEquipamentoEntryCoursor() {
		Cursor myCursor = this.database.query(AutoEquipamentoEntry_TABLE_NAME,
				null, null, null, null, null, null);
		myCursor.moveToFirst();
		
		Log.d("bbbbbbbbbbbbbbbbbbbb", myCursor.getCount()+"v");
		return myCursor;
	}

	public void setAutoEquipamentoEntryCoursor(
			ArrayList<AutoEquipmentEntry> entries) {
		
		this.database.delete(AutoEquipamentoEntry_TABLE_NAME, null, null);
		
		AutoEquipmentEntry autoenEntry;

		if (entries != null) {

			for (int i = 0; i < entries.size(); i++) {
				ContentValues values = new ContentValues();
				autoenEntry = entries.get(i);
				values.put(AutoEquipamentoEntry_COLUMN_DESCRICAO,
						autoenEntry.getDESCRICAO());
				values.put(AutoEquipamentoEntry_COLUMN_MARCA,
						autoenEntry.getMARCA());
				values.put(AutoEquipamentoEntry_COLUMN_MODELO,
						autoenEntry.getMODELO());
				values.put(AutoEquipamentoEntry_COLUMN_VALIDADE,
						autoenEntry.getVALIDADE());
				long a = this.database.insert(AutoEquipamentoEntry_TABLE_NAME,
						null, values);
				Log.d("ccccccccccccccccccccccccc", a + " d");
			}
		}
	}

}
