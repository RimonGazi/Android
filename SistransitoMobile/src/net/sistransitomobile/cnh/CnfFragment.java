package net.sistransitomobile.cnh;

import net.sistransitimobile.network.NetworkConnection;
import net.sistransitomobile.fragment.CNHFragmentCallBack;
import net.sistransitomobile.main.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class CnfFragment extends SherlockFragment implements
		android.view.View.OnClickListener {
	private View view;
	private Button btn_consultar;
	private LinearLayout ll_result_parent;
	private TextView tv_result_show;
	private EditText et_input;
	private InputMethodManager imm;
	private final String CNH_URL = "http://sistransito.net/movel/dosis.pl?op=cnh&dadoscnh=";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.cnh_fragment, null, false);
		imm = (InputMethodManager) getActivity().getSystemService(
				Context.INPUT_METHOD_SERVICE);
		initializedView();
		return view;
	}

	private void initializedView() {
		btn_consultar = (Button) view.findViewById(R.id.btn_consultar);
		btn_consultar.setOnClickListener(this);
		ll_result_parent = (LinearLayout) view
				.findViewById(R.id.ll_result_parent);
		tv_result_show = (TextView) view.findViewById(R.id.tv_result_show);
		tv_result_show.setOnClickListener(this);
		et_input = (EditText) view.findViewById(R.id.et_input);
		removeResultView();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_result_show:
			removeResultView();
			enableSearchButton();
			break;
		case R.id.btn_consultar:
			if (!et_input.getText().toString().equals("")) {
				if (NetworkConnection.isNetworkAvailable(getActivity())) {
					imm.hideSoftInputFromWindow(btn_consultar.getWindowToken(),
							0);
					new CnhHttpResultAnysTask(new CNHFragmentCallBack() {

						@Override
						public void CallBack(CnhFormat cnhFormat) {
							addResult(cnhFormat);
						}
					}, getActivity(), (CNH_URL + et_input.getText().toString()))
							.execute("");

				} else {
					showMessage(getResources().getString(R.string.sem_conexao));
				}
			} else {
				et_input.setError(getResources().getString(
						R.string.please_enter_cnh_uer_name));

			}
		}
	}

	private void removeResultView() {
		if (tv_result_show.getParent() != null)
			ll_result_parent.removeView(tv_result_show);

	}

	private void addResultView() {
		if (tv_result_show.getParent() == null)
			ll_result_parent.addView(tv_result_show);

	}

	private void showMessage(String mgs) {
		Toast.makeText(getActivity(), mgs, Toast.LENGTH_LONG).show();

	}

	private void addResult(CnhFormat cnhFormat) {

		if (cnhFormat != null) {
			tv_result_show.setText(cnhFormat.getCnhFormatSpanable(),
					BufferType.SPANNABLE);
			cnhFormat.setWarrning();
		} else {
			tv_result_show.setText(getResources().getString(
					R.string.no_result_found));
		}
		addResultView();
		disableSearchButton();

	}

	private void disableSearchButton() {
		et_input.setEnabled(false);
		btn_consultar.setEnabled(false);
		et_input.setText("");
	}

	private void enableSearchButton() {
		et_input.setEnabled(true);
		btn_consultar.setEnabled(true);
	}

}
