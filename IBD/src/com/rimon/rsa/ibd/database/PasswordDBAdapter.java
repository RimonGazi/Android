package com.rimon.rsa.ibd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rimon.rsa.ibd.main.ConstantValues;

public class PasswordDBAdapter {
	private PasswordDBHelper passDBHelper;
	private Context context;
	private SQLiteDatabase db;

	public PasswordDBAdapter(Context context) {
		this.context = context;
		passDBHelper = new PasswordDBHelper(this.context);
		checkTable();

	}

	private void checkTable() {
		PasswordDBHelper table = new PasswordDBHelper(this.context);
		SQLiteDatabase db = table.getWritableDatabase();

		Cursor mcursor = db.rawQuery("SELECT count(*) FROM "
				+ PasswordDBHelper.TABLE_NAME_PASSWORD, null);
		mcursor.moveToFirst();
		int icount = mcursor.getInt(0);
		if (icount > 0) {
			return;
		} else {

			ContentValues values = new ContentValues();
			values.put(PasswordDBHelper.ID_FIELD, 1);
			values.put(PasswordDBHelper.PASSWORD, "simon");
			values.put(PasswordDBHelper.INITIAL_QUESTION,
					ConstantValues.initial_question_status_false);
			db.insert(PasswordDBHelper.TABLE_NAME_PASSWORD, null, values);
			db.close();

		}

	}

	public void openWriteableDatabase() {
		db = passDBHelper.getWritableDatabase();
	}

	public void openReadableDatabase() {
		db = passDBHelper.getReadableDatabase();
	}

	public void close() {
		db.close();
	}

	// public long insertInformation(String newPassword) {
	// ContentValues values = new ContentValues();
	// values.put(PasswordDBHelper.ID_FIELD, 1);
	// values.put(PasswordDBHelper.PASSWORD, newPassword);
	//
	// long inserted = db.insert(PasswordDBHelper.TABLE_NAME_PASSWORD, null,
	// values);
	//
	// Log.d("inser", inserted + "");
	// return inserted;
	//
	// }

	public Cursor getCursor() {
		Cursor myCursor = db.query(PasswordDBHelper.TABLE_NAME_PASSWORD, null,
				null, null, null, null, null);
		myCursor.moveToFirst();
		return myCursor;
	}

	public String getPassword() {

		Cursor myCursor = db.query(PasswordDBHelper.TABLE_NAME_PASSWORD, null,
				null, null, null, null, null);
		myCursor.moveToFirst();
		return myCursor.getString(myCursor
				.getColumnIndex(PasswordDBHelper.PASSWORD));
	}

	public String getQuestionStatus() {

		Cursor myCursor = db.query(PasswordDBHelper.TABLE_NAME_PASSWORD, null,
				null, null, null, null, null);
		myCursor.moveToFirst();
		return myCursor.getString(myCursor
				.getColumnIndex(PasswordDBHelper.INITIAL_QUESTION));
	}

	public long setPassword(String pass) {
		ContentValues values = new ContentValues();
		values.put(PasswordDBHelper.PASSWORD, pass);

		return db.update(PasswordDBHelper.TABLE_NAME_PASSWORD, values,
				PasswordDBHelper.ID_FIELD + "= ? ", new String[] { "1" });

		// Toast.makeText(context, "Password changed",
		// Toast.LENGTH_LONG).show();

	}

	public long setInitialQuestionStatus(String status) {
		ContentValues values = new ContentValues();
		values.put(PasswordDBHelper.INITIAL_QUESTION, status);
		return db.update(PasswordDBHelper.TABLE_NAME_PASSWORD, values,
				PasswordDBHelper.ID_FIELD + "= ? ", new String[] { "1" });

	}

}