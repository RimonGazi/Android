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

public class PatientHelpFragmentFirst extends SherlockFragment {
	
	private Button btn_next;
	
	private OnSwitchClickListener listener;
	@Override
	public void onAttach(Activity activity) {
		listener=(StartActivityIBD)getActivity();
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.help_1, null,false);
		
		btn_next=(Button) view.findViewById(R.id.help_1_next);
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_RESULT_PAGE);
				
			}
		});
		return view;
	}

}
