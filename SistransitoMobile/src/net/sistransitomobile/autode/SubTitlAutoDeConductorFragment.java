package net.sistransitomobile.autode;

import net.sistransitomobile.main.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class SubTitlAutoDeConductorFragment extends SherlockFragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.autode_conductor_fragment_subtitle, null, false);
		return view;
	}

}
