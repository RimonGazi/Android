package com.rimon.rsa.ipaeps.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.classtorun.ClassRunActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogPasswordForFragment;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogPasswordListener;
import com.rimon.rsa.ipaeps.export.Export;
import com.rimon.rsa.ipaeps.patientlog.PatientLog;
import com.rimon.rsa.ipaeps.patientlogdelete.PatientLogDelete;
import com.rimon.rsa.ipaeps.patientreport.PatientReport;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;
import com.rimon.rsa.ipaes.setting.SettingActivity;

public class StartPageFragment extends SherlockFragment implements
		OnClickListener, AnyDialogPasswordListener, UpdateFragment {
	private Button btn_start, btn_log, btn_print, btn_export, btn_setting,
			btn_delete;
	private Animation animation;
	private RelativeLayout rl_footer;
	private AnyTextView tv_action_bar;
	private ImageView im_action_bar;
	private boolean isSingleDiaglog = true;
	private AnyDiaglogPasswordForFragment anyDiaglogPassword;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		anyDiaglogPassword = new AnyDiaglogPasswordForFragment();
		anyDiaglogPassword.setCancelable(false);
		anyDiaglogPassword.setTargetFragment(this, 0);
		View view = inflater.inflate(R.layout.main_startpage_fragment, null,
				false);

		tv_action_bar = (AnyTextView) view.findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(getActivity().getResources().getString(
				R.string.app_name_cap));
		im_action_bar = (ImageView) view.findViewById(R.id.im_action_bar);
		im_action_bar.setBackgroundResource(R.drawable.ic_action_ber_start);

		btn_start = (Button) view.findViewById(R.id.btn_start);
		btn_log = (Button) view.findViewById(R.id.btn_log);

		btn_setting = (Button) view.findViewById(R.id.btn_setting);
		btn_print = (Button) view.findViewById(R.id.btn_print);
		btn_export = (Button) view.findViewById(R.id.btn_export);
		btn_delete = (Button) view.findViewById(R.id.btn_delete);
		btn_start.setOnClickListener(this);
		btn_log.setOnClickListener(this);
		btn_setting.setOnClickListener(this);
		btn_print.setOnClickListener(this);
		btn_export.setOnClickListener(this);
		btn_delete.setOnClickListener(this);

		animation = AppObject.getScaleAnimition(getActivity());

		rl_footer = (RelativeLayout) view.findViewById(R.id.rt_footer);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				btn_start.setEnabled(true);
				btn_log.setEnabled(true);
				btn_setting.setEnabled(true);
				btn_print.setEnabled(true);
				btn_export.setEnabled(true);
				btn_delete.setEnabled(true);
			}
		});
		return view;
	}

	@Override
	public void Update() {
		// btn_start.startAnimation(animation);
		rl_footer.startAnimation(animation);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_start:
			AppConstants.setDefaultDAtaAll();
			ClassRunActivity classRunActivity = new ClassRunActivity(
					getActivity());

			for (int i = 0; i < classRunActivity.getClassToRun().size(); i++) {
				Log.d("name " + i, classRunActivity.getClassToRun().get(i) + "");
			}

			Intent intent = new Intent(getActivity(), classRunActivity
					.getClassToRun().get(0));
			Bundle bundle = new Bundle();
			bundle.putSerializable(ClassRunActivity.RUNID,
					classRunActivity.getClassToRun());

			bundle.putInt("order", 1);
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case R.id.btn_log:
			startActivity(new Intent(getActivity(), PatientLog.class));

			break;
		case R.id.btn_setting:
			if (isSingleDiaglog) {
				isSingleDiaglog = false;
				anyDiaglogPassword.show(getActivity()
						.getSupportFragmentManager(), "password");
			}
			break;
		case R.id.btn_print:

			startActivity(new Intent(getActivity(), PatientReport.class));

			break;
		case R.id.btn_export:
			startActivity(new Intent(getActivity(), Export.class));

			break;
		case R.id.btn_delete:
			startActivity(new Intent(getActivity(), PatientLogDelete.class));
			break;

		}

	}

	@Override
	public void onClickPasswordDialog(boolean isPasswordCorrect) {
		isSingleDiaglog = true;
		if (isPasswordCorrect) {
			startActivity(new Intent(getActivity(), SettingActivity.class));
		}

	}
}