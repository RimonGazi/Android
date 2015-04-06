package com.project.dataminer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
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

public class Question2 extends Activity {

	private Spinner q2a1, q2a2, q2a3, q2a4, q2a5, q2a6;
	String id;
	String no;
	String kidname;
	DataDbAdapter ddb;
	TextView q2m, q21, q22, q23, q24, q25, q26;
	TextView q2name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question2);

		q2a1 = (Spinner) findViewById(R.id.q2a1);
		q2a2 = (Spinner) findViewById(R.id.q2a2);
		q2a3 = (Spinner) findViewById(R.id.q2a3);
		q2a4 = (Spinner) findViewById(R.id.q2a4);
		q2a5 = (Spinner) findViewById(R.id.q2a5);
		q2a6 = (Spinner) findViewById(R.id.q2a6);
		q2m = (TextView) findViewById(R.id.q2main);
		q21 = (TextView) findViewById(R.id.q21);
		q22 = (TextView) findViewById(R.id.q22);
		q23 = (TextView) findViewById(R.id.q23);
		q24 = (TextView) findViewById(R.id.q24);
		q25 = (TextView) findViewById(R.id.q25);
		q26 = (TextView) findViewById(R.id.q26);
		q2name = (TextView) findViewById(R.id.q2name);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		q2m.setTypeface(ThaiFont);
		q21.setTypeface(ThaiFont);
		q22.setTypeface(ThaiFont);
		q23.setTypeface(ThaiFont);
		q24.setTypeface(ThaiFont);
		q25.setTypeface(ThaiFont);
		q26.setTypeface(ThaiFont);
		q2m.setTextSize(20);
		q21.setTextSize(20);
		q22.setTextSize(20);
		q23.setTextSize(20);
		q24.setTextSize(20);
		q25.setTextSize(20);
		q26.setTextSize(20);

		ddb = new DataDbAdapter(this);
		ddb.open();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}

		q2name.setText(kidname);
		ArrayList<String> strq2a1 = new ArrayList<String>();
		strq2a1.add("");
		strq2a1.add("สภาพบ้านมั่นคงแข็งแรง ปลอดภัย ");
		strq2a1.add("สภาพบ้านต้องได้รับการซ่อมแซมบางส่วน");
		strq2a1.add("สภาพบ้านทรุดโทรมมาก");

		ArrayAdapter<String> q2a1Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq2a1);
		q2a1Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q2a1.setAdapter(q2a1Adapter);

		ArrayList<String> strq2a2 = new ArrayList<String>();
		strq2a2.add("");
		strq2a2.add("มีห้องเป็นสัดส่วน  ไม่แออัด");
		strq2a2.add("ไม่มีห้องเป็นสัดส่วน แต่ไม่แออัด");
		strq2a2.add("มีห้องเป็นสัดส่วน แต่แออัด");
		strq2a2.add("ไม่มีห้องเป็นสัดส่วน และแออัด");

		ArrayAdapter<String> q2a2Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq2a2);
		q2a2Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q2a2.setAdapter(q2a2Adapter);

		ArrayList<String> strq2a3 = new ArrayList<String>();
		strq2a3.add("");
		strq2a3.add("สภาพแวดล้อมรอบบ้านมีความปลอดภัย");
		strq2a3.add("สภาพแวดล้อมรอบบ้านไม่ค่อยปลอดภัย");
		strq2a3.add("สภาพแวดล้อมรอบบ้านมีอันตรายสูง");

		ArrayAdapter<String> q2a3Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq2a3);
		q2a3Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q2a3.setAdapter(q2a3Adapter);

		ArrayList<String> strq2a4 = new ArrayList<String>();
		strq2a4.add("");
		strq2a4.add("บ้านสะอาด ถูกสุขลักษณะ");
		strq2a4.add("บ้านไม่ค่อยสะอาด ไม่ถูกสุขลักษณะ");
		strq2a4.add("สภาพบ้านสกปรก รกรุงรังมาก");

		ArrayAdapter<String> q2a4Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq2a4);
		q2a4Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q2a4.setAdapter(q2a4Adapter);

		ArrayList<String> strq2a5 = new ArrayList<String>();
		strq2a5.add("");
		strq2a5.add("ผู้ดูแลสามารถดูแลเด็กได้ดี");
		strq2a5.add("ผู้ดูแลเด็กมีข้อจำกัดในการดูแลเด็ก");
		strq2a5.add("ผู้ดูแลเด็กไม่สามารถดูแลเด็กได้อย่างเหมาะสมเลย");
		ArrayAdapter<String> q2a5Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq2a5);
		q2a5Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q2a5.setAdapter(q2a5Adapter);

		ArrayList<String> strq2a6 = new ArrayList<String>();
		strq2a6.add("");
		strq2a6.add("คนในครอบครัวไม่มีพฤติกรรมที่อันตรายต่อเด็ก");
		strq2a6.add("คนในครอบครัวมีพฤติกรรมที่ไม่เหมาะสม แต่ไม่อันตรายต่อเด็ก");
		strq2a6.add("คนในครอบครัวมีพฤติกรรมที่อันตรายต่อเด็กมาก");

		ArrayAdapter<String> q2a6Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq2a6);
		q2a6Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q2a6.setAdapter(q2a6Adapter);

		Cursor c = ddb.getallfromidno(id, no);
		String ans21 = c.getString(c.getColumnIndex("ans21"));
		String ans22 = c.getString(c.getColumnIndex("ans22"));
		String ans23 = c.getString(c.getColumnIndex("ans23"));
		String ans24 = c.getString(c.getColumnIndex("ans24"));
		String ans25 = c.getString(c.getColumnIndex("ans25"));
		String ans26 = c.getString(c.getColumnIndex("ans26"));
		if (Followup.activityHint2) {

			q2a1.setSelection(Integer.parseInt(ans21));
			q2a2.setSelection(Integer.parseInt(ans22));
			q2a3.setSelection(Integer.parseInt(ans23));
			q2a4.setSelection(Integer.parseInt(ans24));
			q2a5.setSelection(Integer.parseInt(ans25));
			q2a6.setSelection(Integer.parseInt(ans26));
		} else {
			Followup.activityHint2 = true;
			q2a1.setSelection(0);
			q2a2.setSelection(0);
			q2a3.setSelection(0);
			q2a4.setSelection(0);
			q2a5.setSelection(0);
			q2a6.setSelection(0);
		}

		q2a1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {
				// strq2a2.add("");
				// strq2a2.add("มีห้องเป็นสัดส่วน  ไม่แออัด");
				// strq2a2.add("ไม่มีห้องเป็นสัดส่วน แต่ไม่แออัด");
				// strq2a2.add("มีห้องเป็นสัดส่วน แต่แออัด");
				// strq2a2.add("ไม่มีห้องเป็นสัดส่วน และแออัด");
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans21", position);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q2a2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans22", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q2a3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans23", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q2a4.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans24", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q2a5.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans25", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q2a6.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans26", arg2);
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
		getMenuInflater().inflate(R.menu.question2, menu);
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
