package com.rimon.rsa.ipaes.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpSettingModuleDBOpenHelper;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.radiobutton.AnyRadioButton;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

public class SettingFragment_1 extends SherlockFragment implements
		OnCheckedChangeListener,
		android.widget.CompoundButton.OnCheckedChangeListener, UpdateFragment {

	private View view;

	private CheckBox cb_settin_default;
	private AnyRadioButton rb_settin_r_1, rb_settin_r_2, rb_settin_r_3,
			rb_settin_r_4, rb_settin_r_5, rb_settin_r_6, rb_settin_r_7;
	private RadioGroup rg_setting;
	private AnyTextView tv_setting_rb;
	private PpSettingModuleDBOpenHelper ppSettingModuleDBOpenHelper;
	private ModuleSettingData moduleSetting;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.setting_fragment_1, null, false);
		intializedView();
		checkView();
		return view;

	}

	private void checkView() {

		rg_setting.setOnCheckedChangeListener(null);
		rg_setting.clearCheck();
		cb_settin_default.setOnCheckedChangeListener(null);
		moduleSetting = ppSettingModuleDBOpenHelper.getModuleSettingData();
		if (moduleSetting.getRun_state() == SettingConstants.DEFAULT_MODULE) {
			cb_settin_default.setChecked(true);
			disableRadioButton();
		} else if (moduleSetting.getRun_state() == SettingConstants.PRESET_MODULE) {
			enableRadioButton();

			switch (moduleSetting.getPreset_number()) {
			case 1:
				rb_settin_r_1.setChecked(true);
				break;
			case 2:
				rb_settin_r_2.setChecked(true);
				break;
			case 3:
				rb_settin_r_3.setChecked(true);
				break;
			case 4:
				rb_settin_r_4.setChecked(true);
				break;
			case 5:
				rb_settin_r_5.setChecked(true);
				break;
			case 6:
				rb_settin_r_6.setChecked(true);
				break;
			case 7:
				rb_settin_r_7.setChecked(true);
				break;
			}

		}
		rg_setting.setOnCheckedChangeListener(this);
		cb_settin_default.setOnCheckedChangeListener(this);

	}

	private void intializedView() {
		ppSettingModuleDBOpenHelper = DatabaseCreator
				.getPpSettingModuleDBOpenHelper(getActivity());

		cb_settin_default = (CheckBox) view
				.findViewById(R.id.cb_settin_default);

		cb_settin_default.setOnCheckedChangeListener(this);
		cb_settin_default.setTypeface(AppObject.getCurrentFont(getActivity()));

		rg_setting = (RadioGroup) view.findViewById(R.id.rg_setting);
		rg_setting.setOnCheckedChangeListener(this);

		rb_settin_r_1 = (AnyRadioButton) view.findViewById(R.id.rb_settin_r_1);
		rb_settin_r_2 = (AnyRadioButton) view.findViewById(R.id.rb_settin_r_2);
		rb_settin_r_3 = (AnyRadioButton) view.findViewById(R.id.rb_settin_r_3);
		rb_settin_r_4 = (AnyRadioButton) view.findViewById(R.id.rb_settin_r_4);
		rb_settin_r_5 = (AnyRadioButton) view.findViewById(R.id.rb_settin_r_5);
		rb_settin_r_6 = (AnyRadioButton) view.findViewById(R.id.rb_settin_r_6);
		rb_settin_r_7 = (AnyRadioButton) view.findViewById(R.id.rb_settin_r_7);

		tv_setting_rb = (AnyTextView) view.findViewById(R.id.tv_setting_rb);

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		if (group.getId() == R.id.rg_setting) {
			switch (checkedId) {
			case R.id.rb_settin_r_1:
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new Preset1ModuleData());
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				break;
			case R.id.rb_settin_r_2:
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new Preset2ModuleData());
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				break;
			case R.id.rb_settin_r_3:
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new Preset3ModuleData());
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				break;
			case R.id.rb_settin_r_4:
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new Preset4ModuleData());
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				break;
			case R.id.rb_settin_r_5:
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new Preset5ModuleData());
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				break;
			case R.id.rb_settin_r_6:
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new Preset6ModuleData());
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				break;
			case R.id.rb_settin_r_7:
				ppSettingModuleDBOpenHelper
						.setDefaultModuleData(new Preset7ModuleData());
				ppSettingModuleDBOpenHelper.getModuleSettingData();
				break;

			}
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean ischecked) {

		// Log.d("AAAAAAAAAAAAAAAAAAAAAAAAAAAAa", "1");
		if (ischecked) {
			// Log.d("AAAAAAAAAAAAAAAAAAAAAAAAAAAAa", "2");

			disableRadioButton();
			rg_setting.setOnCheckedChangeListener(null);
			rg_setting.clearCheck();
			rg_setting.setOnCheckedChangeListener(this);

			ppSettingModuleDBOpenHelper
					.setDefaultModuleData(new DefaultModuleData());

		} else {
			// Log.d("AAAAAAAAAAAAAAAAAAAAAAAAAAAAa", "3");
			rb_settin_r_1.setChecked(true);
			enableRadioButton();
		}

	}

	private void enableRadioButton() {
		rb_settin_r_1.setEnabled(true);
		rb_settin_r_2.setEnabled(true);
		rb_settin_r_3.setEnabled(true);
		rb_settin_r_4.setEnabled(true);
		rb_settin_r_5.setEnabled(true);
		rb_settin_r_6.setEnabled(true);
		rb_settin_r_7.setEnabled(true);
		tv_setting_rb.setEnabled(true);

	}

	private void disableRadioButton() {
		rb_settin_r_1.setEnabled(false);
		rb_settin_r_2.setEnabled(false);
		rb_settin_r_3.setEnabled(false);
		rb_settin_r_4.setEnabled(false);
		rb_settin_r_5.setEnabled(false);
		rb_settin_r_6.setEnabled(false);
		rb_settin_r_7.setEnabled(false);
		tv_setting_rb.setEnabled(false);

	}

	@Override
	public void Update() {
		checkView();

	}

}
