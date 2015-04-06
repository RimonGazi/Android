package com.rimon.rsa.ipaeps.dialogfragment;

import java.util.Arrays;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TextView;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.rsa.adapter.AnyArrayAdapter;

public class AnyDiaglogFragmentForFragment extends DialogFragment {

	private int array_id;
	private String previous_selection;
	private int view_id;
	private int title_id;
	private List<String> list;
	private int selected;
	private TextView viewTitle;
	private AnyArrayAdapter<String> adapter;
	private AnyDialogListener dialogListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		dialogListener = (AnyDialogListener) getTargetFragment();

	}

	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		dialogListener.OnDialogCancel();

	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//
		viewTitle = (TextView) getActivity().getLayoutInflater().inflate(
				R.layout.custom_any_text_view, null);

		array_id = getArguments().getInt(AppConstants.DIAGLOG_ARRAY_ID);
		view_id = getArguments().getInt(AppConstants.DIAGLOG_VIEW_ID);
		title_id = getArguments().getInt(AppConstants.DIAGLOG_TITLE_ID);

		viewTitle.setText(title_id);

		previous_selection = getArguments().getString(
				AppConstants.DIAGLOG_PREVIOUS_SELECTION);
		list = Arrays.asList(getResources().getStringArray(array_id));
		selected = list.indexOf(previous_selection);
		adapter = new AnyArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_single_choice,
				android.R.id.text1, list);

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),
				AlertDialog.THEME_HOLO_LIGHT);
		// Set the dialog title
		builder.setCustomTitle(viewTitle);

		builder.setSingleChoiceItems(adapter, selected,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int location) {

						dialogListener.onDialogSingleItemSelected(view_id,
								list.get(location));
						dismiss();

					}
				});
		return builder.create();
	}

	@Override
	public View getView() {
		// TODO Auto-generated method stub
		return super.getView();
	}

}
