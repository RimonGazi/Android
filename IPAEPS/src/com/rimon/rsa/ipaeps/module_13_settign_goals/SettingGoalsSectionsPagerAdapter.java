package com.rimon.rsa.ipaeps.module_13_settign_goals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class SettingGoalsSectionsPagerAdapter extends FragmentStatePagerAdapter {

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public SettingGoalsSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new Module13SettingGoalsFragment1();
		case 1:
			return new Module13SettingGoalsFragment2();
		case 2:
			return new Module13SettingGoalsFragment3();

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