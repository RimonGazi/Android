package com.rimon.rsa.ipaeps.edittext;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.rimon.rsa.ipaeps.appobject.AppObject;

public class AnyEditText extends EditText {

	public AnyEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();

	}

	public AnyEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public AnyEditText(Context context) {
		super(context);
		init();
	}

	private void init() {
		setTypeface(AppObject.getCurrentFont(getContext()));
	}
}
