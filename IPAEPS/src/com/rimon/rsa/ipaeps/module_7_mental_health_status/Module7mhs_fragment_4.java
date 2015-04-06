package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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

public class Module7mhs_fragment_4 extends SherlockFragment implements
		OnClickListener, AnyDialogListener, OnSeekBarChangeListener {
	private boolean isSingleDiaglog = true;
	private AnyButton btn_next, btn_previous, btn_q_module_7_7;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private View view;
	private String btn_value = "";
	private int skb_score_8 = -1;
	private SeekBar skb__q_module_7_8;
	private AnyTextView tv_q_module_7_8;

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
		view = inflater.inflate(R.layout.module_7_mhs_fragment_4, null, false);

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		btn_q_module_7_7 = (AnyButton) view.findViewById(R.id.btn_q_module_7_7);
		btn_q_module_7_7.setOnClickListener(this);
		skb__q_module_7_8 = (SeekBar) view.findViewById(R.id.skb__q_module_7_8);
		skb__q_module_7_8.setOnSeekBarChangeListener(this);
		tv_q_module_7_8 = (AnyTextView) view.findViewById(R.id.tv_q_module_7_8);

		return view;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_next:
			getValue();
			listener.pageChange(AppConstants.MODULE_7_PAGE_5);

			break;
		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_7_PAGE_3);
			break;
		case R.id.btn_q_module_7_7:

			showDialog(R.array.array_sleep, R.id.btn_q_module_7_7,
					R.string.q_module_7_7, btn_value);

			break;

		}
	}

	private void getValue() {
		AppConstants.q_module_7_7 = btn_value;
		AppConstants.q_module_7_8 = String.valueOf(skb_score_8);
		Log.d("AppConstants.q_module_7_7", AppConstants.q_module_7_7);
		Log.d("AppConstants.q_module_7_8", AppConstants.q_module_7_8);

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
		if (view_id == R.id.btn_q_module_7_7) {
			btn_value = selected_item;
			btn_q_module_7_7.setText(selected_item);
			setLastState(btn_q_module_7_7);
		}
		checkNextButtonVigible();

	}

	private void checkNextButtonVigible() {

		if ((!btn_value.equals("")) && (skb_score_8 >= 0)) {
			btn_next.setEnabled(true);

		} else {
			btn_next.setEnabled(false);

		}

	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

	@Override
	public void onProgressChanged(SeekBar view, int process, boolean arg2) {
		if (view.getId() == R.id.skb__q_module_7_8) {
			tv_q_module_7_8.setText(String.valueOf(process));
			skb_score_8 = process;
		}
		checkNextButtonVigible();
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
	}

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

}
