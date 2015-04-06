package net.sistransitomobile.appobject;

import net.sistransitimobile.http.CustomHttpClient;
import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.database.DatabaseCreator;
import net.sistransitomobile.main.R;
import android.app.Service;
import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AppObject {
	private static Vibrator vibrator;
	private static MediaPlayer mPlayer = null;

	private static CustomHttpClient customHttpClient;

	private static Animation slide_and_scale_animation = null;
	private static Typeface tf_normal, tf_current, tf_title;

	private AppObject(Context context) {
		getfont(context);
		slide_and_scale_animation = AnimationUtils.loadAnimation(context,
				R.anim.slide_and_scale);

		customHttpClient = new CustomHttpClient();
		mPlayer = MediaPlayer.create(context, R.raw.right_answer);
		vibrator = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);

	}

	public static Typeface getTf_normal(Context context) {
		if (tf_normal == null)
			tf_normal = Typeface.createFromAsset(context.getAssets(),
					"font/MuseoSans-300.ttf");
		return tf_normal;
	}

	public static Typeface getCurrentFont(Context context) {
		if (tf_current == null) {
			getfont(context);
		}
		return tf_current;
	}

	public static void getfont(Context context) {

		String font = (DatabaseCreator.getDatabaseAdapterSetting(context))
				.getFont();

		if ((font.equals(AppConstants.FONT_1))) {
			tf_current = Typeface.createFromAsset(context.getAssets(),
					"font/Roboto-Regular.ttf");
		} else if ((font.equals(AppConstants.FONT_2))) {
			tf_current = Typeface.createFromAsset(context.getAssets(),
					"font/Roboto-Regular.ttf");
		} else if ((font.equals(AppConstants.FONT_3))) {
			tf_current = Typeface.createFromAsset(context.getAssets(),
					"font/Roboto-Regular.ttf");
		} else {
			tf_current = Typeface.DEFAULT;
		}
	}

	public static Typeface getTitlefont(Context context) {

		tf_title = Typeface.createFromAsset(context.getAssets(),
				"font/Roboto-Regular.ttf");
		return tf_title;

	}

	public static void setfont(Context context, String font) {
		(DatabaseCreator.getDatabaseAdapterSetting(context)).setFont(font);
		getfont(context);
	}

	public static Animation getSlideAndScaleAnimition(Context context) {
		if (slide_and_scale_animation == null) {
			slide_and_scale_animation = AnimationUtils.loadAnimation(context,
					R.anim.slide_and_scale);
			return slide_and_scale_animation;
		}
		return slide_and_scale_animation;

	}

	public static CustomHttpClient getHttpClient() {
		if (customHttpClient == null) {
			customHttpClient = new CustomHttpClient();
		}
		return customHttpClient;
	}

	public static void startWarning(Context context) {
		if (mPlayer == null) {
			mPlayer = MediaPlayer.create(context, R.raw.right_answer);
		}
		mPlayer.start();
	}

	public static void startVibrate(Context context) {
		vibrator = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		vibrator.vibrate(3000);
	}

}
