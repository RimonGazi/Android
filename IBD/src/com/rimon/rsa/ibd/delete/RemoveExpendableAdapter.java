package com.rimon.rsa.ibd.delete;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rimon.rsa.ibd.database.DBHelper;
import com.rimon.rsa.mental.R;

public class RemoveExpendableAdapter extends CursorTreeAdapter {
	LayoutInflater mInflator;
	Context mycontext;
	public static String idNumber[];
	public static boolean chnageState = false;
	public static boolean[] selectedStatus;

	public RemoveExpendableAdapter(Cursor cursor, Context context) {
		super(cursor, context);
		mycontext = context;
		mInflator = LayoutInflater.from(context);
		idNumber = new String[cursor.getCount()];
		selectedStatus = new boolean[cursor.getCount()];
		for (int i = 0; i < cursor.getCount(); i++) {
			selectedStatus[i] = false;
			idNumber[i] = "";
		}

	}

	@Override
	protected void bindChildView(View view, Context context, Cursor cursor,
			boolean isLastChild) {

	}

	@Override
	protected void bindGroupView(View view, Context context, Cursor cursor,
			boolean isExpanded) {
		@SuppressWarnings("unused")
		TextView tv_gender, tv_age, tv_condition, tv_time, tv_date;
		@SuppressWarnings("unused")
		ImageView imageDelete;
		tv_gender = (TextView) view.findViewById(R.id.log_gender_delete);
		tv_age = (TextView) view.findViewById(R.id.log_age_delete);
		tv_condition = (TextView) view.findViewById(R.id.log_conditon_delete);
		tv_date = (TextView) view.findViewById(R.id.log_date_delete);
		tv_time = (TextView) view.findViewById(R.id.log_time_delete);
		imageDelete = (ImageView) view.findViewById(R.id.imageView_delete);

	}

	@Override
	protected View newChildView(Context context, Cursor cursor,
			boolean isLastChild, ViewGroup parent) {

		return null;
	}

	@Override
	protected View newGroupView(Context context, Cursor cursor,
			boolean isExpanded, ViewGroup parent) {

		View view = mInflator.inflate(R.layout.delete_log_view_parent, null);
		TextView tv_gender, tv_age, tv_condition, tv_time, tv_date;
		@SuppressWarnings("unused")
		ImageView imageDelete;
		tv_gender = (TextView) view.findViewById(R.id.log_gender_delete);
		tv_age = (TextView) view.findViewById(R.id.log_age_delete);
		tv_condition = (TextView) view.findViewById(R.id.log_conditon_delete);
		tv_date = (TextView) view.findViewById(R.id.log_date_delete);
		tv_time = (TextView) view.findViewById(R.id.log_time_delete);
		imageDelete = (ImageView) view.findViewById(R.id.imageView_delete);

		tv_gender
				.setText(cursor.getString(cursor.getColumnIndex(DBHelper.PQ_2)));
		tv_age.setText(cursor.getString(cursor.getColumnIndex(DBHelper.PQ_1)));
		tv_condition.setText(cursor.getString(cursor
				.getColumnIndex(DBHelper.PQ_3)));
		tv_date.setText(cursor.getString(cursor.getColumnIndex(DBHelper.DATE)));
		tv_time.setText(cursor.getString(cursor.getColumnIndex(DBHelper.TIME)));

		return view;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View view,
			ViewGroup parent) {
		final int position = groupPosition;
		view = mInflator.inflate(R.layout.delete_log_view_parent, null);
		TextView tv_gender, tv_age, tv_condition, tv_time, tv_date;
		final ImageView imageDelete;
		tv_gender = (TextView) view.findViewById(R.id.log_gender_delete);
		tv_age = (TextView) view.findViewById(R.id.log_age_delete);
		tv_condition = (TextView) view.findViewById(R.id.log_conditon_delete);
		tv_date = (TextView) view.findViewById(R.id.log_date_delete);
		tv_time = (TextView) view.findViewById(R.id.log_time_delete);
		imageDelete = (ImageView) view.findViewById(R.id.imageView_delete);

		tv_gender.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_2)));
		tv_age.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_1)));
		tv_condition.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.PQ_3)));
		tv_date.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.DATE)));
		tv_time.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(DBHelper.TIME)));

		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (selectedStatus[position]) {
					selectedStatus[position] = false;
					imageDelete.setImageResource(R.drawable.unchecked_checkbox);
					idNumber[position] = "";
				} else {
					selectedStatus[position] = true;
					imageDelete.setImageResource(R.drawable.checked_checkbox);
					idNumber[position] = (getGroup(position)
							.getString(getGroup(position).getColumnIndex(
									DBHelper.ID_FIELD))).toString();

				}

			}
		});

		if (selectedStatus[position]) {

			imageDelete.setImageResource(R.drawable.checked_checkbox);
			idNumber[position] = (getGroup(position).getString(getGroup(
					position).getColumnIndex(DBHelper.ID_FIELD))).toString();
			// + (getGroup(position).getString(getGroup(position)
			// .getColumnIndex(DBHelper.PLATE))).toString();

		} else {
			imageDelete.setImageResource(R.drawable.unchecked_checkbox);
			idNumber[position] = "";

		}
		if (chnageState == true) {
			for (int i = 0; i < idNumber.length; i++) {
				if (selectedStatus[i]) {
					idNumber[i] = (getGroup(i).getString(getGroup(i)
							.getColumnIndex(DBHelper.ID_FIELD))).toString();
					// + (getGroup(i).getString(getGroup(i)
					// .getColumnIndex(DBHelper.PLATE)))
					// .toString();

				} else {
					idNumber[i] = "";
				}
			}

			chnageState = false;
		}

		return view;

	}

	@Override
	protected Cursor getChildrenCursor(Cursor groupCursor) {

		return null;
	}
}