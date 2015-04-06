package com.rimon.rsa.ipaeps.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.rimon.rsa.ipaeps.appobject.AppObject;

public class TitleTextView extends TextView {

	public TitleTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		init();
	}

	public TitleTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	public TitleTextView(Context context) {
		super(context);

		init();
	}

	private void init() {
		setTypeface(AppObject.getCurrentFont(getContext()));
	}

}
