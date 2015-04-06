package com.rimon.rsa.ipaeps.patientlog;

import android.database.Cursor;

public interface LogListener {
	public void onCallBack(boolean isPrint, boolean isSave, boolean isExport,
			Cursor dataCursor);

}
