package com.rimon.rsa.ipaeps.classtorun;

import android.content.Context;

import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpSettingModuleDBOpenHelper;
import com.rimon.rsa.ipaeps.module_10_patient_confidence.Module10MentalHealthStatus;
import com.rimon.rsa.ipaeps.module_11_patient_questions_concerns.Module11PatientQuestionsConcerns;
import com.rimon.rsa.ipaeps.module_12_goals.Module12Goals;
import com.rimon.rsa.ipaeps.module_13_settign_goals.Module13SettingGoals;
import com.rimon.rsa.ipaeps.module_14_identify_problems.Module14IdentifyProblems;
import com.rimon.rsa.ipaeps.module_15_program_evaluation.Module15ProgramEvaluation;
import com.rimon.rsa.ipaeps.module_16_last_screen.Module16LastScreen;
import com.rimon.rsa.ipaeps.module_1_patient_id.Module1PatientID;
import com.rimon.rsa.ipaeps.module_2_demographic_details.Module2DemographicDetails;
import com.rimon.rsa.ipaeps.module_3_ibd.Module3Ibd;
import com.rimon.rsa.ipaeps.module_4.medications.Module4Medications;
import com.rimon.rsa.ipaeps.module_5_medication_adherence.Module5MedicalAdherence;
import com.rimon.rsa.ipaeps.module_6_pain.Module6Pain;
import com.rimon.rsa.ipaeps.module_7_mental_health_status.Module7MentalHealth;
import com.rimon.rsa.ipaeps.module_8_mental_health_status_feedback.Module8MentalHealthStatusFeedBacck;
import com.rimon.rsa.ipaeps.module_9_diet.Module9Diet;
import com.rimon.rsa.ipaes.setting.ModuleSettingData;
import com.rimon.rsa.ipaes.setting.SettingConstants;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassRunActivity implements Serializable {

	public static final String RUNID = "runid";
	private static final long serialVersionUID = 14393745L;
	private ModuleSettingData moduleSettingData;
	private PpSettingModuleDBOpenHelper ppSettingModuleDBOpenHelper;
	private ArrayList<Class<?>> activityClass;
	private Context context;

	public ClassRunActivity(Context cnt) {
		this.context = cnt;

	}

	public ArrayList<Class<?>> getClassToRun() {

		activityClass = new ArrayList<Class<?>>();
		ppSettingModuleDBOpenHelper = DatabaseCreator
				.getPpSettingModuleDBOpenHelper(context);
		moduleSettingData = ppSettingModuleDBOpenHelper.getModuleSettingData();

		if ((moduleSettingData.getRun_state() == SettingConstants.DEFAULT_MODULE)
				|| (moduleSettingData.getRun_state() == SettingConstants.PRESET_MODULE)) {

			if (moduleSettingData.getModule_order_1() == 1) {
				activityClass.add(Module1PatientID.class);
			}
			if (moduleSettingData.getModule_order_2() == 1) {
				activityClass.add(Module2DemographicDetails.class);

			}
			if (moduleSettingData.getModule_order_3() == 1) {
				activityClass.add(Module3Ibd.class);

			}
			if (moduleSettingData.getModule_order_4() == 1) {
				activityClass.add(Module4Medications.class);

			}

			if (moduleSettingData.getModule_order_5() == 1) {
				activityClass.add(Module5MedicalAdherence.class);

			}

			if (moduleSettingData.getModule_order_6() == 1) {
				activityClass.add(Module6Pain.class);

			}

			if (moduleSettingData.getModule_order_7() == 1) {
				activityClass.add(Module7MentalHealth.class);

			}

			if (moduleSettingData.getModule_order_8() == 1) {
				activityClass.add(Module8MentalHealthStatusFeedBacck.class);

			}

			if (moduleSettingData.getModule_order_9() == 1) {
				activityClass.add(Module9Diet.class);

			}
			if (moduleSettingData.getModule_order_10() == 1) {
				activityClass.add(Module10MentalHealthStatus.class);

			}

			if (moduleSettingData.getModule_order_11() == 1) {
				activityClass.add(Module11PatientQuestionsConcerns.class);

			}

			if (moduleSettingData.getModule_order_12() == 1) {
				activityClass.add(Module12Goals.class);

			}
			if (moduleSettingData.getModule_order_13() == 1) {
				activityClass.add(Module13SettingGoals.class);

			}

			if (moduleSettingData.getModule_order_14() == 1) {
				activityClass.add(Module14IdentifyProblems.class);

			}

			if (moduleSettingData.getModule_order_15() == 1) {
				activityClass.add(Module15ProgramEvaluation.class);

			}

			if (moduleSettingData.getModule_order_16() == 1) {
				activityClass.add(Module16LastScreen.class);
			}
		} else if (moduleSettingData.getRun_state() == SettingConstants.COUSTOM_MODULE) {
			for (int i = 0; i < moduleSettingData.getModule_order_16(); i++) {
				activityClass.add(i, null);
			}
			if (moduleSettingData.getModule_order_1() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_1() - 1);
				activityClass.add(moduleSettingData.getModule_order_1() - 1,
						Module1PatientID.class);
			}
			if (moduleSettingData.getModule_order_2() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_2() - 1);
				activityClass.add(moduleSettingData.getModule_order_2() - 1,
						Module2DemographicDetails.class);

			}
			if (moduleSettingData.getModule_order_3() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_3() - 1);
				activityClass.add(moduleSettingData.getModule_order_3() - 1,
						Module3Ibd.class);

			}
			if (moduleSettingData.getModule_order_4() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_4() - 1);
				activityClass.add(moduleSettingData.getModule_order_4() - 1,
						Module4Medications.class);

			}

			if (moduleSettingData.getModule_order_5() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_5() - 1);
				activityClass.add(moduleSettingData.getModule_order_5() - 1,
						Module5MedicalAdherence.class);

			}

			if (moduleSettingData.getModule_order_6() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_6() - 1);
				activityClass.add(moduleSettingData.getModule_order_6() - 1,
						Module6Pain.class);

			}

			if (moduleSettingData.getModule_order_7() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_7() - 1);
				activityClass.add(moduleSettingData.getModule_order_7() - 1,
						Module7MentalHealth.class);

			}

			if (moduleSettingData.getModule_order_8() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_8() - 1);
				activityClass.add(moduleSettingData.getModule_order_8() - 1,
						Module8MentalHealthStatusFeedBacck.class);

			}

			if (moduleSettingData.getModule_order_9() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_9() - 1);
				activityClass.add(moduleSettingData.getModule_order_9() - 1,
						Module9Diet.class);

			}
			if (moduleSettingData.getModule_order_10() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_10() - 1);
				activityClass.add(moduleSettingData.getModule_order_10() - 1,
						Module10MentalHealthStatus.class);

			}

			if (moduleSettingData.getModule_order_11() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_11() - 1);
				activityClass.add(moduleSettingData.getModule_order_11() - 1,
						Module11PatientQuestionsConcerns.class);

			}

			if (moduleSettingData.getModule_order_12() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_12() - 1);
				activityClass.add(moduleSettingData.getModule_order_12() - 1,
						Module12Goals.class);

			}
			if (moduleSettingData.getModule_order_13() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_13() - 1);
				activityClass.add(moduleSettingData.getModule_order_13() - 1,
						Module13SettingGoals.class);

			}

			if (moduleSettingData.getModule_order_14() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_14() - 1);
				activityClass.add(moduleSettingData.getModule_order_14() - 1,
						Module14IdentifyProblems.class);

			}

			if (moduleSettingData.getModule_order_15() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_15() - 1);
				activityClass.add(moduleSettingData.getModule_order_15() - 1,
						Module15ProgramEvaluation.class);

			}

			if (moduleSettingData.getModule_order_16() >= 1) {
				activityClass.remove(moduleSettingData.getModule_order_16() - 1);
				activityClass.add(moduleSettingData.getModule_order_16() - 1,
						Module16LastScreen.class);
			}

		}
		return activityClass;
	}

}
