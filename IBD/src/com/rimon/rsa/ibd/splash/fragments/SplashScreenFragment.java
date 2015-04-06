package com.rimon.rsa.ibd.splash.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ibd.delete.DeleteLogView;
import com.rimon.rsa.ibd.export.Export;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.main.OnSwitchClickListener;
import com.rimon.rsa.ibd.main.StartActivityIBD;
import com.rimon.rsa.ibd.print.ActivityPrint;
import com.rimon.rsa.ibd.setting.Setting;
import com.rimon.rsa.mental.R;

public class SplashScreenFragment extends SherlockFragment implements
		View.OnClickListener {

	private Button btn_start, btn_log, btn_print, btn_export, btn_delete,
			btn_password;

	private OnSwitchClickListener listener;

	@Override
	public void onAttach(Activity activity) {
		listener = (StartActivityIBD) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.splash_screen, null, false);
		btn_start = (Button) view.findViewById(R.id.splash_btn_start);
		btn_start.setOnClickListener(this);
		btn_log = (Button) view.findViewById(R.id.splash_btn_log);
		btn_log.setOnClickListener(this);
		btn_print = (Button) view.findViewById(R.id.splash_btn_print);
		btn_print.setOnClickListener(this);
		btn_export = (Button) view.findViewById(R.id.splash_btn_export);
		btn_export.setOnClickListener(this);
		btn_delete = (Button) view.findViewById(R.id.splash_btn_delete);
		btn_delete.setOnClickListener(this);
		btn_password = (Button) view.findViewById(R.id.splash_btn_password);
		btn_password.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.splash_btn_start:
			listener.onSwitchClick(ConstantValues.PATIENT_QUESTION_START_PAGE);
			break;
		case R.id.splash_btn_log:
			getActivity().startActivity(
					new Intent(getActivity(),
							com.rimon.rsa.ibd.log.LogView.class));

			break;
		case R.id.splash_btn_print:
			// PDF pdf = new PDF(getActivity());
			// try {
			// Log.d("ppppppppppppppppppp", "ccccccccccccccc");
			// pdf.cteatePDf();
			// } catch (FileNotFoundException e) {
			//
			// e.printStackTrace();
			// }

			startActivity(new Intent(getActivity(), ActivityPrint.class));

			break;
		case R.id.splash_btn_password:

			startActivity(new Intent(getActivity(), Setting.class));

			break;
		case R.id.splash_btn_export:
			startActivity(new Intent(getActivity(), Export.class));

			break;
		case R.id.splash_btn_delete:
			startActivity(new Intent(getActivity(), DeleteLogView.class));

			break;
		}

	}
}
