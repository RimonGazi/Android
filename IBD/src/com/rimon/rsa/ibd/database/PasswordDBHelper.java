package com.rimon.rsa.ibd.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PasswordDBHelper extends SQLiteOpenHelper {
	public static final String DB_NAME = "ibd.db";
	public static final int VERSION = 1;

	public static final String TABLE_NAME_PASSWORD = "ibd_password";
	public static final String ID_FIELD = "_id";
	public static final String PASSWORD = "password";
	public static final String INITIAL_QUESTION = "initial_question";

	public static final String PASSWORD_TABLE_SQL = "CREATE TABLE "
			+ TABLE_NAME_PASSWORD + " ( " + ID_FIELD + " INTEGER PRIMARY KEY, "
			+ INITIAL_QUESTION + " TEXT, " + PASSWORD + " TEXT )";

	public PasswordDBHelper(Context context) {
		super(context, TABLE_NAME_PASSWORD, null, VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("TABLE SQL", PASSWORD_TABLE_SQL);
		db.execSQL(PASSWORD_TABLE_SQL);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// UPGRADE LOGIC

	}
}
