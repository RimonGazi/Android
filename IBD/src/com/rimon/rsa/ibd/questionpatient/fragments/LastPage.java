package com.rimon.rsa.ibd.questionpatient.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.OnSwitchClickListener;
import com.rimon.rsa.ibd.main.StartActivityIBD;
import com.rimon.rsa.mental.R;

public class LastPage extends SherlockFragment {

	private Button btn_end;
	private OnSwitchClickListener listener;

	@Override
	public void onAttach(Activity activity) {
		listener = (StartActivityIBD) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.last_page, null, false);

		btn_end = (Button) view.findViewById(R.id.btn_end_patient_question);
		btn_end.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				newInitializedVariable();
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_START_PAGE);
			}

			
		});
		return view;
	}
	private void newInitializedVariable() {
		ConstantValues.us_pq_1 = true;
		ConstantValues.us_pq_2 = true;
		ConstantValues.us_pq_3 = true;
		ConstantValues.us_pq_4 = true;
		ConstantValues.us_pq_5 = true;
		ConstantValues.us_pq_6 = true;
		
		ConstantValues.us_fq_1 = true;
		ConstantValues.us_fq_2 = true;
		ConstantValues.us_fq_3 = true;
		ConstantValues.us_fq_4 = true;
		
		ConstantValues.us_patient_result=true;
		ConstantValues.us_patient_score=true;
		
		
		// first page question
		ConstantValues.question_1_value = "";
		ConstantValues.question_2_value = "";
		ConstantValues.question_3_value = "";
		ConstantValues.question_4_value = "";
		ConstantValues.question_5_value = "";

		// second page question
		ConstantValues.question_6_value = "";
		ConstantValues.question_7_value = "";
		ConstantValues.question_8_value = "";
		ConstantValues.question_9_value = "";
		ConstantValues.question_10_value = "";
		ConstantValues.question_11_value = "";

		// third page 12-18
		ConstantValues.question_12_value = "";
		ConstantValues.question_13_value = "";
		ConstantValues.question_14_value = "";
		ConstantValues.question_15_value = "";
		ConstantValues.question_16_value = "";
		ConstantValues.question_17_value = "";
		ConstantValues.question_18_value = "";
		// fourth page 19 -25
		ConstantValues.question_19_value = "";
		ConstantValues.question_20_value = "";
		ConstantValues.question_21_value = "";
		ConstantValues.question_22_value = "";
		ConstantValues.question_23_value = "";
		ConstantValues.question_24_value = "";
		ConstantValues.question_25_value = "";

		// fifth page 26-32
		ConstantValues.question_26_value = "";
		ConstantValues.question_27_value = "";
		ConstantValues.question_28_value = "";
		ConstantValues.question_29_value = "";
		ConstantValues.question_30_value = "";
		ConstantValues.question_31_value = "";
		ConstantValues.question_32_value = "";
		// sixth page
		ConstantValues.question_33_value = "";
		ConstantValues.question_34_value = "";
		ConstantValues.question_35_value = "";
		ConstantValues.question_36_value = "";
		ConstantValues.question_37_value = "";

		ConstantValues.f_question_1_value = "";
		ConstantValues.f_question_2_value = "";
		ConstantValues.f_question_3_value = "";
		ConstantValues.f_question_4_value = "";
		ConstantValues.f_question_5_value = "";
		ConstantValues.f_question_6_value = "";
		ConstantValues.f_question_7_value = "";
		ConstantValues.f_question_8_value = "";
		ConstantValues.f_question_9_value = "";
		ConstantValues.f_question_10_value = "";
		ConstantValues.f_question_11_value = "";
		ConstantValues.f_question_12_value = "";
		ConstantValues.f_question_13_value = "";
		ConstantValues.f_question_14_value = "";
		ConstantValues.f_question_15_value = "";
		ConstantValues.f_question_16_value = "";
		ConstantValues.f_question_17_value = "";
		

		
		// pataString scrore
		ConstantValues.result_level = "";
		ConstantValues.depression = "0";
		ConstantValues.anxiety = "0";
		ConstantValues.stress = "0";

		ConstantValues.depression_level = "0";
		ConstantValues.anxiety_level = "0";
		ConstantValues.stress_level = "0";
		ConstantValues.all_question_status="";
		
	}
}
