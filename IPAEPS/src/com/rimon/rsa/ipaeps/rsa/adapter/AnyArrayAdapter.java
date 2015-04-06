package com.rimon.rsa.ipaeps.rsa.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rimon.rsa.ipaeps.appobject.AppObject;

public class AnyArrayAdapter<T> extends ArrayAdapter<T> {

	private Context context;

	public AnyArrayAdapter(Context context, int resource,
			int textViewResourceId, List<T> objects) {
		super(context, resource, textViewResourceId, objects);
		this.context = context;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = super.getView(position, convertView, parent);
		TextView tv = (TextView) v.findViewById(android.R.id.text1);

		tv.setSingleLine(false);
		tv.setTextColor(Color.BLACK);
		tv.setTypeface(AppObject.getCurrentFont(context));
		tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		return v;

	}

}

// ListAdapter adapter = new ArrayAdapter<String>(getActivity(),
// android.R.layout.simple_list_item_single_choice,
// android.R.id.text1, getResources().getStringArray(array_id)) {
//
// public View getView(int position, View convertView, ViewGroup parent)
// {
// // User super class to create the View
// View v = super.getView(position, convertView, parent);
//
// // TextView title =
// // (TextView)v.findViewById(android.R.id.title);
// TextView tv = (TextView) v.findViewById(android.R.id.text1);
//
// tv.setSingleLine(false);
// tv.setTextColor(Color.BLACK);
// tv.setTypeface(AppObject.getCurrentFont(getActivity()));
// tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// return v;
// }
// };