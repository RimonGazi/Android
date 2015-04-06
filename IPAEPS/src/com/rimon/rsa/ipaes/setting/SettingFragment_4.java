package com.rimon.rsa.ipaes.setting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpSettingModuleDBOpenHelper;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglog;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogPasswordListener;

public class SettingFragment_4 extends SherlockFragment implements
		OnClickListener, AnyDialogPasswordListener {
	private View view;
	private EditText et_current_password, et_new_password;
	private AnyButton btn_password_cahnge;
	private String get_user_current_p = "", new_set_p = "", get_dtabase_p = "";
	private boolean isSingleDiaglog = true;
	private Bundle bundle;
	private AnyDiaglog diaglogFragment;
	private PpSettingModuleDBOpenHelper ppSettingModuleDBOpenHelper;
	private Button btn_font_cahnge;
	private RadioGroup rg_font;
	private RadioButton rb_f_courgette, rb_f_museo, rb_f_default;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		diaglogFragment = new AnyDiaglog();
		diaglogFragment.setTargetFragment(this, 0);
		bundle = new Bundle();
		ppSettingModuleDBOpenHelper = DatabaseCreator
				.getPpSettingModuleDBOpenHelper(getActivity());
		view = inflater.inflate(R.layout.setting_fragment_4, null, false);

		rg_font = (RadioGroup) view.findViewById(R.id.rg_font);

		rb_f_courgette = (RadioButton) view.findViewById(R.id.rb_f_courgette);
		rb_f_museo = (RadioButton) view.findViewById(R.id.rb_f_museo);
		rb_f_default = (RadioButton) view.findViewById(R.id.rb_f_default);

		btn_font_cahnge = (Button) view.findViewById(R.id.btn_font_cahnge);
		btn_font_cahnge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (rg_font.getCheckedRadioButtonId() == R.id.rb_f_courgette) {

					if ((ppSettingModuleDBOpenHelper.getFont())
							.equals(AppConstants.FONT_1)) {
						Toast.makeText(
								getActivity(),
								getResources().getString(
										R.string.font_is_already_used),
								Toast.LENGTH_LONG).show();
					} else {
						AppObject.setfont(getActivity(), AppConstants.FONT_1);
						restartApp();
					}

				} else if (rg_font.getCheckedRadioButtonId() == R.id.rb_f_museo) {
					if ((ppSettingModuleDBOpenHelper.getFont())
							.equals(AppConstants.FONT_2)) {
						Toast.makeText(
								getActivity(),
								getResources().getString(
										R.string.font_is_already_used),
								Toast.LENGTH_LONG).show();
					} else {
						AppObject.setfont(getActivity(), AppConstants.FONT_2);
						restartApp();
					}

				} else if (rg_font.getCheckedRadioButtonId() == R.id.rb_f_default) {

					if ((ppSettingModuleDBOpenHelper.getFont())
							.equals(AppConstants.FONT_3)) {
						Toast.makeText(
								getActivity(),
								getResources().getString(
										R.string.font_is_already_used),
								Toast.LENGTH_LONG).show();
					} else {
						AppObject.setfont(getActivity(), AppConstants.FONT_3);
						restartApp();
					}
				}

			}
		});

		initializedView();
		checkView();

		return view;

	}

	private void initializedView() {
		et_current_password = (EditText) view
				.findViewById(R.id.et_current_password);
		et_new_password = (EditText) view.findViewById(R.id.et_new_password);
		btn_password_cahnge = (AnyButton) view
				.findViewById(R.id.btn_password_cahnge);
		btn_password_cahnge.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.btn_password_cahnge) {
			get_user_current_p = et_current_password.getText().toString();
			get_dtabase_p = ppSettingModuleDBOpenHelper.getPassword();
			new_set_p = et_new_password.getText().toString();
			if (!get_user_current_p.equals(null)
					&& !get_user_current_p.equals("")
					&& get_user_current_p.length() >= 5) {

				if (!new_set_p.equals(null) && !new_set_p.equals("")) {

					if (new_set_p.length() >= 5) {

						if (get_dtabase_p.length() == get_user_current_p
								.length()
								&& get_dtabase_p.equals(get_user_current_p)) {

							if (ppSettingModuleDBOpenHelper
									.setPassword(new_set_p)) {
								showDiaglog(
										getActivity().getString(
												R.string.password_change),
										getActivity().getString(R.string.p_c_s));
								et_current_password.setText("");
								et_new_password.setText("");

							} else {
								showDiaglog(
										getActivity().getString(
												R.string.password_change),
										getActivity().getString(R.string.error));

							}

						} else {
							showDiaglog(
									getActivity().getString(
											R.string.password_change),
									getActivity().getString(
											R.string.passowrd_not_match));

						}
					} else {
						showDiaglog(
								getActivity().getString(
										R.string.password_change),
								getActivity().getString(
										R.string.invalid_p_length));

					}

				} else {
					showDiaglog(
							getActivity().getString(R.string.password_change),
							getActivity().getString(R.string.invalid_n_p));
				}

			}

			else {
				showDiaglog(getActivity().getString(R.string.password_change),
						getActivity().getString(R.string.invalid_c_p));
			}

		}

	}

	private void showDiaglog(String title, String mgs) {
		Log.d("rrrrrrrrrrrrr", "eeee1");
		if (isSingleDiaglog) {
			isSingleDiaglog = false;
			bundle.putInt(AppConstants.ANY_DIAGLOT_ICON,
					R.drawable.password_icon);

			bundle.putString(AppConstants.ANY_DIAGLOT_MESSAGE, mgs);
			bundle.putString(AppConstants.ANY_DIAGLOT_TITLE, title);
			diaglogFragment.setArguments(bundle);
			diaglogFragment.setCancelable(false);
			diaglogFragment.show(getActivity().getSupportFragmentManager(),
					"diaglog");
		}

	}

	@Override
	public void onClickPasswordDialog(boolean isPasswordCorrect) {
		isSingleDiaglog = true;

	}

	private void restartApp() {

		Intent intent = getActivity()
				.getBaseContext()
				.getPackageManager()
				.getLaunchIntentForPackage(
						getActivity().getBaseContext().getPackageName());
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}

	private void checkView() {
		if ((ppSettingModuleDBOpenHelper.getFont()).equals(AppConstants.FONT_1)) {
			rb_f_courgette.setChecked(true);
		} else if ((ppSettingModuleDBOpenHelper.getFont())
				.equals(AppConstants.FONT_2)) {
			rb_f_museo.setChecked(true);
		} else if ((ppSettingModuleDBOpenHelper.getFont())
				.equals(AppConstants.FONT_3)) {
			rb_f_default.setChecked(true);
		}

	}

}
