package net.sistransitomobile.textview;

import net.sistransitomobile.appobject.AppObject;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class AnyTextViewTitle extends TextView {

	public AnyTextViewTitle(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);

		init();
	}

	public AnyTextViewTitle(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	public AnyTextViewTitle(Context context) {
		super(context);

		init();
	}

	private void init() {
		setTypeface(AppObject.getTitlefont(getContext()));
	}

}
