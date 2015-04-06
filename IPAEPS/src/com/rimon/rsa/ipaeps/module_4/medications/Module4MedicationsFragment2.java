package com.rimon.rsa.ipaeps.module_4.medications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.TextView.BufferType;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appdatabase.SavePatientData;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.classtorun.ClassRunActivity;
import com.rimon.rsa.ipaeps.coustomt_typeface.CustomTypefaceSpan;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module4MedicationsFragment2 extends SherlockFragment implements
		AnyDialogListener, OnClickListener {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;

	private AnyButton btn_q_module_4_4, btn_q_module_4_6,
			btn_dosage_q_module_4_4;
	private EditText et_q_module_4_4, et_q_module_4_5;
	private String drug_4 = "";
	private String dosage_4 = "";
	private String et_c_dosage_4 = "", et_c_5 = "";
	private String index_0, index_1, index_other;
	private AnyButton btn_next, btn_previous;

	private int array_btn_dosage_q_module_4_4 = -1;

	private View view;
	private SpannableStringBuilder spannableString;
	private CustomTypefaceSpan customTypefaceSpan;
	private boolean check_et_nextButton;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module4Medications) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		index_0 = getActivity().getString(R.string.m_4_index0);
		index_1 = getActivity().getString(R.string.m_4_index1);
		index_other = getActivity().getString(R.string.m_4_ohter);
		customTypefaceSpan = new CustomTypefaceSpan(getActivity());
		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		view = inflater.inflate(R.layout.module_4_medication_fragment_2, null,
				false);
		enableView();

		return view;

	}

	private void enableView() {
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(this);
		btn_next.setEnabled(true);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);
		btn_previous.setOnClickListener(this);
		btn_q_module_4_4 = (AnyButton) view.findViewById(R.id.btn_q_module_4_4);

		btn_q_module_4_4.setOnClickListener(this);

		btn_dosage_q_module_4_4 = (AnyButton) view
				.findViewById(R.id.btn_dosage_q_module_4_4);

		btn_dosage_q_module_4_4.setOnClickListener(this);

		et_q_module_4_4 = (EditText) view.findViewById(R.id.et_q_module_4_4);

		et_q_module_4_4.addTextChangedListener(new TextCahnageWatcher(
				R.id.et_q_module_4_4));
		et_q_module_4_5 = (EditText) view.findViewById(R.id.et_q_module_4_5);
		et_q_module_4_5.addTextChangedListener(new TextCahnageWatcher(
				R.id.et_q_module_4_5));
		btn_q_module_4_6 = (AnyButton) view.findViewById(R.id.btn_q_module_4_6);
		btn_q_module_4_6.setOnClickListener(this);

	}

	private void getValue() {
		if (drug_4.equals("")) {
			AppConstants.q_module_4_7 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_4_7 = drug_4;
		}
		if (et_q_module_4_4.isEnabled())
			if (et_c_dosage_4.equals("")) {
				AppConstants.q_module_4_8 = AppConstants.DEFULLT_DATA;
			} else {
				AppConstants.q_module_4_8 = et_c_dosage_4;
			}
		else {
			if (dosage_4.equals("")) {
				AppConstants.q_module_4_8 = AppConstants.DEFULLT_DATA;
			} else {
				AppConstants.q_module_4_8 = dosage_4;
			}
		}
		if (et_c_5.equals("")) {
			AppConstants.q_module_4_9 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_4_9 = et_c_5;
		}

		Log.d("AppConstants.q_module_4_1", AppConstants.q_module_4_1);
		Log.d("AppConstants.q_module_4_2", AppConstants.q_module_4_2);
		Log.d("AppConstants.q_module_4_3", AppConstants.q_module_4_3);
		Log.d("AppConstants.q_module_4_4", AppConstants.q_module_4_4);
		Log.d("AppConstants.q_module_4_5", AppConstants.q_module_4_5);
		Log.d("AppConstants.q_module_4_6", AppConstants.q_module_4_6);

		Log.d("AppConstants.q_module_4_7", AppConstants.q_module_4_7);
		Log.d("AppConstants.q_module_4_8", AppConstants.q_module_4_8);

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		check_et_nextButton = false;
		isSingleDiaglog = true;
		switch (view_id) {
		case R.id.btn_q_module_4_4:
			setLastState(btn_q_module_4_4);
			btn_q_module_4_4.setText(selected_item);
			drug_4 = selected_item;
			et_q_module_4_4.setText("");
			et_c_dosage_4 = "";
			dosage_4 = "";
			if (selected_item.equals(index_other)) {
				if (btn_dosage_q_module_4_4.isEnabled()) {
					btn_dosage_q_module_4_4.setEnabled(false);
				}
				if (!et_q_module_4_4.isEnabled()) {
					et_q_module_4_4.setEnabled(true);
					et_q_module_4_4.requestFocus();
				}
			} else if (selected_item.equals(index_0)
					|| selected_item.equals(index_1)) {

				if (btn_dosage_q_module_4_4.isEnabled()) {
					btn_dosage_q_module_4_4.setEnabled(false);
				}
				if (et_q_module_4_4.isEnabled()) {
					et_q_module_4_4.setEnabled(false);
				}
				dosage_4 = AppConstants.DEFULLT_DATA;

			} else {
				btn_dosage_q_module_4_4.setEnabled(true);
				if (et_q_module_4_4.isEnabled()) {
					et_q_module_4_4.setEnabled(false);

				}
				setArrayList(R.id.btn_dosage_q_module_4_4, selected_item);
			}
			break;

		case R.id.btn_dosage_q_module_4_4:
			setLastStateDossage(btn_dosage_q_module_4_4);

			et_q_module_4_4.setText(setTextColor(selected_item),
					BufferType.SPANNABLE);
			dosage_4 = selected_item;
			break;

		}
		check_et_nextButton = true;
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

		case R.id.btn_q_module_4_4:
			showDialog(R.array.drug_array, R.id.btn_q_module_4_4,
					R.string.ibd_drug, drug_4);

			break;

		case R.id.btn_dosage_q_module_4_4:
			showDialog(array_btn_dosage_q_module_4_4,
					R.id.btn_dosage_q_module_4_4,
					R.string.drug_dosage_and_method_of_entry, dosage_4);

			break;

		case R.id.btn_next:
			getValue();
			startActivity(getIntentToRun());
			getActivity().finish();
			break;

		case R.id.btn_previous:
			listener.pageChange(AppConstants.MODULE_4_PAGE_1);
			break;
		case R.id.btn_q_module_4_6:
			et_q_module_4_5.requestFocus();
			break;
		}

	}

	// private void checkNextButtonVisible() {
	// Log.d("checkn", "call");
	// if (checkDrug() && checkDosage() & checkEt() && check_et_5()) {
	//
	// btn_next.setEnabled(true);
	// } else {
	//
	// btn_next.setEnabled(false);
	// }
	//
	// }

	// private boolean check_et_5() {
	// if (et_c_5.equals(""))
	// return false;
	// else {
	// return true;
	// }
	// }
	//
	// private boolean checkDrug() {
	// if (drug_4.equals("")) {
	// return false;
	// } else {
	//
	// return true;
	// }
	//
	// }
	//
	// private boolean checkDosage() {
	// if (btn_dosage_q_module_4_4.isEnabled()) {
	// if (dosage_4.equals(""))
	// return false;
	// else
	// return true;
	//
	// } else {
	//
	// return true;
	// }
	// }
	//
	// private boolean checkEt() {
	// if (et_q_module_4_4.isEnabled()) {
	// if (et_c_dosage_4.equals(""))
	// return false;
	// else
	// return true;
	// } else {
	// Log.d("checket", "false");
	// return true;
	// }
	// }

	class TextCahnageWatcher implements TextWatcher {
		private int id;

		TextCahnageWatcher(int id) {
			this.id = id;
		}

		@Override
		public void afterTextChanged(Editable s) {
			if (check_et_nextButton) {
				switch (id) {
				case R.id.et_q_module_4_4:
					et_c_dosage_4 = s.toString().trim();

					break;

				}
				switch (id) {
				case R.id.et_q_module_4_5:
					et_c_5 = s.toString().trim();
					break;

				}

				// checkNextButtonVisible();
			}
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub

		}

	}

	private void setArrayList(int id, String valueString) {
		List<String> drug_arrray = Arrays.asList(getActivity().getResources()
				.getStringArray(R.array.drug_array));
		int index = drug_arrray.indexOf(valueString);
		int temp_index = 0 - 1;
		switch (index) {
		case 2:
			temp_index = R.array.index_2;
			break;

		case 3:
			temp_index = R.array.index_3;
			break;

		case 4:
			temp_index = R.array.index_4;
			break;

		case 5:
			temp_index = R.array.index_5;
			break;
		case 6:
			temp_index = R.array.index_6;
			break;

		case 7:
			temp_index = R.array.index_7;
			break;
		case 8:
			temp_index = R.array.index_8;
			break;

		case 9:
			temp_index = R.array.index_9;
			break;
		case 10:
			temp_index = R.array.index_10;
			break;

		case 11:
			temp_index = R.array.index_11;
			break;
		case 12:
			temp_index = R.array.index_12;
			break;

		case 13:
			temp_index = R.array.index_13;
			break;
		case 14:
			temp_index = R.array.index_14;
			break;
		case 15:
			temp_index = R.array.index_15;
			break;

		case 16:
			temp_index = R.array.index_16;
			break;

		}
		switch (id) {
		case R.id.btn_dosage_q_module_4_4:
			array_btn_dosage_q_module_4_4 = temp_index;

			break;

		}

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

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getActivity().getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

	private void setLastStateDossage(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_bacground_reverse);
		anyButton.setTextColor(getActivity().getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(
				R.drawable.btn_drug_backgrount_left_last_stage, 0, 0, 0);

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