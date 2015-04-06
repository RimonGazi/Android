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

public class Question6 extends Activity {

	private Spinner q6a1, q6a2;
	TextView q61, q62;
	String id;
	String no;
	String kidname;
	DataDbAdapter ddb;
	TextView q6name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question6);

		q6a1 = (Spinner) findViewById(R.id.q6a1);
		q6a2 = (Spinner) findViewById(R.id.q6a2);
		q61 = (TextView) findViewById(R.id.q61);
		q62 = (TextView) findViewById(R.id.q62);
		q6name = (TextView) findViewById(R.id.q6name);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		q61.setTypeface(ThaiFont);
		q62.setTypeface(ThaiFont);
		q61.setTextSize(20);
		q62.setTextSize(20);

		ddb = new DataDbAdapter(this);
		ddb.open();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}

		q6name.setText(kidname);

		ArrayList<String> strq6a1 = new ArrayList<String>();
		strq6a1.add("");
		strq6a1.add("เด็กไม่มีปัญหาด้านการเรียนรู้");
		strq6a1.add("มีแนวโน้ม หรือข้อบ่งชี้ว่าเด็กอาจมีปัญหาด้านการเรียนรู้");
		strq6a1.add("เด็กมีปัญหาด้านการเรียนรู้");
//		
//		strq6a1.add("");0
//		strq6a1.add("เด็กไม่มีปัญหาด้านการเรียนรู้");1
//		strq6a1.add("มีแนวโน้ม หรือข้อบ่งชี้ว่าเด็กอาจมีปัญหาด้านการเรียนรู้");2
//		strq6a1.add("เด็กมีปัญหาด้านการเรียนรู้");3
		ArrayAdapter<String> q6a1Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq6a1);
		q6a1Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q6a1.setAdapter(q6a1Adapter);

		ArrayList<String> strq6a2 = new ArrayList<String>();
		strq6a2.add("");
		strq6a2.add("อายุไม่ถึงเกณฑ์เข้าเรียน");
		strq6a2.add("ได้เรียนตามเกณฑ์อายุ และจบการศึกษาภาคบังคับตามเกณฑ์แล้ว ");
		strq6a2.add("กำลังเรียนตามเกณฑ์อายุ และมีแนวโน้มที่จะจบการศึกษาภาคบังคับ");
		strq6a2.add("ได้เรียนตามเกณฑ์อายุ แต่มีแนวโน้มว่าเด็กจะต้องออกจากโรงเรียนหรือเลิกเรียน");
		strq6a2.add("เรียนช้ากว่าเกณฑ์ แต่ยังเรียนอยู่ ");
		strq6a2.add("เรียนช้ากว่าเกณฑ์ และเรียนจบการศึกษาภาคบังคับเกณฑ์แล้ว");
		strq6a2.add("เด็กไม่ได้เข้าเรียนเลย แม้อายุจะถึงเกณฑ์");
		strq6a2.add("เด็กยังไม่จบการศึกษาภาคบังคับ");
		
//		strq6a2.add(""); 0
//		strq6a2.add("อายุไม่ถึงเกณฑ์เข้าเรียน");1
//		strq6a2.add("ได้เรียนตามเกณฑ์อายุ และจบการศึกษาภาคบังคับตามเกณฑ์แล้ว ");2
//		strq6a2.add("กำลังเรียนตามเกณฑ์อายุ และมีแนวโน้มที่จะจบการศึกษาภาคบังคับ");3
//		strq6a2.add("ได้เรียนตามเกณฑ์อายุ แต่มีแนวโน้มว่าเด็กจะต้องออกจากโรงเรียนหรือเลิกเรียน");4
//		strq6a2.add("เรียนช้ากว่าเกณฑ์ แต่ยังเรียนอยู่ ");5
//		strq6a2.add("เรียนช้ากว่าเกณฑ์ และเรียนจบการศึกษาภาคบังคับเกณฑ์แล้ว");6
//		strq6a2.add("เด็กไม่ได้เข้าเรียนเลย แม้อายุจะถึงเกณฑ์");7
//		strq6a2.add("เด็กยังไม่จบการศึกษาภาคบังคับ");8

		ArrayAdapter<String> q6a2Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq6a2);
		q6a2Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q6a2.setAdapter(q6a2Adapter);
		Cursor c = ddb.getallfromidno(id, no);
		String ans61 = c.getString(c.getColumnIndex("ans61"));
		String ans62 = c.getString(c.getColumnIndex("ans62"));

		if (Followup.activityHint6) {
			q6a1.setSelection(Integer.parseInt(ans61));
			q6a2.setSelection(Integer.parseInt(ans62));
		} else {
			Followup.activityHint6 = true;
			q6a1.setSelection(0);
			q6a2.setSelection(0);
		}

		q6a1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long arg3) {
//				TextView selectedText = (TextView) parent.getChildAt(0);
//				selectedText.setTextColor(Color.GREEN);
//				 if ((position == 1) ||(position == 2) ||(position == 3)) {
//					selectedText.setTextColor(Color.GREEN);
//					
//				} else  if ((position == 4) ||(position == 5) ||(position == 6)) {
//					selectedText.setTextColor(Color.YELLOW);
//					
//				} else  if ((position == 7) ||(position == 8)) {
//					 selectedText.setTextColor(Color.RED);
//					
//				}
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans61", position);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q6a2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {

//				TextView selectedText = (TextView) parent.getChildAt(0);
////				if (position == 0) {
////					selectedText.setTextColor(Color.GREEN);
////				}

				ContentValues updateValues = new ContentValues();
				updateValues.put("ans62", position);
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
		getMenuInflater().inflate(R.menu.question6, menu);
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
