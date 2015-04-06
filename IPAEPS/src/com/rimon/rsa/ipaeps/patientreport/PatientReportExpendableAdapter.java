package com.rimon.rsa.ipaeps.patientreport;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpPatientDBOpenHelper;
import com.rimon.rsa.ipaeps.button.AnyButtonWithTitleText;
import com.rimon.rsa.ipaeps.patientlog.LogTextFormatWithSpan;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.textview.TitleTextView;

public class PatientReportExpendableAdapter extends CursorTreeAdapter {
	private LayoutInflater mInflator;
	private Context context;
	private PateintListener listener;
	private LogTextFormatWithSpan textFormat;

	public PatientReportExpendableAdapter(Cursor cursor, Context context) {
		super(cursor, context);
		this.context = context;
		mInflator = LayoutInflater.from(context);
		listener = (PatientReport) context;

	}

	@Override
	protected void bindChildView(View arg0, Context arg1, Cursor arg2,
			boolean arg3) {

	}

	@Override
	protected void bindGroupView(View view, Context context, Cursor cursor,
			boolean isExpanded) {
		TitleTextView patient_id, gs_id, date, time;
		patient_id = (TitleTextView) view.findViewById(R.id.patient_id);
		gs_id = (TitleTextView) view.findViewById(R.id.gs_id);
		date = (TitleTextView) view.findViewById(R.id.date);
		time = (TitleTextView) view.findViewById(R.id.time);
		patient_id.setText(cursor.getString(cursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_1)));
			gs_id.setText(cursor.getString(cursor
					.getColumnIndex(PpPatientDBOpenHelper.q_module_1_2))+", "+cursor.getString(cursor
							.getColumnIndex(PpPatientDBOpenHelper.q_module_1_3)));
		
		date.setText(cursor.getString(cursor
				.getColumnIndex(PpPatientDBOpenHelper.date)));
		time.setText(cursor.getString(cursor
				.getColumnIndex(PpPatientDBOpenHelper.time)));

	}

	@Override
	protected Cursor getChildrenCursor(Cursor groupCursor) {
		int groupId = groupCursor.getInt(groupCursor
				.getColumnIndex(PpPatientDBOpenHelper.database_id));

		PpPatientDBOpenHelper ppPatientDBOpenHelper = DatabaseCreator
				.getPpPatientDBOpenHelper(context);
		return ppPatientDBOpenHelper.getAllPatientCursorFromID(groupId);
	}

	@Override
	protected View newChildView(Context arg0, Cursor arg1, boolean arg2,
			ViewGroup arg3) {
		return null;
	}

	@Override
	protected View newGroupView(Context context, Cursor cursor,
			boolean isExpanded, ViewGroup parent) {

		View view = mInflator.inflate(R.layout.log_spendable_parent, null);
		TitleTextView patient_id, gs_id, date, time;
		patient_id = (TitleTextView) view.findViewById(R.id.patient_id);
		gs_id = (TitleTextView) view.findViewById(R.id.gs_id);
		date = (TitleTextView) view.findViewById(R.id.date);
		time = (TitleTextView) view.findViewById(R.id.time);
		patient_id.setText(cursor.getString(cursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_1)));
		gs_id.setText(cursor.getString(cursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_2)));
		date.setText(cursor.getString(cursor
				.getColumnIndex(PpPatientDBOpenHelper.date)));
		time.setText(cursor.getString(cursor
				.getColumnIndex(PpPatientDBOpenHelper.time)));
		return view;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View view, ViewGroup parent) {
		AnyButtonWithTitleText btn_save, btn_print;
		AnyTextView q_module_2, q_module_3, q_module_4, q_module_5, q_module_6, q_module_7, q_module_8, q_module_9, q_module_10, q_module_11, q_module_12, q_module_13, q_module_14, q_module_15;

		final int gp = groupPosition;
		view = mInflator.inflate(R.layout.patient_spendable_list_child, null);

		btn_print = (AnyButtonWithTitleText) view.findViewById(R.id.btn_print);
		btn_save = (AnyButtonWithTitleText) view.findViewById(R.id.btn_save);

		btn_print.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onCallBack(true, false, getGroup(gp));
			}
		});

		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onCallBack(false, true, getGroup(gp));
			}
		});

		q_module_2 = (AnyTextView) view.findViewById(R.id.q_module_2);
		q_module_3 = (AnyTextView) view.findViewById(R.id.q_module_3);
		q_module_4 = (AnyTextView) view.findViewById(R.id.q_module_4);
		q_module_5 = (AnyTextView) view.findViewById(R.id.q_module_5);
		q_module_6 = (AnyTextView) view.findViewById(R.id.q_module_6);
		q_module_7 = (AnyTextView) view.findViewById(R.id.q_module_7);
		q_module_8 = (AnyTextView) view.findViewById(R.id.q_module_8);
		q_module_9 = (AnyTextView) view.findViewById(R.id.q_module_9);
		q_module_10 = (AnyTextView) view.findViewById(R.id.q_module_10);
		q_module_11 = (AnyTextView) view.findViewById(R.id.q_module_11);
		q_module_12 = (AnyTextView) view.findViewById(R.id.q_module_12);
		q_module_13 = (AnyTextView) view.findViewById(R.id.q_module_13);
		q_module_14 = (AnyTextView) view.findViewById(R.id.q_module_14);
		q_module_15 = (AnyTextView) view.findViewById(R.id.q_module_15);

		textFormat = new LogTextFormatWithSpan(context, getGroup(groupPosition));

		q_module_2.setText(textFormat.getQuestion_2());
		q_module_3.setText(textFormat.getQuestion_3());
		q_module_4.setText(textFormat.getQuestion_4());
		q_module_5.setText(textFormat.getQuestion_5());
		q_module_6.setText(textFormat.getQuestion_6());
		q_module_7.setText(textFormat.getQuestion_7());
		q_module_8.setText(textFormat.getQuestion_8());
		q_module_9.setText(textFormat.getQuestion_9());
		q_module_10.setText(textFormat.getQuestion_10());
		q_module_11.setText(textFormat.getQuestion_11());
		q_module_12.setText(textFormat.getQuestion_12());
		q_module_13.setText(textFormat.getQuestion_13());
		q_module_14.setText(textFormat.getQuestion_14());
		q_module_15.setText(textFormat.getQuestion_15());
		return view;
	}

}
