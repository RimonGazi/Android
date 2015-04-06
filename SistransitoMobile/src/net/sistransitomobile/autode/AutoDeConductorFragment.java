package net.sistransitomobile.autode;

import java.util.Arrays;
import java.util.List;

import net.sistransitomobile.adapter.AnyArrayAdapter;
import net.sistransitomobile.main.R;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockFragment;

public class AutoDeConductorFragment extends SherlockFragment implements
		OnItemSelectedListener {
	private View view;
	private EditText et_autode_placa, et_autode_model, et_autode_condutor,
			et_autode_cnh_ppd, et_autode_cpf, et_autode_cor_do_veiculo;
	private Spinner autode_spinner_especie, autode_spinner_categori;
	private List<String> list_category, list_especie;
	private AnyArrayAdapter<String> adapter_category, adapter_especie;
	private AutoDeData data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater
				.inflate(R.layout.auto_de_condutor_fragment, null, false);
		initializedView();
		getAutodeObject();	
		return view;
	}

	private void addListener() {
		et_autode_cnh_ppd.addTextChangedListener(new ChangeText(
				R.id.et_autode_cnh_ppd));
		et_autode_condutor.addTextChangedListener(new ChangeText(
				R.id.et_autode_condutor));
		et_autode_cpf
				.addTextChangedListener(new ChangeText(R.id.et_autode_cpf));
		autode_spinner_categori.setOnItemSelectedListener(this);
		autode_spinner_especie.setOnItemSelectedListener(this);

	}

	private void getAutodeObject() {
		data = AutoDeObgect.getAutoDeOject();
		if (data.isStoreFullData()) {
			getRecomandedUpdate();
			getOtherUpdate();
			addListener();
		} else {
			getRecomandedUpdate();
			addListener();
			initializedSelectetItems();
		}
	}

	private void initializedSelectetItems() {
		autode_spinner_categori.setSelection(0);
		autode_spinner_especie.setSelection(0);
		et_autode_cnh_ppd.setText("");
		et_autode_condutor.setText("");
		et_autode_cpf.setText("");
	}

	private void initializedView() {
		et_autode_placa = (EditText) view.findViewById(R.id.et_autode_placa);
		et_autode_model = (EditText) view.findViewById(R.id.et_autode_model);
		et_autode_condutor = (EditText) view
				.findViewById(R.id.et_autode_condutor);
		et_autode_cnh_ppd = (EditText) view
				.findViewById(R.id.et_autode_cnh_ppd);
		et_autode_cpf = (EditText) view.findViewById(R.id.et_autode_cpf);
		et_autode_cor_do_veiculo = (EditText) view
				.findViewById(R.id.et_autode_cor_do_veiculo);

		et_autode_placa.setEnabled(false);
		et_autode_cor_do_veiculo.setEnabled(false);
		et_autode_model.setEnabled(false);
		list_category = Arrays.asList(getResources().getStringArray(
				R.array.autode_categoria));
		adapter_category = new AnyArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, android.R.id.text1,
				list_category);
		list_especie = Arrays.asList(getResources().getStringArray(
				R.array.autode_especie));
		adapter_especie = new AnyArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, android.R.id.text1,
				list_especie);
		autode_spinner_especie = (Spinner) view
				.findViewById(R.id.autode_spinner_especie);
		autode_spinner_categori = (Spinner) view
				.findViewById(R.id.autode_spinner_categoria);
		autode_spinner_especie.setAdapter(adapter_especie);
		autode_spinner_categori.setAdapter(adapter_category);
		
		setAutocompleteView();
	}

	private void setAutocompleteView() {
	
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long Id) {

		switch (view.getId()) {
		case R.id.autode_spinner_categoria:
			data.setCategoria((String) parent.getItemAtPosition(pos));
			break;

		case R.id.autode_spinner_especie:
			data.setEspecie((String) parent.getItemAtPosition(pos));
			break;

		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}

	private void getRecomandedUpdate() {
		et_autode_placa.setText(data.getPlate());
		et_autode_model.setText(data.getModel());
		et_autode_cor_do_veiculo.setText(data.getCor_do_veiculo());
	}

	private void getOtherUpdate() {
		int selection_1 = 0, selection_2 = 0;
		selection_1 = list_category.indexOf(data.getCategoria());
		selection_2 = list_especie.indexOf(data.getEspecie());
		autode_spinner_categori.setSelection(selection_1);
		autode_spinner_especie.setSelection(selection_2);
		et_autode_cnh_ppd.setText(data.getCnh_ppd());
		et_autode_cpf.setText(data.getCpf());
		et_autode_condutor.setText(data.getIdentification_do_conductor());
	}

	private class ChangeText implements TextWatcher {
		private int id;

		public ChangeText(int id) {
			this.id = id;
		}

		@Override
		public void afterTextChanged(Editable s) {
			switch (id) {
			case R.id.et_autode_cnh_ppd:
				data.setCnh_ppd(s.toString());
				break;
			case R.id.et_autode_cpf:
				data.setCpf(s.toString());
				break;
			case R.id.et_autode_condutor:
				data.setIdentification_do_conductor(s.toString());
			}
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {

		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {

		}
	}
}