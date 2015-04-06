package com.rimon.rsa.ipaeps.radiobutton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.rimon.rsa.ipaeps.appobject.AppObject;

public class AnyRadioButton extends RadioButton {
	public AnyRadioButton(Context context) {
		super(context);

		init();

	}

	public AnyRadioButton(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);

		init();
	}

	public AnyRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	private void init() {
		// setTypeface(AppObject.getTf_normal(context));
		setTypeface(AppObject.getCurrentFont(getContext()));

	}

}
