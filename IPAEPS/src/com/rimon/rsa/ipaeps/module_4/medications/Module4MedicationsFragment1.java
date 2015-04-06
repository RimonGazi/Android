package com.rimon.rsa.ipaeps.module_4.medications;

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
import android.widget.TextView.BufferType;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.coustomt_typeface.CustomTypefaceSpan;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module4MedicationsFragment1 extends SherlockFragment implements
		AnyDialogListener, OnClickListener {
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private LinearLayout layout;
	private Animation animation;
	private AnyButton btn_q_module_4_1, btn_q_module_4_2, btn_q_module_4_3,
			btn_dosage_q_module_4_1, btn_dosage_q_module_4_2,
			btn_dosage_q_module_4_3;
	private EditText et_q_module_4_1, et_q_module_4_2, et_q_module_4_3;
	private String drug_1 = "", drug_2 = "", drug_3 = "";
	private String dosage_1 = "", dosage_2 = "", dosage_3 = "";
	private String et_c_dosage_1 = "", et_c_dosage_2 = "", et_c_dosage_3 = "";

	private String index_0, index_1, index_other;

	private AnyButton btn_next;

	private int array_btn_dosage_q_module_4_1 = -1,
			array_btn_dosage_q_module_4_2 = -1,
			array_btn_dosage_q_module_4_3 = -1;

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
		view = inflater.inflate(R.layout.module_4_medication_fragment_1, null,
				false);

		layout = (LinearLayout) view
				.findViewById(R.id.linear_layout_mediaction_4_1);

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
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(this);
		btn_q_module_4_1 = (AnyButton) view.findViewById(R.id.btn_q_module_4_1);
		btn_q_module_4_2 = (AnyButton) view.findViewById(R.id.btn_q_module_4_2);
		btn_q_module_4_3 = (AnyButton) view.findViewById(R.id.btn_q_module_4_3);

		btn_q_module_4_1.setOnClickListener(this);
		btn_q_module_4_2.setOnClickListener(this);
		btn_q_module_4_3.setOnClickListener(this);
		btn_dosage_q_module_4_1 = (AnyButton) view
				.findViewById(R.id.btn_dosage_q_module_4_1);
		btn_dosage_q_module_4_2 = (AnyButton) view
				.findViewById(R.id.btn_dosage_q_module_4_2);
		btn_dosage_q_module_4_3 = (AnyButton) view
				.findViewById(R.id.btn_dosage_q_module_4_3);
		btn_dosage_q_module_4_1.setOnClickListener(this);
		btn_dosage_q_module_4_2.setOnClickListener(this);
		btn_dosage_q_module_4_3.setOnClickListener(this);
		et_q_module_4_1 = (EditText) view.findViewById(R.id.et_q_module_4_1);
		et_q_module_4_2 = (EditText) view.findViewById(R.id.et_q_module_4_2);
		et_q_module_4_3 = (EditText) view.findViewById(R.id.et_q_module_4_3);
		et_q_module_4_1.addTextChangedListener(new TextCahnageWatcher(
				R.id.et_q_module_4_1));
		et_q_module_4_2.addTextChangedListener(new TextCahnageWatcher(
				R.id.et_q_module_4_2));
		et_q_module_4_3.addTextChangedListener(new TextCahnageWatcher(
				R.id.et_q_module_4_3));

	}

	private void getValue() {
		AppConstants.q_module_4_1 = drug_1;

		if (et_q_module_4_1.isEnabled())
			AppConstants.q_module_4_2 = et_c_dosage_1;
		else {
			AppConstants.q_module_4_2 = dosage_1;
		}

		if (drug_2.equals("")) {
			AppConstants.q_module_4_3 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_4_3 = drug_2;
		}

		if (et_q_module_4_2.isEnabled()) {
			if (et_c_dosage_2.equals("")) {
				AppConstants.q_module_4_4 = AppConstants.DEFULLT_DATA;

			} else {
				AppConstants.q_module_4_4 = et_c_dosage_2;
			}

		} else {
			if (dosage_2.equals("")) {
				AppConstants.q_module_4_4 = AppConstants.DEFULLT_DATA;

			} else {
				AppConstants.q_module_4_4 = dosage_2;
			}
		}
		if (drug_3.equals("")) {
			AppConstants.q_module_4_5 = AppConstants.DEFULLT_DATA;
		} else {
			AppConstants.q_module_4_5 = drug_3;
		}

		if (et_q_module_4_3.isEnabled()) {
			if (et_c_dosage_3.equals("")) {
				AppConstants.q_module_4_6 = AppConstants.DEFULLT_DATA;

			} else {
				AppConstants.q_module_4_6 = et_c_dosage_3;
			}

		} else {
			if (dosage_2.equals("")) {
				AppConstants.q_module_4_6 = AppConstants.DEFULLT_DATA;

			} else {
				AppConstants.q_module_4_6 = dosage_3;
			}
		}

		Log.d("AppConstants.q_module_4_1", AppConstants.q_module_4_1);
		Log.d("AppConstants.q_module_4_2", AppConstants.q_module_4_2);
		Log.d("AppConstants.q_module_4_3", AppConstants.q_module_4_3);
		Log.d("AppConstants.q_module_4_4", AppConstants.q_module_4_4);
		Log.d("AppConstants.q_module_4_5", AppConstants.q_module_4_5);
		Log.d("AppConstants.q_module_4_6", AppConstants.q_module_4_6);

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		check_et_nextButton = false;
		switch (view_id) {
		case R.id.btn_q_module_4_1:
			setLastState(btn_q_module_4_1);
			btn_q_module_4_1.setText(selected_item);
			drug_1 = selected_item;
			et_q_module_4_1.setText("");
			et_c_dosage_1 = "";
			dosage_1 = "";
			if (selected_item.equals(index_other)) {

				Log.d("other....", "other....");
				if (btn_dosage_q_module_4_1.isEnabled()) {
					btn_dosage_q_module_4_1.setEnabled(false);
				}
				if (!et_q_module_4_1.isEnabled()) {
					et_q_module_4_1.setEnabled(true);
					et_q_module_4_1.requestFocus();
				}
			} else if (selected_item.equals(index_0)
					|| selected_item.equals(index_1)) {
				Log.d("other12", " 12");

				if (btn_dosage_q_module_4_1.isEnabled()) {
					btn_dosage_q_module_4_1.setEnabled(false);
				}
				if (et_q_module_4_1.isEnabled()) {
					et_q_module_4_1.setEnabled(false);
				}
				dosage_1 = AppConstants.DEFULLT_DATA;

			} else {

				btn_dosage_q_module_4_1.setEnabled(true);
				if (!et_q_module_4_1.isEnabled()) {
					et_q_module_4_1.setEnabled(false);

				}
				setArrayList(R.id.btn_dosage_q_module_4_1, selected_item);
			}
			break;

		case R.id.btn_q_module_4_2:
			setLastState(btn_q_module_4_2);
			btn_q_module_4_2.setText(selected_item);
			drug_2 = selected_item;
			et_q_module_4_2.setText("");
			et_c_dosage_2 = "";
			dosage_2 = "";
			if (selected_item.equals(index_other)) {
				if (btn_dosage_q_module_4_2.isEnabled()) {
					btn_dosage_q_module_4_2.setEnabled(false);
				}
				if (!et_q_module_4_2.isEnabled()) {
					et_q_module_4_2.setEnabled(true);
					et_q_module_4_2.requestFocus();
				}
			} else if (selected_item.equals(index_0)
					|| selected_item.equals(index_1)) {

				if (btn_dosage_q_module_4_2.isEnabled()) {
					btn_dosage_q_module_4_2.setEnabled(false);
				}
				if (et_q_module_4_2.isEnabled()) {
					et_q_module_4_2.setEnabled(false);
				}
				dosage_2 = AppConstants.DEFULLT_DATA;

			} else {
				btn_dosage_q_module_4_2.setEnabled(true);
				if (et_q_module_4_2.isEnabled()) {
					et_q_module_4_2.setEnabled(false);

				}
				setArrayList(R.id.btn_dosage_q_module_4_2, selected_item);
			}
			break;

		case R.id.btn_q_module_4_3:
			setLastState(btn_q_module_4_3);
			btn_q_module_4_3.setText(selected_item);
			drug_3 = selected_item;
			et_q_module_4_3.setText("");
			et_c_dosage_3 = "";
			dosage_3 = "";
			if (selected_item.equals(index_other)) {
				if (btn_dosage_q_module_4_3.isEnabled()) {
					btn_dosage_q_module_4_3.setEnabled(false);
				}
				if (!et_q_module_4_3.isEnabled()) {
					et_q_module_4_3.setEnabled(true);
					et_q_module_4_3.requestFocus();
				}
			} else if (selected_item.equals(index_0)
					|| selected_item.equals(index_1)) {

				if (btn_dosage_q_module_4_3.isEnabled()) {
					btn_dosage_q_module_4_3.setEnabled(false);
				}
				if (et_q_module_4_3.isEnabled()) {
					et_q_module_4_3.setEnabled(false);
				}
				dosage_3 = AppConstants.DEFULLT_DATA;

			} else {
				btn_dosage_q_module_4_3.setEnabled(true);
				if (et_q_module_4_3.isEnabled()) {
					et_q_module_4_3.setEnabled(false);

				}
				setArrayList(R.id.btn_dosage_q_module_4_3, selected_item);
			}
			break;
		case R.id.btn_dosage_q_module_4_1:
			setLastStateDossage(btn_dosage_q_module_4_1);

			et_q_module_4_1.setText(setTextColor(selected_item),
					BufferType.SPANNABLE);
			dosage_1 = selected_item;
			break;

		case R.id.btn_dosage_q_module_4_2:
			setLastStateDossage(btn_dosage_q_module_4_2);

			et_q_module_4_2.setText(setTextColor(selected_item),
					BufferType.SPANNABLE);
			dosage_2 = selected_item;
			break;

		case R.id.btn_dosage_q_module_4_3:
			setLastStateDossage(btn_dosage_q_module_4_3);
			et_q_module_4_3.setText(setTextColor(selected_item),
					BufferType.SPANNABLE);

			dosage_3 = selected_item;
			break;
		}
		check_et_nextButton = true;
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
		case R.id.btn_q_module_4_1:
			showDialog(R.array.drug_array, R.id.btn_q_module_4_1,
					R.string.ibd_drug, drug_1);

			break;
		case R.id.btn_q_module_4_2:
			showDialog(R.array.drug_array, R.id.btn_q_module_4_2,
					R.string.ibd_drug, drug_2);

			break;
		case R.id.btn_q_module_4_3:
			showDialog(R.array.drug_array, R.id.btn_q_module_4_3,
					R.string.ibd_drug, drug_3);

			break;

		case R.id.btn_dosage_q_module_4_1:
			showDialog(array_btn_dosage_q_module_4_1,
					R.id.btn_dosage_q_module_4_1,
					R.string.drug_dosage_and_method_of_entry, dosage_1);

			break;
		case R.id.btn_dosage_q_module_4_2:
			showDialog(array_btn_dosage_q_module_4_2,
					R.id.btn_dosage_q_module_4_2,
					R.string.drug_dosage_and_method_of_entry, dosage_2);

			break;
		case R.id.btn_dosage_q_module_4_3:
			showDialog(array_btn_dosage_q_module_4_3,
					R.id.btn_dosage_q_module_4_3,
					R.string.drug_dosage_and_method_of_entry, dosage_3);

			break;
		case R.id.btn_next:
			getValue();
			listener.pageChange(AppConstants.MODULE_4_PAGE_2);
		}

	}

	private void checkNextButtonVisible() {
		Log.d("checkn", "call");
		if (checkDrug_1() & checkEt_1()) {
			Log.d("checkn", "true");
			btn_next.setEnabled(true);
		}

		else if (checkDrug_2() & checkEt_2()) {
			Log.d("checkn2", "true");
			btn_next.setEnabled(true);
		} else if (checkDrug_3() & checkEt_3()) {
			Log.d("checkn3", "true");
			btn_next.setEnabled(true);
		} else {
			Log.d("checkn", "false");
			btn_next.setEnabled(false);
		}

	}

	private boolean checkEt_2() {
		if (et_q_module_4_2.isEnabled()) {
			if (et_c_dosage_2.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}

	}

	private boolean checkDrug_2() {
		if (btn_dosage_q_module_4_2.isEnabled()) {
			Log.d("odss 2", "enable");
			if (!drug_2.equals("") && !dosage_2.equals("")) {
				Log.d("odss 2", "true 2");
				return true;
			} else {
				Log.d("odss 2", "false");
				return false;
			}
		} else if (!drug_2.equals("")) {
			Log.d("odss 2", "true 2");
			return true;
		} else {
			return false;
		}
	}

	private boolean checkEt_3() {
		if (et_q_module_4_3.isEnabled()) {
			if (et_c_dosage_3.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}

	}

	private boolean checkDrug_3() {
		if (btn_dosage_q_module_4_3.isEnabled()) {
			Log.d("odss 3", "enable");
			if (!drug_3.equals("") && !dosage_3.equals("")) {
				Log.d("odss 3", "true 3");
				return true;
			} else {
				Log.d("odss 3", "false");
				return false;
			}
		} else if (!drug_3.equals("")) {
			Log.d("odss 3", "true 2");
			return true;
		} else {
			return false;
		}
	}

	private boolean checkEt_1() {
		if (et_q_module_4_1.isEnabled()) {
			if (et_c_dosage_1.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}

	}

	private boolean checkDrug_1() {
		if (btn_dosage_q_module_4_1.isEnabled()) {
			Log.d("odss 1", "enable");
			if (!drug_1.equals("") && !dosage_1.equals("")) {
				Log.d("odss 1", "true 1");
				return true;
			} else {
				Log.d("odss 1", "false");
				return false;
			}
		} else if (!drug_1.equals("")) {
			Log.d("odss 1", "true 2");
			return true;
		} else {
			return false;
		}
	}

	// private boolean checkDrug_2() {
	// if (btn_dosage_q_module_4_2.isEnabled()) {
	//
	// if (!drug_2.equals("") && !dosage_2.equals("")) {
	// return true;
	// } else {
	// return false;
	// }
	// } else {
	// return true;
	// }
	// }
	//
	// private boolean checkDrug_3() {
	// if (btn_dosage_q_module_4_3.isEnabled()) {
	// if (!drug_3.equals("") && !dosage_3.equals("")) {
	// return true;
	// } else {
	// return false;
	// }
	// } else {
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
				case R.id.et_q_module_4_1:
					et_c_dosage_1 = s.toString().trim();

					break;
				case R.id.et_q_module_4_2:
					et_c_dosage_2 = s.toString();

					break;
				case R.id.et_q_module_4_3:
					et_c_dosage_3 = s.toString();

					break;

				}

				checkNextButtonVisible();
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
		case R.id.btn_dosage_q_module_4_1:
			array_btn_dosage_q_module_4_1 = temp_index;
			break;
		case R.id.btn_dosage_q_module_4_2:
			array_btn_dosage_q_module_4_2 = temp_index;
			break;
		case R.id.btn_dosage_q_module_4_3:
			array_btn_dosage_q_module_4_3 = temp_index;
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

}