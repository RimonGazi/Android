package com.rimon.rsa.ipaes.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;

public class SettingFragment_3 extends SherlockFragment {
	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.setting_fragment_3, null, false);
		return view;
		
	}

}
