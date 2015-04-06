package com.rimon.rsa.ipaeps.module_14_identify_problems;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module14IdentifyProblemsFragment1 extends SherlockFragment
		implements OnSeekBarChangeListener, AnyDialogListener, OnClickListener {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private LinearLayout layout;
	private Animation animation;
	private AnyButton btn_q_module_14_1, btn_q_module_14_3;
	private EditText et_q_module_14_1, et_q_module_14_3;
	private String et_value_1 = "", et_value_3 = "";
	private String btn_value_1 = "-1", btn_value_3 = "-1";
	private boolean btn_c_1, btn_c_3;

	private AnyTextView q_module_14_main_title;

	// btn title
	private AnyTextView q_module_14_1_title, q_module_14_2_title;

	// seek ber title
	private AnyTextView q_module_14_1, q_module_14_2;
	private AnyTextView tv_score_1, tv_score_2, tv_score_3, tv_score_4;
	private AnyTextView tv_l_r_1, tv_l_r_2, tv_l_r_3, tv_l_r_4;

	// score
	private AnyTextView tv_q_module_14_score_2, tv_q_module_14_score_4;
	private SeekBar skb_q_module_14_2, skb_q_module_14_4;

	private AnyButton btn_next;

	private int score_2 = -1, score_4 = -1;
	private View view;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module14IdentifyProblems) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		view = inflater.inflate(R.layout.module_14_identify_problem_1, null,
				false);

		layout = (LinearLayout) view
				.findViewById(R.id.linear_layout_identify_1);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getValue();
				listener.pageChange(AppConstants.MODULE_14_PAGE_2);

			}
		});

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

	private void getValue() {
		if (et_q_module_14_1.isEnabled()) {
			AppConstants.q_module_14_1 = et_value_1;
		} else {
			AppConstants.q_module_14_1 = btn_value_1;
		}

		AppConstants.q_module_14_2 = String.valueOf(score_2);
		if (et_q_module_14_3.isEnabled()) {
			AppConstants.q_module_14_3 = et_value_3;
		} else {
			AppConstants.q_module_14_3 = btn_value_3;
		}

		AppConstants.q_module_14_4 = String.valueOf(score_4);

		Log.d("AppConstants.q_module_14_1", AppConstants.q_module_14_1);
		Log.d("AppConstants.q_module_14_2", AppConstants.q_module_14_2);
		Log.d("AppConstants.q_module_14_3", AppConstants.q_module_14_3);
		Log.d("AppConstants.q_module_14_4", AppConstants.q_module_14_4);
	}

	private void enableView() {
		q_module_14_main_title = (AnyTextView) view
				.findViewById(R.id.q_module_14_main_title);
		q_module_14_main_title.setEnabled(true);
		q_module_14_1_title = (AnyTextView) view
				.findViewById(R.id.q_module_14_1_title);
		q_module_14_1_title.setEnabled(true);
		q_module_14_2_title = (AnyTextView) view
				.findViewById(R.id.q_module_14_2_title);
		q_module_14_2_title.setEnabled(true);

		q_module_14_1 = (AnyTextView) view.findViewById(R.id.q_module_14_1);
		q_module_14_1.setEnabled(true);
		q_module_14_2 = (AnyTextView) view.findViewById(R.id.q_module_14_2);
		q_module_14_2.setEnabled(true);

		tv_score_1 = (AnyTextView) view.findViewById(R.id.tv_score_1);
		tv_score_1.setEnabled(true);
		tv_score_2 = (AnyTextView) view.findViewById(R.id.tv_score_2);
		tv_score_2.setEnabled(true);
		tv_score_3 = (AnyTextView) view.findViewById(R.id.tv_score_3);
		tv_score_3.setEnabled(true);
		tv_score_4 = (AnyTextView) view.findViewById(R.id.tv_score_4);
		tv_score_4.setEnabled(true);

		tv_q_module_14_score_2 = (AnyTextView) view
				.findViewById(R.id.tv_q_module_14_score_2);
		tv_q_module_14_score_2.setEnabled(true);
		tv_q_module_14_score_4 = (AnyTextView) view
				.findViewById(R.id.tv_q_module_14_score_4);
		tv_q_module_14_score_4.setEnabled(true);

		skb_q_module_14_2 = (SeekBar) view
				.findViewById(R.id.skb__q_module_14_2);
		skb_q_module_14_2.setEnabled(true);
		skb_q_module_14_4 = (SeekBar) view
				.findViewById(R.id.skb__q_module_14_4);
		skb_q_module_14_4.setEnabled(true);

		skb_q_module_14_2.setOnSeekBarChangeListener(this);
		skb_q_module_14_4.setOnSeekBarChangeListener(this);

		tv_l_r_1 = (AnyTextView) view.findViewById(R.id.tv_l_r_1);
		tv_l_r_1.setEnabled(true);
		tv_l_r_2 = (AnyTextView) view.findViewById(R.id.tv_l_r_2);
		tv_l_r_2.setEnabled(true);
		tv_l_r_3 = (AnyTextView) view.findViewById(R.id.tv_l_r_3);
		tv_l_r_3.setEnabled(true);
		tv_l_r_4 = (AnyTextView) view.findViewById(R.id.tv_l_r_4);
		tv_l_r_4.setEnabled(true);
		btn_q_module_14_1 = (AnyButton) view
				.findViewById(R.id.btn_q_module_14_1);

		btn_q_module_14_3 = (AnyButton) view
				.findViewById(R.id.btn_q_module_14_3);
		btn_q_module_14_1.setEnabled(true);
		btn_q_module_14_3.setEnabled(true);
		btn_q_module_14_1.setOnClickListener(this);
		btn_q_module_14_3.setOnClickListener(this);
		et_q_module_14_1 = (EditText) view.findViewById(R.id.et_q_module_14_1);
		et_q_module_14_3 = (EditText) view.findViewById(R.id.et_q_module_14_3);
		et_q_module_14_1.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				et_value_1 = s.toString().trim();
				checkNextButtonVisible();
			}
		});
		et_q_module_14_3.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				et_value_3 = s.toString().trim();
				checkNextButtonVisible();

			}
		});

	}

	private void checkNextButtonVisible() {
		if (score_2 >= 0 && score_4 >= 0 && check_btn() && check_et_1()
				&& check_et_3()) {

			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}

	private boolean check_btn() {
		if (btn_c_1 && btn_c_3) {
			return true;
		}

		return false;
	}

	private boolean check_et_1() {
		if (et_q_module_14_1.isEnabled()) {
			if (et_value_1.equals("")) {
				return false;

			} else {
				return true;
			}
		}

		return true;
	}

	private boolean check_et_3() {
		if (et_q_module_14_3.isEnabled()) {
			if (et_value_3.equals("")) {
				return false;

			} else {
				return true;
			}
		}

		return true;
	}

	@Override
	public void onProgressChanged(SeekBar id, int process, boolean arg2) {
		switch (id.getId()) {
		case R.id.skb__q_module_14_2:
			score_2 = process;
			tv_q_module_14_score_2.setText(String.valueOf(score_2));
			break;
		case R.id.skb__q_module_14_4:
			score_4 = process;
			tv_q_module_14_score_4.setText(String.valueOf(score_4));
			break;

		}
		checkNextButtonVisible();

	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

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
		case R.id.btn_q_module_14_1:
			showDialog(R.array.arry_14_q, R.id.btn_q_module_14_1,
					R.string.q_module_14_1_title, btn_value_1);
			break;
		case R.id.btn_q_module_14_3:
			showDialog(R.array.arry_14_q, R.id.btn_q_module_14_3,
					R.string.q_module_14_2_title, btn_value_3);
			break;

		}

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {

		case R.id.btn_q_module_14_1:
			btn_c_1 = true;
			btn_value_1 = selected_item;
			btn_q_module_14_1.setText(selected_item);
			if (selected_item.equals("Other")) {
				et_q_module_14_1.setEnabled(true);
				et_q_module_14_1.requestFocus();
			} else {
				et_q_module_14_1.setEnabled(false);
				et_value_1 = "";
				et_q_module_14_1.setText("");
			}

			break;

		case R.id.btn_q_module_14_3:
			btn_c_3 = true;
			btn_value_3 = selected_item;
			btn_q_module_14_3.setText(selected_item);
			if (selected_item.equals("Other")) {
				et_q_module_14_3.setEnabled(true);
				et_q_module_14_3.requestFocus();
			} else {
				et_q_module_14_3.setEnabled(false);
				et_value_3 = "";
				et_q_module_14_3.setText("");
			}

			break;
		}
		checkNextButtonVisible();
	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

}
