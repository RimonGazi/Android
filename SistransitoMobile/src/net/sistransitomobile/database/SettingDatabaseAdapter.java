package net.sistransitomobile.database;

import net.sistransito.timeandime.TimeAndIme;
import net.sistransitomobile.appconstant.AppConstants;
import net.sqlcipher.database.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class SettingDatabaseAdapter {
	private TimeAndIme ime;
	private SetttingDatabaseHelper databaseHelperSettting;
	private SQLiteDatabase database;

	public SettingDatabaseAdapter(Context context) {
		databaseHelperSettting = new SetttingDatabaseHelper(context);
		ime = new TimeAndIme(context);
		database = databaseHelperSettting.getWritableDatabase(ime.getIME());
		checkTable();
	}

	public String getFont() {
		Cursor cursor = database.query(
				SetttingDatabaseHelper.SETTING_TABLE_NAME, null, null, null,
				null, null, null);
		cursor.moveToFirst();
		String value=cursor.getString(cursor
				.getColumnIndex(SetttingDatabaseHelper.SETTING_FONT));
		cursor.close();
		return value;
	}

	public boolean setFont(String font) {

		ContentValues values = new ContentValues();
		values.put(SetttingDatabaseHelper.SETTING_RINGTONE, font);
		int check = database.update(SetttingDatabaseHelper.SETTING_TABLE_NAME,
				values, SetttingDatabaseHelper.SETTING_ID_FILED + "= ? ",
				new String[] { "1" });

		return check > 1;

	}

	public Boolean getAutobackup() {
		Cursor cursor = database.query(
				SetttingDatabaseHelper.SETTING_TABLE_NAME, null, null, null,
				null, null, null);
		cursor.moveToFirst();
		if ((cursor.getString(cursor
				.getColumnIndex(SetttingDatabaseHelper.SETTING_AUTO_BACKUP)))
				.equals(AppConstants.TRUE)) {
			cursor.close();
			return true;
		} else {
			cursor.close();
			return false;
		}
	}

	public Boolean getRingtone() {
		Cursor cursor = database.query(
				SetttingDatabaseHelper.SETTING_TABLE_NAME, null, null, null,
				null, null, null);
		cursor.moveToFirst();
		if ((cursor.getString(cursor
				.getColumnIndex(SetttingDatabaseHelper.SETTING_RINGTONE)))
				.equals(AppConstants.TRUE)) {
			cursor.close();
			return true;
		} else {
			cursor.close();
			return false;
		}
	}

	public Boolean getRemerberState() {
		Cursor cursor = database.query(
				SetttingDatabaseHelper.SETTING_TABLE_NAME, null, null, null,
				null, null, null);
		cursor.moveToFirst();
		if ((cursor.getString(cursor
				.getColumnIndex(SetttingDatabaseHelper.SETTING_REMEMBER)))
				.equals(AppConstants.TRUE)) {
			cursor.close();
			return true;
		} else {
			cursor.close();
			return false;
		}

	}

	public Boolean getPasswordState() {
		Cursor cursor = database.query(
				SetttingDatabaseHelper.SETTING_TABLE_NAME, null, null, null,
				null, null, null);
		cursor.moveToFirst();
		if ((cursor.getString(cursor
				.getColumnIndex(SetttingDatabaseHelper.SETTING_PASSWORD_STATE)))
				.equals(AppConstants.TRUE)) {
			cursor.close();
			return true;
		} else {
			cursor.close();
			return false;
		}

	}

	public Boolean getVibrator() {
		Cursor cursor = database.query(
				SetttingDatabaseHelper.SETTING_TABLE_NAME, null, null, null,
				null, null, null);
		cursor.moveToFirst();
		if ((cursor.getString(cursor
				.getColumnIndex(SetttingDatabaseHelper.SETTING_VIBRATOR)))
				.equals(AppConstants.TRUE)) {
			cursor.close();
			return true;
		} else {
			cursor.close();
			return false;
		}
	}

	public void setVibrator(boolean check) {
		String value;
		if (check) {
			value = AppConstants.TRUE;
		} else {
			value = AppConstants.FALSE;
		}
		ContentValues values = new ContentValues();
		values.put(SetttingDatabaseHelper.SETTING_VIBRATOR, value);
		int w = database.update(SetttingDatabaseHelper.SETTING_TABLE_NAME,
				values, SetttingDatabaseHelper.SETTING_ID_FILED + "= ? ",
				new String[] { "1" });
		Log.d("qqqqqqqqqqqqqqqqqqqqqqqqq", w + "");

	}

	public void setRingtone(boolean check) {
		String value;
		if (check) {
			value = AppConstants.TRUE;
		} else {
			value = AppConstants.FALSE;
		}
		ContentValues values = new ContentValues();
		values.put(SetttingDatabaseHelper.SETTING_RINGTONE, value);
		database.update(SetttingDatabaseHelper.SETTING_TABLE_NAME, values,
				SetttingDatabaseHelper.SETTING_ID_FILED + "= ? ",
				new String[] { "1" });

	}

	public void setAutobackup(boolean check) {
		String value;
		if (check) {
			value = AppConstants.TRUE;
		} else {
			value = AppConstants.FALSE;
		}
		ContentValues values = new ContentValues();
		values.put(SetttingDatabaseHelper.SETTING_AUTO_BACKUP, value);
		database.update(SetttingDatabaseHelper.SETTING_TABLE_NAME, values,
				SetttingDatabaseHelper.SETTING_ID_FILED + "= ? ",
				new String[] { "1" });

	}

	public void setRemerberState(boolean check) {
		String value;
		if (check) {
			value = AppConstants.TRUE;
		} else {
			value = AppConstants.FALSE;
		}
		ContentValues values = new ContentValues();
		values.put(SetttingDatabaseHelper.SETTING_REMEMBER, value);
		database.update(SetttingDatabaseHelper.SETTING_TABLE_NAME, values,
				SetttingDatabaseHelper.SETTING_ID_FILED + "= ? ",
				new String[] { "1" });
	}

	public void setPasswordState(boolean check) {
		String value;
		if (check) {
			value = AppConstants.TRUE;
		} else {
			value = AppConstants.FALSE;
		}
		ContentValues values = new ContentValues();
		values.put(SetttingDatabaseHelper.SETTING_PASSWORD_STATE, value);
		database.update(SetttingDatabaseHelper.SETTING_TABLE_NAME, values,
				SetttingDatabaseHelper.SETTING_ID_FILED + "= ? ",
				new String[] { "1" });
	}

	private void checkTable() {

		Cursor mcursor = database.rawQuery("SELECT count(*) FROM "
				+ SetttingDatabaseHelper.SETTING_TABLE_NAME, null);

		mcursor.moveToFirst();
		int icount = mcursor.getInt(0);
		if (icount > 0) {
			mcursor.close();
			return;
		} else {

			ContentValues values = new ContentValues();
			values.put(SetttingDatabaseHelper.SETTING_ID_FILED, "1");

			values.put(SetttingDatabaseHelper.SETTING_AUTO_BACKUP,
					AppConstants.TRUE);

			values.put(SetttingDatabaseHelper.SETTING_VIBRATOR,
					AppConstants.TRUE);
			values.put(SetttingDatabaseHelper.SETTING_RINGTONE,
					AppConstants.TRUE);

			values.put(SetttingDatabaseHelper.SETTING_REMEMBER,
					AppConstants.FALSE);
			values.put(SetttingDatabaseHelper.SETTING_PASSWORD_STATE,
					AppConstants.FALSE);
			values.put(SetttingDatabaseHelper.SETTING_FONT, AppConstants.FONT_1);
			database.insert(SetttingDatabaseHelper.SETTING_TABLE_NAME, null,
					values);
			mcursor.close();
		}
	}

	public synchronized void close() {
		database.close();
	}

}
