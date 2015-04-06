package com.rimon.rsa.ipaeps.radiobutton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.rimon.rsa.ipaeps.appobject.AppObject;

public class AnyRadioButtonWithTitleText extends RadioButton {

	public AnyRadioButtonWithTitleText(Context context) {
		super(context);

		init();

	}

	public AnyRadioButtonWithTitleText(Context context, AttributeSet attrs,
			int defStyle) {

		super(context, attrs, defStyle);

		init();
	}

	public AnyRadioButtonWithTitleText(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	private void init() {
		setTypeface(AppObject.getCurrentFont(getContext()));

	}

}
