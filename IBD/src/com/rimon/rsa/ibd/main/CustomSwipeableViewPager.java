package com.rimon.rsa.ibd.main;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomSwipeableViewPager extends ViewPager {
	public static int width, height;
	private boolean swipeable = true;

	public CustomSwipeableViewPager(Context context) {
		super(context);
	}

	public CustomSwipeableViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		return (this.swipeable) ? super.onInterceptTouchEvent(arg0) : false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return (this.swipeable) ? super.onTouchEvent(event) : false;
	}

	public void setSwipeable(boolean swipeable) {
		this.swipeable = swipeable;
	}

}