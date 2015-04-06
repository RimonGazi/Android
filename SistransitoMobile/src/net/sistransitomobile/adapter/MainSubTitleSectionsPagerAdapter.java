package net.sistransitomobile.adapter;

import net.sistransitomobile.cnh.SubTitleCnfFragment;
import net.sistransitomobile.placa.counsult.SubTitleConsultFragment;
import net.sistransitomobile.placa.lister.SubTitleLogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MainSubTitleSectionsPagerAdapter extends FragmentPagerAdapter {

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public MainSubTitleSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new SubTitleConsultFragment();
		case 1:
			return new SubTitleCnfFragment();
		case 2:
			return new SubTitleLogFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}
}