package net.sistransitomobile.login;

import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.fragment.AnyDiaglog;
import net.sistransitomobile.fragment.AnyPageChangeListener;
import net.sistransitomobile.main.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentLogin extends SherlockFragment implements OnClickListener {
	private View view;
	private AnyPageChangeListener anyPageChangeListener;
	private Button btn_register;
	private ImageButton im_btn_back;
	private Button btn_login;
	private EditText et_email, et_password;
	private CheckBox cb_remember;
	private InputMethodManager imm;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		anyPageChangeListener = (LoginActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.login_fragment, null, false);
		imm = (InputMethodManager) getActivity().getSystemService(
				Context.INPUT_METHOD_SERVICE);
		initializedView();
		setUpActionBar();
		return view;

	}

	private void initializedView() {
		btn_register = (Button) view.findViewById(R.id.btn_register);
		btn_register.setOnClickListener(this);
		btn_login = (Button) view.findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
		et_email = (EditText) view.findViewById(R.id.et_email);
		et_password = (EditText) view.findViewById(R.id.et_password);
		cb_remember = (CheckBox) view.findViewById(R.id.cb_remember);
		cb_remember.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton view, boolean ischecked) {

				if (ischecked) {
					(DatabaseCreator.getDatabaseAdapterSetting(getActivity()))
							.setRemerberState(true);
				} else {
					(DatabaseCreator.getDatabaseAdapterSetting(getActivity()))
							.setRemerberState(false);
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register:
			anyPageChangeListener.onPageChange(AppConstants.LOING_FRAGMENT_1);
			break;
		case R.id.btn_login:
			if (checkInput()) {
				imm.hideSoftInputFromWindow(btn_login.getWindowToken(), 0);
				userLogin();

			}
			break;
		}

	}

	private void setUpActionBar() {
		im_btn_back = (ImageButton) view.findViewById(R.id.im_btn_back);
		im_btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				getActivity().finish();
			}
		});
	}

	private boolean checkInput() {
		if (et_email.getText().toString().equals("")) {
			et_email.setError(getResources().getString(
					R.string.please_enter_your_email));
			et_email.requestFocus();
			return false;
		} else if (et_password.getText().toString().equals("")) {
			et_password.setError(getResources().getString(
					R.string.please_enter_your_password));
			et_password.requestFocus();
			return false;
		} else {
			return true;
		}
	}

	private void userLogin() {

		String url = "http://sistransito.net/movel/dosis.pl?op=dologin&login="
				+ et_email.getText().toString() + "&senha="
				+ et_password.getText();

		(new LoginHttpResultAnysTask(new FragmentCallBackLogin() {

			@Override
			public void CallBack(LogJsonFormat logJsonFormat) {
				if (logJsonFormat != null) {
					if (logJsonFormat.isIsSuccess()) {
						DatabaseCreator.getdDatabseAdapterUserio(getActivity())
								.setAllData(logJsonFormat);
						sentResult();
					} else {
						AnyDiaglog.DialogShow("Invalid email or senha",
								getActivity());
					}
				}
			}

		}, getActivity(), url)).execute("");

	}

	private void sentResult() {

		(DatabaseCreator.getDatabaseAdapterSetting(getActivity()))
				.setPasswordState(true);
		(DatabaseCreator.getDatabaseAdapterSetting(getActivity()))
				.setRemerberState(cb_remember.isChecked());
		Intent intent = new Intent();
		intent.putExtra("login", true);
		getActivity().setResult(AppConstants.ACITVITY_REQUEST_CODE, intent);
		getActivity().finish();
	}
}
