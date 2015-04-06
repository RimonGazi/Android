package com.rimon.rsa.ipaeps.googleCoudePrint;

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
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.actionbarsherlock.app.SherlockActivity;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.actionbar.CustomActionBar;
import com.rimon.rsa.ipaeps.appconstants.AppConstants;

public class PrintDialogActivity extends SherlockActivity {
	private static final String PRINT_DIALOG_URL = "https://www.google.com/cloudprint/dialog.html";
	private static final String JS_INTERFACE = "AndroidPrintDialog";
	private static final String CONTENT_TRANSFER_ENCODING = "base64";
	private static final String ZXING_URL = "http://zxing.appspot.com";
	private static final int ZXING_SCAN_REQUEST = 65743;
	private static final String CLOSE_POST_MESSAGE_NAME = "cp-dialog-on-close";

	private WebView dialogWebView;
	private Intent cloudPrintIntent;

	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.print_dialog);
		actionberSetUp();
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
		@JavascriptInterface
		public String getType() {
			return cloudPrintIntent.getType();
		}

		@JavascriptInterface
		public String getTitle() {
			return cloudPrintIntent.getExtras().getString(
					AppConstants.DIAGLOG_TITLE_ID);
		}

		@JavascriptInterface
		public String getContent() {

			Log.d("DDDDDDDDDDDDDDDDDDD", "dddddddddddddddddddd");
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

		@JavascriptInterface
		public String getEncoding() {
			return CONTENT_TRANSFER_ENCODING;
		}

		@JavascriptInterface
		public void onPostMessage(String message) {
			if (message.startsWith(CLOSE_POST_MESSAGE_NAME)) {
				Log.d("onfinsh", "onfinsh");
				File file = new File(
						cloudPrintIntent
								.getStringExtra(AppConstants.DIAGLOG_FILE));
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

		CustomActionBar actionBar = new CustomActionBar(
				PrintDialogActivity.this);
		actionBar.setupActionBarWithBack(getSupportActionBar(),
				R.drawable.ic_print_p, R.string.print_2);

	}

	@Override
	protected void onDestroy() {
		File file = new File(
				cloudPrintIntent.getStringExtra(AppConstants.DIAGLOG_FILE));
		file.delete();
		super.onDestroy();
	}
}