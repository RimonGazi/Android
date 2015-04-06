package com.rimon.rsa.juadmissiontest;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.rimon.mymap.R;
import com.rimon.mymap.StartActivity;

public class SearchFragment extends Fragment {
	private Spinner spinner;
	private Button btn_submit, btn_back, btn_seatPlan, btn_result;
	private LinearLayout linearLayout;
	private EditText et_roll;
	private Button tv_set_plan;
	private OnSwitchClickListener listener;
	String roll = "";
	String unit = "";
	RelativeLayout relativeLayout;

	@Override
	public void onAttach(Activity activity) {
		listener = (StartActivity) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.search, container, false);
		tv_set_plan = (Button) view.findViewById(R.id.tv_s_plan_tite);
		linearLayout = (LinearLayout) view
				.findViewById(R.id.layout_contain_componet);
		relativeLayout = (RelativeLayout) view.findViewById(R.id.relative_ll);
		btn_seatPlan = (Button) view.findViewById(R.id.btn_seatPlan);

		btn_back = (Button) view.findViewById(R.id.btn_back);
		btn_submit = (Button) view.findViewById(R.id.btn_submit);
		et_roll = (EditText) view.findViewById(R.id.et_roll);
		spinner = (Spinner) view.findViewById(R.id.sp_unite);
		initializedSpinner();
		InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et_roll, InputMethodManager.SHOW_FORCED);
		if (spinner.getParent() != null) {
			linearLayout.removeView(spinner);
		}
		if (et_roll.getParent() != null) {
			linearLayout.removeView(et_roll);
		}
		if (btn_submit.getParent() != null) {
			linearLayout.removeView(btn_submit);
		}
		if (btn_back.getParent() != null) {
			linearLayout.removeView(btn_back);
		}

		tv_set_plan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (spinner.getParent() == null) {
					linearLayout.addView(spinner);
				}
				if (et_roll.getParent() == null) {
					linearLayout.addView(et_roll);
				}
				if (btn_submit.getParent() == null) {
					linearLayout.addView(btn_submit);
				}
				if (btn_back.getParent() == null) {
					linearLayout.addView(btn_back);
				}
				if (tv_set_plan.getParent() != null) {
					relativeLayout.removeView(btn_seatPlan);
				}
				if (tv_set_plan.getParent() != null) {
					linearLayout.removeView(tv_set_plan);
				}

			}
		});
		btn_seatPlan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (spinner.getParent() == null) {
					linearLayout.addView(spinner);
				}
				if (et_roll.getParent() == null) {
					linearLayout.addView(et_roll);
				}
				if (btn_submit.getParent() == null) {
					linearLayout.addView(btn_submit);
				}
				if (btn_back.getParent() == null) {
					linearLayout.addView(btn_back);
				}
				if (tv_set_plan.getParent() != null) {
					relativeLayout.removeView(btn_seatPlan);
				}
				if (tv_set_plan.getParent() != null) {
					linearLayout.removeView(tv_set_plan);
				}

			}
		});

		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (spinner.getParent() != null) {
					linearLayout.removeView(spinner);
				}
				if (et_roll.getParent() != null) {
					linearLayout.removeView(et_roll);
				}
				if (btn_submit.getParent() != null) {
					linearLayout.removeView(btn_submit);
				}
				if (btn_back.getParent() != null) {
					linearLayout.removeView(btn_back);
				}
				if (btn_seatPlan.getParent() == null) {
					relativeLayout.addView(btn_seatPlan);
				}

				if (tv_set_plan.getParent() == null) {
					linearLayout.addView(tv_set_plan);
				}

			}
		});
		btn_submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isNetworkAvailable()) {
					roll = et_roll.getText().toString();
					unit = spinner.getSelectedItem().toString();
					if ((!roll.equals("")) && (roll.length() == 6)) {
						if ((unit.equals("A")) || (unit.equals("B"))
								|| (unit.equals("C")) || (unit.equals("D"))
								|| (unit.equals("E")) || (unit.equals("F"))
								|| (unit.equals("G")) || (unit.equals("H")))
							new CheckResult().execute(" ");

						else {
							DialogShow("Invalid Input !");

						}
					}

					else {
						DialogShow("Invalid Input !");

					}

				} else {
					DialogShow("Internet not available, Check your internet connectivity and try again");
				}

			}
		});

		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
	}

	private void initializedSpinner() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {

				View v = super.getView(position, convertView, parent);
				if (position == getCount()) {
					((TextView) v.findViewById(android.R.id.text1)).setText("");
					((TextView) v.findViewById(android.R.id.text1))
							.setHint(getItem(getCount()));

					// "Hint to be displayed"
				}
				((TextView) v).setGravity(Gravity.CENTER);
				return v;
			}

			@Override
			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View v = super.getDropDownView(position, convertView, parent);

				((TextView) v).setGravity(Gravity.CENTER);

				return v;

			}

			@Override
			public int getCount() {
				return super.getCount() - 1; // you dont display last item. It
												// is used as hint.
			}

		};

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter.add("A");
		adapter.add("B");
		adapter.add("C");
		adapter.add("D");
		adapter.add("E");
		adapter.add("F");
		adapter.add("G");
		adapter.add("H");
		adapter.add("Select Unit");
		spinner.setAdapter(adapter);
		spinner.setSelection(adapter.getCount()); // display hint

	}

	class CheckResult extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;
		String response = "";
		int success = 0;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = null;
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("Wait ................");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			ArrayList<NameValuePair> listParamsData = new ArrayList<NameValuePair>();
			listParamsData.add(new BasicNameValuePair("roll", roll));
			Log.d("unit", unit + "");
			Log.d("roll", et_roll.getText().toString());
			String url = "";
			if (unit.equals("A")) {
				url = ConstandValue.A_UNIT_URL;
			} else if (unit.equals("B")) {
				url = ConstandValue.B_UNIT_URL;

			} else if (unit.equals("C")) {
				url = ConstandValue.C_UNIT_URL;

			} else if (unit.equals("D")) {
				url = ConstandValue.D_UNIT_URL;

			} else if (unit.equals("E")) {
				url = ConstandValue.E_UNIT_URL;
			} else if (unit.equals("F")) {
				url = ConstandValue.F_UNIT_URL;
			} else if (unit.equals("G")) {
				url = ConstandValue.G_UNIT_URL;
			} else if (unit.equals("H")) {
				url = ConstandValue.H_UNIT_URL;
			}
			try {
				response = CustomHttpClient
						.executeHttpPost(url, listParamsData);
				Log.d("response", response);
				if (!response.equals("")) {
					JSONObject respObject = new JSONObject(response);
					success = respObject.getInt("success");

					if (success == 1) {
						ConstandValue.unit = unit;
						JSONArray booksArray = respObject
								.getJSONArray("seatPlan");

						JSONObject bookObj = booksArray.getJSONObject(0);
						ConstandValue.roll = roll;
						ConstandValue.time = bookObj.getString("time");
						ConstandValue.date = bookObj.getString("date");

						ConstandValue.shift = bookObj.getString("shift");

						try {
							ConstandValue.room = bookObj.getString("room");

						} catch (Exception e) {
							// TODO: handle exception
						}

						try {
							ConstandValue.address = bookObj
									.getString("building");
						} catch (Exception e) {

						}
						try {
							ConstandValue.lat = bookObj.getDouble("lati");
							ConstandValue.lon = bookObj.getDouble("long");

						} catch (Exception e) {
							// TODO: handle exception
						}

						Log.d("LLLLLLLLLLLL", ConstandValue.lat + " :::: "
								+ ConstandValue.lon);

						if (ConstandValue.room.equals("")
								|| ConstandValue.room.equals("null")
								|| ConstandValue.room.equals(null)
								|| ConstandValue.room.isEmpty()) {
							ConstandValue.room = "Publish soon...";

						}
						if (ConstandValue.address.equals("")
								|| ConstandValue.address.equals("null")
								|| ConstandValue.address.equals(null)
								|| ConstandValue.address.isEmpty()) {
							ConstandValue.address = "Publish soon...";

						}
						Log.d("shhhhhhhhhhhhh", ConstandValue.shift);
						Log.d("room", ConstandValue.room);
						Log.d("address", ConstandValue.address);
						Log.d("address", "");

					}
				}
			} catch (Exception e) {
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
			if ((pDialog != null) && (pDialog.isShowing())) {
				pDialog.dismiss();
			}

			if (success == 0) {
				DialogShow("No Result found !");
			} else {
				et_roll.setText("");
				spinner.setSelection(0);
				listener.onSwitchClick();
			}
			super.onPostExecute(result);
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

	private void DialogShow(String mgs) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
}
