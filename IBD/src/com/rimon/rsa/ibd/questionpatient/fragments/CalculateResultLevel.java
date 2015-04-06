package com.rimon.rsa.ibd.questionpatient.fragments;

import java.util.Arrays;

import com.rimon.rsa.ibd.main.ConstantValues;

public class CalculateResultLevel {
	private int dss_final_level = 0, anx_final_level = 0, str_final_level = 0;

	public String calculateResult(int dss_result, int anx_result,
			int str_result, String contString) {

		if ((dss_result >= 0) && (dss_result <= 4)) {
			dss_final_level = 1;
		} else if ((dss_result >= 5) && (dss_result <= 10)) {
			dss_final_level = 2;
		} else if ((dss_result >= 11) && (dss_result <= 13)) {
			dss_final_level = 3;
		} else if ((dss_result >= 14) && (dss_result <= 21)) {
			dss_final_level = 4;
		}

		if ((anx_result >= 0) && (anx_result <= 3)) {
			anx_final_level = 1;
		} else if ((anx_result >= 4) && (anx_result <= 7)) {
			anx_final_level = 2;
		} else if ((anx_result >= 8) && (anx_result <= 9)) {
			anx_final_level = 3;
		} else if ((anx_result >= 10) && (anx_result <= 21)) {
			anx_final_level = 4;
		}

		if ((str_result >= 0) && (str_result <= 7)) {
			str_final_level = 1;
		} else if ((str_result >= 8) && (str_result <= 12)) {
			str_final_level = 2;
		} else if ((str_result >= 13) && (str_result <= 16)) {
			str_final_level = 3;
		} else if ((str_result >= 17) && (str_result <= 21)) {
			str_final_level = 4;
		}
		int sort_leve[] = {anx_final_level, dss_final_level };
		Arrays.sort(sort_leve);

		if (contString.equals("YES")) {
			if (sort_leve[sort_leve.length - 1] <= 2) {
				return ConstantValues.MODERATE;
			}

		}

		if (sort_leve[sort_leve.length - 1] == 1)
			return ConstantValues.VERY_LOW;
		else if (sort_leve[sort_leve.length - 1] == 2)
			return ConstantValues.LOW;
		else if (sort_leve[sort_leve.length - 1] == 3)
			return ConstantValues.MODERATE;
		else
			return ConstantValues.HIGH;

	}

	public String get_depression_level() {
		if (dss_final_level == 1)
			return ConstantValues.VERY_LOW;
		else if (dss_final_level == 2)
			return ConstantValues.LOW;
		else if (dss_final_level == 3)
			return ConstantValues.MODERATE;
		else
			return ConstantValues.HIGH;

	}

	public String get_anxiety_level() {
		if (anx_final_level == 1)
			return ConstantValues.VERY_LOW;
		else if (anx_final_level == 2)
			return ConstantValues.LOW;
		else if (anx_final_level == 3)
			return ConstantValues.MODERATE;
		else
			return ConstantValues.HIGH;
	}

	public String get_stress_level() {
		if (str_final_level == 1)
			return ConstantValues.VERY_LOW;
		else if (str_final_level == 2)
			return ConstantValues.LOW;
		else if (str_final_level == 3)
			return ConstantValues.MODERATE;
		else
			return ConstantValues.HIGH;
	}
}
