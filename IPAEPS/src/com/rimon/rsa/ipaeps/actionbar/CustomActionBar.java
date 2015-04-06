package com.rimon.rsa.ipaeps.actionbar;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.textview.AnyTextView;

public class CustomActionBar {
	private Activity context;
	private TextView tv_action_bar;
	private ImageView im_action_bar;
	private ImageButton im_btn_back;

	public CustomActionBar(Activity geActivity) {
		this.context = geActivity;
	}

	public void setupActionBarWithBack(ActionBar actionBar, int icon, int title) {
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View localView = context.getLayoutInflater().inflate(
				R.layout.action_bar_layout_with_back, null);
		actionBar.setCustomView(localView, new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT));
		tv_action_bar = (AnyTextView) localView
				.findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(context.getResources().getString(title));
		im_action_bar = (ImageView) localView.findViewById(R.id.im_action_bar);
		im_action_bar.setBackgroundResource(icon);
		im_btn_back = (ImageButton) localView.findViewById(R.id.im_btn_back);
		im_btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				context.finish();
			}
		});

	}

}
