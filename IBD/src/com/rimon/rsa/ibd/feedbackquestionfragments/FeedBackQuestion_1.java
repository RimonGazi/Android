package com.rimon.rsa.ibd.feedbackquestionfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.OnSwitchClickListener;
import com.rimon.rsa.ibd.questionpatient.fragments.UpdateFragment;
import com.rimon.rsa.mental.R;

public class FeedBackQuestion_1 extends SherlockFragment implements
		OnCheckedChangeListener, UpdateFragment {
	private CheckBox cb_fb_1_1, cb_fb_1_2, cb_fb_1_3, cb_fb_1_4, cb_fb_1_5,
			cb_fb_1_6, cb_fb_1_7;
	private CheckBox cb_fb_2_1, cb_fb_2_2, cb_fb_2_3, cb_fb_2_4, cb_fb_2_5,
			cb_fb_2_6, cb_fb_2_7;
	private CheckBox cb_fb_3_1, cb_fb_3_2, cb_fb_3_3, cb_fb_3_4, cb_fb_3_5,
			cb_fb_3_6, cb_fb_3_7;
	private CheckBox cb_fb_4_1, cb_fb_4_2, cb_fb_4_3, cb_fb_4_4, cb_fb_4_5,
			cb_fb_4_6, cb_fb_4_7;

	private Button btn_right, btn_next;
	private RelativeLayout layout;
	private OnSwitchClickListener listener;
	private boolean status;

	@Override
	public void onAttach(Activity activity) {
		listener = (OnSwitchClickListener) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.pfq_1, null, false);
		layout = (RelativeLayout) view.findViewById(R.id.fb_1_remove_layout);
		btn_next = (Button) view.findViewById(R.id.btn_fb_1_next);
		btn_right = (Button) view.findViewById(R.id.btn_fb_1_right);

		if (btn_right.getParent() != null)
			layout.removeView(btn_right);
		if (btn_next.getParent() != null)
			layout.removeView(btn_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (cb_fb_1_1.isChecked()) {
					ConstantValues.f_question_1_value = "1";
				} else if (cb_fb_1_2.isChecked()) {
					ConstantValues.f_question_1_value = "2";
				} else if (cb_fb_1_3.isChecked()) {
					ConstantValues.f_question_1_value = "3";
				} else if (cb_fb_1_4.isChecked()) {
					ConstantValues.f_question_1_value = "4";
				} else if (cb_fb_1_5.isChecked()) {
					ConstantValues.f_question_1_value = "5";
				} else if (cb_fb_1_6.isChecked()) {
					ConstantValues.f_question_1_value = "6";
				} else if (cb_fb_1_7.isChecked()) {
					ConstantValues.f_question_1_value = "7";
				}
				
				if (cb_fb_2_1.isChecked()) {
					ConstantValues.f_question_2_value = "1";
				} else if (cb_fb_2_2.isChecked()) {
					ConstantValues.f_question_2_value = "2";
				} else if (cb_fb_2_3.isChecked()) {
					ConstantValues.f_question_2_value = "3";
				} else if (cb_fb_2_4.isChecked()) {
					ConstantValues.f_question_2_value = "4";
				} else if (cb_fb_2_5.isChecked()) {
					ConstantValues.f_question_2_value = "5";
				} else if (cb_fb_2_6.isChecked()) {
					ConstantValues.f_question_2_value = "6";
				} else if (cb_fb_2_7.isChecked()) {
					ConstantValues.f_question_2_value = "7";
				}
				
				if (cb_fb_3_1.isChecked()) {
					ConstantValues.f_question_3_value = "1";
				} else if (cb_fb_3_2.isChecked()) {
					ConstantValues.f_question_3_value = "2";
				} else if (cb_fb_3_3.isChecked()) {
					ConstantValues.f_question_3_value = "3";
				} else if (cb_fb_3_4.isChecked()) {
					ConstantValues.f_question_3_value = "4";
				} else if (cb_fb_3_5.isChecked()) {
					ConstantValues.f_question_3_value = "5";
				} else if (cb_fb_3_6.isChecked()) {
					ConstantValues.f_question_3_value = "6";
				} else if (cb_fb_3_7.isChecked()) {
					ConstantValues.f_question_3_value = "7";
				}
				if (cb_fb_4_1.isChecked()) {
					ConstantValues.f_question_4_value = "1";
				} else if (cb_fb_4_2.isChecked()) {
					ConstantValues.f_question_4_value = "2";
				} else if (cb_fb_4_3.isChecked()) {
					ConstantValues.f_question_4_value = "3";
				} else if (cb_fb_4_4.isChecked()) {
					ConstantValues.f_question_4_value = "4";
				} else if (cb_fb_4_5.isChecked()) {
					ConstantValues.f_question_4_value = "5";
				} else if (cb_fb_4_6.isChecked()) {
					ConstantValues.f_question_4_value = "6";
				} else if (cb_fb_4_7.isChecked()) {
					ConstantValues.f_question_4_value = "7";
				}

				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_FIRST_HELP_PAGE);

			}
		});
		cb_fb_1_1 = (CheckBox) view.findViewById(R.id.cb_fb_1_1);
		cb_fb_1_2 = (CheckBox) view.findViewById(R.id.cb_fb_1_2);
		cb_fb_1_3 = (CheckBox) view.findViewById(R.id.cb_fb_1_3);
		cb_fb_1_4 = (CheckBox) view.findViewById(R.id.cb_fb_1_4);
		cb_fb_1_5 = (CheckBox) view.findViewById(R.id.cb_fb_1_5);
		cb_fb_1_6 = (CheckBox) view.findViewById(R.id.cb_fb_1_6);
		cb_fb_1_7 = (CheckBox) view.findViewById(R.id.cb_fb_1_7);

		cb_fb_2_1 = (CheckBox) view.findViewById(R.id.cb_fb_2_1);
		cb_fb_2_2 = (CheckBox) view.findViewById(R.id.cb_fb_2_2);
		cb_fb_2_3 = (CheckBox) view.findViewById(R.id.cb_fb_2_3);
		cb_fb_2_4 = (CheckBox) view.findViewById(R.id.cb_fb_2_4);
		cb_fb_2_5 = (CheckBox) view.findViewById(R.id.cb_fb_2_5);
		cb_fb_2_6 = (CheckBox) view.findViewById(R.id.cb_fb_2_6);
		cb_fb_2_7 = (CheckBox) view.findViewById(R.id.cb_fb_2_7);

		cb_fb_3_1 = (CheckBox) view.findViewById(R.id.cb_fb_3_1);
		cb_fb_3_2 = (CheckBox) view.findViewById(R.id.cb_fb_3_2);
		cb_fb_3_3 = (CheckBox) view.findViewById(R.id.cb_fb_3_3);
		cb_fb_3_4 = (CheckBox) view.findViewById(R.id.cb_fb_3_4);
		cb_fb_3_5 = (CheckBox) view.findViewById(R.id.cb_fb_3_5);
		cb_fb_3_6 = (CheckBox) view.findViewById(R.id.cb_fb_3_6);
		cb_fb_3_7 = (CheckBox) view.findViewById(R.id.cb_fb_3_7);

		cb_fb_4_1 = (CheckBox) view.findViewById(R.id.cb_fb_4_1);
		cb_fb_4_2 = (CheckBox) view.findViewById(R.id.cb_fb_4_2);
		cb_fb_4_3 = (CheckBox) view.findViewById(R.id.cb_fb_4_3);
		cb_fb_4_4 = (CheckBox) view.findViewById(R.id.cb_fb_4_4);
		cb_fb_4_5 = (CheckBox) view.findViewById(R.id.cb_fb_4_5);
		cb_fb_4_6 = (CheckBox) view.findViewById(R.id.cb_fb_4_6);
		cb_fb_4_7 = (CheckBox) view.findViewById(R.id.cb_fb_4_7);

		cb_fb_1_1.setOnCheckedChangeListener(this);
		cb_fb_1_2.setOnCheckedChangeListener(this);
		cb_fb_1_3.setOnCheckedChangeListener(this);
		cb_fb_1_4.setOnCheckedChangeListener(this);
		cb_fb_1_5.setOnCheckedChangeListener(this);
		cb_fb_1_6.setOnCheckedChangeListener(this);
		cb_fb_1_7.setOnCheckedChangeListener(this);

		cb_fb_2_1.setOnCheckedChangeListener(this);
		cb_fb_2_2.setOnCheckedChangeListener(this);
		cb_fb_2_3.setOnCheckedChangeListener(this);
		cb_fb_2_4.setOnCheckedChangeListener(this);
		cb_fb_2_5.setOnCheckedChangeListener(this);
		cb_fb_2_6.setOnCheckedChangeListener(this);
		cb_fb_2_7.setOnCheckedChangeListener(this);

		cb_fb_3_1.setOnCheckedChangeListener(this);
		cb_fb_3_2.setOnCheckedChangeListener(this);
		cb_fb_3_3.setOnCheckedChangeListener(this);
		cb_fb_3_4.setOnCheckedChangeListener(this);
		cb_fb_3_5.setOnCheckedChangeListener(this);
		cb_fb_3_6.setOnCheckedChangeListener(this);
		cb_fb_3_7.setOnCheckedChangeListener(this);

		cb_fb_4_1.setOnCheckedChangeListener(this);
		cb_fb_4_2.setOnCheckedChangeListener(this);
		cb_fb_4_3.setOnCheckedChangeListener(this);
		cb_fb_4_4.setOnCheckedChangeListener(this);
		cb_fb_4_5.setOnCheckedChangeListener(this);
		cb_fb_4_6.setOnCheckedChangeListener(this);
		cb_fb_4_7.setOnCheckedChangeListener(this);

		return view;
	}

	@Override
	public void onCheckedChanged(CompoundButton cb, boolean ischecked) {
		switch (cb.getId()) {

		// first checkbox
		case R.id.cb_fb_1_1:
			if (ischecked) {
				cb_fb_1_2.setChecked(false);
				cb_fb_1_3.setChecked(false);
				cb_fb_1_4.setChecked(false);
				cb_fb_1_5.setChecked(false);
				cb_fb_1_6.setChecked(false);
				cb_fb_1_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_1_2:
			if (ischecked) {
				cb_fb_1_1.setChecked(false);
				cb_fb_1_3.setChecked(false);
				cb_fb_1_4.setChecked(false);
				cb_fb_1_5.setChecked(false);
				cb_fb_1_6.setChecked(false);
				cb_fb_1_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_1_3:
			if (ischecked) {
				cb_fb_1_1.setChecked(false);
				cb_fb_1_2.setChecked(false);
				cb_fb_1_4.setChecked(false);
				cb_fb_1_5.setChecked(false);
				cb_fb_1_6.setChecked(false);
				cb_fb_1_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_1_4:
			if (ischecked) {
				cb_fb_1_1.setChecked(false);
				cb_fb_1_2.setChecked(false);
				cb_fb_1_3.setChecked(false);
				cb_fb_1_5.setChecked(false);
				cb_fb_1_6.setChecked(false);
				cb_fb_1_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_1_5:
			if (ischecked) {
				cb_fb_1_1.setChecked(false);
				cb_fb_1_2.setChecked(false);
				cb_fb_1_3.setChecked(false);
				cb_fb_1_4.setChecked(false);
				cb_fb_1_6.setChecked(false);
				cb_fb_1_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_1_6:
			if (ischecked) {
				cb_fb_1_1.setChecked(false);
				cb_fb_1_2.setChecked(false);
				cb_fb_1_3.setChecked(false);
				cb_fb_1_4.setChecked(false);
				cb_fb_1_5.setChecked(false);
				cb_fb_1_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_1_7:
			if (ischecked) {
				cb_fb_1_1.setChecked(false);
				cb_fb_1_2.setChecked(false);
				cb_fb_1_3.setChecked(false);
				cb_fb_1_4.setChecked(false);
				cb_fb_1_5.setChecked(false);
				cb_fb_1_6.setChecked(false);
			}
			break;

		// second check box
		case R.id.cb_fb_2_1:
			if (ischecked) {
				cb_fb_2_2.setChecked(false);
				cb_fb_2_3.setChecked(false);
				cb_fb_2_4.setChecked(false);
				cb_fb_2_5.setChecked(false);
				cb_fb_2_6.setChecked(false);
				cb_fb_2_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_2_2:
			if (ischecked) {
				cb_fb_2_1.setChecked(false);
				cb_fb_2_3.setChecked(false);
				cb_fb_2_4.setChecked(false);
				cb_fb_2_5.setChecked(false);
				cb_fb_2_6.setChecked(false);
				cb_fb_2_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_2_3:
			if (ischecked) {
				cb_fb_2_1.setChecked(false);
				cb_fb_2_2.setChecked(false);
				cb_fb_2_4.setChecked(false);
				cb_fb_2_5.setChecked(false);
				cb_fb_2_6.setChecked(false);
				cb_fb_2_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_2_4:
			if (ischecked) {
				cb_fb_2_1.setChecked(false);
				cb_fb_2_2.setChecked(false);
				cb_fb_2_3.setChecked(false);
				cb_fb_2_5.setChecked(false);
				cb_fb_2_6.setChecked(false);
				cb_fb_2_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_2_5:
			if (ischecked) {
				cb_fb_2_1.setChecked(false);
				cb_fb_2_2.setChecked(false);
				cb_fb_2_3.setChecked(false);
				cb_fb_2_4.setChecked(false);
				cb_fb_2_6.setChecked(false);
				cb_fb_2_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_2_6:
			if (ischecked) {
				cb_fb_2_1.setChecked(false);
				cb_fb_2_2.setChecked(false);
				cb_fb_2_3.setChecked(false);
				cb_fb_2_4.setChecked(false);
				cb_fb_2_5.setChecked(false);
				cb_fb_2_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_2_7:
			if (ischecked) {
				cb_fb_2_1.setChecked(false);
				cb_fb_2_2.setChecked(false);
				cb_fb_2_3.setChecked(false);
				cb_fb_2_4.setChecked(false);
				cb_fb_2_5.setChecked(false);
				cb_fb_2_6.setChecked(false);
			}
			break;

		// third check box
		case R.id.cb_fb_3_1:
			if (ischecked) {
				cb_fb_3_2.setChecked(false);
				cb_fb_3_3.setChecked(false);
				cb_fb_3_4.setChecked(false);
				cb_fb_3_5.setChecked(false);
				cb_fb_3_6.setChecked(false);
				cb_fb_3_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_3_2:
			if (ischecked) {
				cb_fb_3_1.setChecked(false);
				cb_fb_3_3.setChecked(false);
				cb_fb_3_4.setChecked(false);
				cb_fb_3_5.setChecked(false);
				cb_fb_3_6.setChecked(false);
				cb_fb_3_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_3_3:
			if (ischecked) {
				cb_fb_3_1.setChecked(false);
				cb_fb_3_2.setChecked(false);
				cb_fb_3_4.setChecked(false);
				cb_fb_3_5.setChecked(false);
				cb_fb_3_6.setChecked(false);
				cb_fb_3_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_3_4:
			if (ischecked) {
				cb_fb_3_1.setChecked(false);
				cb_fb_3_2.setChecked(false);
				cb_fb_3_3.setChecked(false);
				cb_fb_3_5.setChecked(false);
				cb_fb_3_6.setChecked(false);
				cb_fb_3_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_3_5:
			if (ischecked) {
				cb_fb_3_1.setChecked(false);
				cb_fb_3_2.setChecked(false);
				cb_fb_3_3.setChecked(false);
				cb_fb_3_4.setChecked(false);
				cb_fb_3_6.setChecked(false);
				cb_fb_3_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_3_6:
			if (ischecked) {
				cb_fb_3_1.setChecked(false);
				cb_fb_3_2.setChecked(false);
				cb_fb_3_3.setChecked(false);
				cb_fb_3_4.setChecked(false);
				cb_fb_3_5.setChecked(false);
				cb_fb_3_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_3_7:
			if (ischecked) {
				cb_fb_3_1.setChecked(false);
				cb_fb_3_2.setChecked(false);
				cb_fb_3_3.setChecked(false);
				cb_fb_3_4.setChecked(false);
				cb_fb_3_5.setChecked(false);
				cb_fb_3_6.setChecked(false);
			}
			break;

		// fourth checked box
		case R.id.cb_fb_4_1:
			if (ischecked) {
				cb_fb_4_2.setChecked(false);
				cb_fb_4_3.setChecked(false);
				cb_fb_4_4.setChecked(false);
				cb_fb_4_5.setChecked(false);
				cb_fb_4_6.setChecked(false);
				cb_fb_4_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_4_2:
			if (ischecked) {
				cb_fb_4_1.setChecked(false);
				cb_fb_4_3.setChecked(false);
				cb_fb_4_4.setChecked(false);
				cb_fb_4_5.setChecked(false);
				cb_fb_4_6.setChecked(false);
				cb_fb_4_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_4_3:
			if (ischecked) {
				cb_fb_4_1.setChecked(false);
				cb_fb_4_2.setChecked(false);
				cb_fb_4_4.setChecked(false);
				cb_fb_4_5.setChecked(false);
				cb_fb_4_6.setChecked(false);
				cb_fb_4_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_4_4:
			if (ischecked) {
				cb_fb_4_1.setChecked(false);
				cb_fb_4_2.setChecked(false);
				cb_fb_4_3.setChecked(false);
				cb_fb_4_5.setChecked(false);
				cb_fb_4_6.setChecked(false);
				cb_fb_4_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_4_5:
			if (ischecked) {
				cb_fb_4_1.setChecked(false);
				cb_fb_4_2.setChecked(false);
				cb_fb_4_3.setChecked(false);
				cb_fb_4_4.setChecked(false);
				cb_fb_4_6.setChecked(false);
				cb_fb_4_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_4_6:
			if (ischecked) {
				cb_fb_4_1.setChecked(false);
				cb_fb_4_2.setChecked(false);
				cb_fb_4_3.setChecked(false);
				cb_fb_4_4.setChecked(false);
				cb_fb_4_5.setChecked(false);
				cb_fb_4_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_4_7:
			if (ischecked) {
				cb_fb_4_1.setChecked(false);
				cb_fb_4_2.setChecked(false);
				cb_fb_4_3.setChecked(false);
				cb_fb_4_4.setChecked(false);
				cb_fb_4_5.setChecked(false);
				cb_fb_4_6.setChecked(false);
			}
			break;
		}

		checkAddNextAndRightButton();
	}

	private void checkAddNextAndRightButton() {
		status = true;

		if ((cb_fb_1_1.isChecked()) || (cb_fb_1_2.isChecked())
				|| (cb_fb_1_3.isChecked()) || (cb_fb_1_4.isChecked())
				|| (cb_fb_1_5.isChecked()) || (cb_fb_1_6.isChecked())
				|| (cb_fb_1_7.isChecked())) {
			if ((cb_fb_2_1.isChecked()) || (cb_fb_2_2.isChecked())
					|| (cb_fb_2_3.isChecked()) || (cb_fb_2_4.isChecked())
					|| (cb_fb_2_5.isChecked()) || (cb_fb_2_6.isChecked())
					|| (cb_fb_2_7.isChecked())) {

				if ((cb_fb_3_1.isChecked()) || (cb_fb_3_2.isChecked())
						|| (cb_fb_3_3.isChecked()) || (cb_fb_3_4.isChecked())
						|| (cb_fb_3_5.isChecked()) || (cb_fb_3_6.isChecked())
						|| (cb_fb_3_7.isChecked())) {

					if ((cb_fb_4_1.isChecked()) || (cb_fb_4_2.isChecked())
							|| (cb_fb_4_3.isChecked())
							|| (cb_fb_4_4.isChecked())
							|| (cb_fb_4_5.isChecked())
							|| (cb_fb_4_6.isChecked())
							|| (cb_fb_4_7.isChecked())) {
						status = false;
						if (btn_right.getParent() == null)
							layout.addView(btn_right);
						if (btn_next.getParent() == null)
							layout.addView(btn_next);

					}

				}

			}

		}
		if (status) {
			if (btn_right.getParent() != null)
				layout.removeView(btn_right);
			if (btn_next.getParent() != null)
				layout.removeView(btn_next);
		}

	}

	@Override
	public void Update() {

		cb_fb_1_1.setChecked(false);
		cb_fb_1_2.setChecked(false);
		cb_fb_1_3.setChecked(false);
		cb_fb_1_4.setChecked(false);
		cb_fb_1_5.setChecked(false);
		cb_fb_1_6.setChecked(false);
		cb_fb_1_7.setChecked(false);

		cb_fb_2_1.setChecked(false);
		cb_fb_2_2.setChecked(false);
		cb_fb_2_3.setChecked(false);
		cb_fb_2_4.setChecked(false);
		cb_fb_2_5.setChecked(false);
		cb_fb_2_6.setChecked(false);
		cb_fb_2_7.setChecked(false);

		cb_fb_3_1.setChecked(false);
		cb_fb_3_2.setChecked(false);
		cb_fb_3_3.setChecked(false);
		cb_fb_3_4.setChecked(false);
		cb_fb_3_5.setChecked(false);
		cb_fb_3_6.setChecked(false);
		cb_fb_3_7.setChecked(false);

		cb_fb_4_1.setChecked(false);
		cb_fb_4_2.setChecked(false);
		cb_fb_4_3.setChecked(false);
		cb_fb_4_4.setChecked(false);
		cb_fb_4_5.setChecked(false);
		cb_fb_4_6.setChecked(false);
		cb_fb_4_7.setChecked(false);

		// Toast.makeText(getActivity(), "1", Toast.LENGTH_LONG).show();

	}
}
