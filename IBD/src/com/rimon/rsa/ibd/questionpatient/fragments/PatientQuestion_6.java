package com.rimon.rsa.ibd.questionpatient.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.OnSwitchClickListener;
import com.rimon.rsa.ibd.main.StartActivityIBD;
import com.rimon.rsa.mental.R;

public class PatientQuestion_6 extends SherlockFragment implements
		OnItemSelectedListener, UpdateFragment {

	private boolean sp_33_check, sp_34_check, sp_35_check, sp_36_check,
			sp_37_check;

	private Spinner sp_question33, sp_question34, sp_question35, sp_question36,
			sp_question37;
	private RelativeLayout layout;
	private Button btn_next, btn_right, btn_back;
	private OnSwitchClickListener listener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (StartActivityIBD) getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		sp_33_check = true;
		sp_34_check = true;
		sp_35_check = true;
		sp_36_check = true;
		sp_37_check = true;

		View view = inflater.inflate(R.layout.patient_q_6, null, false);

		layout = (RelativeLayout) view.findViewById(R.id.patient_q_6_layout);

		btn_next = (Button) view.findViewById(R.id.btn_sixth_next);
		btn_right = (Button) view.findViewById(R.id.btn_sixth_right);
		btn_back = (Button) view.findViewById(R.id.btn_sixth_back);
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}
		sp_question33 = (Spinner) view.findViewById(R.id.sp_pq_33);
		sp_question33.setOnItemSelectedListener(this);
		sp_question33.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question34 = (Spinner) view.findViewById(R.id.sp_pq_34);
		sp_question34.setOnItemSelectedListener(this);
		sp_question35 = (Spinner) view.findViewById(R.id.sp_pq_35);
		sp_question35.setOnItemSelectedListener(this);
		sp_question36 = (Spinner) view.findViewById(R.id.sp_pq_36);
		sp_question36.setOnItemSelectedListener(this);
		sp_question37 = (Spinner) view.findViewById(R.id.sp_pq_37);
		sp_question37.setOnItemSelectedListener(this);
		initializedCustomSpinner();

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				ConstantValues.question_33_value = sp_question33
						.getSelectedItem().toString();
				ConstantValues.question_34_value = sp_question34
						.getSelectedItem().toString();
				ConstantValues.question_35_value = sp_question35
						.getSelectedItem().toString();
				ConstantValues.question_36_value = sp_question36
						.getSelectedItem().toString();
				ConstantValues.question_37_value = sp_question37
						.getSelectedItem().toString();

				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_HELP_1);

			}
		});

		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_FIFTH_PAGE);

			}
		});

		return view;
	}

	private void initializedCustomSpinner() {

		CustomArrayAdapter<String> adpAdapter33_35 = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.array_33_to_35));
		adpAdapter33_35.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question33.setAdapter(adpAdapter33_35);
		sp_question34.setAdapter(adpAdapter33_35);
		sp_question35.setAdapter(adpAdapter33_35);
		CustomArrayAdapter<String> adpAdapter36_37 = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.array_36_to_37));
		adpAdapter36_37.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question36.setAdapter(adpAdapter36_37);
		sp_question37.setAdapter(adpAdapter36_37);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		checkNextButtonVissibility();

		switch (parent.getId()) {
		case R.id.sp_pq_33:
			if (sp_33_check) {
				sp_33_check = false;
				sp_question33
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_34_check) {
					sp_question34
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_35_check) {
					sp_question35
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_36_check) {
					sp_question36
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_37_check) {
					sp_question37
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_34:
			if (sp_34_check) {
				sp_34_check = false;
				sp_question34
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_35_check) {
					sp_question35
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_36_check) {
					sp_question36
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_37_check) {
					sp_question37
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_33_check) {
					sp_question33
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_35:
			if (sp_35_check) {
				sp_35_check = false;
				sp_question35
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_36_check) {
					sp_question36
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_37_check) {
					sp_question37
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_33_check) {
					sp_question33
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_34_check) {
					sp_question34
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
			}
			break;

		case R.id.sp_pq_36:
			if (sp_36_check) {
				sp_36_check = false;
				sp_question36
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_37_check) {
					sp_question37
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_33_check) {
					sp_question33
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_34_check) {
					sp_question34
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_35_check) {
					sp_question35
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_37:
			if (sp_37_check) {
				sp_37_check = false;
				sp_question37
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_33_check) {
					sp_question33
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_34_check) {
					sp_question34
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_35_check) {
					sp_question35
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_36_check) {
					sp_question36
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		}

	}

	private void checkNextButtonVissibility() {
		if ((sp_question33.getSelectedItemPosition() >= 0 && sp_question33
				.getSelectedItemPosition() < sp_question33.getCount())
				&& (sp_question34.getSelectedItemPosition() >= 0 && sp_question34
						.getSelectedItemPosition() < sp_question34.getCount())
				&& (sp_question35.getSelectedItemPosition() >= 0 && sp_question35
						.getSelectedItemPosition() < sp_question35.getCount())
				&& (sp_question36.getSelectedItemPosition() >= 0 && sp_question36
						.getSelectedItemPosition() < sp_question36.getCount())
				&& (sp_question37.getSelectedItemPosition() >= 0 && sp_question37
						.getSelectedItemPosition() < sp_question37.getCount())) {

			if (btn_right.getParent() == null) {
				layout.addView(btn_right);
			}
			if (btn_next.getParent() == null) {
				layout.addView(btn_next);
			}
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	@Override
	public void Update() {
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}
		initializedCustomSpinner();
		sp_33_check = true;
		sp_34_check = true;
		sp_35_check = true;
		sp_36_check = true;
		sp_37_check = true;
		sp_question33.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question34.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question35.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question36.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question37.setBackgroundResource(R.drawable.spinner_start_state);

	}
}
