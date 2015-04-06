package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.textview.TitleTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module7mhs_fragment_1 extends SherlockFragment {
	private RelativeLayout layout;

	private TitleTextView tvAnyTextView;
	private Animation animation;
	private AnyButton btn_next;
	private AnyPageChangeListener listener;

	@Override
	public void onAttach(Activity activity) {
		listener = (Module7MentalHealth) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.module_7_mhs_fragment_1, null,
				false);
		tvAnyTextView = (TitleTextView) view
				.findViewById(R.id.tv_moudle_7_splash);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);

		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_7_PAGE_2);

			}
		});
		layout = (RelativeLayout) view
				.findViewById(R.id.q_module_7_splash_layut);
		animation = AppObject.getScaleAnimition(getActivity());

		layout.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				enableView();

			}
		});

		return view;
	}

	private void enableView() {
		tvAnyTextView.setEnabled(true);
		btn_next.setEnabled(true);

	}

}
