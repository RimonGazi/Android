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

;
public class PatientQuestion_2 extends SherlockFragment implements
		OnItemSelectedListener, UpdateFragment {
	private boolean sp_6_check, sp_7_check, sp_8_check, sp_9_check,
			sp_10_check, sp_11_check;

	private CustomSpinner sp_question6, sp_question7, sp_question8,
			sp_question9, sp_question10, sp_question11;
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
		View view = inflater.inflate(R.layout.patient_q_2, null, false);
		sp_6_check = true;
		sp_7_check = true;
		sp_8_check = true;
		sp_9_check = true;
		sp_10_check = true;
		sp_11_check = true;

		sp_question6 = (CustomSpinner) view.findViewById(R.id.sp_pq_6);
		sp_question6.setOnItemSelectedListener(this);
		sp_question6.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question7 = (CustomSpinner) view.findViewById(R.id.sp_pq_7);
		sp_question7.setOnItemSelectedListener(this);
		sp_question8 = (CustomSpinner) view.findViewById(R.id.sp_pq_8);
		sp_question8.setOnItemSelectedListener(this);
		sp_question9 = (CustomSpinner) view.findViewById(R.id.sp_pq_9);
		sp_question9.setOnItemSelectedListener(this);
		sp_question10 = (CustomSpinner) view.findViewById(R.id.sp_pq_10);
		sp_question10.setOnItemSelectedListener(this);
		sp_question11 = (CustomSpinner) view.findViewById(R.id.sp_pq_11);
		sp_question11.setOnItemSelectedListener(this);

		layout = (RelativeLayout) view.findViewById(R.id.patient_q_2_layout);

		btn_next = (Button) view.findViewById(R.id.btn_second_next);
		btn_right = (Button) view.findViewById(R.id.btn_second_right);
		btn_back = (Button) view.findViewById(R.id.btn_second_back);
		if (btn_next.getParent() != null) {
			layout.removeView(btn_next);
		}
		if (btn_right.getParent() != null) {
			layout.removeView(btn_right);
		}
		initializedCustomSpinner();

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				ConstantValues.question_6_value = sp_question6
						.getSelectedItem().toString();
				ConstantValues.question_7_value = sp_question7
						.getSelectedItem().toString();
				ConstantValues.question_8_value = sp_question8
						.getSelectedItem().toString();
				ConstantValues.question_9_value = sp_question9
						.getSelectedItem().toString();
				ConstantValues.question_10_value = sp_question10
						.getSelectedItem().toString();
				ConstantValues.question_11_value = sp_question11
						.getSelectedItem().toString();

				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_THIRD_PAGE);
				// initializedCustomSpinner();

			}
		});
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_FIRST_PAGE);

			}
		});
		return view;
	}

	private void initializedCustomSpinner() {

		CustomArrayAdapter<String> adpAdapter = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.array_6_to_10));

		adpAdapter.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question6.setAdapter(adpAdapter);
		sp_question7.setAdapter(adpAdapter);
		sp_question8.setAdapter(adpAdapter);
		sp_question9.setAdapter(adpAdapter);
		sp_question10.setAdapter(adpAdapter);

		CustomArrayAdapter<String> adpAdapter_11 = new CustomArrayAdapter<String>(
				getActivity(), getActivity().getResources().getStringArray(
						R.array.array_11));

		adpAdapter_11.setDropDownViewResource(R.drawable.coustom_prompt);
		sp_question11.setAdapter(adpAdapter_11);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int arg2,
			long arg3) {
		checkNextButtonVisibility();
		switch (parent.getId()) {
		case R.id.sp_pq_6:
			if (sp_6_check) {
				sp_6_check = false;
				sp_question6
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_7_check) {
					sp_question7
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_8_check) {
					sp_question8
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_9_check) {
					sp_question9
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_10_check) {
					sp_question10
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_11_check) {
					sp_question11
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_7:
			if (sp_7_check) {
				sp_7_check = false;
				sp_question7
						.setBackgroundResource(R.drawable.spinner_last_state);

			}
			if (sp_8_check) {
				sp_question8
						.setBackgroundResource(R.drawable.spinner_mid_state);
			} else if (sp_9_check) {
				sp_question9
						.setBackgroundResource(R.drawable.spinner_mid_state);
			} else if (sp_10_check) {
				sp_question10
						.setBackgroundResource(R.drawable.spinner_mid_state);
			} else if (sp_11_check) {
				sp_question11
						.setBackgroundResource(R.drawable.spinner_mid_state);
			} else if (sp_6_check) {
				sp_question6
						.setBackgroundResource(R.drawable.spinner_mid_state);

			}
			break;

		case R.id.sp_pq_8:
			if (sp_8_check) {
				sp_8_check = false;
				sp_question8
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_9_check) {
					sp_question9
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_10_check) {
					sp_question10
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_11_check) {
					sp_question11
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_6_check) {
					sp_question6
							.setBackgroundResource(R.drawable.spinner_mid_state);

				} else if (sp_7_check) {
					sp_question7
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_9:

			if (sp_9_check) {
				sp_9_check = false;
				sp_question9
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_10_check) {
					sp_question10
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_11_check) {
					sp_question11
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_6_check) {
					sp_question6
							.setBackgroundResource(R.drawable.spinner_mid_state);

				} else if (sp_7_check) {
					sp_question7
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_8_check) {
					sp_question8
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		case R.id.sp_pq_10:
			if (sp_10_check) {
				sp_10_check = false;
				sp_question10
						.setBackgroundResource(R.drawable.spinner_last_state);
				if (sp_11_check) {
					sp_question11
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_6_check) {
					sp_question6
							.setBackgroundResource(R.drawable.spinner_mid_state);

				} else if (sp_7_check) {
					sp_question7
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_8_check) {
					sp_question8
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
				if (sp_9_check) {
					sp_question9
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;
		case R.id.sp_pq_11:
			if (sp_11_check) {
				sp_11_check = false;
				sp_question11
						.setBackgroundResource(R.drawable.spinner_last_state);

				if (sp_6_check) {
					sp_question6
							.setBackgroundResource(R.drawable.spinner_mid_state);

				} else if (sp_7_check) {
					sp_question7
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_8_check) {
					sp_question8
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}
				if (sp_9_check) {
					sp_question9
							.setBackgroundResource(R.drawable.spinner_mid_state);
				} else if (sp_10_check) {
					sp_question10
							.setBackgroundResource(R.drawable.spinner_mid_state);
				}

			}
			break;

		}

	}

	private void checkNextButtonVisibility() {
		if ((sp_question6.getSelectedItemPosition() >= 0 && sp_question6
				.getSelectedItemPosition() < sp_question6.getCount())
				&& (sp_question7.getSelectedItemPosition() >= 0 && sp_question7
						.getSelectedItemPosition() < sp_question7.getCount())
				&& (sp_question8.getSelectedItemPosition() >= 0 && sp_question8
						.getSelectedItemPosition() < sp_question8.getCount())
				&& (sp_question9.getSelectedItemPosition() >= 0 && sp_question9
						.getSelectedItemPosition() < sp_question9.getCount())
				&& (sp_question10.getSelectedItemPosition() >= 0 && sp_question10
						.getSelectedItemPosition() < sp_question10.getCount())
				&& (sp_question11.getSelectedItemPosition() >= 0 && sp_question11
						.getSelectedItemPosition() < sp_question11.getCount())) {

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
		sp_question6.setBackgroundResource(R.drawable.spinner_mid_state);
		sp_question7.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question8.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question9.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question10.setBackgroundResource(R.drawable.spinner_start_state);
		sp_question11.setBackgroundResource(R.drawable.spinner_start_state);

		sp_6_check = true;
		sp_7_check = true;
		sp_8_check = true;
		sp_9_check = true;
		sp_10_check = true;
		sp_11_check = true;

	}

}
