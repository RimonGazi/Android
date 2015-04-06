package com.rimon.rsa.ibd.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ibd.database.PasswordDBAdapter;
import com.rimon.rsa.ibd.questionpatient.fragments.UpdateFragment;
import com.rimon.rsa.mental.R;

public class StartActivityIBD extends SherlockFragmentActivity implements
		OnSwitchClickListener {

	private CustomSwipeableViewPager pager;
	private SectionsPagerAdapter adapter;
	private int currentPage = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.start_activity);
		actionberSetUp();
		pager = (CustomSwipeableViewPager) findViewById(R.id.pager);
		pager.setSwipeable(false);
		adapter = new SectionsPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);

		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				currentPage = position;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onSwitchClick(int id) {
		UpdateFragment updateFragment = null;
		switch (id) {
		case ConstantValues.SPLASH_PAGE:
			pager.setCurrentItem(ConstantValues.SPLASH_PAGE);
			break;
		case ConstantValues.PATIENT_QUESTION_START_PAGE:
			// hideSystemUI();
			getSupportActionBar().hide();
			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_START_PAGE);

			break;
		case ConstantValues.PATIENT_QUESTION_FIRST_PAGE:
			// Toast.makeText(StartActivityIBD.this, "1 without conditon",
			// Toast.LENGTH_LONG).show();
			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_FIRST_PAGE);
			if (ConstantValues.us_pq_1) {
				// Toast.makeText(StartActivityIBD.this, "1 without conditon",
				// Toast.LENGTH_LONG).show();
				ConstantValues.us_pq_1 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_QUESTION_FIRST_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.PATIENT_QUESTION_SECOND_PAGE:

			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_SECOND_PAGE);
			if (ConstantValues.us_pq_2) {
				ConstantValues.us_pq_2 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_QUESTION_SECOND_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.PATIENT_QUESTION_THIRD_PAGE:

			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_THIRD_PAGE);
			if (ConstantValues.us_pq_3) {
				ConstantValues.us_pq_3 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_QUESTION_THIRD_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.PATIENT_QUESTION_FOURTH_PAGE:

			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_FOURTH_PAGE);
			if (ConstantValues.us_pq_4) {
				ConstantValues.us_pq_4 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_QUESTION_FOURTH_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.PATIENT_QUESTION_FIFTH_PAGE:

			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_FIFTH_PAGE);
			if (ConstantValues.us_pq_5) {
				ConstantValues.us_pq_5 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_QUESTION_FIFTH_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.PATIENT_QUESTION_SIXTH_PAGE:

			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_SIXTH_PAGE);
			if (ConstantValues.us_pq_6) {
				ConstantValues.us_pq_6 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_QUESTION_SIXTH_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;

		case ConstantValues.PATIENT_QUESTION_HELP_1:

			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_HELP_1);

			break;

		case ConstantValues.PATIENT_QUESTION_RESULT_PAGE:
			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_RESULT_PAGE);
			if (ConstantValues.us_patient_result) {
				ConstantValues.us_patient_result = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_QUESTION_RESULT_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}
			break;

		case ConstantValues.PATIENT_QUESTION_HELP_2:

			pager.setCurrentItem(ConstantValues.PATIENT_QUESTION_HELP_2);

			break;

		case ConstantValues.FEEDBACK_QUESTION_SECONS_HELP_PAGE:
			pager.setCurrentItem(ConstantValues.FEEDBACK_QUESTION_SECONS_HELP_PAGE);

			break;

		case ConstantValues.FEEDBACK_QUESTION_FOURTH_PAGE:

			pager.setCurrentItem(ConstantValues.FEEDBACK_QUESTION_FOURTH_PAGE);
			if (ConstantValues.us_fq_4) {

				ConstantValues.us_fq_4 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.FEEDBACK_QUESTION_FOURTH_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;

		case ConstantValues.FEEDBACK_QUESTION_FIRST_PAGE:

			pager.setCurrentItem(ConstantValues.FEEDBACK_QUESTION_FIRST_PAGE);
			if (ConstantValues.us_fq_1) {
				ConstantValues.us_fq_1 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.FEEDBACK_QUESTION_FIRST_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.FEEDBACK_QUESTION_SECOND_PAGE:

			pager.setCurrentItem(ConstantValues.FEEDBACK_QUESTION_SECOND_PAGE);
			if (ConstantValues.us_fq_2) {
				ConstantValues.us_fq_2 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.FEEDBACK_QUESTION_SECOND_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.FEEDBACK_QUESTION_THIRD_PAGE:

			pager.setCurrentItem(ConstantValues.FEEDBACK_QUESTION_THIRD_PAGE);
			if (ConstantValues.us_fq_3) {
				ConstantValues.us_fq_3 = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.FEEDBACK_QUESTION_THIRD_PAGE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;

		case ConstantValues.FEEDBACK_QUESTION_FIRST_HELP_PAGE:

			pager.setCurrentItem(ConstantValues.FEEDBACK_QUESTION_FIRST_HELP_PAGE);

			break;

		case ConstantValues.PATIENT_SCORE:
			pager.setCurrentItem(ConstantValues.PATIENT_SCORE);
			if (ConstantValues.us_patient_score) {
				ConstantValues.us_patient_score = false;
				updateFragment = (UpdateFragment) adapter.instantiateItem(
						pager, ConstantValues.PATIENT_SCORE);
				if (updateFragment != null)
					updateFragment.Update();
			}

			break;
		case ConstantValues.PATIENT_LAST_PAGE:
			pager.setCurrentItem(ConstantValues.PATIENT_LAST_PAGE);
			break;

		}
	}

	private void actionberSetUp() {
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View view = getLayoutInflater().inflate(
				R.layout.custom_action_bar_main_page, null);

		getSupportActionBar().setCustomView(
				view,
				new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
						ActionBar.LayoutParams.MATCH_PARENT));

		TextView tv_title = (TextView) view.findViewById(R.id.actionber_tv);

		tv_title.setText("Mental helath diagnosis");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_HOME) {
			return false;
		}
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0
				&& currentPage != ConstantValues.SPLASH_PAGE) {

			LinearLayout layout = new LinearLayout(StartActivityIBD.this);
			LinearLayout.LayoutParams lpLParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT);
			layout.setLayoutParams(lpLParams);

			final EditText input = new EditText(StartActivityIBD.this);
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			input.setLayoutParams(lp);
			layout.addView(input);

			AlertDialog.Builder builder = new AlertDialog.Builder(this,
					AlertDialog.THEME_HOLO_LIGHT);

			builder.setTitle("Password");
			builder.setMessage("Enter password");
			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							String password = input.getText().toString();
							PasswordDBAdapter passwordDBAdapter = new PasswordDBAdapter(
									StartActivityIBD.this);
							passwordDBAdapter.openReadableDatabase();
							String myPassword = passwordDBAdapter.getPassword();
							passwordDBAdapter.close();
							if (myPassword.equals(password)) {
								getSupportActionBar().show();
								pager.setCurrentItem(ConstantValues.SPLASH_PAGE);
								newInitializedVariable();

							} else {
								AlertDialog.Builder builder1 = new AlertDialog.Builder(
										StartActivityIBD.this,
										AlertDialog.THEME_HOLO_LIGHT);
								builder1.setTitle("Info");
								builder1.setMessage("Invalid password");
								builder1.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												dialog.dismiss();
											}
										});
								builder1.setIcon(android.R.drawable.ic_dialog_alert);
								AlertDialog alertDialog1 = builder1.create();
								alertDialog1.show();
							}
						}
					});
			builder.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});

			builder.setIcon(R.drawable.pass_icon);
			AlertDialog alertDialog = builder.create();
			alertDialog.setView(layout);
			alertDialog.show();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	// private void hideSystemUI() {
	// // Set the IMMERSIVE flag.
	// // Set the content to appear under the system bars so that the content
	// // doesn't resize when the system bars hide and show.
	// getWindow().getDecorView().setSystemUiVisibility(
	// View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	// | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	// | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	// | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
	// | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
	// | View.SYSTEM_UI_FLAG_IMMERSIVE);
	// }
	//
	// // This snippet shows the system bars. It does this by removing all the
	// // flags
	// // except for the ones that make the content appear under the system
	// bars.
	// private void showSystemUI() {
	// getWindow().getDecorView().setSystemUiVisibility(
	// View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	// | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	// | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
	// }
	private void newInitializedVariable() {
		ConstantValues.us_pq_1 = true;
		ConstantValues.us_pq_2 = true;
		ConstantValues.us_pq_3 = true;
		ConstantValues.us_pq_4 = true;
		ConstantValues.us_pq_5 = true;
		ConstantValues.us_pq_6 = true;

		ConstantValues.us_fq_1 = true;
		ConstantValues.us_fq_2 = true;
		ConstantValues.us_fq_3 = true;
		ConstantValues.us_fq_4 = true;

		ConstantValues.us_patient_result = true;
		ConstantValues.us_patient_score = true;

		// first page question
		ConstantValues.question_1_value = "";
		ConstantValues.question_2_value = "";
		ConstantValues.question_3_value = "";
		ConstantValues.question_4_value = "";
		ConstantValues.question_5_value = "";

		// second page question
		ConstantValues.question_6_value = "";
		ConstantValues.question_7_value = "";
		ConstantValues.question_8_value = "";
		ConstantValues.question_9_value = "";
		ConstantValues.question_10_value = "";
		ConstantValues.question_11_value = "";

		// third page 12-18
		ConstantValues.question_12_value = "";
		ConstantValues.question_13_value = "";
		ConstantValues.question_14_value = "";
		ConstantValues.question_15_value = "";
		ConstantValues.question_16_value = "";
		ConstantValues.question_17_value = "";
		ConstantValues.question_18_value = "";
		// fourth page 19 -25
		ConstantValues.question_19_value = "";
		ConstantValues.question_20_value = "";
		ConstantValues.question_21_value = "";
		ConstantValues.question_22_value = "";
		ConstantValues.question_23_value = "";
		ConstantValues.question_24_value = "";
		ConstantValues.question_25_value = "";

		// fifth page 26-32
		ConstantValues.question_26_value = "";
		ConstantValues.question_27_value = "";
		ConstantValues.question_28_value = "";
		ConstantValues.question_29_value = "";
		ConstantValues.question_30_value = "";
		ConstantValues.question_31_value = "";
		ConstantValues.question_32_value = "";
		// sixth page
		ConstantValues.question_33_value = "";
		ConstantValues.question_34_value = "";
		ConstantValues.question_35_value = "";
		ConstantValues.question_36_value = "";
		ConstantValues.question_37_value = "";

		ConstantValues.f_question_1_value = "";
		ConstantValues.f_question_2_value = "";
		ConstantValues.f_question_3_value = "";
		ConstantValues.f_question_4_value = "";
		ConstantValues.f_question_5_value = "";
		ConstantValues.f_question_6_value = "";
		ConstantValues.f_question_7_value = "";
		ConstantValues.f_question_8_value = "";
		ConstantValues.f_question_9_value = "";
		ConstantValues.f_question_10_value = "";
		ConstantValues.f_question_11_value = "";
		ConstantValues.f_question_12_value = "";
		ConstantValues.f_question_13_value = "";
		ConstantValues.f_question_14_value = "";
		ConstantValues.f_question_15_value = "";
		ConstantValues.f_question_16_value = "";
		ConstantValues.f_question_17_value = "";

		// pataString scrore
		ConstantValues.result_level = "";
		ConstantValues.depression = "0";
		ConstantValues.anxiety = "0";
		ConstantValues.stress = "0";

		ConstantValues.depression_level = "0";
		ConstantValues.anxiety_level = "0";
		ConstantValues.stress_level = "0";
		ConstantValues.all_question_status = "";

	}

}
