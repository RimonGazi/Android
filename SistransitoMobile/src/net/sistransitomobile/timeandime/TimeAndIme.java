package net.sistransitomobile.timeandime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.content.Context;
import android.telephony.TelephonyManager;

public class TimeAndIme {
	private Calendar calendar;
	private SimpleDateFormat sDatef;
	private SimpleDateFormat sTimef;
	private TelephonyManager mngr;

	public TimeAndIme(Context context) {
		mngr = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		calendar = Calendar.getInstance();
		sDatef = new SimpleDateFormat("dd/MMMM/yyyy", Locale.getDefault());

		sTimef = new SimpleDateFormat("hh:mm a", Locale.getDefault());
	}

	public String getTime() {
		return sTimef.format(calendar.getTime());
	}

	public String getDate() {
		return sDatef.format(calendar.getTime());
	}

	public String getUniqueId() {
		return mngr.getDeviceId() + String.valueOf(System.currentTimeMillis());
	}

	public String getIME() {
		return mngr.getDeviceId();
	}
}
