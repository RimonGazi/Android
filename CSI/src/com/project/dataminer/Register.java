package com.project.dataminer;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {

	static Button Bdate, regist;
	static TextView name;
	static TextView lname;
	static TextView cid;
	static TextView addr;
	static TextView addr2;
	static TextView addr3;
	static TextView nname;
	static EditText ename;
	static EditText elname;
	static EditText ecid;

	static EditText enname;
	static final int DATE_DIALOG_ID = 0;
	private UserDbAdapter db;
	private CheckBox cb_male, cb_female;
	private Spinner sp_province_add3;
	private AutoCompleteTextView ac_subdristic, ac_dristic;
	String subDristricAddreess, dristricAddress, provimicAddress;
	private AddressValuSUBDRISTIC addressValuSUBDRISTIC;
	private AddressValuDISTRIC addressValuDISTRIC;
	private AddressValuPROVIMCE addressValuPROVIMCE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		addressValuSUBDRISTIC = new AddressValuSUBDRISTIC();
		addressValuDISTRIC = new AddressValuDISTRIC();
		addressValuPROVIMCE = new AddressValuPROVIMCE();
		subDristricAddreess = addressValuSUBDRISTIC.getSUBDRISTICvalueFirst();
		dristricAddress = addressValuDISTRIC.getDISTRICValueFirst();
		provimicAddress = addressValuPROVIMCE.getPROVIMCEvalueFirst();
		Typeface ThaiFont = Typeface.createFromAsset(getAssets(),
				"font/CORDIA.TTF");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		cb_male = (CheckBox) findViewById(R.id.cb_male_register);
		cb_female = (CheckBox) findViewById(R.id.cb_female_register);
		nname = (TextView) findViewById(R.id.nname);
		enname = (EditText) findViewById(R.id.enname);
		Bdate = (Button) findViewById(R.id.bday);
		regist = (Button) findViewById(R.id.regist);
		name = (TextView) findViewById(R.id.name);
		lname = (TextView) findViewById(R.id.lname);
		cid = (TextView) findViewById(R.id.cid);
		addr = (TextView) findViewById(R.id.addr);
		ename = (EditText) findViewById(R.id.ename);
		elname = (EditText) findViewById(R.id.elname);
		ecid = (EditText) findViewById(R.id.ecid);
		addr2 = (TextView) findViewById(R.id.addr2);
		addr3 = (TextView) findViewById(R.id.addr3);

		ac_subdristic = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_eaddr1);
		ac_subdristic.setTypeface(ThaiFont);

		ArrayAdapter<String> ac_subdAdapter = new ArrayAdapter<String>(
				Register.this, android.R.layout.simple_dropdown_item_1line,
				addressValuSUBDRISTIC.getSUBDRISTIC());
		ac_subdristic.setAdapter(ac_subdAdapter);

		ac_subdristic.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int pos,
					long arg3) {
				subDristricAddreess = (String) parent.getItemAtPosition(pos);
				// Toast.makeText(Register.this, subDristricAddreess,
				// Toast.LENGTH_SHORT).show();

			}
		});

		ac_dristic = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_eaddr2);
		ac_dristic.setTypeface(ThaiFont);
		ArrayAdapter<String> ac_dAdapter = new ArrayAdapter<String>(
				Register.this, android.R.layout.simple_dropdown_item_1line,
				addressValuDISTRIC.getDISTRIC());
		ac_dristic.setAdapter(ac_dAdapter);

		ac_dristic.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int pos,
					long arg3) {
				dristricAddress = (String) parent.getItemAtPosition(pos);
				// Toast.makeText(Register.this, dristricAddress,
				// Toast.LENGTH_SHORT).show();

			}
		});

		sp_province_add3 = (Spinner) findViewById(R.id.spinnereaddr3);
		ArrayAdapter<String> sppAdapter = new ArrayAdapter<String>(
				Register.this, android.R.layout.simple_selectable_list_item,
				addressValuPROVIMCE.getPROVIMCE());
		sp_province_add3.setAdapter(sppAdapter);
		sp_province_add3
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						provimicAddress = parent.getSelectedItem().toString();
						// Toast.makeText(Register.this,
						// parent.getSelectedItem().toString(),
						// Toast.LENGTH_SHORT).show();

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		cb_female.setTypeface(ThaiFont);
		cb_male.setTypeface(ThaiFont);
		name.setTypeface(ThaiFont);
		lname.setTypeface(ThaiFont);
		cid.setTypeface(ThaiFont);
		addr.setTypeface(ThaiFont);
		ename.setTypeface(ThaiFont);
		elname.setTypeface(ThaiFont);
		ecid.setTypeface(ThaiFont);
		// eaddr.setTypeface(ThaiFont);
		Bdate.setTypeface(ThaiFont);
		addr2.setTypeface(ThaiFont);
		addr3.setTypeface(ThaiFont);
		regist.setTypeface(ThaiFont);
		// eaddr2.setTypeface(ThaiFont);

		nname.setTypeface(ThaiFont);
		enname.setTypeface(ThaiFont);
		name.setTextSize(20);
		lname.setTextSize(20);
		cid.setTextSize(20);
		addr.setTextSize(20);
		Bdate.setTextSize(20);
		addr2.setTextSize(20);
		addr3.setTextSize(20);
		nname.setTextSize(20);

		db = new UserDbAdapter(this);
		db.open();

		Bdate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				DialogFragment d = new DatePickerFragment();
				d.show(getFragmentManager(), "date");
			}
		});

		cb_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					if (cb_female.isChecked()) {
						cb_female.setChecked(false);
					}

				}

			}
		});
		cb_female
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							if (cb_male.isChecked()) {
								cb_male.setChecked(false);
							}

						}

					}
				});

		regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				boolean checkStatus = cb_male.isChecked()
						|| cb_female.isChecked();
				if (ecid.getText().toString().length() == 13
						&& !ename.getText().toString().equals("")
						&& !elname.getText().toString().equals("")
						&& !enname.getText().toString().equals("")
						&& checkStatus) {
					String gender = "";
					if (cb_male.isChecked()) {
						gender = "male";
					} else {
						gender = "female";
					}
					db.AddData(ecid.getText().toString(), ename.getText()
							.toString(), elname.getText().toString(), Bdate
							.getText().toString(), enname.getText().toString(),
							2, subDristricAddreess, dristricAddress,
							provimicAddress, gender);
					Toast.makeText(getApplicationContext(), "Done",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(getApplicationContext(),
							com.project.dataminer.Menu.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(getApplicationContext(),
							"ต้องกรอกข้อมูลให้ครบ", Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		Intent intent = new Intent(getApplicationContext(),
				com.project.dataminer.Menu.class);
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}

	public static class DatePickerFragment extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {
			// Do something with the date chosen by the user
			month = month + 1;

			Log.d("MMMMMMMMMMMMMMMMRes", month + "");
			Bdate.setText(new StringBuilder().append(year).append("-")
					.append(month).append("-").append(day));
		}
	}
}
