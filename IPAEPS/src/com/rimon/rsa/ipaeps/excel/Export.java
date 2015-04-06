package com.rimon.rsa.ipaeps.excel;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.actionbar.CustomActionBar;

public class Export extends SherlockFragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {

		super.onCreate(arg0);
		setContentView(R.layout.export_main);
		actionberSetUp();
	}

	private void actionberSetUp() {

		CustomActionBar customActionBar = new CustomActionBar(Export.this);
		customActionBar.setupActionBarWithBack(getSupportActionBar(),
				R.drawable.ic_excel_p, R.string.export_3);

	}

}
