package com.rimon.rsa.ipaeps.module_3_ibd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

public class Module3IbdFragment1 extends SherlockFragment implements
		AnyDialogListener, OnClickListener, UpdateFragment {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyButton btn_q_module_3_1, btn_q_module_3_2, btn_q_module_3_3,
			btn_q_module_3_4, btn_q_module_3_5;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private LinearLayout layout;
	private Animation animation;
	private boolean c_m_s_q_1, c_m_s_q_2, c_m_s_q_3, c_m_s_q_4, c_m_s_q_5;
	private AnyButton btn_next;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module3Ibd) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		View view = inflater.inflate(R.layout.module_3_ibd_fragment_1, null,
				false);
		layout = (LinearLayout) view.findViewById(R.id.linear_layout_ibd_1);
		btn_q_module_3_1 = (AnyButton) view.findViewById(R.id.btn_q_module_3_1);
		btn_q_module_3_1.setOnClickListener(this);
		btn_q_module_3_2 = (AnyButton) view.findViewById(R.id.btn_q_module_3_2);
		btn_q_module_3_2.setOnClickListener(this);
		btn_q_module_3_3 = (AnyButton) view.findViewById(R.id.btn_q_module_3_3);
		btn_q_module_3_3.setOnClickListener(this);
		btn_q_module_3_4 = (AnyButton) view.findViewById(R.id.btn_q_module_3_4);
		btn_q_module_3_4.setOnClickListener(this);
		btn_q_module_3_5 = (AnyButton) view.findViewById(R.id.btn_q_module_3_5);
		btn_q_module_3_5.setOnClickListener(this);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_3_PAGE_2);
				Log.d("AppConstants.q_module_3_1", AppConstants.q_module_3_1);
				Log.d("AppConstants.q_module_3_2", AppConstants.q_module_3_2);
				Log.d("AppConstants.q_module_3_3", AppConstants.q_module_3_3);
				Log.d("AppConstants.q_module_3_4", AppConstants.q_module_3_4);
				Log.d("AppConstants.q_module_3_5", AppConstants.q_module_3_5);

			}
		});
		disableView();
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

	private void disableView() {
		btn_q_module_3_1.setEnabled(false);
		btn_q_module_3_2.setEnabled(false);
		btn_q_module_3_3.setEnabled(false);
		btn_q_module_3_4.setEnabled(false);
		btn_q_module_3_5.setEnabled(false);

	}

	private void enableView() {
		btn_q_module_3_1.setEnabled(true);
		btn_q_module_3_2.setEnabled(true);
		btn_q_module_3_3.setEnabled(true);
		btn_q_module_3_4.setEnabled(true);
		btn_q_module_3_5.setEnabled(true);
		btn_q_module_3_1.setBackgroundResource(R.drawable.btn_left_mid_state);

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_q_module_3_1:
			btn_q_module_3_1.setText(selected_item);
			AppConstants.q_module_3_1 = selected_item;
			setLastState(btn_q_module_3_1);
			c_m_s_q_1 = true;
			setMidState();
			break;
		case R.id.btn_q_module_3_2:
			btn_q_module_3_2.setText(selected_item);
			AppConstants.q_module_3_2 = selected_item;
			setLastState(btn_q_module_3_2);
			c_m_s_q_2 = true;
			setMidState();
			break;
		case R.id.btn_q_module_3_3:
			btn_q_module_3_3.setText(selected_item);
			AppConstants.q_module_3_3 = selected_item;
			setLastState(btn_q_module_3_3);
			c_m_s_q_3 = true;
			setMidState();
			break;
		case R.id.btn_q_module_3_4:
			btn_q_module_3_4.setText(selected_item);
			AppConstants.q_module_3_4 = selected_item;
			setLastState(btn_q_module_3_4);
			c_m_s_q_4 = true;
			setMidState();
			break;
		case R.id.btn_q_module_3_5:
			btn_q_module_3_5.setText(selected_item);
			AppConstants.q_module_3_5 = selected_item;
			setLastState(btn_q_module_3_5);
			c_m_s_q_5 = true;
			setMidState();
			break;
		}

		checkNextButtonVisible();
	}

	private void checkNextButtonVisible() {

		if (c_m_s_q_1 && c_m_s_q_2 && c_m_s_q_3 && c_m_s_q_3 && c_m_s_q_5)
			btn_next.setEnabled(true);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_q_module_3_1:
			showDialog(R.array.condition, R.id.btn_q_module_3_1,
					R.string.q_module_3_1, AppConstants.q_module_3_1);
			break;
		case R.id.btn_q_module_3_2:
			showDialog(R.array.diagnosed_with_ibd, R.id.btn_q_module_3_2,
					R.string.q_module_3_2, AppConstants.q_module_3_2);
			break;
		case R.id.btn_q_module_3_3:
			showDialog(R.array.past_3_month_ibd, R.id.btn_q_module_3_3,
					R.string.q_module_3_3, AppConstants.q_module_3_3);
			break;
		case R.id.btn_q_module_3_4:
			showDialog(R.array.zero_to_thirty, R.id.btn_q_module_3_4,
					R.string.q_module_3_4, AppConstants.q_module_3_4);
			break;
		case R.id.btn_q_module_3_5:
			showDialog(R.array.zero_to_thirty, R.id.btn_q_module_3_5,
					R.string.q_module_3_5, AppConstants.q_module_3_5);
			break;
		}

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
			diaglogFragment.show(getActivity().getSupportFragmentManager(),
					"diaglog");
		}

	}

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getActivity().getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

	private void setMidState() {
		if (!c_m_s_q_1) {
			btn_q_module_3_1
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_3_1.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_2) {
			btn_q_module_3_2
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_3_2.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);
		} else if (!c_m_s_q_3) {
			btn_q_module_3_3
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_3_3.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);
		} else if (!c_m_s_q_4) {
			btn_q_module_3_4
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_3_4.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);
		} else if (!c_m_s_q_5) {
			btn_q_module_3_5
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_3_5.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);
		}

	}

	@Override
	public void Update() {
		disableView();
		layout.startAnimation(animation);
	}
	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;
	}

}
