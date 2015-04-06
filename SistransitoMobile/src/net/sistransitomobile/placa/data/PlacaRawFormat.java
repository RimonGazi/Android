package net.sistransitomobile.placa.data;

import net.sistransito.timeandime.TimeAndIme;
import android.content.Context;

public class PlacaRawFormat {
	TimeAndIme time;

	public PlacaRawFormat(Context context) {
		time = new TimeAndIme(context);
		setDATE(time.getDate() + "\n" + time.getTime());

	}

	private String PLATE, MODEL, COLOR, TYPE, LICENSE_YEAR, LICENSE_DATE,
			LICENSE_STATUS, IPVA, INSURANCE, STATUS, INFRACTIONS, RESTRICTIONS,
			DATE;

	public String getPLATE() {
		return PLATE;
	}

	public void setPLATE(String pLATE) {
		PLATE = pLATE;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getLICENSE_YEAR() {
		return LICENSE_YEAR;
	}

	public void setLICENSE_YEAR(String lICENSE_YEAR) {
		LICENSE_YEAR = lICENSE_YEAR;
	}

	public String getLICENSE_DATE() {
		return LICENSE_DATE;
	}

	public void setLICENSE_DATE(String lICENSE_DATE) {
		LICENSE_DATE = lICENSE_DATE;
	}

	public String getLICENSE_STATUS() {
		return LICENSE_STATUS;
	}

	public void setLICENSE_STATUS(String lICENSE_STATUS) {
		LICENSE_STATUS = lICENSE_STATUS;
	}

	public String getIPVA() {
		return IPVA;
	}

	public void setIPVA(String iPVA) {
		IPVA = iPVA;
	}

	public String getINSURANCE() {
		return INSURANCE;
	}

	public void setINSURANCE(String iNSURANCE) {
		INSURANCE = iNSURANCE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getINFRACTIONS() {
		return INFRACTIONS;
	}

	public void setINFRACTIONS(String iNFRACTIONS) {
		INFRACTIONS = iNFRACTIONS;
	}

	public String getRESTRICTIONS() {
		return RESTRICTIONS;
	}

	public void setRESTRICTIONS(String rESTRICTIONS) {
		RESTRICTIONS = rESTRICTIONS;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String date) {
		DATE = date;
	}

}
