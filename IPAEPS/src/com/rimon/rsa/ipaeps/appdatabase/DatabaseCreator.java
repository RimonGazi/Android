package com.rimon.rsa.ipaeps.appdatabase;

import android.content.Context;

public class DatabaseCreator {

	public static PpSettingModuleDBOpenHelper ppSettingModuleDBOpenHelper;
	public static PpPatientDBOpenHelper ppPatientDBOpenHelper;

	Context context;

	private DatabaseCreator(Context context) {
		this.context = context;
		
	}
	public  static void openAllDatabase(Context context){
		ppSettingModuleDBOpenHelper = new PpSettingModuleDBOpenHelper(context);
		ppPatientDBOpenHelper = new PpPatientDBOpenHelper(context);

	}

	public static PpSettingModuleDBOpenHelper getPpSettingModuleDBOpenHelper(
			Context cnt) {
		if (ppSettingModuleDBOpenHelper == null) {
			ppSettingModuleDBOpenHelper = new PpSettingModuleDBOpenHelper(cnt);
		}
		return ppSettingModuleDBOpenHelper;
	}

	public static PpPatientDBOpenHelper getPpPatientDBOpenHelper(Context context) {

		if (ppPatientDBOpenHelper == null) {
			ppPatientDBOpenHelper = new PpPatientDBOpenHelper(context);
		}
		return ppPatientDBOpenHelper;

	}

}
