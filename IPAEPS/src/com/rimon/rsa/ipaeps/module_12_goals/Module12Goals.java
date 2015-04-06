package com.rimon.rsa.ipaeps.module_12_goals;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.SavePatientData;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogPasswordForActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogPasswordListener;
import com.rimon.rsa.ipaeps.main.FixedSpeedScroller;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;
import com.rimon.rsa.ipaeps.viewpager.AnySwipeableViewPager;
import com.viewpagerindicator.CirclePageIndicator;

public class Module12Goals extends SherlockFragmentActivity implements
		AnyPageChangeListener, AnyDialogPasswordListener {

	private AnySwipeableViewPager pager;
	private GoalsSectionsPagerAdapter adapter;
	private AnyTextView tv_action_bar;
	private CirclePageIndicator indicator;
	private ImageView im_action_bar;
	private boolean isSingleDiaglog = true;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.module_12_goals);
		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(this.getResources().getString(
				R.string.responses_to_past_goals));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar.setBackgroundResource(R.drawable.ic_module_12_goal);
		pager = (AnySwipeableViewPager) findViewById(R.id.medication_pager);
		adapter = new GoalsSectionsPagerAdapter(getSupportFragmentManager());
		try {
			Field mScroller = ViewPager.class.getDeclaredField("mScroller");
			mScroller.setAccessible(true);
			FixedSpeedScroller scroller = new FixedSpeedScroller(this);
			mScroller.set(pager, scroller);
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
		pager.setOffscreenPageLimit(adapter.getCount());

		pager.setAdapter(adapter);
		indicator = (CirclePageIndicator) findViewById(R.id.titles);
		indicator.setViewPager(pager);
		pager.setSwipeable(false);
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			// indicator.set
			@Override
			public void onPageSelected(int arg0) {
				indicator.onPageSelected(arg0);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void pageChange(int id) {
		pager.setCurrentItem(id);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			if (isSingleDiaglog) {
				isSingleDiaglog = false;
				AnyDiaglogPasswordForActivity anyDiaglogPassword = new AnyDiaglogPasswordForActivity();
				anyDiaglogPassword.setCancelable(false);
				anyDiaglogPassword.show(getSupportFragmentManager(), "");

			}

		}
		return false;
	}

	@Override
	public void onClickPasswordDialog(boolean isPasswordCorrect) {
		isSingleDiaglog = true;
		if (isPasswordCorrect) {
			(new SavePatientData(this)).execute("");
			finish();
		}
	}

}
