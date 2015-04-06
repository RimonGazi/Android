package net.sistransitomobile.database;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import android.content.Context;

public class PlacaSearchDatabaseHelper extends SQLiteOpenHelper {
	
	
	public static final String DATABASE_NAME_VEICULOS = "database_veiculos.db";
	public static final String TABLE_NAME = "veiculos";
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
	private final String TABLE_SQL = "CREATE TABLE [veiculos] (_id integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,placa text,modelo text,cor text,tipo text,ano_licenciamento text,data_licenciamento text,status_licenciamento text,ipva text,seguro text,status text,infracoes text,restricoes text,date text)";

	public PlacaSearchDatabaseHelper(Context context) {
		super(context, DATABASE_NAME_VEICULOS, null,
				DatabaseCreator.VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}
