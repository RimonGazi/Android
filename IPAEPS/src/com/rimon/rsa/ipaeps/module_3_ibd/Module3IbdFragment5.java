package com.rimon.rsa.ipaeps.module_3_ibd;

import android.app.Activity;
import android.content.Intent;
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
import com.rimon.rsa.ipaeps.appdatabase.SavePatientData;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.classtorun.ClassRunActivity;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

import java.util.ArrayList;

public class Module3IbdFragment5 extends SherlockFragment implements
		UpdateFragment, OnSeekBarChangeListener {
	private AnyPageChangeListener listener;
	private AnyTextView tv_q_module_17, tv_q_module_18, tv_q_module_19;
	private SeekBar skb__q_module_17, skb__q_module_18, skb__q_module_19;
	private View view;
	private int value_17 = -1, value_18 = -1, value_19 = -1;
	private AnyButton btn_next, btn_previous;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module3Ibd) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.module_3_ibd_fragment_5, null, false);
		value_17 = value_18 = value_19 = -1;
		tv_q_module_17 = (AnyTextView) view.findViewById(R.id.tv_q_module_17);
		tv_q_module_18 = (AnyTextView) view.findViewById(R.id.tv_q_module_18);
		tv_q_module_19 = (AnyTextView) view.findViewById(R.id.tv_q_module_19);
		skb__q_module_17 = (SeekBar) view.findViewById(R.id.skb__q_module_17);
		skb__q_module_18 = (SeekBar) view.findViewById(R.id.skb__q_module_18);
		skb__q_module_19 = (SeekBar) view.findViewById(R.id.skb__q_module_19);

		skb__q_module_17.setOnSeekBarChangeListener(this);
		skb__q_module_18.setOnSeekBarChangeListener(this);
		skb__q_module_19.setOnSeekBarChangeListener(this);

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(getIntentToRun());
				getActivity().finish();

				Log.d("AppConstants.q_module_3_1", AppConstants.q_module_3_1);
				Log.d("AppConstants.q_module_3_2", AppConstants.q_module_3_2);
				Log.d("AppConstants.q_module_3_3", AppConstants.q_module_3_3);
				Log.d("AppConstants.q_module_3_4", AppConstants.q_module_3_4);
				Log.d("AppConstants.q_module_3_5", AppConstants.q_module_3_5);

				Log.d("AppConstants.q_module_3_6", AppConstants.q_module_3_6);
				Log.d("AppConstants.q_module_3_7", AppConstants.q_module_3_7);
				Log.d("AppConstants.q_module_3_8", AppConstants.q_module_3_8);
				Log.d("AppConstants.q_module_3_9", AppConstants.q_module_3_9);
				Log.d("AppConstants.q_module_3_10", AppConstants.q_module_3_10);

				Log.d("AppConstants.q_module_3_11", AppConstants.q_module_3_11);
				Log.d("AppConstants.q_module_3_12", AppConstants.q_module_3_12);

				Log.d("AppConstants.q_module_3_13", AppConstants.q_module_3_13);
				Log.d("AppConstants.q_module_3_14", AppConstants.q_module_3_14);
				Log.d("AppConstants.q_module_3_15", AppConstants.q_module_3_15);
				Log.d("AppConstants.q_module_3_16", AppConstants.q_module_3_16);

				Log.d("AppConstants.q_module_3_17", AppConstants.q_module_3_17);
				Log.d("AppConstants.q_module_3_18", AppConstants.q_module_3_18);
				Log.d("AppConstants.q_module_3_19", AppConstants.q_module_3_19);
			}
		});
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_3_PAGE_4);

			}
		});

		return view;
	}

	@Override
	public void Update() {

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {

		switch (seekBar.getId()) {
		case R.id.skb__q_module_17:
			value_17 = progress;
			tv_q_module_17.setText(String.valueOf(value_17));
			AppConstants.q_module_3_17 = String.valueOf(value_17);
			break;

		case R.id.skb__q_module_18:
			value_18 = progress;
			tv_q_module_18.setText(String.valueOf(value_18));
			AppConstants.q_module_3_18 = String.valueOf(value_18);
			break;
		case R.id.skb__q_module_19:
			value_19 = progress;
			tv_q_module_19.setText(String.valueOf(value_19));
			AppConstants.q_module_3_19 = String.valueOf(value_19);
			break;
		}

		checkNextButtonVisible();

	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	private void checkNextButtonVisible() {
		if (value_17 >= 0 && value_18 >= 0 && value_19 >= 0) {
			btn_next.setEnabled(true);
		}
	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getActivity().getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");
		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(getActivity(), classes.get(order_activity));

		Bundle bundleTo = new Bundle();
		bundleTo.putSerializable(ClassRunActivity.RUNID, classes);
		bundleTo.putInt("order", ++order_activity);
		intent.putExtras(bundleTo);
		if (order_activity == classes.size()) {
			(new SavePatientData(getActivity())).execute("");
		}
		return intent;
	}
}
