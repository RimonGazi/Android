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
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.radiobutton.AnyRadioButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module6PainFragment_2 extends SherlockFragment implements
		OnClickListener, OnCheckedChangeListener, AnyDialogListener {
	private boolean isSingleDiaglog = true;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private AnyButton btn_q_module_6_5, btn_q_module_6_7, btn_next,
			btn_previous;
	private RadioGroup rg_q_module_6_6_1, rg_q_module_6_6_2;
	private SeekBar skb_q_module_6_8;
	private AnyTextView tv_score_4;
	private View view;
	private String value_5 = "", value_7 = "";
	private int value_8 = -1;
	private int value_6 = -1;
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
		view = inflater.inflate(R.layout.module_6_pain_fragment_2, null, false);
		enableView();
		return view;
	}

	private void disableView() {
		rg_q_module_6_6_1.clearCheck();
		rg_q_module_6_6_2.clearCheck();

		btn_q_module_6_7.setEnabled(false);
		btn_q_module_6_7.setText(getResources().getString(
				R.string.duration_of_pain));
		for (int i = 0; i < rg_q_module_6_6_2.getChildCount(); i++) {
			(rg_q_module_6_6_2.getChildAt(i)).setEnabled(false);
		}
		for (int i = 0; i < rg_q_module_6_6_1.getChildCount(); i++) {
			(rg_q_module_6_6_1.getChildAt(i)).setEnabled(false);
		}
		skb_q_module_6_8.setProgress(0);
		skb_q_module_6_8.setEnabled(false);

	}

	private void enableView_2() {
		rg_q_module_6_6_1.clearCheck();
		rg_q_module_6_6_2.clearCheck();
		btn_q_module_6_7.setText(getResources().getString(
				R.string.duration_of_pain));
		btn_q_module_6_7.setEnabled(true);
		for (int i = 0; i < rg_q_module_6_6_2.getChildCount(); i++) {
			(rg_q_module_6_6_2.getChildAt(i)).setEnabled(true);
		}
		for (int i = 0; i < rg_q_module_6_6_1.getChildCount(); i++) {
			(rg_q_module_6_6_1.getChildAt(i)).setEnabled(true);
		}
		skb_q_module_6_8.setProgress(0);
		skb_q_module_6_8.setEnabled(true);

	}

	private void enableView() {
		btn_q_module_6_5 = (AnyButton) view.findViewById(R.id.btn_q_module_6_5);
		btn_q_module_6_5.setOnClickListener(this);
		btn_q_module_6_7 = (AnyButton) view.findViewById(R.id.btn_q_module_6_7);
		btn_q_module_6_7.setOnClickListener(this);
		rg_q_module_6_6_1 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_6_6_1);
		rg_q_module_6_6_2 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_6_6_2);
		rg_q_module_6_6_1.setOnCheckedChangeListener(this);
		rg_q_module_6_6_2.setOnCheckedChangeListener(this);
		tv_score_4 = (AnyTextView) view.findViewById(R.id.tv_score_4);
		skb_q_module_6_8 = (SeekBar) view.findViewById(R.id.skb_q_module_6_8);
		skb_q_module_6_8
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
						value_8 = arg1;
						// checkNextButtonVisible();

					}
				});
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setEnabled(true);
		btn_next.setOnClickListener(this);

		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:
			getValue();
			listener.pageChange(AppConstants.MODULE_6_PAGE_3);

			break;

		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_6_PAGE_1);

			break;
		case R.id.btn_q_module_6_5:
			showDialog(R.array.loacation, R.id.btn_q_module_6_5,
					R.string.location_selected, value_5);
			break;

		case R.id.btn_q_module_6_7:
			showDialog(R.array.duration_of_pain, R.id.btn_q_module_6_7,
					R.string.duration_of_pain, value_7);
			break;

		}

	}

	private void getValue() {
		if (value_5.equals("")) {
			AppConstants.q_module_6_5 = AppConstants.DEFULLT_DATA;

		} else {
			AppConstants.q_module_6_5 = value_5;
		}

		if (value_7.equals("")) {
			AppConstants.q_module_6_7 = AppConstants.DEFULLT_DATA;

		} else {
			AppConstants.q_module_6_7 = value_7;

		}

		value_6 = rg_q_module_6_6_1.getCheckedRadioButtonId() == -1 ? rg_q_module_6_6_2
				.getCheckedRadioButtonId() : rg_q_module_6_6_1
				.getCheckedRadioButtonId();
		if (value_6 == -1) {
			AppConstants.q_module_6_6 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_6_6 = ((AnyRadioButton) view
					.findViewById(value_6)).getText().toString();
		}
		if (value_8 == -1) {
			AppConstants.q_module_6_8 = AppConstants.DEFULLT_DATA;

		} else {
			AppConstants.q_module_6_8 = String.valueOf(value_8);
		}

		Log.d("AppConstants.q_module_6_5", AppConstants.q_module_6_5);
		Log.d("AppConstants.q_module_6_6", AppConstants.q_module_6_6);
		Log.d("AppConstants.q_module_6_7", AppConstants.q_module_6_7);
		Log.d("AppConstants.q_module_6_8", AppConstants.q_module_6_8);

	}

	// private void checkNextButtonVisible() {
	// if (chek_rg() && check_btn() && (value_8 > 0)) {
	// btn_next.setEnabled(true);
	// } else {
	// btn_next.setEnabled(false);
	// }
	//
	// }

	// private boolean check_btn() {
	//
	// if (!value_5.equals("") && !value_7.equals("")) {
	// return true;
	// } else {
	// return false;
	// }
	//
	// }
	//
	// private boolean chek_rg() {
	// value_6 = rg_q_module_6_6_1.getCheckedRadioButtonId() == -1 ?
	// rg_q_module_6_6_2
	// .getCheckedRadioButtonId() : rg_q_module_6_6_1
	// .getCheckedRadioButtonId();
	// if (value_6 != -1)
	// return true;
	//
	// return false;
	// }

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (group.getId()) {
		case R.id.rg_q_module_6_6_1:
			if (checkedId != -1) {
				rg_q_module_6_6_2.setOnCheckedChangeListener(null);
				rg_q_module_6_6_2.clearCheck();
				rg_q_module_6_6_2.setOnCheckedChangeListener(this);
			}

			break;

		case R.id.rg_q_module_6_6_2:
			if (checkedId != -1) {
				rg_q_module_6_6_1.setOnCheckedChangeListener(null);
				rg_q_module_6_6_1.clearCheck();
				rg_q_module_6_6_1.setOnCheckedChangeListener(this);
			}

			break;

		}
		// checkNextButtonVisible();
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
		case R.id.btn_q_module_6_5:
			btn_q_module_6_5.setText(selected_item);
			value_5 = selected_item;
			setLastState(btn_q_module_6_5);
			if (LOCATION_SELECT_FIRST == locationList.indexOf(selected_item)
					|| LOCATION_SELECT_LAST == locationList
							.indexOf(selected_item)) {
				disableView();

			} else {
				enableView_2();

			}

			break;

		case R.id.btn_q_module_6_7:
			btn_q_module_6_7.setText(selected_item);
			value_7 = selected_item;
			setLastState(btn_q_module_6_7);

			break;
		}
		// checkNextButtonVisible();

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
