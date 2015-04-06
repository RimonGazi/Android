package com.rimon.rsa.ibd.setting;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.rimon.rsa.ibd.database.PasswordDBAdapter;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.Dialog;
import com.rimon.rsa.mental.R;

public class Setting extends SherlockActivity {
	private Button btn_pasword_change;
	private EditText et_current_password, et_new_password, et_confirm_password;
	private PasswordDBAdapter passwordDBAdapter;
	private CheckBox cb_all_question, cb_initial_question;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		actionberSetUp();
		passwordDBAdapter = new PasswordDBAdapter(Setting.this);
		passwordDBAdapter.openWriteableDatabase();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);

		btn_pasword_change = (Button) findViewById(R.id.btn_pasword_change);
		et_confirm_password = (EditText) findViewById(R.id.et_cnp);
		et_new_password = (EditText) findViewById(R.id.et_np);
		et_current_password = (EditText) findViewById(R.id.et_cp);
		btn_pasword_change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String myPassword = passwordDBAdapter.getPassword();
				String inputPassword = et_current_password.getText().toString();

				if (myPassword.equals(inputPassword)) {
					String new_password = et_new_password.getText().toString();
					String confirm_password = et_confirm_password.getText()
							.toString();
					if ((!new_password.equals(""))
							&& (!new_password.equals(null))
							&& (!confirm_password.equals(""))
							&& (!confirm_password.equals(null))) {
						if (new_password.length() >= 5
								&& confirm_password.length() >= 5) {
							if (new_password.equals(confirm_password)) {
								if (!new_password.equals(myPassword)) {

									if (passwordDBAdapter
											.setPassword(new_password) > 0) {
										Dialog.DialogShow("Password changed",
												Setting.this);
										et_current_password.setText("");
										et_confirm_password.setText("");
										et_new_password.setText("");
									} else {
										Dialog.DialogShow("Error", Setting.this);
									}
								} else {
									Dialog.DialogShow(
											"Current password and new password same !",
											Setting.this);
								}

							} else {
								Dialog.DialogShow("Password not match !",
										Setting.this);
							}
						} else {
							Dialog.DialogShow(
									"Password lenght at least 5 character !",
									Setting.this);

						}
					} else {
						Dialog.DialogShow("Invalid password !", Setting.this);
					}
				} else {
					Dialog.DialogShow("Incorrect Password !", Setting.this);
				}

			}
		});

		cb_all_question = (CheckBox) findViewById(R.id.checkBoxAllQuestion);
		cb_initial_question = (CheckBox) findViewById(R.id.checkBoxIntialQuestion);
		if (passwordDBAdapter.getQuestionStatus().equals(
				ConstantValues.initial_question_status_true)) {
			cb_initial_question.setChecked(true);
		} else {
			cb_all_question.setChecked(true);
		}

		cb_all_question
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {

						if (ischecked) {
							cb_initial_question.setChecked(false);
							passwordDBAdapter
									.setInitialQuestionStatus(ConstantValues.initial_question_status_false);

						} else {
							cb_initial_question.setChecked(true);
							passwordDBAdapter
									.setInitialQuestionStatus(ConstantValues.initial_question_status_true);
						}

					}
				});

		cb_initial_question
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {

						if (ischecked) {
							cb_all_question.setChecked(false);
							passwordDBAdapter
									.setInitialQuestionStatus(ConstantValues.initial_question_status_true);
						} else {
							cb_all_question.setChecked(true);
							passwordDBAdapter
									.setInitialQuestionStatus(ConstantValues.initial_question_status_false);
						}

					}
				});

	}

	@Override
	protected void onDestroy() {
		if (passwordDBAdapter != null) {
			passwordDBAdapter.close();
		}
		super.onDestroy();
	}

	private void actionberSetUp() {
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View view = getLayoutInflater().inflate(R.layout.custom_action_bar,
				null);
		getSupportActionBar().setCustomView(
				view,
				new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
						ActionBar.LayoutParams.MATCH_PARENT));
		ImageButton back = (ImageButton) view.findViewById(R.id.back);
		TextView tv_title = (TextView) view.findViewById(R.id.actionber_tv);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});

		tv_title.setText("Setting");
	}
}
