package net.sistransitomobile.login;

import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.fragment.AnyPageChangeListener;
import net.sistransitomobile.main.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.actionbarsherlock.app.SherlockFragment;


public class FragmentRegister extends SherlockFragment implements
		OnClickListener, TextWatcher {
	private View view;
	private Button btn_login, btn_sign_up;
	private AnyPageChangeListener anyPageChangeListener;
	private ImageButton im_action_bar;
	private EditText et_name, et_orgao, et_email, et_matricula, et_cpf,
			et_password;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		anyPageChangeListener = (LoginActivity) activity;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.register_fragment, null, false);
		initializedView();
		setUpActionBar();
		return view;
	}

	private void initializedView() {

		btn_login = (Button) view.findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);

		btn_sign_up = (Button) view.findViewById(R.id.btn_sign_up);
		btn_sign_up.setOnClickListener(this);

		et_password = (EditText) view.findViewById(R.id.et_password);
		et_password.addTextChangedListener(this);

		et_email = (EditText) view.findViewById(R.id.et_email);
		et_email.addTextChangedListener(this);

		et_cpf = (EditText) view.findViewById(R.id.et_cpf);
		et_cpf.addTextChangedListener(this);

		et_matricula = (EditText) view.findViewById(R.id.et_matricula);
		et_matricula.addTextChangedListener(this);

		et_orgao = (EditText) view.findViewById(R.id.et_autority);
		et_orgao.addTextChangedListener(this);

		et_name = (EditText) view.findViewById(R.id.et_name);
		et_name.addTextChangedListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			anyPageChangeListener.onPageChange(AppConstants.LOING_FRAGMENT_0);
			break;
		case R.id.btn_sign_up:
			userSingUp();
			break;
		}
	}

	private void setUpActionBar() {
		im_action_bar = (ImageButton) view.findViewById(R.id.im_btn_back);
		im_action_bar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				getActivity().finish();
			}
		});
	}

	private void userSingUp() {

	}

	@Override
	public void afterTextChanged(Editable arg0) {
		if (checkSingUpButtonVigible()) {
			btn_sign_up.setEnabled(true);
		} else {
			btn_sign_up.setEnabled(false);
		}

	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	private boolean checkSingUpButtonVigible() {

		if (et_name.getText().toString().equals("")) {
			return false;
		} else if (et_orgao.getText().toString().equals("")) {
			return false;
		} else if (et_matricula.getText().toString().equals("")) {
			return false;
		} else if (et_cpf.getText().toString().equals("")) {
			return false;
		} else if (et_email.getText().toString().equals("")) {
			return false;
		} else if (et_password.getText().toString().equals("")) {
			return false;
		} else {
			return true;
		}

	}

}
