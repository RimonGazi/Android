package com.project.dataminer;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class UserMenu extends Activity {

	String id;
	String kidname;
	String done;
	String age;
	TextView umname;
	Button umasses;
	TextView um2;
	UserDbAdapter udb;
	DataDbAdapter ddb;
	SimpleCursorAdapter adapter;
	ListView lv;
	int count;

	String common_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_menu);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
		}

		umname = (TextView) findViewById(R.id.umname);
		umasses = (Button) findViewById(R.id.umasses);
		um2 = (TextView) findViewById(R.id.um2);
		lv = (ListView) findViewById(R.id.umlistview);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		umname.setTypeface(ThaiFont);
		umasses.setTypeface(ThaiFont);
		um2.setTypeface(ThaiFont);
		umname.setTextSize(20);
		um2.setTextSize(20);

		udb = new UserDbAdapter(this);
		udb.open();
		Cursor c = udb.getid(id);

		Calendar today = Calendar.getInstance();
		String birthDateString = c.getString(c.getColumnIndex("dob")).trim();
		int birthDateDate = 0;
		int birthDateMonth = 0;
		int birthDateYear = 0;
		try {
			int i = birthDateString.indexOf("-");
			birthDateYear = Integer.parseInt(birthDateString.substring(0, i));

			int j = birthDateString.indexOf("-", i + 1);
			birthDateMonth = Integer.parseInt(birthDateString.substring(i + 1,
					j));
			birthDateDate = Integer.parseInt(birthDateString.substring(j + 1));

		} catch (Exception e) {
			// TODO: handle exception
		}

		CsiConstant.child_name = c.getString(c.getColumnIndex("nname"));
		// CsiConstant.child_age = getAge(birthDateYear, birthDateMonth,
		// birthDateDate);

		CsiConstant.child_age = birthDateYear + "";
		Log.d("mmmmmmmmmmmmmmUsrmenu", birthDateMonth + "");
		umname.setText(CsiConstant.child_name + "   " + CsiConstant.child_age);
		kidname = (String) umname.getText();
		done = c.getString(c.getColumnIndex("done"));
		common_id = c.getString(c.getColumnIndex("cid"));
		ddb = new DataDbAdapter(this);
		ddb.open();
		Cursor c2 = ddb.getallfromid(id);
		count = c2.getCount();
		// umname.setText(String.valueOf(count));
		adapter = new SimpleCursorAdapter(this, R.layout.show_asses, c2,
				new String[] { "timebegin" }, new int[] { R.id.showasses });
		lv.setAdapter(adapter);

		if (done.equals("0")) {
			umasses.setEnabled(false);
		}

		umasses.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ddb.AddData(Integer.parseInt(id), count + 1, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						"", common_id, "", "");
				ContentValues updateValues = new ContentValues();
				updateValues.put("done", 0);
				udb.update(updateValues, id);
				if (count == 0) {
					Intent intent = new Intent(getApplicationContext(),
							QuestionAll.class);
					intent.putExtra("id", id);
					intent.putExtra("no", String.valueOf(count + 1));
					intent.putExtra("kidname", kidname);
					startActivity(intent);
				} else {

					Log.d("user menu",
							"id :" + id + " no : " + String.valueOf(count + 1));
					Intent intent = new Intent(getApplicationContext(),
							Followup.class);
					intent.putExtra("id", id);
					intent.putExtra("no", String.valueOf(count + 1));
					intent.putExtra("kidname", kidname);
					startActivity(intent);
				}
			}
		});

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Cursor s = ddb.getallfromidno(id, String.valueOf(arg2 + 1));
				String ss = s.getString(s.getColumnIndex("saved"));
				if (ss.equals("1")) {
					Intent intent3 = new Intent(getApplicationContext(),
							Conclude.class);
					intent3.putExtra("id", id);
					intent3.putExtra("no", String.valueOf(arg2 + 1));
					intent3.putExtra("kidname", kidname);
					startActivity(intent3);
				} else {
					Followup.activityHint1 = false;
					Followup.activityHint2 = false;
					Followup.activityHint3 = false;
					Followup.activityHint4 = false;
					Followup.activityHint5 = false;
					Followup.activityHint6 = false;
					Followup.activityHintQdetail = false;
					Intent intent4 = new Intent(getApplicationContext(),
							QuestionAll.class);
					intent4.putExtra("id", id);
					intent4.putExtra("no", String.valueOf(arg2 + 1));
					intent4.putExtra("kidname", kidname);
					startActivity(intent4);
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_menu, menu);
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

	// private String getAge(int year, int month, int day) {
	//
	// // Calendar dob = Calendar.getInstance();
	// // Calendar today = Calendar.getInstance();
	// //
	// // dob.set(year, month, day);
	// //
	// // int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
	// //
	// // if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
	// // {
	// // age--;
	// // }
	// //
	// // Integer ageInt = new Integer(age);
	// // String ageS = ageInt.toString();
	// GregorianCalendar cal = new GregorianCalendar();
	// int y, m, d;
	// int age = 0;
	//
	// y = cal.get(Calendar.YEAR);
	// m = cal.get(Calendar.MONTH) + 1;
	// d = cal.get(Calendar.DAY_OF_MONTH);
	// Log.d("today ", y + "  m:" + m + "  d:" + d);
	// cal.set(year, month - 1, day);
	// age = y - cal.get(Calendar.YEAR);
	// Log.d("birthday or", cal.get(Calendar.MONTH) + "");
	// Log.d("birthday or", cal.get(Calendar.DAY_OF_MONTH) + "");
	//
	// Log.d("birthday or", cal.get(Calendar.YEAR) + "");
	//
	// if ((m < cal.get(Calendar.MONTH))
	// || ((m == cal.get(Calendar.MONTH)) && (d < cal
	// .get(Calendar.DAY_OF_MONTH)))) {
	// --age;
	// }
	// Log.d("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa", age
	// + "");
	//
	// return age + "";
	//
	// }
}
