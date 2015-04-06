package com.rimon.rsa.ibd.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	public static final String DB_NAME_FROME = "ibd.db";
	public static final int VERSION = 1;

	public static final String TABLE_NAME_PATIENT = "ibd_table";
	public static final String ID_FIELD = "_id";
	public static final String PQ_1 = "PQ_1";
	public static final String PQ_2 = "PQ_2";
	public static final String PQ_3 = "PQ_3";
	public static final String PQ_4 = "PQ_4";
	public static final String PQ_5 = "PQ_5";
	public static final String PQ_6 = "PQ_6";
	public static final String PQ_7 = "PQ_7";
	public static final String PQ_8 = "PQ_8";
	public static final String PQ_9 = "PQ_9";
	public static final String PQ_10 = "PQ_10";
	public static final String PQ_11 = "PQ_11";
	public static final String PQ_12 = "PQ_12";
	public static final String PQ_13 = "PQ_13";
	public static final String PQ_14 = "PQ_14";
	public static final String PQ_15 = "PQ_15";
	public static final String PQ_16 = "PQ_16";
	public static final String PQ_17 = "PQ_17";
	public static final String PQ_18 = "PQ_18";
	public static final String PQ_19 = "PQ_19";
	public static final String PQ_20 = "PQ_20";
	public static final String PQ_21 = "PQ_21";
	public static final String PQ_22 = "PQ_22";
	public static final String PQ_23 = "PQ_23";
	public static final String PQ_24 = "PQ_24";
	public static final String PQ_25 = "PQ_25";
	public static final String PQ_26 = "PQ_26";
	public static final String PQ_27 = "PQ_27";
	public static final String PQ_28 = "PQ_28";
	public static final String PQ_29 = "PQ_29";
	public static final String PQ_30 = "PQ_30";
	public static final String PQ_31 = "PQ_31";
	public static final String PQ_32 = "PQ_32";
	public static final String PQ_33 = "PQ_33";
	public static final String PQ_34 = "PQ_34";
	public static final String PQ_35 = "PQ_35";
	public static final String PQ_36 = "PQ_36";
	public static final String PQ_37 = "PQ_37";
	public static final String PFQ_1 = "PFQ_1";
	public static final String PFQ_2 = "PFQ_2";
	public static final String PFQ_3 = "PFQ_3";
	public static final String PFQ_4 = "PFQ_4";
	public static final String PFQ_5 = "PFQ_5";
	public static final String PFQ_6 = "PFQ_6";
	public static final String PFQ_7 = "PFQ_7";
	public static final String PFQ_8 = "PFQ_8";
	public static final String PFQ_9 = "PFQ_9";
	public static final String PFQ_10 = "PFQ_10";
	public static final String PFQ_11 = "PFQ_11";
	public static final String PFQ_12 = "PFQ_12";
	public static final String PFQ_13 = "PFQ_13";
	public static final String PFQ_14 = "PFQ_14";
	public static final String PFQ_15 = "PFQ_15";
	public static final String PFQ_16 = "PFQ_16";
	public static final String PFQ_17 = "PFQ_17";

	public static final String TIME = "time";
	public static final String DATE = "date";
	public static final String RESULT_LEVEL = "result_level";
	public static final String EXPORT_STATUS = "export_status";
	public static final String DEPRESSION = "depression";
	public static final String STRESS = "stress";
	public static final String ANXIETY = "anxiety";

	public static final String DEPRESSION_LEVEL = "depression_l";
	public static final String STRESS_LEVEL = "stress_l";
	public static final String ANXIETY_LEVEL = "anxiety_l";
	public static final String ALL_QUESTION_STATUS = "all_question";

	public static final String RRD_TABLE_SQL = "CREATE TABLE "
			+ TABLE_NAME_PATIENT + " (" + ID_FIELD
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + PQ_1 + " TEXT, " + PQ_2
			+ " TEXT, " + PQ_3 + " TEXT, " + PQ_4 + " TEXT, " + PQ_5
			+ " TEXT, " + PQ_6 + " TEXT, " + PQ_7 + " TEXT, " + PQ_8
			+ " TEXT, " + PQ_9 + " TEXT, " + PQ_10 + " TEXT, " + PQ_11
			+ " TEXT, " + PQ_12 + " TEXT, " + PQ_13 + " TEXT, " + PQ_14
			+ " TEXT, " + PQ_15 + " TEXT, " + PQ_16 + " TEXT, " + PQ_17
			+ " TEXT, " + PQ_18 + " TEXT, " + PQ_19 + " TEXT, " + PQ_20
			+ " TEXT, " + PQ_21 + " TEXT, " + PQ_22 + " TEXT, " + PQ_23
			+ " TEXT, " + PQ_24 + " TEXT, " + PQ_25 + " TEXT, " + PQ_26
			+ " TEXT, " + PQ_27 + " TEXT, " + PQ_28 + " TEXT, " + PQ_29
			+ " TEXT, " + PQ_30 + " TEXT, " + PQ_31 + " TEXT, " + PQ_32
			+ " TEXT, " + PQ_33 + " TEXT, " + PQ_34 + " TEXT, " + PQ_35
			+ " TEXT, " + PQ_36 + " TEXT, " + PQ_37 + " TEXT, " + PFQ_1
			+ " TEXT, " + PFQ_2 + " TEXT, " + PFQ_3 + " TEXT, " + PFQ_4
			+ " TEXT, " + PFQ_5 + " TEXT, " + PFQ_6 + " TEXT, " + PFQ_7
			+ " TEXT, " + PFQ_8 + " TEXT, " + PFQ_9 + " TEXT, " + PFQ_10
			+ " TEXT, " + PFQ_11 + " TEXT, " + PFQ_12 + " TEXT, " + PFQ_13
			+ " TEXT, " + PFQ_14 + " TEXT, " + PFQ_15 + " TEXT, " + PFQ_16
			+ " TEXT, " + PFQ_17 + " TEXT, " + RESULT_LEVEL + " TEXT, "
			+ ANXIETY + " TEXT, " + DEPRESSION + " TEXT, " + STRESS + " TEXT,"
			+ ANXIETY_LEVEL + " TEXT, " + DEPRESSION_LEVEL + " TEXT, "
			+ STRESS_LEVEL + " TEXT," + TIME + " TEXT," + DATE + " TEXT, "
			+ EXPORT_STATUS + " TEXT," + ALL_QUESTION_STATUS + " TEXT )";

	public DBHelper(Context context) {
		super(context, TABLE_NAME_PATIENT, null, VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("TABLE SQL", RRD_TABLE_SQL);
		db.execSQL(RRD_TABLE_SQL);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// UPGRADE LOGIC

	}

}
