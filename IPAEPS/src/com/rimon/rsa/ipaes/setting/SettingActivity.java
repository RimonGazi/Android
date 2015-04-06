package com.rimon.rsa.ipaes.setting;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.actionbar.CustomActionBar;
import com.rimon.rsa.ipaeps.main.FixedSpeedScroller;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;
import com.rimon.rsa.ipaeps.viewpager.AnySwipeableViewPager;

public class SettingActivity extends SherlockFragmentActivity implements
		ActionBar.TabListener {
	private AnySwipeableViewPager pager;
	private SettingSectionsPagerAdapter adapter;
	private boolean updateFragmentCheck;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.setting_main);

		pager = (AnySwipeableViewPager) findViewById(R.id.setting_pager);

		pager.setSwipeable(false);

		adapter = new SettingSectionsPagerAdapter(getSupportFragmentManager(),
				SettingActivity.this);
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

		pager.setOnPageChangeListener(new OnPageChangeListener() {

			// indicator.set
			@Override
			public void onPageSelected(int arg0) {
				// indicator.onPageSelected(arg0);

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
		actionberSetUp();

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		if (updateFragmentCheck) {

			if (tab.getPosition() == 0 || tab.getPosition() == 1) {
				UpdateFragment updateFragment = null;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, tab.getPosition());
				updateFragment.Update();
				updateFragmentCheck = false;
			}
		}
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		updateFragmentCheck = true;

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	private void actionberSetUp() {

		CustomActionBar customActionBar = new CustomActionBar(
				SettingActivity.this);
		customActionBar.setupActionBarWithBack(getSupportActionBar(),
				R.drawable.ic_setting_p, R.string.setting);

		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for (int i = 0; i < adapter.getCount(); i++) {
			getSupportActionBar().addTab(
					getSupportActionBar().newTab()
							.setText(adapter.getPageTitle(i))
							.setTabListener(this));
		}
	}
}
