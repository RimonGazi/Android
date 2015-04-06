package net.sistransitomobile.login;

import java.lang.reflect.Field;

import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.fragment.AnyPageChangeListener;
import net.sistransitomobile.main.R;
import net.sistransitomobile.viewpager.AnySwipeableViewPager;
import net.sistransitomobile.viewpager.FixedSpeedScroller;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;


public class LoginActivity extends SherlockFragmentActivity implements
		AnyPageChangeListener {
	private AnySwipeableViewPager pager;
	private LoginSectionsPagerAdapter adapter;
	private Field mScroller;
	private FixedSpeedScroller scroller;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.login_main);
		setPager();

	}

	private void setPager() {
		pager = (AnySwipeableViewPager) findViewById(R.id.login_pager);
		pager.setSwipeable(false);
		adapter = new LoginSectionsPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setCurrentItem(getIntent().getIntExtra(
				AppConstants.LOING_FRAGMENT_ID, 0));
		try {
			mScroller = ViewPager.class.getDeclaredField("mScroller");

			mScroller.setAccessible(true);
			scroller = new FixedSpeedScroller(this);
			mScroller.set(pager, scroller);
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
	}

	@Override
	public void onPageChange(int id) {
		pager.setCurrentItem(id);

	}

}
