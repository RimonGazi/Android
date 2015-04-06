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

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.OnSwitchClickListener;
import com.rimon.rsa.ibd.main.StartActivityIBD;
import com.rimon.rsa.mental.R;

public class PatientQuestion_1 extends SherlockFragment implements
		OnItemSelectedListener, UpdateFragment {

	private CustomSpinner sp_question1, sp_question2, sp_question3,
			sp_question4, sp_question5;
	private boolean sp_1_check, sp_2_check, sp_3_check, sp_4_check, sp_5_check;
	private RelativeLayout layout;
	private Button btn_next, btn_right;
	private OnSwitchClickListener listener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (StartActivityIBD) getActivity();
	//	Toast.makeText(getActivity(), "aaaaaaa", Toast.LENGTH_SHORT).show();
	//	super.onDetach();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		sp_1_check = true;
		sp_2_check = true;
		sp_3_check = true;
		sp_4_check = true;
		sp_5_check = true;

		View view = inflater.inflate(R.layout.patient_q_1, null, false);
		layout = (RelativeLayout) view.findViewById(R.id.patient_q_1_layout);

		btn_next = (Button) view.findViewById(R.id.btn_first_next);
		btn_right = (Button) view.findViewById(R.id.btn_first_right);
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}

		sp_question1 = (CustomSpinner) view.findViewById(R.id.sp_pq_1);
		sp_question1.setOnItemSelectedListener(this);
		sp_question2 = (CustomSpinner) view.findViewById(R.id.sp_pq_2);
		sp_question2.setOnItemSelectedListener(this);
		sp_question3 = (CustomSpinner) view.findViewById(R.id.sp_pq_3);
		sp_question3.setOnItemSelectedListener(this);
		sp_question4 = (CustomSpinner) view.findViewById(R.id.sp_pq_4);
		sp_question4.setOnItemSelectedListener(this);
		sp_question5 = (CustomSpinner) view.findViewById(R.id.sp_pq_5);
		sp_question5.setOnItemSelectedListener(this);
		sp_question1.setBackgroundResource(R.drawable.spinner_mid_state);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ConstantValues.question_1_value = sp_question1
						.getSelectedItem().toString();
				ConstantValues.question_2_value = sp_question2
						.getSelectedItem().toString();
				ConstantValues.question_3_value = sp_question3
						.getSelectedItem().toString();
				ConstantValues.question_4_value = sp_question4
						.getSelectedItem().toString();
				ConstantValues.question_5_value = sp_question5
						.getSelectedItem().toString();
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_SECOND_PAGE);

			}
		});
		initializedCustomSpinnerAge();
		initializedCustomSpinnerGender();
		initializedCustomSpinnerCondition();
		initializedCustomSpinnerIbdDiagnosis();
		initializedCustomSpinnerPastThreeMonth();

		return view;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		checkNextButtonVisibility();

		switch (parent.getId()) {
		case R.id.sp_pq_1:
			if (sp_1_check) {
				sp_question1
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_2_check) {
					sp_question2
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_3_check) {
					sp_question3
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_4_check) {
					sp_question4
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_5_check) {
					sp_question5
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
				sp_1_check = false;
			}
			break;

		case R.id.sp_pq_2:
			if (sp_2_check) {
				sp_2_check = false;
				sp_question2
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_3_check) {
					sp_question3
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_4_check) {
					sp_question4
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_5_check) {
					sp_question5
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_1_check) {
					sp_question1
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
			}
			break;

		case R.id.sp_pq_3:
			if (sp_3_check) {
				sp_3_check = false;
				sp_question3
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_4_check) {
					sp_question4
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_5_check) {
					sp_question5
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_1_check) {
					sp_question1
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_2_check) {
					sp_question2
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
			}
			break;

		case R.id.sp_pq_4:
			if (sp_4_check) {
				sp_4_check = false;
				sp_question4
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_5_check) {
					sp_question5
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_3_check) {
					sp_question3
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_2_check) {
					sp_question2
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_1_check) {
					sp_question1
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
			}
			break;
		case R.id.sp_pq_5:
			if (sp_5_check) {
				sp_5_check = false;
				sp_question5
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_1_check) {
					sp_question1
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_2_check) {
					sp_question2
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_3_check) {
					sp_question3
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_4_check) {
					sp_question4
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
			}
			break;

		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

	public void initializedCustomSpinnerAge() {

		CustomArrayAdapter<String> adpAdapter = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.age));

		adpAdapter.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question1.setAdapter(adpAdapter);

	}

	private void initializedCustomSpinnerGender() {

		CustomArrayAdapter<String> adpAdapter = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.gender));

		adpAdapter.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question2.setAdapter(adpAdapter);

	}

	private void initializedCustomSpinnerCondition() {

		CustomArrayAdapter<String> adpAdapter = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.condition));

		adpAdapter.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question3.setAdapter(adpAdapter);

	}

	private void initializedCustomSpinnerIbdDiagnosis() {

		CustomArrayAdapter<String> adpAdapter = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.diagnosed_with_ibd));

		adpAdapter.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question4.setAdapter(adpAdapter);

	}

	private void initializedCustomSpinnerPastThreeMonth() {

		CustomArrayAdapter<String> adpAdapter = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.past_3_month_ibd));

		adpAdapter.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question5.setAdapter(adpAdapter);

	}

	private void checkNextButtonVisibility() {
		if ((sp_question1.getSelectedItemPosition() >= 0 && sp_question1
				.getSelectedItemPosition() < sp_question1.getCount())
				&& (sp_question2.getSelectedItemPosition() >= 0 && sp_question2
						.getSelectedItemPosition() < sp_question2.getCount())
				&& (sp_question3.getSelectedItemPosition() >= 0 && sp_question3
						.getSelectedItemPosition() < sp_question3.getCount())
				&& (sp_question5.getSelectedItemPosition() >= 0 && sp_question5
						.getSelectedItemPosition() < sp_question5.getCount())
				&& (sp_question4.getSelectedItemPosition() >= 0 && sp_question4
						.getSelectedItemPosition() < sp_question4.getCount())) {

			if (btn_right.getParent() == null) {
				layout.addView(btn_right);
			}
			if (btn_next.getParent() == null) {
				layout.addView(btn_next);
			}

		}

	}

	@Override
	public void onDetach() {
		// Toast.makeText(getActivity(), "ddddddddd",
		// Toast.LENGTH_SHORT).show();
		super.onDetach();
	}

	@Override
	public void Update() {
		// Toast.makeText(getActivity(), "ppppppppppp1",
		// Toast.LENGTH_LONG).show();
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}
		initializedCustomSpinnerAge();
		initializedCustomSpinnerGender();
		initializedCustomSpinnerCondition();
		initializedCustomSpinnerIbdDiagnosis();
		initializedCustomSpinnerPastThreeMonth();
		sp_question1.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question2.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question3.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question4.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question5.setBackgroundResource(R.drawable.spinner_start_state);

		sp_1_check = true;
		sp_2_check = true;
		sp_3_check = true;
		sp_4_check = true;
		sp_5_check = true;

	}
}
