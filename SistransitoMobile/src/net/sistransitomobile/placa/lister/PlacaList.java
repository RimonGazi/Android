package net.sistransitomobile.placa.lister;

import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.main.R;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class PlacaList extends SherlockActivity implements OnClickListener {
	private PlacaListerExpandableAdapter expandableAdapter;
	private ExpandableListView expandableListView;

	private ImageButton im_btn_delete, im_btn_back;
	public static Boolean CallSecondActivity = false;
	private TextView tvMessage;
	private RelativeLayout placa_lister_layout;
	private Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.placa_lister_main);
		initializedView();
	}

	private void initializedView() {
		im_btn_back = (ImageButton) findViewById(R.id.im_btn_back);
		im_btn_back.setOnClickListener(this);
		im_btn_delete = (ImageButton) findViewById(R.id.im_btn_delete);
		im_btn_delete.setOnClickListener(this);
		if (checCursor()) {
			addResultView();
		} else {
			addNoResultView();
		}
	}

	private boolean checCursor() {
		cursor = (DatabaseCreator.getPlacaSearchDatabaseAdapter(PlacaList.this))
				.getAllPlacaCursor();
		return cursor.getCount() > 0;
	}

	private void addNoResultView() {
		placa_lister_layout = (RelativeLayout) findViewById(R.id.placa_lister_layout);
		im_btn_delete.setEnabled(false);
		cursor.close();
		tvMessage = new TextView(this);
		tvMessage.setText(getResources().getString(R.string.no_result_found));
		tvMessage.setGravity(Gravity.CENTER);
		tvMessage.setTextAppearance(this, android.R.style.TextAppearance_Large);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		tvMessage.setLayoutParams(params);
		tvMessage.setTextColor(getResources().getColor(R.color.line_color));
		if (tvMessage.getParent() == null) {
			placa_lister_layout.addView(tvMessage);
		}
	}

	private void addResultView() {
		expandableAdapter = new PlacaListerExpandableAdapter(cursor,
				PlacaList.this);
		expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewPlaca);
		expandableListView.setAdapter(expandableAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_btn_back:
			finish();
			break;
		case R.id.im_btn_delete:
			finish();
			startActivity(new Intent(PlacaList.this, PlacaListerDelete.class));
			break;

		}
	}

}
