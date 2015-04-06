package com.rimon.rsa.ipaeps.module_11_patient_questions_concerns;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appdatabase.SavePatientData;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.classtorun.ClassRunActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogPasswordForActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogPasswordListener;
import com.rimon.rsa.ipaeps.textview.AnyTextView;

public class Module11PatientQuestionsConcerns extends SherlockFragmentActivity
		implements android.widget.CompoundButton.OnCheckedChangeListener,
		TextWatcher, AnyDialogPasswordListener {

	private AnyButton btn_next;
	private LinearLayout layout;
	private Animation animation;
	private CheckBox cb_q_module_11_1, cb_q_module_11_2, cb_q_module_11_3,
			cb_q_module_11_4, cb_q_module_11_5, cb_q_module_11_6,
			cb_q_module_11_7, cb_q_module_11_8, cb_q_module_11_9,
			cb_q_module_11_10, cb_q_module_11_11, cb_q_module_11_12,
			cb_q_module_11_13, cb_q_module_11_14, cb_q_module_11_15,
			cb_q_module_11_16, cb_q_module_11_17, cb_q_module_11_18,
			cb_q_module_11_19, cb_q_module_11_20;
	private ImageView im_action_bar;
	private AnyTextView tv_action_bar;
	private AnyTextView tv_title;
	private EditText et_q_module_11_20;
	private String value = "";
	private boolean isSingleDiaglog = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.module_11_patient_question_concerns);

		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(this.getResources().getString(
				R.string.patient_questions_concerns));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar
				.setBackgroundResource(R.drawable.ic_actionber_patient_concern);
		btn_next = (AnyButton) findViewById(R.id.btn_next);
		layout = (LinearLayout) findViewById(R.id.linear_layout_patient_concern_health);
		initilizedView();

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getVlue();
				startActivity(getIntentToRun());
				finish();

			}
		});

		animation = AppObject.getScaleAnimition(this);
		layout.startAnimation(animation);

		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				viewEnable();

			}

		});
	}

	private void initilizedView() {
		et_q_module_11_20 = (EditText) findViewById(R.id.et_q_module_11_20);

		et_q_module_11_20.addTextChangedListener(this);
		tv_title = (AnyTextView) findViewById(R.id.tv_q_module_11_21);
		cb_q_module_11_1 = (CheckBox) findViewById(R.id.cb_q_module_11_1);
		cb_q_module_11_2 = (CheckBox) findViewById(R.id.cb_q_module_11_2);
		cb_q_module_11_3 = (CheckBox) findViewById(R.id.cb_q_module_11_3);
		cb_q_module_11_4 = (CheckBox) findViewById(R.id.cb_q_module_11_4);
		cb_q_module_11_5 = (CheckBox) findViewById(R.id.cb_q_module_11_5);
		cb_q_module_11_6 = (CheckBox) findViewById(R.id.cb_q_module_11_6);
		cb_q_module_11_7 = (CheckBox) findViewById(R.id.cb_q_module_11_7);
		cb_q_module_11_8 = (CheckBox) findViewById(R.id.cb_q_module_11_8);
		cb_q_module_11_9 = (CheckBox) findViewById(R.id.cb_q_module_11_9);
		cb_q_module_11_10 = (CheckBox) findViewById(R.id.cb_q_module_11_10);
		cb_q_module_11_11 = (CheckBox) findViewById(R.id.cb_q_module_11_11);
		cb_q_module_11_12 = (CheckBox) findViewById(R.id.cb_q_module_11_12);
		cb_q_module_11_13 = (CheckBox) findViewById(R.id.cb_q_module_11_13);
		cb_q_module_11_14 = (CheckBox) findViewById(R.id.cb_q_module_11_14);
		cb_q_module_11_15 = (CheckBox) findViewById(R.id.cb_q_module_11_15);
		cb_q_module_11_16 = (CheckBox) findViewById(R.id.cb_q_module_11_16);
		cb_q_module_11_17 = (CheckBox) findViewById(R.id.cb_q_module_11_17);
		cb_q_module_11_18 = (CheckBox) findViewById(R.id.cb_q_module_11_18);
		cb_q_module_11_19 = (CheckBox) findViewById(R.id.cb_q_module_11_19);
		cb_q_module_11_20 = (CheckBox) findViewById(R.id.cb_q_module_11_20);

		cb_q_module_11_1.setOnCheckedChangeListener(this);
		cb_q_module_11_2.setOnCheckedChangeListener(this);
		cb_q_module_11_3.setOnCheckedChangeListener(this);
		cb_q_module_11_4.setOnCheckedChangeListener(this);
		cb_q_module_11_5.setOnCheckedChangeListener(this);
		cb_q_module_11_6.setOnCheckedChangeListener(this);
		cb_q_module_11_7.setOnCheckedChangeListener(this);
		cb_q_module_11_8.setOnCheckedChangeListener(this);
		cb_q_module_11_9.setOnCheckedChangeListener(this);
		cb_q_module_11_10.setOnCheckedChangeListener(this);
		cb_q_module_11_11.setOnCheckedChangeListener(this);
		cb_q_module_11_12.setOnCheckedChangeListener(this);
		cb_q_module_11_13.setOnCheckedChangeListener(this);
		cb_q_module_11_14.setOnCheckedChangeListener(this);
		cb_q_module_11_15.setOnCheckedChangeListener(this);
		cb_q_module_11_16.setOnCheckedChangeListener(this);
		cb_q_module_11_17.setOnCheckedChangeListener(this);
		cb_q_module_11_18.setOnCheckedChangeListener(this);
		cb_q_module_11_19.setOnCheckedChangeListener(this);
		cb_q_module_11_20.setOnCheckedChangeListener(this);

		cb_q_module_11_1.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_2.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_3.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_4.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_5.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_6.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_7.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_8.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_9.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_10.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_11.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_12.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_13.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_14.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_15.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_16.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_17.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_18.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_19.setTypeface(AppObject.getCurrentFont(this));
		cb_q_module_11_20.setTypeface(AppObject.getCurrentFont(this));

	}

	private void viewEnable() {
		tv_title.setEnabled(true);
		cb_q_module_11_1.setEnabled(true);
		cb_q_module_11_2.setEnabled(true);
		cb_q_module_11_3.setEnabled(true);
		cb_q_module_11_4.setEnabled(true);
		cb_q_module_11_5.setEnabled(true);
		cb_q_module_11_6.setEnabled(true);
		cb_q_module_11_7.setEnabled(true);
		cb_q_module_11_8.setEnabled(true);
		cb_q_module_11_9.setEnabled(true);
		cb_q_module_11_10.setEnabled(true);
		cb_q_module_11_11.setEnabled(true);
		cb_q_module_11_12.setEnabled(true);
		cb_q_module_11_13.setEnabled(true);
		cb_q_module_11_14.setEnabled(true);
		cb_q_module_11_15.setEnabled(true);
		cb_q_module_11_16.setEnabled(true);
		cb_q_module_11_17.setEnabled(true);
		cb_q_module_11_18.setEnabled(true);
		cb_q_module_11_19.setEnabled(true);
		cb_q_module_11_20.setEnabled(true);

	}

	private void checkNextButtonVisible() {

		if (et_q_module_11_20.isEnabled()) {

			if (value.equals("")) {
				btn_next.setEnabled(false);
			} else {
				btn_next.setEnabled(true);
			}

		} else {
			if (cb_q_module_11_1.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_2.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_3.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_4.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_5.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_6.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_7.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_8.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_9.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_10.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_11.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_12.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_13.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_14.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_15.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_16.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_17.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_18.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_19.isChecked()) {
				btn_next.setEnabled(true);
			} else if (cb_q_module_11_20.isChecked()) {
				btn_next.setEnabled(true);
			} else {
				btn_next.setEnabled(false);
			}
		}

	}

	@Override
	public void afterTextChanged(Editable s) {
		value = s.toString().trim();
		checkNextButtonVisible();
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (buttonView.getId() == R.id.cb_q_module_11_20) {
			if (isChecked) {
				et_q_module_11_20.setEnabled(true);

			} else {
				et_q_module_11_20.setEnabled(false);
			}
		}
		checkNextButtonVisible();

	}

	private void getVlue() {
		AppConstants.q_module_11_1 = "";

		if (cb_q_module_11_1.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_1.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_2.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_2.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_3.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_3.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_4.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_4.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_5.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_5.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_6.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_6.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_7.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_7.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_8.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_8.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_9.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_9.getText().toString()
					+ ", ";
		}
		if (cb_q_module_11_10.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_10.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_11.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_11.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_12.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_12.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_13.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_13.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_14.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_14.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_15.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_15.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_16.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_16.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_17.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_17.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_18.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_18.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_19.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_19.getText()
					.toString() + ", ";

		}
		if (cb_q_module_11_20.isChecked()) {
			AppConstants.q_module_11_1 += cb_q_module_11_20.getText()
					.toString() + ", ";

		}
		if (et_q_module_11_20.isEnabled()) {
			AppConstants.q_module_11_1 += value + ", ";

		}
		AppConstants.q_module_11_1 = AppConstants.q_module_11_1.substring(0,
				AppConstants.q_module_11_1.length() - 2);

		Log.d("AppConstants.q_module_11_1", AppConstants.q_module_11_1);

	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");

		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(Module11PatientQuestionsConcerns.this,
				classes.get(order_activity));

		Bundle bundleTo = new Bundle();
		bundleTo.putSerializable(ClassRunActivity.RUNID, classes);
		bundleTo.putInt("order", ++order_activity);
		intent.putExtras(bundleTo);
		if (order_activity == classes.size()) {
			(new SavePatientData(this)).execute("");
		}
		return intent;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isSingleDiaglog) {
				isSingleDiaglog = false;
				AnyDiaglogPasswordForActivity anyDiaglogPassword = new AnyDiaglogPasswordForActivity();
				anyDiaglogPassword.setCancelable(false);
				anyDiaglogPassword
						.show(getSupportFragmentManager(), "password");

			}

		}
		return false;
	}

	@Override
	public void onClickPasswordDialog(boolean isPasswordCorrect) {
		isSingleDiaglog = true;
		if (isPasswordCorrect) {
			(new SavePatientData(this)).execute("");
			finish();
		}
	}

}
