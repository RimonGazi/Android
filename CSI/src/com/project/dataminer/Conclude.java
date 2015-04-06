package com.project.dataminer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Conclude extends Activity {

	TextView q1c, q2c, q3c, q4c, q5c, q6c, qname;
	ImageView imageq1;
	ImageView imageq2;
	ImageView imageq3;
	ImageView imageq4;
	ImageView imageq5;
	ImageView imageq6;
	DataDbAdapter ddb;
	UserDbAdapter udb;
	Button data;
	Button save;
	String id;
	String no;
	String kidname;
	String ans11;
	String ans12;
	String ans13;
	String ans21;
	String ans22;
	String ans23;
	String ans24;
	String ans25;
	String ans26;
	String ans31;
	String ans32;
	String ans33;
	String ans34;
	String ans35;
	String ans41;
	String ans42;
	String ans43;
	String ans51;
	String ans52;
	String ans53;
	String ans54;
	String ans61;
	String ans62;
	String saved;
	AlertDialog confirm;
	String qh11, qh12, qh13, qh14, qh21, qh22, qh23, qh24, qh25, qh26, qh31,
			qh32, qh33, qh41, qh42, qh43, qh51, qh52, qh61, qh62;
	TextView h11, h12, h13, h14, h21, h22, h23, h24, h25, h26, h31, h32, h33,
			h41, h42, h43, h51, h52, h61, h62;
	TextView ca11, ca12, ca13, ca21, ca22, ca23, ca24, ca25, ca26, ca31, ca32,
			ca33, ca34, ca35, ca41, ca42, ca43, ca51, ca52, ca53, ca54, ca61,
			ca62;
	TextView qcare, qcareage, job, qcarerelate, qcarelong, qwith, qwithd,
			qwiths, qevent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conclude);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
			no = extras.getString("no");
			kidname = extras.getString("kidname");
		}

		ddb = new DataDbAdapter(this);
		udb = new UserDbAdapter(this);

		imageq1 = (ImageView) findViewById(R.id.imageq1);
		imageq2 = (ImageView) findViewById(R.id.imageq2);
		imageq3 = (ImageView) findViewById(R.id.imageq3);
		imageq4 = (ImageView) findViewById(R.id.imageq4);
		imageq5 = (ImageView) findViewById(R.id.imageq5);
		imageq6 = (ImageView) findViewById(R.id.imageq6);
		data = (Button) findViewById(R.id.data);
		save = (Button) findViewById(R.id.save);
		qname = (TextView) findViewById(R.id.qname);
		q1c = (TextView) findViewById(R.id.q1c);
		q2c = (TextView) findViewById(R.id.q2c);
		q3c = (TextView) findViewById(R.id.q3c);
		q4c = (TextView) findViewById(R.id.q4c);
		q5c = (TextView) findViewById(R.id.q5c);
		q6c = (TextView) findViewById(R.id.q6c);
		ca11 = (TextView) findViewById(R.id.ca11);
		ca12 = (TextView) findViewById(R.id.ca12);
		ca13 = (TextView) findViewById(R.id.ca13);
		ca21 = (TextView) findViewById(R.id.ca21);
		ca22 = (TextView) findViewById(R.id.ca22);
		ca23 = (TextView) findViewById(R.id.ca23);
		ca24 = (TextView) findViewById(R.id.ca24);
		ca25 = (TextView) findViewById(R.id.ca25);
		ca26 = (TextView) findViewById(R.id.ca26);
		ca31 = (TextView) findViewById(R.id.ca31);
		ca32 = (TextView) findViewById(R.id.ca32);
		ca33 = (TextView) findViewById(R.id.ca33);
		ca34 = (TextView) findViewById(R.id.ca34);
		ca35 = (TextView) findViewById(R.id.ca35);
		ca41 = (TextView) findViewById(R.id.ca41);
		ca42 = (TextView) findViewById(R.id.ca42);
		ca43 = (TextView) findViewById(R.id.ca43);
		ca51 = (TextView) findViewById(R.id.ca51);
		ca52 = (TextView) findViewById(R.id.ca52);
		ca53 = (TextView) findViewById(R.id.ca53);
		ca54 = (TextView) findViewById(R.id.ca54);
		ca61 = (TextView) findViewById(R.id.ca61);
		ca62 = (TextView) findViewById(R.id.ca62);
		h11 = (TextView) findViewById(R.id.h11);
		h12 = (TextView) findViewById(R.id.h12);
		h13 = (TextView) findViewById(R.id.h13);
		h14 = (TextView) findViewById(R.id.h14);
		h21 = (TextView) findViewById(R.id.h21);
		h22 = (TextView) findViewById(R.id.h22);
		h23 = (TextView) findViewById(R.id.h23);
		h24 = (TextView) findViewById(R.id.h24);
		h25 = (TextView) findViewById(R.id.h25);
		h26 = (TextView) findViewById(R.id.h26);
		h31 = (TextView) findViewById(R.id.h31);
		h32 = (TextView) findViewById(R.id.h32);
		h33 = (TextView) findViewById(R.id.h33);
		h41 = (TextView) findViewById(R.id.h41);
		h42 = (TextView) findViewById(R.id.h42);
		h43 = (TextView) findViewById(R.id.h43);
		h51 = (TextView) findViewById(R.id.h51);
		h52 = (TextView) findViewById(R.id.h52);
		h61 = (TextView) findViewById(R.id.h61);
		h62 = (TextView) findViewById(R.id.h62);
		qcare = (TextView) findViewById(R.id.qcare);
		qcareage = (TextView) findViewById(R.id.qcareage);
		job = (TextView) findViewById(R.id.job);

	//	qcarerelate = (TextView) findViewById(R.id.qcarerelate);
		qcarelong = (TextView) findViewById(R.id.qcarelong);
		qwith = (TextView) findViewById(R.id.qwith);
		qwithd = (TextView) findViewById(R.id.qwithd);
		qwiths = (TextView) findViewById(R.id.qwiths);
		qevent = (TextView) findViewById(R.id.qevent);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		q1c.setTypeface(ThaiFont);
		q2c.setTypeface(ThaiFont);
		q3c.setTypeface(ThaiFont);
		q4c.setTypeface(ThaiFont);
		q5c.setTypeface(ThaiFont);
		q6c.setTypeface(ThaiFont);
		qname.setTypeface(ThaiFont);
		q1c.setTextSize(20);
		q2c.setTextSize(20);
		q3c.setTextSize(20);
		q4c.setTextSize(20);
		q5c.setTextSize(20);
		q6c.setTextSize(20);
		qname.setTextSize(20);
		qname.setText(kidname);

		data.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						QuestionAll.class);
				intent.putExtra("id", id);
				intent.putExtra("no", no);
				intent.putExtra("kidname", kidname);
				startActivity(intent);
			}
		});

		confirm = new AlertDialog.Builder(this).create();
		confirm.setTitle("บันทึก");
		confirm.setMessage("กดแล้วจะไม่สามารถแก้ไขรายการได้อีก");
		confirm.setIcon(android.R.drawable.ic_dialog_alert);
		confirm.setButton2("ตกลง", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				ddb.open();
				udb.open();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Calendar c = Calendar.getInstance();
				ContentValues updateValues = new ContentValues();
				updateValues.put("saved", 1);
				updateValues.put("timeend", dateFormat.format(c.getTime()));
				ddb.update(updateValues, id, no);
				ContentValues ud = new ContentValues();
				ud.put("done", 1);
				udb.update(ud, id);
				Intent intent = new Intent(getApplicationContext(),
						com.project.dataminer.Menu.class);
				startActivity(intent);
				finish();
			}
		});
		confirm.setButton("ยกเลิก", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
			}
		});

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				confirm.show();
			}
		});

		ddb = new DataDbAdapter(this);
		ddb.open();
		Cursor c = ddb.getallfromidno(id, no);
		ans11 = c.getString(c.getColumnIndex("ans11"));
		ans12 = c.getString(c.getColumnIndex("ans12"));
		ans13 = c.getString(c.getColumnIndex("ans13"));
		ans21 = c.getString(c.getColumnIndex("ans21"));
		ans22 = c.getString(c.getColumnIndex("ans22"));
		ans23 = c.getString(c.getColumnIndex("ans23"));
		ans24 = c.getString(c.getColumnIndex("ans24"));
		ans25 = c.getString(c.getColumnIndex("ans25"));
		ans26 = c.getString(c.getColumnIndex("ans26"));
		ans31 = c.getString(c.getColumnIndex("ans31"));
		ans32 = c.getString(c.getColumnIndex("ans32"));
		ans33 = c.getString(c.getColumnIndex("ans33"));
		ans34 = c.getString(c.getColumnIndex("ans34"));
		ans35 = c.getString(c.getColumnIndex("ans35"));
		ans41 = c.getString(c.getColumnIndex("ans41"));
		ans42 = c.getString(c.getColumnIndex("ans42"));
		ans43 = c.getString(c.getColumnIndex("ans43"));
		ans51 = c.getString(c.getColumnIndex("ans51"));
		ans52 = c.getString(c.getColumnIndex("ans52"));
		ans53 = c.getString(c.getColumnIndex("ans53"));
		ans54 = c.getString(c.getColumnIndex("ans54"));
		ans61 = c.getString(c.getColumnIndex("ans61"));
		ans62 = c.getString(c.getColumnIndex("ans62"));
		saved = c.getString(c.getColumnIndex("saved"));
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

		String care = c.getString(c.getColumnIndex("care"));
		String careage = c.getString(c.getColumnIndex("careage"));
		String jobString = c.getString(c.getColumnIndex(MySQLiteHelper.JOB));
		String carerelate = c.getString(c.getColumnIndex("carerelate"));
		String with018 = c.getString(c.getColumnIndex("with018"));
		String with18up = c.getString(c.getColumnIndex("with18up"));
		String withd018 = c.getString(c.getColumnIndex("withd018"));
		String withd18up = c.getString(c.getColumnIndex("withd18up"));
		String withs018 = c.getString(c.getColumnIndex("withs018"));
		String withs18up = c.getString(c.getColumnIndex("withs18up"));
		String carelong = c.getString(c.getColumnIndex("carelong"));
		String event = c.getString(c.getColumnIndex("event"));

		qcare.setText("ชื่อผู้ดูแล : " + care);
		qcareage.setText("อายุผู้ดูแล  : " + careage);
		job.setText("อาชีพ : " + jobString);
		// drelatedadArrayList.add("");// order 0
		// drelatedadArrayList.add("พ่อ/แม่แท้ๆ");// order 1
		// drelatedadArrayList.add("พี่น้องพ่อแม่เดียวกัน");// order 2
		// drelatedadArrayList.add("ญาติแท้ๆ ของเด็ก");// order 3
		// drelatedadArrayList.add("พ่อ/แม่เลี้ยง หรือ พ่อ/แม่บุญธรรม");// order
		// 4
		// drelatedadArrayList.add("พี่น้องต่างพ่อ/แม่ ");// order 5
		// drelatedadArrayList.add("ญาติไม่แท้ เช่น ป้าสะใภ้ ");// order 6
		// drelatedadArrayList.add("คนอื่น ที่ไม่ใช่ญาติ เช่น เพื่อนบ้าน ");//
		// order 7
		String stringCarerelate = "";
		if (carerelate.equals("1")) {
			stringCarerelate = "พ่อ/แม่แท้ๆ";
		} else if (carerelate.equals("2")) {
			stringCarerelate = "พี่น้องพ่อแม่เดียวกัน";
		} else if (carerelate.equals("3")) {
			stringCarerelate = "ญาติแท้ๆ ของเด็ก";
		} else if (carerelate.equals("4")) {
			stringCarerelate = "พ่อ/แม่เลี้ยง หรือ พ่อ/แม่บุญธรรม";
		} else if (carerelate.equals("5")) {
			stringCarerelate = "พี่น้องต่างพ่อ/แม่ ";
		} else if (carerelate.equals("6")) {
			stringCarerelate = "ญาติไม่แท้ เช่น ป้าสะใภ้ ";
		} else if (carerelate.equals("7")) {
			stringCarerelate = "คนอื่น ที่ไม่ใช่ญาติ เช่น เพื่อนบ้าน";
		}
		//qcarerelate.setText("ความสัมพันธ์กับเด็ก : " + stringCarerelate);
		// carelong.add("");0
		// carelong.add("ตั้งแต่เกิด");1
		// carelong.add("ไม่ถึงปี");2
		// carelong.add("นานกว่า 1 ปี");3
		if (carelong.equals("1")) {
			qcarelong
					.setText("เด็กอาศัยอยู่กับครัวเรือนนี้มา  เด็กอาศัยอยู่กับครัวเรือนนี้มา ตั้งแต่เกิด");
		} else if (carelong.equals("2")) {
			qcarelong
					.setText("เด็กอาศัยอยู่กับครัวเรือนนี้มา เด็กอาศัยอยู่กับครัวเรือนนี้มา  ไม่ถึงปี");
		} else if (carelong.equals("3")) {
			qcarelong
					.setText("เด็กอาศัยอยู่กับครัวเรือนนี้มา เด็กอาศัยอยู่กับครัวเรือนนี้มา  นานกว่า 1 ปี");
		} else if (carelong.equals("0")) {
			qcarelong.setText("");
		} else {
			qcarelong.setText("");
		}
		qwith.setText("ในครัวเรือนเดียวกัน มีเด็ก (0-18 ปี) " + with018
				+ " คน ผู้ใหญ่" + with18up + " คน");
		qwithd.setText("ในครัวเรือนเดียวกัน มีเด็กพิการ (0-18 ปี) " + withd018
				+ " คน ผู้ใหญ่" + withd18up + " คน");
		qwiths.setText("ในครัวเรือนเดียวกัน มีเด็กเจ็บป่วย (0-18 ปี) "
				+ withs018 + " คน ผู้ใหญ่" + withs18up + " คน");

		// event.add("");0
		// event.add("ป่วยหนัก");1
		// event.add("เสียชีวิต");2
		// event.add("ย้ายที่อยู่");3
		// event.add("เปลี่ยนผู้ดูแล");4
		// event.add("ภัยพิบัติ");5
		// event.add("อืนๆ");6
		// event.add("ไม่มี");7
		if (event.equals("1")) {
			qevent.setText("\nเหตุการณ์สำคัญของครอบครัวในช่วง 6 เดือนที่ผ่านมา : ป่วยหนัก");
		} else if (event.equals("2")) {
			qevent.setText("\nเหตุการณ์สำคัญของครอบครัวในช่วง 6 เดือนที่ผ่านมา : เสียชีวิต");
		} else if (event.equals("3")) {
			qevent.setText("\nเหตุการณ์สำคัญของครอบครัวในช่วง 6 เดือนที่ผ่านมา : ย้ายที่อยู่");
		} else if (event.equals("4")) {
			qevent.setText("\nเหตุการณ์สำคัญของครอบครัวในช่วง 6 เดือนที่ผ่านมา : เปลี่ยนผู้ดูแล");
		} else if (event.equals("5")) {
			qevent.setText("\nเหตุการณ์สำคัญของครอบครัวในช่วง 6 เดือนที่ผ่านมา : ภัยพิบัติ");
		} else if (event.equals("6")) {
			qevent.setText("\nเหตุการณ์สำคัญของครอบครัวในช่วง 6 เดือนที่ผ่านมา : อืนๆ");
		} else if (event.equals("7")) {
			qevent.setText("\nเหตุการณ์สำคัญของครอบครัวในช่วง 6 เดือนที่ผ่านมา : ไม่มี");
		}
		if (saved.equals("1")) {
			data.setEnabled(false);
			save.setEnabled(false);
		}

		Log.d("database save ", saved + " save");
		if (ans11.equals("0") || ans12.equals("0") || ans13.equals("0")
				|| ans21.equals("0") || ans22.equals("0") || ans23.equals("0")
				|| ans24.equals("0") || ans25.equals("0") || ans26.equals("0")
				|| ans31.equals("0") || ans32.equals("0") || ans33.equals("0")
				|| ans34.equals("0") || ans35.equals("0") || ans41.equals("0")
				|| ans42.equals("0") || ans43.equals("0") || ans51.equals("0")
				|| ans52.equals("0") || ans53.equals("0") || ans54.equals("0")
				|| ans61.equals("0") || ans62.equals("0")) {
			save.setEnabled(false);
			Log.d("condition data ", saved + " save");
		}
		Log.d(" data ", " ans11 : " + ans11 + " ans12 :" + ans12 + " ans13 :"
				+ ans13 + " ans21 :" + ans21 + " ans22 :" + ans22 + "ans23 :"
				+ ans23 + "ans24 :" + ans24 + "ans25 :" + ans25 + "ans26 :"
				+ ans26 + " ans31 :" + ans31 + "ans32 :" + ans32 + "ans33 :"
				+ ans33 + "ans34 :" + ans34 + " ans35 :" + ans35 + "ans41 :"
				+ ans41 + " ans42 :" + ans42 + " ans43 :" + ans43 + " ans51 :"
				+ ans51 + "ans52 :" + ans52 + " ans53 :" + ans53 + " ans54 :"
				+ ans54 + " ans61:" + ans61 + "ans62 :" + ans62 + "  ali value");

		// question 5 image set

		Log.d("select ans ", "ANS 51" + ans51 + "ANS 52" + ans52 + "ANS 53"
				+ ans53 + "ANS 54" + ans54);

		if (ans51.equals("3") || ans52.equals("3") || ans53.equals("3")
				|| ans54.equals("3")) {
			imageq5.setImageResource(R.drawable.red);
		} else if (ans51.equals("2") || ans52.equals("2") || ans53.equals("2")) {
			imageq5.setImageResource(R.drawable.yellow);

		} else if (ans51.equals("1") && ans52.equals("1") && ans53.equals("1")
				&& ans54.equals("1")) {
			imageq5.setImageResource(R.drawable.green);

		}

		if (ans11.equals("1") || ans12.equals("1") || ans13.equals("1")) {
			imageq1.setImageResource(R.drawable.green);
		}
		if (ans11.equals("2") || ans12.equals("2") || ans13.equals("2")) {
			imageq1.setImageResource(R.drawable.yellow);
		}
		if (ans11.equals("3") || ans12.equals("3") || ans13.equals("3")) {
			imageq1.setImageResource(R.drawable.red);
		}

		if (ans21.equals("1") || ans22.equals("1") || ans23.equals("1")
				|| ans24.equals("1") || ans25.equals("1") || ans26.equals("1")) {
			imageq2.setImageResource(R.drawable.green);
		}
		if (ans21.equals("2") || ans22.equals("2") || ans22.equals("3")
				|| ans23.equals("2") || ans24.equals("2") || ans25.equals("2")
				|| ans26.equals("2")) {
			imageq2.setImageResource(R.drawable.yellow);
		}
		if (ans21.equals("3") || ans22.equals("4") || ans23.equals("3")
				|| ans24.equals("3") || ans25.equals("3") || ans26.equals("3")) {
			imageq2.setImageResource(R.drawable.red);
		}

		if (ans31.equals("1") || ans32.equals("1") || ans33.equals("1")
				|| ans34.equals("1") || ans35.equals("1")) {
			imageq3.setImageResource(R.drawable.green);
		}
		if (ans31.equals("2") || ans32.equals("2") || ans33.equals("2")
				|| ans34.equals("2") || ans35.equals("2")) {
			imageq3.setImageResource(R.drawable.yellow);
		}
		if (ans31.equals("3") || ans32.equals("3") || ans33.equals("3")
				|| ans34.equals("3") || ans35.equals("3")) {
			imageq3.setImageResource(R.drawable.red);
		}

		if (ans41.equals("1") || ans42.equals("1") || ans43.equals("1")) {
			imageq4.setImageResource(R.drawable.green);
		}
		if (ans41.equals("2") || ans42.equals("2") || ans43.equals("2")) {
			imageq4.setImageResource(R.drawable.yellow);
		}
		if (ans41.equals("3") || ans42.equals("3") || ans43.equals("3")) {
			imageq4.setImageResource(R.drawable.red);
		}

		// if the user select any answer that is red in any question then in
		// conclude page show red image
		//
		// if the user select any answer that is yellow in any question, but non
		// of red, then in conclude page show yellow

		// 6.1
		// 1 green
		// 2 yellow
		// 3 red
		// > 6.2 order 0 is blank
		// > order 1 is green
		// > order 2 is green
		// > order 3 is green
		// > order 4 is yellow
		// > order 5 is yellow
		// > order 6 is yellow
		// > order 7 is red
		// > order 8 is red
		if (ans61.equals("3") || ans62.equals("7") || ans62.equals("8")) {
			imageq6.setImageResource(R.drawable.red);
		} else if (ans61.equals("2") || ans62.equals("4") || ans62.equals("5")
				|| ans62.equals("6")) {
			imageq6.setImageResource(R.drawable.yellow);
		} else if ((ans61.equals("1"))
				&& (ans62.equals("1") || ans62.equals("2") || ans62.equals("3"))) {
			imageq6.setImageResource(R.drawable.green);
		}

		if (this.ans11.equals("1"))
			this.ca11.setText("มีให้กินอย่างเพียงพอ และไม่อด");
		if (this.ans11.equals("2"))
			this.ca11.setText("อดบ้างเป็นบางมื้อ ");
		if (this.ans11.equals("3"))
			this.ca11.setText("ต้องทนหิวเป็นประจำ (ไม่ค่อยมีกิน) ");
		// strq1a2.add("");
		// strq1a2.add("กินอาหารที่มีประโยชน์เสมอ");
		// strq1a2.add("กินอาหารที่มีประโยชน์บ้าง");
		// strq1a2.add("ไม่เคยมีอาหารที่มีประโยชน์กินเลย");

		if (this.ans12.equals("1"))
			this.ca12.setText("กินอาหารที่มีประโยชน์เสมอ");
		else if (this.ans12.equals("2"))
			this.ca12.setText("กินอาหารที่มีประโยชน์บ้าง");
		else if (this.ans12.equals("3"))
			this.ca12.setText("ไม่เคยมีอาหารที่มีประโยชน์กินเลย");
		if (this.ans13.equals("1"))
			this.ca13.setText("มีน้ำหนักส่วนสูงตามเกณฑ์มาตรฐาน");
		if (this.ans13.equals("2"))
			this.ca13.setText("มีน้ำหนักส่วนสูงน้อย/มากกว่าเกณฑ์นิดหน่อย");
		if (this.ans13.equals("3"))
			this.ca13.setText("อ้วนหรือผอมมากเกินไป");

		// strq2a1.add("");
		// strq2a1.add("สภาพบ้านมั่นคงแข็งแรง ปลอดภัย ");
		// strq2a1.add("สภาพบ้านต้องได้รับการซ่อมแซมบางส่วน");
		// strq2a1.add("สภาพบ้านทรุดโทรมมาก");

		if (this.ans21.equals("1"))
			this.ca21.setText("สภาพบ้านมั่นคงแข็งแรง ปลอดภัย");
		else if (this.ans21.equals("2"))
			this.ca21.setText("สภาพบ้านต้องได้รับการซ่อมแซมบางส่วน");
		else if (this.ans21.equals("3"))
			this.ca21.setText("สภาพบ้านทรุดโทรมมาก");

		// strq2a2.add("");
		// strq2a2.add("มีห้องเป็นสัดส่วน  ไม่แออัด");
		// strq2a2.add("ไม่มีห้องเป็นสัดส่วน แต่ไม่แออัด");
		// strq2a2.add("มีห้องเป็นสัดส่วน แต่แออัด");
		// strq2a2.add("ไม่มีห้องเป็นสัดส่วน และแออัด");
		if (this.ans22.equals("1"))
			this.ca22.setText("มีห้องเป็นสัดส่วน  ไม่แออัด");
		else if (this.ans22.equals("2"))
			this.ca22.setText("ไม่มีห้องเป็นสัดส่วน แต่ไม่แออัด");
		else if (this.ans22.equals("3"))
			this.ca22.setText("มีห้องเป็นสัดส่วน แต่แออัด");
		else if (this.ans22.equals("4"))
			this.ca22.setText("ไม่มีห้องเป็นสัดส่วน และแออัด");

		if (this.ans23.equals("1"))
			this.ca23.setText("สภาพแวดล้อมรอบบ้านมีความปลอดภัย");
		if (this.ans23.equals("2"))
			this.ca23.setText("สภาพแวดล้อมรอบบ้านไม่ค่อยปลอดภัย");
		if (this.ans23.equals("3"))
			this.ca23.setText("สภาพแวดล้อมรอบบ้านมีอันตรายสูง");
		if (this.ans24.equals("1"))
			this.ca24.setText("สะอาด ถูกสุขลักษณะ");
		if (this.ans24.equals("2"))
			this.ca24.setText("บ้านไม่ค่อยสะอาด ไม่ถูกสุขลักษณะ");
		if (this.ans24.equals("3"))
			this.ca24.setText("สภาพบ้านสกปรก รกรุงรังมาก");
		if (this.ans25.equals("1"))
			this.ca25.setText("ผู้ดูแลสามารถดูแลเด็กได้ดี");
		if (this.ans25.equals("2"))
			this.ca25.setText("ผู้ดูแลเด็กมีข้อจำกัดในการดูแลเด็ก");
		if (this.ans25.equals("3"))
			this.ca25.setText("ผู้ดูแลเด็กไม่สามารถดูแลเด็กได้อย่างเหมาะสมเลย");
		if (this.ans26.equals("1"))
			this.ca26.setText("คนในครอบครัวไม่มีพฤติกรรมที่อันตรายต่อเด็ก");
		if (this.ans26.equals("2"))
			this.ca26
					.setText("คนในครอบครัวมีพฤติกรรมที่ไม่เหมาะสม แต่ไม่อันตรายต่อเด็ก");
		if (this.ans26.equals("3"))
			this.ca26.setText("คนในครอบครัวมีพฤติกรรมที่อันตรายต่อเด็กมาก");
		if (this.ans31.equals("1"))
			this.ca31.setText("ปลอดภัยจากความรุนแรงทางเพศ ทางร่างกาย และจิตใจ");
		if (this.ans31.equals("2"))
			this.ca31
					.setText("มีความเสี่ยงต่อความรุนแรงทางเพศ ทางร่างกาย และจิตใจ");
		if (this.ans31.equals("3"))
			this.ca31
					.setText("ตกเป็นเหยื่อความรุนแรงทางเพศ ทางร่างกาย และจิตใจ");
		if (this.ans32.equals("1"))
			this.ca32.setText("เด็กไม่ถูกเลือกปฏิบัติหรือกีดกันทางสังคม");
		if (this.ans32.equals("2"))
			this.ca32.setText("เด็กอาจถูกเลือกปฏิบัติหรือกีดกันทางสังคม");
		if (this.ans32.equals("3"))
			this.ca32.setText("เด็กถูกเลือกปฏิบัติหรือกีดกันทางสังคม");
		if (this.ans33.equals("1"))
			this.ca33.setText("ไม่มีการใช้แรงงานเด็กเกินกำลัง ");
		if (this.ans33.equals("2"))
			this.ca33.setText("เด็กอาจถูกใช้แรงงานเกินกำลัง");
		if (this.ans33.equals("3"))
			this.ca33.setText("เด็กถูกใช้แรงงานเกินกำลัง");
		if (this.ans34.equals("1"))
			this.ca34.setText("มีสถานะทางกฎหมาย (มีบัตรประชาชน)");
		if (this.ans34.equals("2"))
			this.ca34.setText("กำลังอยู่ระหว่างดำเนินการขอสถานะทางกฎหมาย");
		if (this.ans34.equals("3"))
			this.ca34.setText("ไร้สถานะทางกฎหมาย");
		if (this.ans35.equals("1"))
			this.ca35.setText("เด็กไม่อยู่ในคดีความใดๆ");
		if (this.ans35.equals("2"))
			this.ca35.setText("เด็กเคยอยู่ในคดีความ แต่จบสิ้นไปแล้ว");
		if (this.ans35.equals("3"))
			this.ca35.setText("เด็กอยู่ระหว่างคดีความ รอลงอาญาหรือคุมประพฤติ");
		if (this.ans41.equals("1"))
			this.ca41.setText("ไม่เจ็บป่วยเลยในรอบ 1 เดือนที่ผ่านมา");
		if (this.ans41.equals("2"))
			this.ca41
					.setText("เจ็บป่วยบ้างเล็กน้อยแต่สามารถใช้ชีวิตได้ตามปกติ");
		if (this.ans41.equals("3"))
			this.ca41.setText("เจ็บป่วยบ่อยจนส่งผลต่อการใช้ชีวิตประจำวัน");

		if (this.ans42.equals("1"))
			this.ca42.setText("เด็กได้รับการดูแลสุขภาพเหมาะสม");
		if (this.ans42.equals("3"))
			this.ca42.setText("เด็กไม่ได้รับการดูแลสุขภาพอย่างเหมาะสมเลย");

		if (this.ans43.equals("1"))
			this.ca43.setText("เด็กมีสิทธิสวัสดิการด้านสุขภาพ");
		if (this.ans43.equals("3"))
			this.ca43.setText("เด็กไม่มีสิทธิสวัสดิการด้านสุขภาพ ");

		// set 5 question
		// "" value 0 no color origanl value 0
		// "อายุต่ำกว่า 3 ขวบ" value 5 no color origanl value 1
		// "เด็กไม่มีอาการซึมเศร้า หรือ/และเก็บกด" value 1 green color
		// origanl
		// value 2

		// "เด็กมีอาการซึมเศร้า และ/หรือเก็บกดมาก" value 3 red color origanl
		// value 3
		if (this.ans51.equals("1"))
			this.ca51.setText("เด็กไม่มีอาการซึมเศร้า หรือ/และเก็บกด");
		else if (this.ans51.equals("3"))
			this.ca51.setText("เด็กมีอาการซึมเศร้า และ/หรือเก็บกดมาก");
		else if (this.ans51.equals("5"))
			this.ca51.setText("อายุต่ำกว่า 3 ขวบ");

		// if (this.ans51.equals("1"))
		// this.ca51.setText("อายุต่ำกว่า 3 ขวบ");
		//
		// if (this.ans51.equals("2"))
		// this.ca51.setText("เด็กไม่มีอาการซึมเศร้า หรือ/และเก็บกด");
		//
		// if (this.ans51.equals("3"))
		// this.ca51.setText("เด็กไม่ร่าเริงสดใสบ้าง");
		//
		// if (this.ans51.equals("4"))
		// this.ca51.setText("เด็กมีอาการซึมเศร้า และ/หรือเก็บกดมาก");

		// 2

		// strq5a2.add(""); //value 0 no color ov 0
		// strq5a2.add("อายุต่ำกว่า 3 ขวบ");//value 4 no color ov 1
		// strq5a2.add("เด็กมีอารมณ์ปกติ ควบคุมอารมณ์ได้ดี");// value 1
		// green ov 2
		// strq5a2.add("เด็กงอแงบ่อย เอาแต่ใจ");// value 2 yello color ov 3
		// strq5a2.add("เด็กมีอารมณ์แปรปรวน ควบคุมอารมณ์ไม่ได้");// value 3
		// red color ov 4
		if (this.ans52.equals("1"))
			this.ca52.setText("เด็กมีอารมณ์ปกติ ควบคุมอารมณ์ได้ดี");
		else if (this.ans52.equals("2"))
			this.ca52.setText("เด็กงอแงบ่อย เอาแต่ใจ ");
		else if (this.ans52.equals("3"))
			this.ca52.setText("เด็กมีอารมณ์แปรปรวน ควบคุมอารมณ์ไม่ได้");
		else if (this.ans52.equals("4"))
			this.ca52.setText("อายุต่ำกว่า 3 ขวบ");

		// if (this.ans52.equals("1"))
		// this.ca52.setText("อายุต่ำกว่า 3 ขวบ");
		// if (this.ans52.equals("2"))
		// this.ca52.setText("เด็กมีอารมณ์ปกติ ควบคุมอารมณ์ได้ดี ");
		// if (this.ans52.equals("3"))
		// this.ca52.setText("เด็กงอแงบ่อย เอาแต่ใจ");
		// if (this.ans52.equals("4"))
		// this.ca52.setText("เด็กมีอารมณ์แปรปรวน ควบคุมอารมณ์ไม่ได้");
		// 3

		if (this.ans53.equals("1"))
			this.ca53.setText("เข้ากับเพื่อนได้ดี (ทั้งกลุ่มตนเอง และอื่นๆ)");
		else if (this.ans53.equals("2"))
			this.ca53
					.setText("อยู่กับกลุ่มเพื่อนของตัวเอง เข้ากับเพื่อนคนอื่นไม่ได้");
		else if (this.ans53.equals("3"))
			this.ca53
					.setText("เข้ากับเพื่อนไม่ได้ หรือไม่เล่นกับเพื่อน แยกตัว");
		else if (this.ans53.equals("4"))
			this.ca53.setText("อายุต่ำกว่า 3 ขวบ");

		// if (this.ans53.equals("1"))
		// this.ca53.setText("อายุต่ำกว่า 3 ขวบ");
		// if (this.ans53.equals("2"))
		// this.ca53.setText("เข้ากับเพื่อนได้ดี (ทั้งกลุ่มตนเอง และอื่นๆ)");
		// if (this.ans53.equals("3"))
		// this.ca53
		// .setText("อยู่กับกลุ่มเพื่อนของตัวเอง เข้ากับเพื่อนคนอื่นไม่ได้");
		// if (this.ans53.equals("4"))
		// this.ca53
		// .setText("เข้ากับเพื่อนไม่ได้ หรือไม่เล่นกับเพื่อน แยกตัว");
		// //4
		// if (this.ans54.equals("1"))
		// this.ca54.setText("ไม่มีปัญหาพฤติกรรมทางสังคม");
		// if (this.ans54.equals("3"))
		// this.ca54.setText("มีปัญหาพฤติกรรมทางสังคม");

		if (this.ans54.equals("1"))
			this.ca54.setText("ไม่มีปัญหาพฤติกรรมทางสังคม");
		else if (this.ans54.equals("3"))
			this.ca54.setText("มีปัญหาพฤติกรรมทางสังคม");
		else if (this.ans54.equals("4"))
			this.ca54.setText("อายุต่ำกว่า 3 ขวบ");

		if (this.ans61.equals("1"))
			this.ca61.setText("ไม่มีปัญหาด้านการเรียนรู้");
		if (this.ans61.equals("2"))
			this.ca61
					.setText("มีแนวโน้ม หรือข้อบ่งชี้ว่าเด็กอาจมีปัญหาด้านการเรียนรู้");
		if (this.ans61.equals("3"))
			this.ca61.setText("มีปัญหาด้านการเรียนรู้");

		// strq6a2.add("");0
		// strq6a2.add("อายุไม่ถึงเกณฑ์เข้าเรียน");1
		// strq6a2.add("ได้เรียนตามเกณฑ์อายุ และจบการศึกษาภาคบังคับตามเกณฑ์แล้ว ");2
		// strq6a2.add("กำลังเรียนตามเกณฑ์อายุ และมีแนวโน้มที่จะจบการศึกษาภาคบังคับ");3
		// strq6a2.add("ได้เรียนตามเกณฑ์อายุ แต่มีแนวโน้มว่าเด็กจะต้องออกจากโรงเรียนหรือเลิกเรียน");4
		// strq6a2.add("เรียนช้ากว่าเกณฑ์ แต่ยังเรียนอยู่ ");5
		// strq6a2.add("เรียนช้ากว่าเกณฑ์ และเรียนจบการศึกษาภาคบังคับเกณฑ์แล้ว");6
		// strq6a2.add("เด็กไม่ได้เข้าเรียนเลย แม้อายุจะถึงเกณฑ์");7
		// strq6a2.add("เด็กยังไม่จบการศึกษาภาคบังคับ");8

		if (this.ans62.equals("1"))
			this.ca62.setText("อายุไม่ถึงเกณฑ์เข้าเรียน");
		else if (this.ans62.equals("2"))
			this.ca62
					.setText("ได้เรียนตามเกณฑ์อายุ และจบการศึกษาภาคบังคับตามเกณฑ์แล้ว ");
		else if (this.ans62.equals("3"))
			this.ca62
					.setText("กำลังเรียนตามเกณฑ์อายุ และมีแนวโน้มที่จะจบการศึกษาภาคบังคับ");
		else if (this.ans62.equals("4"))
			this.ca62
					.setText("ได้เรียนตามเกณฑ์อายุ แต่มีแนวโน้มว่าเด็กจะต้องออกจากโรงเรียนหรือเลิกเรียน");
		else if (this.ans62.equals("5"))
			this.ca62.setText("เรียนช้ากว่าเกณฑ์ แต่ยังเรียนอยู่ ");
		else if (this.ans62.equals("6"))
			this.ca62
					.setText("เรียนช้ากว่าเกณฑ์ และเรียนจบการศึกษาภาคบังคับเกณฑ์แล้ว");
		else if (this.ans62.equals("7"))
			this.ca62.setText("เด็กไม่ได้เข้าเรียนเลย แม้อายุจะถึงเกณฑ์");
		else if (this.ans62.equals("8"))
			this.ca62.setText("เด็กยังไม่จบการศึกษาภาคบังคับ");

		// set the help page question 1

		if (this.qh11.equals("1"))
			this.h11.setText("เงินช่วยเหลือ");
		if (this.qh12.equals("1"))
			this.h12.setText("อาหาร/นมผงเด็ก");
		if (this.qh13.equals("1"))
			this.h13.setText("ให้คำแนะนำจากเจ้าหน้าที่สาธารณสุข");
		if (this.qh14.equals("1"))
			this.h14.setText("อื่นๆ");

		if (this.qh21.equals("1"))
			this.h21.setText("เงินช่วยเหลือ ");
		if (this.qh22.equals("1"))
			this.h22.setText("อุปกรณ์ซ่อมแซมที่อยู่อาศัย/เครื่องใช้");
		if (this.qh23.equals("1"))
			this.h23.setText("ส่งต่อ (แล้วแต่กรณี)");
		if (this.qh24.equals("1"))
			this.h24.setText("ให้คำปรึกษาแก่ผู้ดูแลในการเลี้ยงดูเด็ก");
		if (this.qh25.equals("1"))
			this.h25.setText("ส่งต่อ พมจ./ศพส. เพื่อจัดหาครอบครัวทดแทน");
		if (this.qh26.equals("1"))
			this.h26.setText("อื่นๆ เช่นติดตามญาติ");

		// q3
		if (this.qh31.equals("1"))
			this.h31.setText("แจ้งเหตุ OSCC หรือหน่วยงานที่เกี่ยวข้อง");
		if (this.qh32.equals("1"))
			this.h32.setText("แยกเด็กออกจากสถานการณ์ความรุนแรง");
		if (this.qh33.equals("1"))
			this.h33.setText("อื่นๆ เช่น ให้คำปรึกษาในการเลี้ยงดูเด็ก");

		// q4
		if (this.qh41.equals("1"))
			this.h41.setText("เงินช่วยเหลือ");
		if (this.qh42.equals("1"))
			this.h42.setText("ประสานงานกับหน่วยงานที่เกี่ยวข้องเพื่อให้ได้รับสิทธิเรื่องสุขภาพ");
		if (this.qh43.equals("1"))
			this.h43.setText("อื่นๆ เช่น ขอคำแนะนำจากสาธารณสุข");

		// q5

		if (this.qh51.equals("1"))
			this.h51.setText("ขอคำแนะนำจากเจ้าหน้าที่สาธารณสุข");
		if (this.qh52.equals("1"))
			this.h52.setText("อื่นๆ");

		if (this.qh61.equals("1"))
			this.h61.setText("ขอคำแนะนำจากโรงเรียน/ฝ่ายการศึกษา/สาธารณสุข");
		if (this.qh62.equals("1"))
			this.h62.setText("อื่นๆ เช่น ประสานงานกับหน่วยงานอื่นๆ");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.conclude, menu);
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
