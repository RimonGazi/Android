package net.sistransitomobile.main;

import java.lang.reflect.Field;

import net.sistransitomobile.adapter.MainSectionsPagerAdapter;
import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.fragment.AnyPageChangeListener;
import net.sistransitomobile.fragment.UpdateFragment;
import net.sistransitomobile.viewpager.AnySwipeableViewPager;
import net.sistransitomobile.viewpager.FixedSpeedScroller;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity implements AnyPageChangeListener{
	private AnySwipeableViewPager pager;
	private MainSectionsPagerAdapter adapter;
	private Field mScroller;
	private FixedSpeedScroller scroller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setPager();
	}

	private void setPager() {
		pager = (AnySwipeableViewPager) findViewById(R.id.main_pager);
		pager.setSwipeable(false);
		adapter = new MainSectionsPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
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
		
		if (id == AppConstants.LOING_FRAGMENT_0) {
			UpdateFragment updateFragment = null;
			updateFragment = (UpdateFragment) adapter
					.instantiateItem(pager, id);
			updateFragment.Update();
		}
		pager.setCurrentItem(id);
		
	}

}
