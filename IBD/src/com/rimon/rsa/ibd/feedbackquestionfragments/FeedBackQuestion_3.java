package com.rimon.rsa.ibd.feedbackquestionfragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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

public class FeedBackQuestion_3 extends SherlockFragment implements
		OnCheckedChangeListener, UpdateFragment {

	private CheckBox cb_fb_9_1, cb_fb_9_2, cb_fb_9_3, cb_fb_9_4, cb_fb_9_5,
			cb_fb_9_6, cb_fb_9_7;
	private CheckBox cb_fb_10_1, cb_fb_10_2, cb_fb_10_3, cb_fb_10_4,
			cb_fb_10_5, cb_fb_10_6, cb_fb_10_7;
	private CheckBox cb_fb_11_1, cb_fb_11_2, cb_fb_11_3, cb_fb_11_4,
			cb_fb_11_5, cb_fb_11_6, cb_fb_11_7;
	private CheckBox cb_fb_12_1, cb_fb_12_2, cb_fb_12_3, cb_fb_12_4,
			cb_fb_12_5, cb_fb_12_6, cb_fb_12_7;

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
		View view = inflater.inflate(R.layout.pfq_3, null, false);
		layout = (RelativeLayout) view.findViewById(R.id.fb_3_remove_layout);
		btn_next = (Button) view.findViewById(R.id.btn_fb_3_next);
		btn_right = (Button) view.findViewById(R.id.btn_fb_3_right);
		btn_back = (Button) view.findViewById(R.id.btn_fb_3_back);

		if (btn_right.getParent() != null)
			layout.removeView(btn_right);
		if (btn_next.getParent() != null)
			layout.removeView(btn_next);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (cb_fb_10_1.isChecked()) {
					ConstantValues.f_question_10_value = "1";
				} else if (cb_fb_10_2.isChecked()) {
					ConstantValues.f_question_10_value = "2";
				} else if (cb_fb_10_3.isChecked()) {
					ConstantValues.f_question_10_value = "3";
				} else if (cb_fb_10_4.isChecked()) {
					ConstantValues.f_question_10_value = "4";
				} else if (cb_fb_10_5.isChecked()) {
					ConstantValues.f_question_10_value = "5";
				} else if (cb_fb_10_6.isChecked()) {
					ConstantValues.f_question_10_value = "6";
				} else if (cb_fb_10_7.isChecked()) {
					ConstantValues.f_question_10_value = "7";
				}

				if (cb_fb_11_1.isChecked()) {
					ConstantValues.f_question_11_value = "1";
				} else if (cb_fb_11_2.isChecked()) {
					ConstantValues.f_question_11_value = "2";
				} else if (cb_fb_11_3.isChecked()) {
					ConstantValues.f_question_11_value = "3";
				} else if (cb_fb_11_4.isChecked()) {
					ConstantValues.f_question_11_value = "4";
				} else if (cb_fb_11_5.isChecked()) {
					ConstantValues.f_question_11_value = "5";
				} else if (cb_fb_11_6.isChecked()) {
					ConstantValues.f_question_11_value = "6";
				} else if (cb_fb_11_7.isChecked()) {
					ConstantValues.f_question_11_value = "7";
				}
				if (cb_fb_12_1.isChecked()) {
					ConstantValues.f_question_12_value = "1";
				} else if (cb_fb_12_2.isChecked()) {
					ConstantValues.f_question_12_value = "2";
				} else if (cb_fb_12_3.isChecked()) {
					ConstantValues.f_question_12_value = "3";
				} else if (cb_fb_12_4.isChecked()) {
					ConstantValues.f_question_12_value = "4";
				} else if (cb_fb_12_5.isChecked()) {
					ConstantValues.f_question_12_value = "5";
				} else if (cb_fb_12_6.isChecked()) {
					ConstantValues.f_question_12_value = "6";
				} else if (cb_fb_12_7.isChecked()) {
					ConstantValues.f_question_12_value = "7";
				}

				if (cb_fb_9_1.isChecked()) {
					ConstantValues.f_question_9_value = "1";
				} else if (cb_fb_9_2.isChecked()) {
					ConstantValues.f_question_9_value = "2";
				} else if (cb_fb_9_3.isChecked()) {
					ConstantValues.f_question_9_value = "3";
				} else if (cb_fb_9_4.isChecked()) {
					ConstantValues.f_question_9_value = "4";
				} else if (cb_fb_9_5.isChecked()) {
					ConstantValues.f_question_9_value = "5";
				} else if (cb_fb_9_6.isChecked()) {
					ConstantValues.f_question_9_value = "6";
				} else if (cb_fb_9_7.isChecked()) {
					ConstantValues.f_question_9_value = "7";
				}

				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_FOURTH_PAGE);

			}
		});

		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_SECOND_PAGE);

			}
		});

		cb_fb_9_1 = (CheckBox) view.findViewById(R.id.cb_fb_9_1);
		cb_fb_9_2 = (CheckBox) view.findViewById(R.id.cb_fb_9_2);
		cb_fb_9_3 = (CheckBox) view.findViewById(R.id.cb_fb_9_3);
		cb_fb_9_4 = (CheckBox) view.findViewById(R.id.cb_fb_9_4);
		cb_fb_9_5 = (CheckBox) view.findViewById(R.id.cb_fb_9_5);
		cb_fb_9_6 = (CheckBox) view.findViewById(R.id.cb_fb_9_6);
		cb_fb_9_7 = (CheckBox) view.findViewById(R.id.cb_fb_9_7);

		cb_fb_10_1 = (CheckBox) view.findViewById(R.id.cb_fb_10_1);
		cb_fb_10_2 = (CheckBox) view.findViewById(R.id.cb_fb_10_2);
		cb_fb_10_3 = (CheckBox) view.findViewById(R.id.cb_fb_10_3);
		cb_fb_10_4 = (CheckBox) view.findViewById(R.id.cb_fb_10_4);
		cb_fb_10_5 = (CheckBox) view.findViewById(R.id.cb_fb_10_5);
		cb_fb_10_6 = (CheckBox) view.findViewById(R.id.cb_fb_10_6);
		cb_fb_10_7 = (CheckBox) view.findViewById(R.id.cb_fb_10_7);

		cb_fb_11_1 = (CheckBox) view.findViewById(R.id.cb_fb_11_1);
		cb_fb_11_2 = (CheckBox) view.findViewById(R.id.cb_fb_11_2);
		cb_fb_11_3 = (CheckBox) view.findViewById(R.id.cb_fb_11_3);
		cb_fb_11_4 = (CheckBox) view.findViewById(R.id.cb_fb_11_4);
		cb_fb_11_5 = (CheckBox) view.findViewById(R.id.cb_fb_11_5);
		cb_fb_11_6 = (CheckBox) view.findViewById(R.id.cb_fb_11_6);
		cb_fb_11_7 = (CheckBox) view.findViewById(R.id.cb_fb_11_7);

		cb_fb_12_1 = (CheckBox) view.findViewById(R.id.cb_fb_12_1);
		cb_fb_12_2 = (CheckBox) view.findViewById(R.id.cb_fb_12_2);
		cb_fb_12_3 = (CheckBox) view.findViewById(R.id.cb_fb_12_3);
		cb_fb_12_4 = (CheckBox) view.findViewById(R.id.cb_fb_12_4);
		cb_fb_12_5 = (CheckBox) view.findViewById(R.id.cb_fb_12_5);
		cb_fb_12_6 = (CheckBox) view.findViewById(R.id.cb_fb_12_6);
		cb_fb_12_7 = (CheckBox) view.findViewById(R.id.cb_fb_12_7);

		cb_fb_9_1.setOnCheckedChangeListener(this);
		cb_fb_9_2.setOnCheckedChangeListener(this);
		cb_fb_9_3.setOnCheckedChangeListener(this);
		cb_fb_9_4.setOnCheckedChangeListener(this);
		cb_fb_9_5.setOnCheckedChangeListener(this);
		cb_fb_9_6.setOnCheckedChangeListener(this);
		cb_fb_9_7.setOnCheckedChangeListener(this);

		cb_fb_10_1.setOnCheckedChangeListener(this);
		cb_fb_10_2.setOnCheckedChangeListener(this);
		cb_fb_10_3.setOnCheckedChangeListener(this);
		cb_fb_10_4.setOnCheckedChangeListener(this);
		cb_fb_10_5.setOnCheckedChangeListener(this);
		cb_fb_10_6.setOnCheckedChangeListener(this);
		cb_fb_10_7.setOnCheckedChangeListener(this);

		cb_fb_11_1.setOnCheckedChangeListener(this);
		cb_fb_11_2.setOnCheckedChangeListener(this);
		cb_fb_11_3.setOnCheckedChangeListener(this);
		cb_fb_11_4.setOnCheckedChangeListener(this);
		cb_fb_11_5.setOnCheckedChangeListener(this);
		cb_fb_11_6.setOnCheckedChangeListener(this);
		cb_fb_11_7.setOnCheckedChangeListener(this);

		cb_fb_12_1.setOnCheckedChangeListener(this);
		cb_fb_12_2.setOnCheckedChangeListener(this);
		cb_fb_12_3.setOnCheckedChangeListener(this);
		cb_fb_12_4.setOnCheckedChangeListener(this);
		cb_fb_12_5.setOnCheckedChangeListener(this);
		cb_fb_12_6.setOnCheckedChangeListener(this);
		cb_fb_12_7.setOnCheckedChangeListener(this);

		return view;
	}

	@Override
	public void onCheckedChanged(CompoundButton cb, boolean ischecked) {
		switch (cb.getId()) {

		// fifth checkbox

		// sixth check box
		case R.id.cb_fb_9_1:
			if (ischecked) {
				cb_fb_9_2.setChecked(false);
				cb_fb_9_3.setChecked(false);
				cb_fb_9_4.setChecked(false);
				cb_fb_9_5.setChecked(false);
				cb_fb_9_6.setChecked(false);
				cb_fb_9_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_9_2:
			if (ischecked) {
				cb_fb_9_1.setChecked(false);
				cb_fb_9_3.setChecked(false);
				cb_fb_9_4.setChecked(false);
				cb_fb_9_5.setChecked(false);
				cb_fb_9_6.setChecked(false);
				cb_fb_9_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_9_3:
			if (ischecked) {
				cb_fb_9_1.setChecked(false);
				cb_fb_9_2.setChecked(false);
				cb_fb_9_4.setChecked(false);
				cb_fb_9_5.setChecked(false);
				cb_fb_9_6.setChecked(false);
				cb_fb_9_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_9_4:
			if (ischecked) {
				cb_fb_9_1.setChecked(false);
				cb_fb_9_2.setChecked(false);
				cb_fb_9_3.setChecked(false);
				cb_fb_9_5.setChecked(false);
				cb_fb_9_6.setChecked(false);
				cb_fb_9_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_9_5:
			if (ischecked) {
				cb_fb_9_1.setChecked(false);
				cb_fb_9_2.setChecked(false);
				cb_fb_9_3.setChecked(false);
				cb_fb_9_4.setChecked(false);
				cb_fb_9_6.setChecked(false);
				cb_fb_9_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_9_6:
			if (ischecked) {
				cb_fb_9_1.setChecked(false);
				cb_fb_9_2.setChecked(false);
				cb_fb_9_3.setChecked(false);
				cb_fb_9_4.setChecked(false);
				cb_fb_9_5.setChecked(false);
				cb_fb_9_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_9_7:
			if (ischecked) {
				cb_fb_9_1.setChecked(false);
				cb_fb_9_2.setChecked(false);
				cb_fb_9_3.setChecked(false);
				cb_fb_9_4.setChecked(false);
				cb_fb_9_5.setChecked(false);
				cb_fb_9_6.setChecked(false);
			}
			break;

		// seven check box
		case R.id.cb_fb_10_1:
			if (ischecked) {
				cb_fb_10_2.setChecked(false);
				cb_fb_10_3.setChecked(false);
				cb_fb_10_4.setChecked(false);
				cb_fb_10_5.setChecked(false);
				cb_fb_10_6.setChecked(false);
				cb_fb_10_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_10_2:
			if (ischecked) {
				cb_fb_10_1.setChecked(false);
				cb_fb_10_3.setChecked(false);
				cb_fb_10_4.setChecked(false);
				cb_fb_10_5.setChecked(false);
				cb_fb_10_6.setChecked(false);
				cb_fb_10_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_10_3:
			if (ischecked) {
				cb_fb_10_1.setChecked(false);
				cb_fb_10_2.setChecked(false);
				cb_fb_10_4.setChecked(false);
				cb_fb_10_5.setChecked(false);
				cb_fb_10_6.setChecked(false);
				cb_fb_10_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_10_4:
			if (ischecked) {
				cb_fb_10_1.setChecked(false);
				cb_fb_10_2.setChecked(false);
				cb_fb_10_3.setChecked(false);
				cb_fb_10_5.setChecked(false);
				cb_fb_10_6.setChecked(false);
				cb_fb_10_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_10_5:
			if (ischecked) {
				cb_fb_10_1.setChecked(false);
				cb_fb_10_2.setChecked(false);
				cb_fb_10_3.setChecked(false);
				cb_fb_10_4.setChecked(false);
				cb_fb_10_6.setChecked(false);
				cb_fb_10_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_10_6:
			if (ischecked) {
				cb_fb_10_1.setChecked(false);
				cb_fb_10_2.setChecked(false);
				cb_fb_10_3.setChecked(false);
				cb_fb_10_4.setChecked(false);
				cb_fb_10_5.setChecked(false);
				cb_fb_10_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_10_7:
			if (ischecked) {
				cb_fb_10_1.setChecked(false);
				cb_fb_10_2.setChecked(false);
				cb_fb_10_3.setChecked(false);
				cb_fb_10_4.setChecked(false);
				cb_fb_10_5.setChecked(false);
				cb_fb_10_6.setChecked(false);
			}
			break;
		case R.id.cb_fb_11_1:
			if (ischecked) {
				cb_fb_11_2.setChecked(false);
				cb_fb_11_3.setChecked(false);
				cb_fb_11_4.setChecked(false);
				cb_fb_11_5.setChecked(false);
				cb_fb_11_6.setChecked(false);
				cb_fb_11_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_11_2:
			if (ischecked) {
				cb_fb_11_1.setChecked(false);
				cb_fb_11_3.setChecked(false);
				cb_fb_11_4.setChecked(false);
				cb_fb_11_5.setChecked(false);
				cb_fb_11_6.setChecked(false);
				cb_fb_11_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_11_3:
			if (ischecked) {
				cb_fb_11_1.setChecked(false);
				cb_fb_11_2.setChecked(false);
				cb_fb_11_4.setChecked(false);
				cb_fb_11_5.setChecked(false);
				cb_fb_11_6.setChecked(false);
				cb_fb_11_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_11_4:
			if (ischecked) {
				cb_fb_11_1.setChecked(false);
				cb_fb_11_2.setChecked(false);
				cb_fb_11_3.setChecked(false);
				cb_fb_11_5.setChecked(false);
				cb_fb_11_6.setChecked(false);
				cb_fb_11_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_11_5:
			if (ischecked) {
				cb_fb_11_1.setChecked(false);
				cb_fb_11_2.setChecked(false);
				cb_fb_11_3.setChecked(false);
				cb_fb_11_4.setChecked(false);
				cb_fb_11_6.setChecked(false);
				cb_fb_11_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_11_6:
			if (ischecked) {
				cb_fb_11_1.setChecked(false);
				cb_fb_11_2.setChecked(false);
				cb_fb_11_3.setChecked(false);
				cb_fb_11_4.setChecked(false);
				cb_fb_11_5.setChecked(false);
				cb_fb_11_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_11_7:
			if (ischecked) {
				cb_fb_11_1.setChecked(false);
				cb_fb_11_2.setChecked(false);
				cb_fb_11_3.setChecked(false);
				cb_fb_11_4.setChecked(false);
				cb_fb_11_5.setChecked(false);
				cb_fb_11_6.setChecked(false);
			}
			break;

		// sixth check box
		case R.id.cb_fb_12_1:
			if (ischecked) {
				cb_fb_12_2.setChecked(false);
				cb_fb_12_3.setChecked(false);
				cb_fb_12_4.setChecked(false);
				cb_fb_12_5.setChecked(false);
				cb_fb_12_6.setChecked(false);
				cb_fb_12_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_12_2:
			if (ischecked) {
				cb_fb_12_1.setChecked(false);
				cb_fb_12_3.setChecked(false);
				cb_fb_12_4.setChecked(false);
				cb_fb_12_5.setChecked(false);
				cb_fb_12_6.setChecked(false);
				cb_fb_12_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_12_3:
			if (ischecked) {
				cb_fb_12_1.setChecked(false);
				cb_fb_12_2.setChecked(false);
				cb_fb_12_4.setChecked(false);
				cb_fb_12_5.setChecked(false);
				cb_fb_12_6.setChecked(false);
				cb_fb_12_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_12_4:
			if (ischecked) {
				cb_fb_12_1.setChecked(false);
				cb_fb_12_2.setChecked(false);
				cb_fb_12_3.setChecked(false);
				cb_fb_12_5.setChecked(false);
				cb_fb_12_6.setChecked(false);
				cb_fb_12_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_12_5:
			if (ischecked) {
				cb_fb_12_1.setChecked(false);
				cb_fb_12_2.setChecked(false);
				cb_fb_12_3.setChecked(false);
				cb_fb_12_4.setChecked(false);
				cb_fb_12_6.setChecked(false);
				cb_fb_12_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_12_6:
			if (ischecked) {
				cb_fb_12_1.setChecked(false);
				cb_fb_12_2.setChecked(false);
				cb_fb_12_3.setChecked(false);
				cb_fb_12_4.setChecked(false);
				cb_fb_12_5.setChecked(false);
				cb_fb_12_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_12_7:
			if (ischecked) {
				cb_fb_12_1.setChecked(false);
				cb_fb_12_2.setChecked(false);
				cb_fb_12_3.setChecked(false);
				cb_fb_12_4.setChecked(false);
				cb_fb_12_5.setChecked(false);
				cb_fb_12_6.setChecked(false);
			}
			break;

		}

		checkAddNextAndRightButton();
	}

	private void checkAddNextAndRightButton() {
		status = true;

		if ((cb_fb_9_1.isChecked()) || (cb_fb_9_2.isChecked())
				|| (cb_fb_9_3.isChecked()) || (cb_fb_9_4.isChecked())
				|| (cb_fb_9_5.isChecked()) || (cb_fb_9_6.isChecked())
				|| (cb_fb_9_7.isChecked())) {
			if ((cb_fb_10_1.isChecked()) || (cb_fb_10_2.isChecked())
					|| (cb_fb_10_3.isChecked()) || (cb_fb_10_4.isChecked())
					|| (cb_fb_10_5.isChecked()) || (cb_fb_10_6.isChecked())
					|| (cb_fb_10_7.isChecked())) {

				if ((cb_fb_11_1.isChecked()) || (cb_fb_11_2.isChecked())
						|| (cb_fb_11_3.isChecked()) || (cb_fb_11_4.isChecked())
						|| (cb_fb_11_5.isChecked()) || (cb_fb_11_6.isChecked())
						|| (cb_fb_11_7.isChecked())) {

					Log.d("111111111111111", "turrrrr");
					if ((cb_fb_12_1.isChecked()) || (cb_fb_12_2.isChecked())
							|| (cb_fb_12_3.isChecked())
							|| (cb_fb_12_4.isChecked())
							|| (cb_fb_12_5.isChecked())
							|| (cb_fb_12_6.isChecked())
							|| (cb_fb_12_7.isChecked())) {
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

		cb_fb_9_1.setChecked(false);
		cb_fb_9_2.setChecked(false);
		cb_fb_9_3.setChecked(false);
		cb_fb_9_4.setChecked(false);
		cb_fb_9_5.setChecked(false);
		cb_fb_9_6.setChecked(false);
		cb_fb_9_7.setChecked(false);

		cb_fb_10_1.setChecked(false);
		cb_fb_10_2.setChecked(false);
		cb_fb_10_3.setChecked(false);
		cb_fb_10_4.setChecked(false);
		cb_fb_10_5.setChecked(false);
		cb_fb_10_6.setChecked(false);
		cb_fb_10_7.setChecked(false);

		cb_fb_11_1.setChecked(false);
		cb_fb_11_2.setChecked(false);
		cb_fb_11_3.setChecked(false);
		cb_fb_11_4.setChecked(false);
		cb_fb_11_5.setChecked(false);
		cb_fb_11_6.setChecked(false);
		cb_fb_11_7.setChecked(false);

		cb_fb_12_1.setChecked(false);
		cb_fb_12_2.setChecked(false);
		cb_fb_12_3.setChecked(false);
		cb_fb_12_4.setChecked(false);
		cb_fb_12_5.setChecked(false);
		cb_fb_12_6.setChecked(false);
		cb_fb_12_7.setChecked(false);
	}
}
