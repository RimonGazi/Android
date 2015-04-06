package com.rimon.mymap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.juadmissiontest.ConstandValue;
import com.rimon.rsa.juadmissiontest.CustomSwipeableViewPager;
import com.rimon.rsa.juadmissiontest.OnSwitchClickListener;
import com.rimon.rsa.juadmissiontest.SectionsPagerAdapter;
import com.rimon.rsa.juadmissiontest.save.FileSaveFragment;

public class StartActivity extends SherlockFragmentActivity implements
		OnSwitchClickListener, FileSaveFragment.Callbacks {
	CustomSwipeableViewPager customSwipeableViewPager;
	SectionsPagerAdapter sectionsPagerAdapter;
	public static FragmentManager fragmentManager;

	private int currentPage = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		fragmentManager = getSupportFragmentManager();
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
		// getSupportActionBar().setLogo(R.drawable.icon);

		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionber_icon));

		getSupportActionBar().setDisplayShowCustomEnabled(true);
		setContentView(R.layout.main);
		customSwipeableViewPager = (CustomSwipeableViewPager) findViewById(R.id.pager);
		sectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());
		customSwipeableViewPager.setSwipeable(false);
		customSwipeableViewPager.setAdapter(sectionsPagerAdapter);
		customSwipeableViewPager
				.setOnPageChangeListener(new OnPageChangeListener() {

					@Override
					public void onPageSelected(int arg0) {
						currentPage = arg0;
						if (currentPage == ConstandValue.SEARCH_PAGE) {
							getSupportActionBar().setDisplayHomeAsUpEnabled(
									false);
						} else {
							getSupportActionBar().setDisplayHomeAsUpEnabled(
									true);
						}

					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onPageScrollStateChanged(int arg0) {
						// TODO Auto-generated method stub

					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {

		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (currentPage != ConstandValue.SEARCH_PAGE)
				customSwipeableViewPager.setCurrentItem(
						ConstandValue.SEARCH_PAGE, true);
			break;

		case R.id.help:
			if (currentPage != ConstandValue.HELP_PAGE)
				customSwipeableViewPager.setCurrentItem(
						ConstandValue.HELP_PAGE, true);
			break;
		case R.id.about:
			if (currentPage != ConstandValue.ABOUT_PAGE)
				customSwipeableViewPager.setCurrentItem(
						ConstandValue.ABOUT_PAGE, true);
			break;

		case R.id.privious_search:
			if (currentPage != ConstandValue.RESULT_PAGE)
				customSwipeableViewPager.setCurrentItem(
						ConstandValue.RESULT_PAGE, true);
			break;

		}
		return false;
	}

	@Override
	public void onSwitchClick() {

		customSwipeableViewPager.setCurrentItem(ConstandValue.RESULT_PAGE,
				false);

	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {
		boolean canSave = true;

		// Catch the really stupid case.
		if (absolutePath == null || absolutePath.length() == 0
				|| fileName == null || fileName.length() == 0) {
			canSave = false;
			// showToast(R.string.alert_supply_filename, Toast.LENGTH_SHORT);
		}

		// Do we have a filename if the extension is thrown away?
		if (canSave) {
			String copyName = FileSaveFragment.NameNoExtension(fileName);
			if (copyName == null || copyName.length() == 0) {
				canSave = false;
				// showToast(R.string.alert_supply_filename,
				// Toast.LENGTH_SHORT);
			}
		}

		// Allow only alpha-numeric names. Simplify dealing with reserved path
		// characters.
		if (canSave) {
			if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
				canSave = false;
				// showToast(R.string.alert_bad_filename_chars,
				// Toast.LENGTH_SHORT);
			}
		}

		// No overwrite of an existing file.
		if (canSave) {
			if (FileSaveFragment.FileExists(absolutePath, fileName)) {
				canSave = false;
				// showToast(R.string.alert_file_exists, Toast.LENGTH_SHORT);
			}
		}

		return canSave;
	}

	@Override
	public void onConfirmSave(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {
			// Recommend that file save for large amounts of data is handled
			// by an AsyncTask.
			mySaveMethod(absolutePath, fileName);
		}
	}

	private void mySaveMethod(String absolutePath, String fileName) {
		Log.d("file name", fileName);
		String data = "\nJahangirnagar University\n"
				+ "\t Admission Test"
				+ "\n\n Seat Plan "
				+ "\n ..........."
				+ "\n\n Roll :"
				+ ConstandValue.roll
				+ "\n\n Unit :"
				+ ConstandValue.unit
				+ "\n\n Shift:"
				+ ConstandValue.shift
				+ "\n\n Date :"
				+ ConstandValue.date
				+ "\n\n Time :"
				+ ConstandValue.time
				+ "\n\n Room :"
				+ ConstandValue.room
				+ "\n\n Building/dept :"
				+ ConstandValue.address
				+ "\n\n Powered By\n Dept. of CSE,\n Jahangirnagar University\n ..............";

		fileName += ".txt";
		Writer writer;
		// Toast.makeText(MainActivity.this, fileName,
		// Toast.LENGTH_SHORT).show();
		File outputFile = new File(absolutePath, fileName);
		try {
			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(data);
			writer.close();
			Toast.makeText(StartActivity.this, "Saved", Toast.LENGTH_SHORT)
					.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (currentPage != ConstandValue.SEARCH_PAGE) {
				customSwipeableViewPager.setCurrentItem(
						ConstandValue.SEARCH_PAGE, true);
			} else if (currentPage == ConstandValue.SEARCH_PAGE) {
				finish();

			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
