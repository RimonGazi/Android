package com.rimon.rsa.ipaeps.module_3_ibd;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class IbdSectionsPagerAdapter extends FragmentStatePagerAdapter {

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public IbdSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new Module3IbdFragment1();
		case 1:
			return new Module3IbdFragment2();

		case 2:
			return new Module3IbdFragment3();
		case 3:
			return new Module3IbdFragment4();
		case 4:
			return new Module3IbdFragment5();
		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 5;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		/*
		 * switch (position) { case 0: return "Register"; case 1: return
		 * "Search"; case 2: return "Result"; }
		 */
		return null;
	}
	// @Override
	// public float getPageWidth(int position) {
	// // TODO Auto-generated method stub
	// return 0.93f;
	// }

}