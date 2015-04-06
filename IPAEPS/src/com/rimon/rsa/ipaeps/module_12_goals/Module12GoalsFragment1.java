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
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class Module12GoalsFragment1 extends SherlockFragment implements
		AnyDialogListener, OnClickListener {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private LinearLayout layout;
	private Animation animation;
	private AnyButton btn_ga_q_module_12_1, btn_sg_q_module_12_2;
	private EditText et_sg_module_12_2;
	private String ga_1 = "";
	private String sg_1 = "";
	private String et_c_sg_1 = "";
	private final String index_0 = "I have NO goals I want to work on",
			index_1 = "Set my own specific goal";
	private AnyButton btn_next;
	private AnyTextView tv_module_12_title_1, tv_q_module_12_1,
			tv_module_12_goal_title_1, tv_score_1, tv_score_2, tv_score_3,
			tv_12_sk_2, tv_12_sk_1;

	private View view;
	private SpannableStringBuilder spannableString;
	private CustomTypefaceSpan customTypefaceSpan;
	private SeekBar skb__q_module_12_3;
	private int skb__q_module_12_3_value = -1;
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
		view = inflater.inflate(R.layout.module_12_goals_fragment_1, null,
				false);

		layout = (LinearLayout) view.findViewById(R.id.linear_layout_goal_12_1);

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
		tv_module_12_title_1 = (AnyTextView) view
				.findViewById(R.id.tv_module_12_title_1);
		tv_module_12_title_1.setEnabled(true);
		tv_q_module_12_1 = (AnyTextView) view
				.findViewById(R.id.tv_q_module_12_1);
		tv_q_module_12_1.setEnabled(true);
		btn_ga_q_module_12_1 = (AnyButton) view
				.findViewById(R.id.btn_ga_q_module_12_1);
		btn_ga_q_module_12_1.setEnabled(true);
		btn_ga_q_module_12_1.setOnClickListener(this);
		btn_sg_q_module_12_2 = (AnyButton) view
				.findViewById(R.id.btn_sg_q_module_12_2);
		btn_sg_q_module_12_2.setOnClickListener(this);

		et_sg_module_12_2 = (EditText) view
				.findViewById(R.id.et_sg_module_12_2);
		et_sg_module_12_2.addTextChangedListener(new TextWatcher() {

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
				et_c_sg_1 = arg0.toString();
				checkNextButtonVisible();

			}
		});

		tv_module_12_goal_title_1 = (AnyTextView) view
				.findViewById(R.id.tv_module_12_goal_title_1);
		tv_module_12_goal_title_1.setEnabled(true);
		tv_score_1 = (AnyTextView) view.findViewById(R.id.tv_score_1);
		tv_score_1.setEnabled(true);

		tv_score_2 = (AnyTextView) view.findViewById(R.id.tv_score_2);
		tv_score_2.setEnabled(true);
		tv_score_3 = (AnyTextView) view.findViewById(R.id.tv_score_3);
		tv_score_3.setEnabled(true);
		skb__q_module_12_3 = (SeekBar) view
				.findViewById(R.id.skb__q_module_12_3);
		skb__q_module_12_3.setEnabled(true);
		skb__q_module_12_3
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
						skb__q_module_12_3_value = arg1;
						tv_score_2.setText(String.valueOf(arg1));
						checkNextButtonVisible();

					}
				});

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(this);
		tv_12_sk_2 = (AnyTextView) view.findViewById(R.id.tv_12_sk_2);
		tv_12_sk_2.setEnabled(true);

		tv_12_sk_1 = (AnyTextView) view.findViewById(R.id.tv_12_sk_1);
		tv_12_sk_1.setEnabled(true);
	}

	private void getValue() {

		AppConstants.q_module_12_1 = ga_1;

		if (et_sg_module_12_2.isEnabled()) {
			AppConstants.q_module_12_2 = et_c_sg_1;

		} else {
			AppConstants.q_module_12_2 = sg_1;
		}

		AppConstants.q_module_12_3 = String.valueOf(skb__q_module_12_3_value);

		Log.d("AppConstants.q_module_12_1", AppConstants.q_module_12_1);
		Log.d("AppConstants.q_module_12_2", AppConstants.q_module_12_2);
		Log.d("AppConstants.q_module_12_3", AppConstants.q_module_12_3);

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_ga_q_module_12_1:
			btn_ga_q_module_12_1.setText(selected_item);
			ga_1 = selected_item;
			et_sg_module_12_2.setText("");
			if (et_sg_module_12_2.isEnabled()) {
				et_sg_module_12_2.setEnabled(false);

			}
			if (btn_sg_q_module_12_2.isEnabled()) {
				btn_sg_q_module_12_2.setEnabled(false);
			}
			if (selected_item.equals(index_0)) {
				sg_1 = AppConstants.DEFULLT_DATA;

			} else if (selected_item.equals(index_1)) {
				et_sg_module_12_2.setEnabled(true);
				et_sg_module_12_2.requestFocus();
			} else {
				btn_sg_q_module_12_2.setEnabled(true);
				setArrayList(selected_item);
			}
			setLastStateGA(btn_ga_q_module_12_1);

			break;

		case R.id.btn_sg_q_module_12_2:
			sg_1 = selected_item;
			et_sg_module_12_2.setText(setTextColor(selected_item));
			setLastStateSp(btn_sg_q_module_12_2);
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
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_ga_q_module_12_1:
			showDialog(R.array.array_modue_12_ga, R.id.btn_ga_q_module_12_1,
					R.string.general_area, ga_1);

			break;
		case R.id.btn_sg_q_module_12_2:

			showDialog(array_btn_12_2, R.id.btn_sg_q_module_12_2,
					R.string.specific_goal, sg_1);
			break;

		case R.id.btn_next:
			getValue();
			listener.pageChange(AppConstants.MODULE_12_PAGE_2);
		}

	}

	private void checkNextButtonVisible() {
		if (check_et() && (skb__q_module_12_3_value >= 0) && check_sg()
				&& check_ga()) {
			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}

	private boolean check_sg() {

		if (btn_sg_q_module_12_2.isEnabled()) {
			if (sg_1.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {

			return true;
		}
	}

	private boolean check_ga() {

		if (ga_1.equals("")) {
			return false;
		} else {
			return true;
		}

	}

	private boolean check_et() {
		if (et_sg_module_12_2.isEnabled()) {
			if (et_c_sg_1.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}
	}

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