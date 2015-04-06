package com.rimon.rsa.ipaeps.main;

import java.lang.reflect.Field;

import net.sqlcipher.database.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;
import com.rimon.rsa.ipaeps.viewpager.AnySwipeableViewPager;

public class Main extends SherlockFragmentActivity {

	private AnySwipeableViewPager pager;
	private MainSectionsPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		pager = (AnySwipeableViewPager) findViewById(R.id.main_pager);
		pager.setSwipeable(false);
		adapter = new MainSectionsPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		try {
			Field mScroller = ViewPager.class.getDeclaredField("mScroller");

			mScroller.setAccessible(true);
			FixedSpeedScroller scroller = new FixedSpeedScroller(this);

			mScroller.set(pager, scroller);
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				pager.setCurrentItem(1, true);
				try {
					UpdateFragment updateFragment = (UpdateFragment) adapter
							.instantiateItem(pager, 1);
					if (updateFragment != null)
						updateFragment.Update();

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}, 2000);
		new Load().execute("");
	}
	class Load extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... arg0) {
			SQLiteDatabase.loadLibs(getApplicationContext());
			DatabaseCreator.openAllDatabase(getApplicationContext());
			return null;
		}
	}
}