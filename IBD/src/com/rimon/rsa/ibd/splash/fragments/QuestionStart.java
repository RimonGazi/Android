package com.rimon.rsa.ibd.splash.fragments;

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
import com.rimon.rsa.mental.R;

public class QuestionStart extends SherlockFragment {
	private OnSwitchClickListener listener;

	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		listener = (OnSwitchClickListener) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.start_page, null, false);

		Button btn_start = (Button) view
				.findViewById(R.id.btn_start_patient_question);
		btn_start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_FIRST_PAGE);

			}
		});
		return view;
	}

}
