package com.rimon.rsa.ipaeps.appdatabase;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import android.content.Context;

public class PatientDBHelper extends SQLiteOpenHelper {
	public final static int VERSION = 1;

	public PatientDBHelper(Context context) {
		super(context, PpPatientDBOpenHelper.PATIENT_DB_NAME, null, VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_SQL);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	private static final String TABLE_SQL = "CREATE TABLE [data] (_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,time text,date text,sync text,unique_id text,q_module_1_1 text,q_module_1_2 text,q_module_1_3 text,q_module_2_1 text,q_module_2_2 text,q_module_2_3 text,q_module_2_4 text,q_module_2_5 text,q_module_2_6 text,q_module_3_1 text,q_module_3_2 text,q_module_3_3 text,q_module_3_4 text,q_module_3_5 text,q_module_3_6 text,q_module_3_7 text,q_module_3_8 text,q_module_3_9 text,q_module_3_10 text,q_module_3_11 text,q_module_3_12 text,q_module_3_13 text,q_module_3_14 text,q_module_3_15 text,q_module_3_16 text,q_module_3_17 text,q_module_3_18 text,q_module_3_19 text,q_module_4_1 text,q_module_4_2 text,q_module_4_3 text,q_module_4_4 text,q_module_4_5 text,q_module_4_6 text,q_module_4_7 text,q_module_4_8 text,q_module_4_9 text,q_module_5_1 text,q_module_5_2 text,q_module_5_3 text,q_module_5_4 text,q_module_5_5 text,q_module_6_1 text,q_module_6_2 text,q_module_6_3 text,q_module_6_4 text,q_module_6_5 text,q_module_6_6 text,q_module_6_7 text,q_module_6_8 text,q_module_6_9 text,q_module_6_10 text,q_module_6_11 text,q_module_6_12 text,q_module_7_1 text,q_module_7_2 text,q_module_7_3 text,q_module_7_4 text,q_module_7_5 text,q_module_7_6 text,q_module_7_7 text,q_module_7_8 text,q_module_7_9 text,q_module_7_10 text,q_module_7_11 text,q_module_7_12 text,q_module_7_13 text,q_module_7_14 text,q_module_7_15 text,q_module_7_16 text,q_module_7_17 text,q_module_7_18 text,q_module_7_19 text,q_module_7_20 text,q_module_7_21 text,q_module_7_22_result text,q_module_7_23_result_level text,q_module_8_1 text,q_module_8_2 text,q_module_8_3 text,q_module_8_4 text,q_module_9_1 text,q_module_9_2 text,q_module_9_3 text,q_module_9_4 text,q_module_9_5 text,q_module_9_6 text,q_module_9_7 text,q_module_10_1 text,q_module_10_2 text,q_module_10_3 text,q_module_10_4 text,q_module_10_5 text,q_module_10_6 text,q_module_11_1 text,q_module_12_1 text,q_module_12_2 text,q_module_12_3 text,q_module_12_4 text,q_module_12_5 text,q_module_12_6 text,q_module_12_7 text,q_module_12_8 text,q_module_12_9 text,q_module_13_1 text,q_module_13_2 text,q_module_13_3 text,q_module_13_4 text,q_module_13_5 text,q_module_13_6 text,q_module_13_7 text,q_module_13_8 text,q_module_13_9 text,q_module_14_1 text,q_module_14_2 text,q_module_14_3 text,q_module_14_4 text,q_module_14_5 text,q_module_14_6 text,q_module_15_1 text,q_module_15_2 text,q_module_15_3 text,q_module_15_4 text,isexport text DEFAULT 0)";
}
