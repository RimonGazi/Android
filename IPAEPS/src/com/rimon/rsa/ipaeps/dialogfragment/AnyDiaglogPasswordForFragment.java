package com.rimon.rsa.ipaeps.dialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpSettingModuleDBOpenHelper;

public class AnyDiaglogPasswordForFragment extends DialogFragment {
	private AnyDialogPasswordListener passwordListener;
	private PpSettingModuleDBOpenHelper dbOpenHelper;
	private InputMethodManager imm;
	private View viewTitle, viewContent;
	private EditText et_dialog;
	private Button btn_cancel, btn_ok;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		passwordListener = (AnyDialogPasswordListener) getTargetFragment();

	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		imm = (InputMethodManager) getActivity().getSystemService(
				Context.INPUT_METHOD_SERVICE);

		// title
		viewTitle = getActivity().getLayoutInflater().inflate(
				R.layout.custom_dialog_title, null);

		// content
		viewContent = getActivity().getLayoutInflater().inflate(
				R.layout.custom_dialog_content, null);
		et_dialog = (EditText) viewContent.findViewById(R.id.et_dialog);

		btn_cancel = (Button) viewContent.findViewById(R.id.btn_cencel);
		btn_ok = (Button) viewContent.findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (imm.isAcceptingText()) {
					imm.hideSoftInputFromWindow(getActivity().getCurrentFocus()
							.getWindowToken(), 0);
				}

				// imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
				String password = et_dialog.getText().toString();
				dbOpenHelper = DatabaseCreator
						.getPpSettingModuleDBOpenHelper(getActivity());
				String db_password = dbOpenHelper.getPassword();
				if ((db_password.length() == password.length())
						&& (db_password.equals(password))) {

					passwordListener.onClickPasswordDialog(true);
				} else {
					Toast.makeText(
							getActivity(),
							getActivity().getResources().getString(
									R.string.invalid_password),
							Toast.LENGTH_LONG).show();
					passwordListener.onClickPasswordDialog(false);
				}
				getDialog().dismiss();
			}

		});

		btn_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (imm.isAcceptingText()) {
					imm.hideSoftInputFromWindow(getActivity().getCurrentFocus()
							.getWindowToken(), 0);
				}
				getDialog().dismiss();
				passwordListener.onClickPasswordDialog(false);
			}
		});

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),
				AlertDialog.THEME_HOLO_LIGHT);

		builder.setCustomTitle(viewTitle);
		builder.setView(viewContent);

		builder.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(DialogInterface arg0, int arg1, KeyEvent arg2) {
				if (imm.isAcceptingText()) {
					imm.hideSoftInputFromWindow(getActivity().getCurrentFocus()
							.getWindowToken(), 0);
				}
				passwordListener.onClickPasswordDialog(false);
				return false;
			}
		});
		builder.setIcon(com.rimon.rsa.ipaeps.R.drawable.password_icon);

		return builder.create();
	}
}
