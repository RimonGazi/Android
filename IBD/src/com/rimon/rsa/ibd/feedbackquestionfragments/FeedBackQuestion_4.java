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

;

public class FeedBackQuestion_4 extends SherlockFragment implements
		OnCheckedChangeListener, UpdateFragment {

	private CheckBox cb_fb_13_1, cb_fb_13_2;
	private CheckBox cb_fb_14_1, cb_fb_14_2, cb_fb_14_3, cb_fb_14_4,
			cb_fb_14_5, cb_fb_14_6, cb_fb_14_7;
	private CheckBox cb_fb_15_1, cb_fb_15_2, cb_fb_15_3, cb_fb_15_4,
			cb_fb_15_5, cb_fb_15_6, cb_fb_15_7;

	private CheckBox cb_fb_16_1, cb_fb_16_2, cb_fb_16_3, cb_fb_16_4,
			cb_fb_16_5, cb_fb_16_6, cb_fb_16_7;
	private CheckBox cb_fb_17_1, cb_fb_17_2, cb_fb_17_3, cb_fb_17_4,
			cb_fb_17_5, cb_fb_17_6, cb_fb_17_7;

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

		View view = inflater.inflate(R.layout.pfq_4, null, false);
		layout = (RelativeLayout) view.findViewById(R.id.fb_4_remove_layout);
		btn_next = (Button) view.findViewById(R.id.btn_fb_4_next);
		btn_right = (Button) view.findViewById(R.id.btn_fb_4_right);
		btn_back = (Button) view.findViewById(R.id.btn_fb_4_back);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (cb_fb_13_1.isChecked()) {
					ConstantValues.f_question_13_value = getActivity()
							.getResources()
							.getString(R.string.face_to_face_only).trim();
				} else if (cb_fb_13_2.isChecked()) {
					ConstantValues.f_question_13_value = getActivity()
							.getResources()
							.getString(R.string.face_to_face_service).trim();
				}
				if (cb_fb_14_1.isChecked()) {
					ConstantValues.f_question_14_value = "1";
				} else if (cb_fb_14_2.isChecked()) {
					ConstantValues.f_question_14_value = "2";
				} else if (cb_fb_14_3.isChecked()) {
					ConstantValues.f_question_14_value = "3";
				} else if (cb_fb_14_4.isChecked()) {
					ConstantValues.f_question_14_value = "4";
				} else if (cb_fb_14_5.isChecked()) {
					ConstantValues.f_question_14_value = "5";
				} else if (cb_fb_14_6.isChecked()) {
					ConstantValues.f_question_14_value = "6";
				} else if (cb_fb_14_7.isChecked()) {
					ConstantValues.f_question_14_value = "7";
				}
				if (cb_fb_15_1.isChecked()) {
					ConstantValues.f_question_15_value = "1";
				} else if (cb_fb_15_2.isChecked()) {
					ConstantValues.f_question_15_value = "2";
				} else if (cb_fb_15_3.isChecked()) {
					ConstantValues.f_question_15_value = "3";
				} else if (cb_fb_15_4.isChecked()) {
					ConstantValues.f_question_15_value = "4";
				} else if (cb_fb_15_5.isChecked()) {
					ConstantValues.f_question_15_value = "5";
				} else if (cb_fb_15_6.isChecked()) {
					ConstantValues.f_question_15_value = "6";
				} else if (cb_fb_15_7.isChecked()) {
					ConstantValues.f_question_15_value = "7";
				}
				if (cb_fb_16_1.isChecked()) {
					ConstantValues.f_question_16_value = "1";
				} else if (cb_fb_16_2.isChecked()) {
					ConstantValues.f_question_16_value = "2";
				} else if (cb_fb_16_3.isChecked()) {
					ConstantValues.f_question_16_value = "3";
				} else if (cb_fb_16_4.isChecked()) {
					ConstantValues.f_question_16_value = "4";
				} else if (cb_fb_16_5.isChecked()) {
					ConstantValues.f_question_16_value = "5";
				} else if (cb_fb_16_6.isChecked()) {
					ConstantValues.f_question_16_value = "6";
				} else if (cb_fb_16_7.isChecked()) {
					ConstantValues.f_question_16_value = "7";
				}
				if (cb_fb_17_1.isChecked()) {
					ConstantValues.f_question_17_value = "1";
				} else if (cb_fb_17_2.isChecked()) {
					ConstantValues.f_question_17_value = "2";
				} else if (cb_fb_17_3.isChecked()) {
					ConstantValues.f_question_17_value = "3";
				} else if (cb_fb_17_4.isChecked()) {
					ConstantValues.f_question_17_value = "4";
				} else if (cb_fb_17_5.isChecked()) {
					ConstantValues.f_question_17_value = "5";
				} else if (cb_fb_17_6.isChecked()) {
					ConstantValues.f_question_17_value = "6";
				} else if (cb_fb_17_7.isChecked()) {
					ConstantValues.f_question_17_value = "7";
				}
				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_SECONS_HELP_PAGE);

			}
		});
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				listener.onSwitchClick(ConstantValues.FEEDBACK_QUESTION_THIRD_PAGE);

			}
		});

		if (btn_right.getParent() != null)
			layout.removeView(btn_right);
		if (btn_next.getParent() != null)
			layout.removeView(btn_next);

		cb_fb_13_1 = (CheckBox) view.findViewById(R.id.cb_fb_13_1);
		cb_fb_13_2 = (CheckBox) view.findViewById(R.id.cb_fb_13_2);
		cb_fb_14_1 = (CheckBox) view.findViewById(R.id.cb_fb_14_1);
		cb_fb_14_2 = (CheckBox) view.findViewById(R.id.cb_fb_14_2);
		cb_fb_14_3 = (CheckBox) view.findViewById(R.id.cb_fb_14_3);
		cb_fb_14_4 = (CheckBox) view.findViewById(R.id.cb_fb_14_4);
		cb_fb_14_5 = (CheckBox) view.findViewById(R.id.cb_fb_14_5);
		cb_fb_14_6 = (CheckBox) view.findViewById(R.id.cb_fb_14_6);
		cb_fb_14_7 = (CheckBox) view.findViewById(R.id.cb_fb_14_7);

		cb_fb_15_1 = (CheckBox) view.findViewById(R.id.cb_fb_15_1);
		cb_fb_15_2 = (CheckBox) view.findViewById(R.id.cb_fb_15_2);
		cb_fb_15_3 = (CheckBox) view.findViewById(R.id.cb_fb_15_3);
		cb_fb_15_4 = (CheckBox) view.findViewById(R.id.cb_fb_15_4);
		cb_fb_15_5 = (CheckBox) view.findViewById(R.id.cb_fb_15_5);
		cb_fb_15_6 = (CheckBox) view.findViewById(R.id.cb_fb_15_6);
		cb_fb_15_7 = (CheckBox) view.findViewById(R.id.cb_fb_15_7);

		cb_fb_16_1 = (CheckBox) view.findViewById(R.id.cb_fb_16_1);
		cb_fb_16_2 = (CheckBox) view.findViewById(R.id.cb_fb_16_2);
		cb_fb_16_3 = (CheckBox) view.findViewById(R.id.cb_fb_16_3);
		cb_fb_16_4 = (CheckBox) view.findViewById(R.id.cb_fb_16_4);
		cb_fb_16_5 = (CheckBox) view.findViewById(R.id.cb_fb_16_5);
		cb_fb_16_6 = (CheckBox) view.findViewById(R.id.cb_fb_16_6);
		cb_fb_16_7 = (CheckBox) view.findViewById(R.id.cb_fb_16_7);

		cb_fb_17_1 = (CheckBox) view.findViewById(R.id.cb_fb_17_1);
		cb_fb_17_2 = (CheckBox) view.findViewById(R.id.cb_fb_17_2);
		cb_fb_17_3 = (CheckBox) view.findViewById(R.id.cb_fb_17_3);
		cb_fb_17_4 = (CheckBox) view.findViewById(R.id.cb_fb_17_4);
		cb_fb_17_5 = (CheckBox) view.findViewById(R.id.cb_fb_17_5);
		cb_fb_17_6 = (CheckBox) view.findViewById(R.id.cb_fb_17_6);
		cb_fb_17_7 = (CheckBox) view.findViewById(R.id.cb_fb_17_7);

		cb_fb_16_1.setOnCheckedChangeListener(this);
		cb_fb_16_2.setOnCheckedChangeListener(this);
		cb_fb_16_3.setOnCheckedChangeListener(this);
		cb_fb_16_4.setOnCheckedChangeListener(this);
		cb_fb_16_5.setOnCheckedChangeListener(this);
		cb_fb_16_6.setOnCheckedChangeListener(this);
		cb_fb_16_7.setOnCheckedChangeListener(this);

		cb_fb_17_1.setOnCheckedChangeListener(this);
		cb_fb_17_2.setOnCheckedChangeListener(this);
		cb_fb_17_3.setOnCheckedChangeListener(this);
		cb_fb_17_4.setOnCheckedChangeListener(this);
		cb_fb_17_5.setOnCheckedChangeListener(this);
		cb_fb_17_6.setOnCheckedChangeListener(this);
		cb_fb_17_7.setOnCheckedChangeListener(this);

		cb_fb_13_1.setOnCheckedChangeListener(this);
		cb_fb_13_2.setOnCheckedChangeListener(this);

		cb_fb_14_1.setOnCheckedChangeListener(this);
		cb_fb_14_2.setOnCheckedChangeListener(this);
		cb_fb_14_3.setOnCheckedChangeListener(this);
		cb_fb_14_4.setOnCheckedChangeListener(this);
		cb_fb_14_5.setOnCheckedChangeListener(this);
		cb_fb_14_6.setOnCheckedChangeListener(this);
		cb_fb_14_7.setOnCheckedChangeListener(this);

		cb_fb_15_1.setOnCheckedChangeListener(this);
		cb_fb_15_2.setOnCheckedChangeListener(this);
		cb_fb_15_3.setOnCheckedChangeListener(this);
		cb_fb_15_4.setOnCheckedChangeListener(this);
		cb_fb_15_5.setOnCheckedChangeListener(this);
		cb_fb_15_6.setOnCheckedChangeListener(this);
		cb_fb_15_7.setOnCheckedChangeListener(this);

		return view;
	}

	@Override
	public void onCheckedChanged(CompoundButton cb, boolean ischecked) {

		switch (cb.getId()) {

		// fifth checkbox

		// seven check box
		case R.id.cb_fb_13_1:
			if (ischecked) {
				cb_fb_13_2.setChecked(false);

			}
			break;
		case R.id.cb_fb_13_2:
			if (ischecked) {
				cb_fb_13_1.setChecked(false);

			}
			break;
		case R.id.cb_fb_14_1:
			if (ischecked) {
				cb_fb_14_2.setChecked(false);
				cb_fb_14_3.setChecked(false);
				cb_fb_14_4.setChecked(false);
				cb_fb_14_5.setChecked(false);
				cb_fb_14_6.setChecked(false);
				cb_fb_14_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_14_2:
			if (ischecked) {
				cb_fb_14_1.setChecked(false);
				cb_fb_14_3.setChecked(false);
				cb_fb_14_4.setChecked(false);
				cb_fb_14_5.setChecked(false);
				cb_fb_14_6.setChecked(false);
				cb_fb_14_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_14_3:
			if (ischecked) {
				cb_fb_14_1.setChecked(false);
				cb_fb_14_2.setChecked(false);
				cb_fb_14_4.setChecked(false);
				cb_fb_14_5.setChecked(false);
				cb_fb_14_6.setChecked(false);
				cb_fb_14_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_14_4:
			if (ischecked) {
				cb_fb_14_1.setChecked(false);
				cb_fb_14_2.setChecked(false);
				cb_fb_14_3.setChecked(false);
				cb_fb_14_5.setChecked(false);
				cb_fb_14_6.setChecked(false);
				cb_fb_14_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_14_5:
			if (ischecked) {
				cb_fb_14_1.setChecked(false);
				cb_fb_14_2.setChecked(false);
				cb_fb_14_3.setChecked(false);
				cb_fb_14_4.setChecked(false);
				cb_fb_14_6.setChecked(false);
				cb_fb_14_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_14_6:
			if (ischecked) {
				cb_fb_14_1.setChecked(false);
				cb_fb_14_2.setChecked(false);
				cb_fb_14_3.setChecked(false);
				cb_fb_14_4.setChecked(false);
				cb_fb_14_5.setChecked(false);
				cb_fb_14_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_14_7:
			if (ischecked) {
				cb_fb_14_1.setChecked(false);
				cb_fb_14_2.setChecked(false);
				cb_fb_14_3.setChecked(false);
				cb_fb_14_4.setChecked(false);
				cb_fb_14_5.setChecked(false);
				cb_fb_14_6.setChecked(false);
			}
			break;

		// sixth check box
		case R.id.cb_fb_15_1:
			if (ischecked) {
				cb_fb_15_2.setChecked(false);
				cb_fb_15_3.setChecked(false);
				cb_fb_15_4.setChecked(false);
				cb_fb_15_5.setChecked(false);
				cb_fb_15_6.setChecked(false);
				cb_fb_15_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_15_2:
			if (ischecked) {
				cb_fb_15_1.setChecked(false);
				cb_fb_15_3.setChecked(false);
				cb_fb_15_4.setChecked(false);
				cb_fb_15_5.setChecked(false);
				cb_fb_15_6.setChecked(false);
				cb_fb_15_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_15_3:
			if (ischecked) {
				cb_fb_15_1.setChecked(false);
				cb_fb_15_2.setChecked(false);
				cb_fb_15_4.setChecked(false);
				cb_fb_15_5.setChecked(false);
				cb_fb_15_6.setChecked(false);
				cb_fb_15_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_15_4:
			if (ischecked) {
				cb_fb_15_1.setChecked(false);
				cb_fb_15_2.setChecked(false);
				cb_fb_15_3.setChecked(false);
				cb_fb_15_5.setChecked(false);
				cb_fb_15_6.setChecked(false);
				cb_fb_15_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_15_5:
			if (ischecked) {
				cb_fb_15_1.setChecked(false);
				cb_fb_15_2.setChecked(false);
				cb_fb_15_3.setChecked(false);
				cb_fb_15_4.setChecked(false);
				cb_fb_15_6.setChecked(false);
				cb_fb_15_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_15_6:
			if (ischecked) {
				cb_fb_15_1.setChecked(false);
				cb_fb_15_2.setChecked(false);
				cb_fb_15_3.setChecked(false);
				cb_fb_15_4.setChecked(false);
				cb_fb_15_5.setChecked(false);
				cb_fb_15_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_15_7:
			if (ischecked) {
				cb_fb_15_1.setChecked(false);
				cb_fb_15_2.setChecked(false);
				cb_fb_15_3.setChecked(false);
				cb_fb_15_4.setChecked(false);
				cb_fb_15_5.setChecked(false);
				cb_fb_15_6.setChecked(false);
			}
			break;
		case R.id.cb_fb_16_1:
			if (ischecked) {
				cb_fb_16_2.setChecked(false);
				cb_fb_16_3.setChecked(false);
				cb_fb_16_4.setChecked(false);
				cb_fb_16_5.setChecked(false);
				cb_fb_16_6.setChecked(false);
				cb_fb_16_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_16_2:
			if (ischecked) {
				cb_fb_16_1.setChecked(false);
				cb_fb_16_3.setChecked(false);
				cb_fb_16_4.setChecked(false);
				cb_fb_16_5.setChecked(false);
				cb_fb_16_6.setChecked(false);
				cb_fb_16_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_16_3:
			if (ischecked) {
				cb_fb_16_1.setChecked(false);
				cb_fb_16_2.setChecked(false);
				cb_fb_16_4.setChecked(false);
				cb_fb_16_5.setChecked(false);
				cb_fb_16_6.setChecked(false);
				cb_fb_16_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_16_4:
			if (ischecked) {
				cb_fb_16_1.setChecked(false);
				cb_fb_16_2.setChecked(false);
				cb_fb_16_3.setChecked(false);
				cb_fb_16_5.setChecked(false);
				cb_fb_16_6.setChecked(false);
				cb_fb_16_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_16_5:
			if (ischecked) {
				cb_fb_16_1.setChecked(false);
				cb_fb_16_2.setChecked(false);
				cb_fb_16_3.setChecked(false);
				cb_fb_16_4.setChecked(false);
				cb_fb_16_6.setChecked(false);
				cb_fb_16_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_16_6:
			if (ischecked) {
				cb_fb_16_1.setChecked(false);
				cb_fb_16_2.setChecked(false);
				cb_fb_16_3.setChecked(false);
				cb_fb_16_4.setChecked(false);
				cb_fb_16_5.setChecked(false);
				cb_fb_16_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_16_7:
			if (ischecked) {
				cb_fb_16_1.setChecked(false);
				cb_fb_16_2.setChecked(false);
				cb_fb_16_3.setChecked(false);
				cb_fb_16_4.setChecked(false);
				cb_fb_16_5.setChecked(false);
				cb_fb_16_6.setChecked(false);
			}
			break;

		// sixth check box
		case R.id.cb_fb_17_1:
			if (ischecked) {
				cb_fb_17_2.setChecked(false);
				cb_fb_17_3.setChecked(false);
				cb_fb_17_4.setChecked(false);
				cb_fb_17_5.setChecked(false);
				cb_fb_17_6.setChecked(false);
				cb_fb_17_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_17_2:
			if (ischecked) {
				cb_fb_17_1.setChecked(false);
				cb_fb_17_3.setChecked(false);
				cb_fb_17_4.setChecked(false);
				cb_fb_17_5.setChecked(false);
				cb_fb_17_6.setChecked(false);
				cb_fb_17_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_17_3:
			if (ischecked) {
				cb_fb_17_1.setChecked(false);
				cb_fb_17_2.setChecked(false);
				cb_fb_17_4.setChecked(false);
				cb_fb_17_5.setChecked(false);
				cb_fb_17_6.setChecked(false);
				cb_fb_17_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_17_4:
			if (ischecked) {
				cb_fb_17_1.setChecked(false);
				cb_fb_17_2.setChecked(false);
				cb_fb_17_3.setChecked(false);
				cb_fb_17_5.setChecked(false);
				cb_fb_17_6.setChecked(false);
				cb_fb_17_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_17_5:
			if (ischecked) {
				cb_fb_17_1.setChecked(false);
				cb_fb_17_2.setChecked(false);
				cb_fb_17_3.setChecked(false);
				cb_fb_17_4.setChecked(false);
				cb_fb_17_6.setChecked(false);
				cb_fb_17_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_17_6:
			if (ischecked) {
				cb_fb_17_1.setChecked(false);
				cb_fb_17_2.setChecked(false);
				cb_fb_17_3.setChecked(false);
				cb_fb_17_4.setChecked(false);
				cb_fb_17_5.setChecked(false);
				cb_fb_17_7.setChecked(false);
			}
			break;
		case R.id.cb_fb_17_7:
			if (ischecked) {
				cb_fb_17_1.setChecked(false);
				cb_fb_17_2.setChecked(false);
				cb_fb_17_3.setChecked(false);
				cb_fb_17_4.setChecked(false);
				cb_fb_17_5.setChecked(false);
				cb_fb_17_6.setChecked(false);
			}
			break;

		}
		checkAddNextAndRightButton();

	}

	private void checkAddNextAndRightButton() {

		status = true;

		Log.d("1222222222222222222222222222", "tttttttttttttttttt");
		if ((cb_fb_13_1.isChecked()) || (cb_fb_13_2.isChecked())) {
			if ((cb_fb_14_1.isChecked()) || (cb_fb_14_2.isChecked())
					|| (cb_fb_14_3.isChecked()) || (cb_fb_14_4.isChecked())
					|| (cb_fb_14_5.isChecked()) || (cb_fb_14_6.isChecked())
					|| (cb_fb_14_7.isChecked())) {

				Log.d("111111111111111", "turrrrr");
				if ((cb_fb_15_1.isChecked()) || (cb_fb_15_2.isChecked())
						|| (cb_fb_15_3.isChecked()) || (cb_fb_15_4.isChecked())
						|| (cb_fb_15_5.isChecked()) || (cb_fb_15_6.isChecked())
						|| (cb_fb_15_7.isChecked())) {

					if ((cb_fb_16_1.isChecked()) || (cb_fb_16_2.isChecked())
							|| (cb_fb_16_3.isChecked())
							|| (cb_fb_16_4.isChecked())
							|| (cb_fb_16_5.isChecked())
							|| (cb_fb_16_6.isChecked())
							|| (cb_fb_16_7.isChecked())) {

						Log.d("111111111111111", "turrrrr");
						if ((cb_fb_17_1.isChecked())
								|| (cb_fb_17_2.isChecked())
								|| (cb_fb_17_3.isChecked())
								|| (cb_fb_17_4.isChecked())
								|| (cb_fb_17_5.isChecked())
								|| (cb_fb_17_6.isChecked())
								|| (cb_fb_17_7.isChecked())) {
							Log.d("33333333333333333333333333",
									"tttttttttttttttttt");
							status = false;
							if (btn_right.getParent() == null)
								layout.addView(btn_right);
							if (btn_next.getParent() == null)
								layout.addView(btn_next);
						}
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

		cb_fb_13_1.setChecked(false);
		cb_fb_13_2.setChecked(false);

		cb_fb_14_1.setChecked(false);
		cb_fb_14_2.setChecked(false);
		cb_fb_14_3.setChecked(false);
		cb_fb_14_4.setChecked(false);
		cb_fb_14_5.setChecked(false);
		cb_fb_14_6.setChecked(false);
		cb_fb_14_7.setChecked(false);

		cb_fb_15_1.setChecked(false);
		cb_fb_15_2.setChecked(false);
		cb_fb_15_3.setChecked(false);
		cb_fb_15_4.setChecked(false);
		cb_fb_15_5.setChecked(false);
		cb_fb_15_6.setChecked(false);
		cb_fb_15_7.setChecked(false);

		cb_fb_16_1.setChecked(false);
		cb_fb_16_2.setChecked(false);
		cb_fb_16_3.setChecked(false);
		cb_fb_16_4.setChecked(false);
		cb_fb_16_5.setChecked(false);
		cb_fb_16_6.setChecked(false);
		cb_fb_16_7.setChecked(false);

		cb_fb_17_1.setChecked(false);
		cb_fb_17_2.setChecked(false);
		cb_fb_17_3.setChecked(false);
		cb_fb_17_4.setChecked(false);
		cb_fb_17_5.setChecked(false);
		cb_fb_17_6.setChecked(false);
		cb_fb_17_7.setChecked(false);
		// Toast.makeText(getActivity(), "4", Toast.LENGTH_LONG).show();
	}

}
