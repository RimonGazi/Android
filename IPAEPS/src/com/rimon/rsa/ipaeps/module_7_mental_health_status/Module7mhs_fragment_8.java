package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.updatefragment.AnyPageChangeListener;

public class Module7mhs_fragment_8 extends SherlockFragment {
	

	private AnyButton btn_next;
	private AnyPageChangeListener listener;

	@Override
	public void onAttach(Activity activity) {
		listener = (Module7MentalHealth) getActivity();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.module_7_mhs_fragment_8, null,
				false);

		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setEnabled(true);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listener.pageChange(AppConstants.MODULE_7_PAGE_9);

			}
		});

		return view;
	}

}
