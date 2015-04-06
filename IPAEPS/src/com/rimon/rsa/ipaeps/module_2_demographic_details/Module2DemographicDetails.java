package com.rimon.rsa.ipaeps.module_2_demographic_details;

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

import java.util.ArrayList;

public class Module2DemographicDetails extends SherlockFragmentActivity
		implements OnClickListener, AnyDialogListener,
		AnyDialogPasswordListener {
	private boolean isSingleDiaglog = true;
	private AnyDiaglogFragmentForActivity diaglogFragment;
	private Bundle bundle;

	private LinearLayout layout;
	private Animation animation;
	private AnyButton btn_next;
	private AnyTextView tv_action_bar;
	private AnyButton btn_q_module_2_1, btn_q_module_2_2, btn_q_module_2_3,
			btn_q_module_2_4, btn_q_module_2_5, btn_q_module_2_6;
	private boolean c_m_s_q_1, c_m_s_q_2, c_m_s_q_3, c_m_s_q_4, c_m_s_q_5,
			c_m_s_q_6;
	private ImageView im_action_bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		diaglogFragment = new AnyDiaglogFragmentForActivity();
		bundle = new Bundle();
		setContentView(R.layout.module_2_demographic_details);

		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(getResources().getString(
				R.string.demographic_details));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar
				.setBackgroundResource(R.drawable.ic_actionber_demographic);

		btn_q_module_2_1 = (AnyButton) findViewById(R.id.btn_q_module_2_1);
		btn_q_module_2_2 = (AnyButton) findViewById(R.id.btn_q_module_2_2);
		btn_q_module_2_3 = (AnyButton) findViewById(R.id.btn_q_module_2_3);
		btn_q_module_2_4 = (AnyButton) findViewById(R.id.btn_q_module_2_4);
		btn_q_module_2_5 = (AnyButton) findViewById(R.id.btn_q_module_2_5);
		btn_q_module_2_6 = (AnyButton) findViewById(R.id.btn_q_module_2_6);
		disableView();

		layout = (LinearLayout) findViewById(R.id.linear_layout_demographic);
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
				enableView();

			}
		});
		btn_next = (AnyButton) findViewById(R.id.btn_next);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(getIntentToRun());
				Log.d("q_module_2_1", AppConstants.q_module_2_1);
				Log.d("q_module_2_2", AppConstants.q_module_2_2);
				Log.d("q_module_2_3", AppConstants.q_module_2_3);
				Log.d("q_module_2_4", AppConstants.q_module_2_4);
				Log.d("q_module_2_5", AppConstants.q_module_2_5);
				Log.d("q_module_2_6", AppConstants.q_module_2_6);
				finish();

			}
		});
		btn_q_module_2_1.setOnClickListener(this);
		btn_q_module_2_2.setOnClickListener(this);
		btn_q_module_2_3.setOnClickListener(this);
		btn_q_module_2_4.setOnClickListener(this);
		btn_q_module_2_5.setOnClickListener(this);
		btn_q_module_2_6.setOnClickListener(this);

	}

	private void disableView() {

		btn_q_module_2_1.setEnabled(false);
		btn_q_module_2_2.setEnabled(false);
		btn_q_module_2_3.setEnabled(false);
		btn_q_module_2_4.setEnabled(false);
		btn_q_module_2_5.setEnabled(false);
		btn_q_module_2_6.setEnabled(false);
	}

	private void enableView() {

		btn_q_module_2_1.setEnabled(true);
		btn_q_module_2_2.setEnabled(true);
		btn_q_module_2_3.setEnabled(true);
		btn_q_module_2_4.setEnabled(true);
		btn_q_module_2_5.setEnabled(true);
		btn_q_module_2_6.setEnabled(true);
		btn_q_module_2_1.setBackgroundResource(R.drawable.btn_left_mid_state);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_q_module_2_1:
			showDialog(R.array.age, R.id.btn_q_module_2_1,
					R.string.q_module_2_1, AppConstants.q_module_2_1);
			break;
		case R.id.btn_q_module_2_2:
			showDialog(R.array.gender, R.id.btn_q_module_2_2,
					R.string.q_module_2_2, AppConstants.q_module_2_2);
			break;
		case R.id.btn_q_module_2_3:
			showDialog(R.array.marrid_status, R.id.btn_q_module_2_3,
					R.string.q_module_2_3, AppConstants.q_module_2_3);
			break;
		case R.id.btn_q_module_2_4:
			showDialog(R.array.education, R.id.btn_q_module_2_4,
					R.string.q_module_2_4, AppConstants.q_module_2_4);
			break;
		case R.id.btn_q_module_2_5:
			showDialog(R.array.yes_no, R.id.btn_q_module_2_5,
					R.string.q_module_2_5, AppConstants.q_module_2_5);
			break;
		case R.id.btn_q_module_2_6:
			showDialog(R.array.gastroenterologist, R.id.btn_q_module_2_6,
					R.string.q_module_2_6, AppConstants.q_module_2_6);
			break;
		}

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_q_module_2_1:
			btn_q_module_2_1.setText(selected_item);
			AppConstants.q_module_2_1 = selected_item;
			setLastState(btn_q_module_2_1);
			c_m_s_q_1 = true;
			setMidState();
			break;
		case R.id.btn_q_module_2_2:
			btn_q_module_2_2.setText(selected_item);
			AppConstants.q_module_2_2 = selected_item;
			setLastState(btn_q_module_2_2);
			c_m_s_q_2 = true;
			setMidState();
			break;
		case R.id.btn_q_module_2_3:
			btn_q_module_2_3.setText(selected_item);
			AppConstants.q_module_2_3 = selected_item;
			setLastState(btn_q_module_2_3);
			c_m_s_q_3 = true;
			setMidState();
			break;
		case R.id.btn_q_module_2_4:
			btn_q_module_2_4.setText(selected_item);
			AppConstants.q_module_2_4 = selected_item;
			setLastState(btn_q_module_2_4);
			c_m_s_q_4 = true;
			setMidState();
			break;
		case R.id.btn_q_module_2_5:
			btn_q_module_2_5.setText(selected_item);
			AppConstants.q_module_2_5 = selected_item;
			setLastState(btn_q_module_2_5);
			c_m_s_q_5 = true;
			setMidState();
			break;
		case R.id.btn_q_module_2_6:
			btn_q_module_2_6.setText(selected_item);
			AppConstants.q_module_2_6 = selected_item;
			setLastState(btn_q_module_2_6);
			c_m_s_q_6 = true;
			setMidState();
			break;
		}

		checkNextButtonVisible();
	}

	private void checkNextButtonVisible() {

		if (c_m_s_q_1 && c_m_s_q_2 && c_m_s_q_3 && c_m_s_q_3 && c_m_s_q_5
				&& c_m_s_q_6)
			btn_next.setEnabled(true);

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

	private void setMidState() {
		if (!c_m_s_q_1) {
			btn_q_module_2_1
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_2_1.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_2) {
			btn_q_module_2_2
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_2_2.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_3) {
			btn_q_module_2_3
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_2_3.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_4) {
			btn_q_module_2_4
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_2_4.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_5) {
			btn_q_module_2_5
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_2_5.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_6) {
			btn_q_module_2_6
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_2_6.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		}

	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");
		Log.d("pppppppppppppppppppppppppppppppppppp", order_activity + "");
		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(Module2DemographicDetails.this,
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
