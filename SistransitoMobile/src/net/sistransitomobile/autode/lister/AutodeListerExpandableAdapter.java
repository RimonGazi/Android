package net.sistransitomobile.autode.lister;

import net.sistransitomobile.autode.AutoDeActivity;
import net.sistransitomobile.autode.AutoDeData;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.database.PlacaSearchDatabaseHelper;
import net.sistransitomobile.main.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorTreeAdapter;
import android.widget.TextView;

public class AutodeListerExpandableAdapter extends CursorTreeAdapter {
	private LayoutInflater mInflator;
	private Context mycontext;

	public AutodeListerExpandableAdapter(Cursor cursor, Context context) {
		super(cursor, context);
		mycontext = context;
		mInflator = LayoutInflater.from(context);
	}

	@Override
	protected void bindChildView(View arg0, Context arg1, Cursor arg2,
			boolean arg3) {
	}

	@Override
	protected void bindGroupView(View view, Context arg1, Cursor cursor,
			boolean arg3) {
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

	}

	@Override
	protected View newChildView(Context arg0, Cursor arg1, boolean arg2,
			ViewGroup arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected View newGroupView(Context context, Cursor cursor,
			boolean isExpendable, ViewGroup parent) {
		View view = mInflator.inflate(R.layout.placa_lister_listview_parent,
				null);
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
		return view;
	}

	@Override
	protected Cursor getChildrenCursor(Cursor groupCursor) {
		int groupId = groupCursor.getInt(groupCursor
				.getColumnIndex(PlacaSearchDatabaseHelper.COLUMN_ID));
		return (DatabaseCreator.getPlacaSearchDatabaseAdapter(mycontext))
				.getAllPlacaCursorFromID(groupId);
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View view, ViewGroup parent) {
		final int gPosition = groupPosition;
		final String placa = getGroup(gPosition).getString(
				getGroup(gPosition).getColumnIndex(
						PlacaSearchDatabaseHelper.COLUMN_PLACA));

		final String cor = getGroup(gPosition).getString(
				getGroup(gPosition).getColumnIndex(
						PlacaSearchDatabaseHelper.COLUMN_COR));

		final String model = getGroup(gPosition).getString(
				getGroup(gPosition).getColumnIndex(
						PlacaSearchDatabaseHelper.COLUMN_MODELO));
		View mView = null;
		if (view != null) {
			mView = view;
		} else {
			mView = mInflator.inflate(R.layout.placa_lister_listview_child,
					parent, false);
		}
		TextView tvModel, tvColor, tvType, tvLicenseYear, tvLicenseDate, tvIpva, tvInsurance, tvIntraction, tvRestrictions;
		Button ver_plate_nova_autos, ver_plate_auto;

		ver_plate_nova_autos = (Button) mView
				.findViewById(R.id.ver_plate_nova_autos);
		ver_plate_auto = (Button) mView.findViewById(R.id.ver_plate_auto);

		if ((DatabaseCreator.getDatabaseAdapterAutoInfracao(mycontext))
				.isSamePlacaExit(placa)) {
			ver_plate_nova_autos.setEnabled(true);
			ver_plate_auto.setEnabled(false);

		} else {
			ver_plate_nova_autos.setEnabled(false);
			ver_plate_auto.setEnabled(true);

		}

		ver_plate_nova_autos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				openAutode((DatabaseCreator
						.getDatabaseAdapterAutoInfracao(mycontext))
						.getAutodeDataFromPlaca(placa));
			}
		});

		ver_plate_auto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AutoDeData data = new AutoDeData();
				data.setPlate(placa);
				data.setModel(model);
				data.setCor_do_veiculo(cor);
				data.setStoreFullData(false);
				openAutode(data);
			}
		});
		tvModel = (TextView) mView.findViewById(R.id.log_model);
		tvColor = (TextView) mView.findViewById(R.id.log_color);
		tvType = (TextView) mView.findViewById(R.id.log_type);
		tvLicenseYear = (TextView) mView.findViewById(R.id.log_license_year);
		tvLicenseDate = (TextView) mView.findViewById(R.id.log_license_date);
		tvIpva = (TextView) mView.findViewById(R.id.log_ipva);
		tvInsurance = (TextView) mView.findViewById(R.id.log_insurance);

		tvIntraction = (TextView) mView.findViewById(R.id.log_infraction);
		tvRestrictions = (TextView) mView.findViewById(R.id.log_restriction);

		tvModel.setText(mycontext.getResources().getString(
				R.string.model_format)
				+ model);

		tvColor.setText(mycontext.getResources().getString(R.string.cor_format)
				+ cor);

		tvType.setText(mycontext.getResources().getString(R.string.tipo_format)
				+ getGroup(gPosition).getString(
						getGroup(gPosition).getColumnIndex(
								PlacaSearchDatabaseHelper.COLUMN_TIPO)));

		tvLicenseYear
				.setText(mycontext.getResources().getString(
						R.string.ano_licenciamento_format)
						+ getGroup(gPosition)
								.getString(
										getGroup(gPosition)
												.getColumnIndex(
														PlacaSearchDatabaseHelper.COLUMN_ANO_LICENCIAMENTO)));

		tvLicenseDate
				.setText(mycontext.getResources().getString(
						R.string.data_licenciamento_format)
						+ getGroup(gPosition)
								.getString(
										getGroup(gPosition)
												.getColumnIndex(
														PlacaSearchDatabaseHelper.COLUMN_DATA_LICENCIAMENTO)));
		tvIpva.setText(mycontext.getResources().getString(R.string.ipva_format)
				+ getGroup(gPosition).getString(
						getGroup(gPosition).getColumnIndex(
								PlacaSearchDatabaseHelper.COLUMN_IPVA)));

		tvInsurance.setText(mycontext.getResources().getString(
				R.string.seguro_format)
				+ getGroup(gPosition).getString(
						getGroup(gPosition).getColumnIndex(
								PlacaSearchDatabaseHelper.COLUMN_SEGURO)));

		tvIntraction.setText(mycontext.getResources().getString(
				R.string.multas_format)
				+ getGroup(gPosition).getString(
						getGroup(gPosition).getColumnIndex(
								PlacaSearchDatabaseHelper.COLUMN_INFRACOES)));

		tvRestrictions.setText(mycontext.getResources().getString(
				R.string.restricoes_format)
				+ getGroup(gPosition).getString(
						getGroup(gPosition).getColumnIndex(
								PlacaSearchDatabaseHelper.COLUMN_RESTRICOES)));

		return mView;
	}

	private void openAutode(AutoDeData data) {
		Intent intent = new Intent(mycontext, AutoDeActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable(AutoDeData.getAutoDeId(), data);
		intent.putExtras(bundle);
		mycontext.startActivity(intent);
		((Activity) mycontext).finish();
	}
}
