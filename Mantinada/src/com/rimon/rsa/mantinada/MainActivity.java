package com.rimon.rsa.mantinada;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.rimon.rsa.manrinaFragment.OnSwitchClickListener;
import com.rimon.rsa.manrinaFragment.ResultFargment;
import com.rimon.rsa.manrinaFragment.SectionsPagerAdapter;
import com.rimon.rsa.mantinada.save.FileSaveFragment;


public class MainActivity extends FragmentActivity implements
		OnSwitchClickListener, FileSaveFragment.Callbacks {

	private SectionsPagerAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
//				if (arg0 == 2 && !menuItemSave.isVisible()) {
//					menuItemSave.setVisible(true);
//
//				} else if (arg0 != 2 && menuItemSave.isVisible()) {
//					menuItemSave.setVisible(false);
//				}
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
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.main, menu);
		
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

//		if (item.getTitle().equals(MENU_ITEM_SAVE_TITLE)) {
//			String doc = getResources().getString(
//					R.string.file_save_extention_doc);
//			String frag = getResources().getString(
//					R.string.file_save_tag_fragment);
//			FileSaveFragment fsf = FileSaveFragment.newInstance(doc,
//					R.string.file_save_alert_ok,
//					R.string.file_save_alert_cancel, R.string.file_save_title,
//					R.string.file_save_hint, android.R.drawable.ic_menu_save);
//
//			fsf.show(getFragmentManager(), frag);
//
//		}
		return super.onOptionsItemSelected(item);

	}

	@Override
	public void onSwitchClick() {
		mViewPager.setCurrentItem(2);
	}

	@Override
	public boolean onCanSave(String absolutePath, String fileName) {
		boolean canSave = true;

		// Catch the really stupid case.
		if (absolutePath == null || absolutePath.length() == 0
				|| fileName == null || fileName.length() == 0) {
			canSave = false;
			showToast(R.string.file_save_invalid_path, Toast.LENGTH_SHORT);
		}

		// Do we have a filename if the extension is thrown away?
		if (canSave) {
			String copyName = FileSaveFragment.NameNoExtension(fileName);
			if (copyName == null || copyName.length() == 0) {
				canSave = false;
				showToast(R.string.file_save_duplicate_file, Toast.LENGTH_SHORT);
			}
		}

		// Allow only alpha-numeric names. Simplify dealing with reserved path
		// characters.
		if (canSave) {
			if (!FileSaveFragment.IsAlphaNumeric(fileName)) {
				canSave = false;
				showToast(R.string.file_save_invalid_name, Toast.LENGTH_SHORT);
			}
		}

		// No overwrite of an existing file.
		if (canSave) {
			if (FileSaveFragment.FileExists(absolutePath, fileName)) {
				canSave = false;
				showToast(R.string.file_save_exit_name, Toast.LENGTH_SHORT);
			}
		}

		return canSave;
	}

	@Override
	public void onConfirmSave(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {
			// Recommend that file save for large amounts of data is handled
			// by an AsyncTask.
			// mySaveMethod(absolutePath, fileName);

			Toast.makeText(MainActivity.this, absolutePath + " " + fileName,
					Toast.LENGTH_SHORT).show();
		}

	}

	private void showToast(int id, int time) {
		String text = getResources().getString(id);
		Toast.makeText(MainActivity.this, text, time).show();

	}

}