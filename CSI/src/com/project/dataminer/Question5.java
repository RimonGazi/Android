package com.project.dataminer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Question5 extends Activity {

	private Spinner q5a1, q5a2, q5a3, q5a4;
	TextView q5m, q51, q52, q53, q54;
	String id;
	String no;
	String kidname;
	DataDbAdapter ddb;
	TextView q5name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question5);

		q5a1 = (Spinner) findViewById(R.id.q5a1);
		q5a2 = (Spinner) findViewById(R.id.q5a2);
		q5a3 = (Spinner) findViewById(R.id.q5a3);
		q5a4 = (Spinner) findViewById(R.id.q5a4);
		q5m = (TextView) findViewById(R.id.q5main);
		q51 = (TextView) findViewById(R.id.q51);
		q52 = (TextView) findViewById(R.id.q52);
		q53 = (TextView) findViewById(R.id.q53);
		q54 = (TextView) findViewById(R.id.q54);
		q5name = (TextView) findViewById(R.id.q5name);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		q51.setTypeface(ThaiFont);
		q52.setTypeface(ThaiFont);
		q53.setTypeface(ThaiFont);
		q54.setTypeface(ThaiFont);
		q5m.setTypeface(ThaiFont);
		q51.setTextSize(20);
		q52.setTextSize(20);
		q53.setTextSize(20);
		q54.setTextSize(20);
		q5m.setTextSize(20);

		ddb = new DataDbAdapter(this);
		ddb.open();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}

		q5name.setText(kidname);

		ArrayList<String> strq5a1 = new ArrayList<String>();
		strq5a1.add("");
		strq5a1.add("อายุต่ำกว่า 3 ขวบ");
		strq5a1.add("เด็กไม่มีอาการซึมเศร้า หรือ/และเก็บกด");
		strq5a1.add("เด็กมีอาการซึมเศร้า และ/หรือเก็บกดมาก");
		
		
		// "" value 0 no color origanl value 0
		// "อายุต่ำกว่า 3 ขวบ" value 5 no color origanl value 1
		// "เด็กไม่มีอาการซึมเศร้า หรือ/และเก็บกด" value 1 green color origanl
		// value 2
		// "เด็กมีอาการซึมเศร้า และ/หรือเก็บกดมาก" value 3 red color origanl
		// value 3
		ArrayAdapter<String> q5a1Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq5a1);
		q5a1Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q5a1.setAdapter(q5a1Adapter);

		ArrayList<String> strq5a2 = new ArrayList<String>();
		strq5a2.add(""); // value 0 no color ov 0
		strq5a2.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
		strq5a2.add("เด็กมีอารมณ์ปกติ ควบคุมอารมณ์ได้ดี");// value 1 green ov 2
		strq5a2.add("เด็กงอแงบ่อย เอาแต่ใจ");// value 2 yello color ov 3
		strq5a2.add("เด็กมีอารมณ์แปรปรวน ควบคุมอารมณ์ไม่ได้");// value 3 red
																// color ov 4

		ArrayAdapter<String> q5a2Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq5a2);
		q5a2Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q5a2.setAdapter(q5a2Adapter);

		ArrayList<String> strq5a3 = new ArrayList<String>();
		strq5a3.add(""); // value 0 no color ov 0
		strq5a3.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
		strq5a3.add("เข้ากับเพื่อนได้ดี (ทั้งกลุ่มตนเอง และอื่นๆ)");// value 1
																	// green ov
																	// 2
		strq5a3.add("อยู่กับกลุ่มเพื่อนของตัวเอง เข้ากับเพื่อนคนอื่นไม่ได้");// value
																				// 2
																				// yellow
																				// ov
																				// 3
		strq5a3.add("เข้ากับเพื่อนไม่ได้ หรือไม่เล่นกับเพื่อน แยกตัว");// value
																		// 3 red
																		// ov 4

		ArrayAdapter<String> q5a3Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq5a3);
		q5a3Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q5a3.setAdapter(q5a3Adapter);

		ArrayList<String> strq5a4 = new ArrayList<String>();
		strq5a4.add(""); // value 0 no color ov 0
		strq5a4.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
		strq5a4.add("ไม่มีปัญหาพฤติกรรมทางสังคม");// value 1 green ov 2
		// /strq5a4.add("");
		strq5a4.add("มีปัญหาพฤติกรรมทางสังคม");// value 3 red ov 3
		ArrayAdapter<String> q5a4Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strq5a4);
		q5a4Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		q5a4.setAdapter(q5a4Adapter);

		Cursor c = ddb.getallfromidno(id, no);
		String ans51 = c.getString(c.getColumnIndex("ans51"));
		String ans52 = c.getString(c.getColumnIndex("ans52"));
		String ans53 = c.getString(c.getColumnIndex("ans53"));
		String ans54 = c.getString(c.getColumnIndex("ans54"));

		if (Followup.activityHint5) {

			// "" value 0 no color origanl value 0
			// "อายุต่ำกว่า 3 ขวบ" value 5 no color origanl value 1
			// "เด็กไม่มีอาการซึมเศร้า หรือ/และเก็บกด" value 1 green color
			// origanl
			// value 2
			// "เด็กมีอาการซึมเศร้า และ/หรือเก็บกดมาก" value 3 red color origanl
			// value 3
			int question51 = Integer.parseInt(ans51);
			if (question51 == 5) {
				question51 = 1;
			} else if (question51 == 1) {
				question51 = 2;
			} else if (question51 == 3) {
				question51 = 3;
			}
			q5a1.setSelection(question51);

			// strq5a2.add(""); // value 0 no color ov 0
			// strq5a2.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
			// strq5a2.add("เด็กมีอารมณ์ปกติ ควบคุมอารมณ์ได้ดี");// value 1
			// green ov 2
			// strq5a2.add("เด็กงอแงบ่อย เอาแต่ใจ");// value 2 yello color ov 3
			// strq5a2.add("เด็กมีอารมณ์แปรปรวน ควบคุมอารมณ์ไม่ได้");// value 3
			// red color ov 4
			int question52 = Integer.parseInt(ans52);
			if (question52 == 4) {
				question52 = 1;
			} else if (question52 == 1) {
				question52 = 2;
			} else if (question52 == 2) {
				question52 = 3;
			} else if (question52 == 3) {
				question52 = 4;
			}
			q5a2.setSelection(question52);
			//
			// strq5a3.add(""); // value 0 no color ov 0
			// strq5a3.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
			// strq5a3.add("เข้ากับเพื่อนได้ดี (ทั้งกลุ่มตนเอง และอื่นๆ)");//
			// value 1 green ov 2
			// strq5a3.add("อยู่กับกลุ่มเพื่อนของตัวเอง เข้ากับเพื่อนคนอื่นไม่ได้");//
			// value 2 yellow ov 3
			// strq5a3.add("เข้ากับเพื่อนไม่ได้ หรือไม่เล่นกับเพื่อน แยกตัว");//
			// value 3 red ov 4

			int question53 = Integer.parseInt(ans53);
			if (question53 == 4) {
				question53 = 1;
			} else if (question53 == 1) {
				question53 = 2;
			} else if (question53 == 2) {
				question53 = 3;
			} else if (question53 == 3) {
				question53 = 4;
			}
			q5a3.setSelection(question53);

			//
			// strq5a4.add(""); // value 0 no color ov 0
			// strq5a4.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
			// strq5a4.add("ไม่มีปัญหาพฤติกรรมทางสังคม");// value 1 green ov 2
			// // /strq5a4.add("");
			// strq5a4.add("มีปัญหาพฤติกรรมทางสังคม");// value 3 red ov 3
			//
			int question54 = Integer.parseInt(ans54);

			if (question54 == 4) {
				question54 = 1;
			} else if (question54 == 1) {
				question54 = 2;
			}

			q5a4.setSelection(question54);
		} else {
			q5a4.setSelection(0);
			q5a3.setSelection(0);
			q5a2.setSelection(0);
			q5a1.setSelection(0);
			Followup.activityHint5 = true;
		}

		q5a1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {
				int value = 0;

				// "" value 0 no color origanl value 0
				// "อายุต่ำกว่า 3 ขวบ" value 5 no color origanl value 1
				// "เด็กไม่มีอาการซึมเศร้า หรือ/และเก็บกด" value 1 green color
				// origanl
				// value 2
				// "เด็กมีอาการซึมเศร้า และ/หรือเก็บกดมาก" value 3 red color
				// origanl
				// value 3

				if (position == 1) {
					value = 5;
				} else if (position == 2) {
					value = 1;
				} else if (position == 3) {
					value = 3;
				}

				ContentValues updateValues = new ContentValues();
				updateValues.put("ans51", value);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q5a2.setOnItemSelectedListener(new OnItemSelectedListener() {

			// strq5a2.add(""); //value 0 no color ov 0
			// strq5a2.add("อายุต่ำกว่า 3 ขวบ");//value 4 no color ov 1
			// strq5a2.add("เด็กมีอารมณ์ปกติ ควบคุมอารมณ์ได้ดี");// value 1
			// green ov 2
			// strq5a2.add("เด็กงอแงบ่อย เอาแต่ใจ");// value 2 yello color ov 3
			// strq5a2.add("เด็กมีอารมณ์แปรปรวน ควบคุมอารมณ์ไม่ได้");// value 3
			// red color ov 4
			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {
				int value = 0;
				TextView selectedText = (TextView) parent.getChildAt(0);
				if (position == 0) {
					// value 0 no color ov 0
					value = 0;
				} else if (position == 1) {
					// value 4 no color ov 1
					value = 4;
				} else if (position == 2) {
					// selectedText.setTextColor(Color.GREEN);
					value = 1;
				} else if (position == 3) {
					// selectedText.setTextColor(Color.YELLOW);
					value = 2;
				} else if (position == 4) {
					// selectedText.setTextColor(Color.RED);
					value = 3;
				}
				Log.d("222222222", value + "");
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans52", value);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q5a3.setOnItemSelectedListener(new OnItemSelectedListener() {
			// strq5a3.add(""); // value 0 no color ov 0
			// strq5a3.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
			// strq5a3.add("เข้ากับเพื่อนได้ดี (ทั้งกลุ่มตนเอง และอื่นๆ)");//
			// value 1 green ov 2
			// strq5a3.add("อยู่กับกลุ่มเพื่อนของตัวเอง เข้ากับเพื่อนคนอื่นไม่ได้");//
			// value 2 yellow ov 3
			// strq5a3.add("เข้ากับเพื่อนไม่ได้ หรือไม่เล่นกับเพื่อน แยกตัว");//
			// value 3 red ov 4

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {
				int value = 0;
				TextView selectedText = (TextView) parent.getChildAt(0);
				if (position == 0) {
					value = 0;// no color;
				} else if (position == 1) {

					value = 4;// no color
				} else if (position == 2) {
					// selectedText.setTextColor(Color.GREEN);
					value = 1;
				} else if (position == 3) {
					// selectedText.setTextColor(Color.YELLOW);
					value = 2;

				} else if (position == 4) {
					// selectedText.setTextColor(Color.RED);
					value = 3;
				}
				Log.d("33333333333", value + "");
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans53", value);
				ddb.update(updateValues, id, no);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		q5a4.setOnItemSelectedListener(new OnItemSelectedListener() {

			// strq5a4.add(""); // value 0 no color ov 0
			// strq5a4.add("อายุต่ำกว่า 3 ขวบ");// value 4 no color ov 1
			// strq5a4.add("ไม่มีปัญหาพฤติกรรมทางสังคม");// value 1 green ov 2
			// strq5a4.add("มีปัญหาพฤติกรรมทางสังคม");// value 3 red ov 3

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {

				int value = 0;
				TextView selectedText = (TextView) parent.getChildAt(0);
				if (position == 0) {
					value = 0;// no color;
				} else if (position == 1) {

					value = 4;// no color
				} else if (position == 2) {
					// selectedText.setTextColor(Color.GREEN);
					value = 1;
				} else if (position == 3) {
					// selectedText.setTextColor(Color.RED);
					value = 3;
				}
				Log.d("44444444444444", value + "");
				ContentValues updateValues = new ContentValues();
				updateValues.put("ans54", value);
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
		getMenuInflater().inflate(R.menu.question5, menu);
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
