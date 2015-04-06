package net.sistransistomobile.datepicker;

import java.util.Calendar;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

public class MyDatePicker extends DialogFragment implements
		DatePickerDialog.OnDateSetListener {

	DateListener dateTimeListener;
	
	@Override
	public void onCancel(DialogInterface dialog) {
		dateTimeListener.date(null);
		super.onCancel(dialog);
	}

	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		dateTimeListener = (DateListener) getTargetFragment();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker

		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	public void onDateSet(DatePicker view, int year, int month, int day) {
		dateTimeListener.date(day + "/" + month + "/" + year);
	}
}
