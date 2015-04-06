package net.sistransitomobile.placa.data;

import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.appobject.AppObject;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.main.R;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

public class PlacaViewFormat {
	private SpannableString resultViewData;

	private String PLATE, MODEL, COLOR, TYPE, LICENSE_YEAR, LICENSE_DATE,
			LICENSE_STATUS, IPVA, INSURANCE, INFRACTIONS, RESTRICTIONS, DATE;
	private boolean isVibrateOrRinging;
	private Context context;

	public PlacaViewFormat(PlacaRawFormat placaRawFormat, Context context) {
		this.context = context;

		this.PLATE = context.getResources().getString(R.string.place_format)
				+ placaRawFormat.getPLATE() + "  ";

		this.MODEL = AppConstants.NEW_LINE
				+ context.getResources().getString(R.string.model_format)
				+ placaRawFormat.getMODEL() + AppConstants.NEW_LINE;

		this.COLOR = context.getResources().getString(R.string.cor_format)
				+ placaRawFormat.getCOLOR() + AppConstants.NEW_LINE;

		this.TYPE = context.getResources().getString(R.string.tipo_format)
				+ placaRawFormat.getTYPE() + AppConstants.NEW_LINE;

		this.LICENSE_YEAR = context.getResources().getString(
				R.string.ano_licenciamento_format)
				+ placaRawFormat.getLICENSE_YEAR() + AppConstants.NEW_LINE;

		this.LICENSE_DATE = context.getResources().getString(
				R.string.data_licenciamento_format)
				+ placaRawFormat.getLICENSE_DATE() + AppConstants.NEW_LINE;

		// this.LICENSE_STATUS = context.getResources().getString(
		// R.string.licenciamento_format)
		// + placaRawFormat.getLICENSE_STATUS() + AppConstants.NEW_LINE;

		this.LICENSE_STATUS = placaRawFormat.getLICENSE_STATUS();

		this.IPVA = context.getResources().getString(R.string.ipva_format)
				+ placaRawFormat.getIPVA() + AppConstants.NEW_LINE;

		this.INSURANCE = context.getResources().getString(
				R.string.seguro_format)
				+ placaRawFormat.getINSURANCE() + AppConstants.NEW_LINE;

		this.INFRACTIONS = context.getResources().getString(
				R.string.multas_format)
				+ placaRawFormat.getINFRACTIONS() + AppConstants.NEW_LINE;
		this.RESTRICTIONS = context.getResources().getString(
				R.string.restricoes_format)
				+ placaRawFormat.getRESTRICTIONS() + AppConstants.NEW_LINE;
		this.DATE = context.getResources().getString(R.string.date_format)
				+ placaRawFormat.getDATE() + AppConstants.NEW_LINE;
		setResultViewData(placaRawFormat);
	}

	public boolean isVibrateOrRinging() {
		return isVibrateOrRinging;
	}

	private void setVibrateOrRinging(boolean isVibrateOrRinging) {
		this.isVibrateOrRinging = isVibrateOrRinging;
	}

	public SpannableString getResultViewData() {
		return resultViewData;
	}

	private void setResultViewData(PlacaRawFormat placaRawFormat) {
		String result = PLATE + LICENSE_STATUS + MODEL + COLOR + TYPE
				+ LICENSE_YEAR + LICENSE_DATE + IPVA + INSURANCE + INFRACTIONS
				+ RESTRICTIONS;

		resultViewData = new SpannableString(result);
		if (placaRawFormat.getLICENSE_STATUS() != null) {
			int position = result.indexOf(placaRawFormat.getLICENSE_STATUS());

			if ((placaRawFormat.getLICENSE_STATUS()).equals("NORMAL")
					|| (placaRawFormat.getLICENSE_STATUS()).equals("normal")) {

				resultViewData.setSpan(new ForegroundColorSpan(Color.BLUE),
						position, (position + (placaRawFormat
								.getLICENSE_STATUS()).length()), 0);
				setVibrateOrRinging(false);
			} else {
				setVibrateOrRinging(true);
				resultViewData.setSpan(new ForegroundColorSpan(Color.RED),
						position, (position + (placaRawFormat
								.getLICENSE_STATUS()).length()), 0);

			}

			if (position != -1) {
				resultViewData.setSpan(new RelativeSizeSpan(1.5f), position,
						(position + (placaRawFormat.getLICENSE_STATUS())
								.length()), 0);
			}
		}
	}

	public String getPLATE() {
		return PLATE;
	}

	public String getMODEL() {
		return MODEL;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public String getTYPE() {
		return TYPE;
	}

	public String getLICENSE_YEAR() {
		return LICENSE_YEAR;
	}

	public String getLICENSE_DATE() {
		return LICENSE_DATE;
	}

	public String getLICENSE_STATUS() {
		return LICENSE_STATUS;
	}

	public String getIPVA() {
		return IPVA;
	}

	public String getINSURANCE() {
		return INSURANCE;
	}

	public String getINFRACTIONS() {
		return INFRACTIONS;
	}

	public String getRESTRICTIONS() {
		return RESTRICTIONS;
	}

	public String getDATE() {
		return DATE;
	}

	public void setWarning() {
		if (isVibrateOrRinging) {
			if (DatabaseCreator.getDatabaseAdapterSetting(context)
					.getVibrator()) {
				AppObject.startVibrate(context);
			}
			if (DatabaseCreator.getDatabaseAdapterSetting(context)
					.getRingtone()) {
				AppObject.startWarning(context);
			}
		}
	}

}
