package net.sistransitomobile.adapter;

import net.sistransitomobile.autode.SubTitlAutoDeConductorFragment;
import net.sistransitomobile.autode.SubTitlAutoDeGegrarFragment;
import net.sistransitomobile.autode.SubTitlAutoDeInfracieoFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class AutoDeSubTitleSectionsPagerAdapter extends FragmentPagerAdapter {

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public AutoDeSubTitleSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new SubTitlAutoDeConductorFragment();
		case 1:
			return new SubTitlAutoDeInfracieoFragment();
		case 2:
			return new SubTitlAutoDeGegrarFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}
}