package com.rimon.rsa.ibd.questionpatient.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ibd.database.DBAdapter;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.OnSwitchClickListener;
import com.rimon.rsa.ibd.main.StartActivityIBD;
import com.rimon.rsa.mental.R;

public class PatientScore extends SherlockFragment implements UpdateFragment {

	private TextView tv_dip_scrore, tv_anx_scrore, tv_str_scrore;
	private TextView tv_dip_level, tv_anx_level, tv_str_level;
	private TextView tv_mh_profesional;
	private OnSwitchClickListener listener;
	private Button btn_next;

	@Override
	public void onAttach(Activity activity) {
		listener = (StartActivityIBD) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.score_screen_01, null, false);

		tv_dip_scrore = (TextView) view.findViewById(R.id.tv_dip_score);
		tv_anx_scrore = (TextView) view.findViewById(R.id.tv_anx_score);
		tv_str_scrore = (TextView) view.findViewById(R.id.tv_str_score);

		tv_dip_level = (TextView) view.findViewById(R.id.tv_dip_level);
		tv_anx_level = (TextView) view.findViewById(R.id.tv_anx_level);
		tv_str_level = (TextView) view.findViewById(R.id.tv_str_level);

		tv_mh_profesional = (TextView) view
				.findViewById(R.id.tv_mh_profesional);

		SetScore();
		btn_next = (Button) view.findViewById(R.id.btn_score_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new SaveInfo().start();
				listener.onSwitchClick(ConstantValues.PATIENT_LAST_PAGE);
			}
		});

		return view;
	}

	class SaveInfo extends Thread {
		private DBAdapter adapter;

		@Override
		public void run() {
			super.run();
			adapter = new DBAdapter(getActivity());
			adapter.openWriteableDatabase();
			adapter.insert();
			adapter.close();
		}
	}

	@Override
	public void Update() {
		SetScore();

	}

	private void SetScore() {
		tv_dip_scrore.setText(ConstantValues.depression);
		tv_anx_scrore.setText(ConstantValues.anxiety);
		tv_str_scrore.setText(ConstantValues.stress);
		tv_dip_level.setText(ConstantValues.depression_level);
		tv_anx_level.setText(ConstantValues.anxiety_level);
		tv_str_level.setText(ConstantValues.stress_level);
		tv_mh_profesional.setText(ConstantValues.question_34_value);

	}
}
