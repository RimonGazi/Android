package com.rimon.rsa.ipaeps.module_12_goals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class GoalsSectionsPagerAdapter extends FragmentStatePagerAdapter {

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public GoalsSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new Module12GoalsFragment1();
		case 1:
			return new Module12GoalsFragment2();
		case 2:
			return new Module12GoalsFragment3();

		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
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