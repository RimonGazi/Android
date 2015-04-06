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

public class Question3 extends Activity {

	private Spinner q3a1, q3a2, q3a3, q3a4, q3a5;
	TextView q3m, q31, q32, q33, q34, q35;
	String id;
	String no;
	String kidname;
	DataDbAdapter ddb;
	TextView q3name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question3);

		q3a1 = (Spinner) findViewById(R.id.q3a1);
		q3a2 = (Spinner) findViewById(R.id.q3a2);
		q3a3 = (Spinner) findViewById(R.id.q3a3);
		q3a4 = (Spinner) findViewById(R.id.q3a4);
		q3a5 = (Spinner) findViewById(R.id.q3a5);
		q3m = (TextView) findViewById(R.id.q3main);
		q31 = (TextView) findViewById(R.id.q31);
		q32 = (TextView) findViewById(R.id.q32);
		q33 = (TextView) findViewById(R.id.q33);
		q34 = (TextView) findViewById(R.id.q34);
		q35 = (TextView) findViewById(R.id.q35);
		q3name = (TextView) findViewById(R.id.q3name);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		q3m.setTypeface(ThaiFont);
		q31.setTypeface(ThaiFont);
		q32.setTypeface(ThaiFont);
		q33.setTypeface(ThaiFont);
		q34.setTypeface(ThaiFont);
		q35.setTypeface(ThaiFont);
		q3m.setTextSize(20);
		q31.setTextSize(20);
		q32.setTextSize(20);
		q33.setTextSize(20);
		q34.setTextSize(20);
		q35.setTextSize(20);

		ddb = new DataDbAdapter(this);
		ddb.open();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}
		q3name.setText(kidname);

		ArrayList<String> strq3a1 = new ArrayList<String>();
		strq3a1.add("");
		strq3a1.add("ปลอดภัยจากความรุนแรงทางเพศ ทางร่างกาย และจิตใจ");
		strq3a1.add("มีความเสี่ยงต่อความรุนแรงทางเพศ ทางร่างกาย และจิตใจ");
		strq3a1.add("ตกเป็นเหยื่อความรุนแรงทางเพศ ทางร่างกาย และจิตใจ");
		ArrayAdapter<String> q3a1Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq3a1);
		q3a1Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q3a1.setAdapter(q3a1Adapter);

		ArrayList<String> strq3a2 = new ArrayList<String>();
		strq3a2.add("");
		strq3a2.add("เด็กไม่ถูกเลือกปฏิบัติหรือกีดกันทางสังคม");
		strq3a2.add("เด็กอาจถูกเลือกปฏิบัติหรือกีดกันทางสังคม");
		strq3a2.add("เด็กถูกเลือกปฏิบัติหรือกีดกันทางสังคม");

		ArrayAdapter<String> q3a2Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq3a2);
		q3a2Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q3a2.setAdapter(q3a2Adapter);

		ArrayList<String> strq3a3 = new ArrayList<String>();
		strq3a3.add("");
		strq3a3.add("ไม่มีการใช้แรงงานเด็กเกินกำลัง ");
		strq3a3.add("เด็กอาจถูกใช้แรงงานเกินกำลัง");
		strq3a3.add("เด็กถูกใช้แรงงานเกินกำลัง");

		ArrayAdapter<String> q3a3Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq3a3);
		q3a3Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q3a3.setAdapter(q3a3Adapter);

		ArrayList<String> strq3a4 = new ArrayList<String>();
		strq3a4.add("");
		strq3a4.add("เด็กมีสถานะทางกฎหมาย");
		strq3a4.add("เด็กกำลังขอสถานะทางกฎหมาย");
		strq3a4.add("เด็กไร้สถานะทางกฎหมาย");
		ArrayAdapter<String> q3a4Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq3a4);
		q3a4Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q3a4.setAdapter(q3a4Adapter);

		ArrayList<String> strq3a5 = new ArrayList<String>();
		strq3a5.add("");
		strq3a5.add("เด็กไม่อยู่ในคดีความใดๆ");
		strq3a5.add("เด็กเคยอยู่ในคดีความ แต่จบสิ้นไปแล้ว");
		strq3a5.add("เด็กอยู่ระหว่างคดีความ รอลงอาญาหรือคุมประพฤติ");
		ArrayAdapter<String> q3a5Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq3a5);
		q3a5Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q3a5.setAdapter(q3a5Adapter);

		Cursor c = ddb.getallfromidno(id, no);
		String ans31 = c.getString(c.getColumnIndex("ans31"));
		String ans32 = c.getString(c.getColumnIndex("ans32"));
		String ans33 = c.getString(c.getColumnIndex("ans33"));
		String ans34 = c.getString(c.getColumnIndex("ans34"));
		String ans35 = c.getString(c.getColumnIndex("ans35"));
		if (Followup.activityHint3) {

			q3a1.setSelection(Integer.parseInt(ans31));
			q3a2.setSelection(Integer.parseInt(ans32));
			q3a3.setSelection(Integer.parseInt(ans33));
			q3a4.setSelection(Integer.parseInt(ans34));
			q3a5.setSelection(Integer.parseInt(ans35));
		} else {
			q3a1.setSelection(0);
			q3a2.setSelection(0);
			q3a3.setSelection(0);
			q3a4.setSelection(0);
			q3a5.setSelection(0);
			Followup.activityHint3 = true;
		}

		q3a1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans31", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q3a2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans32", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q3a3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans33", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q3a4.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans34", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q3a5.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans35", arg2);
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
		getMenuInflater().inflate(R.menu.question3, menu);
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
