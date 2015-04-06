package com.android.rsa.googlecludeprint;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.rimon.rsa.mental.R;

public class PrintDialogActivity extends SherlockActivity {
	private static final String PRINT_DIALOG_URL = "https://www.google.com/cloudprint/dialog.html";
	private static final String JS_INTERFACE = "AndroidPrintDialog";
	private static final String CONTENT_TRANSFER_ENCODING = "base64";

	private static final String ZXING_URL = "http://zxing.appspot.com";
	private static final int ZXING_SCAN_REQUEST = 65743;

	// private String file_name_print;

	/**
	 * Post message that is sent by Print Dialog web page when the printing
	 * dialog needs to be closed.
	 */
	private static final String CLOSE_POST_MESSAGE_NAME = "cp-dialog-on-close";

	/**
	 * Web view element to show the printing dialog in.
	 */
	private WebView dialogWebView;

	/**
	 * Intent that started the action.
	 */
	Intent cloudPrintIntent;

	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		actionberSetUp();
		setContentView(R.layout.print_dialog);
		Log.d("onCreate", "onCreate");
		dialogWebView = (WebView) findViewById(R.id.webview);
		cloudPrintIntent = this.getIntent();

		WebSettings settings = dialogWebView.getSettings();
		settings.setJavaScriptEnabled(true);

		dialogWebView.setWebViewClient(new PrintDialogWebClient());
		dialogWebView.addJavascriptInterface(
				new PrintDialogJavaScriptInterface(), JS_INTERFACE);
		dialogWebView.loadUrl(PRINT_DIALOG_URL);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == ZXING_SCAN_REQUEST && resultCode == RESULT_OK) {
			dialogWebView.loadUrl(intent.getStringExtra("SCAN_RESULT"));

			Log.d("onActivityResult", "onActivityResult");
		}
	}

	final class PrintDialogJavaScriptInterface {
		public String getType() {
			return cloudPrintIntent.getType();
		}

		public String getTitle() {
			return cloudPrintIntent.getExtras().getString("title");
		}

		public String getContent() {
			try {
				ContentResolver contentResolver = getContentResolver();
				InputStream is = contentResolver
						.openInputStream(cloudPrintIntent.getData());
				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				byte[] buffer = new byte[4096];
				int n = is.read(buffer);
				while (n >= 0) {
					baos.write(buffer, 0, n);
					n = is.read(buffer);
				}
				is.close();
				Log.d("ssssssssssssssss", baos.toString());
				baos.flush();

				return Base64
						.encodeToString(baos.toByteArray(), Base64.DEFAULT);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}

		public String getEncoding() {
			return CONTENT_TRANSFER_ENCODING;
		}

		public void onPostMessage(String message) {
			if (message.startsWith(CLOSE_POST_MESSAGE_NAME)) {
				Log.d("onfinsh", "onfinsh");
				File file = new File(
						cloudPrintIntent.getStringExtra("file_name"));
				file.delete();
				finish();
			}
		}
	}

	private final class PrintDialogWebClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (url.startsWith(ZXING_URL)) {
				Intent intentScan = new Intent(
						"com.google.zxing.client.android.SCAN");
				intentScan.putExtra("SCAN_MODE", "QR_CODE_MODE");
				try {
					startActivityForResult(intentScan, ZXING_SCAN_REQUEST);
				} catch (ActivityNotFoundException error) {
					view.loadUrl(url);
				}
			} else {
				view.loadUrl(url);
			}
			return false;
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			if (PRINT_DIALOG_URL.equals(url)) {
				// Submit print document.
				view.loadUrl("javascript:printDialog.setPrintDocument(printDialog.createPrintDocument("
						+ "window."
						+ JS_INTERFACE
						+ ".getType(),window."
						+ JS_INTERFACE
						+ ".getTitle(),"
						+ "window."
						+ JS_INTERFACE
						+ ".getContent(),window."
						+ JS_INTERFACE
						+ ".getEncoding()))");

				// Add post messages listener.
				view.loadUrl("javascript:window.addEventListener('message',"
						+ "function(evt){window." + JS_INTERFACE
						+ ".onPostMessage(evt.data)}, false)");
			}
		}
	}

	private void actionberSetUp() {
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View view = getLayoutInflater().inflate(R.layout.custom_action_bar,
				null);
		getSupportActionBar().setCustomView(
				view,
				new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
						ActionBar.LayoutParams.MATCH_PARENT));
		ImageButton back = (ImageButton) view.findViewById(R.id.back);
		TextView tv_title = (TextView) view.findViewById(R.id.actionber_tv);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {
					File file = new File(cloudPrintIntent
							.getStringExtra("file_name"));
					file.delete();
				} catch (Exception e) {
					// TODO: handle exception
				}
				finish();

			}
		});

		tv_title.setText("Print");
	}
}