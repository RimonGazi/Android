package com.rimon.rsa.ipaeps.module_9_diet;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appdatabase.SavePatientData;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDiaglogPasswordForActivity;
import com.rimon.rsa.ipaeps.dialogfragment.AnyDialogPasswordListener;
import com.rimon.rsa.ipaeps.main.FixedSpeedScroller;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;
import com.rimon.rsa.ipaeps.viewpager.AnySwipeableViewPager;
import com.viewpagerindicator.CirclePageIndicator;

import java.lang.reflect.Field;

public class Module9Diet extends SherlockFragmentActivity implements
		AnyDialogPasswordListener, AnyPageChangeListener {
	private AnySwipeableViewPager pager;
	private DietSectionsPagerAdapter adapter;
	private AnyTextView tv_action_bar;
	private CirclePageIndicator indicator;
	private ImageView im_action_bar;
	private boolean isSingleDiaglog = true;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.module_9_diet_main);
		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(this.getResources().getString(R.string.you_diet));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar.setBackgroundResource(R.drawable.ic_diet);
		pager = (AnySwipeableViewPager) findViewById(R.id.diet_pager);
		pager.setSwipeable(false);
		adapter = new DietSectionsPagerAdapter(getSupportFragmentManager());
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
		if (id == AppConstants.MODULE_9_PAGE_2) {
			UpdateFragment updateFragment = null;
			updateFragment = (UpdateFragment) adapter
					.instantiateItem(pager, id);
			updateFragment.Update();
		}
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
