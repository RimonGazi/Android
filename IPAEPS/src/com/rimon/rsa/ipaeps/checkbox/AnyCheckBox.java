package com.rimon.rsa.ipaeps.checkbox;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.rimon.rsa.ipaeps.appobject.AppObject;

public class AnyCheckBox extends RadioButton {
	Context context;

	public AnyCheckBox(Context context) {
		super(context);
		this.context = context;
		init();

	}

	public AnyCheckBox(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);
		this.context = context;
		init();
	}

	public AnyCheckBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	private void init() {
		setTypeface(AppObject.getCurrentFont(context));

	}

}
