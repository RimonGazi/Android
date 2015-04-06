package net.sistransitomobile.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class AnyTextView extends TextView {

	public AnyTextView(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);

		init();
	}

	public AnyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	public AnyTextView(Context context) {
		super(context);

		init();
	}

	private void init() {
		// setTypeface(AppObject.getTf_normal(getContext()));
	//	setTypeface(AppObject.getCurrentFont(getContext()));
		
	}

}
