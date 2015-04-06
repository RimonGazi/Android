package com.rimon.rsa.ibd.log;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorTreeAdapter;
import android.widget.TextView;

import com.rimon.rsa.ibd.database.DBHelper;
import com.rimon.rsa.ibd.export.PatientData;
import com.rimon.rsa.mental.R;

public class ExpendableAdapter extends CursorTreeAdapter {
	LayoutInflater mInflator;
	Context context;
	PrintCallback print_call_back;
	SaveCallback saveCallback;
	ExportCallback exportCallback;

	public ExpendableAdapter(Cursor cursor, Context con) {
		super(cursor, con);
		context = con;
		mInflator = LayoutInflater.from(context);
		print_call_back = (PrintCallback) context;
		exportCallback = (ExportCallback) context;
		saveCallback = (SaveCallback) context;
	}

	@Override
	protected void bindChildView(View view, Context context, Cursor cursor,
			boolean isLastChild) {
		TextView pq_4, pq_5, pq_6, pq_7, pq_8, pq_9, pq_10, pq_11, pq_12, pq_13, pq_14, pq_15, pq_16, pq_17, pq_18, pq_19, pq_20, pq_21, pq_22, pq_23, pq_24, pq_25, pq_26, pq_27, pq_28, pq_29, pq_30, pq_31, pq_32, pq_33, pq_34, pq_35, pq_36, pq_37;
		TextView pfq_1, pfq_2, pfq_3, pfq_4, pfq_5, pfq_6, pfq_7, pfq_8, pfq_9, pfq_10, pfq_11, pfq_12, pfq_13, pfq_14, pfq_15, pfq_16, pfq_17;
		@SuppressWarnings("unused")
		Button btn_print, btn_export, btn_save;
		TextView tv_stress, tv_anxiety, tv_depression;

		TextView tv_stress_level, tv_anxiety_level, tv_depression_level;

		tv_stress_level = (TextView) view.findViewById(R.id.log_stress_level);
		tv_anxiety_level = (TextView) view.findViewById(R.id.log_anxiety_level);
		tv_depression_level = (TextView) view
				.findViewById(R.id.log_depression_level);

		tv_stress = (TextView) view.findViewById(R.id.log_stress);
		tv_anxiety = (TextView) view.findViewById(R.id.log_anxiety);
		tv_depression = (TextView) view.findViewById(R.id.log_depression);

		btn_print = (Button) view.findViewById(R.id.log_print);
		btn_export = (Button) view.findViewById(R.id.log_export);

		btn_save = (Button) view.findViewById(R.id.log_save_all_question);
		pq_4 = (TextView) view.findViewById(R.id.pq_4);
		pq_5 = (TextView) view.findViewById(R.id.pq_5);
		pq_6 = (TextView) view.findViewById(R.id.pq_6);
		pq_7 = (TextView) view.findViewById(R.id.pq_7);
		pq_8 = (TextView) view.findViewById(R.id.pq_8);
		pq_9 = (TextView) view.findViewById(R.id.pq_9);
		pq_10 = (TextView) view.findViewById(R.id.pq_10);
		pq_11 = (TextView) view.findViewById(R.id.pq_11);
		pq_12 = (TextView) view.findViewById(R.id.pq_12);
		pq_13 = (TextView) view.findViewById(R.id.pq_13);
		pq_14 = (TextView) view.findViewById(R.id.pq_14);
		pq_15 = (TextView) view.findViewById(R.id.pq_15);
		pq_16 = (TextView) view.findViewById(R.id.pq_16);
		pq_17 = (TextView) view.findViewById(R.id.pq_17);
		pq_18 = (TextView) view.findViewById(R.id.pq_18);
		pq_19 = (TextView) view.findViewById(R.id.pq_19);
		pq_20 = (TextView) view.findViewById(R.id.pq_20);
		pq_21 = (TextView) view.findViewById(R.id.pq_21);
		pq_22 = (TextView) view.findViewById(R.id.pq_22);
		pq_23 = (TextView) view.findViewById(R.id.pq_23);
		pq_24 = (TextView) view.findViewById(R.id.pq_24);
		pq_25 = (TextView) view.findViewById(R.id.pq_25);
		pq_26 = (TextView) view.findViewById(R.id.pq_26);
		pq_27 = (TextView) view.findViewById(R.id.pq_27);
		pq_28 = (TextView) view.findViewById(R.id.pq_28);
		pq_29 = (TextView) view.findViewById(R.id.pq_29);
		pq_30 = (TextView) view.findViewById(R.id.pq_30);
		pq_31 = (TextView) view.findViewById(R.id.pq_31);
		pq_32 = (TextView) view.findViewById(R.id.pq_32);
		pq_33 = (TextView) view.findViewById(R.id.pq_33);
		pq_34 = (TextView) view.findViewById(R.id.pq_34);
		pq_35 = (TextView) view.findViewById(R.id.pq_35);
		pq_36 = (TextView) view.findViewById(R.id.pq_36);
		pq_37 = (TextView) view.findViewById(R.id.pq_37);

		pfq_1 = (TextView) view.findViewById(R.id.pfq_1);
		pfq_2 = (TextView) view.findViewById(R.id.pfq_2);
		pfq_3 = (TextView) view.findViewById(R.id.pfq_3);
		pfq_4 = (TextView) view.findViewById(R.id.pfq_4);
		pfq_5 = (TextView) view.findViewById(R.id.pfq_5);
		pfq_6 = (TextView) view.findViewById(R.id.pfq_6);
		pfq_7 = (TextView) view.findViewById(R.id.pfq_7);
		pfq_8 = (TextView) view.findViewById(R.id.pfq_8);
		pfq_9 = (TextView) view.findViewById(R.id.pfq_9);
		pfq_10 = (TextView) view.findViewById(R.id.pfq_10);
		pfq_11 = (TextView) view.findViewById(R.id.pfq_11);
		pfq_12 = (TextView) view.findViewById(R.id.pfq_12);
		pfq_13 = (TextView) view.findViewById(R.id.pfq_13);
		pfq_14 = (TextView) view.findViewById(R.id.pfq_14);
		pfq_15 = (TextView) view.findViewById(R.id.pfq_15);
		pfq_16 = (TextView) view.findViewById(R.id.pfq_16);
		pfq_17 = (TextView) view.findViewById(R.id.pfq_17);

		tv_stress.setText(context.getResources().getString(R.string.stress)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.STRESS)));
		tv_anxiety.setText(context.getResources().getString(R.string.anxiety)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.ANXIETY)));
		tv_depression.setText(context.getResources().getString(
				R.string.depression)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.DEPRESSION)));

		tv_stress_level
				.setText(context.getResources().getString(
						R.string.stress_severity_level)
						+ "\n\n"
						+ cursor.getString(cursor
								.getColumnIndex(DBHelper.STRESS_LEVEL)));
		tv_anxiety_level.setText(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.ANXIETY_LEVEL)));
		tv_depression_level.setText(context.getResources().getString(
				R.string.depression_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.DEPRESSION_LEVEL)));

		pq_4.setText(context.getResources().getString(R.string.patient_q_4)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_4)));

		pq_5.setText(context.getResources().getString(R.string.patient_q_5)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_5)));

		pq_6.setText(context.getResources().getString(R.string.patient_q_6)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_6)));

		pq_7.setText(context.getResources().getString(R.string.patient_q_7)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_7)));

		pq_8.setText(context.getResources().getString(R.string.patient_q_8)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_8)));

		pq_9.setText(context.getResources().getString(R.string.patient_q_9)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_9)));

		pq_10.setText(context.getResources().getString(R.string.patient_q_10)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_10)));

		pq_11.setText(context.getResources().getString(R.string.patient_q_11)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_11)));

		pq_12.setText(context.getResources().getString(R.string.patient_q_12)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_12)));

		pq_13.setText(context.getResources().getString(R.string.patient_q_13)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_13)));

		pq_14.setText(context.getResources().getString(R.string.patient_q_14)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_14)));

		pq_15.setText(context.getResources().getString(R.string.patient_q_15)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_15)));

		pq_16.setText(context.getResources().getString(R.string.patient_q_16)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_16)));

		pq_17.setText(context.getResources().getString(R.string.patient_q_17)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_17)));

		pq_18.setText(context.getResources().getString(R.string.patient_q_18)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_18)));

		pq_19.setText(context.getResources().getString(R.string.patient_q_19)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_19)));

		pq_20.setText(context.getResources().getString(R.string.patient_q_20)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_20)));

		pq_21.setText(context.getResources().getString(R.string.patient_q_21)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_21)));

		pq_22.setText(context.getResources().getString(R.string.patient_q_22)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_22)));

		pq_23.setText(context.getResources().getString(R.string.patient_q_23)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_23)));

		pq_24.setText(context.getResources().getString(R.string.patient_q_24)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_24)));

		pq_25.setText(context.getResources().getString(R.string.patient_q_25)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_25)));

		pq_26.setText(context.getResources().getString(R.string.patient_q_26)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_26)));

		pq_27.setText(context.getResources().getString(R.string.patient_q_27)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_27)));

		pq_28.setText(context.getResources().getString(R.string.patient_q_28)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_28)));

		pq_29.setText(context.getResources().getString(R.string.patient_q_29)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_29)));

		pq_30.setText(context.getResources().getString(R.string.patient_q_30)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_30)));

		pq_31.setText(context.getResources().getString(R.string.patient_q_31)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_31)));

		pq_32.setText(context.getResources().getString(R.string.patient_q_32)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_32)));

		pq_33.setText(context.getResources().getString(R.string.patient_q_33)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_33)));

		pq_34.setText(context.getResources().getString(R.string.patient_q_34)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_34)));

		pq_35.setText(context.getResources().getString(R.string.patient_q_35)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_35)));

		pq_36.setText(context.getResources().getString(R.string.patient_q_36)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_36)));

		pq_37.setText(context.getResources().getString(R.string.patient_q_37)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_37)));

		pfq_1.setText(context.getResources().getString(R.string.feedback_01)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_1)));

		pfq_2.setText(context.getResources().getString(R.string.feedback_02)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_2)));

		pfq_3.setText(context.getResources().getString(R.string.feedback_03)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_3)));

		pfq_4.setText(context.getResources().getString(R.string.feedback_04)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_4)));

		pfq_5.setText(context.getResources().getString(R.string.feedback_05)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_5)));

		pfq_6.setText(context.getResources().getString(R.string.feedback_06)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_6)));

		pfq_7.setText(context.getResources().getString(R.string.feedback_07)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_7)));

		pfq_8.setText(context.getResources().getString(R.string.feedback_08)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_8)));

		pfq_9.setText(context.getResources().getString(R.string.feedback_09)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_9)));

		pfq_10.setText(context.getResources().getString(R.string.feedback_10)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_10)));

		pfq_11.setText(context.getResources().getString(R.string.feedback_11)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_11)));

		pfq_12.setText(context.getResources().getString(R.string.feedback_12)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_12)));

		pfq_13.setText(context.getResources().getString(R.string.feedback_13)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_13)));

		pfq_14.setText(context.getResources().getString(R.string.feedback_14)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_14)));

		pfq_15.setText(context.getResources().getString(R.string.feedback_15)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_15)));

		pfq_16.setText(context.getResources().getString(R.string.feedback_16)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_16)));

		pfq_17.setText(context.getResources().getString(R.string.feedback_17)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_17)));

	}

	@Override
	protected void bindGroupView(View view, Context context, Cursor cursor,
			boolean isExpanded) {
		TextView gender, age, condition, date, time;

		gender = (TextView) view.findViewById(R.id.log_gender);
		age = (TextView) view.findViewById(R.id.log_age);
		condition = (TextView) view.findViewById(R.id.log_condition);
		date = (TextView) view.findViewById(R.id.log_date);
		time = (TextView) view.findViewById(R.id.log_time);

		gender.setText("Gender : "
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_2)));
		age.setText("Age : "
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_1)));
		condition.setText("Condition : "
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_3)));
		date.setText(cursor.getString(cursor.getColumnIndex(DBHelper.DATE)));
		time.setText(cursor.getString(cursor.getColumnIndex(DBHelper.TIME)));

	}

	@Override
	protected Cursor getChildrenCursor(Cursor groupCursor) {
		int groupId = groupCursor.getInt(groupCursor
				.getColumnIndex(DBHelper.ID_FIELD));
		DBHelper dbHelper = new DBHelper(context);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String sqlString = "SELECT * FROM " + DBHelper.TABLE_NAME_PATIENT
				+ " where _id=" + groupId;
		Cursor mCursor = db.rawQuery(sqlString, null);
		return mCursor;

	}

	@Override
	protected View newChildView(Context context, Cursor cursor,
			boolean isLastChild, ViewGroup parent) {

		View view = mInflator.inflate(R.layout.log_view_child, null);

		TextView pq_4, pq_5, pq_6, pq_7, pq_8, pq_9, pq_10, pq_11, pq_12, pq_13, pq_14, pq_15, pq_16, pq_17, pq_18, pq_19, pq_20, pq_21, pq_22, pq_23, pq_24, pq_25, pq_26, pq_27, pq_28, pq_29, pq_30, pq_31, pq_32, pq_33, pq_34, pq_35, pq_36, pq_37;
		TextView pfq_1, pfq_2, pfq_3, pfq_4, pfq_5, pfq_6, pfq_7, pfq_8, pfq_9, pfq_10, pfq_11, pfq_12, pfq_13, pfq_14, pfq_15, pfq_16, pfq_17;
		@SuppressWarnings("unused")
		Button btn_print, btn_export, btn_save;
		TextView tv_stress, tv_anxiety, tv_depression;

		TextView tv_stress_level, tv_anxiety_level, tv_depression_level;

		tv_stress_level = (TextView) view.findViewById(R.id.log_stress_level);
		tv_anxiety_level = (TextView) view.findViewById(R.id.log_anxiety_level);
		tv_depression_level = (TextView) view
				.findViewById(R.id.log_depression_level);

		tv_stress = (TextView) view.findViewById(R.id.log_stress);
		tv_anxiety = (TextView) view.findViewById(R.id.log_anxiety);
		tv_depression = (TextView) view.findViewById(R.id.log_depression);

		btn_print = (Button) view.findViewById(R.id.log_print);
		btn_export = (Button) view.findViewById(R.id.log_export);
		btn_save = (Button) view.findViewById(R.id.log_save_all_question);
		pq_4 = (TextView) view.findViewById(R.id.pq_4);
		pq_5 = (TextView) view.findViewById(R.id.pq_5);
		pq_6 = (TextView) view.findViewById(R.id.pq_6);
		pq_7 = (TextView) view.findViewById(R.id.pq_7);
		pq_8 = (TextView) view.findViewById(R.id.pq_8);
		pq_9 = (TextView) view.findViewById(R.id.pq_9);
		pq_10 = (TextView) view.findViewById(R.id.pq_10);
		pq_11 = (TextView) view.findViewById(R.id.pq_11);
		pq_12 = (TextView) view.findViewById(R.id.pq_12);
		pq_13 = (TextView) view.findViewById(R.id.pq_13);
		pq_14 = (TextView) view.findViewById(R.id.pq_14);
		pq_15 = (TextView) view.findViewById(R.id.pq_15);
		pq_16 = (TextView) view.findViewById(R.id.pq_16);
		pq_17 = (TextView) view.findViewById(R.id.pq_17);
		pq_18 = (TextView) view.findViewById(R.id.pq_18);
		pq_19 = (TextView) view.findViewById(R.id.pq_19);
		pq_20 = (TextView) view.findViewById(R.id.pq_20);
		pq_21 = (TextView) view.findViewById(R.id.pq_21);
		pq_22 = (TextView) view.findViewById(R.id.pq_22);
		pq_23 = (TextView) view.findViewById(R.id.pq_23);
		pq_24 = (TextView) view.findViewById(R.id.pq_24);
		pq_25 = (TextView) view.findViewById(R.id.pq_25);
		pq_26 = (TextView) view.findViewById(R.id.pq_26);
		pq_27 = (TextView) view.findViewById(R.id.pq_27);
		pq_28 = (TextView) view.findViewById(R.id.pq_28);
		pq_29 = (TextView) view.findViewById(R.id.pq_29);
		pq_30 = (TextView) view.findViewById(R.id.pq_30);
		pq_31 = (TextView) view.findViewById(R.id.pq_31);
		pq_32 = (TextView) view.findViewById(R.id.pq_32);
		pq_33 = (TextView) view.findViewById(R.id.pq_33);
		pq_34 = (TextView) view.findViewById(R.id.pq_34);
		pq_35 = (TextView) view.findViewById(R.id.pq_35);
		pq_36 = (TextView) view.findViewById(R.id.pq_36);
		pq_37 = (TextView) view.findViewById(R.id.pq_37);

		pfq_1 = (TextView) view.findViewById(R.id.pfq_1);
		pfq_2 = (TextView) view.findViewById(R.id.pfq_2);
		pfq_3 = (TextView) view.findViewById(R.id.pfq_3);
		pfq_4 = (TextView) view.findViewById(R.id.pfq_4);
		pfq_5 = (TextView) view.findViewById(R.id.pfq_5);
		pfq_6 = (TextView) view.findViewById(R.id.pfq_6);
		pfq_7 = (TextView) view.findViewById(R.id.pfq_7);
		pfq_8 = (TextView) view.findViewById(R.id.pfq_8);
		pfq_9 = (TextView) view.findViewById(R.id.pfq_9);
		pfq_10 = (TextView) view.findViewById(R.id.pfq_10);
		pfq_11 = (TextView) view.findViewById(R.id.pfq_11);
		pfq_12 = (TextView) view.findViewById(R.id.pfq_12);
		pfq_13 = (TextView) view.findViewById(R.id.pfq_13);
		pfq_14 = (TextView) view.findViewById(R.id.pfq_14);
		pfq_15 = (TextView) view.findViewById(R.id.pfq_15);
		pfq_16 = (TextView) view.findViewById(R.id.pfq_16);
		pfq_17 = (TextView) view.findViewById(R.id.pfq_17);

		tv_stress.setText(context.getResources().getString(R.string.stress)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.STRESS)));
		tv_anxiety.setText(context.getResources().getString(R.string.anxiety)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.ANXIETY)));
		tv_depression.setText(context.getResources().getString(
				R.string.depression)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.DEPRESSION)));

		tv_stress_level
				.setText(context.getResources().getString(
						R.string.stress_severity_level)
						+ "\n\n"
						+ cursor.getString(cursor
								.getColumnIndex(DBHelper.STRESS_LEVEL)));
		tv_anxiety_level.setText(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.ANXIETY_LEVEL)));
		tv_depression_level.setText(context.getResources().getString(
				R.string.depression_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.DEPRESSION_LEVEL)));

		pq_4.setText(context.getResources().getString(R.string.patient_q_4)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_4)));

		pq_5.setText(context.getResources().getString(R.string.patient_q_5)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_5)));

		pq_6.setText(context.getResources().getString(R.string.patient_q_6)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_6)));

		pq_7.setText(context.getResources().getString(R.string.patient_q_7)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_7)));

		pq_8.setText(context.getResources().getString(R.string.patient_q_8)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_8)));

		pq_9.setText(context.getResources().getString(R.string.patient_q_9)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_9)));

		pq_10.setText(context.getResources().getString(R.string.patient_q_10)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_10)));

		pq_11.setText(context.getResources().getString(R.string.patient_q_11)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_11)));

		pq_12.setText(context.getResources().getString(R.string.patient_q_12)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_12)));

		pq_13.setText(context.getResources().getString(R.string.patient_q_13)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_13)));

		pq_14.setText(context.getResources().getString(R.string.patient_q_14)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_14)));

		pq_15.setText(context.getResources().getString(R.string.patient_q_15)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_15)));

		pq_16.setText(context.getResources().getString(R.string.patient_q_16)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_16)));

		pq_17.setText(context.getResources().getString(R.string.patient_q_17)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_17)));

		pq_18.setText(context.getResources().getString(R.string.patient_q_18)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_18)));

		pq_19.setText(context.getResources().getString(R.string.patient_q_19)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_19)));

		pq_20.setText(context.getResources().getString(R.string.patient_q_20)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_20)));

		pq_21.setText(context.getResources().getString(R.string.patient_q_21)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_21)));

		pq_22.setText(context.getResources().getString(R.string.patient_q_22)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_22)));

		pq_23.setText(context.getResources().getString(R.string.patient_q_23)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_23)));

		pq_24.setText(context.getResources().getString(R.string.patient_q_24)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_24)));

		pq_25.setText(context.getResources().getString(R.string.patient_q_25)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_25)));

		pq_26.setText(context.getResources().getString(R.string.patient_q_26)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_26)));

		pq_27.setText(context.getResources().getString(R.string.patient_q_27)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_27)));

		pq_28.setText(context.getResources().getString(R.string.patient_q_28)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_28)));

		pq_29.setText(context.getResources().getString(R.string.patient_q_29)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_29)));

		pq_30.setText(context.getResources().getString(R.string.patient_q_30)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_30)));

		pq_31.setText(context.getResources().getString(R.string.patient_q_31)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_31)));

		pq_32.setText(context.getResources().getString(R.string.patient_q_32)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_32)));

		pq_33.setText(context.getResources().getString(R.string.patient_q_33)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_33)));

		pq_34.setText(context.getResources().getString(R.string.patient_q_34)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_34)));

		pq_35.setText(context.getResources().getString(R.string.patient_q_35)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_35)));

		pq_36.setText(context.getResources().getString(R.string.patient_q_36)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_36)));

		pq_37.setText(context.getResources().getString(R.string.patient_q_37)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_37)));

		pfq_1.setText(context.getResources().getString(R.string.feedback_01)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_1)));

		pfq_2.setText(context.getResources().getString(R.string.feedback_02)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_2)));

		pfq_3.setText(context.getResources().getString(R.string.feedback_03)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_3)));

		pfq_4.setText(context.getResources().getString(R.string.feedback_04)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_4)));

		pfq_5.setText(context.getResources().getString(R.string.feedback_05)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_5)));

		pfq_6.setText(context.getResources().getString(R.string.feedback_06)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_6)));

		pfq_7.setText(context.getResources().getString(R.string.feedback_07)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_7)));

		pfq_8.setText(context.getResources().getString(R.string.feedback_08)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_8)));

		pfq_9.setText(context.getResources().getString(R.string.feedback_09)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_9)));

		pfq_10.setText(context.getResources().getString(R.string.feedback_10)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_10)));

		pfq_11.setText(context.getResources().getString(R.string.feedback_11)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_11)));

		pfq_12.setText(context.getResources().getString(R.string.feedback_12)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_12)));

		pfq_13.setText(context.getResources().getString(R.string.feedback_13)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_13)));

		pfq_14.setText(context.getResources().getString(R.string.feedback_14)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_14)));

		pfq_15.setText(context.getResources().getString(R.string.feedback_15)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_15)));

		pfq_16.setText(context.getResources().getString(R.string.feedback_16)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_16)));

		pfq_17.setText(context.getResources().getString(R.string.feedback_17)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PFQ_17)));

		return view;

	}

	@Override
	protected View newGroupView(Context context, Cursor cursor,
			boolean isExpanded, ViewGroup parent) {

		View view = mInflator.inflate(R.layout.log_view_parent, null);

		TextView gender, age, condition, date, time;

		gender = (TextView) view.findViewById(R.id.log_gender);
		age = (TextView) view.findViewById(R.id.log_age);
		condition = (TextView) view.findViewById(R.id.log_condition);
		date = (TextView) view.findViewById(R.id.log_date);
		time = (TextView) view.findViewById(R.id.log_time);

		gender.setText("Gender : "
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_2)));
		age.setText("Age : "
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_1)));
		condition.setText("Condition : "
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_3)));
		date.setText(cursor.getString(cursor.getColumnIndex(DBHelper.DATE)));
		time.setText(cursor.getString(cursor.getColumnIndex(DBHelper.TIME)));

		return view;
	}

	@Override
	public View getChildView(int groupPosition, int childP,
			boolean isLastChild, View view, ViewGroup parent) {
		final int childPosition = groupPosition;
		view = mInflator.inflate(R.layout.log_view_child, null);
		TextView pq_4, pq_5, pq_6, pq_7, pq_8, pq_9, pq_10, pq_11, pq_12, pq_13, pq_14, pq_15, pq_16, pq_17, pq_18, pq_19, pq_20, pq_21, pq_22, pq_23, pq_24, pq_25, pq_26, pq_27, pq_28, pq_29, pq_30, pq_31, pq_32, pq_33, pq_34, pq_35, pq_36, pq_37;
		TextView pfq_1, pfq_2, pfq_3, pfq_4, pfq_5, pfq_6, pfq_7, pfq_8, pfq_9, pfq_10, pfq_11, pfq_12, pfq_13, pfq_14, pfq_15, pfq_16, pfq_17;
		Button btn_print, btn_export, btn_save;
		TextView tv_stress, tv_anxiety, tv_depression;

		TextView tv_stress_level, tv_anxiety_level, tv_depression_level;

		tv_stress_level = (TextView) view.findViewById(R.id.log_stress_level);
		tv_anxiety_level = (TextView) view.findViewById(R.id.log_anxiety_level);
		tv_depression_level = (TextView) view
				.findViewById(R.id.log_depression_level);

		tv_stress = (TextView) view.findViewById(R.id.log_stress);
		tv_anxiety = (TextView) view.findViewById(R.id.log_anxiety);
		tv_depression = (TextView) view.findViewById(R.id.log_depression);

		btn_print = (Button) view.findViewById(R.id.log_print);
		btn_export = (Button) view.findViewById(R.id.log_export);
		btn_save = (Button) view.findViewById(R.id.log_save_all_question);
		pq_4 = (TextView) view.findViewById(R.id.pq_4);
		pq_5 = (TextView) view.findViewById(R.id.pq_5);
		pq_6 = (TextView) view.findViewById(R.id.pq_6);
		pq_7 = (TextView) view.findViewById(R.id.pq_7);
		pq_8 = (TextView) view.findViewById(R.id.pq_8);
		pq_9 = (TextView) view.findViewById(R.id.pq_9);
		pq_10 = (TextView) view.findViewById(R.id.pq_10);
		pq_11 = (TextView) view.findViewById(R.id.pq_11);
		pq_12 = (TextView) view.findViewById(R.id.pq_12);
		pq_13 = (TextView) view.findViewById(R.id.pq_13);
		pq_14 = (TextView) view.findViewById(R.id.pq_14);
		pq_15 = (TextView) view.findViewById(R.id.pq_15);
		pq_16 = (TextView) view.findViewById(R.id.pq_16);
		pq_17 = (TextView) view.findViewById(R.id.pq_17);
		pq_18 = (TextView) view.findViewById(R.id.pq_18);
		pq_19 = (TextView) view.findViewById(R.id.pq_19);
		pq_20 = (TextView) view.findViewById(R.id.pq_20);
		pq_21 = (TextView) view.findViewById(R.id.pq_21);
		pq_22 = (TextView) view.findViewById(R.id.pq_22);
		pq_23 = (TextView) view.findViewById(R.id.pq_23);
		pq_24 = (TextView) view.findViewById(R.id.pq_24);
		pq_25 = (TextView) view.findViewById(R.id.pq_25);
		pq_26 = (TextView) view.findViewById(R.id.pq_26);
		pq_27 = (TextView) view.findViewById(R.id.pq_27);
		pq_28 = (TextView) view.findViewById(R.id.pq_28);
		pq_29 = (TextView) view.findViewById(R.id.pq_29);
		pq_30 = (TextView) view.findViewById(R.id.pq_30);
		pq_31 = (TextView) view.findViewById(R.id.pq_31);
		pq_32 = (TextView) view.findViewById(R.id.pq_32);
		pq_33 = (TextView) view.findViewById(R.id.pq_33);
		pq_34 = (TextView) view.findViewById(R.id.pq_34);
		pq_35 = (TextView) view.findViewById(R.id.pq_35);
		pq_36 = (TextView) view.findViewById(R.id.pq_36);
		pq_37 = (TextView) view.findViewById(R.id.pq_37);

		pfq_1 = (TextView) view.findViewById(R.id.pfq_1);
		pfq_2 = (TextView) view.findViewById(R.id.pfq_2);
		pfq_3 = (TextView) view.findViewById(R.id.pfq_3);
		pfq_4 = (TextView) view.findViewById(R.id.pfq_4);
		pfq_5 = (TextView) view.findViewById(R.id.pfq_5);
		pfq_6 = (TextView) view.findViewById(R.id.pfq_6);
		pfq_7 = (TextView) view.findViewById(R.id.pfq_7);
		pfq_8 = (TextView) view.findViewById(R.id.pfq_8);
		pfq_9 = (TextView) view.findViewById(R.id.pfq_9);
		pfq_10 = (TextView) view.findViewById(R.id.pfq_10);
		pfq_11 = (TextView) view.findViewById(R.id.pfq_11);
		pfq_12 = (TextView) view.findViewById(R.id.pfq_12);
		pfq_13 = (TextView) view.findViewById(R.id.pfq_13);
		pfq_14 = (TextView) view.findViewById(R.id.pfq_14);
		pfq_15 = (TextView) view.findViewById(R.id.pfq_15);
		pfq_16 = (TextView) view.findViewById(R.id.pfq_16);
		pfq_17 = (TextView) view.findViewById(R.id.pfq_17);

		tv_stress_level.setText(context.getResources().getString(
				R.string.stress_severity_level)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.STRESS_LEVEL)));
		tv_anxiety_level.setText(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.ANXIETY_LEVEL)));
		tv_depression_level.setText(context.getResources().getString(
				R.string.depression_severity_level)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.DEPRESSION_LEVEL)));

		tv_stress.setText(context.getResources().getString(R.string.stress)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.STRESS)));
		tv_anxiety.setText(context.getResources().getString(R.string.anxiety)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition)
								.getColumnIndex(DBHelper.ANXIETY)));
		tv_depression.setText(context.getResources().getString(
				R.string.depression)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.DEPRESSION)));

		pq_4.setText(context.getResources().getString(R.string.patient_q_4)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_4)));

		pq_5.setText(context.getResources().getString(R.string.patient_q_5)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_5)));

		pq_6.setText(context.getResources().getString(R.string.patient_q_6)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_6)));

		pq_7.setText(context.getResources().getString(R.string.patient_q_7)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_7)));

		pq_8.setText(context.getResources().getString(R.string.patient_q_8)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_8)));

		pq_9.setText(context.getResources().getString(R.string.patient_q_9)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_9)));

		pq_10.setText(context.getResources().getString(R.string.patient_q_10)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_10)));

		pq_11.setText(context.getResources().getString(R.string.patient_q_11)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_11)));

		pq_12.setText(context.getResources().getString(R.string.patient_q_12)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_12)));

		pq_13.setText(context.getResources().getString(R.string.patient_q_13)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_13)));

		pq_14.setText(context.getResources().getString(R.string.patient_q_14)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_14)));

		pq_15.setText(context.getResources().getString(R.string.patient_q_15)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_15)));

		pq_16.setText(context.getResources().getString(R.string.patient_q_16)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_16)));

		pq_17.setText(context.getResources().getString(R.string.patient_q_17)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_17)));

		pq_18.setText(context.getResources().getString(R.string.patient_q_18)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_18)));

		pq_19.setText(context.getResources().getString(R.string.patient_q_19)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_19)));

		pq_20.setText(context.getResources().getString(R.string.patient_q_20)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_20)));

		pq_21.setText(context.getResources().getString(R.string.patient_q_21)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_21)));

		pq_22.setText(context.getResources().getString(R.string.patient_q_22)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_22)));

		pq_23.setText(context.getResources().getString(R.string.patient_q_23)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_23)));

		pq_24.setText(context.getResources().getString(R.string.patient_q_24)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_24)));

		pq_25.setText(context.getResources().getString(R.string.patient_q_25)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_25)));

		pq_26.setText(context.getResources().getString(R.string.patient_q_26)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_26)));

		pq_27.setText(context.getResources().getString(R.string.patient_q_27)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_27)));

		pq_28.setText(context.getResources().getString(R.string.patient_q_28)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_28)));

		pq_29.setText(context.getResources().getString(R.string.patient_q_29)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_29)));

		pq_30.setText(context.getResources().getString(R.string.patient_q_30)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_30)));

		pq_31.setText(context.getResources().getString(R.string.patient_q_31)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_31)));

		pq_32.setText(context.getResources().getString(R.string.patient_q_32)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_32)));

		pq_33.setText(context.getResources().getString(R.string.patient_q_33)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_33)));

		pq_34.setText(context.getResources().getString(R.string.patient_q_34)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_34)));

		pq_35.setText(context.getResources().getString(R.string.patient_q_35)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_35)));

		pq_36.setText(context.getResources().getString(R.string.patient_q_36)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_36)));

		pq_37.setText(context.getResources().getString(R.string.patient_q_37)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_37)));

		pfq_1.setText(context.getResources().getString(R.string.feedback_01)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_1)));

		pfq_2.setText(context.getResources().getString(R.string.feedback_02)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_2)));

		pfq_3.setText(context.getResources().getString(R.string.feedback_03)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_3)));

		pfq_4.setText(context.getResources().getString(R.string.feedback_04)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_4)));

		pfq_5.setText(context.getResources().getString(R.string.feedback_05)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_5)));

		pfq_6.setText(context.getResources().getString(R.string.feedback_06)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_6)));

		pfq_7.setText(context.getResources().getString(R.string.feedback_07)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_7)));

		pfq_8.setText(context.getResources().getString(R.string.feedback_08)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_8)));

		pfq_9.setText(context.getResources().getString(R.string.feedback_09)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PFQ_9)));

		pfq_10.setText(context.getResources().getString(R.string.feedback_10)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_10)));

		pfq_11.setText(context.getResources().getString(R.string.feedback_11)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_11)));

		pfq_12.setText(context.getResources().getString(R.string.feedback_12)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_12)));

		pfq_13.setText(context.getResources().getString(R.string.feedback_13)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_13)));

		pfq_14.setText(context.getResources().getString(R.string.feedback_14)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_14)));

		pfq_15.setText(context.getResources().getString(R.string.feedback_15)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_15)));

		pfq_16.setText(context.getResources().getString(R.string.feedback_16)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_16)));

		pfq_17.setText(context.getResources().getString(R.string.feedback_17)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.PFQ_17)));

		btn_print.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (v.getId() == R.id.log_print) {
					print_call_back
							.printCallback(getPatientData(childPosition));

				}

			}

		});

		btn_export.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (v.getId() == R.id.log_export) {
					exportCallback
							.exportCallback(getPatientData(childPosition));
				}
			}
		});

		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				saveCallback.saveCallback(getPatientData(childPosition));

			}
		});

		return view;
	}

	private PatientData getPatientData(int childPosition) {
		PatientData patientData = new PatientData();
		patientData.setANXIETY(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.ANXIETY)));
		patientData.setSTRESS(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.STRESS)));
		patientData.setDEPRESSION(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.DEPRESSION)));

		patientData
				.setANXIETY_LEVEL(getGroup(childPosition).getString(
						getGroup(childPosition).getColumnIndex(
								DBHelper.ANXIETY_LEVEL)));
		patientData.setSTRESS_LEVEL(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.STRESS_LEVEL)));
		patientData.setDEPRESSION_LEVEL(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(
						DBHelper.DEPRESSION_LEVEL)));
		patientData.setPQ_1(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_1)));
		patientData.setPQ_2(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_2)));
		patientData.setPQ_3(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_3)));
		patientData.setPQ_4(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_4)));
		patientData.setPQ_5(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_5)));
		patientData.setPQ_6(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_6)));
		patientData.setPQ_7(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_7)));
		patientData.setPQ_8(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_8)));
		patientData.setPQ_9(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_9)));
		patientData.setPQ_10(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_10)));
		patientData.setPQ_11(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_11)));
		patientData.setPQ_12(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_12)));
		patientData.setPQ_13(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_13)));
		patientData.setPQ_14(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_14)));
		patientData.setPQ_15(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_15)));
		patientData.setPQ_16(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_16)));
		patientData.setPQ_17(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_17)));
		patientData.setPQ_18(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_18)));
		patientData.setPQ_19(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_19)));
		patientData.setPQ_20(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_20)));
		patientData.setPQ_21(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_21)));
		patientData.setPQ_22(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_22)));
		patientData.setPQ_23(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_23)));
		patientData.setPQ_24(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_24)));
		patientData.setPQ_25(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_25)));
		patientData.setPQ_26(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_26)));
		patientData.setPQ_27(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_27)));
		patientData.setPQ_28(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_28)));
		patientData.setPQ_29(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_29)));
		patientData.setPQ_30(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_30)));
		patientData.setPQ_31(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_31)));
		patientData.setPQ_32(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_32)));
		patientData.setPQ_33(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_33)));
		patientData.setPQ_34(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_34)));
		patientData.setPQ_35(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_35)));
		patientData.setPQ_36(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_36)));
		patientData.setPQ_37(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PQ_37)));

		patientData.setPFQ_1(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_1)));
		patientData.setPFQ_2(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_2)));
		patientData.setPFQ_3(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_3)));
		patientData.setPFQ_4(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_4)));
		patientData.setPFQ_5(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_5)));
		patientData.setPFQ_6(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_6)));
		patientData.setPFQ_7(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_7)));
		patientData.setPFQ_8(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_8)));
		patientData.setPFQ_9(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_9)));
		patientData.setPFQ_10(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_10)));
		patientData.setPFQ_11(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_11)));
		patientData.setPFQ_12(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_12)));
		patientData.setPFQ_13(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_13)));
		patientData.setPFQ_14(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_14)));
		patientData.setPFQ_15(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_15)));
		patientData.setPFQ_16(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_16)));
		patientData.setPFQ_17(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.PFQ_17)));

		patientData.setTIME(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.TIME)));
		patientData.setDATE(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(DBHelper.DATE)));
		patientData.setALL_QUESTION_STAUS(getGroup(childPosition).getString(
				getGroup(childPosition).getColumnIndex(
						DBHelper.ALL_QUESTION_STATUS)));

		return patientData;

	}

}
