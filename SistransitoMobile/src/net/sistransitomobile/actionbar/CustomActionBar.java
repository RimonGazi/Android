package net.sistransitomobile.actionbar;

import net.sistransitomobile.main.R;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.actionbarsherlock.app.SherlockActivity;

public class CustomActionBar {
	private SherlockActivity context;
	private View localView;
	private ImageButton im_btn_back;
	public CustomActionBar(SherlockActivity geActivity) {
		this.context = geActivity;
	}
	public void setupActionBarWithBack() {
		localView = context.getLayoutInflater().inflate(
				R.layout.action_bar_back_login, null);
		im_btn_back = (ImageButton) localView.findViewById(R.id.im_btn_back);
		im_btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				context.finish();
				Log.d("FFFFFFFFFFFFFFFF	", "fffffffff");
			}
		});
	}

}
