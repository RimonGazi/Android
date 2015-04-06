package com.rimon.rsa.ipaeps.appobject;

import android.content.Context;
import android.graphics.Typeface;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;
import com.rimon.rsa.ipaeps.appdatabase.DatabaseCreator;
import com.rimon.rsa.ipaeps.appdatabase.PpSettingModuleDBOpenHelper;

public class AppObject {
	private static Animation layout_scale_in = null;
	private static Typeface tf_normal, tf_current;
	private static Typeface tf_title;
	static int i = 1;

	private AppObject(Context context) {
		layout_scale_in = AnimationUtils
				.loadAnimation(context, R.anim.slide_in);
		// tf_normal = Typeface.createFromAsset(context.getAssets(),
		// "font/MuseoSans-300.ttf");
		// tf_title = Typeface.createFromAsset(context.getAssets(),
		// "font/Courgette-Regular.ttf");
		//
		// tf_current = Typeface.createFromAsset(context.getAssets(),
		// "font/Courgette-Regular.ttf");
		getfont(context);

	}

	public static Typeface getTf_normal(Context context) {
		if (tf_normal == null)
			tf_normal = Typeface.createFromAsset(context.getAssets(),
					"font/MuseoSans-300.ttf");
		return tf_normal;
	}

	public static Typeface getTf_title(Context context) {
		if (tf_title == null)
			tf_title = Typeface.createFromAsset(context.getAssets(),
					"font/Courgette-Regular.ttf");

		return tf_title;
	}

	public static Animation getScaleAnimition(Context context) {
		if (layout_scale_in == null) {
			layout_scale_in = AnimationUtils.loadAnimation(context,
					R.anim.slide_in);
			return layout_scale_in;
		}
		return layout_scale_in;

	}

	public static Typeface getCurrentFont(Context context) {
		if (tf_current == null) {
			getfont(context);
		}
		return tf_current;
	}

	public static void getfont(Context context) {

		PpSettingModuleDBOpenHelper dbOpenHelper = DatabaseCreator
				.getPpSettingModuleDBOpenHelper(context);

		if ((dbOpenHelper.getFont()).equals(AppConstants.FONT_1)) {

			tf_current = Typeface.createFromAsset(context.getAssets(),
					"font/Courgette-Regular.ttf");
		} else if ((dbOpenHelper.getFont()).equals(AppConstants.FONT_2)) {
			tf_current = Typeface.createFromAsset(context.getAssets(),
					"font/MuseoSans-300.ttf");
		} else {
			tf_current = Typeface.DEFAULT;

		}
	}

	public static void setfont(Context context, String font) {
		PpSettingModuleDBOpenHelper dbOpenHelper = DatabaseCreator
				.getPpSettingModuleDBOpenHelper(context);
		dbOpenHelper.setFont(font);
		getfont(context);
	}

}
