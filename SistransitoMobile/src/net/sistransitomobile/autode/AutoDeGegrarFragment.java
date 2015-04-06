package net.sistransitomobile.autode;

import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.fragment.UpdateFragment;
import net.sistransitomobile.main.R;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockFragment;

public class AutoDeGegrarFragment extends SherlockFragment implements
		OnClickListener, OnCheckedChangeListener, UpdateFragment {
	private View view;
	private CheckBox checkBox_autode_CLRV, checkBox_autode_CNH,
			checkBox_autode_PPD, checkBox_autode_remocao,
			checkBox_autode_retencao;
	private EditText et_autode_observacao, et_autode_identificacao_embracador,
			et_autode_CNPJ_CPF_embracador,
			et_autode_identificacao_do_transportadfor,
			et_autode_CNPJ_CPF_transportadfor;
	private Button btn_autode_conferir, btn_autode_gerar;
	private AutoDeData data;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.auto_de_gerar_fragment, null, false);
		initializedView();
		getAutodeObject();
		return view;
	}

	private void addListener() {
		checkBox_autode_retencao.setOnCheckedChangeListener(this);
		checkBox_autode_remocao.setOnCheckedChangeListener(this);
		checkBox_autode_CLRV.setOnCheckedChangeListener(this);
		checkBox_autode_CNH.setOnCheckedChangeListener(this);
		checkBox_autode_CNH.setOnCheckedChangeListener(this);

		et_autode_observacao.addTextChangedListener(new ChangeText(
				R.id.et_autode_observacao));

		et_autode_identificacao_embracador
				.addTextChangedListener(new ChangeText(
						R.id.et_autode_identificacao_embracador));

		et_autode_CNPJ_CPF_embracador.addTextChangedListener(new ChangeText(
				R.id.et_autode_CNPJ_CPF_embracador));

		et_autode_identificacao_do_transportadfor
				.addTextChangedListener(new ChangeText(
						R.id.et_autode_identificacao_do_transportadfor));

		et_autode_CNPJ_CPF_transportadfor
				.addTextChangedListener(new ChangeText(
						R.id.et_autode_CNPJ_CPF_transportadfor));

		btn_autode_conferir.setOnClickListener(this);
		btn_autode_gerar.setOnClickListener(this);
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

		checkBox_autode_retencao.setChecked(false);
		checkBox_autode_remocao.setChecked(false);
		checkBox_autode_CLRV.setChecked(false);
		checkBox_autode_CNH.setChecked(false);
		checkBox_autode_CNH.setChecked(false);
		et_autode_observacao.setText("");
		et_autode_identificacao_embracador.setText("");
		et_autode_CNPJ_CPF_embracador.setText("");
		et_autode_identificacao_do_transportadfor.setText("");
		et_autode_CNPJ_CPF_transportadfor.setText("");
	}

	private void getRecomandedUpdate() {
		if (data.getClrv().compareTo(AppConstants.cross) == 0) {
			checkBox_autode_CLRV.setChecked(false);
		} else {
			checkBox_autode_CLRV.setChecked(true);
		}

		if (data.getCnh().compareTo(AppConstants.cross) == 0) {
			checkBox_autode_CNH.setChecked(false);
		} else {
			checkBox_autode_CNH.setChecked(true);
		}
		if (data.getPpd().compareTo(AppConstants.cross) == 0) {
			checkBox_autode_PPD.setChecked(false);
		} else {
			checkBox_autode_PPD.setChecked(true);
		}
		if (data.getRemocao().compareTo(AppConstants.cross) == 0) {
			checkBox_autode_remocao.setChecked(false);
		} else {
			checkBox_autode_remocao.setChecked(true);
		}
		if (data.getRetencao().compareTo(AppConstants.cross) == 0) {
			checkBox_autode_retencao.setChecked(false);
		} else {
			checkBox_autode_retencao.setChecked(true);
		}

		et_autode_observacao.setText(data.getObservacao());
		et_autode_identificacao_embracador.setText(data
				.getIdetificacao_embracador());
		et_autode_CNPJ_CPF_embracador.setText(data.getCnpj_cpf_embracador());
		et_autode_identificacao_do_transportadfor.setText(data
				.getIdentificacao_do_transportadfor());
		et_autode_CNPJ_CPF_transportadfor.setText(data
				.getCnpj_cpf_transportadfor());

	}

	private void initializedView() {

		checkBox_autode_CLRV = (CheckBox) view
				.findViewById(R.id.checkBox_autode_CLRV);
		checkBox_autode_CNH = (CheckBox) view
				.findViewById(R.id.checkBox_autode_CNH);
		checkBox_autode_PPD = (CheckBox) view
				.findViewById(R.id.checkBox_autode_PPD);
		checkBox_autode_remocao = (CheckBox) view
				.findViewById(R.id.checkBox_autode_remocao);
		checkBox_autode_retencao = (CheckBox) view
				.findViewById(R.id.checkBox_autode_retencao);

		et_autode_observacao = (EditText) view
				.findViewById(R.id.et_autode_observacao);
		et_autode_identificacao_embracador = (EditText) view
				.findViewById(R.id.et_autode_identificacao_embracador);
		et_autode_CNPJ_CPF_embracador = (EditText) view
				.findViewById(R.id.et_autode_CNPJ_CPF_embracador);
		et_autode_identificacao_do_transportadfor = (EditText) view
				.findViewById(R.id.et_autode_identificacao_do_transportadfor);
		et_autode_CNPJ_CPF_transportadfor = (EditText) view
				.findViewById(R.id.et_autode_CNPJ_CPF_transportadfor);

		btn_autode_conferir = (Button) view
				.findViewById(R.id.btn_autode_conferir);
		btn_autode_gerar = (Button) view.findViewById(R.id.btn_autode_gerar);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_autode_conferir:

			break;

		case R.id.btn_autode_gerar:

			break;
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton view, boolean isChecked) {

		switch (view.getId()) {
		case R.id.checkBox_autode_CLRV:
			if (isChecked) {
				data.setClrv(AppConstants.Right);
			} else {
				data.setClrv(AppConstants.cross);
			}
			break;

		case R.id.checkBox_autode_CNH:
			if (isChecked) {
				data.setCnh(AppConstants.Right);
			} else {
				data.setCnh(AppConstants.cross);
			}
			break;

		case R.id.checkBox_autode_PPD:
			if (isChecked) {
				data.setPpd(AppConstants.Right);
			} else {
				data.setPpd(AppConstants.cross);
			}
			break;

		case R.id.checkBox_autode_remocao:
			if (isChecked) {
				data.setRemocao(AppConstants.Right);
			} else {
				data.setRemocao(AppConstants.cross);
			}
			break;

		case R.id.checkBox_autode_retencao:
			if (isChecked) {
				data.setRetencao(AppConstants.Right);
			} else {
				data.setRetencao(AppConstants.cross);
			}
			break;
		}
	}

	private class ChangeText implements TextWatcher {
		private int id;

		public ChangeText(int id) {
			this.id = id;
		}

		@Override
		public void afterTextChanged(Editable s) {
			switch (id) {
			case R.id.et_autode_observacao:
				data.setObservacao(s.toString());
				break;
			case R.id.et_autode_identificacao_embracador:
				data.setIdetificacao_embracador(s.toString());
				break;
			case R.id.et_autode_CNPJ_CPF_embracador:
				data.setCnpj_cpf_embracador(s.toString());
				break;
			case R.id.et_autode_identificacao_do_transportadfor:
				data.setIdentificacao_do_transportadfor(s.toString());
				break;
			case R.id.et_autode_CNPJ_CPF_transportadfor:
				data.setCnpj_cpf_transportadfor(s.toString());
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
	public void Update() {
		String s=data.getObservacao();
		et_autode_observacao.setText(s);
	}
}
