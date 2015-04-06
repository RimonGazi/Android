package com.project.dataminer;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class SyncInofrmation extends AsyncTask<String, String, String> {

	private int intial_update_number = 0;;
	private Context context;
	public ProgressDialog pDialog;
	Cursor userCursor, dataCursor;
	UserDbAdapter userDbAdapter;
	DataDbAdapter dataDbAdapter;
	private boolean user_update_status = false;
	private boolean data_update_status = false;
	final String userUrl = "http://printfood.com/csi/insertuser.php";
	final String dataUrl = "http://www.printfood.com/csi/insertdata.php";
	private int userUpdateNumber = 0;
	private int dataUpdateNumber = 0;

	public SyncInofrmation(Context con) {
		context = con;
		userDbAdapter = new UserDbAdapter(context);
		userDbAdapter.open();
		dataDbAdapter = new DataDbAdapter(context);
		dataDbAdapter.open();

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		userCursor = userDbAdapter.getallUpdatedData();
		dataCursor = dataDbAdapter.getallUpdatedData();
		pDialog = null;
		pDialog = new ProgressDialog(context);
		pDialog.setMax(100);
		pDialog.setCancelable(false);
		pDialog.setMessage("Wait\n .....");
		pDialog.show();
	}

	@Override
	protected String doInBackground(String... arg0) {

		if (((userCursor.getCount()) > 0)) {

			user_update_status = true;
			String userResponse;
			ArrayList<NameValuePair> listParamsUsers = new ArrayList<NameValuePair>();
			listParamsUsers.add(new BasicNameValuePair("usersJSON",
					getUserJson()));
			try {
				userResponse = CustomHttpClient.executeHttpPost(userUrl,
						listParamsUsers);

				JSONArray resultJsonArray = new JSONArray(userResponse);
				Log.d("jason aaray ",
						resultJsonArray + " " + resultJsonArray.length());
				for (int loparg = 0; loparg < resultJsonArray.length(); loparg++) {
					JSONObject obj = (JSONObject) resultJsonArray.get(loparg);
					Log.d("ssssssssssss",
							obj.getString("id") + " " + obj.getString("status"));
					if ((obj.getString("status")).equals("yes")) {
						Log.d("update", "yes");
						userDbAdapter.updateUpdateStatusUser(
								obj.getString("id"), "yes");
						userUpdateNumber++;

					}

				}
			} catch (Exception e) {

				e.printStackTrace();
			}

		} else {
			user_update_status = false;

		}
		if ((dataCursor.getCount() > 0)) {
			intial_update_number = dataCursor.getCount();
			user_update_status = true;
			String dataResponse;
			ArrayList<NameValuePair> listParamsData = new ArrayList<NameValuePair>();
			listParamsData
					.add(new BasicNameValuePair("dataJSON", getDataJson()));

			try {
				if (intial_update_number > 0) {
					dataResponse = CustomHttpClient.executeHttpPost(dataUrl,
							listParamsData);
					JSONArray resultJsonArrayData = new JSONArray(dataResponse);
					Log.d("jason aaray ", resultJsonArrayData + " "
							+ resultJsonArrayData.length());
					for (int loparg = 0; loparg < resultJsonArrayData.length(); loparg++) {
						JSONObject obj = (JSONObject) resultJsonArrayData
								.get(loparg);
						Log.d("ssssssssssss",
								obj.getString("id") + " "
										+ obj.getString("status"));
						if ((obj.getString("status")).equals("yes")) {
							Log.d("update", "yes");
							dataDbAdapter.updateUpdateStatusData(
									obj.getString("id"), "yes");
							dataUpdateNumber++;

						}

					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			data_update_status = false;

		}

		return null;

	}

	@Override
	protected void onProgressUpdate(String... values) {
		super.onProgressUpdate(values);
		// pDialog.setProgress(Integer.parseInt(values[0]));
	}

	@Override
	protected void onPostExecute(String result) {
		if ((pDialog != null) && (pDialog.isShowing())) {
			pDialog.dismiss();
		}
		if (!user_update_status && !data_update_status) {
			DialogShow("ข้อมูลทั้งหมดจะถูกปรับปรุง");
		} else if (user_update_status || data_update_status) {
			// DialogShow("Total Update needed : "
			// + (userCursor.getCount() + intial_update_number) + "\n\n"
			// + "Children's information Update needed : "
			// + userCursor.getCount() + "\n"
			// + "Children's information Updated : " + userUpdateNumber
			// + "\n\nChildren's question answer Update needed : "
			// + intial_update_number + "\n"
			// + "Children's question answer Updated : "
			// + dataUpdateNumber);
			Log.d("update ingfo",
					"Total Update needed : "
							+ (userCursor.getCount() + intial_update_number)
							+ "\n\n"
							+ "Children's information Update needed : "
							+ userCursor.getCount() + "\n"
							+ "Children's information Updated : "
							+ userUpdateNumber
							+ "\n\nChildren's question answer Update needed : "
							+ intial_update_number + "\n"
							+ "Children's question answer Updated : "
							+ dataUpdateNumber);
			DialogShowConfirm("กรุณากดตกลง");

		}

		userDbAdapter.close();
		dataDbAdapter.close();
		intial_update_number = 0;
		super.onPostExecute(result);
	}

	private String getUserJson() {
		ArrayList<HashMap<String, String>> userList;
		userList = new ArrayList<HashMap<String, String>>();
		if (userCursor.moveToFirst()) {
			do {
				HashMap<String, String> map = new HashMap<String, String>();
				// id = userCursor.getString(0);
				map.put("id", userCursor.getString(0));
				map.put("cid", userCursor.getString(6));
				map.put("name", userCursor.getString(1));
				map.put("lname", userCursor.getString(2));
				map.put("dob", userCursor.getString(3));
				map.put("nname", userCursor.getString(4));
				map.put("addr1", userCursor.getString(7));
				map.put("addr2", userCursor.getString(8));
				map.put("addr3", userCursor.getString(9));
				map.put("gender", userCursor.getString(11));
				map.put("userName", SingIn.nameOfUser);
				userList.add(map);
			} while (userCursor.moveToNext());

		}
		Gson gson = new GsonBuilder().create();

		Log.d("hasmap", gson.toJson(userList));
		return gson.toJson(userList);
	}

	private String getDataJson() {
		int i = 1;
		ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		// Log.d("counr :", dataCursor.getCount() + "");
		if (dataCursor.moveToFirst()) {
			do {
				if ((!(dataCursor.getString(2)).equals("0"))
						&& (!(dataCursor.getString(3)).equals("0"))
						&& (!(dataCursor.getString(4)).equals("0"))
						&& (!(dataCursor.getString(5)).equals("0"))
						&& (!(dataCursor.getString(6)).equals("0"))
						&& (!(dataCursor.getString(7)).equals("0"))
						&& (!(dataCursor.getString(8)).equals("0"))
						&& (!(dataCursor.getString(9)).equals("0"))
						&& (!(dataCursor.getString(10)).equals("0"))
						&& (!(dataCursor.getString(11)).equals("0"))
						&& (!(dataCursor.getString(12)).equals("0"))
						&& (!(dataCursor.getString(13)).equals("0"))
						&& (!(dataCursor.getString(14)).equals("0"))
						&& (!(dataCursor.getString(15)).equals("0"))
						&& (!(dataCursor.getString(16)).equals("0"))
						&& (!(dataCursor.getString(18)).equals("0"))
						&& (!(dataCursor.getString(19)).equals("0"))
						&& (!(dataCursor.getString(10)).equals("0"))
						&& (!(dataCursor.getString(11)).equals("0"))
						&& (!(dataCursor.getString(12)).equals("0"))
						&& (!(dataCursor.getString(13)).equals("0"))
						&& (!(dataCursor.getString(14)).equals("0"))
						&& (!(dataCursor.getString(15)).equals("0"))
						&& (!(dataCursor.getString(16)).equals("0"))
						&& (!(dataCursor.getString(17)).equals("0"))
						&& (!(dataCursor.getString(18)).equals("0"))
						&& (!(dataCursor.getString(19)).equals("0"))
						&& (!(dataCursor.getString(20)).equals("0"))
						&& (!(dataCursor.getString(21)).equals("0"))
						&& (!(dataCursor.getString(22)).equals("0"))
						&& (!(dataCursor.getString(23)).equals("0"))
						&& (!(dataCursor.getString(24)).equals("0"))
						&& (!(dataCursor.getString(26)).equals(""))
						&& (!(dataCursor.getString(27)).equals(""))
						&& (!(dataCursor.getString(28)).equals(""))
						&& (!(dataCursor.getString(29)).equals(""))
						&& (!(dataCursor.getString(30)).equals(""))
						&& (!(dataCursor.getString(31)).equals(""))
						&& (!(dataCursor.getString(32)).equals(""))
						&& (!(dataCursor.getString(34)).equals(""))
						&& (!(dataCursor.getString(35)).equals(""))
						&& (!(dataCursor.getString(36)).equals(""))
						&& (!(dataCursor.getString(dataCursor
								.getColumnIndex(MySQLiteHelper.JOB)))
								.equals(""))
						&& (!(dataCursor.getString(dataCursor
								.getColumnIndex(MySQLiteHelper.ID_DATA_EXTEA)))
								.equals("0"))) {

					i++;
					HashMap<String, String> map2 = new HashMap<String, String>();
					map2.put("id", String.valueOf(dataCursor.getInt(0)));
					map2.put("no", dataCursor.getString(1));
					map2.put("ans11", dataCursor.getString(2));
					map2.put("ans12", dataCursor.getString(3));
					map2.put("ans13", dataCursor.getString(4));
					map2.put("ans21", dataCursor.getString(5));
					map2.put("ans22", dataCursor.getString(6));
					map2.put("ans23", dataCursor.getString(7));
					map2.put("ans24", dataCursor.getString(8));
					map2.put("ans25", dataCursor.getString(9));
					map2.put("ans26", dataCursor.getString(10));
					map2.put("ans31", dataCursor.getString(11));
					map2.put("ans32", dataCursor.getString(12));
					map2.put("ans33", dataCursor.getString(13));
					map2.put("ans34", dataCursor.getString(14));
					map2.put("ans35", dataCursor.getString(15));
					map2.put("ans41", dataCursor.getString(16));
					map2.put("ans42", dataCursor.getString(17));
					map2.put("ans43", dataCursor.getString(18));
					map2.put("ans51", dataCursor.getString(19));
					map2.put("ans52", dataCursor.getString(20));
					map2.put("ans53", dataCursor.getString(21));
					map2.put("ans54", dataCursor.getString(22));
					map2.put("ans61", dataCursor.getString(23));
					map2.put("ans62", dataCursor.getString(24));
					map2.put("care", dataCursor.getString(26));
					map2.put("careage", dataCursor.getString(27));
					map2.put("carerelate", dataCursor.getString(28));
					map2.put("carelong", dataCursor.getString(29));
					map2.put("with018", dataCursor.getString(30));
					map2.put("with18up", dataCursor.getString(31));
					map2.put("withd018", dataCursor.getString(32));
					map2.put("withd18up", dataCursor.getString(33));
					map2.put("withs018", dataCursor.getString(34));
					map2.put("withs18up", dataCursor.getString(35));
					map2.put("event", dataCursor.getString(36));
					map2.put("q1h1", dataCursor.getString(37));
					map2.put("q1h2", dataCursor.getString(38));
					map2.put("q1h3", dataCursor.getString(39));
					map2.put("q1h4", dataCursor.getString(40));
					map2.put("q2h1", dataCursor.getString(41));
					map2.put("q2h2", dataCursor.getString(42));
					map2.put("q2h3", dataCursor.getString(43));
					map2.put("q2h4", dataCursor.getString(44));
					map2.put("q2h5", dataCursor.getString(45));
					map2.put("q2h6", dataCursor.getString(46));
					map2.put("q3h1", dataCursor.getString(47));
					map2.put("q3h2", dataCursor.getString(48));
					map2.put("q3h3", dataCursor.getString(49));
					map2.put("q4h1", dataCursor.getString(50));
					map2.put("q4h2", dataCursor.getString(51));
					map2.put("q4h3", dataCursor.getString(52));
					map2.put("q5h1", dataCursor.getString(53));
					map2.put("q5h2", dataCursor.getString(54));
					map2.put("q6h1", dataCursor.getString(55));
					map2.put("q6h2", dataCursor.getString(56));
					map2.put("timebegin", dataCursor.getString(57));
					map2.put("timeend", dataCursor.getString(58));
					map2.put("common_cid", dataCursor.getString(dataCursor
							.getColumnIndex(MySQLiteHelper.COMMON_CID)));
					dataList.add(map2);

					map2.put(MySQLiteHelper.JOB, dataCursor
							.getString(dataCursor
									.getColumnIndex(MySQLiteHelper.JOB)));
					map2.put(
							MySQLiteHelper.ID_DATA_EXTEA,
							dataCursor.getString(dataCursor
									.getColumnIndex(MySQLiteHelper.ID_DATA_EXTEA)));
					dataList.add(map2);
					Log.d("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD",
							dataList.toString());
				} else {
					intial_update_number--;
				}

			} while (dataCursor.moveToNext());
		}
		Gson gson = new GsonBuilder().create();

		// Log.d("hasmap data", gson.toJson(dataList));

		return gson.toJson(dataList);
	}

	private void DialogShow(String mgs) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
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

	private void DialogShowConfirm(String mgs) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("ข้อมูล");
		builder.setMessage(mgs);
		builder.setPositiveButton("ตกลง",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						context.startActivity(new Intent(context, Menu.class));

					}
				});
		builder.setIcon(android.R.drawable.ic_dialog_alert);
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}
}
