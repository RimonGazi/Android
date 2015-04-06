package com.rimon.rsa.ipaeps.module_9_diet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
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
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

import java.util.ArrayList;

public class Module9DietFragment3 extends SherlockFragment implements
		OnCheckedChangeListener, OnSeekBarChangeListener, AnyDialogListener,
		UpdateFragment {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyButton btn_next, btn_previous, btn_q_module_9_5;
	private RadioGroup rg_q_module_9_6, rg_q_module_9_5;
	private SeekBar skb_q_module_7;
	private int value_9_7 = -1;
	private AnyTextView tv_q_module_9_7, tv_q_module_9_5;
	private View view;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private String btn_value = "";

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module9Diet) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		view = inflater.inflate(R.layout.module_9_diet_fragment_3, null, false);

		rg_q_module_9_5 = (RadioGroup) view.findViewById(R.id.rg_q_module_9_5);
		rg_q_module_9_5.setOnCheckedChangeListener(this);
		btn_q_module_9_5 = (AnyButton) view.findViewById(R.id.btn_q_module_9_5);
		tv_q_module_9_5 = (AnyTextView) view.findViewById(R.id.tv_q_module_9_5);
		btn_q_module_9_5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				showDialog(R.array.lost_weight, R.id.btn_q_module_9_5,
						R.string.how_much_over_the_6, AppConstants.q_module_9_6);

			}
		});

		rg_q_module_9_6 = (RadioGroup) view.findViewById(R.id.rg_q_module_9_6);
		rg_q_module_9_6.setOnCheckedChangeListener(this);

		skb_q_module_7 = (SeekBar) view.findViewById(R.id.skb__q_module_9_7);
		skb_q_module_7.setOnSeekBarChangeListener(this);
		tv_q_module_9_7 = (AnyTextView) view.findViewById(R.id.tv_q_module_9_7);

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getValue();

				Log.d("AppConstants.q_module_9_5", AppConstants.q_module_9_5);
				Log.d("AppConstants.q_module_9_6", AppConstants.q_module_9_6);
				Log.d("AppConstants.q_module_9_7", AppConstants.q_module_9_7);

				startActivity(getIntentToRun());
				getActivity().finish();

			}
		});
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_9_PAGE_2);

			}
		});

		return view;
	}

	@Override
	public void onCheckedChanged(RadioGroup id, int arg1) {
		if (id.getId() == R.id.rg_q_module_9_5) {
			if (rg_q_module_9_5.getCheckedRadioButtonId() == R.id.radio9_5_1) {
				btn_q_module_9_5.setEnabled(true);
			} else {
				btn_q_module_9_5.setEnabled(false);
				btn_q_module_9_5.setText(getActivity().getResources()
						.getString(R.string.how_much_over_the_6));
				btn_value = "";
			}

		}
		checkNextButtonVissible();

	}

	@Override
	public void onProgressChanged(SeekBar id, int progress, boolean fromuser) {
		if (id.getId() == R.id.skb__q_module_9_7) {
			value_9_7 = progress;
			tv_q_module_9_7.setText(String.valueOf(value_9_7));
			checkNextButtonVissible();

		}

	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	private void checkNextButtonVissible() {
		if (rg_q_module_9_6.getCheckedRadioButtonId() != -1 && check_rg_9_6()
				&& (value_9_7 >= 0) && check_btn()) {
			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}

	private boolean check_rg_9_6() {
		if (tv_q_module_9_5.isEnabled()) {
			if (rg_q_module_9_5.getCheckedRadioButtonId() != -1) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}

	}

	private boolean check_btn() {
		if (btn_q_module_9_5.isEnabled()) {

			Log.d("eeeeeeeeeee", "1");
			if (btn_value.equals("")) {
				Log.d("eeeeeeeeeee", "2");
				return false;
			} else {
				Log.d("eeeeeeeeeee", "3");
				return true;
			}

		} else {
			Log.d("eeeeeeeeeee", "4");
			return true;
		}
	}

	private void getValue() {
		if (tv_q_module_9_5.isEnabled()) {

			AppConstants.q_module_9_5 = ((RadioButton) view
					.findViewById(rg_q_module_9_5.getCheckedRadioButtonId()))
					.getText().toString();

			if (btn_q_module_9_5.isEnabled()) {
				AppConstants.q_module_9_5 += btn_value;
			}
		} else {
			AppConstants.q_module_9_5 = AppConstants.DEFULLT_DATA;

		}

		AppConstants.q_module_9_6 = ((RadioButton) view
				.findViewById(rg_q_module_9_6.getCheckedRadioButtonId()))
				.getText().toString();
		AppConstants.q_module_9_7 = String.valueOf(value_9_7);
	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		if (view_id == R.id.btn_q_module_9_5) {
			setLastState(btn_q_module_9_5);
			btn_q_module_9_5.setText(selected_item);
			AppConstants.q_module_9_6 = selected_item;
			btn_value = selected_item;
			checkNextButtonVissible();

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
	public void Update() {
		// if (AppConstants.q_module_9_1.equals(getResources().getString(
		// R.string.no))) {
		// rg_q_module_9_5.clearCheck();
		// for (int i = 0; i < rg_q_module_9_5.getChildCount(); i++) {
		// ((RadioButton) rg_q_module_9_5.getChildAt(i)).setEnabled(false);
		// }
		// tv_q_module_9_5.setEnabled(false);
		// AppConstants.q_module_9_6 = AppConstants.DEFULLT_DATA;
		// // Toast.makeText(getActivity(), "cccccccccc",
		// // Toast.LENGTH_LONG).show();
		//
		// } else {
		// rg_q_module_9_5.clearCheck();
		// for (int i = 0; i < rg_q_module_9_5.getChildCount(); i++) {
		// ((RadioButton) rg_q_module_9_5.getChildAt(i)).setEnabled(true);
		// }
		// tv_q_module_9_5.setEnabled(true);
		// AppConstants.q_module_9_6 = AppConstants.DEFULLT_DATA;
		// // Toast.makeText(getActivity(), "cccccccccc",
		// // Toast.LENGTH_LONG).show();
		//
		// }
		// checkNextButtonVissible();
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

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}
}
