package net.sistransitomobile.database;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import android.content.Context;

public class UserioDatabseHelpler extends SQLiteOpenHelper {

	public UserioDatabseHelpler(Context context) {
		super(context, DATABASE_NAME_USUARIO, null,
				DatabaseCreator.VERSION);
	}

	public static final String DATABASE_NAME_USUARIO= "database_usuario.db";
	public static final String COLUME_ID = "_id";
	public static final String USUARIO_TABLE_NAME = "usuario";
	public static final String COLUMN_NOME = "nome";
	public static final String COLUMN_MATRICULA = "matricula";
	public static final String COLUMN_NOME_ORGAO = "nome_orgao";
	public static final String COLUMN_CODIGO_ORGAO = "codigo_orgao";
	public static final String TABLE_SQl = "CREATE TABLE [usuario] (_id integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,nome text,matricula text,nome_orgao text,codigo_orgao text)";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_SQl);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
