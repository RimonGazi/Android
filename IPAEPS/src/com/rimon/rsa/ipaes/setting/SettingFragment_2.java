package com.rimon.rsa.ipaes.setting;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpSettingModuleDBOpenHelper;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

public class SettingFragment_2 extends SherlockFragment implements
		OnCheckedChangeListener, UpdateFragment {
	private View view;
	private AnyButton btn_reset, btn_save, btn_clean_cb;
	private PpSettingModuleDBOpenHelper ppSettingModuleDBOpenHelper;
	private ModuleSettingData moduleSetting;
	private CheckBox cb_settin_default;
	private CheckBox cb_1, cb_2, cb_3, cb_4, cb_5, cb_6, cb_7, cb_8, cb_9,
			cb_10, cb_11, cb_12, cb_13, cb_14, cb_15;
	private AnyTextView tv_order_1, tv_order_2, tv_order_3, tv_order_4,
			tv_order_5, tv_order_6, tv_order_7, tv_order_8, tv_order_9,
			tv_order_10, tv_order_11, tv_order_12, tv_order_13, tv_order_14,
			tv_order_15, tv_setting_custom;
	private int main_order = 1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.setting_fragment_2, null, false);
		ppSettingModuleDBOpenHelper = DatabaseCreator
				.getPpSettingModuleDBOpenHelper(getActivity());
		intializedView();
		checkView();

		btn_save = (AnyButton) view.findViewById(R.id.btn_save);
		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				saveData();
			}
		});

		btn_reset = (AnyButton) view.findViewById(R.id.btn_reset);
		btn_reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				checkView();

			}
		});

		btn_clean_cb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				removeListenerCustomRunCheckBox();
				main_order = 1;
				cb_1.setChecked(false);
				cb_2.setChecked(false);
				cb_3.setChecked(false);
				cb_4.setChecked(false);
				cb_5.setChecked(false);

				cb_6.setChecked(false);
				cb_7.setChecked(false);
				cb_8.setChecked(false);
				cb_9.setChecked(false);
				cb_10.setChecked(false);

				cb_11.setChecked(false);
				cb_12.setChecked(false);
				cb_13.setChecked(false);
				cb_14.setChecked(false);
				cb_15.setChecked(false);
				tv_order_1.setText("");
				tv_order_1.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));

				tv_order_2.setText("");
				tv_order_2.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_3.setText("");
				tv_order_3.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_4.setText("");
				tv_order_4.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_5.setText("");
				tv_order_5.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_6.setText("");
				tv_order_6.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_7.setText("");
				tv_order_7.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_8.setText("");
				tv_order_8.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_9.setText("");
				tv_order_9.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_10.setText("");
				tv_order_10.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));

				tv_order_11.setText("");
				tv_order_11.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_12.setText("");
				tv_order_12.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_13.setText("");
				tv_order_13.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_14.setText("");
				tv_order_14.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));
				tv_order_15.setText("");
				tv_order_15.setBackgroundColor(getActivity().getResources()
						.getColor(R.color.gray_1));

				addListenerCustomRunCheckBox();

			}
		});
		return view;

	}

	private void checkView() {
		main_order = 1;
		cb_settin_default.setChecked(false);
		disableViewCustomCheckBox();
		removeListenerCustomRunCheckBox();
		moduleSetting = ppSettingModuleDBOpenHelper.getModuleSettingData();
		if (moduleSetting.getRun_state() == SettingConstants.DEFAULT_MODULE) {
			cb_settin_default.setOnCheckedChangeListener(null);
			cb_settin_default.setChecked(true);

		} else if (moduleSetting.getRun_state() == SettingConstants.COUSTOM_MODULE) {
			cb_settin_default.setChecked(false);
			enableViewCustomCheckBox();

			if (moduleSetting.getModule_order_1() >= 1) {
				setCheckBoxAndTextViewCustom(cb_1, tv_order_1,
						moduleSetting.getModule_order_1(), true);
				if (moduleSetting.getModule_order_1() >= main_order) {
					main_order = moduleSetting.getModule_order_1() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_1, tv_order_1, 0, false);
			}

			if (moduleSetting.getModule_order_2() >= 1) {
				setCheckBoxAndTextViewCustom(cb_2, tv_order_2,
						moduleSetting.getModule_order_2(), true);
				if (moduleSetting.getModule_order_2() >= main_order) {
					main_order = moduleSetting.getModule_order_2() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_2, tv_order_2, 0, false);
			}
			if (moduleSetting.getModule_order_3() >= 1) {
				setCheckBoxAndTextViewCustom(cb_3, tv_order_3,
						moduleSetting.getModule_order_3(), true);
				if (moduleSetting.getModule_order_3() >= main_order) {
					main_order = moduleSetting.getModule_order_3() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_3, tv_order_3, 0, false);
			}
			if (moduleSetting.getModule_order_4() >= 1) {
				setCheckBoxAndTextViewCustom(cb_4, tv_order_4,
						moduleSetting.getModule_order_4(), true);
				if (moduleSetting.getModule_order_4() >= main_order) {
					main_order = moduleSetting.getModule_order_4() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_4, tv_order_4, 0, false);
			}
			if (moduleSetting.getModule_order_5() >= 1) {
				setCheckBoxAndTextViewCustom(cb_5, tv_order_5,
						moduleSetting.getModule_order_5(), true);
				if (moduleSetting.getModule_order_5() >= main_order) {
					main_order = moduleSetting.getModule_order_5() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_5, tv_order_5, 0, false);
			}
			if (moduleSetting.getModule_order_6() >= 1) {
				setCheckBoxAndTextViewCustom(cb_6, tv_order_6,
						moduleSetting.getModule_order_6(), true);
				if (moduleSetting.getModule_order_6() >= main_order) {
					main_order = moduleSetting.getModule_order_6() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_6, tv_order_6, 0, false);
			}
			if (moduleSetting.getModule_order_7() >= 1) {
				setCheckBoxAndTextViewCustom(cb_7, tv_order_7,
						moduleSetting.getModule_order_7(), true);
				if (moduleSetting.getModule_order_7() >= main_order) {
					main_order = moduleSetting.getModule_order_7() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_7, tv_order_7, 0, false);
			}
			if (moduleSetting.getModule_order_8() >= 1) {
				setCheckBoxAndTextViewCustom(cb_8, tv_order_8,
						moduleSetting.getModule_order_8(), true);
				if (moduleSetting.getModule_order_8() >= main_order) {
					main_order = moduleSetting.getModule_order_8() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_8, tv_order_8, 0, false);
			}
			if (moduleSetting.getModule_order_9() >= 1) {
				setCheckBoxAndTextViewCustom(cb_9, tv_order_9,
						moduleSetting.getModule_order_9(), true);
				if (moduleSetting.getModule_order_9() >= main_order) {
					main_order = moduleSetting.getModule_order_9() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_9, tv_order_9, 0, false);
			}
			if (moduleSetting.getModule_order_10() >= 1) {
				setCheckBoxAndTextViewCustom(cb_10, tv_order_10,
						moduleSetting.getModule_order_10(), true);
				if (moduleSetting.getModule_order_10() >= main_order) {
					main_order = moduleSetting.getModule_order_10() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_10, tv_order_10, 0, false);
			}
			if (moduleSetting.getModule_order_11() >= 1) {
				setCheckBoxAndTextViewCustom(cb_11, tv_order_11,
						moduleSetting.getModule_order_11(), true);
				if (moduleSetting.getModule_order_11() >= main_order) {
					main_order = moduleSetting.getModule_order_11() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_11, tv_order_11, 0, false);
			}
			if (moduleSetting.getModule_order_12() >= 1) {
				setCheckBoxAndTextViewCustom(cb_12, tv_order_12,
						moduleSetting.getModule_order_12(), true);
				if (moduleSetting.getModule_order_12() >= main_order) {
					main_order = moduleSetting.getModule_order_12() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_12, tv_order_12, 0, false);
			}
			if (moduleSetting.getModule_order_13() >= 1) {
				setCheckBoxAndTextViewCustom(cb_13, tv_order_13,
						moduleSetting.getModule_order_13(), true);
				if (moduleSetting.getModule_order_13() >= main_order) {
					main_order = moduleSetting.getModule_order_13() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_13, tv_order_13, 0, false);
			}
			if (moduleSetting.getModule_order_14() >= 1) {
				setCheckBoxAndTextViewCustom(cb_14, tv_order_14,
						moduleSetting.getModule_order_14(), true);
				if (moduleSetting.getModule_order_14() >= main_order) {
					main_order = moduleSetting.getModule_order_14() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_14, tv_order_14, 0, false);
			}

			if (moduleSetting.getModule_order_15() >= 1) {
				setCheckBoxAndTextViewCustom(cb_15, tv_order_15,
						moduleSetting.getModule_order_15(), true);
				if (moduleSetting.getModule_order_15() >= main_order) {
					main_order = moduleSetting.getModule_order_15() + 1;
				}

			} else {
				setCheckBoxAndTextViewCustom(cb_15, tv_order_15, 0, false);
			}
		} else {
			enableViewCustomCheckBox();
			main_order = 1;
		}
		cb_settin_default.setOnCheckedChangeListener(this);
		addListenerCustomRunCheckBox();

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.cb_settin_default:
			if (isChecked) {
				main_order = 1;
				disableViewCustomCheckBox();

			} else if (!isChecked) {

				enableViewCustomCheckBox();

			}

			break;

		case R.id.cb_1:
			if (isChecked) {
				singleCustomRunChecked(tv_order_1);

			} else {
				singleCustomRunUnChecked(tv_order_1, cb_1);
			}
			break;

		case R.id.cb_2:
			if (isChecked) {
				singleCustomRunChecked(tv_order_2);

			} else {
				singleCustomRunUnChecked(tv_order_2, cb_2);
			}
			break;

		case R.id.cb_3:
			if (isChecked) {
				singleCustomRunChecked(tv_order_3);

			} else {
				singleCustomRunUnChecked(tv_order_3, cb_3);
			}
			break;

		case R.id.cb_4:
			if (isChecked) {
				singleCustomRunChecked(tv_order_4);

			} else {
				singleCustomRunUnChecked(tv_order_4, cb_4);
			}
			break;
		case R.id.cb_5:
			if (isChecked) {
				singleCustomRunChecked(tv_order_5);

			} else {
				singleCustomRunUnChecked(tv_order_5, cb_5);
			}
			break;
		case R.id.cb_6:
			if (isChecked) {
				singleCustomRunChecked(tv_order_6);

			} else {
				singleCustomRunUnChecked(tv_order_6, cb_6);
			}
			break;
		case R.id.cb_7:
			if (isChecked) {
				singleCustomRunChecked(tv_order_7);

			} else {
				singleCustomRunUnChecked(tv_order_7, cb_7);
			}
			break;
		case R.id.cb_8:
			if (isChecked) {
				singleCustomRunChecked(tv_order_8);

			} else {
				singleCustomRunUnChecked(tv_order_8, cb_8);
			}
			break;
		case R.id.cb_9:
			if (isChecked) {
				singleCustomRunChecked(tv_order_9);

			} else {
				singleCustomRunUnChecked(tv_order_9, cb_9);
			}
			break;
		case R.id.cb_10:
			if (isChecked) {
				singleCustomRunChecked(tv_order_10);

			} else {
				singleCustomRunUnChecked(tv_order_10, cb_10);
			}
			break;
		case R.id.cb_11:
			if (isChecked) {
				singleCustomRunChecked(tv_order_11);

			} else {
				singleCustomRunUnChecked(tv_order_11, cb_11);
			}
			break;
		case R.id.cb_12:
			if (isChecked) {
				singleCustomRunChecked(tv_order_12);

			} else {
				singleCustomRunUnChecked(tv_order_12, cb_12);
			}
			break;
		case R.id.cb_13:
			if (isChecked) {
				singleCustomRunChecked(tv_order_13);

			} else {
				singleCustomRunUnChecked(tv_order_13, cb_13);
			}
			break;
		case R.id.cb_14:
			if (isChecked) {
				singleCustomRunChecked(tv_order_14);

			} else {
				singleCustomRunUnChecked(tv_order_14, cb_14);
			}
			break;
		case R.id.cb_15:
			if (isChecked) {
				singleCustomRunChecked(tv_order_15);

			} else {
				singleCustomRunUnChecked(tv_order_15, cb_15);
			}
			break;

		}

	}

	private void setCheckBoxAndTextViewCustom(CheckBox cb, TextView tv,
			int value, boolean isSet) {

		if (isSet) {
			cb.setChecked(true);
			tv.setBackgroundColor(getActivity().getResources().getColor(
					R.color.teal));
			tv.setTextColor(Color.WHITE);
			tv.setText(String.valueOf(value));

		} else {

			cb.setChecked(false);
			tv.setBackgroundColor(getActivity().getResources().getColor(
					R.color.gray_1));
			tv.setText("");

		}

	}

	private void singleCustomRunChecked(TextView tvView) {
		tvView.setBackgroundColor(getActivity().getResources().getColor(
				R.color.teal));
		tvView.setTextColor(Color.WHITE);
		tvView.setText(String.valueOf(main_order++));

	}

	private void singleCustomRunUnChecked(TextView tvView, CheckBox cb) {

		tvView.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		--main_order;
		int value = Integer.valueOf(tvView.getText().toString());
		tvView.setText("");
		if (cb_1.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_1.getText().toString());
			if (tv_value > value) {
				tv_order_1.setText(String.valueOf(--tv_value));
			}
		}
		if (cb_2.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_2.getText().toString());
			if (tv_value > value) {
				tv_order_2.setText(String.valueOf(--tv_value));
			}
		}
		if (cb_3.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_3.getText().toString());
			if (tv_value > value) {
				tv_order_3.setText(String.valueOf(--tv_value));
			}
		}

		if (cb_4.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_4.getText().toString());
			if (tv_value > value) {
				tv_order_4.setText(String.valueOf(--tv_value));
			}
		}
		if (cb_5.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_5.getText().toString());
			if (tv_value > value) {
				tv_order_5.setText(String.valueOf(--tv_value));
			}
		}
		if (cb_6.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_6.getText().toString());
			if (tv_value > value) {
				tv_order_6.setText(String.valueOf(--tv_value));
			}
		}

		if (cb_7.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_7.getText().toString());
			if (tv_value > value) {
				tv_order_7.setText(String.valueOf(--tv_value));
			}
		}

		if (cb_8.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_8.getText().toString());
			if (tv_value > value) {
				tv_order_8.setText(String.valueOf(--tv_value));
			}
		}

		if (cb_9.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_9.getText().toString());
			if (tv_value > value) {
				tv_order_9.setText(String.valueOf(--tv_value));
			}
		}

		if (cb_10.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_10.getText().toString());
			if (tv_value > value) {
				tv_order_10.setText(String.valueOf(--tv_value));
			}
		}

		if (cb_11.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_11.getText().toString());
			if (tv_value > value) {
				tv_order_11.setText(String.valueOf(--tv_value));
			}
		}
		if (cb_12.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_12.getText().toString());
			if (tv_value > value) {
				tv_order_12.setText(String.valueOf(--tv_value));
			}
		}

		if (cb_13.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_13.getText().toString());
			if (tv_value > value) {
				tv_order_13.setText(String.valueOf(--tv_value));
			}
		}
		if (cb_14.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_14.getText().toString());
			if (tv_value > value) {
				tv_order_14.setText(String.valueOf(--tv_value));
			}
		}
		if (cb_15.isChecked()) {
			int tv_value = Integer.valueOf(tv_order_15.getText().toString());
			if (tv_value > value) {
				tv_order_15.setText(String.valueOf(--tv_value));
			}
		}

	}

	private void addListenerCustomRunCheckBox() {
		cb_1.setOnCheckedChangeListener(this);
		cb_2.setOnCheckedChangeListener(this);
		cb_3.setOnCheckedChangeListener(this);
		cb_4.setOnCheckedChangeListener(this);
		cb_5.setOnCheckedChangeListener(this);
		cb_6.setOnCheckedChangeListener(this);
		cb_7.setOnCheckedChangeListener(this);
		cb_8.setOnCheckedChangeListener(this);
		cb_9.setOnCheckedChangeListener(this);
		cb_10.setOnCheckedChangeListener(this);
		cb_11.setOnCheckedChangeListener(this);
		cb_12.setOnCheckedChangeListener(this);
		cb_13.setOnCheckedChangeListener(this);
		cb_14.setOnCheckedChangeListener(this);
		cb_15.setOnCheckedChangeListener(this);

	}

	private void removeListenerCustomRunCheckBox() {

		cb_1.setOnCheckedChangeListener(null);
		cb_2.setOnCheckedChangeListener(null);
		cb_3.setOnCheckedChangeListener(null);
		cb_4.setOnCheckedChangeListener(null);
		cb_5.setOnCheckedChangeListener(null);
		cb_6.setOnCheckedChangeListener(null);
		cb_7.setOnCheckedChangeListener(null);
		cb_8.setOnCheckedChangeListener(null);
		cb_9.setOnCheckedChangeListener(null);
		cb_10.setOnCheckedChangeListener(null);
		cb_11.setOnCheckedChangeListener(null);
		cb_12.setOnCheckedChangeListener(null);
		cb_13.setOnCheckedChangeListener(null);
		cb_14.setOnCheckedChangeListener(null);
		cb_15.setOnCheckedChangeListener(null);

	}

	private void enableViewCustomCheckBox() {
		cb_1.setEnabled(true);
		cb_2.setEnabled(true);
		cb_3.setEnabled(true);
		cb_4.setEnabled(true);
		cb_5.setEnabled(true);
		cb_6.setEnabled(true);
		cb_7.setEnabled(true);
		cb_8.setEnabled(true);
		cb_9.setEnabled(true);
		cb_10.setEnabled(true);
		cb_11.setEnabled(true);
		cb_12.setEnabled(true);
		cb_13.setEnabled(true);
		cb_14.setEnabled(true);
		cb_15.setEnabled(true);
		tv_setting_custom.setEnabled(true);

	}

	private void disableViewCustomCheckBox() {
		removeListenerCustomRunCheckBox();
		cb_1.setEnabled(false);
		cb_2.setEnabled(false);
		cb_3.setEnabled(false);
		cb_4.setEnabled(false);
		cb_5.setEnabled(false);
		cb_6.setEnabled(false);
		cb_7.setEnabled(false);
		cb_8.setEnabled(false);
		cb_9.setEnabled(false);
		cb_10.setEnabled(false);
		cb_11.setEnabled(false);
		cb_12.setEnabled(false);
		cb_13.setEnabled(false);
		cb_14.setEnabled(false);
		cb_15.setEnabled(false);
		cb_1.setChecked(false);
		cb_2.setChecked(false);
		cb_3.setChecked(false);
		cb_4.setChecked(false);
		cb_5.setChecked(false);

		cb_6.setChecked(false);
		cb_7.setChecked(false);
		cb_8.setChecked(false);
		cb_9.setChecked(false);
		cb_10.setChecked(false);

		cb_11.setChecked(false);
		cb_12.setChecked(false);
		cb_13.setChecked(false);
		cb_14.setChecked(false);
		cb_15.setChecked(false);

		tv_order_1.setText("");
		tv_order_1.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));

		tv_order_2.setText("");
		tv_order_2.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_3.setText("");
		tv_order_3.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_4.setText("");
		tv_order_4.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_5.setText("");
		tv_order_5.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_6.setText("");
		tv_order_6.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_7.setText("");
		tv_order_7.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_8.setText("");
		tv_order_8.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_9.setText("");
		tv_order_9.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_10.setText("");
		tv_order_10.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));

		tv_order_11.setText("");
		tv_order_11.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_12.setText("");
		tv_order_12.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_13.setText("");
		tv_order_13.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_14.setText("");
		tv_order_14.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));
		tv_order_15.setText("");
		tv_order_15.setBackgroundColor(getActivity().getResources().getColor(
				R.color.gray_1));

		tv_setting_custom.setEnabled(false);

		addListenerCustomRunCheckBox();
	}

	private void intializedView() {

		btn_clean_cb = (AnyButton) view.findViewById(R.id.btn_clean_cb);
		cb_settin_default = (CheckBox) view
				.findViewById(R.id.cb_settin_default);
		cb_settin_default.setTypeface(AppObject.getCurrentFont(getActivity()));
		cb_1 = (CheckBox) view.findViewById(R.id.cb_1);
		cb_1.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_2 = (CheckBox) view.findViewById(R.id.cb_2);
		cb_2.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_3 = (CheckBox) view.findViewById(R.id.cb_3);
		cb_3.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_4 = (CheckBox) view.findViewById(R.id.cb_4);
		cb_4.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_5 = (CheckBox) view.findViewById(R.id.cb_5);
		cb_5.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_6 = (CheckBox) view.findViewById(R.id.cb_6);
		cb_6.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_7 = (CheckBox) view.findViewById(R.id.cb_7);
		cb_7.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_8 = (CheckBox) view.findViewById(R.id.cb_8);
		cb_8.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_9 = (CheckBox) view.findViewById(R.id.cb_9);
		cb_9.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_10 = (CheckBox) view.findViewById(R.id.cb_10);
		cb_10.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_11 = (CheckBox) view.findViewById(R.id.cb_11);
		cb_11.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_12 = (CheckBox) view.findViewById(R.id.cb_12);
		cb_12.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_13 = (CheckBox) view.findViewById(R.id.cb_13);
		cb_13.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_14 = (CheckBox) view.findViewById(R.id.cb_14);
		cb_14.setTypeface(AppObject.getCurrentFont(getActivity()));

		cb_15 = (CheckBox) view.findViewById(R.id.cb_15);
		cb_15.setTypeface(AppObject.getCurrentFont(getActivity()));

		tv_order_1 = (AnyTextView) view.findViewById(R.id.tv_order_1);
		tv_order_2 = (AnyTextView) view.findViewById(R.id.tv_order_2);
		tv_order_3 = (AnyTextView) view.findViewById(R.id.tv_order_3);
		tv_order_4 = (AnyTextView) view.findViewById(R.id.tv_order_4);
		tv_order_5 = (AnyTextView) view.findViewById(R.id.tv_order_5);
		tv_order_6 = (AnyTextView) view.findViewById(R.id.tv_order_6);
		tv_order_7 = (AnyTextView) view.findViewById(R.id.tv_order_7);
		tv_order_8 = (AnyTextView) view.findViewById(R.id.tv_order_8);
		tv_order_9 = (AnyTextView) view.findViewById(R.id.tv_order_9);
		tv_order_10 = (AnyTextView) view.findViewById(R.id.tv_order_10);
		tv_order_11 = (AnyTextView) view.findViewById(R.id.tv_order_11);
		tv_order_12 = (AnyTextView) view.findViewById(R.id.tv_order_12);
		tv_order_13 = (AnyTextView) view.findViewById(R.id.tv_order_13);
		tv_order_14 = (AnyTextView) view.findViewById(R.id.tv_order_14);
		tv_order_15 = (AnyTextView) view.findViewById(R.id.tv_order_15);

		tv_setting_custom = (AnyTextView) view
				.findViewById(R.id.tv_setting_custom);

	}

	@Override
	public void Update() {

		checkView();
	}

	private void saveData() {
		if (cb_settin_default.isChecked()) {
			if (ppSettingModuleDBOpenHelper
					.setDefaultModuleData(new DefaultModuleData())) {
				Toast.makeText(
						getActivity(),
						getActivity().getResources().getString(
								R.string.default_pre_set_programs_save),
						Toast.LENGTH_LONG).show();

			} else {
				Toast.makeText(
						getActivity(),
						getActivity().getResources().getString(
								R.string.default_pre_set_programs_not_save),
						Toast.LENGTH_LONG).show();
			}

		} else {
			boolean anyCbChecked = false;

			int module_order_1 = -1, module_order_2 = -1, module_order_3 = -1, module_order_4 = -1, module_order_5 = -1, module_order_6 = -1, module_order_7 = -1, module_order_8 = -1, module_order_9 = -1, module_order_10 = -1, module_order_11 = -1, module_order_12 = -1, module_order_13 = -1, module_order_14 = -1, module_order_15 = -1, module_order_16 = main_order;
			if (cb_1.isChecked()) {
				anyCbChecked = true;
				module_order_1 = Integer.valueOf(tv_order_1.getText()
						.toString());
			}
			if (cb_2.isChecked()) {
				anyCbChecked = true;
				module_order_2 = Integer.valueOf(tv_order_2.getText()
						.toString());
			}
			if (cb_3.isChecked()) {
				anyCbChecked = true;
				module_order_3 = Integer.valueOf(tv_order_3.getText()
						.toString());
			}
			if (cb_4.isChecked()) {
				anyCbChecked = true;
				module_order_4 = Integer.valueOf(tv_order_4.getText()
						.toString());
			}
			if (cb_5.isChecked()) {
				anyCbChecked = true;
				module_order_5 = Integer.valueOf(tv_order_5.getText()
						.toString());
			}
			if (cb_6.isChecked()) {
				anyCbChecked = true;
				module_order_6 = Integer.valueOf(tv_order_6.getText()
						.toString());
			}
			if (cb_7.isChecked()) {
				anyCbChecked = true;
				module_order_7 = Integer.valueOf(tv_order_7.getText()
						.toString());
			}
			if (cb_8.isChecked()) {
				anyCbChecked = true;
				module_order_8 = Integer.valueOf(tv_order_8.getText()
						.toString());
			}
			if (cb_9.isChecked()) {
				anyCbChecked = true;
				module_order_9 = Integer.valueOf(tv_order_9.getText()
						.toString());
			}
			if (cb_10.isChecked()) {
				anyCbChecked = true;
				module_order_10 = Integer.valueOf(tv_order_10.getText()
						.toString());
			}
			if (cb_11.isChecked()) {
				anyCbChecked = true;
				module_order_11 = Integer.valueOf(tv_order_11.getText()
						.toString());
			}
			if (cb_12.isChecked()) {
				anyCbChecked = true;
				module_order_12 = Integer.valueOf(tv_order_12.getText()
						.toString());
			}
			if (cb_13.isChecked()) {
				anyCbChecked = true;
				module_order_13 = Integer.valueOf(tv_order_13.getText()
						.toString());
			}
			if (cb_14.isChecked()) {
				anyCbChecked = true;
				module_order_14 = Integer.valueOf(tv_order_14.getText()
						.toString());
			}
			if (cb_15.isChecked()) {
				anyCbChecked = true;
				module_order_15 = Integer.valueOf(tv_order_15.getText()
						.toString());
			}

			Log.d("1oooooooooo", module_order_1 + "");
			Log.d("1oooooooooo", module_order_16 + "");

			if (anyCbChecked) {
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new ModuleSettingData(
								module_order_1, module_order_2, module_order_3,
								module_order_4, module_order_5, module_order_6,
								module_order_7, module_order_8, module_order_9,
								module_order_10, module_order_11,
								module_order_12, module_order_13,
								module_order_14, module_order_15,
								module_order_16,
								SettingConstants.COUSTOM_MODULE, -1));
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				Toast.makeText(
						getActivity(),
						getActivity().getResources().getString(
								R.string.custom_pre_set_programs_save),
						Toast.LENGTH_LONG).show();

			} else {
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new DefaultModuleData());
				cb_settin_default.setChecked(true);
				Toast.makeText(
						getActivity(),
						getActivity().getResources().getString(
								R.string.there_are_progame), Toast.LENGTH_LONG)
						.show();

			}
		}

	}
}
