package net.sistransitomobile.setting;

import net.sistransitomobile.database.SettingDatabaseAdapter;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.main.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class SettingActivity extends SherlockActivity implements
		OnCheckedChangeListener {

	private ImageButton im_btn_back;
	private CheckBox checkBoxVibarte, checkBoxRington, checkBoxAutoBackup;
	private SettingDatabaseAdapter database;
	private TextView tv_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_main);
		database = DatabaseCreator.getDatabaseAdapterSetting(this);
		actionbarSetup();
		initializedView();
	}

	private void actionbarSetup() {
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText(getResources().getString(R.string.setting));
		im_btn_back = (ImageButton) findViewById(R.id.im_btn_back);
		im_btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	private void initializedView() {
		checkBoxAutoBackup = (CheckBox) findViewById(R.id.checkBoxAutoBackup);
		checkBoxRington = (CheckBox) findViewById(R.id.checkBoxRington);
		checkBoxVibarte = (CheckBox) findViewById(R.id.checkBoxVibarte);
		if (database.getAutobackup()) {
			checkBoxAutoBackup.setChecked(true);

		} else {
			checkBoxAutoBackup.setChecked(false);
		}
		if (database.getRingtone()) {
			checkBoxRington.setChecked(true);
		} else {
			checkBoxRington.setChecked(false);
		}
		if (database.getVibrator()) {
			checkBoxVibarte.setChecked(true);
			Log.d("VVVVVVVVVVVVVVVVVVVVV", database.getVibrator() + " ");

		} else {
			checkBoxVibarte.setChecked(false);
			Log.d("VVVVVVVVVVVVVVVVVVVVVe", database.getVibrator() + " ");
		}
		checkBoxVibarte.setOnCheckedChangeListener(this);
		checkBoxRington.setOnCheckedChangeListener(this);
		checkBoxAutoBackup.setOnCheckedChangeListener(this);

	}

	@Override
	public void onCheckedChanged(CompoundButton view, boolean isChecked) {
		switch (view.getId()) {
		case R.id.checkBoxAutoBackup:
			if (isChecked) {
				database.setAutobackup(true);
			} else {
				database.setAutobackup(false);
			}

			break;
		case R.id.checkBoxRington:
			if (isChecked) {
				database.setRingtone(true);
			} else {
				database.setRingtone(false);
			}

			break;
		case R.id.checkBoxVibarte:
			Log.d("hhhhhhhhhhhhhhhhhhhhhhh", database.getVibrator() + "");
			if (isChecked) {
				database.setVibrator(true);
			} else {
				database.setVibrator(false);
			}
			Log.d("hhhhhhhhhhhhhhhhhhhhhhh", database.getVibrator() + "");
			break;
		}
	}

}
