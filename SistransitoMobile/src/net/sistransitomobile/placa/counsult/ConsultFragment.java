package net.sistransitomobile.placa.counsult;

import net.sistransitimobile.network.NetworkConnection;
import net.sistransitomobile.autode.AutoDeActivity;
import net.sistransitomobile.autode.AutoDeData;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.fragment.AnyDiaglog;
import net.sistransitomobile.main.R;
import net.sistransitomobile.placa.data.PlacaHttpResultAnysTask;
import net.sistransitomobile.placa.data.PlacaRawFormat;
import net.sistransitomobile.placa.data.PlacaViewFormat;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import com.actionbarsherlock.app.SherlockFragment;

public class ConsultFragment extends SherlockFragment implements
		OnClickListener {

	private View view;
	private LinearLayout ll_parent_rsult_view, ll_child_reult_view;
	private TextView tv_result_show;
	private Button btn_autuar, btn_consultar;
	private EditText et_input_chracter, et_input_number;
	private CheckBox cb_offline_search;
	private String placa;
	private final int PLACA_CHARACTER_LENGTH = 3;
	private final int PLACA_NUMBER_LENGTH = 4;
	private InputMethodManager imm;
	private PlacaHttpResultAnysTask httpResultAnysTask;
	private EditTextCahnge et_charater, et_number;
	private Boolean text_change_statte = true;
	private PlacaRawFormat placaRawFormat_main;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.consult_fragment, null, false);
		imm = (InputMethodManager) getActivity().getSystemService(
				Context.INPUT_METHOD_SERVICE);
		initilizedView();
		return view;
	}

	private void initilizedView() {
		ll_parent_rsult_view = (LinearLayout) view
				.findViewById(R.id.ll_parent_rsult_view);
		ll_child_reult_view = (LinearLayout) view
				.findViewById(R.id.ll_child_reult_view);
		tv_result_show = (TextView) view.findViewById(R.id.tv_result_show);
		tv_result_show.setOnClickListener(this);
		btn_autuar = (Button) view.findViewById(R.id.btn_autuar);
		btn_autuar.setOnClickListener(this);
		btn_consultar = (Button) view.findViewById(R.id.btn_consultar);
		btn_consultar.setOnClickListener(this);
		et_input_chracter = (EditText) view
				.findViewById(R.id.et_input_chracter);
		et_input_number = (EditText) view.findViewById(R.id.et_input_number);
		cb_offline_search = (CheckBox) view
				.findViewById(R.id.cb_offline_search);
		reomoveResultView();
		et_charater = new EditTextCahnge(R.id.et_input_chracter);
		et_number = new EditTextCahnge(R.id.et_input_number);
		et_input_chracter.addTextChangedListener(et_charater);
		et_input_number.addTextChangedListener(et_number);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_consultar:
			if (iSVehicalSearch()) {
				getVehicaleResult();

			}
			break;

		case R.id.tv_result_show:
			reomoveResultView();
			enableSearch();
			break;

		case R.id.btn_autuar:
			if (placaRawFormat_main != null) {

				if ((DatabaseCreator
						.getDatabaseAdapterAutoInfracao(getActivity()))
						.isSamePlacaExit(placaRawFormat_main.getPLATE())) {
					openAutode((DatabaseCreator
							.getDatabaseAdapterAutoInfracao(getActivity()))
							.getAutodeDataFromPlaca(placaRawFormat_main
									.getPLATE()));

				} else {
					AutoDeData data = new AutoDeData();
					data.setPlate(placaRawFormat_main.getPLATE());
					data.setModel(placaRawFormat_main.getMODEL());
					data.setCor_do_veiculo(placaRawFormat_main.getCOLOR());
					data.setStoreFullData(false);
					openAutode(data);

				}

			}
		}

	}

	private void getVehicaleResult() {

		httpResultAnysTask = new PlacaHttpResultAnysTask(
				new net.sistransitomobile.fragment.FragmentCallBack() {

					@Override
					public void CallBack(PlacaRawFormat placaRawFormat,
							boolean isOffline) {
						Log.d("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "1");
						resultCallBack(placaRawFormat, isOffline);

					}
				}, getActivity(), isOfflineSearch(), (placa));
		httpResultAnysTask.execute("");

	}

	private void addResultView() {
		if (ll_child_reult_view.getParent() == null) {
			ll_parent_rsult_view.addView(ll_child_reult_view);
		}
	}

	private void reomoveResultView() {
		if (ll_child_reult_view.getParent() != null) {
			ll_parent_rsult_view.removeView(ll_child_reult_view);
		}

	}

	private boolean iSVehicalSearch() {

		if (checkInput()) {
			if (isOfflineSearch()) {
				return true;
			} else {
				if (isInternetConnected()) {
					return true;
				} else {
					AnyDiaglog.DialogShow(
							getResources().getString(R.string.sem_conexao),
							getActivity());
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private boolean isOfflineSearch() {
		return cb_offline_search.isChecked() ? true : false;
	}

	private boolean isInternetConnected() {
		return NetworkConnection.isNetworkAvailable(getActivity());
	}

	public void resultCallBack(PlacaRawFormat placaRawFormat, boolean isOffline) {
		placaRawFormat_main = null;

		if (placaRawFormat != null) {

			this.placaRawFormat_main = placaRawFormat;
			PlacaViewFormat placaViewFormat = new PlacaViewFormat(
					placaRawFormat, getActivity());
			addResultView();

			tv_result_show.setText(placaViewFormat.getResultViewData(),
					BufferType.SPANNABLE);
			placaViewFormat.setWarning();
			addResultView();
			diableSearch();
			btn_autuar.setEnabled(true);

		} else {
			tv_result_show.setText(getResources().getString(
					R.string.no_result_found));
			btn_autuar.setEnabled(false);
			addResultView();
			diableSearch();
		}
	}

	// after result enable all search helper view ;
	private void enableSearch() {
		btn_consultar.setEnabled(true);
		et_input_chracter.setEnabled(true);
		et_input_number.setEnabled(true);
		cb_offline_search.setEnabled(true);

	}

	// after show search result disable all search helper view ;
	private void diableSearch() {
		btn_consultar.setEnabled(false);
		et_input_chracter.setEnabled(false);
		et_input_number.setEnabled(false);
		cb_offline_search.setEnabled(false);
		text_change_statte = false;
		et_input_number.setText("");
		et_input_chracter.setText("");
		text_change_statte = true;

	}

	// check input if the number length is 4 and character length is 3
	private boolean checkInput() {
		String chareter = et_input_chracter.getText().toString().trim();
		String number = et_input_number.getText().toString().trim();
		placa = chareter + number;
		if (chareter.length() != PLACA_CHARACTER_LENGTH) {
			et_input_chracter.setError(getResources().getString(
					R.string.p_first_three_letter));
			et_input_chracter.requestFocus();
			return false;
		} else if (number.length() != PLACA_NUMBER_LENGTH) {
			et_input_number.setError(getResources().getString(
					R.string.p_last_four_number));
			et_input_number.requestFocus();
			return false;
		} else {
			return true;
		}
	}

	private class EditTextCahnge implements TextWatcher {
		private int id;

		public EditTextCahnge(int id) {
			this.id = id;
		}

		@Override
		public void afterTextChanged(Editable text) {
			if (text_change_statte) {

				switch (id) {
				case R.id.et_input_chracter:

					et_input_chracter.setError(null);
					if (text.toString().length() == PLACA_CHARACTER_LENGTH) {
						if (et_input_number.getText().toString().length() != PLACA_NUMBER_LENGTH) {
							et_input_number.requestFocus();
						} else {
							imm.hideSoftInputFromWindow(
									btn_consultar.getWindowToken(), 0);
							btn_consultar.setFocusableInTouchMode(true);
							btn_consultar.requestFocus();
						}
					}

					break;
				case R.id.et_input_number:

					et_input_number.setError(null);
					if (text.toString().length() == PLACA_NUMBER_LENGTH) {
						if (et_input_chracter.getText().toString().length() != PLACA_CHARACTER_LENGTH) {
							et_input_chracter.requestFocus();
						} else {
							imm.hideSoftInputFromWindow(
									btn_consultar.getWindowToken(), 0);
							btn_consultar.setFocusableInTouchMode(true);
							btn_consultar.requestFocus();
						}
					}

					break;

				}
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

	private void openAutode(AutoDeData data) {
		Intent intent = new Intent(getActivity(), AutoDeActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable(AutoDeData.getAutoDeId(), data);
		intent.putExtras(bundle);
		startActivity(intent);
	}

}
