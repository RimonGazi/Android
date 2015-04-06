package com.rimon.rsa.ipaeps.module_3_ibd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

public class Module3IbdFragment3 extends SherlockFragment implements
		UpdateFragment, OnCheckedChangeListener, OnClickListener {
	private AnyPageChangeListener listener;
	private RadioGroup rg_q_module_3_11_1, rg_q_module_3_11_2;
	private int check_id_11;
	private View view;
	private AnyButton btn_next, btn_previous;

	private CheckBox radio19, radio20, radio21, radio22, radio23, radio24,
			radio25, radio26, radio27, radio28;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module3Ibd) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.module_3_ibd_fragment_3, null, false);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);

		rg_q_module_3_11_1 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_11_1);
		rg_q_module_3_11_2 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_11_2);
		rg_q_module_3_11_1.clearCheck();
		rg_q_module_3_11_2.clearCheck();
		rg_q_module_3_11_1.setOnCheckedChangeListener(this);
		rg_q_module_3_11_2.setOnCheckedChangeListener(this);

		radio19 = (CheckBox) view.findViewById(R.id.radio19);
		radio20 = (CheckBox) view.findViewById(R.id.radio20);
		radio21 = (CheckBox) view.findViewById(R.id.radio21);
		radio22 = (CheckBox) view.findViewById(R.id.radio22);
		radio23 = (CheckBox) view.findViewById(R.id.radio23);
		radio24 = (CheckBox) view.findViewById(R.id.radio24);
		radio25 = (CheckBox) view.findViewById(R.id.radio25);
		radio26 = (CheckBox) view.findViewById(R.id.radio26);
		radio27 = (CheckBox) view.findViewById(R.id.radio27);
		radio28 = (CheckBox) view.findViewById(R.id.radio28);

		radio19.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio20.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio21.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio22.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio23.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio24.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio25.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio26.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio27.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio28.setTypeface(AppObject.getCurrentFont(getActivity()));

		radio19.setOnClickListener(this);
		radio20.setOnClickListener(this);
		radio21.setOnClickListener(this);
		radio22.setOnClickListener(this);
		radio23.setOnClickListener(this);
		radio24.setOnClickListener(this);
		radio25.setOnClickListener(this);
		radio26.setOnClickListener(this);
		radio27.setOnClickListener(this);
		radio28.setOnClickListener(this);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AppConstants.q_module_3_11 = ((RadioButton) view
						.findViewById(check_id_11)).getText().toString();

				getQuestion3_12_value();

				listener.pageChange(AppConstants.MODULE_3_PAGE_4);
				Log.d("AppConstants.q_module_3_11", AppConstants.q_module_3_11);
				Log.d("AppConstants.q_module_3_12", AppConstants.q_module_3_12);

			}

		});
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_3_PAGE_2);

			}
		});

		return view;
	}

	@Override
	public void onCheckedChanged(RadioGroup viGroup, int check_id) {

		switch (viGroup.getId()) {
		case R.id.rg_q_module_3_11_1:
			if (check_id != -1) {
				rg_q_module_3_11_2.setOnCheckedChangeListener(null);
				rg_q_module_3_11_2.clearCheck();
				rg_q_module_3_11_2.setOnCheckedChangeListener(this);
			}

			break;

		case R.id.rg_q_module_3_11_2:
			if (check_id != -1) {
				rg_q_module_3_11_1.setOnCheckedChangeListener(null);
				rg_q_module_3_11_1.clearCheck();
				rg_q_module_3_11_1.setOnCheckedChangeListener(this);

			}
			break;

		}
		checkNextButtonVisible();
	}

	private void checkNextButtonVisible() {
		check_id_11 = rg_q_module_3_11_1.getCheckedRadioButtonId() == -1 ? rg_q_module_3_11_2
				.getCheckedRadioButtonId() : rg_q_module_3_11_1
				.getCheckedRadioButtonId();

		if ((check_id_11 != -1) && checkQuestion3_12())
			btn_next.setEnabled(true);

	}

	@Override
	public void Update() {

	}

	private boolean checkQuestion3_12() {

		if (radio19.isChecked()) {
			return true;
		} else if (radio20.isChecked()) {
			return true;
		} else if (radio21.isChecked()) {
			return true;
		} else if (radio22.isChecked()) {
			return true;
		} else if (radio23.isChecked()) {
			return true;
		} else if (radio24.isChecked()) {
			return true;
		} else if (radio25.isChecked()) {
			return true;
		} else if (radio26.isChecked()) {
			return true;
		} else if (radio27.isChecked()) {
			return true;
		} else if (radio28.isChecked()) {
			return true;
		} else {
			return false;
		}

	}

	private void getQuestion3_12_value() {
		AppConstants.q_module_3_12 = "";
		if (radio19.isChecked())
			AppConstants.q_module_3_12 += radio19.getText().toString() + ", ";
		if (radio20.isChecked())
			AppConstants.q_module_3_12 += radio20.getText().toString() + ", ";
		if (radio21.isChecked())
			AppConstants.q_module_3_12 += radio21.getText().toString() + ", ";
		if (radio22.isChecked())
			AppConstants.q_module_3_12 += radio22.getText().toString() + ", ";
		if (radio23.isChecked())
			AppConstants.q_module_3_12 += radio23.getText().toString() + ", ";
		if (radio24.isChecked())
			AppConstants.q_module_3_12 += radio24.getText().toString() + ", ";
		if (radio25.isChecked())
			AppConstants.q_module_3_12 += radio25.getText().toString() + ", ";
		if (radio26.isChecked())
			AppConstants.q_module_3_12 += radio26.getText().toString() + ", ";
		if (radio27.isChecked())
			AppConstants.q_module_3_12 += radio27.getText().toString() + ", ";
		if (radio28.isChecked())
			AppConstants.q_module_3_12 += radio28.getText().toString() + ", ";

		if (AppConstants.q_module_3_12.equals("")) {
			AppConstants.q_module_3_12 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_3_12 = (AppConstants.q_module_3_12)
					.substring(0, (AppConstants.q_module_3_12).length() - 2);
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.radio19:
		case R.id.radio20:
		case R.id.radio21:
		case R.id.radio22:
		case R.id.radio23:
		case R.id.radio24:
		case R.id.radio25:
		case R.id.radio26:
		case R.id.radio27:
		case R.id.radio28:
			checkNextButtonVisible();
			break;
		}
	}
}