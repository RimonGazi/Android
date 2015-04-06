package com.project.dataminer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataDbAdapter {
	private static final String DATABASE_TABLE = "data";
	private Context context;
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;

	public DataDbAdapter(Context context) {
		this.context = context;
	}

	public DataDbAdapter open() throws SQLException {
		dbHelper = new MySQLiteHelper(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	public long AddData(int id, int no, int ans11, int ans12, int ans13,
			int ans21, int ans22, int ans23, int ans24, int ans25, int ans26,
			int ans31, int ans32, int ans33, int ans34, int ans35, int ans41,
			int ans42, int ans43, int ans51, int ans52, int ans53, int ans54,
			int ans61, int ans62, int saved, String comment, String cid,
			String job, String id_data) {
		ContentValues values = new ContentValues();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		values.put("_id", id);
		values.put("_no", no);
		values.put("ans11", ans11);
		values.put("ans12", ans12);
		values.put("ans13", ans13);
		values.put("ans21", ans21);
		values.put("ans22", ans22);
		values.put("ans23", ans23);
		values.put("ans24", ans24);
		values.put("ans25", ans25);
		values.put("ans26", ans26);
		values.put("ans31", ans31);
		values.put("ans32", ans32);
		values.put("ans33", ans33);
		values.put("ans34", ans34);
		values.put("ans35", ans35);
		values.put("ans41", ans41);
		values.put("ans42", ans42);
		values.put("ans43", ans43);
		values.put("ans51", ans51);
		values.put("ans52", ans52);
		values.put("ans53", ans53);
		values.put("ans54", ans54);
		values.put("ans61", ans61);
		values.put("ans62", ans62);
		values.put("saved", saved);
		values.put("care", "");
		values.put("careage", "");
		values.put("carerelate", "");
		values.put("carelong", "");
		values.put("with018", "");
		values.put("with18up", "");
		values.put("withd018", "");
		values.put("withd18up", "");
		values.put("withs018", "");
		values.put("withs18up", "");
		values.put("event", "");
		values.put("q1h1", 0);
		values.put("q1h2", 0);
		values.put("q1h3", 0);
		values.put("q1h4", 0);
		values.put("q2h1", 0);
		values.put("q2h2", 0);
		values.put("q2h3", 0);
		values.put("q2h4", 0);
		values.put("q2h5", 0);
		values.put("q2h6", 0);
		values.put("q3h1", 0);
		values.put("q3h2", 0);
		values.put("q3h3", 0);
		values.put("q4h1", 0);
		values.put("q4h2", 0);
		values.put("q4h3", 0);
		values.put("q5h1", 0);
		values.put("q5h2", 0);
		values.put("q6h1", 0);
		values.put("q6h2", 0);
		values.put("timebegin", dateFormat.format(c.getTime()));
		values.put("timeend", "");
		values.put(MySQLiteHelper.UPDATE_STATUS_DATA, "no");
		values.put(MySQLiteHelper.COMMON_CID, cid);
		values.put(MySQLiteHelper.JOB, job);
		values.put(MySQLiteHelper.ID_DATA_EXTEA, id_data);
		return database.insert(DATABASE_TABLE, null, values);
	}

	public Cursor getallfromid(String id) {
		Cursor c = database.query(DATABASE_TABLE, new String[] { "_id", "_no",
				"ans11", "ans12", "ans13", "ans21", "ans22", "ans23", "ans24",
				"ans25", "ans26", "ans31", "ans32", "ans33", "ans34", "ans35",
				"ans41", "ans42", "ans43", "ans51", "ans52", "ans53", "ans54",
				"ans61", "ans62", "saved", "care", "careage", "carerelate",
				"carelong", "with018", "with18up", "withd018", "withd18up",
				"withs018", "withs18up", "event", "q1h1", "q1h2", "q1h3",
				"q1h4", "q2h1", "q2h2", "q2h3", "q2h4", "q2h5", "q2h6", "q3h1",
				"q3h2", "q3h3", "q4h1", "q4h2", "q4h3", "q5h1", "q5h2", "q6h1",
				"q6h2", "timebegin", "timeend", MySQLiteHelper.JOB,
				MySQLiteHelper.ID_DATA_EXTEA }, "_id=?", new String[] { id },
				null, null, null);
		return c;
	}

	public Cursor getallfromidno(String id, String no) {
		
		Cursor c = database.query(DATABASE_TABLE, new String[] { "_id", "_no",
				"ans11", "ans12", "ans13", "ans21", "ans22", "ans23", "ans24",
				"ans25", "ans26", "ans31", "ans32", "ans33", "ans34", "ans35",
				"ans41", "ans42", "ans43", "ans51", "ans52", "ans53", "ans54",
				"ans61", "ans62", "saved", "care", "careage", "carerelate",
				"carelong", "with018", "with18up", "withd018", "withd18up",
				"withs018", "withs18up", "event", "q1h1", "q1h2", "q1h3",
				"q1h4", "q2h1", "q2h2", "q2h3", "q2h4", "q2h5", "q2h6", "q3h1",
				"q3h2", "q3h3", "q4h1", "q4h2", "q4h3", "q5h1", "q5h2", "q6h1",
				"q6h2", "timebegin", "timeend", MySQLiteHelper.JOB,
				MySQLiteHelper.ID_DATA_EXTEA }, "_id=? AND _no=?",
				new String[] { id, no }, null, null, null);
		c.moveToFirst();
		return c;
	}

	public long update(ContentValues c, String id, String no) {
		return database.update(DATABASE_TABLE, c, "_id=? AND _no=?",
				new String[] { id, no });
	}

	public void updateUpdateStatusData(String id, String status) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.UPDATE_STATUS_DATA, "yes");
		long l = database.update(DATABASE_TABLE, values, "_id=?",
				new String[] { id });
		Log.d("LLLLLLdata", l + "");
	}

	public Cursor getallUpdatedData() {
		Cursor c = database.query(DATABASE_TABLE, null,
				MySQLiteHelper.UPDATE_STATUS_DATA + "=?",
				new String[] { "no" }, null, null, null);

		return c;
	}

	public Cursor getallUpdatedData2() {
		String sql = MySQLiteHelper.UPDATE_STATUS_DATA + " =?";
		sql += " and ans11 !=?";
		sql += " and ans12 !=?";
		sql += " and ans13 !=?";
		sql += " and ans21 !=?";
		sql += " and ans22 !=?";
		sql += " and ans23 !=?";
		sql += " and ans24 !=?";
		sql += " and ans25 !=?";
		sql += " and ans26 !=?";
		sql += " and ans31 !=?";
		sql += " and ans32 !=?";
		sql += " and ans33 !=?";
		sql += " and ans34 !=?";
		sql += " and ans35 !=?";
		sql += " and ans41 !=?";
		sql += " and ans42 !=?";
		sql += " and ans43 !=?";
		sql += " and ans51 !=?";
		sql += " and ans52 !=?";
		sql += " and ans53 !=?";
		sql += " and ans54 !=?";
		sql += " and ans61 !=?";
		sql += " and ans62 !=?";
		// sql += " and care !=?";
		// sql += " and careage !=?";
		// sql += " and carerelate !=?";
		// sql += " and carelong !=?";
		// sql += " and with018 !=?";
		// sql += " and with18up !=?";
		// sql += " and withd018 !=?";
		// sql += " and withd18up !=?";
		// sql += " and withs018 !=?";
		// sql += " and withs18up !=?";
		// sql += " and event !=?";
		// sql += " and q1h1 !=?";
		// sql += " and q1h2 !=?";
		// sql += " and q1h3 !=?";
		// sql += " and q1h4 !=?";
		// sql += " and q2h1 !=?";
		// sql += " and q2h2 !=?";
		// sql += " and q2h3 !=?";
		// sql += " and q2h4 !=?";
		// sql += " and q2h5 !=?";
		// sql += " and q2h6 !=?";
		// sql += " and q3h1 !=?";
		// sql += " and q3h2 !=?";
		// sql += " and q3h3 !=?";
		// sql += " and q4h1 !=?";
		// sql += " and q4h2 !=?";
		// sql += " and q4h3 !=?";
		// sql += " and q5h1 !=?";
		// sql += " and q5h2 !=?";
		// sql += " and q6h1 !=?";
		// sql += " and q6h2 !=?";
		sql += "and job !=?";
		sql += "and id_data";
		String array[] = { "no", "0", "0", "0", "0", "0", "0", "0", "0", "0",
				"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
				"0", "0" };
		Cursor c = database.query(DATABASE_TABLE, null, sql,
				new String[] { "no" }, null, null, null);

		return c;
	}
}
