package com.rimon.rsa.ipaeps.customtextandcolor;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

public class CustomTextAndColor {

	private SpannableStringBuilder spannableString;
	private Typeface typeface;
	private int foregroundColorSpan;

	public CustomTextAndColor(int foregroundColorSpan, Typeface typeface) {
		this.typeface = typeface;
		this.foregroundColorSpan = foregroundColorSpan;
	}
	public SpannableStringBuilder setTextColor(String text) {
		spannableString = new SpannableStringBuilder(text);
		spannableString.setSpan(typeface, 0, text.length(), 0);
		spannableString.setSpan(new ForegroundColorSpan(foregroundColorSpan),
				0, text.length(), 0);
		return spannableString;
	}
}
