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

public class Module7mhs_fragment_5 extends SherlockFragment implements
		OnClickListener, AnyDialogListener {
	private boolean isSingleDiaglog = true;
	private AnyButton btn_q_module_7_9, btn_q_module_7_10, btn_q_module_7_11;
	private AnyButton btn_next, btn_previous;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private String btn_value_9 = "", btn_value_10 = "", btn_value_11 = "";
	private boolean c_m_s_q_9, c_m_s_q_10, c_m_s_q_11;

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
		View view = inflater.inflate(R.layout.module_7_mhs_fragment_5, null,
				false);

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		btn_q_module_7_9 = (AnyButton) view.findViewById(R.id.btn_q_module_7_9);
		btn_q_module_7_10 = (AnyButton) view
				.findViewById(R.id.btn_q_module_7_10);
		btn_q_module_7_11 = (AnyButton) view
				.findViewById(R.id.btn_q_module_7_11);
		btn_q_module_7_9.setOnClickListener(this);
		btn_q_module_7_10.setOnClickListener(this);
		btn_q_module_7_11.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:
			listener.pageChange(AppConstants.MODULE_7_PAGE_6);
			getValue();
			break;
		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_7_PAGE_4);
			break;
		case R.id.btn_q_module_7_9:

			showDialog(R.array.yes_no, R.id.btn_q_module_7_9,
					R.string.q_module_7_9, btn_value_9);
			break;
		case R.id.btn_q_module_7_10:

			showDialog(R.array.yes_no, R.id.btn_q_module_7_10,
					R.string.q_module_7_10, btn_value_10);
			break;
		case R.id.btn_q_module_7_11:

			showDialog(R.array.yes_no, R.id.btn_q_module_7_11,
					R.string.q_module_7_11, btn_value_11);
			break;
		}

	}

	private void getValue() {

		AppConstants.q_module_7_9 = btn_value_9;
		AppConstants.q_module_7_10 = btn_value_10;
		AppConstants.q_module_7_11 = btn_value_11;
		Log.d("AppConstants.q_module_7_9", AppConstants.q_module_7_9);
		Log.d("AppConstants.q_module_7_10", AppConstants.q_module_7_10);
		Log.d("AppConstants.q_module_7_11", AppConstants.q_module_7_11);

	}

	private void checkNextButtonVigible() {
		if ((!btn_value_9.equals("")) && (!btn_value_10.equals(""))
				&& (!btn_value_11.equals(""))) {
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

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_q_module_7_9:
			btn_q_module_7_9.setText(selected_item);
			btn_value_9 = selected_item;
			setLastState(btn_q_module_7_9);
			c_m_s_q_9 = true;
			setMidState();
			break;

		case R.id.btn_q_module_7_10:
			btn_q_module_7_10.setText(selected_item);
			btn_value_10 = selected_item;
			setLastState(btn_q_module_7_10);
			c_m_s_q_10 = true;
			setMidState();
			break;
		case R.id.btn_q_module_7_11:
			btn_q_module_7_11.setText(selected_item);
			btn_value_11 = selected_item;
			setLastState(btn_q_module_7_11);
			c_m_s_q_11 = true;
			setMidState();
			break;

		}
		checkNextButtonVigible();

	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;
	}

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

	private void setMidState() {
		if (!c_m_s_q_9) {
			btn_q_module_7_9
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_7_9.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_10) {
			btn_q_module_7_10
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_7_10.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		} else if (!c_m_s_q_11) {
			btn_q_module_7_11
					.setBackgroundResource(R.drawable.btn_left_mid_state);
			btn_q_module_7_11.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.btn_right_mid_state, 0);

		}

	}

}
