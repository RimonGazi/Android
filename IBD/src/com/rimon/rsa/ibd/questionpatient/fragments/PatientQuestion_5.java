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

public class PatientQuestion_5 extends SherlockFragment implements
		OnItemSelectedListener, UpdateFragment {

	private boolean sp_26_check, sp_27_check, sp_28_check, sp_29_check,
			sp_30_check, sp_31_check, sp_32_check;
	private Spinner sp_question_26, sp_question_27, sp_question_28,
			sp_question_29, sp_question_30, sp_question_31, sp_question_32;
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

		sp_26_check = true;
		sp_27_check = true;
		sp_28_check = true;
		sp_29_check = true;
		sp_30_check = true;
		sp_31_check = true;
		sp_32_check = true;

		View view = inflater.inflate(R.layout.patient_q_5, null, false);

		layout = (RelativeLayout) view.findViewById(R.id.patient_q_5_layout);

		btn_next = (Button) view.findViewById(R.id.btn_fifth_next);
		btn_right = (Button) view.findViewById(R.id.btn_fifth_right);
		btn_back = (Button) view.findViewById(R.id.btn_fifth_back);
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}

		sp_question_26 = (Spinner) view.findViewById(R.id.sp_pq_26);
		sp_question_26.setOnItemSelectedListener(this);
		sp_question_26.setBackgroundResource(R.drawable.spinner_mid_state);

		sp_question_27 = (Spinner) view.findViewById(R.id.sp_pq_27);
		sp_question_27.setOnItemSelectedListener(this);
		sp_question_28 = (Spinner) view.findViewById(R.id.sp_pq_28);
		sp_question_28.setOnItemSelectedListener(this);
		sp_question_29 = (Spinner) view.findViewById(R.id.sp_pq_29);
		sp_question_29.setOnItemSelectedListener(this);
		sp_question_30 = (Spinner) view.findViewById(R.id.sp_pq_30);
		sp_question_30.setOnItemSelectedListener(this);
		sp_question_31 = (Spinner) view.findViewById(R.id.sp_pq_31);
		sp_question_31.setOnItemSelectedListener(this);
		sp_question_32 = (Spinner) view.findViewById(R.id.sp_pq_32);
		sp_question_32.setOnItemSelectedListener(this);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				ConstantValues.depression = String.valueOf(sp_question_26
						.getSelectedItemPosition()
						+ sp_question_27.getSelectedItemPosition()
						+ sp_question_28.getSelectedItemPosition()
						+ sp_question_29.getSelectedItemPosition()
						+ sp_question_30.getSelectedItemPosition()
						+ sp_question_31.getSelectedItemPosition()
						+ sp_question_32.getSelectedItemPosition());

				ConstantValues.question_26_value = sp_question_26
						.getSelectedItem().toString();
				ConstantValues.question_27_value = sp_question_27
						.getSelectedItem().toString();
				ConstantValues.question_28_value = sp_question_28
						.getSelectedItem().toString();
				ConstantValues.question_29_value = sp_question_29
						.getSelectedItem().toString();
				ConstantValues.question_30_value = sp_question_30
						.getSelectedItem().toString();
				ConstantValues.question_31_value = sp_question_31
						.getSelectedItem().toString();
				ConstantValues.question_32_value = sp_question_32
						.getSelectedItem().toString();

				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_SIXTH_PAGE);
				// initializedCustomSpinner();

			}
		});

		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_FOURTH_PAGE);

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
		sp_question_26.setAdapter(adpAdapter);
		sp_question_27.setAdapter(adpAdapter);
		sp_question_28.setAdapter(adpAdapter);
		sp_question_29.setAdapter(adpAdapter);
		sp_question_30.setAdapter(adpAdapter);
		sp_question_31.setAdapter(adpAdapter);
		sp_question_32.setAdapter(adpAdapter);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		checkNextButtonVissibility();
		switch (parent.getId()) {
		case R.id.sp_pq_26:
			if (sp_26_check) {
				sp_26_check = false;
				sp_question_26
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_27_check) {
					sp_question_27
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_28_check) {
					sp_question_28
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_29_check) {
					sp_question_29
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_30_check) {
					sp_question_30
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_31_check) {
					sp_question_31
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_32_check) {
					sp_question_32
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_27:
			if (sp_27_check) {
				sp_27_check = false;
				sp_question_27
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_28_check) {
					sp_question_28
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_29_check) {
					sp_question_29
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_30_check) {
					sp_question_30
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_31_check) {
					sp_question_31
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_32_check) {
					sp_question_32
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_26_check) {
					sp_question_26
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_28:
			if (sp_28_check) {
				sp_28_check = false;
				sp_question_28
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_29_check) {
					sp_question_29
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_30_check) {
					sp_question_30
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_31_check) {
					sp_question_31
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_32_check) {
					sp_question_32
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_26_check) {
					sp_question_26
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_27_check) {
					sp_question_27
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_29:
			if (sp_29_check) {
				sp_29_check = false;
				sp_question_29
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_30_check) {
					sp_question_30
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_31_check) {
					sp_question_31
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_32_check) {
					sp_question_32
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_26_check) {
					sp_question_26
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_27_check) {
					sp_question_27
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_28_check) {
					sp_question_28
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_30:
			if (sp_30_check) {
				sp_30_check = false;
				sp_question_30
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_31_check) {
					sp_question_31
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_32_check) {
					sp_question_32
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_26_check) {
					sp_question_26
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_27_check) {
					sp_question_27
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_28_check) {
					sp_question_28
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_29_check) {
					sp_question_29
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_31:
			if (sp_31_check) {
				sp_31_check = false;
				sp_question_31
						.setBackgroundResource(R.drawable.spinner_last_state);

				if (sp_32_check) {
					sp_question_32
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_26_check) {
					sp_question_26
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_27_check) {
					sp_question_27
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_28_check) {
					sp_question_28
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_29_check) {
					sp_question_29
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_30_check) {
					sp_question_30
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_32:
			if (sp_32_check) {
				sp_32_check = false;
				sp_question_32
						.setBackgroundResource(R.drawable.spinner_last_state);

				if (sp_26_check) {
					sp_question_26
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_27_check) {
					sp_question_27
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_28_check) {
					sp_question_28
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_29_check) {
					sp_question_29
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_30_check) {
					sp_question_30
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_31_check) {
					sp_question_31
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
		if ((sp_question_26.getSelectedItemPosition() >= 0 && sp_question_26
				.getSelectedItemPosition() < sp_question_26.getCount())
				&& (sp_question_27.getSelectedItemPosition() >= 0 && sp_question_27
						.getSelectedItemPosition() < sp_question_27.getCount())
				&& (sp_question_28.getSelectedItemPosition() >= 0 && sp_question_28
						.getSelectedItemPosition() < sp_question_28.getCount())
				&& (sp_question_29.getSelectedItemPosition() >= 0 && sp_question_29
						.getSelectedItemPosition() < sp_question_29.getCount())
				&& (sp_question_30.getSelectedItemPosition() >= 0 && sp_question_30
						.getSelectedItemPosition() < sp_question_30.getCount())
				&& (sp_question_31.getSelectedItemPosition() >= 0 && sp_question_31
						.getSelectedItemPosition() < sp_question_31.getCount())
				&& (sp_question_32.getSelectedItemPosition() >= 0 && sp_question_32
						.getSelectedItemPosition() < sp_question_32.getCount())) {

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
		sp_26_check = true;
		sp_27_check = true;
		sp_28_check = true;
		sp_29_check = true;
		sp_30_check = true;
		sp_31_check = true;
		sp_32_check = true;

		sp_question_26.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question_27.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_28.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_29.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_30.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_31.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question_32.setBackgroundResource(R.drawable.spinner_start_state);

	}

}
