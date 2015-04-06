package net.sistransitomobile.placa.lister;

import net.sistransitomobile.database.PlacaSearchDatabaseHelper;
import net.sistransitomobile.main.R;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlacaListerDeleteExpendableAdapter extends CursorTreeAdapter {
	LayoutInflater mInflator;
	Context mycontext;
	public static String idNumber[];
	public static boolean chnageState = false;
	public static boolean[] selectedStatus;

	public PlacaListerDeleteExpendableAdapter(Cursor cursor, Context context) {
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

		ImageView imageView;

		TextView log_plate, log_time, log_license_status;
		log_plate = (TextView) view.findViewById(R.id.log_plate);
		log_license_status = (TextView) view
				.findViewById(R.id.log_license_status);
		log_time = (TextView) view.findViewById(R.id.log_time);
		log_plate.setText(cursor.getString(cursor
				.getColumnIndex(PlacaSearchDatabaseHelper.COLUMN_PLACA)));
		log_license_status
				.setText(cursor.getString(cursor
						.getColumnIndex(PlacaSearchDatabaseHelper.COLUMN_STATUS_LICENCIAMENTO)));
		log_time.setText(cursor.getString(cursor
				.getColumnIndex(PlacaSearchDatabaseHelper.COLUMN_DATE)));
		imageView = (ImageView) view.findViewById(R.id.list_image);
		imageView.setImageResource(R.drawable.ic_unchecked);
	}

	@Override
	protected View newChildView(Context context, Cursor cursor,
			boolean isLastChild, ViewGroup parent) {

		return null;
	}

	@Override
	protected View newGroupView(Context context, Cursor cursor,
			boolean isExpanded, ViewGroup parent) {

		View view = mInflator.inflate(
				R.layout.placa_lister_delete_listview_parent, null);
		ImageView imageView;

		TextView log_plate, log_time, log_license_status;
		log_plate = (TextView) view.findViewById(R.id.log_plate);
		log_license_status = (TextView) view
				.findViewById(R.id.log_license_status);
		log_time = (TextView) view.findViewById(R.id.log_time);
		log_plate.setText(cursor.getString(cursor
				.getColumnIndex(PlacaSearchDatabaseHelper.COLUMN_PLACA)));
		log_license_status
				.setText(cursor.getString(cursor
						.getColumnIndex(PlacaSearchDatabaseHelper.COLUMN_STATUS_LICENCIAMENTO)));
		log_time.setText(cursor.getString(cursor
				.getColumnIndex(PlacaSearchDatabaseHelper.COLUMN_DATE)));
		imageView = (ImageView) view.findViewById(R.id.list_image);
		imageView.setImageResource(R.drawable.ic_unchecked);
		return view;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View view,
			ViewGroup parent) {
		final int position = groupPosition;

		view = mInflator.inflate(R.layout.placa_lister_delete_listview_parent,
				null);

		TextView log_plate, log_time, log_license_status;
		log_plate = (TextView) view.findViewById(R.id.log_plate);
		log_license_status = (TextView) view
				.findViewById(R.id.log_license_status);
		log_time = (TextView) view.findViewById(R.id.log_time);
	
		log_plate.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(
						PlacaSearchDatabaseHelper.COLUMN_PLACA)));
		log_license_status
				.setText(getGroup(groupPosition)
						.getString(
								getGroup(groupPosition)
										.getColumnIndex(
												PlacaSearchDatabaseHelper.COLUMN_STATUS_LICENCIAMENTO)));
		log_time.setText(getGroup(groupPosition).getString(
				getGroup(groupPosition).getColumnIndex(
						PlacaSearchDatabaseHelper.COLUMN_DATE)));

		final ImageView imageView = (ImageView) view
				.findViewById(R.id.list_image);

		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (selectedStatus[position]) {
					selectedStatus[position] = false;
					imageView.setImageResource(R.drawable.ic_unchecked);
					idNumber[position] = "";
				} else {
					selectedStatus[position] = true;
					imageView.setImageResource(R.drawable.ic_checked);
					idNumber[position] = (getGroup(position)
							.getString(getGroup(position).getColumnIndex(
									PlacaSearchDatabaseHelper.COLUMN_ID)))
							.toString();

				}

			}
		});

		if (selectedStatus[position]) {

			imageView.setImageResource(R.drawable.ic_checked);
			idNumber[position] = (getGroup(position).getString(getGroup(
					position).getColumnIndex(
					PlacaSearchDatabaseHelper.COLUMN_ID))).toString();

		} else {
			imageView.setImageResource(R.drawable.ic_unchecked);
			idNumber[position] = "";

		}
		if (chnageState == true) {
			for (int i = 0; i < idNumber.length; i++) {
				if (selectedStatus[i]) {
					idNumber[i] = (getGroup(i)
							.getString(getGroup(i).getColumnIndex(
									PlacaSearchDatabaseHelper.COLUMN_ID)))
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
	protected Cursor getChildrenCursor(Cursor groupCursor) {
		return null;
	}
}