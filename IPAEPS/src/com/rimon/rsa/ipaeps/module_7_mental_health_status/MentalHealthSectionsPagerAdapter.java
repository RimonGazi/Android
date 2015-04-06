package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class MentalHealthSectionsPagerAdapter extends FragmentStatePagerAdapter {

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public MentalHealthSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new Module7mhs_fragment_1();
		case 1:
			return new Module7mhs_fragment_2();
		case 2:
			return new Module7mhs_fragment_3();
		case 3:
			return new Module7mhs_fragment_4();
		case 4:
			return new Module7mhs_fragment_5();
		case 5:
			return new Module7mhs_fragment_6();
		case 6:
			return new Module7mhs_fragment_7();
		case 7:
			return new Module7mhs_fragment_8();
		case 8:
			return new Module7mhs_fragment_9();

		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 9;
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