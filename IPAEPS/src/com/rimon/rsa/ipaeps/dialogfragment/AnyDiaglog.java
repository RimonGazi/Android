package com.rimon.rsa.ipaeps.dialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TextView;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;

public class AnyDiaglog extends DialogFragment {
	private AnyDialogPasswordListener anyDialogListener;
	private TextView titleView, titleMgs;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		anyDialogListener = (AnyDialogPasswordListener) getTargetFragment();

	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		titleView = (TextView) getActivity().getLayoutInflater().inflate(
				R.layout.custom_title_text_view_diaglog, null);
		titleMgs = (TextView) getActivity().getLayoutInflater().inflate(
				R.layout.custom_any_text_view, null);

		titleView.setCompoundDrawablesWithIntrinsicBounds(getArguments()
				.getInt(AppConstants.ANY_DIAGLOT_ICON), 0, 0, 0);

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),
				AlertDialog.THEME_HOLO_LIGHT);

		titleMgs.setText(getArguments().getString(
				AppConstants.ANY_DIAGLOT_MESSAGE));
		builder.setView(titleMgs);

		titleView.setText(getArguments().getString(
				AppConstants.ANY_DIAGLOT_TITLE));

		builder.setCustomTitle(titleView);

		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				anyDialogListener.onClickPasswordDialog(true);
				dialog.dismiss();

			}
		});
		return builder.create();
	}
}
