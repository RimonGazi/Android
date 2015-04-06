package com.rimon.rsa.ipaeps.module;

import android.content.Context;

import com.rimon.rsa.ipaeps.R;

public class ModuleName {
	private Context context;

	public ModuleName(Context context) {
		this.context = context;
	}

	public String getModuleName_1() {
		return context.getResources().getString(R.string.patient_id);
	}

	public String getModuleName_2() {
		return context.getResources().getString(R.string.demographic_details);
	}

	public String getModuleName_3() {
		return context.getResources().getString(R.string.ibd_activity);
	}

	public String getModuleName_4() {
		return context.getResources().getString(R.string.medications);
	}

	public String getModuleName_5() {
		return context.getResources().getString(R.string.medication_adherence);
	}

	public String getModuleName_6() {
		return context.getResources().getString(R.string.pain_symptoms);
	}

	public String getModuleName_7() {
		return context.getResources().getString(R.string.mental_health_status);
	}

	public String getModuleName_8() {
		return context.getResources().getString(
				R.string.mental_health_status_feed_back);
	}

	public String getModuleName_9() {
		return context.getResources().getString(R.string.you_diet);
	}

	public String getModuleName_10() {
		return context.getResources().getString(R.string.patient_confidence);
	}

	public String getModuleName_11() {
		return context.getResources().getString(
				R.string.patient_questions_concerns);
	}

	public String getModuleName_12() {
		return context.getResources().getString(
				R.string.responses_to_past_goals);
	}

	public String getModuleName_13() {
		return context.getResources().getString(
				R.string.setting_goals_to_better);
	}

	public String getModuleName_14() {
		return context.getResources().getString(R.string.identifying_problems);
	}

	public String getModuleName_15() {
		return context.getResources().getString(R.string.program_evaluation_2);

	}
	

}
