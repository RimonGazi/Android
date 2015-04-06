package com.rimon.rsa.juadmissiontest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rimon.mymap.MainActivity;
import com.rimon.mymap.R;
import com.rimon.rsa.juadmissiontest.save.FileSaveFragment;

public class ResultFragment extends Fragment {
	TextView tv_roll, tv_date, tv_unit, tv_time, tv_shift, tv_room, tv_address;
	Button btn_save, btn_map;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		// inflater.inflate(R.menu.main, menu);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.result, container, false);
		tv_roll = (TextView) view.findViewById(R.id.result_roll);
		tv_time = (TextView) view.findViewById(R.id.result_time);
		tv_unit = (TextView) view.findViewById(R.id.result_unit);
		tv_date = (TextView) view.findViewById(R.id.result_date);
		tv_shift = (TextView) view.findViewById(R.id.result_shift);
		tv_room = (TextView) view.findViewById(R.id.result_room);
		tv_address = (TextView) view.findViewById(R.id.result_address);
		btn_save = (Button) view.findViewById(R.id.result_save);

		btn_map = (Button) view.findViewById(R.id.result_map_view);
		btn_map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getActivity(), MainActivity.class));

			}
		});

		btn_save.setOnClickListener(new OnClickListener() {
			String fragTag = getResources().getString(
					R.string.tag_fragment_FileSave);
			String xml = getResources().getString(R.string.file_extension_xml);

			@Override
			public void onClick(View arg0) {
				android.app.FragmentManager fragManager = getActivity()
						.getFragmentManager();
				com.rimon.rsa.juadmissiontest.save.FileSaveFragment fsf = FileSaveFragment
						.newInstance(xml, R.string.alert_ok,
								R.string.alert_cancel,
								R.string.alert_file_save_as,
								R.string.hint_filename_unadorned,
								R.drawable.save);
				fsf.show(fragManager, fragTag);
			}
		});

		setHasOptionsMenu(true);
		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
	}

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		if (menuVisible) {
			tv_roll.setText(": " + ConstandValue.roll);
			tv_shift.setText(": " + ConstandValue.shift);
			tv_unit.setText(": " + ConstandValue.unit);
			tv_date.setText(": " + ConstandValue.date);
			tv_time.setText(": " + ConstandValue.time);
			tv_room.setText(": " + ConstandValue.room);
			tv_address.setText(": " + ConstandValue.address);

		}
	}
}
