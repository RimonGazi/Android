package net.sistransitomobile.main;

import java.lang.reflect.Field;

import net.sistransitomobile.adapter.MainSubTitleSectionsPagerAdapter;
import net.sistransitomobile.adapter.StartSectionsPagerAdapter;
import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.fragment.AnyPageChangeListener;
import net.sistransitomobile.help.Help;
import net.sistransitomobile.setting.SettingActivity;
import net.sistransitomobile.viewpager.AnySwipeableViewPager;
import net.sistransitomobile.viewpager.DepthPageTransformer;
import net.sistransitomobile.viewpager.FixedSpeedScroller;
import net.sistransitomobile.viewpager.ZoomOutPageTransformer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.viewpagerindicator.UnderlinePageIndicator;

public class StartPageFragment extends SherlockFragment implements
		OnClickListener {
	private Button btn_overflow;
	private View view;
	private AnySwipeableViewPager pager;
	private AnySwipeableViewPager sub_title_pager;
	private UnderlinePageIndicator indicator;
	private Field mScroller;
	private FixedSpeedScroller scroller;
	private ImageView im_btn_tab_consult, im_btn_tab_cnf, im_btn_tab_log;
	private PopupMenu menu;
	private AnyPageChangeListener listener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (MainActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.start_page_fragment, null, false);
		initializedView();
		setMainPager();
		setSubTitlePager();
		setTitleInidcator();
		return view;
	}

	private void setSubTitlePager() {
		sub_title_pager = (AnySwipeableViewPager) view
				.findViewById(R.id.title_pager);
		sub_title_pager.setSwipeable(false);
		sub_title_pager.setAdapter(new MainSubTitleSectionsPagerAdapter(
				getChildFragmentManager()));
		sub_title_pager.setPageMargin(20);
		sub_title_pager.setPageTransformer(true, new ZoomOutPageTransformer());

		try {

			mScroller.set(sub_title_pager, scroller);

		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}

	}

	private void setMainPager() {
		pager = (AnySwipeableViewPager) view.findViewById(R.id.start_pager);
		pager.setSwipeable(false);
		pager.setAdapter(new StartSectionsPagerAdapter(
				getChildFragmentManager()));
		pager.setPageMargin(20);
		pager.setPageTransformer(true, new DepthPageTransformer());

		try {
			mScroller = ViewPager.class.getDeclaredField("mScroller");
			mScroller.setAccessible(true);
			scroller = new FixedSpeedScroller(getActivity());
			scroller.setFixedDuration(2000);
			mScroller.set(pager, scroller);

		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}

	}

	private void setTitleInidcator() {
		indicator = (UnderlinePageIndicator) view.findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		indicator.setFades(false);
		indicator.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int positon) {
				setCurrentTabSelectedIteams(positon);
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
		setCurrentTabSelectedIteams(pager.getCurrentItem());
	}

	private void initializedView() {
		im_btn_tab_cnf = (ImageView) view.findViewById(R.id.im_btn_tab_cnf);
		im_btn_tab_consult = (ImageView) view
				.findViewById(R.id.im_btn_tab_consult);
		im_btn_tab_log = (ImageView) view.findViewById(R.id.im_btn_tab_log);
		im_btn_tab_cnf.setOnClickListener(this);
		im_btn_tab_consult.setOnClickListener(this);
		im_btn_tab_log.setOnClickListener(this);
		btn_overflow = (Button) view.findViewById(R.id.btn_overflow);
		btn_overflow.setOnClickListener(this);
		createMenu();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_btn_tab_consult:
			setPagerPosition(0);
			break;
		case R.id.im_btn_tab_cnf:
			setPagerPosition(1);
			break;
		case R.id.im_btn_tab_log:
			setPagerPosition(2);
			break;
		case R.id.btn_overflow:
			menu.show();

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
			im_btn_tab_consult.setSelected(true);
			im_btn_tab_cnf.setSelected(false);
			im_btn_tab_log.setSelected(false);

			break;

		case 1:
			im_btn_tab_consult.setSelected(false);
			im_btn_tab_cnf.setSelected(true);
			im_btn_tab_log.setSelected(false);

			break;
		case 2:
			im_btn_tab_consult.setSelected(false);
			im_btn_tab_cnf.setSelected(false);
			im_btn_tab_log.setSelected(true);
			break;

		}

	}

	public void createMenu() {
		menu = new PopupMenu(getActivity(), btn_overflow);
		menu.getMenuInflater().inflate(R.menu.main, menu.getMenu());
		menu.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {
				case R.id.action_settings:
					startActivity(new Intent(getActivity(),
							SettingActivity.class));
					return true;

				case R.id.action_help:
					startActivity(new Intent(getActivity(), Help.class));
					return true;

				case R.id.action_logout:
					listener.onPageChange(AppConstants.LOING_FRAGMENT_0);
					return true;

				default:

					return false;
				}

			}

		});

	}

}
