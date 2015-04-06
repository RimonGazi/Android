package com.rimon.rsa.ipaeps.module_3_ibd;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogFragmentForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogListener;
import com.rimon.rsa.ipaeps.radiobutton.AnyRadioButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module3IbdFragment4 extends SherlockFragment implements
		OnCheckedChangeListener, TextWatcher, AnyDialogListener,
		OnClickListener {
	private AnyTextView tv_q_module_3_15;
	private boolean isSingleDiaglog = true;
	private AnyPageChangeListener listener;
	private RadioGroup rg_q_module_3_13, rg_q_module_3_15;
	private int check_id_13 = -1, check_id_15 = -1;
	private View view;
	private AnyButton btn_next, btn_previous;
	private boolean is_rg_15_enable = false;

	private AnyButton btn_q_module_3_14;
	private EditText et_q_module_3_16;
	private AnyDiaglogFragmentForFragment diaglogFragment;
	private Bundle bundle;
	private String et_string = "";
	private CheckBox radio32, radio33, radio34, radio35, radio36, radio37;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Module3Ibd) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		diaglogFragment = new AnyDiaglogFragmentForFragment();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		view = inflater.inflate(R.layout.module_3_ibd_fragment_4, null, false);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_previous = (AnyButton) view.findViewById(R.id.btn_previous);

		rg_q_module_3_13 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_13);

		rg_q_module_3_13.clearCheck();

		rg_q_module_3_13.setOnCheckedChangeListener(this);

		rg_q_module_3_15 = (RadioGroup) view
				.findViewById(R.id.rg_q_module_3_15);

		rg_q_module_3_15.clearCheck();

		rg_q_module_3_15.setOnCheckedChangeListener(this);

		btn_q_module_3_14 = (AnyButton) view

		.findViewById(R.id.btn_q_module_3_14);

		tv_q_module_3_15 = (AnyTextView) view
				.findViewById(R.id.tv_q_module_3_15);

		et_q_module_3_16 = (EditText) view.findViewById(R.id.et_q_module_3_16);
		radio32 = (CheckBox) view.findViewById(R.id.radio32);
		radio33 = (CheckBox) view.findViewById(R.id.radio33);
		radio34 = (CheckBox) view.findViewById(R.id.radio34);
		radio35 = (CheckBox) view.findViewById(R.id.radio35);
		radio36 = (CheckBox) view.findViewById(R.id.radio36);
		radio37 = (CheckBox) view.findViewById(R.id.radio37);
		radio32 = (CheckBox) view.findViewById(R.id.radio32);
		radio33 = (CheckBox) view.findViewById(R.id.radio33);
		radio34 = (CheckBox) view.findViewById(R.id.radio34);
		radio35 = (CheckBox) view.findViewById(R.id.radio35);
		radio36 = (CheckBox) view.findViewById(R.id.radio36);
		radio37 = (CheckBox) view.findViewById(R.id.radio37);

		radio32.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio33.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio34.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio35.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio36.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio37.setTypeface(AppObject.getCurrentFont(getActivity()));
		radio32.setOnClickListener(this);
		radio33.setOnClickListener(this);
		radio34.setOnClickListener(this);
		radio35.setOnClickListener(this);
		radio36.setOnClickListener(this);
		radio37.setOnClickListener(this);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AppConstants.q_module_3_13 = ((RadioButton) view
						.findViewById(check_id_13)).getText().toString();

				if (!btn_q_module_3_14.isEnabled()) {
					AppConstants.q_module_3_14 = AppConstants.DEFULLT_DATA;
				}

				if (is_rg_15_enable) {
					AppConstants.q_module_3_15 = ((AnyRadioButton) view
							.findViewById(check_id_15)).getText().toString();
				} else {
					AppConstants.q_module_3_15 = AppConstants.DEFULLT_DATA;
				}

				getQuestion3_16_value();

				listener.pageChange(AppConstants.MODULE_3_PAGE_5);

				Log.d("AppConstants.q_module_3_13", AppConstants.q_module_3_13);
				Log.d("AppConstants.q_module_3_14", AppConstants.q_module_3_14);
				Log.d("AppConstants.q_module_3_15", AppConstants.q_module_3_15);
				Log.d("AppConstants.q_module_3_16", AppConstants.q_module_3_16);
			}

		});
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_3_PAGE_3);

			}
		});
		et_q_module_3_16.addTextChangedListener(this);
		btn_q_module_3_14 = (AnyButton) view
				.findViewById(R.id.btn_q_module_3_14);
		btn_q_module_3_14.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				showDialog(R.array.zero_to_sisty, R.id.btn_q_module_3_14,
						R.string.q_module_3_14, AppConstants.q_module_3_14);

			}
		});

		return view;
	}

	@Override
	public void onCheckedChanged(RadioGroup viGroup, int check_id) {

		switch (viGroup.getId()) {

		case R.id.rg_q_module_3_13:

			if (rg_q_module_3_13.getCheckedRadioButtonId() == R.id.radio31) {
				btn_q_module_3_14.setEnabled(false);
				btn_q_module_3_14.setText(this.getResources().getString(
						R.string.q_module_3_14));
				setFirstState(btn_q_module_3_14);
				AppConstants.q_module_3_14 = AppConstants.DEFULLT_DATA;
				disable_rg_15();

			} else {
				btn_q_module_3_14.setEnabled(true);
				AppConstants.q_module_3_14 = AppConstants.DEFULLT_DATA;
				setFirstState(btn_q_module_3_14);
				btn_q_module_3_14.setText(this.getResources().getString(
						R.string.q_module_3_14));
				enable_rg_15();

			}
			break;

		case R.id.rg_q_module_3_15:

			break;

		}
		checkNextButtonVisible();
	}

	private void enable_rg_15() {
		is_rg_15_enable = true;
		tv_q_module_3_15.setEnabled(true);
		for (int i = 0; i < rg_q_module_3_15.getChildCount(); i++) {
			((AnyRadioButton) rg_q_module_3_15.getChildAt(i)).setEnabled(true);
		}

	}

	private void disable_rg_15() {
		is_rg_15_enable = false;
		tv_q_module_3_15.setEnabled(false);
		rg_q_module_3_15.clearCheck();
		for (int i = 0; i < rg_q_module_3_15.getChildCount(); i++) {
			((AnyRadioButton) rg_q_module_3_15.getChildAt(i)).setEnabled(false);
		}

	}

	private void checkNextButtonVisible() {

		check_id_13 = rg_q_module_3_13.getCheckedRadioButtonId();

		if ((check_id_13 != -1) && check_btn_14() && check_rg_15()
				&& checkQuestion3_16() && check_et_16()) {
			btn_next.setEnabled(true);
		} else {
			btn_next.setEnabled(false);
		}

	}

	private boolean check_rg_15() {
		if (is_rg_15_enable) {
			check_id_15 = rg_q_module_3_15.getCheckedRadioButtonId();
			if (check_id_15 == -1) {
				return false;
			} else {
				return true;
			}

		} else {

			return true;
		}

	}

	private boolean check_et_16() {

		if (et_q_module_3_16.isEnabled()) {
			if (et_string.equals("")) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}

	}

	private boolean check_btn_14() {
		if (btn_q_module_3_14.isEnabled()) {
			Log.d("EEEEEEEEEEEEEE", "enable");
			if (AppConstants.q_module_3_14.equals(AppConstants.DEFULLT_DATA)) {
				Log.d("EEEEEEEEEEEEEE", "enable+false");
				return false;
			} else {
				Log.d("EEEEEEEEEEEEEE", "enable=true");
				return true;
			}

		} else {

			return true;
		}

	}

	@Override
	public void afterTextChanged(Editable s) {
		et_string = s.toString().trim();
		checkNextButtonVisible();

	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogSingleItemSelected(int view_id, String selected_item) {
		isSingleDiaglog = true;
		if (view_id == R.id.btn_q_module_3_14) {
			btn_q_module_3_14.setText(selected_item);
			AppConstants.q_module_3_14 = selected_item;
			setLastState(btn_q_module_3_14);
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

	private void setLastState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_last_state);
		anyButton.setTextColor(getActivity().getResources().getColorStateList(
				R.color.color_state_2));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_last_state, 0);

	}

	private void setFirstState(AnyButton anyButton) {
		anyButton.setBackgroundResource(R.drawable.btn_left_start_state);
		anyButton.setTextColor(getActivity().getResources().getColorStateList(
				R.color.color_state_1));
		anyButton.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.btn_right_start_state, 0);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.radio32:
		case R.id.radio33:
		case R.id.radio34:
		case R.id.radio35:
		case R.id.radio36:
			checkNextButtonVisible();
			break;
		case R.id.radio37:

			if (radio37.isChecked()) {
				et_q_module_3_16.setEnabled(true);
			} else {
				et_q_module_3_16.setEnabled(false);
				et_q_module_3_16.setText("");
			}
			checkNextButtonVisible();
			break;
		}

	}

	private boolean checkQuestion3_16() {

		if (radio37.isChecked()) {

			if (et_q_module_3_16.getText().toString().equals("")
					|| et_q_module_3_16.getText().toString().equals(null)) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
		// } else {
		//
		// if (radio32.isChecked()) {
		// return true;
		// } else if (radio33.isChecked()) {
		// return true;
		// } else if (radio34.isChecked()) {
		// return true;
		// } else if (radio35.isChecked()) {
		// return true;
		// } else if (radio36.isChecked()) {
		// return true;
		//
		// } else {
		// return false;
		// }
		// }

	}

	private void getQuestion3_16_value() {
		AppConstants.q_module_3_16 = "";

		if (radio32.isChecked())
			AppConstants.q_module_3_16 += radio32.getText().toString() + ", ";
		if (radio33.isChecked())
			AppConstants.q_module_3_16 += radio33.getText().toString() + ", ";
		if (radio34.isChecked())
			AppConstants.q_module_3_16 += radio34.getText().toString() + ", ";
		if (radio35.isChecked())
			AppConstants.q_module_3_16 += radio35.getText().toString() + ", ";
		if (radio36.isChecked())
			AppConstants.q_module_3_16 += radio36.getText().toString() + ", ";

		if (et_q_module_3_16.isEnabled()) {
			AppConstants.q_module_3_16 += ", " + et_string;
		}
		if ((AppConstants.q_module_3_16).equals("")) {
			AppConstants.q_module_3_16 = AppConstants.DEFULLT_DATA;

		} else {
			AppConstants.q_module_3_16 = (AppConstants.q_module_3_16)
					.substring(0, (AppConstants.q_module_3_16).length() - 2);
			AppConstants.q_module_3_16 = AppConstants.q_module_3_16.trim();
		}

	}

	@Override
	public void OnDialogCancel() {
		isSingleDiaglog = true;

	}

}
