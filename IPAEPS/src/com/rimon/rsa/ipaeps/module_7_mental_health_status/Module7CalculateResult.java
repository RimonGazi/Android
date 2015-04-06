package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import com.rimon.rsa.ipaeps.appconstants.AppConstants;

public class Module7CalculateResult {
	public static final String module_7_result_level_green = "Result_level_green";
	public static final String module_7_result_level_yellow = "Result_level_yellow";
	public static final String module_7_result_level_red = "Result_level_red";

	protected void calculateResult() {
		int tempValue = Integer.valueOf(AppConstants.q_module_7_12)
				+ Integer.valueOf(AppConstants.q_module_7_13)
				+ Integer.valueOf(AppConstants.q_module_7_14)
				+ Integer.valueOf(AppConstants.q_module_7_15)
				+ Integer.valueOf(AppConstants.q_module_7_16)
				+ Integer.valueOf(AppConstants.q_module_7_17)
				+ Integer.valueOf(AppConstants.q_module_7_18)
				+ Integer.valueOf(AppConstants.q_module_7_19)
				+ Integer.valueOf(AppConstants.q_module_7_20)
				+ Integer.valueOf(AppConstants.q_module_7_21);
		AppConstants.q_module_7_22_result = String.valueOf(tempValue);
		// Green feedback = K10 score <= 20
		// Yellow feedback = K10 score 21-29
		// RED feedback = K10 score >30

		if (tempValue <= 20) {
			AppConstants.q_module_7_23_result_level = module_7_result_level_green;
		} else if (tempValue >= 21 && tempValue <= 29) {
			AppConstants.q_module_7_23_result_level = module_7_result_level_yellow;
		} else if (tempValue >= 30 && tempValue <= 50) {
			AppConstants.q_module_7_23_result_level = module_7_result_level_red;
		}
	}
}
