package com.rimon.rsa.ibd.database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.rimon.rsa.ibd.main.ConstantValues;

@SuppressLint("SimpleDateFormat")
public class DBAdapter {
	private DBHelper rrdDBHelper;
	private Context context;
	private SQLiteDatabase db;

	public DBAdapter(Context context) {
		this.context = context;
		rrdDBHelper = new DBHelper(this.context);
	}

	public void openWriteableDatabase() {
		db = rrdDBHelper.getWritableDatabase();
	}

	public void openReadableDatabase() {
		db = rrdDBHelper.getReadableDatabase();
	}

	public void close() {
		db.close();
	}

	@SuppressLint("SimpleDateFormat")
	public long insert() {

		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm a");

		ContentValues values = new ContentValues();

		values.put(DBHelper.PQ_1, ConstantValues.question_1_value);
		values.put(DBHelper.PQ_2, ConstantValues.question_2_value);
		values.put(DBHelper.PQ_3, ConstantValues.question_3_value);
		values.put(DBHelper.PQ_4, ConstantValues.question_4_value);
		values.put(DBHelper.PQ_5, ConstantValues.question_5_value);
		values.put(DBHelper.PQ_6, ConstantValues.question_6_value);
		values.put(DBHelper.PQ_7, ConstantValues.question_7_value);
		values.put(DBHelper.PQ_8, ConstantValues.question_8_value);
		values.put(DBHelper.PQ_9, ConstantValues.question_9_value);
		values.put(DBHelper.PQ_10, ConstantValues.question_10_value);
		values.put(DBHelper.PQ_11, ConstantValues.question_11_value);
		values.put(DBHelper.PQ_12, ConstantValues.question_12_value);
		values.put(DBHelper.PQ_13, ConstantValues.question_13_value);
		values.put(DBHelper.PQ_14, ConstantValues.question_14_value);
		values.put(DBHelper.PQ_15, ConstantValues.question_15_value);
		values.put(DBHelper.PQ_16, ConstantValues.question_16_value);
		values.put(DBHelper.PQ_17, ConstantValues.question_17_value);
		values.put(DBHelper.PQ_18, ConstantValues.question_18_value);
		values.put(DBHelper.PQ_19, ConstantValues.question_19_value);
		values.put(DBHelper.PQ_20, ConstantValues.question_20_value);
		values.put(DBHelper.PQ_21, ConstantValues.question_21_value);
		values.put(DBHelper.PQ_22, ConstantValues.question_22_value);
		values.put(DBHelper.PQ_23, ConstantValues.question_23_value);
		values.put(DBHelper.PQ_24, ConstantValues.question_24_value);
		values.put(DBHelper.PQ_25, ConstantValues.question_25_value);
		values.put(DBHelper.PQ_26, ConstantValues.question_26_value);
		values.put(DBHelper.PQ_27, ConstantValues.question_27_value);
		values.put(DBHelper.PQ_28, ConstantValues.question_28_value);
		values.put(DBHelper.PQ_29, ConstantValues.question_29_value);
		values.put(DBHelper.PQ_30, ConstantValues.question_30_value);
		values.put(DBHelper.PQ_31, ConstantValues.question_31_value);
		values.put(DBHelper.PQ_32, ConstantValues.question_32_value);
		values.put(DBHelper.PQ_33, ConstantValues.question_33_value);
		values.put(DBHelper.PQ_34, ConstantValues.question_34_value);
		values.put(DBHelper.PQ_35, ConstantValues.question_35_value);
		values.put(DBHelper.PQ_36, ConstantValues.question_36_value);
		values.put(DBHelper.PQ_37, ConstantValues.question_37_value);

		values.put(DBHelper.PFQ_1, ConstantValues.f_question_1_value);
		values.put(DBHelper.PFQ_2, ConstantValues.f_question_2_value);
		values.put(DBHelper.PFQ_3, ConstantValues.f_question_3_value);
		values.put(DBHelper.PFQ_4, ConstantValues.f_question_4_value);
		values.put(DBHelper.PFQ_5, ConstantValues.f_question_5_value);
		values.put(DBHelper.PFQ_6, ConstantValues.f_question_6_value);
		values.put(DBHelper.PFQ_7, ConstantValues.f_question_7_value);
		values.put(DBHelper.PFQ_8, ConstantValues.f_question_8_value);
		values.put(DBHelper.PFQ_9, ConstantValues.f_question_9_value);
		values.put(DBHelper.PFQ_10, ConstantValues.f_question_10_value);
		values.put(DBHelper.PFQ_11, ConstantValues.f_question_11_value);
		values.put(DBHelper.PFQ_12, ConstantValues.f_question_12_value);
		values.put(DBHelper.PFQ_13, ConstantValues.f_question_13_value);
		values.put(DBHelper.PFQ_14, ConstantValues.f_question_14_value);
		values.put(DBHelper.PFQ_15, ConstantValues.f_question_15_value);
		values.put(DBHelper.PFQ_16, ConstantValues.f_question_16_value);
		values.put(DBHelper.PFQ_17, ConstantValues.f_question_17_value);
		
		values.put(DBHelper.TIME, stf.format(c.getTime()));
		values.put(DBHelper.DATE, sdf.format(c.getTime()));
		values.put(DBHelper.EXPORT_STATUS, ConstantValues.export_status_false);
		values.put(DBHelper.DEPRESSION, ConstantValues.depression);
		values.put(DBHelper.STRESS, ConstantValues.stress);
		values.put(DBHelper.ANXIETY, ConstantValues.anxiety);
		values.put(DBHelper.DEPRESSION_LEVEL, ConstantValues.depression_level);
		values.put(DBHelper.STRESS_LEVEL, ConstantValues.stress_level);
		values.put(DBHelper.ANXIETY_LEVEL, ConstantValues.anxiety_level);
		values.put(DBHelper.RESULT_LEVEL, ConstantValues.result_level);
		values.put(DBHelper.ALL_QUESTION_STATUS, ConstantValues.all_question_status);

		long inserted = db.insert(DBHelper.TABLE_NAME_PATIENT, null, values);

		Log.d("dddddddddddddddddddd", inserted + "");
		return inserted;

	}

	public Cursor getAllCursor() {
		Cursor myCursor = db.query(DBHelper.TABLE_NAME_PATIENT, null, null,
				null, null, null, DBHelper.ID_FIELD + " DESC");

		return myCursor;
	}

	public Cursor getNewPatientCursor() {
		Cursor myCursor = db.query(DBHelper.TABLE_NAME_PATIENT, null,
				DBHelper.EXPORT_STATUS + "=?",
				new String[] { ConstantValues.export_status_false }, null,
				null, null);

		return myCursor;
	}

	public long deleteData(String tableName, String whereClause,
			String[] whereArgs) {
		return db.delete(tableName, whereClause, whereArgs);
	}

	public void updateData(String id) {
		ContentValues values = new ContentValues();
		values.put(DBHelper.EXPORT_STATUS, ConstantValues.export_status_true);
		db.update(DBHelper.TABLE_NAME_PATIENT, values,
				DBHelper.ID_FIELD + "=?", new String[] { id });
	}
}