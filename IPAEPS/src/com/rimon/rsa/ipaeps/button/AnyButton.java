package com.rimon.rsa.ipaeps.button;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.rimon.rsa.ipaeps.appobject.AppObject;

public class AnyButton extends Button {

	public AnyButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public AnyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public AnyButton(Context context) {
		super(context);
		init();
	}

	private void init() {
		setTypeface(AppObject.getCurrentFont(getContext()));
	}

}
