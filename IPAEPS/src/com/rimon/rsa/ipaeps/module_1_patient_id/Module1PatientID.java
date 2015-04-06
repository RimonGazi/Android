package com.rimon.rsa.ipaeps.module_1_patient_id;

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
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogPasswordForActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogPasswordListener;
import com.rimon.rsa.ipaeps.textview.AnyTextView;

public class Module1PatientID extends SherlockFragmentActivity implements
		AnyDialogListener, AnyDialogPasswordListener {

	private LinearLayout layout;
	private Animation animation;
	private EditText et_patient_id, et_gsl_id;
	private AnyButton btn_next, btn_q_module_1_3;

	private AnyButton btn_patient, btn_gsl;
	private ImageView im_action_bar;
	private AnyTextView tv_action_bar;
	private String patient_id_value = "", gsl_id_value = "";
	private AnyDiaglogFragmentForActivity diaglogFragment;
	private Bundle bundle;
	private boolean isSingleDiaglog = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		diaglogFragment = new AnyDiaglogFragmentForActivity();
		// diaglogFragment.setTargetFragment(gets, requestCode)
		bundle = new Bundle();
		setContentView(R.layout.module_1_patient_id);

		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(this.getResources()
				.getString(R.string.patient_id));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar.setBackgroundResource(R.drawable.ic_action_bar_id);
		layout = (LinearLayout) findViewById(R.id.relative_layout_patient_id);
		et_patient_id = (EditText) findViewById(R.id.et_patient_id);
		et_patient_id.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				patient_id_value = (s.toString()).trim();
				AppConstants.q_module_1_1 = patient_id_value.trim();
				checkNextButtonVisible();

			}
		});
		et_gsl_id = (EditText) findViewById(R.id.et_gst_id);
		et_gsl_id.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				gsl_id_value = (s.toString()).trim();
				AppConstants.q_module_1_2 = gsl_id_value;
				checkNextButtonVisible();

			}
		});
		btn_next = (AnyButton) findViewById(R.id.btn_next);
		btn_patient = (AnyButton) findViewById(R.id.btn_start_id);
		btn_gsl = (AnyButton) findViewById(R.id.btn_gst_id);
		btn_q_module_1_3 = (AnyButton) findViewById(R.id.btn_q_module_1_3);
		btn_q_module_1_3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				showDialog(R.array.array_site, R.id.btn_q_module_1_3,
						R.string.site, AppConstants.q_module_1_3);

			}
		});

		animation = AppObject.getScaleAnimition(this);
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
				viewEnable();

			}
		});
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(getIntentToRun());
				Log.d("q_moudle_1_1", AppConstants.q_module_1_1);
				Log.d("q_moudle_1_2", AppConstants.q_module_1_2);
				Log.d("q_moudle_1_3", AppConstants.q_module_1_3);
				finish();

			}
		});

	}

	private void viewEnable() {
		btn_patient.setEnabled(true);
		et_patient_id.setEnabled(true);
		btn_gsl.setEnabled(true);
		et_gsl_id.setEnabled(true);
		btn_q_module_1_3.setEnabled(true);

	}

	private void checkNextButtonVisible() {
		if (!patient_id_value.equals("") && !gsl_id_value.equals("")) {

			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		btn_q_module_1_3.setText(selected_item);
		AppConstants.q_module_1_3 = selected_item;
		setLastState(btn_q_module_1_3);
	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;
	}

	private void showDialog(int array_id, int view_id, int title_id,
			String previous_selection) {
		if (isSingleDiaglog) {
			isSingleDiaglog = false;
			bundle.putInt(AppConstants.DIAGLOG_ARRAY_ID, array_id);
			bundle.putInt(AppConstants.DIAGLOG_VIEW_ID, view_id);
			bundle.putInt(AppConstants.DIAGLOG_TITLE_ID, title_id);
			bundle.putString(AppConstants.DIAGLOG_PREVIOUS_SELECTION,
					previous_selection);

			diaglogFragment.setArguments(bundle);
			diaglogFragment.show(getSupportFragmentManager(), "diaglog");

		}
	}

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");
		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(Module1PatientID.this,
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
