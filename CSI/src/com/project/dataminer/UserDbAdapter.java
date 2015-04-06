package com.project.dataminer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDbAdapter {

	private static final String DATABASE_TABLE = "user";
	private static final String KEY_ROWID = "_id";
	private Context context;
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;

	public UserDbAdapter(Context context) {
		this.context = context;
	}

	public UserDbAdapter open() throws SQLException {
		dbHelper = new MySQLiteHelper(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	public long AddData(String id, String name, String lname, String dob,
			String nname, int done, String addr1, String addr2, String addr3,
			String gender) {
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("lname", lname);
		values.put("dob", dob);
		values.put("nname", nname);
		values.put("done", done);
		values.put("cid", id);
		values.put("addr1", addr1);
		values.put("addr2", addr2);
		values.put("addr3", addr3);
		values.put(MySQLiteHelper.UPDATE_STATUS_USER, "no");
		values.put(MySQLiteHelper.GENDER, gender);
		return database.insert(DATABASE_TABLE, null, values);
	}

	public Cursor fetchAll() {
		Cursor mCursor = database.query(DATABASE_TABLE, new String[] {
				KEY_ROWID, "name", "lname", "dob", "nname", "done", "cid",
				"addr1", "addr2", "addr3" }, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public Cursor getallUpdatedData() {

		Cursor cursor = database.query(DATABASE_TABLE, new String[] {
				KEY_ROWID, "name", "lname", "dob", "nname", "done", "cid",
				"addr1", "addr2", "addr3", MySQLiteHelper.UPDATE_STATUS_USER,
				MySQLiteHelper.GENDER }, MySQLiteHelper.UPDATE_STATUS_USER
				+ " =?", new String[] { "no" }, null, null, null);

		return cursor;

	}

	public Cursor getid(String id) {
		Cursor c = database.rawQuery("SELECT * FROM user WHERE _id =?",
				new String[] { "" + id });
		c.moveToFirst();
		return c;
	}

	public long update(ContentValues c, String id) {
		return database.update(DATABASE_TABLE, c, "_id=?", new String[] { id });
	}

	// public Cursor updateData(String[] whereString) {
	//
	// Cursor c = database.query(DATABASE_TABLE, new String[] { KEY_ROWID,
	// "name", "lname", "dob", "nname", "done", "cid", "addr1",
	// "addr2", "addr3" }, KEY_ROWID + "!=?", whereString, null, null,
	// null, null);
	// return c;
	// }

	public void updateUpdateStatusUser(String id, String status) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.UPDATE_STATUS_USER, status);
		database.update(DATABASE_TABLE, values, "_id=?", new String[] { id });
		// Log.d("LLLLLLL", l + "");

	}

}
