package net.sistransitomobile.database;

import android.content.Context;

/**
 * 
 * @author Gazi
 * 
 *         The database create class create all database single tone object so
 *         the app run falster
 */
public class DatabaseCreator {
	public static final int VERSION = 1;
	private static SettingDatabaseAdapter databaseAdapterSetting;
	private static UserioDatabseAdapter databseAdapterUserio;
	private static PlacaSearchDatabaseAdapter placaSearchDatabaseAdapter;
	private static AutoInfracaoDatabaseAdapter databaseAdapterAutoInfracao;
	private static PrepopulatedDBOpenHelper prepopulatedDBOpenHelper;

	private DatabaseCreator(Context context) {
		openAllDatabase(context);

	}

	public static void openAllDatabase(Context context) {
		databaseAdapterSetting = new SettingDatabaseAdapter(context);
		databseAdapterUserio = new UserioDatabseAdapter(context);
		placaSearchDatabaseAdapter = new PlacaSearchDatabaseAdapter(context);
		databaseAdapterAutoInfracao = new AutoInfracaoDatabaseAdapter(context);
		prepopulatedDBOpenHelper = new PrepopulatedDBOpenHelper(context);

	}

	public static AutoInfracaoDatabaseAdapter getDatabaseAdapterAutoInfracao(
			Context context) {
		if (databaseAdapterAutoInfracao == null)
			databaseAdapterAutoInfracao = new AutoInfracaoDatabaseAdapter(
					context);
		return databaseAdapterAutoInfracao;
	}

	public static SettingDatabaseAdapter getDatabaseAdapterSetting(Context cnt) {
		if (databaseAdapterSetting == null) {
			databaseAdapterSetting = new SettingDatabaseAdapter(cnt);
		}
		return databaseAdapterSetting;
	}

	public static UserioDatabseAdapter getdDatabseAdapterUserio(Context context) {

		if (databseAdapterUserio == null) {
			databseAdapterUserio = new UserioDatabseAdapter(context);
		}
		return databseAdapterUserio;
	}

	public static PlacaSearchDatabaseAdapter getPlacaSearchDatabaseAdapter(
			Context context) {

		if (placaSearchDatabaseAdapter == null) {
			placaSearchDatabaseAdapter = new PlacaSearchDatabaseAdapter(context);
		}
		return placaSearchDatabaseAdapter;
	}

	public synchronized void close() {
		placaSearchDatabaseAdapter.close();
		databaseAdapterSetting.close();
		databseAdapterUserio.close();
		databaseAdapterAutoInfracao.close();
		prepopulatedDBOpenHelper.close();
	}

	public static PrepopulatedDBOpenHelper getPrepopulatedDBOpenHelper(
			Context context) {
		if (prepopulatedDBOpenHelper == null) {
			prepopulatedDBOpenHelper = new PrepopulatedDBOpenHelper(context);

		}
		return prepopulatedDBOpenHelper;
	}
}
