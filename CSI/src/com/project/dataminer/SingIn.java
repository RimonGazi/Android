package com.project.dataminer;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class SingIn extends SherlockActivity implements OnClickListener {

	private EditText userName, password;
	private Button btnLogin, btnSync, show_user_name;
	private LinearLayout layout;
	private TextView title;
	private UserDbAdapter db;
	private boolean loginStaus = false;
	final String urllogin = "http://printfood.com/csi/loginUser.php";
	private String inputUserName, inputUserPassword;
	public static String nameOfUser = "";
	Typeface thaiFont;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		thaiFont = Typeface.createFromAsset(getAssets(), "font/CORDIA.TTF");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sing_in);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowCustomEnabled(true);

		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionber_icon));
		layout = (LinearLayout) findViewById(R.id.linearLayout_sing_in);
		btnSync = (Button) findViewById(R.id.sync_info_update);
		layout.removeView(btnSync);
		show_user_name = (Button) findViewById(R.id.nameOfUser);
		show_user_name.setClickable(false);
		show_user_name.setTypeface(thaiFont);
		layout.removeView(show_user_name);
		userName = (EditText) findViewById(R.id.sing_in_username);
		userName.setTypeface(thaiFont);
		password = (EditText) findViewById(R.id.sing_in_password);
		password.setTypeface(thaiFont);
		btnLogin = (Button) findViewById(R.id.sing_in_login);
		title = (TextView) findViewById(R.id.singin_title);
		title.setTypeface(thaiFont);
		title.setIncludeFontPadding(false);

		btnLogin.setOnClickListener(this);
		btnSync.setOnClickListener(this);
		btnSync.setTypeface(thaiFont);
		btnLogin.setTypeface(thaiFont);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home)
			nameOfUser = "";
		if (db != null)
			db.close();
		finish();

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sing_in_login:
			inputUserName = (userName.getText().toString()).trim();
			inputUserPassword = password.getText().toString();
			nameOfUser = inputUserName;
			userName.setText("");
			password.setText("");
			if ((inputUserName.equals("")) || (inputUserPassword.equals(""))) {
				DialogShow("invalid input!");

			} else {

				new LoginConfirm().execute("");
			}

			break;

		case R.id.sync_info_update:
			new SyncInofrmation(SingIn.this).execute("");
			break;

		}
	}

	class LoginConfirm extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			pDialog = null;
			pDialog = new ProgressDialog(SingIn.this);
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("wait\n .....");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			ArrayList<NameValuePair> listParams = new ArrayList<NameValuePair>();
			listParams.add(new BasicNameValuePair("userName", inputUserName));
			String response = "";
			try {
				response = CustomHttpClient.executeHttpPost(urllogin,
						listParams);
				JSONObject jsonObject = new JSONObject(response);
				String userNameJson = (jsonObject.getString("username")).trim();
				loginStaus = isPasswordCorrect(
						(jsonObject.getString("password")).trim(),
						inputUserPassword);
				Log.d("JJJJJJJJJJJJJJJJJ", userNameJson + "    "
						+ jsonObject.getString("password").trim());
			} catch (Exception e) {

				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			pDialog.setProgress(Integer.parseInt(values[0]));
		}

		@SuppressWarnings("deprecation")
		@Override
		protected void onPostExecute(String result) {
			if ((pDialog != null) && (pDialog.isShowing())) {
				pDialog.dismiss();
			}
			if (loginStaus) {
				if (userName.getParent() != null)
					layout.removeView(userName);
				if (password.getParent() != null)
					layout.removeView(password);
				if (btnLogin.getParent() != null)
					layout.removeView(btnLogin);

				title.setText("");

				if (show_user_name.getParent() == null)
					layout.addView(show_user_name);
				show_user_name.setText(nameOfUser);
				if (userName.getParent() == null)
					layout.addView(btnSync);

				SpannableStringBuilder ssb = new SpannableStringBuilder(
						" ประสาน");
				Bitmap smiley = BitmapFactory.decodeResource(getResources(),
						R.drawable.simage);
				ssb.setSpan(new ImageSpan(smiley), 0, 1,
						Spannable.SPAN_INCLUSIVE_INCLUSIVE);
				title.setTypeface(thaiFont);
				title.setIncludeFontPadding(false);
				title.setText(ssb, BufferType.SPANNABLE);

			} else {
				DialogShow("ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง\nป้อนชื่อผู้ใช้และรหัสผ่านที่ถูกต้องและลองอีกครั้ง");
			}
			loginStaus = false;
			super.onPostExecute(result);

		}

	}

	@Override
	protected void onDestroy() {

		if (db != null)
			db.close();
		nameOfUser = "";
		super.onDestroy();
	}

	private void DialogShow(String mgs) {
		AlertDialog.Builder builder = new AlertDialog.Builder(SingIn.this);
		builder.setTitle("ข้อมูล");
		builder.setMessage(mgs);
		builder.setPositiveButton("ตกลง",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
		builder.setIcon(android.R.drawable.ic_dialog_alert);
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}

	private static boolean isPasswordCorrect(String correctPassword,
			String userEnterPassword) {
		boolean isCorrect = true;
		char[] cPassword = correctPassword.toCharArray();
		char[] uPassword = userEnterPassword.toCharArray();

		if (uPassword.length != cPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(uPassword, cPassword);
		}
		Arrays.fill(cPassword, '0');
		return isCorrect;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (db != null)
				db.close();
			nameOfUser = "";
			//Toast.makeText(SingIn.this, "back", Toast.LENGTH_LONG).show();
			finish();

			if (keyCode == KeyEvent.KEYCODE_HOME) {
				if (db != null)
					db.close();
				nameOfUser = "";
			//	Toast.makeText(SingIn.this, "home", Toast.LENGTH_LONG).show();
				finish();
			}
		}
		return false;
	}

}
