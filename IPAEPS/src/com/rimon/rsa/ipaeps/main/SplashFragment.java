package com.rimon.rsa.ipaeps.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.textview.TitleTextView;

public class SplashFragment extends SherlockFragment {
	private TextView tv_splash, tv_splash_hint;
	ImageView im_splash;
	private AlphaAnimation fadeIn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.main_splash_fragment, null, false);
		im_splash = (ImageView) view.findViewById(R.id.image_splash);
		tv_splash = (TitleTextView) view.findViewById(R.id.tv_splash);
		tv_splash_hint = (TitleTextView) view.findViewById(R.id.tv_splash_hint);
		fadeIn = new AlphaAnimation(0.0f, 1.0f);
		fadeIn.setDuration(3000);
		tv_splash.startAnimation(fadeIn);
		tv_splash_hint.startAnimation(fadeIn);
		im_splash.startAnimation(fadeIn);	
		return view;
	}
}
