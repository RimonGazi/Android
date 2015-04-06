/**
 * Load sqlite chipper library 
 * initialized all database object 
 * initialized all single tone object
 * 
 * 
 * 
 */

package net.sistransitomobile.main;

import net.sqlcipher.database.SQLiteDatabase;
import android.os.AsyncTask;

public class InstallTask extends AsyncTask<Void, Integer, Void> {

	private SplashPageFragment mActivity;

	public InstallTask(SplashPageFragment SplashPageFragment) {
		attach(SplashPageFragment);
	}

	void attach(SplashPageFragment activity) {
		this.mActivity = activity;

	}

	@Override
	protected Void doInBackground(Void... arg0) {

		publishProgress(50);

		try {
			SQLiteDatabase.loadLibs(mActivity.getActivity());
		} catch (Exception e) {

		}
		publishProgress(100);
		return null;
	}

	@Override
	protected void onProgressUpdate(Integer... progress) {
		if (mActivity == null) {
		} else {
			mActivity.updateProgress(progress[0]);
		}
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		if (mActivity == null) {
		} else {
			mActivity.markAsDone();
		}

	}

	void detach() {
		mActivity = null;
	}
}