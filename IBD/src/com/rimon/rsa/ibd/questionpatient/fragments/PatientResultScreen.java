package com.rimon.rsa.ibd.questionpatient.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ibd.database.PasswordDBAdapter;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.OnSwitchClickListener;
import com.rimon.rsa.ibd.main.StartActivityIBD;
import com.rimon.rsa.mental.R;

public class PatientResultScreen extends SherlockFragment implements
		UpdateFragment {
	private OnSwitchClickListener listener;
	private Button next;
	private PasswordDBAdapter passwordDBAdapter;
	private LinearLayout layout_resutl_title;
	private LinearLayout layout_parent, layout_lef, layout_right;
	private TextView tv_title, tv_subtitle, tv_description, tv_bottom;
	private ImageView imageView;

	@Override
	public void onAttach(Activity activity) {
		listener = (StartActivityIBD) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		passwordDBAdapter = new PasswordDBAdapter(getActivity());

		View view = inflater.inflate(R.layout.p_result, null, false);
		layout_resutl_title = (LinearLayout) view
				.findViewById(R.id.lineraLayout_title_reuslt);
		layout_parent = (LinearLayout) view
				.findViewById(R.id.tv_image_layout_parent);
		layout_lef = (LinearLayout) view
				.findViewById(R.id.linerLayout_text_hint_leftside);
		layout_right = (LinearLayout) view
				.findViewById(R.id.linerLayout_image_hine_right_side);
		tv_title = (TextView) view.findViewById(R.id.tv_title);
		tv_subtitle = (TextView) view.findViewById(R.id.tv_sub_title);
		tv_description = (TextView) view
				.findViewById(R.id.tv_result_description);
		tv_bottom = (TextView) view.findViewById(R.id.tv_sub_bottom);
		imageView = (ImageView) view.findViewById(R.id.imv_rsult);

		next = (Button) view.findViewById(R.id.btn_next_result);
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				passwordDBAdapter.openReadableDatabase();
				if (passwordDBAdapter.getQuestionStatus().equals(
						ConstantValues.initial_question_status_true)) {
					// initial_question
					ConstantValues.all_question_status = ConstantValues.STATUS_NO;
					listener.onSwitchClick(ConstantValues.PATIENT_SCORE);
				} else {
					// /all_question
					ConstantValues.all_question_status = ConstantValues.STATUS_YES;
					listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_HELP_2);
				}
				passwordDBAdapter.close();

			}
		});

		resultCalculation();
		setResult();

		return view;
	}

	@Override
	public void Update() {
		resultCalculation();
		setResult();

	}

	private void setResult() {
		if (ConstantValues.result_level.equals(ConstantValues.VERY_LOW)) {
			// no description only image;
			layout_resutl_title
					.setBackgroundResource(R.drawable.level_1_result);

			tv_title.setText(getResources().getString(R.string.level_1_title));
			tv_subtitle.setText(getResources().getString(
					R.string.leve_1_sub_title));
			if (layout_lef.getParent() != null) {
				layout_parent.removeView(layout_lef);
				layout_right.setWeightSum(1);
			}
			imageView.setImageDrawable(getResources().getDrawable(
					R.drawable.level_1and2_image));
			tv_bottom.setText(getResources().getString(
					R.string.result_bottom_01));

		}

		else if (ConstantValues.result_level.equals(ConstantValues.LOW)) {
			// no description only image;
			layout_resutl_title
					.setBackgroundResource(R.drawable.level_2_result);
			tv_title.setText(getResources().getString(R.string.level_2_title));
			tv_subtitle.setText(getResources().getString(
					R.string.leve_2_sub_title));
			if (layout_lef.getParent() != null) {
				layout_parent.removeView(layout_lef);
				layout_right.setWeightSum(1);
			}
			imageView.setImageDrawable(getResources().getDrawable(
					R.drawable.level_1and2_image));
			tv_bottom.setText(getResources().getString(
					R.string.result_bottom_01));
		} else if (ConstantValues.result_level.equals(ConstantValues.MODERATE)) {
			layout_resutl_title
					.setBackgroundResource(R.drawable.level_3_result);
			tv_title.setText(getResources().getString(R.string.level_3_title));
			tv_subtitle.setText(getResources().getString(
					R.string.leve_3_sub_title));
			tv_description.setText(getResources().getString(
					R.string.level_3_4_describtion));
			imageView.setImageDrawable(getResources().getDrawable(
					R.drawable.level_3and4_image));
			tv_bottom.setText(getResources().getString(
					R.string.result_bottom_02));

		} else if (ConstantValues.result_level.equals(ConstantValues.HIGH)) {
			layout_resutl_title
					.setBackgroundResource(R.drawable.level_4_result);
			tv_title.setText(getResources().getString(R.string.level_4_title));
			tv_subtitle.setText(getResources().getString(
					R.string.leve_4_sub_title));
			tv_description.setText(getResources().getString(
					R.string.level_3_4_describtion));
			imageView.setImageDrawable(getResources().getDrawable(
					R.drawable.level_3and4_image));
			tv_bottom.setText(getResources().getString(
					R.string.result_bottom_02));

		}

	}

	private void resultCalculation() {
		CalculateResultLevel calculateResultLevel = new CalculateResultLevel();
		ConstantValues.result_level = calculateResultLevel.calculateResult(
				Integer.valueOf(ConstantValues.depression),
				Integer.valueOf(ConstantValues.anxiety),
				Integer.valueOf(ConstantValues.stress),
				ConstantValues.question_33_value);

		ConstantValues.anxiety_level = calculateResultLevel.get_anxiety_level();
		ConstantValues.depression_level = calculateResultLevel
				.get_depression_level();
		ConstantValues.stress_level = calculateResultLevel.get_stress_level();
	}

}
