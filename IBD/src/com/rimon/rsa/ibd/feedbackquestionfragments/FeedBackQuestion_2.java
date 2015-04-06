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

public class FeedBackQuestion_2 extends SherlockFragment implements
		OnCheckedChangeListener, UpdateFragment {
	private CheckBox cb_fb_5_1, cb_fb_5_2, cb_fb_5_3, cb_fb_5_4, cb_fb_5_5,
			cb_fb_5_6, cb_fb_5_7;
	private CheckBox cb_fb_6_1, cb_fb_6_2, cb_fb_6_3, cb_fb_6_4, cb_fb_6_5,
			cb_fb_6_6, cb_fb_6_7;
	private CheckBox cb_fb_7_1, cb_fb_7_2, cb_fb_7_3, cb_fb_7_4, cb_fb_7_5,
			cb_fb_7_6, cb_fb_7_7;
	private CheckBox cb_fb_8_1, cb_fb_8_2, cb_fb_8_3, cb_fb_8_4, cb_fb_8_5,
			cb_fb_8_6, cb_fb_8_7;

	private Button btn_right, btn_next, btn_back;
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
		View view = inflater.inflate(R.layout.pfq_2, null, false);
		layout = (RelativeLayout) view.findViewById(R.id.fb_2_remove_layout);
		btn_next = (Button) view.findViewById(R.id.btn_fb_2_next);
		btn_right = (Button) view.findViewById(R.id.btn_fb_2_right);
		btn_back = (Button) view.findViewById(R.id.btn_fb_2_back);
		if (btn_right.getParent() != null)
			layout.removeView(btn_right);
		if (btn_next.getParent() != null)
			layout.removeView(btn_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (cb_fb_5_1.isChecked()) {
					ConstantValues.f_question_5_value = "1";
				} else if (cb_fb_5_2.isChecked()) {
					ConstantValues.f_question_5_value = "2";
				} else if (cb_fb_5_3.isChecked()) {
					ConstantValues.f_question_5_value = "3";
				} else if (cb_fb_5_4.isChecked()) {
					ConstantValues.f_question_5_value = "4";
				} else if (cb_fb_5_5.isChecked()) {
					ConstantValues.f_question_5_value = "5";
				} else if (cb_fb_5_6.isChecked()) {
					ConstantValues.f_question_5_value = "6";
				} else if (cb_fb_5_7.isChecked()) {
					ConstantValues.f_question_5_value = "7";
				}

				if (cb_fb_6_1.isChecked()) {
					ConstantValues.f_question_6_value = "1";
				} else if (cb_fb_6_2.isChecked()) {
					ConstantValues.f_question_6_value = "2";
				} else if (cb_fb_6_3.isChecked()) {
					ConstantValues.f_question_6_value = "3";
				} else if (cb_fb_6_4.isChecked()) {
					ConstantValues.f_question_6_value = "4";
				} else if (cb_fb_6_5.isChecked()) {
					ConstantValues.f_question_6_value = "5";
				} else if (cb_fb_6_6.isChecked()) {
					ConstantValues.f_question_6_value = "6";
				} else if (cb_fb_6_7.isChecked()) {
					ConstantValues.f_question_6_value = "7";
				}

				if (cb_fb_7_1.isChecked()) {
					ConstantValues.f_question_7_value = "1";
				} else if (cb_fb_7_2.isChecked()) {
					ConstantValues.f_question_7_value = "2";
				} else if (cb_fb_7_3.isChecked()) {
					ConstantValues.f_question_7_value = "3";
				} else if (cb_fb_7_4.isChecked()) {
					ConstantValues.f_question_7_value = "4";
				} else if (cb_fb_7_5.isChecked()) {
					ConstantValues.f_question_7_value = "5";
				} else if (cb_fb_7_6.isChecked()) {
					ConstantValues.f_question_7_value = "6";
				} else if (cb_fb_7_7.isChecked()) {
					ConstantValues.f_question_7_value = "7";
				}
				if (cb_fb_8_1.isChecked()) {
					ConstantValues.f_question_8_value = "1";
				} else if (cb_fb_8_2.isChecked()) {
					ConstantValues.f_question_8_value = "2";
				} else if (cb_fb_8_3.isChecked()) {
					ConstantValues.f_question_8_value = "3";
				} else if (cb_fb_8_4.isChecked()) {
					ConstantValues.f_question_8_value = "4";
				} else if (cb_fb_8_5.isChecked()) {
					ConstantValues.f_question_8_value = "5";
				} else if (cb_fb_8_6.isChecked()) {
					ConstantValues.f_question_8_value = "6";
				} else if (cb_fb_8_7.isChecked()) {
					ConstantValues.f_question_8_value = "7";
				}
				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_THIRD_PAGE);

			}
		});
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_FIRST_HELP_PAGE);

			}
		});
		cb_fb_5_1 = (CheckBox) view.findViewById(R.id.cb_fb_5_1);
		cb_fb_5_2 = (CheckBox) view.findViewById(R.id.cb_fb_5_2);
		cb_fb_5_3 = (CheckBox) view.findViewById(R.id.cb_fb_5_3);
		cb_fb_5_4 = (CheckBox) view.findViewById(R.id.cb_fb_5_4);
		cb_fb_5_5 = (CheckBox) view.findViewById(R.id.cb_fb_5_5);
		cb_fb_5_6 = (CheckBox) view.findViewById(R.id.cb_fb_5_6);
		cb_fb_5_7 = (CheckBox) view.findViewById(R.id.cb_fb_5_7);

		cb_fb_6_1 = (CheckBox) view.findViewById(R.id.cb_fb_6_1);
		cb_fb_6_2 = (CheckBox) view.findViewById(R.id.cb_fb_6_2);
		cb_fb_6_3 = (CheckBox) view.findViewById(R.id.cb_fb_6_3);
		cb_fb_6_4 = (CheckBox) view.findViewById(R.id.cb_fb_6_4);
		cb_fb_6_5 = (CheckBox) view.findViewById(R.id.cb_fb_6_5);
		cb_fb_6_6 = (CheckBox) view.findViewById(R.id.cb_fb_6_6);
		cb_fb_6_7 = (CheckBox) view.findViewById(R.id.cb_fb_6_7);

		cb_fb_7_1 = (CheckBox) view.findViewById(R.id.cb_fb_7_1);
		cb_fb_7_2 = (CheckBox) view.findViewById(R.id.cb_fb_7_2);
		cb_fb_7_3 = (CheckBox) view.findViewById(R.id.cb_fb_7_3);
		cb_fb_7_4 = (CheckBox) view.findViewById(R.id.cb_fb_7_4);
		cb_fb_7_5 = (CheckBox) view.findViewById(R.id.cb_fb_7_5);
		cb_fb_7_6 = (CheckBox) view.findViewById(R.id.cb_fb_7_6);
		cb_fb_7_7 = (CheckBox) view.findViewById(R.id.cb_fb_7_7);

		cb_fb_8_1 = (CheckBox) view.findViewById(R.id.cb_fb_8_1);
		cb_fb_8_2 = (CheckBox) view.findViewById(R.id.cb_fb_8_2);
		cb_fb_8_3 = (CheckBox) view.findViewById(R.id.cb_fb_8_3);
		cb_fb_8_4 = (CheckBox) view.findViewById(R.id.cb_fb_8_4);
		cb_fb_8_5 = (CheckBox) view.findViewById(R.id.cb_fb_8_5);
		cb_fb_8_6 = (CheckBox) view.findViewById(R.id.cb_fb_8_6);
		cb_fb_8_7 = (CheckBox) view.findViewById(R.id.cb_fb_8_7);

		cb_fb_5_1.setOnCheckedChangeListener(this);
		cb_fb_5_2.setOnCheckedChangeListener(this);
		cb_fb_5_3.setOnCheckedChangeListener(this);
		cb_fb_5_4.setOnCheckedChangeListener(this);
		cb_fb_5_5.setOnCheckedChangeListener(this);
		cb_fb_5_6.setOnCheckedChangeListener(this);
		cb_fb_5_7.setOnCheckedChangeListener(this);

		cb_fb_6_1.setOnCheckedChangeListener(this);
		cb_fb_6_2.setOnCheckedChangeListener(this);
		cb_fb_6_3.setOnCheckedChangeListener(this);
		cb_fb_6_4.setOnCheckedChangeListener(this);
		cb_fb_6_5.setOnCheckedChangeListener(this);
		cb_fb_6_6.setOnCheckedChangeListener(this);
		cb_fb_6_7.setOnCheckedChangeListener(this);

		cb_fb_7_1.setOnCheckedChangeListener(this);
		cb_fb_7_2.setOnCheckedChangeListener(this);
		cb_fb_7_3.setOnCheckedChangeListener(this);
		cb_fb_7_4.setOnCheckedChangeListener(this);
		cb_fb_7_5.setOnCheckedChangeListener(this);
		cb_fb_7_6.setOnCheckedChangeListener(this);
		cb_fb_7_7.setOnCheckedChangeListener(this);

		cb_fb_8_1.setOnCheckedChangeListener(this);
		cb_fb_8_2.setOnCheckedChangeListener(this);
		cb_fb_8_3.setOnCheckedChangeListener(this);
		cb_fb_8_4.setOnCheckedChangeListener(this);
		cb_fb_8_5.setOnCheckedChangeListener(this);
		cb_fb_8_6.setOnCheckedChangeListener(this);
		cb_fb_8_7.setOnCheckedChangeListener(this);

		return view;
	}

	@Override
	public void onCheckedChanged(CompoundButton cb, boolean ischecked) {
		switch (cb.getId()) {

		// fifth checkbox
		case R.id.cb_fb_5_1:
			if (ischecked) {
				cb_fb_5_2.setChecked(false);
				cb_fb_5_3.setChecked(false);
				cb_fb_5_4.setChecked(false);
				cb_fb_5_5.setChecked(false);
				cb_fb_5_6.setChecked(false);
				cb_fb_5_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_5_2:
			if (ischecked) {
				cb_fb_5_1.setChecked(false);
				cb_fb_5_3.setChecked(false);
				cb_fb_5_4.setChecked(false);
				cb_fb_5_5.setChecked(false);
				cb_fb_5_6.setChecked(false);
				cb_fb_5_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_5_3:
			if (ischecked) {
				cb_fb_5_1.setChecked(false);
				cb_fb_5_2.setChecked(false);
				cb_fb_5_4.setChecked(false);
				cb_fb_5_5.setChecked(false);
				cb_fb_5_6.setChecked(false);
				cb_fb_5_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_5_4:
			if (ischecked) {
				cb_fb_5_1.setChecked(false);
				cb_fb_5_2.setChecked(false);
				cb_fb_5_3.setChecked(false);
				cb_fb_5_5.setChecked(false);
				cb_fb_5_6.setChecked(false);
				cb_fb_5_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_5_5:
			if (ischecked) {
				cb_fb_5_1.setChecked(false);
				cb_fb_5_2.setChecked(false);
				cb_fb_5_3.setChecked(false);
				cb_fb_5_4.setChecked(false);
				cb_fb_5_6.setChecked(false);
				cb_fb_5_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_5_6:
			if (ischecked) {
				cb_fb_5_1.setChecked(false);
				cb_fb_5_2.setChecked(false);
				cb_fb_5_3.setChecked(false);
				cb_fb_5_4.setChecked(false);
				cb_fb_5_5.setChecked(false);
				cb_fb_5_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_5_7:
			if (ischecked) {
				cb_fb_5_1.setChecked(false);
				cb_fb_5_2.setChecked(false);
				cb_fb_5_3.setChecked(false);
				cb_fb_5_4.setChecked(false);
				cb_fb_5_5.setChecked(false);
				cb_fb_5_6.setChecked(false);
			}
			break;

		// sixth check box
		case R.id.cb_fb_6_1:
			if (ischecked) {
				cb_fb_6_2.setChecked(false);
				cb_fb_6_3.setChecked(false);
				cb_fb_6_4.setChecked(false);
				cb_fb_6_5.setChecked(false);
				cb_fb_6_6.setChecked(false);
				cb_fb_6_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_6_2:
			if (ischecked) {
				cb_fb_6_1.setChecked(false);
				cb_fb_6_3.setChecked(false);
				cb_fb_6_4.setChecked(false);
				cb_fb_6_5.setChecked(false);
				cb_fb_6_6.setChecked(false);
				cb_fb_6_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_6_3:
			if (ischecked) {
				cb_fb_6_1.setChecked(false);
				cb_fb_6_2.setChecked(false);
				cb_fb_6_4.setChecked(false);
				cb_fb_6_5.setChecked(false);
				cb_fb_6_6.setChecked(false);
				cb_fb_6_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_6_4:
			if (ischecked) {
				cb_fb_6_1.setChecked(false);
				cb_fb_6_2.setChecked(false);
				cb_fb_6_3.setChecked(false);
				cb_fb_6_5.setChecked(false);
				cb_fb_6_6.setChecked(false);
				cb_fb_6_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_6_5:
			if (ischecked) {
				cb_fb_6_1.setChecked(false);
				cb_fb_6_2.setChecked(false);
				cb_fb_6_3.setChecked(false);
				cb_fb_6_4.setChecked(false);
				cb_fb_6_6.setChecked(false);
				cb_fb_6_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_6_6:
			if (ischecked) {
				cb_fb_6_1.setChecked(false);
				cb_fb_6_2.setChecked(false);
				cb_fb_6_3.setChecked(false);
				cb_fb_6_4.setChecked(false);
				cb_fb_6_5.setChecked(false);
				cb_fb_6_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_6_7:
			if (ischecked) {
				cb_fb_6_1.setChecked(false);
				cb_fb_6_2.setChecked(false);
				cb_fb_6_3.setChecked(false);
				cb_fb_6_4.setChecked(false);
				cb_fb_6_5.setChecked(false);
				cb_fb_6_6.setChecked(false);
			}
			break;

		// seven check box
		case R.id.cb_fb_7_1:
			if (ischecked) {
				cb_fb_7_2.setChecked(false);
				cb_fb_7_3.setChecked(false);
				cb_fb_7_4.setChecked(false);
				cb_fb_7_5.setChecked(false);
				cb_fb_7_6.setChecked(false);
				cb_fb_7_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_7_2:
			if (ischecked) {
				cb_fb_7_1.setChecked(false);
				cb_fb_7_3.setChecked(false);
				cb_fb_7_4.setChecked(false);
				cb_fb_7_5.setChecked(false);
				cb_fb_7_6.setChecked(false);
				cb_fb_7_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_7_3:
			if (ischecked) {
				cb_fb_7_1.setChecked(false);
				cb_fb_7_2.setChecked(false);
				cb_fb_7_4.setChecked(false);
				cb_fb_7_5.setChecked(false);
				cb_fb_7_6.setChecked(false);
				cb_fb_7_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_7_4:
			if (ischecked) {
				cb_fb_7_1.setChecked(false);
				cb_fb_7_2.setChecked(false);
				cb_fb_7_3.setChecked(false);
				cb_fb_7_5.setChecked(false);
				cb_fb_7_6.setChecked(false);
				cb_fb_7_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_7_5:
			if (ischecked) {
				cb_fb_7_1.setChecked(false);
				cb_fb_7_2.setChecked(false);
				cb_fb_7_3.setChecked(false);
				cb_fb_7_4.setChecked(false);
				cb_fb_7_6.setChecked(false);
				cb_fb_7_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_7_6:
			if (ischecked) {
				cb_fb_7_1.setChecked(false);
				cb_fb_7_2.setChecked(false);
				cb_fb_7_3.setChecked(false);
				cb_fb_7_4.setChecked(false);
				cb_fb_7_5.setChecked(false);
				cb_fb_7_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_7_7:
			if (ischecked) {
				cb_fb_7_1.setChecked(false);
				cb_fb_7_2.setChecked(false);
				cb_fb_7_3.setChecked(false);
				cb_fb_7_4.setChecked(false);
				cb_fb_7_5.setChecked(false);
				cb_fb_7_6.setChecked(false);
			}
			break;
		case R.id.cb_fb_8_1:
			if (ischecked) {
				cb_fb_8_2.setChecked(false);
				cb_fb_8_3.setChecked(false);
				cb_fb_8_4.setChecked(false);
				cb_fb_8_5.setChecked(false);
				cb_fb_8_6.setChecked(false);
				cb_fb_8_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_8_2:
			if (ischecked) {
				cb_fb_8_1.setChecked(false);
				cb_fb_8_3.setChecked(false);
				cb_fb_8_4.setChecked(false);
				cb_fb_8_5.setChecked(false);
				cb_fb_8_6.setChecked(false);
				cb_fb_8_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_8_3:
			if (ischecked) {
				cb_fb_8_1.setChecked(false);
				cb_fb_8_2.setChecked(false);
				cb_fb_8_4.setChecked(false);
				cb_fb_8_5.setChecked(false);
				cb_fb_8_6.setChecked(false);
				cb_fb_8_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_8_4:
			if (ischecked) {
				cb_fb_8_1.setChecked(false);
				cb_fb_8_2.setChecked(false);
				cb_fb_8_3.setChecked(false);
				cb_fb_8_5.setChecked(false);
				cb_fb_8_6.setChecked(false);
				cb_fb_8_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_8_5:
			if (ischecked) {
				cb_fb_8_1.setChecked(false);
				cb_fb_8_2.setChecked(false);
				cb_fb_8_3.setChecked(false);
				cb_fb_8_4.setChecked(false);
				cb_fb_8_6.setChecked(false);
				cb_fb_8_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_8_6:
			if (ischecked) {
				cb_fb_8_1.setChecked(false);
				cb_fb_8_2.setChecked(false);
				cb_fb_8_3.setChecked(false);
				cb_fb_8_4.setChecked(false);
				cb_fb_8_5.setChecked(false);
				cb_fb_8_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_8_7:
			if (ischecked) {
				cb_fb_8_1.setChecked(false);
				cb_fb_8_2.setChecked(false);
				cb_fb_8_3.setChecked(false);
				cb_fb_8_4.setChecked(false);
				cb_fb_8_5.setChecked(false);
				cb_fb_8_6.setChecked(false);
			}
			break;

		}

		checkAddNextAndRightButton();
	}

	private void checkAddNextAndRightButton() {
		status = true;
		if ((cb_fb_5_1.isChecked()) || (cb_fb_5_2.isChecked())
				|| (cb_fb_5_3.isChecked()) || (cb_fb_5_4.isChecked())
				|| (cb_fb_5_5.isChecked()) || (cb_fb_5_6.isChecked())
				|| (cb_fb_5_7.isChecked())) {
			if ((cb_fb_6_1.isChecked()) || (cb_fb_6_2.isChecked())
					|| (cb_fb_6_3.isChecked()) || (cb_fb_6_4.isChecked())
					|| (cb_fb_6_5.isChecked()) || (cb_fb_6_6.isChecked())
					|| (cb_fb_6_7.isChecked())) {
				if ((cb_fb_7_1.isChecked()) || (cb_fb_7_2.isChecked())
						|| (cb_fb_7_3.isChecked()) || (cb_fb_7_4.isChecked())
						|| (cb_fb_7_5.isChecked()) || (cb_fb_7_6.isChecked())
						|| (cb_fb_7_7.isChecked())) {
					if ((cb_fb_8_1.isChecked()) || (cb_fb_8_2.isChecked())
							|| (cb_fb_8_3.isChecked())
							|| (cb_fb_8_4.isChecked())
							|| (cb_fb_8_5.isChecked())
							|| (cb_fb_8_6.isChecked())
							|| (cb_fb_8_7.isChecked())) {
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

		cb_fb_5_1.setChecked(false);
		cb_fb_5_2.setChecked(false);
		cb_fb_5_3.setChecked(false);
		cb_fb_5_4.setChecked(false);
		cb_fb_5_5.setChecked(false);
		cb_fb_5_6.setChecked(false);
		cb_fb_5_7.setChecked(false);

		cb_fb_6_1.setChecked(false);
		cb_fb_6_2.setChecked(false);
		cb_fb_6_3.setChecked(false);
		cb_fb_6_4.setChecked(false);
		cb_fb_6_5.setChecked(false);
		cb_fb_6_6.setChecked(false);
		cb_fb_6_7.setChecked(false);

		cb_fb_7_1.setChecked(false);
		cb_fb_7_2.setChecked(false);
		cb_fb_7_3.setChecked(false);
		cb_fb_7_4.setChecked(false);
		cb_fb_7_5.setChecked(false);
		cb_fb_7_6.setChecked(false);
		cb_fb_7_7.setChecked(false);

		cb_fb_8_1.setChecked(false);
		cb_fb_8_2.setChecked(false);
		cb_fb_8_3.setChecked(false);
		cb_fb_8_4.setChecked(false);
		cb_fb_8_5.setChecked(false);
		cb_fb_8_6.setChecked(false);
		cb_fb_8_7.setChecked(false);

		// Toast.makeText(getActivity(), "2", Toast.LENGTH_LONG).show();

	}

}
