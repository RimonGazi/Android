package net.sistransistomobile.datepicker;

import java.util.Calendar;


import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

public class MyTimePicker extends DialogFragment implements
		TimePickerDialog.OnTimeSetListener {
	TimeListener dateTimeListener;

	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		dateTimeListener = (TimeListener) getTargetFragment();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current time as the default values for the picker
		final Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		// Create a new instance of TimePickerDialog and return it
		return new TimePickerDialog(getActivity(), this, hour, minute,
				DateFormat.is24HourFormat(getActivity()));
	}

	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		dateTimeListener.time(hourOfDay + " : " + minute);
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		dateTimeListener.time(null);
	}

}
