package net.sistransitomobile.main;

import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.appobject.AppObject;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.fragment.AnyPageChangeListener;
import net.sistransitomobile.fragment.UpdateFragment;
import net.sistransitomobile.login.LoginActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockFragment;

public class SplashPageFragment extends SherlockFragment implements
		OnClickListener, UpdateFragment {
	private View view;
	private LinearLayout linear_layout;
	private InstallTask mTask;
	private ProgressBar mProgressBar = null;
	private Button btn_sing_up, btn_login, btn_lets_go;
	private Intent loginIntent;
	private AnyPageChangeListener listener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (MainActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.splash_fragment, null, false);
		loginIntent = new Intent(getActivity(), LoginActivity.class);
		setRetainInstance(true);
		initializedView();
		startViewAnimation();
		getInstallTask();
		return view;
	}

	private void initializedView() {
		btn_lets_go = (Button) view.findViewById(R.id.btn_lets_go);
		btn_sing_up = (Button) view.findViewById(R.id.btn_sign_up);
		btn_login = (Button) view.findViewById(R.id.btn_login);
		mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
	}

	private void startViewAnimation() {

		linear_layout = (LinearLayout) view.findViewById(R.id.linear_layout);

		linear_layout.startAnimation(AppObject
				.getSlideAndScaleAnimition(getActivity()));
	}

	public void updateProgress(Integer integer) {
		mProgressBar.setProgress(integer);

	}

	public void markAsDone() {
		btn_lets_go.setEnabled(true);
		btn_sing_up.setEnabled(true);
		btn_login.setEnabled(true);
		btn_lets_go.setOnClickListener(this);
		btn_login.setOnClickListener(this);
		btn_sing_up.setOnClickListener(this);
	}

	@SuppressWarnings("deprecation")
	private void getInstallTask() {
		mTask = (InstallTask) getActivity().getLastNonConfigurationInstance();
		if (mTask == null) {
			mTask = new InstallTask(this);
			mTask.execute();
		} else {
			mProgressBar.setProgress(100);
		}
	}

	@Override
	public void onClick(View view_id) {
		switch (view_id.getId()) {
		case R.id.btn_lets_go:
			listener.onPageChange(AppConstants.LOING_FRAGMENT_1);
			break;
		case R.id.btn_login:
			startActivityLogin(AppConstants.LOING_FRAGMENT_ID,
					AppConstants.LOING_FRAGMENT_0);
			break;

		case R.id.btn_sign_up:
			startActivityLogin(AppConstants.LOING_FRAGMENT_ID,
					AppConstants.LOING_FRAGMENT_1);
			break;
		}

	}

	private void startActivityLogin(String id, int value) {
		loginIntent.putExtra(id, value);
		startActivityForResult(loginIntent, AppConstants.ACITVITY_REQUEST_CODE);
	}

	@Override
	public void Update() {
		if ((DatabaseCreator.getDatabaseAdapterSetting(getActivity()))
				.getRemerberState()
				&& (DatabaseCreator.getDatabaseAdapterSetting(getActivity()))
						.getPasswordState()) {
			btn_lets_go.setEnabled(true);
		} else {
			btn_lets_go.setEnabled(false);
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == AppConstants.ACITVITY_REQUEST_CODE && data != null) {
			if (data.getBooleanExtra("login", false)) {
				listener.onPageChange(AppConstants.LOING_FRAGMENT_1);
			}

		}
	}

}
