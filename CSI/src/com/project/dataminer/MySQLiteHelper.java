package com.project.dataminer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "dataminer";
	private static final int DATABASE_VERSION = 1;
	public static final String UPDATE_STATUS_USER = "update_status_user";
	public static final String UPDATE_STATUS_DATA = "update_status_data";
	public static final String GENDER = "gender";
	public static final String JOB = "job";
	public static final String ID_DATA_EXTEA = "id_data";
	public static final String COMMON_CID = "common_cid";

	private static final String USER_CREATE = "create table user "
			+ "(_id integer primary key autoincrement, "
			+ "name text not null, " + "lname text not null, "
			+ "dob text not null, " + "nname text not null, "
			+ "done integer not null, " + "cid text not null, "
			+ "addr1 text not null, " + "addr2 text not null, "
			+ "addr3 text not null, " + UPDATE_STATUS_USER + " text not null, "
			+ GENDER + " text not null);";
	private static final String DATA_CREATE = "create table data "
			+ "(_id int not null, " + "_no integer not null, "
			+ "ans11 integer not null, " + "ans12 integer not null, "
			+ "ans13 integer not null, " + "ans21 integer not null, "
			+ "ans22 integer not null, " + "ans23 integer not null, "
			+ "ans24 integer not null, " + "ans25 integer not null, "
			+ "ans26 integer not null, " + "ans31 integer not null, "
			+ "ans32 integer not null, " + "ans33 integer not null, "
			+ "ans34 integer not null, " + "ans35 integer not null, "
			+ "ans41 integer not null, " + "ans42 integer not null, "
			+ "ans43 integer not null, " + "ans51 integer not null, "
			+ "ans52 integer not null, " + "ans53 integer not null, "
			+ "ans54 integer not null, " + "ans61 integer not null, "
			+ "ans62 integer not null, " + "saved integer not null, "
			+ "care text, " + "careage text, " + "carerelate text, "
			+ "carelong text, " + "with018 text, " + "with18up text, "
			+ "withd018 text, " + "withd18up text, " + "withs018 text, "
			+ "withs18up text, " + "event text, " + "q1h1 integer, "
			+ "q1h2 integer, " + "q1h3 integer, " + "q1h4 integer, "
			+ "q2h1 integer, " + "q2h2 integer, " + "q2h3 integer, "
			+ "q2h4 integer, " + "q2h5 integer, " + "q2h6 integer, "
			+ "q3h1 integer, " + "q3h2 integer, " + "q3h3 integer, "
			+ "q4h1 integer, " + "q4h2 integer, " + "q4h3 integer, "
			+ "q5h1 integer, " + "q5h2 integer, " + "q6h1 integer, "
			+ "q6h2 integer, " + "timebegin text, " + "timeend text, "
			+ UPDATE_STATUS_DATA + " text, " + COMMON_CID + " text, " + JOB
			+ " text, " + ID_DATA_EXTEA + " text );";//, " + "PRIMARY KEY (_id));";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(USER_CREATE);
		db.execSQL(DATA_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
