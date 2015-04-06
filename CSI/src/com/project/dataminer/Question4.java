package com.project.dataminer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Question4 extends Activity {

	private Spinner q4a1, q4a2, q4a3;
	TextView q4m, q41, q42, q43;
	String id;
	String no;
	String kidname;
	DataDbAdapter ddb;
	TextView q4name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question4);

		q4a1 = (Spinner) findViewById(R.id.q4a1);
		q4a2 = (Spinner) findViewById(R.id.q4a2);
		q4a3 = (Spinner) findViewById(R.id.q4a3);
		q4m = (TextView) findViewById(R.id.q4main);
		q41 = (TextView) findViewById(R.id.q41);
		q42 = (TextView) findViewById(R.id.q42);
		q43 = (TextView) findViewById(R.id.q43);
		q4name = (TextView) findViewById(R.id.q4name);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		q4m.setTypeface(ThaiFont);
		q41.setTypeface(ThaiFont);
		q42.setTypeface(ThaiFont);
		q43.setTypeface(ThaiFont);
		q4m.setTextSize(20);
		q41.setTextSize(20);
		q42.setTextSize(20);
		q43.setTextSize(20);

		ddb = new DataDbAdapter(this);
		ddb.open();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}

		q4name.setText(kidname);

		ArrayList<String> strq4a1 = new ArrayList<String>();
		strq4a1.add("");
		strq4a1.add("ไม่เจ็บป่วยเลยในรอบ 1 เดือนที่ผ่านมา");
		strq4a1.add("เจ็บป่วยบ้างเล็กน้อยแต่สามารถใช้ชีวิตได้ตามปกติ");
		strq4a1.add("เจ็บป่วยบ่อยจนส่งผลต่อการใช้ชีวิตประจำวัน");
		ArrayAdapter<String> q4a1Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq4a1);
		q4a1Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q4a1.setAdapter(q4a1Adapter);

		ArrayList<String> strq4a2 = new ArrayList<String>();
		strq4a2.add("");
		strq4a2.add("เด็กได้รับการดูแลสุขภาพเหมาะสม");
		strq4a2.add("เด็กไม่ได้รับการดูแลสุขภาพอย่างเหมาะสมเลย");
		ArrayAdapter<String> q4a2Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq4a2);
		q4a2Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q4a2.setAdapter(q4a2Adapter);

		ArrayList<String> strq4a3 = new ArrayList<String>();
		strq4a3.add("");
		strq4a3.add("เด็กมีสิทธิสวัสดิการด้านสุขภาพ");
		// strq4a3.add("");
		strq4a3.add("เด็กไม่มีสิทธิสวัสดิการด้านสุขภาพ");
		ArrayAdapter<String> q4a3Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq4a3);
		q4a3Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q4a3.setAdapter(q4a3Adapter);

		Cursor c = ddb.getallfromidno(id, no);
		String ans41 = c.getString(c.getColumnIndex("ans41"));
		String ans42 = c.getString(c.getColumnIndex("ans42"));
		String ans43 = c.getString(c.getColumnIndex("ans43"));

		if (Followup.activityHint4) {

			q4a1.setSelection(Integer.parseInt(ans41));
			int value42 = Integer.parseInt(ans42);
			if (value42 == 3) {
				value42 = 2;
			}
			q4a2.setSelection(value42);
			int value43 = Integer.parseInt(ans43);
			if (value43 == 3) {
				value43 = 2;
			}
			q4a3.setSelection(value43);
		} else {
			q4a1.setSelection(0);
			q4a2.setSelection(0);
			q4a3.setSelection(0);
			Followup.activityHint4 = true;
		}

		// strq4a1.add("");
		// strq4a1.add("ไม่เจ็บป่วยเลยในรอบ 1 เดือนที่ผ่านมา");
		// strq4a1.add("เจ็บป่วยบ้างเล็กน้อยแต่สามารถใช้ชีวิตได้ตามปกติ");
		// strq4a1.add("เจ็บป่วยบ่อยจนส่งผลต่อการใช้ชีวิตประจำวัน");

		q4a1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int positon, long arg3) {

				ContentValues updateValues = new ContentValues();
				updateValues.put("ans41", positon);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		// strq4a2.add("");
		// strq4a2.add("เด็กได้รับการดูแลสุขภาพเหมาะสม");
		// strq4a2.add("เด็กไม่ได้รับการดูแลสุขภาพอย่างเหมาะสมเลย");

		q4a2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				if (arg2 == 2)
					arg2 = 3;
				updateValues.put("ans42", arg2);
				ddb.update(updateValues, id, no);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q4a3.setOnItemSelectedListener(new OnItemSelectedListener() {
			// strq4a3.add("");
			// strq4a3.add("เด็กมีสิทธิสวัสดิการด้านสุขภาพ");
			// // strq4a3.add("");
			// strq4a3.add("เด็กไม่มีสิทธิสวัสดิการด้านสุขภาพ");

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				int value = 0;
				if (pos == 2) {
					value = 3;
				} else {
					value = pos;
				}
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans43", value);
				ddb.update(updateValues, id, no);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question4, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(getApplicationContext(),
				com.project.dataminer.Menu.class);
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}
}
