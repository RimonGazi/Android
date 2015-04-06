package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

import java.util.Arrays;
import java.util.List;

public class Module7mhs_fragment_7 extends SherlockFragment implements
		OnClickListener, AnyDialogListener {
	private AnyButton btn_next, btn_previous;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private boolean isSingleDiaglog = true;
	private AnyButton q_module_7_17, q_module_7_18, q_module_7_19,
			q_module_7_20, q_module_7_21;
	private String q_value_17 = "", q_value_18 = "", q_value_19 = "",
			q_value_20 = "", q_value_21 = "";
	private List<String> list;
	private boolean c_m_s_q_17, c_m_s_q_18, c_m_s_q_19, c_m_s_q_20, c_m_s_q_21;

	@Override
	public void onAttach(Activity activity) {
		listener = (Module7MentalHealth) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		View view = inflater.inflate(R.layout.module_7_mhs_fragment_7, null,
				false);

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		q_module_7_17 = (AnyButton) view.findViewById(R.id.btn_q_module_7_17);
		q_module_7_18 = (AnyButton) view.findViewById(R.id.btn_q_module_7_18);
		q_module_7_19 = (AnyButton) view.findViewById(R.id.btn_q_module_7_19);
		q_module_7_20 = (AnyButton) view.findViewById(R.id.btn_q_module_7_20);
		q_module_7_21 = (AnyButton) view.findViewById(R.id.btn_q_module_7_21);
		q_module_7_17.setOnClickListener(this);
		q_module_7_18.setOnClickListener(this);
		q_module_7_19.setOnClickListener(this);
		q_module_7_20.setOnClickListener(this);
		q_module_7_21.setOnClickListener(this);
		list = Arrays.asList(getResources().getStringArray(
				R.array.array_result_mhs));

		return view;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:

			getValue();
			Module7CalculateResult calculateResult = new Module7CalculateResult();
			calculateResult.calculateResult();
			listener.pageChange(AppConstants.MODULE_7_PAGE_8);

			break;
		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_7_PAGE_6);
			break;
		case R.id.btn_q_module_7_17:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_17,
					R.string.q_module_11_17, q_value_17);
			break;
		case R.id.btn_q_module_7_18:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_18,
					R.string.q_module_11_18, q_value_18);
			break;
		case R.id.btn_q_module_7_19:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_19,
					R.string.q_module_11_19, q_value_19);
			break;
		case R.id.btn_q_module_7_20:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_20,
					R.string.q_module_11_20, q_value_20);
			break;
		case R.id.btn_q_module_7_21:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_21,
					R.string.q_module_7_21, q_value_21);
			break;
		}

	}

	private void getValue() {
		AppConstants.q_module_7_17 = String.valueOf(1 + list
				.indexOf(q_value_17));
		AppConstants.q_module_7_18 = String.valueOf(1 + list
				.indexOf(q_value_18));
		AppConstants.q_module_7_19 = String.valueOf(1 + list
				.indexOf(q_value_19));
		AppConstants.q_module_7_20 = String.valueOf(1 + list
				.indexOf(q_value_20));
		AppConstants.q_module_7_21 = String.valueOf(1 + list
				.indexOf(q_value_21));

		Log.d("AppConstants.q_module_7_17", AppConstants.q_module_7_17);
		Log.d("AppConstants.q_module_7_18", AppConstants.q_module_7_18);
		Log.d("AppConstants.q_module_7_19", AppConstants.q_module_7_19);
		Log.d("AppConstants.q_module_7_20", AppConstants.q_module_7_20);
		Log.d("AppConstants.q_module_7_21", AppConstants.q_module_7_21);
	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_q_module_7_17:
			q_module_7_17.setText(selected_item);
			q_value_17 = selected_item;
			setLastState(q_module_7_17);
			c_m_s_q_17 = true;
			setMidState();

			break;
		case R.id.btn_q_module_7_18:
			q_module_7_18.setText(selected_item);
			q_value_18 = selected_item;
			setLastState(q_module_7_18);
			c_m_s_q_18 = true;
			setMidState();

			break;
		case R.id.btn_q_module_7_19:
			q_module_7_19.setText(selected_item);
			q_value_19 = selected_item;
			setLastState(q_module_7_19);
			c_m_s_q_19 = true;
			setMidState();

			break;
		case R.id.btn_q_module_7_20:
			q_module_7_20.setText(selected_item);
			q_value_20 = selected_item;
			setLastState(q_module_7_20);
			c_m_s_q_20 = true;
			setMidState();

			break;
		case R.id.btn_q_module_7_21:
			q_module_7_21.setText(selected_item);
			q_value_21 = selected_item;
			setLastState(q_module_7_21);
			c_m_s_q_21 = true;
			setMidState();

			break;

		}
		checkNextButtonVisible();
	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

	private void checkNextButtonVisible() {
		if (!(q_value_17.equals("")) && !(q_value_18.equals(""))
				&& !(q_value_19.equals("")) && !(q_value_20.equals(""))
				&& !(q_value_21.equals(""))) {
			btn_next.setEnabled(true);

		} else {
			btn_next.setEnabled(false);
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
		anyButton.setTextColor(getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

	private void setMidState() {
		if (!c_m_s_q_17) {
			q_module_7_17.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_17.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_18) {
			q_module_7_18.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_18.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_19) {
			q_module_7_19.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_19.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_20) {
			q_module_7_20.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_20.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_21) {
			q_module_7_21.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_21.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		}

	}

}
