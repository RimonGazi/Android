package com.rimon.rsa.ipaeps.module_3_ibd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module3IbdFragment2 extends SherlockFragment implements
		OnCheckedChangeListener {
	private AnyPageChangeListener listener;
	private AnyButton btn_next, btn_previous;
	private RadioGroup rg_q_module_3_6_1, rg_q_module_3_6_2, rg_q_module_3_7_1,
			rg_q_module_3_7_2, rg_q_module_3_8, rg_q_module_3_9,
			rg_q_module_3_10;
	private int check_id_6, check_id_7, check_id_8, check_id_9, check_id_10;
	private View view;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module3Ibd) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.module_3_ibd_fragment_2, null, false);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);

		rg_q_module_3_6_1 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_6_1);
		rg_q_module_3_6_2 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_6_2);
		rg_q_module_3_7_1 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_7_1);
		rg_q_module_3_7_2 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_7_2);
		rg_q_module_3_8 = (RadioGroup) view.findViewById(R.id.rg_q_module_3_8);
		rg_q_module_3_9 = (RadioGroup) view.findViewById(R.id.rg_q_module_3_9);
		rg_q_module_3_10 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_10);
		rg_q_module_3_6_1.clearCheck();
		rg_q_module_3_6_2.clearCheck();
		rg_q_module_3_7_1.clearCheck();
		rg_q_module_3_7_2.clearCheck();
		rg_q_module_3_8.clearCheck();
		rg_q_module_3_9.clearCheck();
		rg_q_module_3_10.clearCheck();
		rg_q_module_3_6_1.setOnCheckedChangeListener(this);
		rg_q_module_3_6_2.setOnCheckedChangeListener(this);
		rg_q_module_3_7_1.setOnCheckedChangeListener(this);
		rg_q_module_3_7_2.setOnCheckedChangeListener(this);
		rg_q_module_3_8.setOnCheckedChangeListener(this);
		rg_q_module_3_9.setOnCheckedChangeListener(this);
		rg_q_module_3_10.setOnCheckedChangeListener(this);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AppConstants.q_module_3_6 = ((RadioButton) view
						.findViewById(check_id_6)).getText().toString();

				AppConstants.q_module_3_7 = ((RadioButton) view
						.findViewById(check_id_7)).getText().toString();

				AppConstants.q_module_3_8 = ((RadioButton) view
						.findViewById(check_id_8)).getText().toString();

				AppConstants.q_module_3_9 = ((RadioButton) view
						.findViewById(check_id_9)).getText().toString();

				AppConstants.q_module_3_10 = ((RadioButton) view
						.findViewById(check_id_10)).getText().toString();

				listener.pageChange(AppConstants.MODULE_3_PAGE_3);

				Log.d("AppConstants.q_module_3_6", AppConstants.q_module_3_6);
				Log.d("AppConstants.q_module_3_7", AppConstants.q_module_3_7);
				Log.d("AppConstants.q_module_3_8", AppConstants.q_module_3_8);
				Log.d("AppConstants.q_module_3_9", AppConstants.q_module_3_9);
				Log.d("AppConstants.q_module_3_10", AppConstants.q_module_3_10);

			}

		});
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_3_PAGE_1);

			}
		});

		return view;
	}

	@Override
	public void onCheckedChanged(RadioGroup viGroup, int check_id) {

		switch (viGroup.getId()) {
		case R.id.rg_q_module_3_6_1:
			if (check_id != -1) {
				rg_q_module_3_6_2.setOnCheckedChangeListener(null);
				rg_q_module_3_6_2.clearCheck();
				rg_q_module_3_6_2.setOnCheckedChangeListener(this);
			}

			break;

		case R.id.rg_q_module_3_6_2:
			if (check_id != -1) {
				rg_q_module_3_6_1.setOnCheckedChangeListener(null);
				rg_q_module_3_6_1.clearCheck();
				rg_q_module_3_6_1.setOnCheckedChangeListener(this);
				Log.d("rg_q_module_3_6_1", "checked");

			}
			break;
		case R.id.rg_q_module_3_7_1:
			if (check_id != -1) {
				rg_q_module_3_7_2.setOnCheckedChangeListener(null);
				rg_q_module_3_7_2.clearCheck();
				rg_q_module_3_7_2.setOnCheckedChangeListener(this);
			}

			break;

		case R.id.rg_q_module_3_7_2:
			if (check_id != -1) {
				rg_q_module_3_7_1.setOnCheckedChangeListener(null);
				rg_q_module_3_7_1.clearCheck();
				rg_q_module_3_7_1.setOnCheckedChangeListener(this);
			}
		}
		checkNextButtonVisible();
	}

	private void checkNextButtonVisible() {

		check_id_6 = rg_q_module_3_6_1.getCheckedRadioButtonId() != -1 ? rg_q_module_3_6_1
				.getCheckedRadioButtonId() : rg_q_module_3_6_2
				.getCheckedRadioButtonId();

		check_id_7 = rg_q_module_3_7_1.getCheckedRadioButtonId() != -1 ? rg_q_module_3_7_1
				.getCheckedRadioButtonId() : rg_q_module_3_7_2
				.getCheckedRadioButtonId();
		check_id_8 = rg_q_module_3_8.getCheckedRadioButtonId();
		check_id_9 = rg_q_module_3_9.getCheckedRadioButtonId();
		check_id_10 = rg_q_module_3_10.getCheckedRadioButtonId();

		if ((check_id_6 != -1) && (check_id_7 != -1) && (check_id_8 != -1)
				&& (check_id_9 != -1) && (check_id_10 != -1)) {
			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}
}
