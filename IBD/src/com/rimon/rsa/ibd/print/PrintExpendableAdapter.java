package com.rimon.rsa.ibd.print;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorTreeAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rimon.rsa.ibd.database.DBHelper;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.mental.R;

public class PrintExpendableAdapter extends CursorTreeAdapter {
	LayoutInflater mInflator;
	Context context;
	PrintCallbackPrint print_call_back;

	public PrintExpendableAdapter(Cursor cursor, Context con) {
		super(cursor, con);
		context = con;
		mInflator = LayoutInflater.from(context);
		print_call_back = (PrintCallbackPrint) context;

	}

	@Override
	protected void bindChildView(View view, Context context, Cursor cursor,
			boolean isLastChild) {
		TextView pq_1, pq_2, pq_3, pq_4, pq_5, pq_6, pq_7, pq_8, pq_9, pq_10, pq_11, pq_12, pq_13;
		@SuppressWarnings("unused")
		Button btn_print, btn_save;
		btn_print = (Button) view.findViewById(R.id.btn_pl_print);
		btn_save = (Button) view.findViewById(R.id.btn_pl_save);
		pq_1 = (TextView) view.findViewById(R.id.p_q_1);
		pq_2 = (TextView) view.findViewById(R.id.p_q_2);
		pq_3 = (TextView) view.findViewById(R.id.p_q_3);
		pq_4 = (TextView) view.findViewById(R.id.p_q_4);
		pq_5 = (TextView) view.findViewById(R.id.p_q_5);
		pq_6 = (TextView) view.findViewById(R.id.p_q_6);
		pq_7 = (TextView) view.findViewById(R.id.p_q_7);
		pq_8 = (TextView) view.findViewById(R.id.p_q_8);
		pq_9 = (TextView) view.findViewById(R.id.p_q_9);
		pq_10 = (TextView) view.findViewById(R.id.p_q_10);
		pq_11 = (TextView) view.findViewById(R.id.p_q_11);
		pq_12 = (TextView) view.findViewById(R.id.p_q_12);
		pq_13 = (TextView) view.findViewById(R.id.p_q_13);

		pq_1.setText(context.getResources().getString(R.string.p_q_1) + "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_5)));

		pq_2.setText(context.getResources().getString(R.string.p_q_2) + "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_8)));

		pq_3.setText(context.getResources().getString(R.string.p_q_3)

		+ "\n\n" + cursor.getString(cursor.getColumnIndex(DBHelper.PQ_36)));

		pq_4.setText(context.getResources().getString(R.string.p_q_4) + "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_37)));

		pq_5.setText(context.getResources().getString(R.string.anxiety_score)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.ANXIETY)));

		pq_6.setText(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.ANXIETY_LEVEL)));

		pq_7.setText(context.getResources()
				.getString(R.string.depression_score)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.DEPRESSION)));

		pq_8.setText(context.getResources().getString(
				R.string.depression_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.DEPRESSION_LEVEL)));
		pq_9.setText(context.getResources().getString(R.string.stress_score)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.STRESS)));
		pq_10.setText(context.getResources().getString(
				R.string.stress_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.STRESS_LEVEL)));
		pq_11.setText(context.getResources().getString(R.string.suicidal)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_33)));

		pq_12.setText(context.getResources().getString(
				R.string.mental_healt_professional)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_34)));
		pq_13.setText(context.getResources()
				.getString(R.string.symptoms_worsen)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_35)));

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

		View view = mInflator.inflate(R.layout.print_log_view_child, null);
		TextView pq_1, pq_2, pq_3, pq_4, pq_5, pq_6, pq_7, pq_8, pq_9, pq_10, pq_11, pq_12, pq_13;
		@SuppressWarnings("unused")
		Button btn_print, btn_save;
		btn_print = (Button) view.findViewById(R.id.btn_pl_print);
		btn_save = (Button) view.findViewById(R.id.btn_pl_save);
		pq_1 = (TextView) view.findViewById(R.id.p_q_1);
		pq_2 = (TextView) view.findViewById(R.id.p_q_2);
		pq_3 = (TextView) view.findViewById(R.id.p_q_3);
		pq_4 = (TextView) view.findViewById(R.id.p_q_4);
		pq_5 = (TextView) view.findViewById(R.id.p_q_5);
		pq_6 = (TextView) view.findViewById(R.id.p_q_6);
		pq_7 = (TextView) view.findViewById(R.id.p_q_7);
		pq_8 = (TextView) view.findViewById(R.id.p_q_8);
		pq_9 = (TextView) view.findViewById(R.id.p_q_9);
		pq_10 = (TextView) view.findViewById(R.id.p_q_10);
		pq_11 = (TextView) view.findViewById(R.id.p_q_11);
		pq_12 = (TextView) view.findViewById(R.id.p_q_12);
		pq_13 = (TextView) view.findViewById(R.id.p_q_13);

		pq_1.setText(context.getResources().getString(R.string.p_q_1) + "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_5)));

		pq_2.setText(context.getResources().getString(R.string.p_q_2) + "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_8)));

		pq_3.setText(context.getResources().getString(R.string.p_q_3)

		+ "\n\n" + cursor.getString(cursor.getColumnIndex(DBHelper.PQ_36)));

		pq_4.setText(context.getResources().getString(R.string.p_q_4) + "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_37)));

		pq_5.setText(context.getResources().getString(R.string.anxiety_score)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.ANXIETY)));

		pq_6.setText(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.ANXIETY_LEVEL)));

		pq_7.setText(context.getResources()
				.getString(R.string.depression_score)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.DEPRESSION)));

		pq_8.setText(context.getResources().getString(
				R.string.depression_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor
						.getColumnIndex(DBHelper.DEPRESSION_LEVEL)));
		pq_9.setText(context.getResources().getString(R.string.stress_score)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.STRESS)));
		pq_10.setText(context.getResources().getString(
				R.string.stress_severity_level)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.STRESS_LEVEL)));
		pq_11.setText(context.getResources().getString(R.string.suicidal)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_33)));

		pq_12.setText(context.getResources().getString(
				R.string.mental_healt_professional)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_34)));
		pq_13.setText(context.getResources()
				.getString(R.string.symptoms_worsen)
				+ "\n\n"
				+ cursor.getString(cursor.getColumnIndex(DBHelper.PQ_35)));
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
		LinearLayout layout_resutl_title;
		view = mInflator.inflate(R.layout.print_log_view_child, null);
		TextView pq_1, pq_2, pq_3, pq_4, pq_5, pq_6, pq_7, pq_8, pq_9, pq_10, pq_11, pq_12, pq_13;
		Button btn_print, btn_save;
		TextView tv_title, tv_subtitle, tv_description;

		tv_title = (TextView) view.findViewById(R.id.tv_title_print);
		tv_subtitle = (TextView) view.findViewById(R.id.tv_sub_title_print);
		tv_description = (TextView) view
				.findViewById(R.id.tv_result_description_print);

		layout_resutl_title = (LinearLayout) view
				.findViewById(R.id.lineraLayout_title_reuslt_print);

		LinearLayout layout_parent, layout_lef, layout_right;

		layout_parent = (LinearLayout) view
				.findViewById(R.id.tv_image_layout_parent_print);
		layout_lef = (LinearLayout) view
				.findViewById(R.id.linerLayout_text_hint_leftside_print);
		layout_right = (LinearLayout) view
				.findViewById(R.id.linerLayout_image_hine_right_side_print);

		ImageView imageView = (ImageView) view
				.findViewById(R.id.imageview_reuslt_log);
		String result_string = getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.RESULT_LEVEL));

		if (result_string.equals(ConstantValues.VERY_LOW)) {
			

			layout_resutl_title
					.setBackgroundResource(R.drawable.level_1_result);

			tv_title.setText(context.getResources().getString(
					R.string.level_1_title));
			tv_subtitle.setText(context.getResources().getString(
					R.string.leve_1_sub_title));
			if (layout_lef.getParent() != null) {
				layout_parent.removeView(layout_lef);
				layout_right.setWeightSum(1);
			}
			imageView.setImageDrawable(context.getResources().getDrawable(
					R.drawable.level_1and2_image));

		} else if (result_string.equals(ConstantValues.LOW)) {

			layout_resutl_title
					.setBackgroundResource(R.drawable.level_2_result);
			tv_title.setText(context.getResources().getString(
					R.string.level_2_title));
			tv_subtitle.setText(context.getResources().getString(
					R.string.leve_2_sub_title));
			if (layout_lef.getParent() != null) {
				layout_parent.removeView(layout_lef);
				layout_right.setWeightSum(1);
			}

			imageView.setImageDrawable(context.getResources().getDrawable(
					R.drawable.level_1and2_image));
		} else if (result_string.equals(ConstantValues.MODERATE)) {

			layout_resutl_title
					.setBackgroundResource(R.drawable.level_3_result);
			tv_title.setText(context.getResources().getString(
					R.string.level_3_title));
			tv_subtitle.setText(context.getResources().getString(
					R.string.leve_3_sub_title));
			tv_description.setText(context.getResources().getString(
					R.string.level_3_4_describtion));
			imageView.setImageDrawable(context.getResources().getDrawable(
					R.drawable.level_3and4_image));
		} else if (result_string.equals(ConstantValues.HIGH)) {

			layout_resutl_title
					.setBackgroundResource(R.drawable.level_4_result);
			tv_title.setText(context.getResources().getString(
					R.string.level_4_title));
			tv_subtitle.setText(context.getResources().getString(
					R.string.leve_4_sub_title));
			tv_description.setText(context.getResources().getString(
					R.string.level_3_4_describtion));
			imageView.setImageDrawable(context.getResources().getDrawable(
					R.drawable.level_3and4_image));

		}

		btn_print = (Button) view.findViewById(R.id.btn_pl_print);
		btn_save = (Button) view.findViewById(R.id.btn_pl_save);
		pq_1 = (TextView) view.findViewById(R.id.p_q_1);
		pq_2 = (TextView) view.findViewById(R.id.p_q_2);
		pq_3 = (TextView) view.findViewById(R.id.p_q_3);
		pq_4 = (TextView) view.findViewById(R.id.p_q_4);
		pq_5 = (TextView) view.findViewById(R.id.p_q_5);
		pq_6 = (TextView) view.findViewById(R.id.p_q_6);
		pq_7 = (TextView) view.findViewById(R.id.p_q_7);
		pq_8 = (TextView) view.findViewById(R.id.p_q_8);
		pq_9 = (TextView) view.findViewById(R.id.p_q_9);
		pq_10 = (TextView) view.findViewById(R.id.p_q_10);
		pq_11 = (TextView) view.findViewById(R.id.p_q_11);
		pq_12 = (TextView) view.findViewById(R.id.p_q_12);
		pq_13 = (TextView) view.findViewById(R.id.p_q_13);

		pq_1.setText(context.getResources().getString(R.string.p_q_1)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_5)));

		pq_2.setText(context.getResources().getString(R.string.p_q_2)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_8)));

		pq_3.setText(context.getResources().getString(R.string.p_q_3)

				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_36)));

		pq_4.setText(context.getResources().getString(R.string.p_q_4)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_37)));

		pq_5.setText(context.getResources().getString(R.string.anxiety_score)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition)
								.getColumnIndex(DBHelper.ANXIETY)));

		pq_6.setText(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.ANXIETY_LEVEL)));

		pq_7.setText(context.getResources()
				.getString(R.string.depression_score)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.DEPRESSION)));

		pq_8.setText(context.getResources().getString(
				R.string.depression_severity_level)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.DEPRESSION_LEVEL)));
		pq_9.setText(context.getResources().getString(R.string.stress_score)
				+ "\n\n"
				+ getGroup(groupPosition)
						.getString(
								getGroup(groupPosition).getColumnIndex(
										DBHelper.STRESS)));
		pq_10.setText(context.getResources().getString(
				R.string.stress_severity_level)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.STRESS_LEVEL)));
		pq_11.setText(context.getResources().getString(R.string.suicidal)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_33)));

		pq_12.setText(context.getResources().getString(
				R.string.mental_healt_professional)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_34)));
		pq_13.setText(context.getResources()
				.getString(R.string.symptoms_worsen)
				+ "\n\n"
				+ getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(DBHelper.PQ_35)));
		btn_print.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				print_call_back.printCallback(getPatientData(childPosition),
						true);

			}
		});

		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				print_call_back.printCallback(getPatientData(childPosition),
						false);

			}

		});

		return view;
	}

	private PrintResultData getPatientData(int groupPosition) {
		PrintResultData patientData = new PrintResultData();
		patientData.setP_q_1(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_5)));
		patientData.setP_q_2(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_8)));

		patientData.setP_q_3(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_36)));

		patientData.setP_q_4(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_37)));

		patientData.setP_q_5(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.ANXIETY)));

		patientData
				.setP_q_6(getGroup(groupPosition).getString(
						getGroup(groupPosition).getColumnIndex(
								DBHelper.ANXIETY_LEVEL)));

		patientData.setP_q_7(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.DEPRESSION)));

		patientData.setP_q_8(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(
						DBHelper.DEPRESSION_LEVEL)));
		patientData.setP_q_9(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.STRESS)));
		patientData.setP_q_10(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.STRESS_LEVEL)));
		patientData.setP_q_11(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_33)));

		patientData.setP_q_12(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_34)));
		patientData.setP_q_13(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_35)));

		String resultString = getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.RESULT_LEVEL));
		patientData.setResult_level(resultString);

		return patientData;

	}
}
