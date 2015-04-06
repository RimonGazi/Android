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

public class PatientQuestion_3 extends SherlockFragment implements
		OnItemSelectedListener, UpdateFragment {
	private boolean sp_12_check, sp_13_check, sp_14_check, sp_15_check,
			sp_16_check, sp_17_check, sp_18_check;
	private CustomSpinner sp_question12, sp_question13, sp_question14,
			sp_question15, sp_question16, sp_question17, sp_question18;
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

		sp_12_check = true;
		sp_13_check = true;
		sp_14_check = true;
		sp_15_check = true;
		sp_16_check = true;
		sp_17_check = true;
		sp_18_check = true;
		View view = inflater.inflate(R.layout.patient_q_3, null, false);

		layout = (RelativeLayout) view.findViewById(R.id.patient_q_3_layout);

		btn_next = (Button) view.findViewById(R.id.btn_third_next);
		btn_right = (Button) view.findViewById(R.id.btn_third_right);
		btn_back = (Button) view.findViewById(R.id.btn_third_back);
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}

		sp_question12 = (CustomSpinner) view.findViewById(R.id.sp_pq_12);
		sp_question12.setOnItemSelectedListener(this);
		sp_question12.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question13 = (CustomSpinner) view.findViewById(R.id.sp_pq_13);
		sp_question13.setOnItemSelectedListener(this);
		sp_question14 = (CustomSpinner) view.findViewById(R.id.sp_pq_14);
		sp_question14.setOnItemSelectedListener(this);
		sp_question15 = (CustomSpinner) view.findViewById(R.id.sp_pq_15);
		sp_question15.setOnItemSelectedListener(this);
		sp_question16 = (CustomSpinner) view.findViewById(R.id.sp_pq_16);
		sp_question16.setOnItemSelectedListener(this);
		sp_question17 = (CustomSpinner) view.findViewById(R.id.sp_pq_17);
		sp_question17.setOnItemSelectedListener(this);
		sp_question18 = (CustomSpinner) view.findViewById(R.id.sp_pq_18);
		sp_question18.setOnItemSelectedListener(this);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ConstantValues.stress = String.valueOf(sp_question12
						.getSelectedItemPosition()
						+ sp_question13.getSelectedItemPosition()
						+ sp_question14.getSelectedItemPosition()
						+ sp_question15.getSelectedItemPosition()
						+ sp_question16.getSelectedItemPosition()
						+ sp_question17.getSelectedItemPosition()
						+ sp_question18.getSelectedItemPosition());

				ConstantValues.question_12_value = sp_question12
						.getSelectedItem().toString();
				ConstantValues.question_13_value = sp_question13
						.getSelectedItem().toString();
				ConstantValues.question_14_value = sp_question14
						.getSelectedItem().toString();
				ConstantValues.question_15_value = sp_question15
						.getSelectedItem().toString();
				ConstantValues.question_16_value = sp_question16
						.getSelectedItem().toString();
				ConstantValues.question_17_value = sp_question17
						.getSelectedItem().toString();
				ConstantValues.question_18_value = sp_question18
						.getSelectedItem().toString();

				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_FOURTH_PAGE);

			}
		});

		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_SECOND_PAGE);

			}
		});

		initializedCustomSpinner();

		return view;
	}

	private void initializedCustomSpinner() {

		CustomArrayAdapter<String> adpAdapter = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.array_12_to_32));
		adpAdapter.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question12.setAdapter(adpAdapter);
		sp_question13.setAdapter(adpAdapter);
		sp_question14.setAdapter(adpAdapter);
		sp_question15.setAdapter(adpAdapter);
		sp_question16.setAdapter(adpAdapter);
		sp_question17.setAdapter(adpAdapter);
		sp_question18.setAdapter(adpAdapter);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		checkNextButtonVissibility();

		switch (parent.getId()) {
		case R.id.sp_pq_12:
			if (sp_12_check) {
				sp_12_check = false;
				sp_question12
						.setBackgroundResource(R.drawable.spinner_last_state);

				if (sp_13_check) {
					sp_question13
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_14_check) {
					sp_question14
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_15_check) {
					sp_question15
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_16_check) {
					sp_question16
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_17_check) {
					sp_question17
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_18_check) {
					sp_question18
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
			}

			break;

		case R.id.sp_pq_13:
			if (sp_13_check) {
				sp_13_check = false;
				sp_question13
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_14_check) {
					sp_question14
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_15_check) {
					sp_question15
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_16_check) {
					sp_question16
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_17_check) {
					sp_question17
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_18_check) {
					sp_question18
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_12_check) {
					sp_question12
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_14:
			if (sp_14_check) {
				sp_14_check = false;
				sp_question14
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_15_check) {
					sp_question15
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_16_check) {
					sp_question16
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_17_check) {
					sp_question17
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_18_check) {
					sp_question18
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_12_check) {
					sp_question12
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_13_check) {
					sp_question13
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
			}
			break;

		case R.id.sp_pq_15:
			if (sp_15_check) {
				sp_15_check = false;
				sp_question15
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_16_check) {
					sp_question16
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_17_check) {
					sp_question17
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_18_check) {
					sp_question18
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_12_check) {
					sp_question12
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_13_check) {
					sp_question13
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_16_check) {
					sp_question16
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_16:
			if (sp_16_check) {
				sp_16_check = false;
				sp_question16
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_17_check) {
					sp_question17
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_18_check) {
					sp_question18
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_12_check) {
					sp_question12
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_13_check) {
					sp_question13
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_14_check) {
					sp_question14
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_15_check) {
					sp_question15
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_17:
			if (sp_17_check) {
				sp_17_check = false;
				sp_question17
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_18_check) {
					sp_question18
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_12_check) {
					sp_question12
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_13_check) {
					sp_question13
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_14_check) {
					sp_question14
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_15_check) {
					sp_question15
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_16_check) {
					sp_question16
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_18:
			if (sp_18_check) {
				sp_18_check = false;
				sp_question18
						.setBackgroundResource(R.drawable.spinner_last_state);

				if (sp_12_check) {
					sp_question12
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_13_check) {
					sp_question13
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_14_check) {
					sp_question14
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_15_check) {
					sp_question15
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_16_check) {
					sp_question16
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_17_check) {
					sp_question17
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	private void checkNextButtonVissibility() {
		if ((sp_question12.getSelectedItemPosition() >= 0 && sp_question12
				.getSelectedItemPosition() < sp_question12.getCount())
				&& (sp_question13.getSelectedItemPosition() >= 0 && sp_question13
						.getSelectedItemPosition() < sp_question13.getCount())
				&& (sp_question14.getSelectedItemPosition() >= 0 && sp_question14
						.getSelectedItemPosition() < sp_question14.getCount())
				&& (sp_question15.getSelectedItemPosition() >= 0 && sp_question15
						.getSelectedItemPosition() < sp_question15.getCount())
				&& (sp_question16.getSelectedItemPosition() >= 0 && sp_question16
						.getSelectedItemPosition() < sp_question16.getCount())
				&& (sp_question17.getSelectedItemPosition() >= 0 && sp_question17
						.getSelectedItemPosition() < sp_question17.getCount())
				&& (sp_question18.getSelectedItemPosition() >= 0 && sp_question18
						.getSelectedItemPosition() < sp_question18.getCount())) {

			if (btn_right.getParent() == null) {
				layout.addView(btn_right);
			}
			if (btn_next.getParent() == null) {
				layout.addView(btn_next);
			}

		}
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

		sp_question12.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question13.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question14.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question15.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question16.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question17.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question18.setBackgroundResource(R.drawable.spinner_start_state);

		sp_12_check = true;
		sp_13_check = true;
		sp_14_check = true;
		sp_15_check = true;
		sp_16_check = true;
		sp_17_check = true;
		sp_18_check = true;

	}

}
