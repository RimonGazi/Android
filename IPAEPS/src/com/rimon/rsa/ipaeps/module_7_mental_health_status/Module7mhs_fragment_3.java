package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module7mhs_fragment_3 extends SherlockFragment implements
		OnClickListener, OnSeekBarChangeListener {

	private AnyTextView tv_score_q_module_7_5, tv_score_q_module_7_6;
	private SeekBar skb_q_module_7_5, skb_q_module_7_6;

	private int skb_score_5 = -1, skb_score_6 = -1;
	private AnyButton btn_next, btn_previous;
	private AnyPageChangeListener listener;
	private View view;

	@Override
	public void onAttach(Activity activity) {
		listener = (Module7MentalHealth) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.module_7_mhs_fragment_3, null, false);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		enabaleView();
		return view;
	}

	private void enabaleView() {
		tv_score_q_module_7_5 = (AnyTextView) view
				.findViewById(R.id.tv_score_q_module_7_5);
		tv_score_q_module_7_6 = (AnyTextView) view
				.findViewById(R.id.tv_score_q_module_7_6);

		skb_q_module_7_5 = (SeekBar) view.findViewById(R.id.skb_q_module_7_5);
		skb_q_module_7_6 = (SeekBar) view.findViewById(R.id.skb_q_module_7_6);

		skb_q_module_7_5.setOnSeekBarChangeListener(this);
		skb_q_module_7_6.setOnSeekBarChangeListener(this);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:
			listener.pageChange(AppConstants.MODULE_7_PAGE_4);
			getValue();
			break;
		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_7_PAGE_2);
			break;

		}
	}

	private void getValue() {
		AppConstants.q_module_7_5 = String.valueOf(skb_score_5);
		AppConstants.q_module_7_6 = String.valueOf(skb_score_6);
		Log.d("AppConstants.q_module_7_5", AppConstants.q_module_7_5);
		Log.d("AppConstants.q_module_7_6", AppConstants.q_module_7_6);

	}

	@Override
	public void onProgressChanged(SeekBar view, int process, boolean arg2) {
		switch (view.getId()) {
		case R.id.skb_q_module_7_5:
			tv_score_q_module_7_5.setText(String.valueOf(process));
			skb_score_5 = process;

			break;

		case R.id.skb_q_module_7_6:
			tv_score_q_module_7_6.setText(String.valueOf(process));
			skb_score_6 = process;

			break;

		}
		checkNextButtonVigible();

	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	private void checkNextButtonVigible() {
		if (skb_score_5 >= 0 && skb_score_6 >= 0) {
			btn_next.setEnabled(true);

		} else {
			btn_next.setEnabled(false);
		}
	}

}
