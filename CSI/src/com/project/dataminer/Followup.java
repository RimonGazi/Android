package com.project.dataminer;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class Followup extends Activity {

	public static boolean activityHint1 = false;
	public static boolean activityHint2 = false;
	public static boolean activityHint3 = false;
	public static boolean activityHint4 = false;
	public static boolean activityHint5 = false;
	public static boolean activityHint6 = false;
	public static boolean activityHintQdetail = false;

	CheckBox h11, h12, h13, h14, h21, h22, h23, h24, h25, h26, h31, h32, h33,
			h41, h42, h43, h51, h52, h61, h62;
	String id;
	String no;
	String kidname;
	DataDbAdapter ddb;
	String qh11, qh12, qh13, qh14, qh21, qh22, qh23, qh24, qh25, qh26, qh31,
			qh32, qh33, qh41, qh42, qh43, qh51, qh52, qh61, qh62;
	Button done;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_followup);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}
		ddb = new DataDbAdapter(this);

		h11 = (CheckBox) findViewById(R.id.h11);
		h12 = (CheckBox) findViewById(R.id.h12);
		h13 = (CheckBox) findViewById(R.id.h13);
		h14 = (CheckBox) findViewById(R.id.h14);
		h21 = (CheckBox) findViewById(R.id.h21);
		h22 = (CheckBox) findViewById(R.id.h22);
		h23 = (CheckBox) findViewById(R.id.h23);
		h24 = (CheckBox) findViewById(R.id.h24);
		h25 = (CheckBox) findViewById(R.id.h25);
		h26 = (CheckBox) findViewById(R.id.h26);
		h31 = (CheckBox) findViewById(R.id.h31);
		h32 = (CheckBox) findViewById(R.id.h32);
		h33 = (CheckBox) findViewById(R.id.h33);
		h41 = (CheckBox) findViewById(R.id.h41);
		h42 = (CheckBox) findViewById(R.id.h42);
		h43 = (CheckBox) findViewById(R.id.h43);
		h51 = (CheckBox) findViewById(R.id.h51);
		h52 = (CheckBox) findViewById(R.id.h52);
		h61 = (CheckBox) findViewById(R.id.h61);
		h62 = (CheckBox) findViewById(R.id.h62);
		done = (Button) findViewById(R.id.done);

		ddb.open();
		Cursor c = ddb.getallfromidno(id,
				String.valueOf(Integer.parseInt(no) - 1));
		qh11 = c.getString(c.getColumnIndex("q1h1"));
		qh12 = c.getString(c.getColumnIndex("q1h2"));
		qh13 = c.getString(c.getColumnIndex("q1h3"));
		qh14 = c.getString(c.getColumnIndex("q1h4"));

		qh21 = c.getString(c.getColumnIndex("q2h1"));
		qh22 = c.getString(c.getColumnIndex("q2h2"));
		qh23 = c.getString(c.getColumnIndex("q2h3"));
		qh24 = c.getString(c.getColumnIndex("q2h4"));
		qh25 = c.getString(c.getColumnIndex("q2h5"));
		qh26 = c.getString(c.getColumnIndex("q2h6"));
		qh31 = c.getString(c.getColumnIndex("q3h1"));
		qh32 = c.getString(c.getColumnIndex("q3h2"));
		qh33 = c.getString(c.getColumnIndex("q3h3"));
		qh41 = c.getString(c.getColumnIndex("q4h1"));
		qh42 = c.getString(c.getColumnIndex("q4h2"));
		qh43 = c.getString(c.getColumnIndex("q4h3"));
		qh51 = c.getString(c.getColumnIndex("q5h1"));
		qh52 = c.getString(c.getColumnIndex("q5h2"));
		qh61 = c.getString(c.getColumnIndex("q6h1"));
		qh62 = c.getString(c.getColumnIndex("q6h2"));

		if (qh11.equals("0")) {
			h11.setVisibility(View.INVISIBLE);
		}
		if (qh12.equals("0")) {
			h12.setVisibility(View.INVISIBLE);
		}
		if (qh13.equals("0")) {
			h13.setVisibility(View.INVISIBLE);
		}
		if (qh14.equals("0")) {
			h14.setVisibility(View.INVISIBLE);
		}
		if (qh21.equals("0")) {
			h21.setVisibility(View.INVISIBLE);
		}
		if (qh22.equals("0")) {
			h22.setVisibility(View.INVISIBLE);
		}
		if (qh23.equals("0")) {
			h23.setVisibility(View.INVISIBLE);
		}
		if (qh24.equals("0")) {
			h24.setVisibility(View.INVISIBLE);
		}
		if (qh25.equals("0")) {
			h25.setVisibility(View.INVISIBLE);
		}
		if (qh26.equals("0")) {
			h26.setVisibility(View.INVISIBLE);
		}
		if (qh31.equals("0")) {
			h31.setVisibility(View.INVISIBLE);
		}
		if (qh32.equals("0")) {
			h32.setVisibility(View.INVISIBLE);
		}
		if (qh33.equals("0")) {
			h33.setVisibility(View.INVISIBLE);
		}
		if (qh41.equals("0")) {
			h41.setVisibility(View.INVISIBLE);
		}
		if (qh42.equals("0")) {
			h42.setVisibility(View.INVISIBLE);
		}
		if (qh43.equals("0")) {
			h43.setVisibility(View.INVISIBLE);
		}
		if (qh51.equals("0")) {
			h51.setVisibility(View.INVISIBLE);
		}
		if (qh52.equals("0")) {
			h52.setVisibility(View.INVISIBLE);
		}
		if (qh61.equals("0")) {
			h61.setVisibility(View.INVISIBLE);
		}
		if (qh62.equals("0")) {
			h62.setVisibility(View.INVISIBLE);
		}
		done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ContentValues c = new ContentValues();
				c.put("q1h1", h11.isChecked() ? 1 : 0);
				c.put("q1h2", h12.isChecked() ? 1 : 0);
				c.put("q1h3", h13.isChecked() ? 1 : 0);
				c.put("q1h4", h14.isChecked() ? 1 : 0);
				c.put("q2h1", h21.isChecked() ? 1 : 0);
				c.put("q2h2", h22.isChecked() ? 1 : 0);
				c.put("q2h3", h23.isChecked() ? 1 : 0);
				c.put("q2h4", h24.isChecked() ? 1 : 0);
				c.put("q2h5", h25.isChecked() ? 1 : 0);
				c.put("q2h6", h26.isChecked() ? 1 : 0);
				c.put("q3h1", h31.isChecked() ? 1 : 0);
				c.put("q3h2", h32.isChecked() ? 1 : 0);
				c.put("q3h3", h33.isChecked() ? 1 : 0);
				c.put("q4h1", h41.isChecked() ? 1 : 0);
				c.put("q4h2", h42.isChecked() ? 1 : 0);
				c.put("q4h3", h43.isChecked() ? 1 : 0);
				c.put("q5h1", h51.isChecked() ? 1 : 0);
				c.put("q5h2", h52.isChecked() ? 1 : 0);
				c.put("q6h1", h61.isChecked() ? 1 : 0);
				c.put("q6h2", h62.isChecked() ? 1 : 0);
				ddb.update(c, id, String.valueOf(Integer.parseInt(no) - 1));
				Intent intent = new Intent(getApplicationContext(),
						QuestionAll.class);
				intent.putExtra("id", id);
				intent.putExtra("no", String.valueOf((Integer.parseInt(no))));
				intent.putExtra("kidname", kidname);
				Log.d("follow up",
						"id :" + id + " no : " + (Integer.parseInt(no)));
				activityHint1 = false;
				activityHint2 = false;
				activityHint3 = false;
				activityHint4 = false;
				activityHint5 = false;
				activityHint6 = false;
				activityHintQdetail = false;
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.followup, menu);
		return true;
	}

}
