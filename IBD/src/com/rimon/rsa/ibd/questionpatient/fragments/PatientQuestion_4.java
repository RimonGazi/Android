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

public class PatientQuestion_4 extends SherlockFragment implements
		OnItemSelectedListener, UpdateFragment {

	private boolean sp_19_check, sp_20_check, sp_21_check, sp_22_check,
			sp_23_check, sp_24_check, sp_25_check;
	private CustomSpinner sp_question_19, sp_question_20, sp_question_21,
			sp_question_22, sp_question_23, sp_question_24, sp_question_25;
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

		sp_19_check = true;
		sp_20_check = true;
		sp_21_check = true;
		sp_22_check = true;
		sp_23_check = true;
		sp_24_check = true;
		sp_25_check = true;

		View view = inflater.inflate(R.layout.patient_q_4, null, false);
		layout = (RelativeLayout) view.findViewById(R.id.patient_q_4_layout);
		btn_next = (Button) view.findViewById(R.id.btn_fourth_next);
		btn_right = (Button) view.findViewById(R.id.btn_fourth_right);
		btn_back = (Button) view.findViewById(R.id.btn_fourth_back);
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}

		sp_question_19 = (CustomSpinner) view.findViewById(R.id.sp_pq_19);
		sp_question_19.setOnItemSelectedListener(this);
		sp_question_19.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question_20 = (CustomSpinner) view.findViewById(R.id.sp_pq_20);
		sp_question_20.setOnItemSelectedListener(this);
		sp_question_21 = (CustomSpinner) view.findViewById(R.id.sp_pq_21);
		sp_question_21.setOnItemSelectedListener(this);
		sp_question_22 = (CustomSpinner) view.findViewById(R.id.sp_pq_22);
		sp_question_22.setOnItemSelectedListener(this);
		sp_question_23 = (CustomSpinner) view.findViewById(R.id.sp_pq_23);
		sp_question_23.setOnItemSelectedListener(this);
		sp_question_24 = (CustomSpinner) view.findViewById(R.id.sp_pq_24);
		sp_question_24.setOnItemSelectedListener(this);
		sp_question_25 = (CustomSpinner) view.findViewById(R.id.sp_pq_25);
		sp_question_25.setOnItemSelectedListener(this);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ConstantValues.anxiety = String.valueOf(sp_question_19
						.getSelectedItemPosition()
						+ sp_question_20.getSelectedItemPosition()
						+ sp_question_21.getSelectedItemPosition()
						+ sp_question_22.getSelectedItemPosition()
						+ sp_question_23.getSelectedItemPosition()
						+ sp_question_24.getSelectedItemPosition()
						+ sp_question_25.getSelectedItemPosition());

				ConstantValues.question_19_value = sp_question_19
						.getSelectedItem().toString();
				ConstantValues.question_20_value = sp_question_20
						.getSelectedItem().toString();
				ConstantValues.question_21_value = sp_question_21
						.getSelectedItem().toString();
				ConstantValues.question_22_value = sp_question_22
						.getSelectedItem().toString();
				ConstantValues.question_23_value = sp_question_23
						.getSelectedItem().toString();
				ConstantValues.question_24_value = sp_question_24
						.getSelectedItem().toString();
				ConstantValues.question_25_value = sp_question_25
						.getSelectedItem().toString();
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_FIFTH_PAGE);

			}
		});

		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_THIRD_PAGE);

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
		sp_question_19.setAdapter(adpAdapter);
		sp_question_20.setAdapter(adpAdapter);
		sp_question_21.setAdapter(adpAdapter);
		sp_question_22.setAdapter(adpAdapter);
		sp_question_23.setAdapter(adpAdapter);
		sp_question_24.setAdapter(adpAdapter);
		sp_question_25.setAdapter(adpAdapter);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		checkNextButtonVissibility();

		switch (parent.getId()) {
		case R.id.sp_pq_19:
			if (sp_19_check) {
				sp_19_check = false;
				sp_question_19
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_20_check) {
					sp_question_20
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_21_check) {
					sp_question_21
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_22_check) {
					sp_question_22
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_23_check) {
					sp_question_23
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_24_check) {
					sp_question_24
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_25_check) {
					sp_question_25
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_20:
			if (sp_20_check) {
				sp_20_check = false;
				sp_question_20
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_21_check) {
					sp_question_21
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_22_check) {
					sp_question_22
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_23_check) {
					sp_question_23
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_24_check) {
					sp_question_24
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_25_check) {
					sp_question_25
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_19_check) {
					sp_question_19
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_21:
			if (sp_21_check) {
				sp_21_check = false;
				sp_question_21
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_22_check) {
					sp_question_22
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_23_check) {
					sp_question_23
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_24_check) {
					sp_question_24
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_25_check) {
					sp_question_25
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_19_check) {
					sp_question_19
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_20_check) {
					sp_question_20
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_22:
			if (sp_22_check) {
				sp_22_check = false;
				sp_question_22
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_23_check) {
					sp_question_23
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_24_check) {
					sp_question_24
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_25_check) {
					sp_question_25
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_19_check) {
					sp_question_19
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_20_check) {
					sp_question_20
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_21_check) {
					sp_question_21
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_23:
			if (sp_23_check) {
				sp_23_check = false;
				sp_question_23
						.setBackgroundResource(R.drawable.spinner_last_state);
				sp_question_24
						.setBackgroundResource(R.drawable.spinner_mid_state);

				if (sp_24_check) {
					sp_question_24
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_25_check) {
					sp_question_25
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_19_check) {
					sp_question_19
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_20_check) {
					sp_question_20
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_21_check) {
					sp_question_21
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_24_check) {
					sp_question_24
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_24:
			if (sp_24_check) {
				sp_24_check = false;
				sp_question_24
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_25_check) {
					sp_question_25
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_19_check) {
					sp_question_19
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_20_check) {
					sp_question_20
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_21_check) {
					sp_question_21
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_22_check) {
					sp_question_22
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_23_check) {
					sp_question_23
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_25:
			if (sp_25_check) {
				sp_25_check = false;
				sp_question_25
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_19_check) {
					sp_question_19
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_20_check) {
					sp_question_20
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_21_check) {
					sp_question_21
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_22_check) {
					sp_question_22
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_23_check) {
					sp_question_23
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_24_check) {
					sp_question_24
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
		if ((sp_question_19.getSelectedItemPosition() >= 0 && sp_question_19
				.getSelectedItemPosition() < sp_question_19.getCount())
				&& (sp_question_20.getSelectedItemPosition() >= 0 && sp_question_20
						.getSelectedItemPosition() < sp_question_20.getCount())
				&& (sp_question_21.getSelectedItemPosition() >= 0 && sp_question_21
						.getSelectedItemPosition() < sp_question_21.getCount())
				&& (sp_question_22.getSelectedItemPosition() >= 0 && sp_question_22
						.getSelectedItemPosition() < sp_question_22.getCount())
				&& (sp_question_23.getSelectedItemPosition() >= 0 && sp_question_23
						.getSelectedItemPosition() < sp_question_23.getCount())
				&& (sp_question_24.getSelectedItemPosition() >= 0 && sp_question_24
						.getSelectedItemPosition() < sp_question_24.getCount())
				&& (sp_question_25.getSelectedItemPosition() >= 0 && sp_question_25
						.getSelectedItemPosition() < sp_question_25.getCount())) {

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

		sp_19_check = true;
		sp_20_check = true;
		sp_21_check = true;
		sp_22_check = true;
		sp_23_check = true;
		sp_24_check = true;
		sp_25_check = true;

		sp_question_19.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question_20.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_21.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_22.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_23.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_24.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_25.setBackgroundResource(R.drawable.spinner_start_state);

	}

}
