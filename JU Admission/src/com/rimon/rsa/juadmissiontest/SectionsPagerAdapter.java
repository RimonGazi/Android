package com.rimon.rsa.juadmissiontest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new SearchFragment();
		case 1:
			return new ResultFragment();
		case 2:
			return new HelpFragment();
		case 3:
			return new AboutFragment();

		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 4;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		/*
		 * switch (position) { case 0: return "Register"; case 1: return
		 * "Search"; case 2: return "Result"; }
		 */
		return null;
	}

}