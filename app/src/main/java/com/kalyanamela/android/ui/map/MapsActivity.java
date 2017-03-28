package com.kalyanamela.android.ui.map;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kalyanamela.android.R;
import com.kalyanamela.android.utils.AppConstants;
import com.kalyanamela.android.utils.GeocodeAddressIntentService;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String address;
    AddressResultReceiver mResultReceiver;
    boolean fetchAddress;
    int fetchType = AppConstants.USE_ADDRESS_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        address = getIntent().getStringExtra(AppConstants.EXTRA_ADDRESS);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mResultReceiver = new AddressResultReceiver(null);
    }

    private void getLatitudeAndLongitude() {
        Intent intent = new Intent(this, GeocodeAddressIntentService.class);
        intent.putExtra(AppConstants.RECEIVER, mResultReceiver);
        intent.putExtra(AppConstants.FETCH_TYPE_EXTRA, fetchType);
        if(fetchType == AppConstants.USE_ADDRESS_NAME) {
            if(address.length() == 0) {
                Toast.makeText(this, "Please enter an address name", Toast.LENGTH_LONG).show();
                return;
            }
            intent.putExtra(AppConstants.LOCATION_NAME_DATA_EXTRA, address);
        }
        startService(intent);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (address != null) {
            getLatitudeAndLongitude();
        }
    }

    private void setMarkersValues(GoogleMap googleMap, Address addressVal) {
        if (addressVal != null) {//Controls to ensure it is right address such as country etc.
            double longitude = addressVal.getLongitude();
            double latitude = addressVal.getLatitude();
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(sydney).title(address));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            //Move the camera to the user's location and zoom in!
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12.0f));
            CameraUpdate cameraUpdate;
            cameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 16);
            MapsInitializer.initialize(this);
            mMap.animateCamera(CameraUpdateFactory.newLatLng(sydney));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            mMap.animateCamera(cameraUpdate);
        }
    }

    class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, final Bundle resultData) {
            if (resultCode == AppConstants.SUCCESS_RESULT) {
                final Address address = resultData.getParcelable(AppConstants.RESULT_ADDRESS);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String mess = "Latitude: " + address.getLatitude() + "\n" +
                                "Longitude: " + address.getLongitude() + "\n" +
                                "Address: " + resultData.getString(AppConstants.RESULT_DATA_KEY);
                        Toast.makeText(MapsActivity.this, mess, Toast.LENGTH_LONG).show();
                        setMarkersValues(mMap, address);
                    }
                });
            }
            else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MapsActivity.this, resultData.getString(AppConstants.RESULT_DATA_KEY), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
}
