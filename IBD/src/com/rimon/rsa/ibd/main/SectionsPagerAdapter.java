package com.rimon.rsa.ibd.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.rimon.rsa.ibd.feedbackquestionfragments.FeedBackFirstHelp;
import com.rimon.rsa.ibd.feedbackquestionfragments.FeedBackQuestion_1;
import com.rimon.rsa.ibd.feedbackquestionfragments.FeedBackQuestion_2;
import com.rimon.rsa.ibd.feedbackquestionfragments.FeedBackQuestion_3;
import com.rimon.rsa.ibd.feedbackquestionfragments.FeedBackQuestion_4;
import com.rimon.rsa.ibd.feedbackquestionfragments.FeedBackSecondFragment;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientHelpFragmentFirst;
import com.rimon.rsa.ibd.questionpatient.fragments.LastPage;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientHelpFragmentSecond;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientQuestion_1;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientQuestion_2;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientQuestion_3;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientQuestion_4;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientQuestion_5;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientQuestion_6;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientResultScreen;
import com.rimon.rsa.ibd.questionpatient.fragments.PatientScore;
import com.rimon.rsa.ibd.splash.fragments.QuestionStart;
import com.rimon.rsa.ibd.splash.fragments.SplashScreenFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	@Override
	public void finishUpdate(ViewGroup container) {
		super.finishUpdate(container);
	}

	@Override
	public void startUpdate(ViewGroup container) {
		super.startUpdate(container);
	}

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {

		case 0:
			return new SplashScreenFragment();
		case 1:
			return new QuestionStart();
		case 2:
			return new PatientQuestion_1();
		case 3:
			return new PatientQuestion_2();
		case 4:
			return new PatientQuestion_3();
		case 5:
			return new PatientQuestion_4();
		case 6:
			return new PatientQuestion_5();
		case 7:
			return new PatientQuestion_6();
		case 8:
			return new PatientHelpFragmentFirst();
		case 9:
			return new PatientResultScreen();
		case 10:
			return new PatientHelpFragmentSecond();
		case 11:
			return new FeedBackQuestion_1();
		case 12:
			return new FeedBackFirstHelp();
		case 13:
			return new FeedBackQuestion_2();
		case 14:
			return new FeedBackQuestion_3();
		case 15:
			return new FeedBackQuestion_4();
		case 16:
			return new FeedBackSecondFragment();
		case 17:
			return new PatientScore();
		case 18:
			return new LastPage();
		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 19;
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