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

public class Module7mhs_fragment_2 extends SherlockFragment implements
		OnClickListener, OnSeekBarChangeListener {

	private AnyTextView tv_score_q_module_7_1, tv_score_q_module_7_2,
			tv_score_q_module_7_3, tv_score_q_module_7_4;
	private SeekBar skb_q_module_7_1, skb_q_module_7_2, skb_q_module_7_3,
			skb_q_module_7_4;

	private int skb_score_1 = -1, skb_score_2 = -1, skb_score_3 = -1,
			skb_score_4 = -1;
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
		view = inflater.inflate(R.layout.module_7_mhs_fragment_2, null, false);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		enabaleView();
		return view;
	}

	private void enabaleView() {
		tv_score_q_module_7_1 = (AnyTextView) view
				.findViewById(R.id.tv_score_q_module_7_1);
		tv_score_q_module_7_2 = (AnyTextView) view
				.findViewById(R.id.tv_score_q_module_7_2);
		tv_score_q_module_7_3 = (AnyTextView) view
				.findViewById(R.id.tv_score_q_module_7_3);
		tv_score_q_module_7_4 = (AnyTextView) view
				.findViewById(R.id.tv_score_q_module_7_4);
		skb_q_module_7_1 = (SeekBar) view.findViewById(R.id.skb_q_module_7_1);
		skb_q_module_7_2 = (SeekBar) view.findViewById(R.id.skb_q_module_7_2);
		skb_q_module_7_3 = (SeekBar) view.findViewById(R.id.skb_q_module_7_3);
		skb_q_module_7_4 = (SeekBar) view.findViewById(R.id.skb_q_module_7_4);
		skb_q_module_7_1.setOnSeekBarChangeListener(this);
		skb_q_module_7_2.setOnSeekBarChangeListener(this);
		skb_q_module_7_3.setOnSeekBarChangeListener(this);
		skb_q_module_7_4.setOnSeekBarChangeListener(this);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:
			listener.pageChange(AppConstants.MODULE_7_PAGE_3);
			getValue();
			break;
		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_7_PAGE_1);
			break;

		}
	}

	private void getValue() {
		AppConstants.q_module_7_1 = String.valueOf(skb_score_1);
		AppConstants.q_module_7_2 = String.valueOf(skb_score_2);
		AppConstants.q_module_7_3 = String.valueOf(skb_score_3);
		AppConstants.q_module_7_4 = String.valueOf(skb_score_4);
		Log.d("AppConstants.q_module_7_1", AppConstants.q_module_7_1);
		Log.d("AppConstants.q_module_7_2", AppConstants.q_module_7_2);
		Log.d("AppConstants.q_module_7_3", AppConstants.q_module_7_3);
		Log.d("AppConstants.q_module_7_4", AppConstants.q_module_7_4);

	}

	@Override
	public void onProgressChanged(SeekBar view, int process, boolean arg2) {
		switch (view.getId()) {
		case R.id.skb_q_module_7_1:
			tv_score_q_module_7_1.setText(String.valueOf(process));
			skb_score_1 = process;

			break;

		case R.id.skb_q_module_7_2:
			tv_score_q_module_7_2.setText(String.valueOf(process));
			skb_score_2 = process;

			break;
		case R.id.skb_q_module_7_3:
			tv_score_q_module_7_3.setText(String.valueOf(process));
			skb_score_3 = process;

			break;
		case R.id.skb_q_module_7_4:
			tv_score_q_module_7_4.setText(String.valueOf(process));
			skb_score_4 = process;

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
		if (skb_score_1 >= 0 && skb_score_2 >= 0 && skb_score_3 >= 0
				& skb_score_4 >= 0) {
			btn_next.setEnabled(true);

		} else {
			btn_next.setEnabled(false);
		}
	}

}
