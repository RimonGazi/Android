package com.rimon.rsa.ipaeps.module_6_pain;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.radiobutton.AnyRadioButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module6PainFragment_1 extends SherlockFragment implements
		OnClickListener, OnCheckedChangeListener, AnyDialogListener {
	private boolean isSingleDiaglog = true;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private LinearLayout layout;
	private Animation animation;

	private AnyButton btn_q_module_6_1, btn_q_module_6_3, btn_next;
	private RadioGroup rg_q_module_6_2_1, rg_q_module_6_2_2;
	private SeekBar skb_q_module_6_4;
	private AnyTextView tv_score_4;
	private View view;
	private String value_1 = "", value_3 = "";
	private int value_4 = -1;
	private int value_2 = -1;

	private int LOCATION_SELECT_FIRST = 0;
	private int LOCATION_SELECT_LAST = 0;
	private List<String> locationList;

	private AnyPageChangeListener listener;

	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		listener = (Module6Pain) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		locationList = Arrays.asList(getResources().getStringArray(
				R.array.loacation));
		LOCATION_SELECT_LAST = locationList.size() - 1;
		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		view = inflater.inflate(R.layout.module_6_pain_fragment_1, null, false);
		layout = (LinearLayout) view.findViewById(R.id.paint_layout_1);
		animation = AppObject.getScaleAnimition(getActivity());
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
		btn_q_module_6_1 = (AnyButton) view.findViewById(R.id.btn_q_module_6_1);
		btn_q_module_6_1.setOnClickListener(this);
		btn_q_module_6_3 = (AnyButton) view.findViewById(R.id.btn_q_module_6_3);
		btn_q_module_6_3.setOnClickListener(this);
		rg_q_module_6_2_1 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_6_2_1);
		rg_q_module_6_2_2 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_6_2_2);
		rg_q_module_6_2_1.setOnCheckedChangeListener(this);
		rg_q_module_6_2_2.setOnCheckedChangeListener(this);
		tv_score_4 = (AnyTextView) view.findViewById(R.id.tv_score_4);
		skb_q_module_6_4 = (SeekBar) view.findViewById(R.id.skb_q_module_6_4);
		skb_q_module_6_4
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onStartTrackingTouch(SeekBar arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProgressChanged(SeekBar arg0, int arg1,
							boolean arg2) {
						tv_score_4.setText(String.valueOf(arg1));
						value_4 = arg1;
						checkNextButtonVisible();

					}
				});
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:
			getValue();
			listener.pageChange(AppConstants.MODULE_6_PAGE_2);

			break;
		case R.id.btn_q_module_6_1:
			showDialog(R.array.loacation, R.id.btn_q_module_6_1,
					R.string.location_selected, value_1);

		case R.id.btn_q_module_6_3:
			showDialog(R.array.duration_of_pain, R.id.btn_q_module_6_3,
					R.string.duration_of_pain, value_3);
		}
	}

	private void getValue() {
		AppConstants.q_module_6_1 = value_1;
		AppConstants.q_module_6_3 = value_3;

		if (value_2 != -1) {
			AppConstants.q_module_6_2 = ((AnyRadioButton) view
					.findViewById(value_2)).getText().toString();
		} else {
			AppConstants.q_module_6_2 = AppConstants.DEFULLT_DATA;
		}

		AppConstants.q_module_6_4 = String.valueOf(value_4);

		Log.d("AppConstants.q_module_6_1", AppConstants.q_module_6_1);
		Log.d("AppConstants.q_module_6_2", AppConstants.q_module_6_2);
		Log.d("AppConstants.q_module_6_3", AppConstants.q_module_6_3);
		Log.d("AppConstants.q_module_6_4", AppConstants.q_module_6_4);

	}

	private void checkNextButtonVisible() {
		if (chek_rg() && check_btn() && (value_4 >= 0)) {
			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}

	private boolean check_btn() {

		if (!value_1.equals("") && !value_3.equals("")) {
			return true;
		} else {
			return false;
		}

	}

	private boolean chek_rg() {
		value_2 = rg_q_module_6_2_1.getCheckedRadioButtonId() == -1 ? rg_q_module_6_2_2
				.getCheckedRadioButtonId() : rg_q_module_6_2_1
				.getCheckedRadioButtonId();
		if (value_2 != -1)
			return true;

		return false;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (group.getId()) {
		case R.id.rg_q_module_6_2_1:
			if (checkedId != -1) {
				rg_q_module_6_2_2.setOnCheckedChangeListener(null);
				rg_q_module_6_2_2.clearCheck();
				rg_q_module_6_2_2.setOnCheckedChangeListener(this);
			}

			break;

		case R.id.rg_q_module_6_2_2:
			if (checkedId != -1) {
				rg_q_module_6_2_1.setOnCheckedChangeListener(null);
				rg_q_module_6_2_1.clearCheck();
				rg_q_module_6_2_1.setOnCheckedChangeListener(this);
			}

			break;

		}
		checkNextButtonVisible();
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

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_q_module_6_1:
			btn_q_module_6_1.setText(selected_item);
			value_1 = selected_item;
			setLastState(btn_q_module_6_1);
			if (LOCATION_SELECT_FIRST == locationList.indexOf(selected_item)
					|| LOCATION_SELECT_LAST == locationList
							.indexOf(selected_item)) {
				disableView();
				btn_next.setEnabled(true);
			} else {
				enableView_2();
				checkNextButtonVisible();
			}

			break;

		case R.id.btn_q_module_6_3:
			btn_q_module_6_3.setText(selected_item);
			value_3 = selected_item;
			setLastState(btn_q_module_6_3);
			checkNextButtonVisible();

			break;
		}

	}

	private void disableView() {
		rg_q_module_6_2_1.clearCheck();
		rg_q_module_6_2_2.clearCheck();
		btn_q_module_6_3.setText(getResources().getString(
				R.string.duration_of_pain));

		btn_q_module_6_3.setEnabled(false);

		for (int i = 0; i < rg_q_module_6_2_1.getChildCount(); i++) {
			(rg_q_module_6_2_1.getChildAt(i)).setEnabled(false);
		}
		for (int i = 0; i < rg_q_module_6_2_2.getChildCount(); i++) {
			(rg_q_module_6_2_2.getChildAt(i)).setEnabled(false);
		}

		skb_q_module_6_4.setProgress(0);
		skb_q_module_6_4.setEnabled(false);

	}

	private void enableView_2() {

		btn_q_module_6_3.setEnabled(true);
		for (int i = 0; i < rg_q_module_6_2_1.getChildCount(); i++) {
			(rg_q_module_6_2_1.getChildAt(i)).setEnabled(true);
		}
		for (int i = 0; i < rg_q_module_6_2_2.getChildCount(); i++) {
			(rg_q_module_6_2_2.getChildAt(i)).setEnabled(true);
		}
		skb_q_module_6_4.setEnabled(true);

	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getActivity().getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

}
