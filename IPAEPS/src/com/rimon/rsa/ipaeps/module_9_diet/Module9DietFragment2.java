package com.rimon.rsa.ipaeps.module_9_diet;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

public class Module9DietFragment2 extends SherlockFragment implements
		OnClickListener, OnCheckedChangeListener, UpdateFragment, TextWatcher {
	private AnyPageChangeListener listener;
	private EditText et_q_module_9_3;
	private String et_value_9_3 = "";

	// private boolean c_m_s_q_1, c_m_s_q_2, c_m_s_q_3, c_m_s_q_4, c_m_s_q_5;
	private AnyButton btn_next, btn_previous;
	private CheckBox cb_9_3_1, cb_9_3_2, cb_9_3_3, cb_9_3_4, cb_9_3_5,
			cb_9_3_6, cb_9_3_7, cb_9_3_8;
	private View view;
	private RadioGroup rg_q_module_9_4;
	private AnyTextView tv_q_module_3, tv_q_module_4;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module9Diet) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.module_9_diet_fragment_2, null, false);
		initializediew();

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getValue();
				listener.pageChange(AppConstants.MODULE_9_PAGE_3);
				Log.d("AppConstants.q_module_9_3", AppConstants.q_module_9_3);
				Log.d("AppConstants.q_module_9_4", AppConstants.q_module_9_4);

			}
		});
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_9_PAGE_1);

			}
		});

		return view;
	}

	private void initializediew() {

		cb_9_3_1 = (CheckBox) view.findViewById(R.id.cb_9_3_1);
		cb_9_3_2 = (CheckBox) view.findViewById(R.id.cb_9_3_2);
		cb_9_3_3 = (CheckBox) view.findViewById(R.id.cb_9_3_3);
		cb_9_3_4 = (CheckBox) view.findViewById(R.id.cb_9_3_4);
		cb_9_3_5 = (CheckBox) view.findViewById(R.id.cb_9_3_5);
		cb_9_3_6 = (CheckBox) view.findViewById(R.id.cb_9_3_6);
		cb_9_3_7 = (CheckBox) view.findViewById(R.id.cb_9_3_7);
		cb_9_3_8 = (CheckBox) view.findViewById(R.id.cb_9_3_8);
		cb_9_3_1.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_2.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_3.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_4.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_5.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_6.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_7.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_8.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_9_3_1.setOnClickListener(this);
		cb_9_3_2.setOnClickListener(this);
		cb_9_3_3.setOnClickListener(this);
		cb_9_3_4.setOnClickListener(this);
		cb_9_3_5.setOnClickListener(this);
		cb_9_3_6.setOnClickListener(this);
		cb_9_3_7.setOnClickListener(this);
		cb_9_3_8.setOnClickListener(this);
		et_q_module_9_3 = (EditText) view.findViewById(R.id.et_q_module_9_3);
		et_q_module_9_3.addTextChangedListener(this);
		rg_q_module_9_4 = (RadioGroup) view.findViewById(R.id.rg_q_module_9_4);
		rg_q_module_9_4.setOnCheckedChangeListener(this);
		tv_q_module_3 = (AnyTextView) view.findViewById(R.id.tv_q_module_3);
		tv_q_module_4 = (AnyTextView) view.findViewById(R.id.tv_q_module_4);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.cb_9_3_1:
		case R.id.cb_9_3_2:
		case R.id.cb_9_3_3:
		case R.id.cb_9_3_4:
		case R.id.cb_9_3_5:
		case R.id.cb_9_3_6:
		case R.id.cb_9_3_7:
			checkNextButtonVissible();
			break;
		case R.id.cb_9_3_8:
			if (cb_9_3_8.isChecked()) {
				et_q_module_9_3.setEnabled(true);
			} else {
				et_q_module_9_3.setEnabled(false);
			}
			checkNextButtonVissible();
			break;

		}
	}

	private void checkNextButtonVissible() {
		if (tv_q_module_3.isEnabled() && tv_q_module_4.isEnabled()) {
			if (rg_q_module_9_4.getCheckedRadioButtonId() != -1 && check_et()) {
				if (cb_9_3_1.isChecked() || cb_9_3_2.isChecked()
						|| cb_9_3_3.isChecked() || cb_9_3_4.isChecked()
						|| cb_9_3_5.isChecked() || cb_9_3_6.isChecked()
						|| cb_9_3_7.isChecked() || cb_9_3_8.isChecked()) {
					btn_next.setEnabled(true);

				} else {
					btn_next.setEnabled(false);
				}

			} else {
				btn_next.setEnabled(false);
			}
		} else {
			btn_next.setEnabled(true);
		}
	}

	private boolean check_et() {
		if (et_q_module_9_3.isEnabled()) {
			if (et_value_9_3.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		checkNextButtonVissible();
	}

	private void getValue() {
		if (tv_q_module_4.isEnabled()) {
			AppConstants.q_module_9_4 = ((RadioButton) view
					.findViewById(rg_q_module_9_4.getCheckedRadioButtonId()))
					.getText().toString();
		} else {
			AppConstants.q_module_9_4 = AppConstants.DEFULLT_DATA;
		}

		if (tv_q_module_3.isEnabled()) {

			AppConstants.q_module_9_3 = "";
			if (cb_9_3_1.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_1.getText().toString()
						+ ", ";
			}
			if (cb_9_3_2.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_2.getText().toString()
						+ ", ";
			}
			if (cb_9_3_3.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_3.getText().toString()
						+ ", ";
			}
			if (cb_9_3_4.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_4.getText().toString()
						+ ", ";
			}
			if (cb_9_3_5.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_5.getText().toString()
						+ ", ";
			}
			if (cb_9_3_6.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_6.getText().toString()
						+ ", ";
			}
			if (cb_9_3_7.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_7.getText().toString()
						+ ", ";
			}
			if (cb_9_3_8.isChecked()) {
				AppConstants.q_module_9_3 += cb_9_3_8.getText().toString();
			}

			if (et_q_module_9_3.isEnabled()) {
				AppConstants.q_module_9_3 += et_value_9_3 + ", ";
			}
			AppConstants.q_module_9_3 = (AppConstants.q_module_9_3).substring(
					0, AppConstants.q_module_9_3.length() - 2);

		} else {
			AppConstants.q_module_9_3 = AppConstants.DEFULLT_DATA;
		}

	}

	@Override
	public void Update() {
		if (AppConstants.q_module_9_1.equals(getResources().getString(
				R.string.no))) {
			disableViewQuestion3and4();

		} else {
			enableViewQuestion3and4();
		}
		checkNextButtonVissible();

	}

	private void enableViewQuestion3and4() {
		cb_9_3_1.setEnabled(true);
		cb_9_3_2.setEnabled(true);
		cb_9_3_3.setEnabled(true);
		cb_9_3_4.setEnabled(true);
		cb_9_3_5.setEnabled(true);
		cb_9_3_6.setEnabled(true);
		cb_9_3_7.setEnabled(true);
		cb_9_3_8.setEnabled(true);
		for (int i = 0; i < rg_q_module_9_4.getChildCount(); i++) {
			((RadioButton) rg_q_module_9_4.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_3.setEnabled(true);
		tv_q_module_4.setEnabled(true);

	}

	private void disableViewQuestion3and4() {
		tv_q_module_3.setEnabled(false);
		tv_q_module_4.setEnabled(false);

		cb_9_3_1.setOnClickListener(null);
		cb_9_3_2.setOnClickListener(null);
		cb_9_3_3.setOnClickListener(null);
		cb_9_3_4.setOnClickListener(null);
		cb_9_3_5.setOnClickListener(null);
		cb_9_3_6.setOnClickListener(null);
		cb_9_3_7.setOnClickListener(null);
		cb_9_3_8.setOnClickListener(null);

		cb_9_3_1.setChecked(false);
		cb_9_3_2.setChecked(false);
		cb_9_3_3.setChecked(false);
		cb_9_3_4.setChecked(false);
		cb_9_3_5.setChecked(false);
		cb_9_3_6.setChecked(false);
		cb_9_3_7.setChecked(false);
		cb_9_3_8.setChecked(false);

		cb_9_3_1.setEnabled(false);
		cb_9_3_2.setEnabled(false);
		cb_9_3_3.setEnabled(false);
		cb_9_3_4.setEnabled(false);
		cb_9_3_5.setEnabled(false);
		cb_9_3_6.setEnabled(false);
		cb_9_3_7.setEnabled(false);
		cb_9_3_8.setEnabled(false);

		cb_9_3_1.setOnClickListener(this);
		cb_9_3_2.setOnClickListener(this);
		cb_9_3_3.setOnClickListener(this);
		cb_9_3_4.setOnClickListener(this);
		cb_9_3_5.setOnClickListener(this);
		cb_9_3_6.setOnClickListener(this);
		cb_9_3_7.setOnClickListener(this);
		cb_9_3_8.setOnClickListener(this);

		for (int i = 0; i < rg_q_module_9_4.getChildCount(); i++) {
			((RadioButton) rg_q_module_9_4.getChildAt(i)).setEnabled(false);
		}
		rg_q_module_9_4.setOnCheckedChangeListener(null);
		rg_q_module_9_4.clearCheck();
		rg_q_module_9_4.setOnCheckedChangeListener(this);

		et_q_module_9_3.setText("");
		et_q_module_9_3.setEnabled(false);

	}

	@Override
	public void afterTextChanged(Editable arg0) {
		et_value_9_3 = arg0.toString().trim();
		checkNextButtonVissible();

	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {

	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

	}
}
