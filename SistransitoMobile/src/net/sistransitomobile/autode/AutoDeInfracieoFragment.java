package net.sistransitomobile.autode;

import java.util.ArrayList;
import java.util.List;

import net.sistransistomobile.datepicker.DateListener;
import net.sistransistomobile.datepicker.MyDatePicker;
import net.sistransistomobile.datepicker.MyTimePicker;
import net.sistransistomobile.datepicker.TimeListener;
import net.sistransitomobile.adapter.AnyArrayAdapter;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.database.PrepopulatedDBOpenHelper;
import net.sistransitomobile.main.R;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockFragment;

public class AutoDeInfracieoFragment extends SherlockFragment implements
		OnClickListener, TimeListener, DateListener {
	private View view;
	private AutoCompleteTextView autode_autocomplete_incracao,
			auto_autode_Muni;
	private AutoDeData data;
	private EditText et_autode_enquadra, et_autode_desdob, et_autode_art,
			et_autode_de_codigo_do_municipio, auto_de_UF, et_autode_local,
			et_autode_marca, et_autode_modelo, et_autode_numero_de_serie,
			et_autode_medicao_realizada, et_autode_valor,
			et_autode_n_da_amostra;
	private Button btn_autode_date_picker, btn_autode_time_picker;
	private Spinner spinner_autode_descricao;
	private List<String> list_descricao, list_marca, list_modelo;
	private AnyArrayAdapter<String> adapter_descricao;
	private List<String> muni_array, cod_array, uf_array, auto_infracao,
			auto_observacao, auto_desdob, auto_art, auto_enquadra;
	private ArrayAdapter<String> adapter_muni, adapter_infraceao;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.auto_de_infracao_frament, null, false);
		initializedView();
		getAutodeObject();
		return view;
	}

	private void initializedView() {
		autode_autocomplete_incracao = (AutoCompleteTextView) view
				.findViewById(R.id.autode_autocomplete_incracao);
		et_autode_enquadra = (EditText) view
				.findViewById(R.id.et_autode_enquadra);
		et_autode_desdob = (EditText) view.findViewById(R.id.et_autode_desdob);
		et_autode_art = (EditText) view.findViewById(R.id.et_autode_art);
		auto_autode_Muni = (AutoCompleteTextView) view
				.findViewById(R.id.auto_autode_Muni);
		et_autode_de_codigo_do_municipio = (EditText) view
				.findViewById(R.id.et_autode_de_codigo_do_municipio);
		auto_de_UF = (EditText) view.findViewById(R.id.auto_de_UF);
		et_autode_local = (EditText) view.findViewById(R.id.et_autode_local);
		btn_autode_date_picker = (Button) view
				.findViewById(R.id.btn_autode_date_picker);
		btn_autode_time_picker = (Button) view
				.findViewById(R.id.btn_autode_time_picker);

		et_autode_marca = (EditText) view.findViewById(R.id.et_autode_marca);
		et_autode_modelo = (EditText) view.findViewById(R.id.et_autode_modelo);
		et_autode_marca.setEnabled(false);
		et_autode_modelo.setEnabled(false);

		et_autode_numero_de_serie = (EditText) view
				.findViewById(R.id.et_autode_numero_de_serie);
		et_autode_medicao_realizada = (EditText) view
				.findViewById(R.id.et_autode_medicao_realizada);
		et_autode_valor = (EditText) view.findViewById(R.id.et_autode_valor);
		et_autode_n_da_amostra = (EditText) view
				.findViewById(R.id.et_autode_n_da_amostra);

		et_autode_de_codigo_do_municipio.setEnabled(false);
		auto_de_UF.setEnabled(false);
		et_autode_enquadra.setEnabled(false);
		et_autode_desdob.setEnabled(false);
		et_autode_art.setEnabled(false);
		setMunicipioAutoComplete();
		setInfraceaoAutoComplete();
		setDescriboSpinner();

	}

	private void setDescriboSpinner() {

		list_descricao = new ArrayList<String>();
		list_marca = new ArrayList<String>();
		list_modelo = new ArrayList<String>();

		Cursor cursor = ((DatabaseCreator
				.getPrepopulatedDBOpenHelper(getActivity()))
				.getAutoEquipamentoEntryCoursor());
		cursor.moveToFirst();
		for (int i = 0; i < cursor.getCount(); i++) {

			list_descricao
					.add(cursor.getString(cursor
							.getColumnIndex(PrepopulatedDBOpenHelper.AutoEquipamentoEntry_COLUMN_DESCRICAO)));

			list_marca
					.add(cursor.getString(cursor
							.getColumnIndex(PrepopulatedDBOpenHelper.AutoEquipamentoEntry_COLUMN_MARCA)));

			list_modelo
					.add(cursor.getString(cursor
							.getColumnIndex(PrepopulatedDBOpenHelper.AutoEquipamentoEntry_COLUMN_MODELO)));

			cursor.moveToNext();
		}
		cursor.close();

		adapter_descricao = new AnyArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, android.R.id.text1,
				list_descricao);

		spinner_autode_descricao = (Spinner) view
				.findViewById(R.id.spinner_autode_descricao);
		spinner_autode_descricao.setAdapter(adapter_descricao);

		spinner_autode_descricao
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View arg1, int pos, long arg3) {
						Log.d("dddddddddddddddd", "cccccccccl");
						data.setDescricao((String) parent
								.getItemAtPosition(pos));
						int realpositon = list_descricao.indexOf(data
								.getDescricao());

						data.setMarca(list_marca.get(realpositon));
						data.setModelo(list_modelo.get(realpositon));

						et_autode_marca.setText(data.getMarca());
						et_autode_modelo.setText(data.getModelo());

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

	}

	private void setInfraceaoAutoComplete() {

		Cursor cursor = (DatabaseCreator
				.getPrepopulatedDBOpenHelper(getActivity()))
				.getInfracaoCoursor();
		auto_infracao = new ArrayList<String>();
		auto_desdob = new ArrayList<String>();
		auto_art = new ArrayList<String>();
		auto_enquadra = new ArrayList<String>();
		auto_observacao = new ArrayList<String>();
		for (int i = 0; i < cursor.getCount(); i++) {
			auto_infracao
					.add(cursor.getString(cursor
							.getColumnIndex(PrepopulatedDBOpenHelper.INFRACOES_INFRACOES)));
			auto_enquadra
					.add(cursor.getString(cursor
							.getColumnIndex(PrepopulatedDBOpenHelper.INFRACOES_ENQUADRA)));
			auto_desdob
					.add(cursor.getString(cursor
							.getColumnIndex(PrepopulatedDBOpenHelper.INFRACOES_DESDOB)));
			auto_art.add(cursor.getString(cursor
					.getColumnIndex(PrepopulatedDBOpenHelper.INFRACOES_ART)));

			auto_observacao
					.add(cursor.getString(cursor
							.getColumnIndex(PrepopulatedDBOpenHelper.INFERACOES_OBSERVACAO)));
			cursor.moveToNext();
		}
		cursor.close();

		adapter_infraceao = new ArrayAdapter<String>(getActivity(),
				R.layout.custom_autocomplete, R.id.autoCompleteItem,
				auto_infracao);

		autode_autocomplete_incracao.setAdapter(adapter_infraceao);
		autode_autocomplete_incracao
				.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int pos, long id) {

						data.setInfracao((String) parent.getItemAtPosition(pos));
						int real_position = auto_infracao.indexOf(data
								.getInfracao());
						data.setEnquadra(auto_enquadra.get(real_position));
						et_autode_enquadra.setText(data.getEnquadra());
						data.setDesdob(auto_desdob.get(real_position));
						et_autode_desdob.setText(data.getDesdob());
						data.setArt(auto_art.get(real_position));
						et_autode_art.setText(data.getArt());
						data.setObservacao(auto_observacao.get(real_position));
					}
				});

	}

	private void addListener() {

		et_autode_local.addTextChangedListener(new ChangeText(
				R.id.et_autode_local));
		et_autode_marca.addTextChangedListener(new ChangeText(
				R.id.et_autode_marca));
		et_autode_numero_de_serie.addTextChangedListener(new ChangeText(
				R.id.et_autode_numero_de_serie));
		et_autode_modelo.addTextChangedListener(new ChangeText(
				R.id.et_autode_modelo));
		et_autode_medicao_realizada.addTextChangedListener(new ChangeText(
				R.id.et_autode_medicao_realizada));
		et_autode_valor.addTextChangedListener(new ChangeText(
				R.id.et_autode_enquadra));
		et_autode_n_da_amostra.addTextChangedListener(new ChangeText(
				R.id.et_autode_n_da_amostra));
		btn_autode_date_picker.setOnClickListener(this);
		btn_autode_time_picker.setOnClickListener(this);

	}

	private void getAutodeObject() {
		data = AutoDeObgect.getAutoDeOject();
		if (data.isStoreFullData()) {
			getRecomandedUpdate();
			addListener();
		} else {
			addListener();
			initializedSelectetItems();
		}

	}

	private void initializedSelectetItems() {
		et_autode_enquadra.setText("");
		et_autode_desdob.setText("");
		et_autode_art.setText("");
		et_autode_de_codigo_do_municipio.setText("");
		auto_de_UF.setText("");
		et_autode_local.setText("");
		et_autode_marca.setText("");
		et_autode_modelo.setText("");
		et_autode_numero_de_serie.setText("");
		et_autode_medicao_realizada.setText("");
		et_autode_valor.setText("");
		et_autode_n_da_amostra.setText("");
		spinner_autode_descricao.setSelection(0);

	}

	private void getRecomandedUpdate() {
		et_autode_enquadra.setText(data.getEnquadra());
		et_autode_desdob.setText(data.getDesdob());
		et_autode_art.setText(data.getArt());
		et_autode_de_codigo_do_municipio.setText(data.getCodigo_do_municipio());
		auto_de_UF.setText(data.getUf());
		et_autode_local.setText(data.getLocal());
		et_autode_marca.setText(data.getMarca());
		et_autode_modelo.setText(data.getModelo());
		et_autode_numero_de_serie.setText(data.getNumero_de_serie());
		et_autode_medicao_realizada.setText(data.getMedico_realizada());
		et_autode_valor.setText(data.getValor_considerada());
		et_autode_n_da_amostra.setText(data.getN_da_amostra());
		spinner_autode_descricao.setSelection(0);

	}

	private class ChangeText implements TextWatcher {
		private int id;

		public ChangeText(int id) {
			this.id = id;
		}

		@Override
		public void afterTextChanged(Editable s) {
			switch (id) {
			case R.id.et_autode_local:
				data.setLocal(s.toString());
				break;
			case R.id.et_autode_marca:
				data.setMarca(s.toString());
				break;
			case R.id.et_autode_numero_de_serie:
				data.setNumero_de_serie(s.toString());
				break;
			case R.id.et_autode_modelo:
				data.setModelo(s.toString());
				break;
			case R.id.et_autode_medicao_realizada:
				data.setMedico_realizada(s.toString());
				break;
			case R.id.et_autode_valor:
				data.setValor_considerada(s.toString());
				break;
			case R.id.et_autode_n_da_amostra:
				data.setN_da_amostra(s.toString());
				break;
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_autode_date_picker:
			MyDatePicker pickerdate = new MyDatePicker();
			pickerdate.setTargetFragment(this, 0);
			pickerdate.show(getActivity().getSupportFragmentManager(), "date");
			break;

		case R.id.btn_autode_time_picker:
			MyTimePicker picker = new MyTimePicker();
			picker.setTargetFragment(this, 0);
			picker.show(getActivity().getSupportFragmentManager(), "time");
			break;
		}

	}

	public void setMunicipioAutoComplete() {
		muni_array = new ArrayList<String>();
		cod_array = new ArrayList<String>();
		uf_array = new ArrayList<String>();
		Cursor myCursor = ((DatabaseCreator
				.getPrepopulatedDBOpenHelper(getActivity()))
				.getMunicipioCursor());
		do {
			muni_array
					.add(myCursor.getString(myCursor
							.getColumnIndex(PrepopulatedDBOpenHelper.MUNICIPIOS_MUNICIPIOS)));
			uf_array.add(myCursor.getString(myCursor
					.getColumnIndex(PrepopulatedDBOpenHelper.MUNICIPIOS_UF)));
			cod_array.add(myCursor.getString(myCursor
					.getColumnIndex(PrepopulatedDBOpenHelper.MUNICIPIOS_COD)));
		} while (myCursor.moveToNext());
		myCursor.close();
		adapter_muni = new ArrayAdapter<String>(getActivity(),
				R.layout.custom_autocomplete, R.id.autoCompleteItem, muni_array);
		auto_autode_Muni.setAdapter(adapter_muni);

		auto_autode_Muni.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long arg3) {
				data.setMunicipio((String) parent.getItemAtPosition(pos));
				int real_position = muni_array.indexOf((String) parent
						.getItemAtPosition(pos));
				data.setCodigo_do_municipio(cod_array.get(real_position));
				et_autode_de_codigo_do_municipio.setText(data
						.getCodigo_do_municipio());
				data.setUf(uf_array.get(real_position));
				auto_de_UF.setText(data.getUf());

			}
		});
	}

	@Override
	public void date(String dateOrtime) {
		if (dateOrtime != null) {
			data.setData(dateOrtime);
			btn_autode_date_picker.setText(data.getData());
		}
	}

	@Override
	public void time(String dateOrtime) {

		if (dateOrtime != null) {
			data.setHora(dateOrtime);
			btn_autode_time_picker.setText(data.getHora());
		}
	}

}
