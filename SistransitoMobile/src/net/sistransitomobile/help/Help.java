package net.sistransitomobile.help;

import net.sistransitomobile.main.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class Help extends SherlockActivity {
	private ImageButton im_btn_back;
	private TextView tv_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		actionbarSetup();
	}

	private void actionbarSetup() {
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText(getResources().getString(R.string.help));
		im_btn_back = (ImageButton) findViewById(R.id.im_btn_back);
		im_btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

}
