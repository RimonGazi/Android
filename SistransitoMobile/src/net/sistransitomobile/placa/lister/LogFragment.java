package net.sistransitomobile.placa.lister;

import net.sistransitomobile.main.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;

public class LogFragment extends SherlockFragment implements OnClickListener {
	private View view;
	private Button btn_listar_placas;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.log_fragment, null, false);
		initializedView();
		return view;
	}

	private void initializedView() {
		btn_listar_placas = (Button) view.findViewById(R.id.btn_listar_placas);
		btn_listar_placas.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_listar_placas:
			startActivity(new Intent(getActivity(), PlacaList.class));
			break;

		default:
			break;
		}

	}

}
