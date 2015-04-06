package com.rimon.rsa.ipaeps.appdatabase;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.timeandime.TimeAndIme;

public class PpPatientDBOpenHelper extends SQLiteOpenHelper {

	private TimeAndIme timeAndIme;
	public static String DB_PATH;
	private SQLiteDatabase database;
	// private Context context;
	// patient database name
	public static final String PATIENT_DB_NAME = "patientdata.db";
	// patient table name
	public static final String PATIENT_TABLE_NAME = "data";
	// id
	public static String database_id = "_id";
	// time
	public static String time = "time";
	// date
	public static String date = "date";

	// sync
	public static String sync = "sync";
	// unique_id
	public static String unique_id = "unique_id";

	// module 1 patient id
	public static String q_module_1_1 = "q_module_1_1";
	public static String q_module_1_2 = "q_module_1_2";;
	public static String q_module_1_3 = "q_module_1_3";;
	// module 2 Demographic details
	public static String q_module_2_1 = "q_module_2_1";
	public static String q_module_2_2 = "q_module_2_2";
	public static String q_module_2_3 = "q_module_2_3";
	public static String q_module_2_4 = "q_module_2_4";
	public static String q_module_2_5 = "q_module_2_5";
	public static String q_module_2_6 = "q_module_2_6";

	// module 3 ibd
	public static String q_module_3_1 = "q_module_3_1";
	public static String q_module_3_2 = "q_module_3_2";
	public static String q_module_3_3 = "q_module_3_3";
	public static String q_module_3_4 = "q_module_3_4";
	public static String q_module_3_5 = "q_module_3_5";

	public static String q_module_3_6 = "q_module_3_6";
	public static String q_module_3_7 = "q_module_3_7";
	public static String q_module_3_8 = "q_module_3_8";
	public static String q_module_3_9 = "q_module_3_9";
	public static String q_module_3_10 = "q_module_3_10";

	public static String q_module_3_11 = "q_module_3_11";
	public static String q_module_3_12 = "q_module_3_12";
	public static String q_module_3_13 = "q_module_3_13";
	public static String q_module_3_14 = "q_module_3_14";
	public static String q_module_3_15 = "q_module_3_15";
	public static String q_module_3_16 = "q_module_3_16";
	public static String q_module_3_17 = "q_module_3_17";
	public static String q_module_3_18 = "q_module_3_18";
	public static String q_module_3_19 = "q_module_3_19";

	// <!-- 4. Medications -->

	public static String q_module_4_1 = "q_module_4_1";
	public static String q_module_4_2 = "q_module_4_2";
	public static String q_module_4_3 = "q_module_4_3";
	public static String q_module_4_4 = "q_module_4_4";
	public static String q_module_4_5 = "q_module_4_5";
	public static String q_module_4_6 = "q_module_4_6";
	public static String q_module_4_7 = "q_module_4_7";
	public static String q_module_4_8 = "q_module_4_8";
	public static String q_module_4_9 = "q_module_4_9";

	// <!--5. Medication adherence -->
	// question
	public static String q_module_5_1 = "q_module_5_1";
	public static String q_module_5_2 = "q_module_5_2";
	public static String q_module_5_3 = "q_module_5_3";
	public static String q_module_5_4 = "q_module_5_4";
	public static String q_module_5_5 = "q_module_5_5";

	// module 6
	public static String q_module_6_1 = "q_module_6_1";
	public static String q_module_6_2 = "q_module_6_2";
	public static String q_module_6_3 = "q_module_6_3";
	public static String q_module_6_4 = "q_module_6_4";
	public static String q_module_6_5 = "q_module_6_5";
	public static String q_module_6_6 = "q_module_6_6";
	public static String q_module_6_7 = "q_module_6_7";
	public static String q_module_6_8 = "q_module_6_8";
	public static String q_module_6_9 = "q_module_6_9";
	public static String q_module_6_10 = "q_module_6_10";
	public static String q_module_6_11 = "q_module_6_11";
	public static String q_module_6_12 = "q_module_6_12";

	// <!-- 7. Mental health status -->
	public static String q_module_7_1 = "q_module_7_1";
	public static String q_module_7_2 = "q_module_7_2";
	public static String q_module_7_3 = "q_module_7_3";
	public static String q_module_7_4 = "q_module_7_4";
	public static String q_module_7_5 = "q_module_7_5";
	public static String q_module_7_6 = "q_module_7_6";
	public static String q_module_7_7 = "q_module_7_7";
	public static String q_module_7_8 = "q_module_7_8";
	public static String q_module_7_9 = "q_module_7_9";
	public static String q_module_7_10 = "q_module_7_10";
	public static String q_module_7_11 = "q_module_7_11";
	public static String q_module_7_12 = "q_module_7_12";
	public static String q_module_7_13 = "q_module_7_13";
	public static String q_module_7_14 = "q_module_7_14";
	public static String q_module_7_15 = "q_module_7_15";
	public static String q_module_7_16 = "q_module_7_16";
	public static String q_module_7_17 = "q_module_7_17";
	public static String q_module_7_18 = "q_module_7_18";
	public static String q_module_7_19 = "q_module_7_19";
	public static String q_module_7_20 = "q_module_7_20";
	public static String q_module_7_21 = "q_module_7_21";
	public static String q_module_7_22_result = "q_module_7_22_result";
	public static String q_module_7_23_result_level = "q_module_7_23_result_level";

	// <!-- 8. Mental health status (patient feedback) -->
	public static String q_module_8_1 = "q_module_8_1";
	public static String q_module_8_2 = "q_module_8_2";
	public static String q_module_8_3 = "q_module_8_3";
	public static String q_module_8_4 = "q_module_8_4";

	// <!-- 9. Diet -->

	public static String q_module_9_1 = "q_module_9_1";
	public static String q_module_9_2 = "q_module_9_2";
	public static String q_module_9_3 = "q_module_9_3";
	public static String q_module_9_4 = "q_module_9_4";
	public static String q_module_9_5 = "q_module_9_5";
	public static String q_module_9_6 = "q_module_9_6";
	public static String q_module_9_7 = "q_module_9_7";

	// <!-- 10. Patient confidence -->
	public static String q_module_10_1 = "q_module_10_1";
	public static String q_module_10_2 = "q_module_10_2";
	public static String q_module_10_3 = "q_module_10_3";
	public static String q_module_10_4 = "q_module_10_4";
	public static String q_module_10_5 = "q_module_10_5";
	public static String q_module_10_6 = "q_module_10_6";

	// <!-- 11. Patient question -->
	public static String q_module_11_1 = "q_module_11_1";

	// module 12
	public static String q_module_12_1 = "q_module_12_1";
	public static String q_module_12_2 = "q_module_12_2";
	public static String q_module_12_3 = "q_module_12_3";
	public static String q_module_12_4 = "q_module_12_4";
	public static String q_module_12_5 = "q_module_12_5";
	public static String q_module_12_6 = "q_module_12_6";
	public static String q_module_12_7 = "q_module_12_7";
	public static String q_module_12_8 = "q_module_12_8";
	public static String q_module_12_9 = "q_module_12_9";

	// module 13
	public static String q_module_13_1 = "q_module_13_1";
	public static String q_module_13_2 = "q_module_13_2";
	public static String q_module_13_3 = "q_module_13_3";
	public static String q_module_13_4 = "q_module_13_4";
	public static String q_module_13_5 = "q_module_13_5";
	public static String q_module_13_6 = "q_module_13_6";
	public static String q_module_13_7 = "q_module_13_7";
	public static String q_module_13_8 = "q_module_13_8";
	public static String q_module_13_9 = "q_module_13_9";

	// <!-- 14. Identifying problems/barriers I’m currently facing in relation
	// to managing my IBD -->
	public static String q_module_14_1 = "q_module_14_1";
	public static String q_module_14_2 = "q_module_14_2";
	public static String q_module_14_3 = "q_module_14_3";
	public static String q_module_14_4 = "q_module_14_4";
	public static String q_module_14_5 = "q_module_14_5";
	public static String q_module_14_6 = "q_module_14_6";

	// <!-- 15. Program evaluation (patient feedback) -->
	public static String q_module_15_1 = "q_module_15_1";
	public static String q_module_15_2 = "q_module_15_2";
	public static String q_module_15_3 = "q_module_15_3";
	public static String q_module_15_4 = "q_module_15_4";

	public static String isExport = "isexport";

	// get cursor all patient data in to desc order
	public Cursor getAllPatientCursor() {
		Cursor myCursor = this.database.query(PATIENT_TABLE_NAME, null, null,
				null, null, null, database_id + " DESC");

		myCursor.moveToFirst();
		for (int i = 0; i < myCursor.getCount(); i++) {
			Log.d("EEEEEEEEEEEEEEEEEEEE",
					myCursor.getString(myCursor.getColumnIndex(isExport)));
			myCursor.moveToNext();
		}

		myCursor.moveToFirst();

		return myCursor;
	}

	public Cursor getAllPatientCursorFromID(int id) {
		Cursor myCursor = this.database.query(PATIENT_TABLE_NAME, null,
				database_id + "=?", new String[] { id + "" }, null, null, null);
		return myCursor;

	}

	public Cursor getAllPatientCursorFromExport(boolean exportType) {
		Cursor myCursor;
		if (!exportType) {
			myCursor = this.database.query(PATIENT_TABLE_NAME, null, isExport
					+ "= ?", new String[] { "0" }, null, null, null);
		} else {
			myCursor = this.database.query(PATIENT_TABLE_NAME, null, isExport
					+ "= ?", new String[] { "1" }, null, null, null);

		}
		myCursor.moveToFirst();
		return myCursor;

	}

	public boolean updateExportStatus(int id, boolean exportStaus) {
		ContentValues values = new ContentValues();
		values.put(isExport, exportStaus ? "1" : "0");
		return this.database.update(PATIENT_TABLE_NAME, values, database_id
				+ "= ? ", new String[] { id + "" }) > 0;
	}

	public boolean savePatientData() {
		ContentValues values = new ContentValues();

		values.put(time, timeAndIme.getTime());
		values.put(date, timeAndIme.getDate());
		values.put(sync, AppConstants.FALSE);
		values.put(unique_id, timeAndIme.getUniqueId());

		values.put(q_module_1_1, AppConstants.q_module_1_1);
		values.put(q_module_1_2, AppConstants.q_module_1_2);
		values.put(q_module_1_3, AppConstants.q_module_1_3);

		values.put(q_module_2_1, AppConstants.q_module_2_1);
		values.put(q_module_2_2, AppConstants.q_module_2_2);
		values.put(q_module_2_3, AppConstants.q_module_2_3);
		values.put(q_module_2_4, AppConstants.q_module_2_4);
		values.put(q_module_2_5, AppConstants.q_module_2_5);
		values.put(q_module_2_6, AppConstants.q_module_2_6);

		values.put(q_module_3_1, AppConstants.q_module_3_1);
		values.put(q_module_3_2, AppConstants.q_module_3_2);
		values.put(q_module_3_3, AppConstants.q_module_3_3);
		values.put(q_module_3_4, AppConstants.q_module_3_4);
		values.put(q_module_3_5, AppConstants.q_module_3_5);
		values.put(q_module_3_6, AppConstants.q_module_3_6);
		values.put(q_module_3_7, AppConstants.q_module_3_7);
		values.put(q_module_3_8, AppConstants.q_module_3_8);
		values.put(q_module_3_9, AppConstants.q_module_3_9);
		values.put(q_module_3_10, AppConstants.q_module_3_10);
		values.put(q_module_3_11, AppConstants.q_module_3_11);
		values.put(q_module_3_12, AppConstants.q_module_3_12);
		values.put(q_module_3_13, AppConstants.q_module_3_13);
		values.put(q_module_3_14, AppConstants.q_module_3_14);
		values.put(q_module_3_15, AppConstants.q_module_3_15);
		values.put(q_module_3_16, AppConstants.q_module_3_16);
		values.put(q_module_3_17, AppConstants.q_module_3_17);
		values.put(q_module_3_18, AppConstants.q_module_3_18);
		values.put(q_module_3_19, AppConstants.q_module_3_19);

		values.put(q_module_4_1, AppConstants.q_module_4_1);
		values.put(q_module_4_2, AppConstants.q_module_4_2);
		values.put(q_module_4_3, AppConstants.q_module_4_3);
		values.put(q_module_4_4, AppConstants.q_module_4_4);
		values.put(q_module_4_5, AppConstants.q_module_4_5);
		values.put(q_module_4_6, AppConstants.q_module_4_6);
		values.put(q_module_4_7, AppConstants.q_module_4_7);
		values.put(q_module_4_8, AppConstants.q_module_4_8);
		values.put(q_module_4_9, AppConstants.q_module_4_9);

		values.put(q_module_5_1, AppConstants.q_module_5_1);
		values.put(q_module_5_2, AppConstants.q_module_5_2);
		values.put(q_module_5_3, AppConstants.q_module_5_3);
		values.put(q_module_5_4, AppConstants.q_module_5_4);
		values.put(q_module_5_5, AppConstants.q_module_5_5);

		values.put(q_module_6_1, AppConstants.q_module_6_1);
		values.put(q_module_6_2, AppConstants.q_module_6_2);
		values.put(q_module_6_3, AppConstants.q_module_6_3);
		values.put(q_module_6_4, AppConstants.q_module_6_4);
		values.put(q_module_6_5, AppConstants.q_module_6_5);
		values.put(q_module_6_6, AppConstants.q_module_6_6);
		values.put(q_module_6_7, AppConstants.q_module_6_7);
		values.put(q_module_6_8, AppConstants.q_module_6_8);
		values.put(q_module_6_9, AppConstants.q_module_6_9);
		values.put(q_module_6_10, AppConstants.q_module_6_10);
		values.put(q_module_6_11, AppConstants.q_module_6_11);
		values.put(q_module_6_12, AppConstants.q_module_6_12);

		values.put(q_module_7_1, AppConstants.q_module_7_1);
		values.put(q_module_7_2, AppConstants.q_module_7_2);
		values.put(q_module_7_3, AppConstants.q_module_7_3);
		values.put(q_module_7_4, AppConstants.q_module_7_4);
		values.put(q_module_7_5, AppConstants.q_module_7_5);
		values.put(q_module_7_6, AppConstants.q_module_7_6);
		values.put(q_module_7_7, AppConstants.q_module_7_7);
		values.put(q_module_7_8, AppConstants.q_module_7_8);
		values.put(q_module_7_9, AppConstants.q_module_7_9);
		values.put(q_module_7_10, AppConstants.q_module_7_10);
		values.put(q_module_7_11, AppConstants.q_module_7_11);
		values.put(q_module_7_12, AppConstants.q_module_7_12);
		values.put(q_module_7_13, AppConstants.q_module_7_13);
		values.put(q_module_7_14, AppConstants.q_module_7_14);
		values.put(q_module_7_15, AppConstants.q_module_7_15);
		values.put(q_module_7_16, AppConstants.q_module_7_16);
		values.put(q_module_7_17, AppConstants.q_module_7_17);
		values.put(q_module_7_18, AppConstants.q_module_7_18);
		values.put(q_module_7_19, AppConstants.q_module_7_19);
		values.put(q_module_7_20, AppConstants.q_module_7_20);
		values.put(q_module_7_21, AppConstants.q_module_7_21);
		values.put(q_module_7_22_result, AppConstants.q_module_7_22_result);
		values.put(q_module_7_23_result_level,
				AppConstants.q_module_7_23_result_level);

		values.put(q_module_8_1, AppConstants.q_module_8_1);
		values.put(q_module_8_2, AppConstants.q_module_8_2);
		values.put(q_module_8_3, AppConstants.q_module_8_3);
		values.put(q_module_8_4, AppConstants.q_module_8_4);

		values.put(q_module_9_1, AppConstants.q_module_9_1);
		values.put(q_module_9_2, AppConstants.q_module_9_2);
		values.put(q_module_9_3, AppConstants.q_module_9_3);
		values.put(q_module_9_4, AppConstants.q_module_9_4);
		values.put(q_module_9_5, AppConstants.q_module_9_5);
		values.put(q_module_9_6, AppConstants.q_module_9_6);
		values.put(q_module_9_7, AppConstants.q_module_9_7);

		values.put(q_module_10_1, AppConstants.q_module_10_1);
		values.put(q_module_10_2, AppConstants.q_module_10_2);
		values.put(q_module_10_3, AppConstants.q_module_10_3);
		values.put(q_module_10_4, AppConstants.q_module_10_4);
		values.put(q_module_10_5, AppConstants.q_module_10_5);
		values.put(q_module_10_6, AppConstants.q_module_10_6);

		values.put(q_module_11_1, AppConstants.q_module_11_1);

		values.put(q_module_12_1, AppConstants.q_module_12_1);
		values.put(q_module_12_2, AppConstants.q_module_12_2);
		values.put(q_module_12_3, AppConstants.q_module_12_3);
		values.put(q_module_12_4, AppConstants.q_module_12_4);
		values.put(q_module_12_5, AppConstants.q_module_12_5);
		values.put(q_module_12_6, AppConstants.q_module_12_6);
		values.put(q_module_12_7, AppConstants.q_module_12_7);
		values.put(q_module_12_8, AppConstants.q_module_12_8);
		values.put(q_module_12_9, AppConstants.q_module_12_9);

		values.put(q_module_13_1, AppConstants.q_module_13_1);
		values.put(q_module_13_2, AppConstants.q_module_13_2);
		values.put(q_module_13_3, AppConstants.q_module_13_3);
		values.put(q_module_13_4, AppConstants.q_module_13_4);
		values.put(q_module_13_5, AppConstants.q_module_13_5);
		values.put(q_module_13_6, AppConstants.q_module_13_6);
		values.put(q_module_13_7, AppConstants.q_module_13_7);
		values.put(q_module_13_8, AppConstants.q_module_13_8);
		values.put(q_module_13_9, AppConstants.q_module_13_9);

		values.put(q_module_14_1, AppConstants.q_module_14_1);
		values.put(q_module_14_2, AppConstants.q_module_14_2);
		values.put(q_module_14_3, AppConstants.q_module_14_3);
		values.put(q_module_14_4, AppConstants.q_module_14_4);
		values.put(q_module_14_5, AppConstants.q_module_14_5);
		values.put(q_module_14_6, AppConstants.q_module_14_6);

		values.put(q_module_15_1, AppConstants.q_module_15_1);
		values.put(q_module_15_2, AppConstants.q_module_15_2);
		values.put(q_module_15_3, AppConstants.q_module_15_3);
		values.put(q_module_15_4, AppConstants.q_module_15_4);

		return this.database.insert(PATIENT_TABLE_NAME, null, values) > 0;
	}

	public boolean deleteDataFromIdField(String id) {
		return this.database.delete(PATIENT_TABLE_NAME, database_id + "=?",
				new String[] { id }) > 0;
	}

	public PpPatientDBOpenHelper(Context context) {

		super(context, PATIENT_DB_NAME, null, 1);
		// this.context = context;
		timeAndIme = new TimeAndIme(context);
		DB_PATH = context.getDatabasePath(PATIENT_DB_NAME).toString();
		PatientDBHelper dbHelper = new PatientDBHelper(context);
		this.database = dbHelper.getWritableDatabase(timeAndIme.getIME());
	}
	// public SQLiteDatabase getDatabase() {
	// return this.database;
	// }
	//
	// public SQLiteDatabase openDatabase() {
	// String path = DB_PATH + PATIENT_DB_NAME;
	// if (database == null) {
	// createDatabase();
	// // database = SQLiteDatabase.openDatabase(path, "abc123",null
	// // SQLiteDatabase.OPEN_READWRITE);
	// database=SQLiteDatabase.openDatabase(path, "12a3", null,
	// SQLiteDatabase.OPEN_READWRITE);
	// }
	// return database;
	// }
	//
	// private void createDatabase() {
	// boolean dbExists = checkDB();
	// if (!dbExists) {
	// // this.getWritableDatabase("12a3");
	// Log.e(getClass().getName(),
	// "Database doesn't exist. Copying database from assets...");
	// copyDatabase();
	// } else {
	// Log.e(getClass().getName(), "Database already exists");
	// }
	// }
	//
	// private void copyDatabase() {
	// try {
	// InputStream dbInputStream = context.getAssets().open(
	// PATIENT_DB_NAME);
	// String path = DB_PATH + PATIENT_DB_NAME;
	// OutputStream dbOutputStream = new FileOutputStream(path);
	// byte[] buffer = new byte[4096];
	// int readCount = 0;
	// while ((readCount = dbInputStream.read(buffer)) > 0) {
	// dbOutputStream.write(buffer, 0, readCount);
	// }
	//
	// dbInputStream.close();
	// dbOutputStream.close();
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// private boolean checkDB() {
	// String path = DB_PATH + PATIENT_DB_NAME;
	// File file = new File(path);
	// if (file.exists()) {
	// Log.e(getClass().getName(), "Database already exists");
	// return true;
	// }
	// Log.e(getClass().getName(), "Database does not exists");
	// return false;
	// }

	public synchronized void close() {
		if (this.database != null) {
			this.database.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
}
