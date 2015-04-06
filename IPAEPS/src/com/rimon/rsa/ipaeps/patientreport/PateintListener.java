package com.rimon.rsa.ipaeps.patientreport;

import android.database.Cursor;

public interface PateintListener {
	public void onCallBack(boolean isPrint, boolean isSave,
			Cursor dataCursor);

}
