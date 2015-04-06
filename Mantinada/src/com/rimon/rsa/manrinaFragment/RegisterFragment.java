package com.rimon.rsa.manrinaFragment;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rimon.rsa.mantinada.R;

public class RegisterFragment extends Fragment implements TextWatcher,
		View.OnClickListener {
	private EditText etFirstame, etLastName, etChapter, etCategory, etEmail,
			etMantinada;
	private Button btnSubmit;
	private String firstName, lastName, chapter, category, email, mantinada;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	private LayoutInflater inf;
	private View view;
	private RegisterData registerData;
	private static final String POST_URL = "http://10.0.2.2/online_library/addData.php";

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Toast.makeText(getActivity(),"on create view" , Toast.LENGTH_SHORT).show();
		inf = inflater;
		view = inflater.inflate(R.layout.register, container, false);
		preferences = this.getActivity().getSharedPreferences("pref", 0);
		editor = preferences.edit();
		// intialized edit text with xaml
		intializedEditText();
		// intialize text field with share preference
		getSharePref();
		btnSubmit = (Button) view.findViewById(R.id.button1);
		// check share prefirenc is empty and edit Text is empty
		if (!isTextFildNull()) {
			btnSubmit.setEnabled(false);
		}
		btnSubmit.setOnClickListener(this);
		etFirstame.addTextChangedListener(this);
		etLastName.addTextChangedListener(this);
		etChapter.addTextChangedListener(this);
		etCategory.addTextChangedListener(this);
		etEmail.addTextChangedListener(this);
		etMantinada.addTextChangedListener(this);
		return view;
	}

	@Override
	public void afterTextChanged(Editable s) {
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		setSharePref();
		if (isTextFildNull()) {
			btnSubmit.setEnabled(true);
		} else {
			if (!btnSubmit.isActivated()) {
				btnSubmit.setEnabled(false);
			}
		}

	}

	private void intializedEditText() {
		etFirstame = (EditText) view.findViewById(R.id.editText1);
		etLastName = (EditText) view.findViewById(R.id.editText2);
		etChapter = (EditText) view.findViewById(R.id.editText3);
		etCategory = (EditText) view.findViewById(R.id.editText4);
		etEmail = (EditText) view.findViewById(R.id.editText5);
		etMantinada = (EditText) view.findViewById(R.id.editText6);
	}

	private void setEditTextNull() {
		etFirstame.setText("");
		etLastName.setText("");
		etChapter.setText("");
		etCategory.setText("");
		etEmail.setText("");
		etMantinada.setText("");

	}

	private void getSharePref() {
		etFirstame.setText(preferences.getString("firstName", ""));
		etLastName.setText(preferences.getString("lastName", ""));
		etChapter.setText(preferences.getString("chapter", ""));
		etCategory.setText(preferences.getString("category", ""));
		etEmail.setText(preferences.getString("email", ""));
		etMantinada.setText(preferences.getString("mantinada", ""));

	}

	private void setSharePref() {
		editor.putString("firstName", firstName);
		editor.putString("lastName", lastName);
		editor.putString("chapter", chapter);
		editor.putString("category", category);
		editor.putString("email", email);
		editor.putString("mantinada", mantinada);
		editor.commit();
	}

	private boolean isTextFildNull() {
		firstName = etFirstame.getText().toString();
		lastName = etLastName.getText().toString();
		chapter = etChapter.getText().toString();
		category = etCategory.getText().toString();
		email = etEmail.getText().toString();
		mantinada = etMantinada.getText().toString();

		if ((firstName.equals("")) || (lastName.equals(""))
				|| (chapter.equals("")) || (category.equals(""))
				|| (email.equalsIgnoreCase("")) || (mantinada.equals("")))

			return false;
		else
			return true;
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.button1) {

			if (isNetworkAvailable()) {
				registerData = new RegisterData(firstName, lastName, chapter,
						category, email, mantinada);
				View ScrollView = inf.inflate(R.layout.dialog, null, false);
				final TextView tv = (TextView) ScrollView
						.findViewById(R.id.dialogTv);
				tv.setText("");
				tv.append("  Are you went to sent below mantinada ? \n\n");
				tv.append("  " + firstName + "\n\n");
				tv.append("  " + lastName + "\n\n");
				tv.append("  " + chapter + "\n\n");
				tv.append("  " + category + "\n\n");
				tv.append("  " + email + "\n\n");
				@SuppressWarnings("unused")
				int index = 0;
				int check = 0;
				String submantinada = "  ";
				String submitMantinada = "";
				if (mantinada.contains("\n")) {
					for (int i = 0; i < mantinada.length(); i++) {
						char c = mantinada.charAt(i);

						if (c == '\n') {
							if ((i == 0) || (i == (mantinada.length() - 1)))
								continue;
							if (check == 0) {
								submantinada += c + "  ";
								submitMantinada += c;
							}
							check++;
						} else {
							submantinada += c;
							submitMantinada += c;
							check = 0;
						}

					}

				} else {
					submantinada = "  " + mantinada;
				}
				if (!submitMantinada.equals("")) {
					mantinada = submitMantinada;
				}
				tv.append(submantinada + "\n");

				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setView(ScrollView);
				builder.setCancelable(false);
				builder.setTitle("Confirmation");
				builder.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								setEditTextNull();
								setSharePref();
								new SendData().execute(" ");
							}
						});
				builder.setNegativeButton("No",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								tv.setText("");
							}
						});
				builder.setNeutralButton("Cancel",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								tv.setText("");
							}
						});
				builder.setIcon(android.R.drawable.ic_dialog_info);

				AlertDialog alertDialog = builder.create();
				// show it
				alertDialog.show();
			} else {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("Info");
				builder.setMessage("Internet not available, Check your internet connectivity and try again");
				// abuilder.setIcon(android.R.drawable.ic_dialog_alert);
				builder.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

							}
						});
				builder.setIcon(android.R.drawable.ic_dialog_alert);

				AlertDialog alertDialog = builder.create();
				// show it
				alertDialog.show();

			}
		}
	}

	class SendData extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;
		private int success = 12;

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("Wait\nSome slow job is being done...");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {

			ArrayList<NameValuePair> listParams = new ArrayList<NameValuePair>();
			listParams.add(new BasicNameValuePair("firstName", registerData
					.getFirstName()));
			listParams.add(new BasicNameValuePair("lastName", registerData
					.getLastName()));
			listParams.add(new BasicNameValuePair("chapter", registerData
					.getChapter()));
			listParams.add(new BasicNameValuePair("category", registerData
					.getCategory()));
			listParams.add(new BasicNameValuePair("email", registerData
					.getEmail()));
			listParams.add(new BasicNameValuePair("mantinada", registerData
					.getMantinada().toString()));

			String response = null;

			try {
				response = CustomHttpClient.executeHttpPost(POST_URL,
						listParams);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.d("AAAAAAAAAAAAAAAAAAAAAAA", response.toString());
			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				success = jsonObject.getInt("success");
				Log.d("bbbbbbbbbbbb", success + " ");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			pDialog.setProgress(Integer.parseInt(values[0]));
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if (pDialog.isShowing()) {
				pDialog.dismiss();
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle("Confirmation");
			if (success == 1) {
				builder.setMessage("Data sent.");
			} else
				builder.setMessage("Data not sent.");

			success = 12;
			builder.setCancelable(false);
			builder.setNeutralButton("OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			builder.setIcon(android.R.drawable.ic_dialog_info);

			AlertDialog alertDialog = builder.create();
			// show it
			alertDialog.show();
		}

	}

	private boolean isNetworkAvailable() {
		ConnectivityManager cManager = (ConnectivityManager) getActivity()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cManager.getActiveNetworkInfo();
		if (netInfo != null) {
			if (netInfo.isAvailable() && netInfo.isConnected()) {
				return true;
			}
		}
		return false;
	}
}
