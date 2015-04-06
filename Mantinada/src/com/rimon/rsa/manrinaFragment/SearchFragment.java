package com.rimon.rsa.manrinaFragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;

import com.rimon.rsa.mantinada.MainActivity;
import com.rimon.rsa.mantinada.R;



public class SearchFragment extends Fragment {
	private Spinner spinnerCategory, spinnerChapter;
	private CheckBox cbCategory, cbChapter, cbSearch;
	private EditText etSearch;
	private Button btnSearch;
	private ArrayAdapter<String> adapterCategory, adapterChapter;
	private String[] ca = { "1", "2", "3", "4" };
	private String[] ch = { "a", "b", "c", "d" };
	private OnSwitchClickListener listener;
	private String searchTearmString;
	@Override
	public void onDestroy() {
		
		super.onDestroy();
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		listener = (MainActivity) activity;
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.search, container, false);
		spinnerCategory = (Spinner) view.findViewById(R.id.spinnerCategory);
		spinnerChapter = (Spinner) view.findViewById(R.id.spinnerChapter);
		adapterCategory = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_selectable_list_item, ca);
		adapterChapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_single_choice, ch);
		adapterCategory
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerCategory.setAdapter(adapterCategory);
		spinnerChapter.setAdapter(adapterChapter);
		cbCategory = (CheckBox) view.findViewById(R.id.cbCategory);
		cbChapter = (CheckBox) view.findViewById(R.id.cbChapter);
		cbSearch = (CheckBox) view.findViewById(R.id.cbSearch);
		etSearch = (EditText) view.findViewById(R.id.etSearch);
		spinnerCategory.setEnabled(false);
		spinnerChapter.setEnabled(false);
		etSearch.setEnabled(false);
		btnSearch = (Button) view.findViewById(R.id.button1);
		btnSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (spinnerCategory.isEnabled()) {
					searchTearmString = spinnerCategory.getSelectedItem()
							.toString();
					new SearchData().execute("");
					//listener.onSwitchClick(v);
				} else if (spinnerChapter.isEnabled()) {
					searchTearmString = spinnerChapter.getSelectedItem()
							.toString();
					new SearchData().execute("");
					//listener.onSwitchClick(v);
				} else if (etSearch.isEnabled()) {
					searchTearmString = etSearch.getText().toString();
					new SearchData().execute("");
					//listener.onSwitchClick(v);
				} else {

					AlertDialog.Builder builder = new AlertDialog.Builder(
							getActivity());
					builder.setTitle("Error");
					builder.setMessage("Invalid input !");
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
		});

		cbCategory.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean b) {
				if (b) {
					if (cbChapter.isChecked())
						cbChapter.setChecked(false);
					if (cbSearch.isChecked())
						cbSearch.setChecked(false);
					if (spinnerChapter.isEnabled())
						spinnerChapter.setEnabled(false);
					if (etSearch.isEnabled())
						etSearch.setEnabled(false);
					if (!spinnerCategory.isEnabled())
						spinnerCategory.setEnabled(true);
				} else {
					if (spinnerCategory.isEnabled())
						spinnerCategory.setEnabled(false);
					if (spinnerChapter.isEnabled())
						spinnerChapter.setEnabled(false);
					if (etSearch.isEnabled())
						etSearch.setEnabled(false);

				}

			}
		});
		cbChapter.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean b) {
				if (b) {
					if (cbSearch.isChecked())
						cbSearch.setChecked(false);
					if (cbCategory.isChecked())
						cbCategory.setChecked(false);

					if (spinnerCategory.isEnabled())
						spinnerCategory.setEnabled(false);
					if (etSearch.isEnabled())
						etSearch.setEnabled(false);
					if (!spinnerChapter.isEnabled())
						spinnerChapter.setEnabled(true);
				} else {
					if (spinnerCategory.isEnabled())
						spinnerCategory.setEnabled(false);
					if (spinnerChapter.isEnabled())
						spinnerChapter.setEnabled(false);
					if (etSearch.isEnabled())
						etSearch.setEnabled(false);

				}

			}
		});
		cbSearch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean b) {
				if (b) {
					if (cbCategory.isChecked())
						cbCategory.setChecked(false);
					if (cbChapter.isChecked())
						cbChapter.setChecked(false);
					if (spinnerCategory.isEnabled())
						spinnerCategory.setEnabled(false);
					if (spinnerChapter.isEnabled())
						spinnerChapter.setEnabled(false);
					if (!etSearch.isEnabled())
						etSearch.setEnabled(true);
				} else {
					if (spinnerCategory.isEnabled())
						spinnerCategory.setEnabled(false);
					if (spinnerChapter.isEnabled())
						spinnerChapter.setEnabled(false);
					if (etSearch.isEnabled())
						etSearch.setEnabled(false);

				}

			}
		});

		return view;
	}

class SearchData extends AsyncTask<String, String, String> {
		public ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMax(100);
			pDialog.setCancelable(false);
			pDialog.setMessage("Wait\nMntinada is searching ...");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			for (int i = 0; i < 2; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				publishProgress(i + "");
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
		String result1="abcnnnnnnnnnnnnnnnnnnnnnnnn";
		SearchResult.setResult(result1);
		listener.onSwitchClick();
		}

	}

}
