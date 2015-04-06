package com.rimon.rsa.ibd.feedbackquestionfragments;

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

public class FeedBackFirstHelp extends SherlockFragment {
	private OnSwitchClickListener listener;
	private Button btn_next, btn_back;

	@Override
	public void onAttach(Activity activity) {
		listener = (OnSwitchClickListener) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.mid_fb, null, false);
		btn_next = (Button) view.findViewById(R.id.btn_mid_fb_next);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_SECOND_PAGE);

			}
		});
		btn_back = (Button) view.findViewById(R.id.btn_mid_fb_back);
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_FIRST_PAGE);
			}
		});
		return view;
	}

}
