package com.rimon.rsa.ipaeps.module;

import android.database.Cursor;

import com.rimon.rsa.ipaeps.appdatabase.PpPatientDBOpenHelper;

public class ModuleAnswer {
	private Cursor dataCursor;

	public void setCursor(Cursor cursor) {
		this.dataCursor = cursor;
	}

	public ModuleAnswer(Cursor dataCursor) {
		this.dataCursor = dataCursor;
	}

	public ModuleAnswer() {
	}

	// module 1
	public String q_module_1_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_1));
	}

	public String q_module_1_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_2));
	}

	public String q_module_1_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_1_3));
	}

	// module 2
	public String q_module_2_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_2_1));
	}

	public String q_module_2_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_2_2));
	}

	public String q_module_2_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_2_3));
	}

	public String q_module_2_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_2_4));
	}

	public String q_module_2_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_2_5));
	}

	public String q_module_2_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_2_6));
	}

	// module 3

	public String q_module_3_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_1));
	}

	public String q_module_3_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_2));
	}

	public String q_module_3_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_3));
	}

	public String q_module_3_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_4));
	}

	public String q_module_3_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_5));
	}

	public String q_module_3_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_6));
	}

	public String q_module_3_7() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_7));
	}

	public String q_module_3_8() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_8));
	}

	public String q_module_3_9() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_9));
	}

	public String q_module_3_10() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_10));
	}

	public String q_module_3_11() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_11));
	}

	public String q_module_3_12() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_12));
	}

	public String q_module_3_13() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_13));
	}

	public String q_module_3_14() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_14));
	}

	public String q_module_3_15() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_15));
	}

	public String q_module_3_16() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_16));
	}

	public String q_module_3_17() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_17));
	}

	public String q_module_3_18() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_18));
	}

	public String q_module_3_19() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_3_19));
	}

	// module 4

	public String q_module_4_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_1));
	}

	public String q_module_4_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_2));
	}

	public String q_module_4_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_3));
	}

	public String q_module_4_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_4));
	}

	public String q_module_4_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_5));
	}

	public String q_module_4_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_6));
	}

	public String q_module_4_7() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_7));
	}

	public String q_module_4_8() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_8));
	}

	public String q_module_4_9() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_4_9));
	}

	// module 5
	public String q_module_5_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_5_1));
	}

	public String q_module_5_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_5_2));
	}

	public String q_module_5_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_5_3));
	}

	public String q_module_5_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_5_4));
	}

	public String q_module_5_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_5_5));
	}

	// module 6

	public String q_module_6_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_1));
	}

	public String q_module_6_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_2));
	}

	public String q_module_6_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_3));
	}

	public String q_module_6_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_4));
	}

	public String q_module_6_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_5));
	}

	public String q_module_6_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_6));
	}

	public String q_module_6_7() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_7));
	}

	public String q_module_6_8() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_8));
	}

	public String q_module_6_9() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_9));
	}

	public String q_module_6_10() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_10));
	}

	public String q_module_6_11() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_11));
	}

	public String q_module_6_12() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_6_12));
	}

	// module 7

	public String q_module_7_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_1));
	}

	public String q_module_7_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_2));
	}

	public String q_module_7_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_3));
	}

	public String q_module_7_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_4));
	}

	public String q_module_7_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_5));
	}

	public String q_module_7_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_6));
	}

	public String q_module_7_7() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_7));
	}

	public String q_module_7_8() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_8));
	}

	public String q_module_7_9() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_9));
	}

	public String q_module_7_10() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_10));
	}

	public String q_module_7_11() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_11));
	}

	public String q_module_7_12() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_12));
	}

	public String q_module_7_13() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_13));
	}

	public String q_module_7_14() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_14));
	}

	public String q_module_7_15() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_15));
	}

	public String q_module_7_16() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_16));
	}

	public String q_module_7_17() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_17));
	}

	public String q_module_7_18() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_18));
	}

	public String q_module_7_19() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_19));
	}

	public String q_module_7_20() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_20));
	}

	public String q_module_7_21() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_21));
	}

	public String q_module_7_22() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_22_result));
	}

	// module 8

	public String q_module_8_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_8_1));
	}

	public String q_module_8_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_8_2));
	}

	public String q_module_8_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_8_3));
	}

	public String q_module_8_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_8_4));
	}

	// module 9

	public String q_module_9_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_9_1));
	}

	public String q_module_9_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_9_2));
	}

	public String q_module_9_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_9_3));
	}

	public String q_module_9_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_9_4));
	}

	public String q_module_9_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_9_5));
	}

	public String q_module_9_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_9_6));
	}

	public String q_module_9_7() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_9_7));
	}

	// module 10

	public String q_module_10_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_10_1));
	}

	public String q_module_10_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_10_2));
	}

	public String q_module_10_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_10_3));
	}

	public String q_module_10_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_10_4));
	}

	public String q_module_10_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_10_5));
	}

	public String q_module_10_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_10_6));
	}

	// module 11

	public String q_module_11() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_11_1));
	}

	// module 12

	public String q_module_12_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_1));
	}

	public String q_module_12_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_2));
	}

	public String q_module_12_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_3));
	}

	public String q_module_12_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_4));
	}

	public String q_module_12_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_5));
	}

	public String q_module_12_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_6));
	}

	public String q_module_12_7() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_7));
	}

	public String q_module_12_8() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_8));
	}

	public String q_module_12_9() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_12_9));
	}

	// module 13

	public String q_module_13_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_1));
	}

	public String q_module_13_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_2));
	}

	public String q_module_13_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_3));
	}

	public String q_module_13_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_4));
	}

	public String q_module_13_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_5));
	}

	public String q_module_13_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_6));
	}

	public String q_module_13_7() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_7));
	}

	public String q_module_13_8() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_8));
	}

	public String q_module_13_9() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_13_9));
	}

	// module 14

	public String q_module_14_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_14_1));
	}

	public String q_module_14_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_14_2));
	}

	public String q_module_14_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_14_3));
	}

	public String q_module_14_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_14_4));
	}

	public String q_module_14_5() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_14_5));
	}

	public String q_module_14_6() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_14_6));
	}

	// module 15

	public String q_module_15_1() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_15_1));
	}

	public String q_module_15_2() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_15_2));
	}

	public String q_module_15_3() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_15_3));
	}

	public String q_module_15_4() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_15_4));
	}

	public String q_k_10() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.q_module_7_22_result));
	}

	public String getDateAndTime() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.date))
				+ "  "
				+ dataCursor.getString(dataCursor
						.getColumnIndex(PpPatientDBOpenHelper.time));
	}

	public String getDate() {
		return dataCursor.getString(dataCursor
				.getColumnIndex(PpPatientDBOpenHelper.date));
	}

}
