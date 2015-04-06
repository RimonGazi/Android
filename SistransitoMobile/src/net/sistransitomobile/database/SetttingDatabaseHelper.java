package net.sistransitomobile.database;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import android.content.Context;

public class SetttingDatabaseHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME_SETTING = "database_setting.db";
	// public static final int VERSION = 1;
	public static final String SETTING_TABLE_NAME = "setting";
	public static final String SETTING_ID_FILED = "_id";
	public static final String SETTING_AUTO_BACKUP = "auto_bacckup";
	public static final String SETTING_LANGUAGE = "language";
	public static final String SETTING_VIBRATOR = "vibrator";
	public static final String SETTING_RINGTONE = "ringtone";
	public static final String SETTING_REMEMBER = "remember_password";
	public static final String SETTING_PASSWORD_STATE = "password_state";
	public static final String SETTING_FONT = "font";
	public final String SETTING_TABLE_SQL = "CREATE TABLE [setting] (_id integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,auto_bacckup text DEFAULT false,language text,vibrator text DEFAULT true,ringtone text DEFAULT true,remember_password text DEFAULT false,password_state text DEFAULT false,font text DEFAULT 1)";

	public SetttingDatabaseHelper(Context context) {
		super(context, DATABASE_NAME_SETTING, null, DatabaseCreator.VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SETTING_TABLE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
