package com.rimon.rsa.ipaeps.module_7_mental_health_status;

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

public class Module7MentalHealth extends SherlockFragmentActivity implements
		AnyPageChangeListener, AnyDialogPasswordListener {
	private AnySwipeableViewPager pager;
	private MentalHealthSectionsPagerAdapter adapter;
	private AnyTextView tv_action_bar;
	private CirclePageIndicator indicator;
	private ImageView im_action_bar;
	private boolean isSingleDiaglog = true;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.module_7_mhs_main);
		tv_action_bar = (AnyTextView) findViewById(R.id.tv_action_bar);
		tv_action_bar.setText(this.getResources().getString(
				R.string.q_7_1_title));
		im_action_bar = (ImageView) findViewById(R.id.im_action_bar);
		im_action_bar.setBackgroundResource(R.drawable.ic_actionbar_mhs);
		pager = (AnySwipeableViewPager) findViewById(R.id.mhs_pager);

		adapter = new MentalHealthSectionsPagerAdapter(
				getSupportFragmentManager());
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
		pager.setSwipeable(false);

		pager.setAdapter(adapter);
		indicator = (CirclePageIndicator) findViewById(R.id.titles);
		indicator.setViewPager(pager);

		// indicator.setRadius(getResources().getDimension(
		// R.dimen.indicator_radius));

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

		switch (id) {
		case AppConstants.MODULE_7_PAGE_1:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_1_title));

			break;
		case AppConstants.MODULE_7_PAGE_2:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_2_title));

			break;
		case AppConstants.MODULE_7_PAGE_3:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_3_title));

			break;
		case AppConstants.MODULE_7_PAGE_4:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_4_title));

			break;
		case AppConstants.MODULE_7_PAGE_5:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_5_title));

			break;
		case AppConstants.MODULE_7_PAGE_6:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_6_title));

			break;
		case AppConstants.MODULE_7_PAGE_7:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_7_title));

			break;
		case AppConstants.MODULE_7_PAGE_8:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_8_title));
			break;

		case AppConstants.MODULE_7_PAGE_9:
			tv_action_bar.setText(this.getResources().getString(
					R.string.q_7_9_title));

			UpdateFragment updateFragment = null;
			updateFragment = (UpdateFragment) adapter
					.instantiateItem(pager, id);
			updateFragment.Update();

			break;

		}

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
