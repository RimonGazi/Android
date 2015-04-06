package com.rimon.rsa.ipaeps.module_5_medication_adherence;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

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

import java.util.ArrayList;

public class Module5MedicalAdherence extends SherlockFragmentActivity implements
		OnCheckedChangeListener, AnyDialogPasswordListener {
	private RadioGroup rg_q_module_5_1, rg_q_module_5_2, rg_q_module_5_3,
			rg_q_module_5_4, rg_q_module_5_5;
	private AnyButton btn_next;
	private LinearLayout layout;
	private Animation animation;
	private AnyTextView tv_q_module_5_1, tv_q_module_5_2, tv_q_module_5_3,
			tv_q_module_5_4, tv_q_module_5_5;

	private ImageView im_action_bar;
	private AnyTextView tv_action_bar;
	private boolean isSingleDiaglog = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.module_5_medications_adherence);
		initializedview();

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getValue();
				startActivity(getIntentToRun());
				finish();
			}
		});

		animation = AppObject.getScaleAnimition(this);
		layout.startAnimation(animation);

		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				viewEnable();

			}

		});
	}

	private void viewEnable() {
		tv_q_module_5_1.setEnabled(true);
		for (int i = 0; i < rg_q_module_5_1.getChildCount(); i++) {
			((RadioButton) rg_q_module_5_1.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_5_2.setEnabled(true);
		for (int i = 0; i < rg_q_module_5_2.getChildCount(); i++) {
			((RadioButton) rg_q_module_5_2.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_5_3.setEnabled(true);
		for (int i = 0; i < rg_q_module_5_3.getChildCount(); i++) {
			((RadioButton) rg_q_module_5_3.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_5_4.setEnabled(true);
		for (int i = 0; i < rg_q_module_5_4.getChildCount(); i++) {
			((RadioButton) rg_q_module_5_4.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_5_5.setEnabled(true);
		for (int i = 0; i < rg_q_module_5_5.getChildCount(); i++) {
			((RadioButton) rg_q_module_5_5.getChildAt(i)).setEnabled(true);
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup radioGroup_id, int check_id) {

		checkNextButtonVisible();

	}

	private void checkNextButtonVisible() {
		if ((rg_q_module_5_1.getCheckedRadioButtonId() != -1)
				&& (rg_q_module_5_2.getCheckedRadioButtonId() != -1)
				&& (rg_q_module_5_3.getCheckedRadioButtonId() != -1)
				&& (rg_q_module_5_4.getCheckedRadioButtonId() != -1)
				&& (rg_q_module_5_5.getCheckedRadioButtonId() != -1)) {
			btn_next.setEnabled(true);

		} else {
			btn_next.setEnabled(false);
		}

	}

	private void initializedview() {
		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(this.getResources().getString(
				R.string.medication_adherence));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar
				.setBackgroundResource(R.drawable.ic_actionbar_medications_adherence);
		btn_next = (AnyButton) findViewById(R.id.btn_next);
		rg_q_module_5_1 = (RadioGroup) findViewById(R.id.rg_q_module_5_1);
		rg_q_module_5_2 = (RadioGroup) findViewById(R.id.rg_q_module_5_2);
		rg_q_module_5_3 = (RadioGroup) findViewById(R.id.rg_q_module_5_3);
		rg_q_module_5_4 = (RadioGroup) findViewById(R.id.rg_q_module_5_4);
		rg_q_module_5_5 = (RadioGroup) findViewById(R.id.rg_q_module_5_5);
		rg_q_module_5_1.setOnCheckedChangeListener(this);
		rg_q_module_5_2.setOnCheckedChangeListener(this);
		rg_q_module_5_3.setOnCheckedChangeListener(this);
		rg_q_module_5_4.setOnCheckedChangeListener(this);
		rg_q_module_5_5.setOnCheckedChangeListener(this);
		tv_q_module_5_1 = (AnyTextView) findViewById(R.id.tv_q_module_5_1);
		tv_q_module_5_2 = (AnyTextView) findViewById(R.id.tv_q_module_5_2);
		tv_q_module_5_3 = (AnyTextView) findViewById(R.id.tv_q_module_5_3);
		tv_q_module_5_4 = (AnyTextView) findViewById(R.id.tv_q_module_5_4);
		tv_q_module_5_5 = (AnyTextView) findViewById(R.id.tv_q_module_5_5);

		layout = (LinearLayout) findViewById(R.id.linear_layout_medical_adherence);

	}

	private void getValue() {
		AppConstants.q_module_5_1 = ((RadioButton) findViewById(rg_q_module_5_1
				.getCheckedRadioButtonId())).getText().toString();
		AppConstants.q_module_5_2 = ((RadioButton) findViewById(rg_q_module_5_2
				.getCheckedRadioButtonId())).getText().toString();
		AppConstants.q_module_5_3 = ((RadioButton) findViewById(rg_q_module_5_3
				.getCheckedRadioButtonId())).getText().toString();
		AppConstants.q_module_5_4 = ((RadioButton) findViewById(rg_q_module_5_4
				.getCheckedRadioButtonId())).getText().toString();
		AppConstants.q_module_5_5 = ((RadioButton) findViewById(rg_q_module_5_5
				.getCheckedRadioButtonId())).getText().toString();

		Log.d("AppConstants.q_module_5_1", AppConstants.q_module_5_1);
		Log.d("AppConstants.q_module_5_2", AppConstants.q_module_5_2);
		Log.d("AppConstants.q_module_5_3", AppConstants.q_module_5_3);
		Log.d("AppConstants.q_module_5_4", AppConstants.q_module_5_4);
		Log.d("AppConstants.q_module_5_5", AppConstants.q_module_5_5);
	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");
		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(Module5MedicalAdherence.this,
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
				anyDiaglogPassword.show(getSupportFragmentManager(), "");
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
