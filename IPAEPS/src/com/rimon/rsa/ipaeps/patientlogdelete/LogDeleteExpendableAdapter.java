package com.rimon.rsa.ipaeps.patientlogdelete;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;
import android.widget.ImageView;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpPatientDBOpenHelper;
import com.rimon.rsa.ipaeps.textview.TitleTextView;

public class LogDeleteExpendableAdapter extends CursorTreeAdapter {
	private LayoutInflater mInflator;
	private Context context;

	public static String idNumber[];
	public static boolean chnageState = false;
	public static boolean[] selectedStatus;

	public LogDeleteExpendableAdapter(Cursor cursor, Context context) {
		super(cursor, context);
		this.context = context;
		mInflator = LayoutInflater.from(context);
		idNumber = new String[cursor.getCount()];
		selectedStatus = new boolean[cursor.getCount()];
		for (int i = 0; i < cursor.getCount(); i++) {
			selectedStatus[i] = false;
			idNumber[i] = "";
		}
	}
//
//	@Override
//	protected void bindChildView(View arg0, Context arg1, Cursor arg2,
//			boolean arg3) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void bindGroupView(View view, Context context, Cursor cursor,
//			boolean isExpanded) {
//		ImageView im_delete;
//		TitleTextView patient_id, gs_id, date, time;
//		patient_id = (TitleTextView) view.findViewById(R.id.patient_id);
//		gs_id = (TitleTextView) view.findViewById(R.id.gs_id);
//		date = (TitleTextView) view.findViewById(R.id.date);
//		time = (TitleTextView) view.findViewById(R.id.time);
//		patient_id.setText(cursor.getString(cursor
//				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_1)));
//		gs_id.setText(cursor.getString(cursor
//				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_2)));
//		date.setText(cursor.getString(cursor
//				.getColumnIndex(PpPatientDBOpenHelper.date)));
//		time.setText(cursor.getString(cursor
//				.getColumnIndex(PpPatientDBOpenHelper.time)));
//		im_delete = (ImageView) view.findViewById(R.id.im_delete);
//
//	}

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

	// @Override
	// protected View newGroupView(Context context, Cursor cursor,
	// boolean isExpanded, ViewGroup parent) {
	// View view = mInflator.inflate(R.layout.log_delete_spendable_parent,
	// null);
	// TitleTextView patient_id, gs_id, date, time;
	// final ImageView im_delete;
	// patient_id = (TitleTextView) view.findViewById(R.id.patient_id);
	// gs_id = (TitleTextView) view.findViewById(R.id.gs_id);
	// date = (TitleTextView) view.findViewById(R.id.date);
	// time = (TitleTextView) view.findViewById(R.id.time);
	// patient_id.setText(cursor.getString(cursor
	// .getColumnIndex(PpPatientDBOpenHelper.q_module_1_1)));
	// gs_id.setText(cursor.getString(cursor
	// .getColumnIndex(PpPatientDBOpenHelper.q_module_1_2)));
	// date.setText(cursor.getString(cursor
	// .getColumnIndex(PpPatientDBOpenHelper.date)));
	// time.setText(cursor.getString(cursor
	// .getColumnIndex(PpPatientDBOpenHelper.time)));
	//
	// im_delete = (ImageView) view.findViewById(R.id.im_delete);
	// return view;
	// }

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View view,
			ViewGroup parent) {
		final int position = groupPosition;
		view = mInflator.inflate(R.layout.log_delete_spendable_parent, null);
		TitleTextView patient_id, gs_id, date, time;
		final ImageView im_delete;
		patient_id = (TitleTextView) view.findViewById(R.id.patient_id);
		gs_id = (TitleTextView) view.findViewById(R.id.gs_id);
		date = (TitleTextView) view.findViewById(R.id.date);
		time = (TitleTextView) view.findViewById(R.id.time);
		patient_id.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(
						PpPatientDBOpenHelper.q_module_1_1)));
		gs_id.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(
						PpPatientDBOpenHelper.q_module_1_2)));
		date.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(
						PpPatientDBOpenHelper.date)));
		time.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(
						PpPatientDBOpenHelper.time)));

		im_delete = (ImageView) view.findViewById(R.id.im_delete);
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (selectedStatus[position]) {
					selectedStatus[position] = false;
					im_delete.setImageResource(R.drawable.ic_unchecked);
					idNumber[position] = "";
				} else {
					selectedStatus[position] = true;
					im_delete.setImageResource(R.drawable.ic_checked);
					idNumber[position] = (getGroup(position)
							.getString(getGroup(position).getColumnIndex(
									PpPatientDBOpenHelper.database_id)))
							.toString();

				}
			}
		});
		if (selectedStatus[position]) {

			im_delete.setImageResource(R.drawable.ic_checked);
			idNumber[position] = (getGroup(position)
					.getString(getGroup(position).getColumnIndex(
							PpPatientDBOpenHelper.database_id))).toString();

		} else {
			im_delete.setImageResource(R.drawable.ic_unchecked);
			idNumber[position] = "";

		}
		if (chnageState == true) {
			for (int i = 0; i < idNumber.length; i++) {
				if (selectedStatus[i]) {
					idNumber[i] = (getGroup(i).getString(getGroup(i)
							.getColumnIndex(PpPatientDBOpenHelper.database_id)))
							.toString();

				} else {
					idNumber[i] = "";
				}
			}

			chnageState = false;
		}
		return view;
	}

	@Override
	protected void bindChildView(View view, Context context, Cursor cursor,
			boolean isLastChild) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void bindGroupView(View view, Context context, Cursor cursor,
			boolean isExpanded) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected View newGroupView(Context context, Cursor cursor,
			boolean isExpanded, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
