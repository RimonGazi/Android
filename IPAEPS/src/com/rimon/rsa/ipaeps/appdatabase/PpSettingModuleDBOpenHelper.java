package com.rimon.rsa.ipaeps.appdatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.rimon.rsa.ipaes.setting.ModuleSettingData;

public class PpSettingModuleDBOpenHelper extends SQLiteOpenHelper {

	public static final String SETTING_MODULE_DB_NAME = "setting.db";// "off_veiculos.sqlite";
	public static String DB_PATH;
	private SQLiteDatabase database;
	private Context context;
	// table name
	public static final String SETTING_TABLE_NAME = "appsetting";
	// SETTTING DATABSE COLUMEN NAME
	public static final String ID = "id";
	public static final String MOFULE_ORDER_1 = "module_order_1";
	public static final String MOFULE_ORDER_2 = "module_order_2";
	public static final String MOFULE_ORDER_3 = "module_order_3";
	public static final String MOFULE_ORDER_4 = "module_order_4";
	public static final String MOFULE_ORDER_5 = "module_order_5";
	public static final String MOFULE_ORDER_6 = "module_order_6";
	public static final String MOFULE_ORDER_7 = "module_order_7";
	public static final String MOFULE_ORDER_8 = "module_order_8";
	public static final String MOFULE_ORDER_9 = "module_order_9";
	public static final String MOFULE_ORDER_10 = "module_order_10";
	public static final String MOFULE_ORDER_11 = "module_order_11";
	public static final String MOFULE_ORDER_12 = "module_order_12";
	public static final String MOFULE_ORDER_13 = "module_order_13";
	public static final String MOFULE_ORDER_14 = "module_order_14";
	public static final String MOFULE_ORDER_15 = "module_order_15";
	public static final String MOFULE_ORDER_16 = "module_order_16";
	public static final String RUN_STATE = "run_state";
	public static final String PRESET_NUMBER = "preset_number";
	public static final String PASSWORD = "password";
	public static final String FONT = "font";

	public PpSettingModuleDBOpenHelper(Context context) {
		super(context, SETTING_MODULE_DB_NAME, null, 1);
		this.context = context;
		DB_PATH = context.getDatabasePath(SETTING_MODULE_DB_NAME).toString();
		this.database = openDatabase();

	}

	public SQLiteDatabase getDatabase() {
		return this.database;
	}

	public SQLiteDatabase openDatabase() {
		String path = DB_PATH + SETTING_MODULE_DB_NAME;
		if (database == null) {
			createDatabase();
			database = SQLiteDatabase.openDatabase(path, null,
					SQLiteDatabase.OPEN_READWRITE);

		}
		return database;
	}

	private void createDatabase() {
		boolean dbExists = checkDB();
		if (!dbExists) {
			this.getWritableDatabase();
			Log.e(getClass().getName(),
					"Database doesn't exist. Copying database from assets...");
			copyDatabase();
		} else {
			Log.e(getClass().getName(), "Database already exists");
		}
	}

	private void copyDatabase() {
		try {
			InputStream dbInputStream = context.getAssets().open(
					SETTING_MODULE_DB_NAME);
			String path = DB_PATH + SETTING_MODULE_DB_NAME;
			OutputStream dbOutputStream = new FileOutputStream(path);
			byte[] buffer = new byte[4096];
			int readCount = 0;
			while ((readCount = dbInputStream.read(buffer)) > 0) {
				dbOutputStream.write(buffer, 0, readCount);
			}

			dbInputStream.close();
			dbOutputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean checkDB() {
		String path = DB_PATH + SETTING_MODULE_DB_NAME;
		File file = new File(path);
		if (file.exists()) {
			Log.e(getClass().getName(), "Database already exists");
			return true;
		}
		Log.e(getClass().getName(), "Database does not exists");
		return false;
	}

	public synchronized void close() {
		if (this.database != null) {
			this.database.close();
		}
	}

	public String getPassword() {
		Cursor myCursor = this.database.query(SETTING_TABLE_NAME,
				new String[] { PASSWORD }, ID + "=?", new String[] { "1" },
				null, null, null);
		myCursor.moveToFirst();
		return myCursor.getString(myCursor.getColumnIndex(PASSWORD));
	}

	public boolean setPassword(String password) {
		ContentValues values = new ContentValues();
		values.put(PASSWORD, password);
		return this.database.update(SETTING_TABLE_NAME, values, ID + "= ? ",
				new String[] { "1" }) > 0;

	}

	public String getFont() {
		Cursor myCursor = this.database.query(SETTING_TABLE_NAME,
				new String[] { FONT }, ID + "=?", new String[] { "1" }, null,
				null, null);
		myCursor.moveToFirst();
		Log.d("hhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
				myCursor.getString(myCursor.getColumnIndex(FONT)));
		return myCursor.getString(myCursor.getColumnIndex(FONT));
	}

	public boolean setFont(String font) {
		ContentValues values = new ContentValues();
		values.put(FONT, font);
		return this.database.update(SETTING_TABLE_NAME, values, ID + "= ? ",
				new String[] { "1" }) > 0;

	}

	public ModuleSettingData getModuleSettingData() {

		Cursor myCursor = this.database.query(SETTING_TABLE_NAME, null, ID
				+ "=?", new String[] { "1" }, null, null, null);

		// Log.d("courser ", myCursor.getCount() + "");

		if (myCursor.getCount() > 0) {
			myCursor.moveToFirst();

			// Log.d("1",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_1))
			// + "");
			//
			// Log.d("2",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_2))
			// + "");
			// Log.d("3",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_3))
			// + "");
			// Log.d("4",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_4))
			// + "");
			// Log.d("5",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_5))
			// + "");
			// Log.d("6",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_6))
			// + "");
			// Log.d("7",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_7))
			// + "");
			// Log.d("8",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_8))
			// + "");
			// Log.d("9",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_9))
			// + "");
			// Log.d("10",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_10))
			// + "");
			// Log.d("11",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_11))
			// + "");
			// Log.d("12",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_12))
			// + "");
			// Log.d("13",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_13))
			// + "");
			// Log.d("14",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_14))
			// + "");
			// Log.d("15",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_15))
			// + "");
			// Log.d("16",
			// myCursor.getInt(myCursor.getColumnIndex(MOFULE_ORDER_16))
			// + "");
			// Log.d("apps", myCursor.getInt(myCursor.getColumnIndex(RUN_STATE))
			// + "");
			// Log.d("preset number",
			// myCursor.getInt(myCursor.getColumnIndex(PRESET_NUMBER))
			// + "");
			return new ModuleSettingData(myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_1)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_2)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_3)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_4)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_5)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_6)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_7)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_8)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_9)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_10)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_11)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_12)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_13)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_14)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_15)), myCursor.getInt(myCursor
					.getColumnIndex(MOFULE_ORDER_16)), myCursor.getInt(myCursor
					.getColumnIndex(RUN_STATE)), myCursor.getInt(myCursor
					.getColumnIndex(PRESET_NUMBER)));

		} else {
			return null;
		}
	}

	public boolean setDefaultModuleData(ModuleSettingData appSetting) {
		Log.d("1oooooooooo", appSetting.getModule_order_1() + "");
		Log.d("1oooooooooo", appSetting.getModule_order_16() + "");
		ContentValues values = new ContentValues();
		values.put(MOFULE_ORDER_1, appSetting.getModule_order_1());
		values.put(MOFULE_ORDER_2, appSetting.getModule_order_2());
		values.put(MOFULE_ORDER_3, appSetting.getModule_order_3());
		values.put(MOFULE_ORDER_4, appSetting.getModule_order_4());
		values.put(MOFULE_ORDER_5, appSetting.getModule_order_5());
		values.put(MOFULE_ORDER_6, appSetting.getModule_order_6());
		values.put(MOFULE_ORDER_7, appSetting.getModule_order_7());
		values.put(MOFULE_ORDER_8, appSetting.getModule_order_8());
		values.put(MOFULE_ORDER_9, appSetting.getModule_order_9());
		values.put(MOFULE_ORDER_10, appSetting.getModule_order_10());
		values.put(MOFULE_ORDER_11, appSetting.getModule_order_11());
		values.put(MOFULE_ORDER_12, appSetting.getModule_order_12());
		values.put(MOFULE_ORDER_13, appSetting.getModule_order_13());
		values.put(MOFULE_ORDER_14, appSetting.getModule_order_14());
		values.put(MOFULE_ORDER_15, appSetting.getModule_order_15());
		values.put(MOFULE_ORDER_16, appSetting.getModule_order_16());
		values.put(RUN_STATE, appSetting.getRun_state());
		values.put(PRESET_NUMBER, appSetting.getPreset_number());

		this.database.update(SETTING_TABLE_NAME, values, ID + "= ? ",
				new String[] { "1" });

		return this.database.update(SETTING_TABLE_NAME, values, ID + "= ? ",
				new String[] { "1" }) > 0;

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
