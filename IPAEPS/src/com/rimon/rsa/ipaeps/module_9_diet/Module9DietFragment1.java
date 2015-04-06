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
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module9DietFragment1 extends SherlockFragment implements
		OnCheckedChangeListener, TextWatcher {
	private AnyPageChangeListener listener;

	private LinearLayout layout;
	private Animation animation;
	private AnyButton btn_next;
	private AnyTextView tv_q_module_9_1, tv_q_module_9_2;
	private RadioGroup rg_q_module_9_1, rg_q_module_9_2;
	private View view;
	private EditText et_q_module_9_2;
	private String value = "";

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module9Diet) getActivity();
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.module_9_diet_fragment_1, null, false);

		initializedView();

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getValue();
				listener.pageChange(AppConstants.MODULE_9_PAGE_2);
				
				Log.d("AppConstants.q_module_9_1", AppConstants.q_module_9_1);
				Log.d("AppConstants.q_module_9_2", AppConstants.q_module_9_2);
				

			}
		});
		animation = AnimationUtils
				.loadAnimation(getActivity(), R.anim.slide_in);
		layout.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				enableView();

			}

		});

		return view;
	}

	private void enableView() {
		tv_q_module_9_1.setEnabled(true);

		for (int i = 0; i < rg_q_module_9_1.getChildCount(); i++) {
			((RadioButton) rg_q_module_9_1.getChildAt(i)).setEnabled(true);
		}

	}

	private void disableQuestion2View() {
		rg_q_module_9_2.setOnCheckedChangeListener(null);
		rg_q_module_9_2.clearCheck();

		tv_q_module_9_2.setEnabled(false);
		for (int i = 0; i < rg_q_module_9_2.getChildCount(); i++) {
			((RadioButton) rg_q_module_9_2.getChildAt(i)).setEnabled(false);
		}
		rg_q_module_9_2.setOnCheckedChangeListener(this);
		et_q_module_9_2.setText("");
		et_q_module_9_2.setEnabled(false);
	}

	private void enableQueston2View() {
		tv_q_module_9_2.setEnabled(true);
		for (int i = 0; i < rg_q_module_9_2.getChildCount(); i++) {
			((RadioButton) rg_q_module_9_2.getChildAt(i)).setEnabled(true);
		}
	}

	private boolean check_et() {

		if (et_q_module_9_2.isEnabled()) {
			if (value.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}

	}

	private void checkNextButtonVisible() {
		if (rg_q_module_9_1.getCheckedRadioButtonId() != -1
				&& check_rg_q_module_9_2() && check_et()) {

			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);

		}

	}

	private boolean check_rg_q_module_9_2() {

		if (tv_q_module_9_2.isEnabled()) {
			if (rg_q_module_9_2.getCheckedRadioButtonId() != -1) {
				return true;
			} else {
				return false;
			}

		} else {
			return true;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup view, int ischecked) {

		switch (view.getId()) {
		case R.id.rg_q_module_9_2:
			if (rg_q_module_9_2.getCheckedRadioButtonId() == R.id.radio9_9) {
				et_q_module_9_2.setEnabled(true);

			} else {

				et_q_module_9_2.setEnabled(false);
				et_q_module_9_2.setText("");
			}
			break;
		case R.id.rg_q_module_9_1:
			if (rg_q_module_9_1.getCheckedRadioButtonId() == R.id.radio1) {
				disableQuestion2View();
			} else {
				enableQueston2View();
			}
			break;
		}

		checkNextButtonVisible();
	}

	@Override
	public void afterTextChanged(Editable s) {
		value = s.toString().trim();
		checkNextButtonVisible();

	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	private void initializedView() {
		layout = (LinearLayout) view.findViewById(R.id.linear_layout_diet_1);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		tv_q_module_9_1 = (AnyTextView) view.findViewById(R.id.tv_q_module_9_1);
		tv_q_module_9_2 = (AnyTextView) view.findViewById(R.id.tv_q_module_9_2);
		rg_q_module_9_1 = (RadioGroup) view.findViewById(R.id.rg_q_module_9_1);
		rg_q_module_9_2 = (RadioGroup) view.findViewById(R.id.rg_q_module_9_2);
		et_q_module_9_2 = (EditText) view.findViewById(R.id.et_q_module_9_2);
		rg_q_module_9_1.setOnCheckedChangeListener(this);
		rg_q_module_9_2.setOnCheckedChangeListener(this);
		et_q_module_9_2.addTextChangedListener(this);

	}

	private void getValue() {
		AppConstants.q_module_9_1 = ((RadioButton) view
				.findViewById(rg_q_module_9_1.getCheckedRadioButtonId()))
				.getText().toString();
		if (!tv_q_module_9_2.isEnabled()) {
			AppConstants.q_module_9_2 = AppConstants.DEFULLT_DATA;
		} else {

			if (et_q_module_9_2.isEnabled()) {

				AppConstants.q_module_9_2 = et_q_module_9_2.getText()
						.toString();
			} else {
				AppConstants.q_module_9_2 = ((RadioButton) view
						.findViewById(rg_q_module_9_2.getCheckedRadioButtonId()))
						.getText().toString();
			}
		}
	}
}
