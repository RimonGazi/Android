package com.rimon.rsa.ipaes.setting;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.coustomt_typeface.CustomTypefaceSpan;

public class SettingSectionsPagerAdapter extends FragmentStatePagerAdapter {
	SpannableStringBuilder spannableString;
	private Context context;
	private CustomTypefaceSpan customTypefaceSpan;

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public SettingSectionsPagerAdapter(FragmentManager fm, Context cnt) {
		super(fm);
		context = cnt;
		customTypefaceSpan = new CustomTypefaceSpan(context);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new SettingFragment_1();
		case 1:
			return new SettingFragment_2();

		case 2:
			return new SettingFragment_4();

			// case 3:
			// return new SettingFragment_3();

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

		switch (position) {
		case 0:
			return setTextColor("Preset");
		case 1:
			return setTextColor("Custom");
		
		case 2:
			return setTextColor("App");
			
			// case 3:
			// return setTextColor("Print");
		}

		return null;
	}

	private SpannableStringBuilder setTextColor(String text) {

		spannableString = new SpannableStringBuilder(text);
		spannableString.setSpan(customTypefaceSpan, 0, text.length(), 0);
		spannableString.setSpan(new ForegroundColorSpan(context.getResources()
				.getColor(R.color.teal)), 0, text.length(), 0);
		return spannableString;
	}
}