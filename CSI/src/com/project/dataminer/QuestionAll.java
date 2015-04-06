package com.project.dataminer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuestionAll extends Activity {

	String id, no, kidname;
	Button q1, q2, q3, q4, q5, q6, cc, help, questionDetail;

	TextView qname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_all);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
			Log.d("question all",
					"id :" + id + " no : "+no );
		}

		q1 = (Button) findViewById(R.id.q1);
		q2 = (Button) findViewById(R.id.q2);
		q3 = (Button) findViewById(R.id.q3);
		q4 = (Button) findViewById(R.id.q4);
		q5 = (Button) findViewById(R.id.q5);
		q6 = (Button) findViewById(R.id.q6);
		cc = (Button) findViewById(R.id.cc);
		help = (Button) findViewById(R.id.help);
		questionDetail = (Button) findViewById(R.id.detailQuestion);
		qname = (TextView) findViewById(R.id.qname);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		qname.setTypeface(ThaiFont);
		q1.setTypeface(ThaiFont);
		q2.setTypeface(ThaiFont);
		q3.setTypeface(ThaiFont);
		q4.setTypeface(ThaiFont);
		q5.setTypeface(ThaiFont);
		q6.setTypeface(ThaiFont);
		questionDetail.setTypeface(ThaiFont);
		cc.setTypeface(ThaiFont);
		help.setTypeface(ThaiFont);
		qname.setTextSize(20);
		q1.setTextSize(20);
		q2.setTextSize(20);
		q3.setTextSize(20);
		q4.setTextSize(20);
		q5.setTextSize(20);
		q6.setTextSize(20);
		questionDetail.setTextSize(20);
		qname.setText(kidname);

		questionDetail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent inte = new Intent(getApplicationContext(), Qdetail.class);
				inte.putExtra("id", id);
				inte.putExtra("no", no);
				inte.putExtra("kidname", kidname);
				startActivity(inte);
			}
		});

		q1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent7 = new Intent(getApplicationContext(),
						Question1.class);
				intent7.putExtra("id", id);
				intent7.putExtra("no", no);
				intent7.putExtra("kidname", kidname);
				startActivity(intent7);
			}

		});

		q2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent8 = new Intent(getApplicationContext(),
						Question2.class);
				intent8.putExtra("id", id);
				intent8.putExtra("no", no);
				intent8.putExtra("kidname", kidname);
				startActivity(intent8);
			}
		});

		q3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent9 = new Intent(getApplicationContext(),
						Question3.class);
				intent9.putExtra("id", id);
				intent9.putExtra("no", no);
				intent9.putExtra("kidname", kidname);
				startActivity(intent9);
			}
		});

		q4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent10 = new Intent(getApplicationContext(),
						Question4.class);
				intent10.putExtra("id", id);
				intent10.putExtra("no", no);
				intent10.putExtra("kidname", kidname);
				startActivity(intent10);
			}
		});

		q5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent12 = new Intent(getApplicationContext(),
						Question5.class);
				intent12.putExtra("id", id);
				intent12.putExtra("no", no);
				intent12.putExtra("kidname", kidname);
				startActivity(intent12);
			}
		});

		q6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent13 = new Intent(getApplicationContext(),
						Question6.class);
				intent13.putExtra("id", id);
				intent13.putExtra("no", no);
				intent13.putExtra("kidname", kidname);
				startActivity(intent13);
			}
		});

		cc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent14 = new Intent(getApplicationContext(),
						Conclude.class);
				intent14.putExtra("id", id);
				intent14.putExtra("no", no);
				intent14.putExtra("kidname", kidname);
				startActivity(intent14);
			}
		});

		help.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent16 = new Intent(getApplicationContext(),
						Help.class);
				intent16.putExtra("id", id);
				intent16.putExtra("no", no);
				intent16.putExtra("kidname", kidname);
				startActivity(intent16);
			}
		});

	}

}
