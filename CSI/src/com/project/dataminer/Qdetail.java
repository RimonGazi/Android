package com.project.dataminer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Qdetail extends Activity {

	EditText dcare, dcareage, dwith018, dwith18up, et_job, et_id;
	EditText dwithd018, dwithd18up, dwiths018, dwiths18up;
	Spinner dcarelong, devent, dcarerelate;
	TextView nameAge;
	Button detsave;
	DataDbAdapter ddb;
	String id;
	String no;
	String kidname;
	String Stringdcarerelate;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	Typeface thaiFont;

	protected void onCreate(Bundle paramBundle) {

		super.onCreate(paramBundle);
		setContentView(R.layout.activity_qdetail);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}

		ddb = new DataDbAdapter(this);
		ddb.open();
		thaiFont = Typeface.createFromAsset(getAssets(), "font/CORDIA.TTF");

		et_job = (EditText) findViewById(R.id.et_Qdetail_job);
		et_id = (EditText) findViewById(R.id.et_Qdetail_id);
		dcare = (EditText) findViewById(R.id.dcare);
		dcareage = (EditText) findViewById(R.id.dcareage);
		dwith018 = (EditText) findViewById(R.id.dwith018);
		dwith18up = (EditText) findViewById(R.id.dwith18up);
		dwithd018 = (EditText) findViewById(R.id.dwithd018);
		dwithd18up = (EditText) findViewById(R.id.dwithd18up);
		dwiths018 = (EditText) findViewById(R.id.dwiths018);
		dwiths18up = (EditText) findViewById(R.id.dwiths18up);
		nameAge = (TextView) findViewById(R.id.id_nameandage);
		nameAge.setTypeface(thaiFont);
		nameAge.setText(CsiConstant.child_name + " " + CsiConstant.child_age);

		// dcarelong Spinner
		dcarelong = (Spinner) findViewById(R.id.dcarelong);
		ArrayList<String> carelong = new ArrayList<String>();
		carelong.add("");
		carelong.add("ตั้งแต่เกิด");
		carelong.add("ไม่ถึงปี");
		carelong.add("นานกว่า 1 ปี");
		// 1=ตั้งแต่เกิด
		// 2=ไม่ถึงปี
		// 3=มากกว่า 1 ปี
		ArrayAdapter<String> q6a1Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, carelong);
		q6a1Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dcarelong.setAdapter(q6a1Adapter);
		// devent Spinner
		devent = (Spinner) findViewById(R.id.devent);
		ArrayList<String> event = new ArrayList<String>();

		event.add("");
		event.add("ป่วยหนัก");
		event.add("เสียชีวิต");
		event.add("ย้ายที่อยู่");
		event.add("เปลี่ยนผู้ดูแล");
		event.add("ภัยพิบัติ");
		event.add("อืนๆ");
		event.add("ไม่มี");
		// event.add("ผู้ดูแล/พ่อแม่ป่วยหนัก");
		// event.add("ผู้ดูแล/พ่อแม่เสียชีวิต");
		// event.add("ย้ายที่อยู่");
		// event.add("เด็กเปลี่ยนผู้ดูแล");
		// event.add("ภัยพิบัติ");
		// event.add("อื่นๆ ");
		// event.add("ไม่มี");

		// 1= ป่วยหนัก
		// 2= เสียชีวิต
		// 3= ย้ายที่อยู่
		// 4= เปลี่ยนผู้ดูแล
		// 5=ภัยพิบัติ
		// 6=อืนๆ
		// 7=ไม่มี
		ArrayAdapter<String> q6a2Adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, event);
		q6a2Adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		devent.setAdapter(q6a2Adapter);

		// - พ่อ/แม่แท้ๆ = order1 
		// - พี่น้องพ่อแม่เดียวกัน =order2 
		// - ญาติแท้ๆ ของเด็ก = order 3 -
		// พ่อ/แม่เลี้ยง หรือ พ่อ/แม่บุญธรรม = order 4 -
		// พี่น้องต่างพ่อ/แม่ = order5 -
		// ญาติไม่แท้ เช่น ป้าสะใภ้ = order6 -
		// คนอื่น ที่ไม่ใช่ญาติ เช่น เพื่อนบ้าน = order7

		// dcarerelate Spinner
		ArrayList<String> drelatedadArrayList = new ArrayList<String>();
		drelatedadArrayList.add("");// order 0
		drelatedadArrayList.add("พ่อ/แม่แท้ๆ");// order 1
		drelatedadArrayList.add("พี่น้องพ่อแม่เดียวกัน");// order 2
		drelatedadArrayList.add("ญาติแท้ๆ ของเด็ก");// order 3
		drelatedadArrayList.add("พ่อ/แม่เลี้ยง หรือ พ่อ/แม่บุญธรรม");// order 4
		drelatedadArrayList.add("พี่น้องต่างพ่อ/แม่ ");// order 5
		drelatedadArrayList.add("ญาติไม่แท้ เช่น ป้าสะใภ้ ");// order 6
		drelatedadArrayList.add("คนอื่น ที่ไม่ใช่ญาติ เช่น เพื่อนบ้าน ");// order  7

	
		dcarerelate = (Spinner) findViewById(R.id.dcarerelate);
		ArrayAdapter<String> dcareRelatedAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, drelatedadArrayList);
		dcareRelatedAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		dcarerelate.setAdapter(dcareRelatedAdapter);

		detsave = (Button) findViewById(R.id.detsave);
		detsave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.d("dcarerelate",
						String.valueOf(dcarerelate.getSelectedItemPosition()));
				Log.d("dcarelong",
						String.valueOf(dcarelong.getSelectedItemPosition()));

				Log.d("devent",
						String.valueOf(devent.getSelectedItemPosition()));
				if (dcare.getText().toString().equals("")
						|| dcareage.getText().toString().equals("")
						|| dwith018.getText().toString().equals("")
						|| dwith18up.getText().toString().equals("")
						|| dwithd018.getText().toString().equals("")
						|| dwithd18up.getText().toString().equals("")
						|| dwiths018.getText().toString().equals("")
						|| dwiths18up.getText().toString().equals("")
						|| et_job.getText().toString().equals("")
						|| (et_id.getText().toString().length() != 13)) {
					Toast.makeText(getApplicationContext(),
							"ต้องกรอกข้อมูลให้ครบ", Toast.LENGTH_SHORT).show();
				} else {

					ContentValues updateValues = new ContentValues();
					updateValues.put("care", dcare.getText().toString());
					updateValues.put("careage", dcareage.getText().toString());
					updateValues.put("carerelate", String.valueOf(dcarerelate
							.getSelectedItemPosition()));
					updateValues.put("carelong",
							String.valueOf(dcarelong.getSelectedItemPosition()));
					updateValues.put("with018", dwith018.getText().toString());
					updateValues
							.put("with18up", dwith18up.getText().toString());
					updateValues
							.put("withd018", dwithd018.getText().toString());
					updateValues.put("withd18up", dwithd18up.getText()
							.toString());
					updateValues
							.put("withs018", dwiths018.getText().toString());
					updateValues.put("withs18up", dwiths18up.getText()
							.toString());
					updateValues.put("event",
							String.valueOf(devent.getSelectedItemPosition()));
					updateValues.put(MySQLiteHelper.JOB, et_job.getText()
							.toString());
					updateValues.put(MySQLiteHelper.ID_DATA_EXTEA, et_id
							.getText().toString());
					ddb.update(updateValues, id, no);
					Intent intent = new Intent(getApplicationContext(),
							QuestionAll.class);
					intent.putExtra("id", id);
					intent.putExtra("no", no);
					intent.putExtra("kidname", kidname);
					startActivity(intent);
				}

			}
		});
		if (Followup.activityHintQdetail) {
			Cursor c = ddb.getallfromidno(id, no);
			String care = c.getString(c.getColumnIndex("care"));
			String careage = c.getString(c.getColumnIndex("careage"));
			String carerelate = c.getString(c.getColumnIndex("carerelate"));
			String with018 = c.getString(c.getColumnIndex("with018"));
			String with18up = c.getString(c.getColumnIndex("with18up"));
			String withd018 = c.getString(c.getColumnIndex("withd018"));
			String withd18up = c.getString(c.getColumnIndex("withd18up"));
			String withs018 = c.getString(c.getColumnIndex("withs018"));
			String withs18up = c.getString(c.getColumnIndex("withs18up"));
			String acarelong = c.getString(c.getColumnIndex("carelong"));
			String aevent = c.getString(c.getColumnIndex("event"));
			String jobs = c.getString(c.getColumnIndex(MySQLiteHelper.JOB));
			String ids = c.getString(c
					.getColumnIndex(MySQLiteHelper.ID_DATA_EXTEA));
			et_job.setText(jobs);
			et_id.setText(ids);
			dcare.setText(care);
			dcareage.setText(careage);
			dwith018.setText(with018);
			dwith18up.setText(with18up);
			dwithd018.setText(withd018);
			dwithd18up.setText(withd18up);
			dwiths018.setText(withs018);
			dwiths18up.setText(withs18up);
		} else {
			et_job.setText("");
			et_id.setText("");
			dcare.setText("");
			dcareage.setText("");
			dwith018.setText("");
			dwith18up.setText("");
			dwithd018.setText("");
			dwithd18up.setText("");
			dwiths018.setText("");
			dwiths18up.setText("");
			Followup.activityHintQdetail = true;
		}
	}
}