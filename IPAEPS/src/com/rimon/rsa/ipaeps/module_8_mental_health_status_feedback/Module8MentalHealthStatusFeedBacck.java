package com.rimon.rsa.ipaeps.module_8_mental_health_status_feedback;

import java.util.ArrayList;

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

public class Module8MentalHealthStatusFeedBacck extends
		SherlockFragmentActivity implements OnCheckedChangeListener,
		AnyDialogPasswordListener {
	private RadioGroup rg_q_module_8_1, rg_q_module_8_2, rg_q_module_8_3,
			rg_q_module_8_4;
	private AnyButton btn_next;
	private LinearLayout layout;
	private Animation animation;
	private AnyTextView tv_q_module_8_1, tv_q_module_8_2, tv_q_module_8_3,
			tv_q_module_8_4;
	private AnyTextView tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8;
	private ImageView im_action_bar;
	private AnyTextView tv_action_bar;
	private boolean isSingleDiaglog = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.module_8_mental_helath_feedback);

		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(this.getResources().getString(
				R.string.mental_health_status));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar.setBackgroundResource(R.drawable.ic_feedback);
		btn_next = (AnyButton) findViewById(R.id.btn_next);
		rg_q_module_8_1 = (RadioGroup) findViewById(R.id.rg_q_module_8_1);
		rg_q_module_8_2 = (RadioGroup) findViewById(R.id.rg_q_module_8_2);
		rg_q_module_8_3 = (RadioGroup) findViewById(R.id.rg_q_module_8_3);
		rg_q_module_8_4 = (RadioGroup) findViewById(R.id.rg_q_module_8_4);
		rg_q_module_8_1.setOnCheckedChangeListener(this);
		rg_q_module_8_2.setOnCheckedChangeListener(this);
		rg_q_module_8_3.setOnCheckedChangeListener(this);
		rg_q_module_8_4.setOnCheckedChangeListener(this);

		tv_q_module_8_1 = (AnyTextView) findViewById(R.id.tv_q_module_8_1);

		tv_q_module_8_2 = (AnyTextView) findViewById(R.id.tv_q_module_8_2);

		tv_q_module_8_3 = (AnyTextView) findViewById(R.id.tv_q_module_8_3);

		tv_q_module_8_4 = (AnyTextView) findViewById(R.id.tv_q_module_8_4);

		tv_1 = (AnyTextView) findViewById(R.id.anyTextView1);
		tv_2 = (AnyTextView) findViewById(R.id.anyTextView2);
		tv_3 = (AnyTextView) findViewById(R.id.anyTextView3);
		tv_4 = (AnyTextView) findViewById(R.id.anyTextView4);
		tv_5 = (AnyTextView) findViewById(R.id.anyTextView5);
		tv_6 = (AnyTextView) findViewById(R.id.anyTextView6);
		tv_7 = (AnyTextView) findViewById(R.id.anyTextView7);
		tv_8 = (AnyTextView) findViewById(R.id.anyTextView8);

		layout = (LinearLayout) findViewById(R.id.linear_layout_mental_health);

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

	private void viewEnable() {
		tv_q_module_8_1.setEnabled(true);
		tv_1.setEnabled(true);
		tv_2.setEnabled(true);

		for (int i = 0; i < rg_q_module_8_1.getChildCount(); i++) {
			((RadioButton) rg_q_module_8_1.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_8_2.setEnabled(true);
		tv_3.setEnabled(true);
		tv_4.setEnabled(true);
		for (int i = 0; i < rg_q_module_8_2.getChildCount(); i++) {
			((RadioButton) rg_q_module_8_2.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_8_3.setEnabled(true);
		tv_5.setEnabled(true);
		tv_6.setEnabled(true);
		for (int i = 0; i < rg_q_module_8_3.getChildCount(); i++) {
			((RadioButton) rg_q_module_8_3.getChildAt(i)).setEnabled(true);
		}
		tv_q_module_8_4.setEnabled(true);
		tv_7.setEnabled(true);
		tv_8.setEnabled(true);

		for (int i = 0; i < rg_q_module_8_4.getChildCount(); i++) {
			((RadioButton) rg_q_module_8_4.getChildAt(i)).setEnabled(true);
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup radioGroup_id, int check_id) {

		checkNextButtonVisible();

	}

	private void checkNextButtonVisible() {
		if ((rg_q_module_8_1.getCheckedRadioButtonId() != -1)
				&& (rg_q_module_8_2.getCheckedRadioButtonId() != -1)
				&& (rg_q_module_8_3.getCheckedRadioButtonId() != -1)
				&& (rg_q_module_8_4.getCheckedRadioButtonId() != -1)) {
			btn_next.setEnabled(true);

		} else {
			btn_next.setEnabled(false);
		}

	}

	private void getValue() {

		AppConstants.q_module_8_1 = ((RadioButton) findViewById(rg_q_module_8_1
				.getCheckedRadioButtonId())).getContentDescription().toString();
		AppConstants.q_module_8_2 = ((RadioButton) findViewById(rg_q_module_8_2
				.getCheckedRadioButtonId())).getContentDescription().toString();
		AppConstants.q_module_8_3 = ((RadioButton) findViewById(rg_q_module_8_3
				.getCheckedRadioButtonId())).getContentDescription().toString();
		AppConstants.q_module_8_4 = ((RadioButton) findViewById(rg_q_module_8_4
				.getCheckedRadioButtonId())).getContentDescription().toString();
		Log.d("AppConstants.q_module_8_1", AppConstants.q_module_8_1);
		Log.d("AppConstants.q_module_8_2", AppConstants.q_module_8_2);
		Log.d("AppConstants.q_module_8_3", AppConstants.q_module_8_3);
		Log.d("AppConstants.q_module_8_4", AppConstants.q_module_8_4);
	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");
		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(Module8MentalHealthStatusFeedBacck.this,
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
