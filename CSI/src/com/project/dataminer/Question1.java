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

public class Question1 extends Activity {

	private Spinner q1a1, q1a2, q1a3;
	String id;
	String no;
	String kidname;
	DataDbAdapter ddb;
	TextView q1m;
	TextView q11;
	TextView q12;
	TextView q13;
	TextView qname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question1);

		initWidget();
		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		q11.setTypeface(ThaiFont);
		q12.setTypeface(ThaiFont);
		q13.setTypeface(ThaiFont);
		q1m.setTypeface(ThaiFont);
		q11.setTextSize(20);
		q12.setTextSize(20);
		q13.setTextSize(20);
		q1m.setTextSize(20);

		ddb = new DataDbAdapter(this);
		ddb.open();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}

		qname.setText(kidname);
		ArrayList<String> strq1a1 = new ArrayList<String>();

		strq1a1.add("");
		strq1a1.add("มีให้กินอย่างเพียงพอ และไม่อด");
		strq1a1.add("อดบ้างเป็นบางมื้อ ");
		strq1a1.add("ต้องทนหิวเป็นประจำ (ไม่ค่อยมีกิน)");
		ArrayAdapter<String> q1a1Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq1a1);
		q1a1Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q1a1.setAdapter(q1a1Adapter);

		ArrayList<String> strq1a2 = new ArrayList<String>();

		strq1a2.add("");
		strq1a2.add("กินอาหารที่มีประโยชน์เสมอ");
		strq1a2.add("กินอาหารที่มีประโยชน์บ้าง");
		strq1a2.add("ไม่เคยมีอาหารที่มีประโยชน์กินเลย");
		ArrayAdapter<String> q1a2Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq1a2);
		q1a2Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q1a2.setAdapter(q1a2Adapter);

		ArrayList<String> strq1a3 = new ArrayList<String>();
		strq1a3.add("");
		strq1a3.add("มีน้ำหนักส่วนสูงตามเกณฑ์มาตรฐาน");
		strq1a3.add("มีน้ำหนักส่วนสูงน้อย/มากกว่าเกณฑ์นิดหน่อย");
		strq1a3.add("อ้วนหรือผอมมากเกินไป");
		ArrayAdapter<String> q1a3Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq1a3);
		q1a3Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q1a3.setAdapter(q1a3Adapter);

		Cursor c = ddb.getallfromidno(id, no);
		String ans11 = c.getString(c.getColumnIndex("ans11"));
		String ans12 = c.getString(c.getColumnIndex("ans12"));
		String ans13 = c.getString(c.getColumnIndex("ans13"));

		q1a1.setSelection(Integer.parseInt(ans11));
		q1a2.setSelection(Integer.parseInt(ans12));
		q1a3.setSelection(Integer.parseInt(ans13));

		q1a1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans11", arg2);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q1a2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans12", arg2);
				ddb.update(updateValues, id, no);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q1a3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans13", arg2);
				ddb.update(updateValues, id, no);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void initWidget() {
		q1a1 = (Spinner) findViewById(R.id.q1a1);
		q1a2 = (Spinner) findViewById(R.id.q1a2);
		q1a3 = (Spinner) findViewById(R.id.q1a3);
		q11 = (TextView) findViewById(R.id.q11);
		q12 = (TextView) findViewById(R.id.q12);
		q13 = (TextView) findViewById(R.id.q13);
		q1m = (TextView) findViewById(R.id.q1main);
		qname = (TextView) findViewById(R.id.q1name);
		if (Followup.activityHint1) {

		} else {

			q1a1.setSelection(0);
			q1a2.setSelection(0);
			q1a2.setSelection(0);
			Followup.activityHint1 = true;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question1, menu);
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
