package com.rimon.rsa.ipaeps.module_16_last_screen;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appobject.AppObject;
import com.rimon.rsa.ipaeps.button.AnyButton;

public class Module16LastScreen extends SherlockActivity {

	private AnyButton btn_nexButton;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.module_16_last_page);
		imageView = (ImageView) findViewById(R.id.im_lastScreen);
		AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
		fadeIn.setDuration(3000);
		imageView.startAnimation(fadeIn);
		imageView.startAnimation(fadeIn);
		imageView.startAnimation(fadeIn);

		btn_nexButton = (AnyButton) findViewById(R.id.btn_last_next);
		btn_nexButton.setTypeface(AppObject
				.getCurrentFont(Module16LastScreen.this));
		btn_nexButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return false;

		}
		return false;
	}

}
