package net.sistransitomobile.adapter;

import net.sistransitomobile.cnh.CnfFragment;
import net.sistransitomobile.placa.counsult.ConsultFragment;
import net.sistransitomobile.placa.lister.LogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class StartSectionsPagerAdapter extends FragmentPagerAdapter {

	public StartSectionsPagerAdapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			return new ConsultFragment();
		case 1:
			return new CnfFragment();
		case 2:
			return new LogFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}