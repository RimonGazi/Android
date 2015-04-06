package com.project.dataminer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	private TextView title;
	private Button submit;
	private EditText id, pwd;
	String sid, spwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionber_icon));

		title = (TextView) findViewById(R.id.login_title);
		id = (EditText) findViewById(R.id.editText1);
		pwd = (EditText) findViewById(R.id.editText2);
		submit = (Button) findViewById(R.id.save);

		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		title.setTypeface(ThaiFont);
		id.setTypeface(ThaiFont);
		// id.setTextSize(30);
		pwd.setTypeface(ThaiFont);
		// pwd.setTextSize(30);
		submit.setTypeface(ThaiFont);

		submit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				sid = id.getText().toString();
				spwd = pwd.getText().toString();
				if (sid.equals("pact") && spwd.equals("pact")) {
					Intent intent = new Intent(getApplicationContext(),
							com.project.dataminer.Menu.class);
					startActivity(intent);
					intent = null;
					finish();
				} else {

					Toast.makeText(getApplicationContext(),
							"ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		return super.onOptionsItemSelected(item);
	}

}
