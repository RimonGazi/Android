package net.sistransitomobile.adapter;

import net.sistransitomobile.autode.AutoDeConductorFragment;
import net.sistransitomobile.autode.AutoDeGegrarFragment;
import net.sistransitomobile.autode.AutoDeInfracieoFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AutoDeStartSectionsPagerAdapter extends FragmentPagerAdapter {

	public AutoDeStartSectionsPagerAdapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			return new AutoDeConductorFragment();
		case 1:
			return new AutoDeInfracieoFragment();
		case 2:
			return new AutoDeGegrarFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}