package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import java.util.Arrays;
import java.util.List;

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

public class Module7mhs_fragment_6 extends SherlockFragment implements
		OnClickListener, AnyDialogListener {
	private AnyButton btn_next, btn_previous;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private boolean isSingleDiaglog = true;
	private AnyButton q_module_7_12, q_module_7_13, q_module_7_14,
			q_module_7_15, q_module_7_16;
	private String q_value_12 = "", q_value_13 = "", q_value_14 = "",
			q_value_15 = "", q_value_16 = "";
	private List<String> list;
	private boolean c_m_s_q_12, c_m_s_q_13, c_m_s_q_14, c_m_s_q_15, c_m_s_q_16;

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
		View view = inflater.inflate(R.layout.module_7_mhs_fragment_6, null,
				false);

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		q_module_7_12 = (AnyButton) view.findViewById(R.id.btn_q_module_7_12);
		q_module_7_13 = (AnyButton) view.findViewById(R.id.btn_q_module_7_13);
		q_module_7_14 = (AnyButton) view.findViewById(R.id.btn_q_module_7_14);
		q_module_7_15 = (AnyButton) view.findViewById(R.id.btn_q_module_7_15);
		q_module_7_16 = (AnyButton) view.findViewById(R.id.btn_q_module_7_16);
		q_module_7_12.setOnClickListener(this);
		q_module_7_13.setOnClickListener(this);
		q_module_7_14.setOnClickListener(this);
		q_module_7_15.setOnClickListener(this);
		q_module_7_16.setOnClickListener(this);
		list = Arrays.asList(getResources().getStringArray(
				R.array.array_result_mhs));

		return view;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:
			getValue();
			listener.pageChange(AppConstants.MODULE_7_PAGE_7);
			break;
		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_7_PAGE_5);
			break;
		case R.id.btn_q_module_7_12:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_12,
					R.string.q_module_11_12, q_value_12);
			break;
		case R.id.btn_q_module_7_13:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_13,
					R.string.q_module_11_13, q_value_13);
			break;
		case R.id.btn_q_module_7_14:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_14,
					R.string.q_module_11_14, q_value_14);
			break;
		case R.id.btn_q_module_7_15:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_15,
					R.string.q_module_11_15, q_value_15);
			break;
		case R.id.btn_q_module_7_16:
			showDialog(R.array.array_result_mhs, R.id.btn_q_module_7_16,
					R.string.q_module_11_16, q_value_16);
			break;
		}

	}

	private void getValue() {

		AppConstants.q_module_7_12 = String.valueOf(1 + list
				.indexOf(q_value_12));
		AppConstants.q_module_7_13 = String.valueOf(1 + list
				.indexOf(q_value_13));
		AppConstants.q_module_7_14 = String.valueOf(1 + list
				.indexOf(q_value_14));
		AppConstants.q_module_7_15 = String.valueOf(1 + list
				.indexOf(q_value_15));
		AppConstants.q_module_7_16 = String.valueOf(1 + list
				.indexOf(q_value_16));
		Log.d("AppConstants.q_module_7_12", AppConstants.q_module_7_12);
		Log.d("AppConstants.q_module_7_13", AppConstants.q_module_7_13);
		Log.d("AppConstants.q_module_7_14", AppConstants.q_module_7_14);
		Log.d("AppConstants.q_module_7_15", AppConstants.q_module_7_15);
		Log.d("AppConstants.q_module_7_16", AppConstants.q_module_7_16);

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_q_module_7_12:
			q_module_7_12.setText(selected_item);
			q_value_12 = selected_item;
			setLastState(q_module_7_12);
			c_m_s_q_12 = true;
			setMidState();


			break;
		case R.id.btn_q_module_7_13:
			q_module_7_13.setText(selected_item);
			q_value_13 = selected_item;
			setLastState(q_module_7_13);
			c_m_s_q_13 = true;
			setMidState();

			break;
		case R.id.btn_q_module_7_14:
			q_module_7_14.setText(selected_item);
			q_value_14 = selected_item;
			setLastState(q_module_7_14);
			c_m_s_q_14 = true;
			setMidState();


			break;
		case R.id.btn_q_module_7_15:
			q_module_7_15.setText(selected_item);
			q_value_15 = selected_item;
			setLastState(q_module_7_15);
			c_m_s_q_15 = true;
			setMidState();


			break;
		case R.id.btn_q_module_7_16:
			q_module_7_16.setText(selected_item);
			q_value_16 = selected_item;
			setLastState(q_module_7_16);
			c_m_s_q_16 = true;
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
		if (!(q_value_12.equals("")) && !(q_value_13.equals(""))
				&& !(q_value_14.equals("")) && !(q_value_15.equals(""))
				&& !(q_value_16.equals(""))) {
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
		if (!c_m_s_q_12) {
			q_module_7_12
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_12.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_13) {
			q_module_7_13
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_13.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_14) {
			q_module_7_14
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_14.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_15) {
			q_module_7_15.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_15.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_16) {
			q_module_7_16
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			q_module_7_16.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		}

	}

}
