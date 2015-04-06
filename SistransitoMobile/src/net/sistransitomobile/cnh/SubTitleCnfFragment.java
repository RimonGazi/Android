package net.sistransitomobile.cnh;

import net.sistransitomobile.main.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class SubTitleCnfFragment extends SherlockFragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.cnh_fragment_subtitle, null, false);
		return view;
	}

}
