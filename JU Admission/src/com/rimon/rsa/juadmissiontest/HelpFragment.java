package com.rimon.rsa.juadmissiontest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.mymap.R;

public class HelpFragment extends SherlockFragment {
	HelpSectionsPagerAdapter adapter;
	HelpCustomSwipeableViewPager pager;
	TextView tv_ju_url;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.help, container, false);
		tv_ju_url = (TextView) view.findViewById(R.id.url_ju);
		tv_ju_url.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.juniv.edu"));
				getActivity().startActivity(browserIntent);

			}

		});
		
		pager = (HelpCustomSwipeableViewPager) view.findViewById(R.id.pager2);
		adapter = new HelpSectionsPagerAdapter(getChildFragmentManager());
		pager.setAdapter(adapter);

		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
	}
}
