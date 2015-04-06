package com.project.dataminer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class Menu extends SherlockActivity {

	private Button addbutton;
	private Button sync;
	private TextView name;
	private UserDbAdapter db;
	DataDbAdapter ddb;
	SimpleCursorAdapter adapter;
	String[] columns;
	int[] display;
	ListView lv;
	Cursor c, c2;
	String id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionber_icon));
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		setContentView(R.layout.activity_menu);

		db = new UserDbAdapter(this);
		db.open();
		ddb = new DataDbAdapter(this);
		ddb.open();

		addbutton = (Button) findViewById(R.id.addbutton);
		name = (TextView) findViewById(R.id.name);
		lv = (ListView) findViewById(R.id.userlistview);
		sync = (Button) findViewById(R.id.sync);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		sync.setTypeface(ThaiFont);
		sync.setTextSize(20);
		addbutton.setTypeface(ThaiFont);
		addbutton.setTextSize(20);
		name.setTypeface(ThaiFont);
		name.setTextSize(20);

		columns = new String[] { "nname" };
		display = new int[] { R.id.showuser1 };

		addbutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(getApplicationContext(), Register.class);
				startActivity(i);
			}
		});

		c = db.fetchAll();
		adapter = new SimpleCursorAdapter(this, R.layout.show_user, c, columns,
				display) {
			@Override
			public void bindView(View view, Context context, Cursor cursor) {

				Typeface tf = Typeface.createFromAsset(context.getAssets(),
						"font/CORDIA.TTF");
				TextView tv = (TextView) view.findViewById(R.id.showuser2);
				TextView tv2 = (TextView) view.findViewById(R.id.showuser3);
				// TextView tv3 = (TextView)view.findViewById(R.id.showuser1);
				String s = cursor.getString(cursor.getColumnIndex("nname"));
				String s2 = cursor.getString(cursor.getColumnIndex("done"));
				// String s3 = cursor.getString(cursor.getColumnIndex("_id"));
				tv.setText(s);
				if (s2.equals("1")) {
					tv2.setText("         สมบูรณ์");
				} else if (s2.equals("2")) {
					tv2.setText("             ");
				} else {
					tv2.setText("       ไม่สมบูรณ์");
				}

				tv.setTypeface(tf);
				tv2.setTypeface(tf);

				tv.setTextSize(20);
				tv2.setTextSize(20);

			}

			@Override
			public View newView(Context context, Cursor cursor, ViewGroup parent) {
				LayoutInflater infl = LayoutInflater.from(context);
				View v = infl.inflate(R.layout.show_user, parent, false);
				bindView(v, context, cursor);
				return v;
			}

		};

		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent1 = new Intent(getApplicationContext(),
						UserMenu.class);
				intent1.putExtra("id", "" + arg3);

				startActivity(intent1);
				
			}

		});

		sync.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isNetworkAvailable()) {
					if (c.getCount() > 0) {
						startActivity(new Intent(Menu.this, SingIn.class));
					} else {
						DialogShow("Database id empty !");

					}

				} else {

					DialogShow("Internet not available, Check your internet connectivity and try again");
				}
			}
		});
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager cManager = (ConnectivityManager) Menu.this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cManager.getActiveNetworkInfo();
		if (netInfo != null) {
			if (netInfo.isAvailable() && netInfo.isConnected()) {
				return true;
			}
		}
		return false;
	}

	private void DialogShow(String mgs) {
		AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
		builder.setTitle("Info");
		builder.setMessage(mgs);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.setIcon(android.R.drawable.ic_dialog_alert);
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home)
			finish();
		return super.onOptionsItemSelected(item);
	}

}
