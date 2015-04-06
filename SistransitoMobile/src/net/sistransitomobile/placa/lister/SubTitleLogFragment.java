package net.sistransitomobile.placa.lister;

import net.sistransitomobile.main.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class SubTitleLogFragment extends SherlockFragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.log_fragment_subtitle, null, false);
		return view;
	}

}
