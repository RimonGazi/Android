package net.sistransitomobile.autode;

import java.lang.reflect.Field;

import net.sistransitomobile.adapter.AutoDeStartSectionsPagerAdapter;
import net.sistransitomobile.adapter.AutoDeSubTitleSectionsPagerAdapter;
import net.sistransitomobile.fragment.UpdateFragment;
import net.sistransitomobile.main.R;
import net.sistransitomobile.viewpager.AnySwipeableViewPager;
import net.sistransitomobile.viewpager.DepthPageTransformer;
import net.sistransitomobile.viewpager.FixedSpeedScroller;
import net.sistransitomobile.viewpager.ZoomOutPageTransformer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.viewpagerindicator.UnderlinePageIndicator;

public class AutoDeActivity extends SherlockFragmentActivity implements
		OnClickListener {
	private AnySwipeableViewPager pager;
	private AnySwipeableViewPager sub_title_pager;
	private Field mScroller;
	private FixedSpeedScroller scroller;
	private UnderlinePageIndicator indicator;
	private ImageView im_btn_tab_conductor, im_btn_tab_infracieo,
			im_btn_tab_gerar, im_btn_back;
	private AutoDeStartSectionsPagerAdapter adapter;
	private AutoDeData autoDeData;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.auto_de_main);
		getAutodeObject();
		initializedView();
		setMainPager();
		setSubTitlePager();
		setTitleInidcator();

	}

	private void getAutodeObject() {
		Bundle bundleFrom = getIntent().getExtras();
		AutoDeObgect.setAutoDeObject((AutoDeData) bundleFrom
				.getSerializable(AutoDeData.getAutoDeId()));
		autoDeData = AutoDeObgect.getAutoDeOject();
	}

	private void setTitleInidcator() {
		indicator = (UnderlinePageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		indicator.setFades(false);

		indicator.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int positon) {
				setCurrentTabSelectedIteams(positon);
				if (positon == 2) {
					UpdateFragment fragment = (UpdateFragment) adapter
							.instantiateItem(pager, positon);
					fragment.Update();
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		setCurrentTabSelectedIteams(pager.getCurrentItem());

	}

	private void setSubTitlePager() {
		sub_title_pager = (AnySwipeableViewPager) findViewById(R.id.autode_title_pager);
		sub_title_pager.setSwipeable(false);
		sub_title_pager.setAdapter(new AutoDeSubTitleSectionsPagerAdapter(
				getSupportFragmentManager()));
		sub_title_pager.setPageMargin(20);
		sub_title_pager.setPageTransformer(true, new ZoomOutPageTransformer());

		try {

			mScroller.set(sub_title_pager, scroller);

		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}

	}

	private void setMainPager() {
		adapter = new AutoDeStartSectionsPagerAdapter(
				getSupportFragmentManager());
		pager = (AnySwipeableViewPager) findViewById(R.id.autode_start_pager);
		pager.setSwipeable(false);
		pager.setPageMargin(20);
		pager.setPageTransformer(true, new DepthPageTransformer());
		pager.setOffscreenPageLimit(adapter.getCount());
		pager.setAdapter(adapter);

		try {
			mScroller = ViewPager.class.getDeclaredField("mScroller");
			mScroller.setAccessible(true);
			scroller = new FixedSpeedScroller(this);
			scroller.setFixedDuration(2000);
			mScroller.set(pager, scroller);

		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_btn_tab_conductor:
			setPagerPosition(0);
			break;
		case R.id.im_btn_tab_infracieo:
			setPagerPosition(1);
			break;
		case R.id.im_btn_tab_gerar:
			setPagerPosition(2);
			break;

		case R.id.im_btn_back:
			Log.d("dddddddddddddddddddddd", autoDeData.getPlate());
			finish();
		}
	}

	private void setPagerPosition(int position) {
		setCurrentTabSelectedIteams(position);
		sub_title_pager.setCurrentItem(position);
		pager.setCurrentItem(position);
	}

	private void setCurrentTabSelectedIteams(int positon) {
		switch (positon) {
		case 0:
			im_btn_tab_conductor.setSelected(true);
			im_btn_tab_infracieo.setSelected(false);
			im_btn_tab_gerar.setSelected(false);

			break;

		case 1:
			im_btn_tab_conductor.setSelected(false);
			im_btn_tab_infracieo.setSelected(true);
			im_btn_tab_gerar.setSelected(false);

			break;
		case 2:
			im_btn_tab_conductor.setSelected(false);
			im_btn_tab_infracieo.setSelected(false);
			im_btn_tab_gerar.setSelected(true);
			break;
		}
	}

	private void initializedView() {
		im_btn_tab_infracieo = (ImageView) findViewById(R.id.im_btn_tab_infracieo);
		im_btn_tab_conductor = (ImageView) findViewById(R.id.im_btn_tab_conductor);
		im_btn_tab_gerar = (ImageView) findViewById(R.id.im_btn_tab_gerar);
		im_btn_tab_infracieo.setOnClickListener(this);
		im_btn_tab_conductor.setOnClickListener(this);
		im_btn_tab_gerar.setOnClickListener(this);
		im_btn_back = (ImageView) findViewById(R.id.im_btn_back);
		im_btn_back.setOnClickListener(this);
	}
}
