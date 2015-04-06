package com.rimon.rsa.ipaeps.module_12_goals;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.coustomt_typeface.CustomTypefaceSpan;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module12GoalsFragment2 extends SherlockFragment implements
		AnyDialogListener, OnClickListener {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private AnyButton btn_ga_q_module_12_4, btn_sg_q_module_12_5;
	private EditText et_sg_module_12_5;
	private String ga_4 = "";
	private String sg_5 = "";
	private String et_c_sg_5 = "";
	private final String index_0 = "I have NO goals I want to work on",
			index_1 = "Set my own specific goal";
	private AnyButton btn_next, btn_previous;
	private AnyTextView tv_score_6;

	private View view;
	private SpannableStringBuilder spannableString;
	private CustomTypefaceSpan customTypefaceSpan;
	private SeekBar skb__q_module_12_6;
	private int skb__q_module_12_6_value = -1;
	private int array_btn_12_2 = -1;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module12Goals) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		customTypefaceSpan = new CustomTypefaceSpan(getActivity());
		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		view = inflater.inflate(R.layout.module_12_goals_fragment_2, null,
				false);
		enableView();

		return view;

	}

	private void enableView() {

		btn_ga_q_module_12_4 = (AnyButton) view
				.findViewById(R.id.btn_ga_q_module_12_4);

		btn_ga_q_module_12_4.setOnClickListener(this);
		btn_sg_q_module_12_5 = (AnyButton) view
				.findViewById(R.id.btn_sg_q_module_12_5);
		btn_sg_q_module_12_5.setOnClickListener(this);

		et_sg_module_12_5 = (EditText) view
				.findViewById(R.id.et_sg_module_12_5);
		et_sg_module_12_5.addTextChangedListener(new TextWatcher() {

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
			public void afterTextChanged(Editable arg0) {
				et_c_sg_5 = arg0.toString();
				// checkNextButtonVisible();

			}
		});

		tv_score_6 = (AnyTextView) view.findViewById(R.id.tv_score_6);

		skb__q_module_12_6 = (SeekBar) view
				.findViewById(R.id.skb__q_module_12_6);

		skb__q_module_12_6
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
						skb__q_module_12_6_value = arg1;
						tv_score_6.setText(String.valueOf(arg1));
						// checkNextButtonVisible();

					}
				});

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setEnabled(true);
		btn_next.setOnClickListener(this);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
	}

	private void getValue() {
		if (ga_4.equals("")) {
			AppConstants.q_module_12_4 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_12_4 = ga_4;
		}

		if (et_sg_module_12_5.isEnabled()) {
			if (et_c_sg_5.equals("")) {
				AppConstants.q_module_12_5 = AppConstants.DEFULLT_DATA;
			} else {
				AppConstants.q_module_12_5 = et_c_sg_5;
			}

		} else {
			if (sg_5.equals("")) {
				AppConstants.q_module_12_5 = AppConstants.DEFULLT_DATA;
			} else {
				AppConstants.q_module_12_5 = sg_5;
			}
		}
		if (skb__q_module_12_6_value == -1) {
			AppConstants.q_module_12_6 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_12_6 = String
					.valueOf(skb__q_module_12_6_value);
		}
		Log.d("AppConstants.q_module_12_4", AppConstants.q_module_12_4);
		Log.d("AppConstants.q_module_12_5", AppConstants.q_module_12_5);
		Log.d("AppConstants.q_module_12_6", AppConstants.q_module_12_6);

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_ga_q_module_12_4:
			btn_ga_q_module_12_4.setText(selected_item);
			ga_4 = selected_item;
			et_sg_module_12_5.setText("");
			if (et_sg_module_12_5.isEnabled()) {
				et_sg_module_12_5.setEnabled(false);

			}
			if (btn_sg_q_module_12_5.isEnabled()) {
				btn_sg_q_module_12_5.setEnabled(false);
			}
			if (selected_item.equals(index_0)) {
				sg_5 = AppConstants.DEFULLT_DATA;

			} else if (selected_item.equals(index_1)) {
				et_sg_module_12_5.setEnabled(true);
				et_sg_module_12_5.requestFocus();
			} else {
				btn_sg_q_module_12_5.setEnabled(true);
				setArrayList(selected_item);
			}
			setLastStateGA(btn_ga_q_module_12_4);
			break;

		case R.id.btn_sg_q_module_12_5:
			sg_5 = selected_item;

			et_sg_module_12_5.setText(setTextColor(selected_item));
			setLastStateSp(btn_sg_q_module_12_5);
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
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_ga_q_module_12_4:
			showDialog(R.array.array_modue_12_ga, R.id.btn_ga_q_module_12_4,
					R.string.general_area, ga_4);

			break;
		case R.id.btn_sg_q_module_12_5:

			showDialog(array_btn_12_2, R.id.btn_sg_q_module_12_5,
					R.string.specific_goal, sg_5);
			break;

		case R.id.btn_next:
			getValue();
			listener.pageChange(AppConstants.MODULE_12_PAGE_3);
			break;
		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_12_PAGE_1);
			break;

		}

	}

	// private void checkNextButtonVisible() {
	// if (check_et() && (skb__q_module_12_6_value > 0) && check_sg()
	// && check_ga()) {
	// btn_next.setEnabled(true);
	// } else {
	// btn_next.setEnabled(false);
	// }
	//
	// }
	//
	// private boolean check_sg() {
	//
	// if (btn_sg_q_module_12_5.isEnabled()) {
	// if (sg_5.equals("")) {
	// return false;
	// } else {
	// return true;
	// }
	//
	// } else {
	//
	// return true;
	// }
	// }
	//
	// private boolean check_ga() {
	//
	// if (ga_4.equals("")) {
	// return false;
	// } else {
	// return true;
	// }
	//
	// }
	//
	// private boolean check_et() {
	// if (et_sg_module_12_5.isEnabled()) {
	// if (et_c_sg_5.equals("")) {
	// return false;
	// } else {
	// return true;
	// }
	//
	// } else {
	// return true;
	// }
	// }

	private void setArrayList(String valueString) {
		List<String> drug_arrray = Arrays.asList(getActivity().getResources()
				.getStringArray(R.array.array_modue_12_ga));
		int index = drug_arrray.indexOf(valueString);
		int temp_index = -1;
		switch (index) {
		case 2:
			temp_index = R.array.m_12_index_2;
			break;

		case 3:
			temp_index = R.array.m_12_index_3;
			break;

		case 4:
			temp_index = R.array.m_12_index_4;
			break;

		case 5:
			temp_index = R.array.m_12_index_5;
			break;
		case 6:
			temp_index = R.array.m_12_index_6;
			break;

		case 7:
			temp_index = R.array.m_12_index_7;
			break;
		case 8:
			temp_index = R.array.m_12_index_8;
			break;

		case 9:
			temp_index = R.array.m_12_index_9;
			break;
		case 10:
			temp_index = R.array.m_12_index_10;
			break;

		case 11:
			temp_index = R.array.m_12_index_11;
			break;
		case 12:
			temp_index = R.array.m_12_index_12;
			break;

		case 13:
			temp_index = R.array.m_12_index_13;
			break;
		}
		array_btn_12_2 = temp_index;

	}

	private SpannableStringBuilder setTextColor(String text) {
		spannableString = new SpannableStringBuilder(text);
		spannableString.setSpan(customTypefaceSpan, 0, text.length(), 0);
		spannableString.setSpan(new ForegroundColorSpan(getActivity()
				.getResources().getColor(R.color.teal)), 0, text.length(), 0);

		return spannableString;
	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

	private void setLastStateGA(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

	private void setLastStateSp(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_bacground_reverse);
		anyButton.setTextColor(getActivity().getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(
				R.drawable.btn_goal_left_last_state, 0, 0, 0);

	}

}