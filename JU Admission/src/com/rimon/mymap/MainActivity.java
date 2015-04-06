package com.rimon.mymap;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rimon.rsa.juadmissiontest.ConstandValue;
import com.tyczj.mapnavigator.Navigator;

public class MainActivity extends SherlockFragmentActivity implements
		LocationListener {
	static GoogleMap map;
	ArrayList<LatLng> markerPoints;

	LocationManager locationManager;
	String provider;
	LatLng myPosition;
	Location location;
	Navigator navigator;
	boolean zoomCondition = true;
	boolean circleCondition = true;
	Marker my_position_maker;
	Marker mPositionMarker;
	private TextView tv_distance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		location = null;
		map = null;
		provider = null;
		navigator = null;
		locationManager = null;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
		// getSupportActionBar().setLogo(R.drawable.icon);

		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionber_icon));
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowCustomEnabled(true);

		try {
			if (map == null) {
				map = ((SupportMapFragment) getSupportFragmentManager()
						.findFragmentById(R.id.map)).getMap();
				map.setMyLocationEnabled(true);
				map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

				locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
				Criteria criteria = new Criteria();
				provider = locationManager.getBestProvider(criteria, true);
				location = locationManager.getLastKnownLocation(provider);
				// // if (location != null) {
				onLocationChanged(location);
				//
				// }

				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 0, 0, this);
				locationManager.requestLocationUpdates(
						LocationManager.NETWORK_PROVIDER, 0, 0, this);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void zoomIn(double Lat, double Long, float z_leve) {
		CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(Lat,
				Long));

		CameraUpdate zoom = CameraUpdateFactory.zoomTo(z_leve);

		if (zoomCondition) {
			map.moveCamera(center);
			zoomCondition = false;
		}
		map.animateCamera(zoom);

	}

	public void circleDraw(double i, double ii) {

		map.addCircle(new CircleOptions().center(new LatLng(i, ii))
				.radius(1000).strokeColor(Color.BLACK).strokeWidth(2)
				.fillColor(Color.argb(50, 238, 116, 116)));
	}

	@Override
	public void onLocationChanged(Location location) {
		// map.clear();// clean the map
		if (location == null)
			return;

		double latitude = location.getLatitude();
		double longitude = location.getLongitude();
		myPosition = new LatLng(latitude, longitude);

		if (circleCondition) {

			Log.d("value", ConstandValue.lat + " " + ConstandValue.lat);
			if (ConstandValue.lat == 0.0 || ConstandValue.lon == 0.0) {
				tv_distance.setText("Distance not available !");
			} else {
				DecimalFormat df = new DecimalFormat("###.##");
				tv_distance = (TextView) findViewById(R.id.tv_distance_map);
				tv_distance.setText("Distance "
						+ df.format(distance(latitude, longitude,
								ConstandValue.lat, ConstandValue.lon)) + " KM");
			}
			circleCondition = false;
			LatLng destinationPosition = new LatLng(ConstandValue.lat,
					ConstandValue.lon);
			Log.d("consddd", ConstandValue.lat + "  " + ConstandValue.lon);

			// Toast.makeText(this, "Location Changed",
			// Toast.LENGTH_SHORT).show();
			map.addMarker(new MarkerOptions()
					.position(destinationPosition)
					.title("Destination")
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.m_my_position)));

			circleDraw(latitude, longitude);
			zoomIn(latitude, longitude, 14.0f);
			
			navigator = new Navigator(map, new LatLng(
					location.getLatitude(), location.getLongitude()),
					destinationPosition);
			navigator.findDirections(true);

			if (mPositionMarker == null) {

				mPositionMarker = map.addMarker(new MarkerOptions()
						.flat(true)
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.destination_m))
						.anchor(0.5f, 0.5f)
						.position(
								new LatLng(location.getLatitude(), location
										.getLongitude())));

				
			}

		} else {
			zoomIn(latitude, longitude, map.getCameraPosition().zoom);

			if (mPositionMarker == null) {

				mPositionMarker = map.addMarker(new MarkerOptions()
						.flat(true)
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.destination_m))
						.anchor(0.5f, 0.5f)
						.position(
								new LatLng(location.getLatitude(), location
										.getLongitude())));

				// map.animateCamera(CameraUpdateFactory.newLatLng(new
				// LatLng(location
				// .getLatitude(), location.getLongitude())));
			}

			animateMarker(mPositionMarker, location); // Helper method for
														// smooth
														// animation

		}

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onResume() {
		super.onResume();
		// locationManager.requestLocationUpdates(provider, 400, 1, this);
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
	}

	public void animateMarker(final Marker marker, final Location location) {
		final Handler handler = new Handler();
		final long start = SystemClock.uptimeMillis();
		final LatLng startLatLng = marker.getPosition();
		final double startRotation = marker.getRotation();
		final long duration = 500;

		final Interpolator interpolator = new LinearInterpolator();

		handler.post(new Runnable() {
			@Override
			public void run() {
				long elapsed = SystemClock.uptimeMillis() - start;
				float t = interpolator.getInterpolation((float) elapsed
						/ duration);

				double lng = t * location.getLongitude() + (1 - t)
						* startLatLng.longitude;
				double lat = t * location.getLatitude() + (1 - t)
						* startLatLng.latitude;

				float rotation = (float) (t * location.getBearing() + (1 - t)
						* startRotation);

				marker.setPosition(new LatLng(lat, lng));
				marker.setRotation(rotation);

				if (t < 1.0) {
					// Post again 16ms later.
					handler.postDelayed(this, 16);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {

		getSupportMenuInflater().inflate(R.menu.map_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;

		case R.id.normal:
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

			break;
		case R.id.hybrid:

			map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

			break;
		case R.id.satellite:

			map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

			break;
		case R.id.terrain:

			map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

			break;
		case R.id.none:

			map.setMapType(GoogleMap.MAP_TYPE_NONE);

			break;

		}
		return false;
	}

	private double distance(double lat1, double lon1, double lat2, double lon2) {
		Location selected_location = new Location("locationA");
		selected_location.setLatitude(lat1);
		selected_location.setLongitude(lon1);
		Location near_locations = new Location("locationA");
		near_locations.setLatitude(lat2);
		near_locations.setLongitude(lon2);
		return selected_location.distanceTo(near_locations) / 1000;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}