package net.sistransitomobile.database;

import net.sistransito.timeandime.TimeAndIme;
import net.sistransitomobile.login.LogJsonFormat;
import net.sqlcipher.database.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class UserioDatabseAdapter {
	private TimeAndIme ime;
	private UserioDatabseHelpler databseHelplerUserio;
	private SQLiteDatabase database;

	public UserioDatabseAdapter(Context context) {
		databseHelplerUserio = new UserioDatabseHelpler(context);
		ime = new TimeAndIme(context);
		database = databseHelplerUserio.getWritableDatabase(ime.getIME());
		checkTable();
	}

	public synchronized void close() {
		database.close();
	}

	private void checkTable() {

		Cursor mcursor = database.rawQuery("SELECT count(*) FROM "
				+ UserioDatabseHelpler.USUARIO_TABLE_NAME, null);

		mcursor.moveToFirst();
		int icount = mcursor.getInt(0);
		if (icount > 0) {
			mcursor.close();
			return;
		} else {
			ContentValues values = new ContentValues();
			values.put(UserioDatabseHelpler.COLUME_ID, "1");
			values.put(UserioDatabseHelpler.COLUMN_NOME, "1");
			values.put(UserioDatabseHelpler.COLUMN_MATRICULA, "1");
			values.put(UserioDatabseHelpler.COLUMN_NOME_ORGAO, "1");
			values.put(UserioDatabseHelpler.COLUMN_CODIGO_ORGAO, "1");
			database.insert(UserioDatabseHelpler.USUARIO_TABLE_NAME, null,
					values);
			mcursor.close();
		}
	}

	public boolean setAllData(LogJsonFormat logJsonFormat) {
		ContentValues values = new ContentValues();
		values.put(UserioDatabseHelpler.COLUMN_NOME, logJsonFormat.getNome());
		values.put(UserioDatabseHelpler.COLUMN_NOME_ORGAO,
				logJsonFormat.getNome_orgao());
		values.put(UserioDatabseHelpler.COLUMN_MATRICULA,
				logJsonFormat.getMatricula());
		values.put(UserioDatabseHelpler.COLUMN_CODIGO_ORGAO,
				logJsonFormat.getCodigo_orgao());

		int check = database.update(UserioDatabseHelpler.USUARIO_TABLE_NAME,
				values, UserioDatabseHelpler.COLUME_ID + "= ? ",
				new String[] { "1" });

		return check > 1;
	}
	
}
//
// public String getNome() {
// Cursor cursor = database.query(DatabseHelplerUserio.TABLE_NAME, null,
// null, null, null, null, null);
// cursor.moveToFirst();
// return cursor.getString(cursor
// .getColumnIndex(DatabseHelplerUserio.COLUMN_NOME));
// }
//
// public boolean setNome(String nome) {
// ContentValues values = new ContentValues();
// values.put(DatabseHelplerUserio.COLUMN_NOME, nome);
// int check = database.update(DatabseHelplerUserio.TABLE_NAME, values,
// DatabaseHelperSettting.SETTING_ID_FILED + "= ? ",
// new String[] { "1" });
//
// return check > 1;
// }
//
// public String getMatricula() {
// Cursor cursor = database.query(DatabseHelplerUserio.TABLE_NAME, null,
// null, null, null, null, null);
// cursor.moveToFirst();
// return cursor.getString(cursor
// .getColumnIndex(DatabseHelplerUserio.COLUMN_MATRICULA));
// }
//
// public boolean setMatricula(String matricula) {
// ContentValues values = new ContentValues();
// values.put(DatabseHelplerUserio.COLUMN_NOME, matricula);
// int check = database.update(DatabseHelplerUserio.COLUMN_MATRICULA,
// values, DatabaseHelperSettting.SETTING_ID_FILED + "= ? ",
// new String[] { "1" });
//
// return check > 1;
// }
//
// public String getNome_orgao() {
// Cursor cursor = database.query(DatabseHelplerUserio.TABLE_NAME, null,
// null, null, null, null, null);
// cursor.moveToFirst();
// return cursor.getString(cursor
// .getColumnIndex(DatabseHelplerUserio.COLUMN_NOME_ORGAO));
// }
//
// public boolean setNome_orgao(String nome_orgao) {
// ContentValues values = new ContentValues();
// values.put(DatabseHelplerUserio.COLUMN_NOME, nome_orgao);
// int check = database.update(DatabseHelplerUserio.COLUMN_MATRICULA,
// values, DatabaseHelperSettting.SETTING_ID_FILED + "= ? ",
// new String[] { "1" });
//
// return check > 1;
// }
//
// public String getCodigo_orgao() {
// Cursor cursor = database.query(DatabseHelplerUserio.TABLE_NAME, null,
// null, null, null, null, null);
// cursor.moveToFirst();
// return cursor.getString(cursor
// .getColumnIndex(DatabseHelplerUserio.COLUMN_NOME_ORGAO));
// }
//
// public boolean setCodigo_orgao(String codigo_orgao) {
// ContentValues values = new ContentValues();
// values.put(DatabseHelplerUserio.COLUMN_NOME, codigo_orgao);
// int check = database.update(DatabseHelplerUserio.COLUMN_MATRICULA,
// values, DatabaseHelperSettting.SETTING_ID_FILED + "= ? ",
// new String[] { "1" });
//
// return check > 1;
// }

