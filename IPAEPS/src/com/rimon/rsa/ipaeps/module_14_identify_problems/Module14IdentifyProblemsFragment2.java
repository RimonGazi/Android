package com.rimon.rsa.ipaeps.module_14_identify_problems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.rimon.rsa.ipaeps.appdatabase.SavePatientData;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.classtorun.ClassRunActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

import java.util.ArrayList;

public class Module14IdentifyProblemsFragment2 extends SherlockFragment
		implements OnSeekBarChangeListener, AnyDialogListener {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private String btn_value_5 = "-1";
	private boolean cb_bnt_5;
	private EditText et_q_module_14_5;
	private String et_value_5 = "";

	// score
	private AnyTextView tv_q_module_14_score_6;
	private SeekBar skb__q_module_14_6;

	private AnyButton btn_next, btn_previous, btn_q_module_14_5;

	private int score_6 = -1;
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
		view = inflater.inflate(R.layout.module_14_identify_problem_2, null,
				false);

		enableView();
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getValue();
				startActivity(getIntentToRun());
				getActivity().finish();

			}
		});
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_14_PAGE_1);

			}
		});
		btn_q_module_14_5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(R.array.arry_14_q, R.id.btn_q_module_14_5,
						R.string.q_module_14_3_title, btn_value_5);

			}
		});
		et_q_module_14_5.addTextChangedListener(new TextWatcher() {

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
				et_value_5 = s.toString();
				checkNextButtonVisible();

			}
		});

		return view;

	}

	private void getValue() {

		if (et_q_module_14_5.isEnabled()) {
			AppConstants.q_module_14_5 = et_value_5;

		} else {
			AppConstants.q_module_14_5 = btn_value_5;
		}
		AppConstants.q_module_14_6 = String.valueOf(score_6);

		Log.d("AppConstants.q_module_14_5", AppConstants.q_module_14_5);
		Log.d("AppConstants.q_module_14_6", AppConstants.q_module_14_6);

	}

	private void checkNextButtonVisible() {
		if (score_6 > 0 && cb_et() && cb_bnt_5) {

			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}

	private boolean cb_et() {
		if (et_q_module_14_5.isEnabled()) {
			if (et_value_5.equals("")) {
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

		case R.id.skb__q_module_14_6:
			score_6 = process;
			tv_q_module_14_score_6.setText(String.valueOf(score_6));
			checkNextButtonVisible();
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

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		if (view_id == R.id.btn_q_module_14_5) {
			cb_bnt_5 = true;
			btn_value_5 = selected_item;
			btn_q_module_14_5.setText(selected_item);
			if (selected_item.equals("Other")) {
				et_q_module_14_5.setEnabled(true);
				et_q_module_14_5.requestFocus();
			} else {
				et_q_module_14_5.setEnabled(false);
				et_value_5 = "";
				et_q_module_14_5.setText("");
			}
			checkNextButtonVisible();
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

	private void enableView() {

		btn_q_module_14_5 = (AnyButton) view
				.findViewById(R.id.btn_q_module_14_5);

		tv_q_module_14_score_6 = (AnyTextView) view
				.findViewById(R.id.tv_q_module_14_score_6);

		skb__q_module_14_6 = (SeekBar) view
				.findViewById(R.id.skb__q_module_14_6);
		skb__q_module_14_6.setEnabled(true);
		skb__q_module_14_6.setOnSeekBarChangeListener(this);
		et_q_module_14_5 = (EditText) view.findViewById(R.id.et_q_module_14_5);
	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getActivity().getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");

		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(getActivity(), classes.get(order_activity));

		Bundle bundleTo = new Bundle();
		bundleTo.putSerializable(ClassRunActivity.RUNID, classes);
		bundleTo.putInt("order", ++order_activity);
		intent.putExtras(bundleTo);
		if (order_activity == classes.size()) {
			(new SavePatientData(getActivity())).execute("");
		}
		return intent;
	}
}
