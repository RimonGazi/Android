package com.rimon.rsa.ipaeps.module_7_mental_health_status;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockFragment;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appdatabase.SavePatientData;
import com.rimon.rsa.ipaeps.button.AnyButton;
import com.rimon.rsa.ipaeps.classtorun.ClassRunActivity;
import com.rimon.rsa.ipaeps.textview.AnyTextView;
import com.rimon.rsa.ipaeps.updatefragment.UpdateFragment;

import java.util.ArrayList;

public class Module7mhs_fragment_9 extends SherlockFragment implements
		UpdateFragment {

	private AnyButton btn_next;

	private LinearLayout lineraLayout_title_reuslt, tv_image_layout_parent,
			linerLayout_text_hint_leftside, linerLayout_image_hint_right_side;
	private AnyTextView tv_title, tv_sub_title, tv_footer;

	private ImageView im_rsult;

	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.module_7_mhs_fragment_9, null,
				false);

		lineraLayout_title_reuslt = (LinearLayout) view
				.findViewById(R.id.lineraLayout_title_reuslt);
		tv_image_layout_parent = (LinearLayout) view
				.findViewById(R.id.tv_image_layout_parent);
		linerLayout_text_hint_leftside = (LinearLayout) view
				.findViewById(R.id.linerLayout_text_hint_leftside);
		linerLayout_image_hint_right_side = (LinearLayout) view
				.findViewById(R.id.linerLayout_image_hint_right_side);

		tv_title = (AnyTextView) view.findViewById(R.id.tv_title);
		tv_sub_title = (AnyTextView) view.findViewById(R.id.tv_sub_title);
		// tv_result_description = (AnyTextView) view
		// .findViewById(R.id.tv_result_description);
		tv_footer = (AnyTextView) view.findViewById(R.id.tv_footer);
		im_rsult = (ImageView) view.findViewById(R.id.im_rsult);
		btn_next = (AnyButton) view.findViewById(R.id.btn_next);
		btn_next.setEnabled(true);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(getIntentToRun());
				getActivity().finish();
			}
		});

		return view;
	}

	@Override
	public void Update() {
		setUpResult();

	}

	private void setUpResult() {
		if (AppConstants.q_module_7_23_result_level
				.equals(Module7CalculateResult.module_7_result_level_green)) {

			lineraLayout_title_reuslt
					.setBackgroundResource(R.drawable.level_green_result);
			tv_title.setText(getActivity().getString(
					R.string.module_7_result_green_title));
			tv_sub_title.setText(getActivity().getString(
					R.string.module_7_result_green_sub_title));
			tv_footer.setText(getActivity().getString(
					R.string.module_7_result_green_footer));

			if (linerLayout_text_hint_leftside.getParent() != null) {
				tv_image_layout_parent
						.removeView(linerLayout_text_hint_leftside);
				linerLayout_image_hint_right_side.setWeightSum(1);
			}
			im_rsult.setImageDrawable(getResources().getDrawable(
					R.drawable.level_green_and_yellow_image));

		} else if (AppConstants.q_module_7_23_result_level
				.equals(Module7CalculateResult.module_7_result_level_yellow)) {

			lineraLayout_title_reuslt
					.setBackgroundResource(R.drawable.level_green_result);
			tv_title.setText(getActivity().getString(
					R.string.module_7_result_yellow_title));
			tv_sub_title.setText(getActivity().getString(
					R.string.module_7_result_yellow_sub_title));
			tv_footer.setText(getActivity().getString(
					R.string.module_7_result_yellow_footer));

			if (linerLayout_text_hint_leftside.getParent() != null) {
				tv_image_layout_parent
						.removeView(linerLayout_text_hint_leftside);
				linerLayout_image_hint_right_side.setWeightSum(1);
			}
			im_rsult.setImageDrawable(getResources().getDrawable(
					R.drawable.level_green_and_yellow_image));

		} else if (AppConstants.q_module_7_23_result_level
				.equals(Module7CalculateResult.module_7_result_level_red)) {

			lineraLayout_title_reuslt
					.setBackgroundResource(R.drawable.level_red_result);
			tv_title.setText(getActivity().getString(
					R.string.module_7_result_red_title));
			tv_sub_title.setText(getActivity().getString(
					R.string.module_7_result_red_sub_title));
			tv_footer.setText(getActivity().getString(
					R.string.module_7_result_red_footer));

			if (linerLayout_text_hint_leftside.getParent() == null) {
				tv_image_layout_parent.addView(linerLayout_text_hint_leftside);
				linerLayout_text_hint_leftside.setWeightSum(1);
				linerLayout_image_hint_right_side.setWeightSum(1);

			}
			im_rsult.setImageDrawable(getResources().getDrawable(
					R.drawable.level_red_image));
		}
	}

	@SuppressWarnings("unchecked")
	private Intent getIntentToRun() {
		Bundle bundleFrom = getActivity().getIntent().getExtras();
		int order_activity = bundleFrom.getInt("order");
		Log.d("pppppppppppppppppppppppppppppppppppp", order_activity + "");
		ArrayList<Class<?>> classes = (ArrayList<Class<?>>) bundleFrom
				.getSerializable(ClassRunActivity.RUNID);

		Intent intent = new Intent(getActivity(), classes.get(order_activity));

		Bundle bundleTo = new Bundle();
		bundleTo.putSerializable(ClassRunActivity.RUNID, classes);
		bundleTo.putInt("order", ++order_activity);
		intent.putExtras(bundleTo);
		if (order_activity == classes.size()) {
			(new SavePatientData(getActivity())).execute("");
		}
		return intent;
	}
}
