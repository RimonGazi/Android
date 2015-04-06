package com.rimon.rsa.ibd.questionpatient.fragments;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rimon.rsa.mental.R;

public class CustomArrayAdapter<T> extends ArrayAdapter<T> {
	public Context context;

//	public CustomArrayAdapter(Context ctx) {
//
//		super(ctx, android.R.layout.simple_spinner_item);
//		context = ctx;
//	}

	public CustomArrayAdapter(Context ctx, T[] objects) {
		
		super(ctx, android.R.layout.simple_spinner_item, objects);
		context = ctx;

	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = super.getView(position, convertView, parent);
		((TextView) v).setTextColor(context.getResources().getColor(
				R.color.off_white));
		((TextView) v.findViewById(android.R.id.text1))
				.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT));
		((TextView) v.findViewById(android.R.id.text1)).setSingleLine(false);

		return v;

	}
}