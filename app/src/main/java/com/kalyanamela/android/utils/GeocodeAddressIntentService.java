package com.kalyanamela.android.utils;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

import com.kalyanamela.android.data.model.Profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GeocodeAddressIntentService extends IntentService {

    protected ResultReceiver resultReceiver;
    private static final String TAG = "GEO_ADDY_SERVICE";

    public GeocodeAddressIntentService() {
        super("GeocodeAddressIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG, "onHandleIntent");
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String errorMessage = "";
        List<Address> addresses;
        List<Profile> profileList = null;
        int fetchType = intent.getIntExtra(AppConstants.FETCH_TYPE_EXTRA, 0);
        Log.e(TAG, "fetchType == " + fetchType);
        resultReceiver = intent.getParcelableExtra(AppConstants.RECEIVER);
        if(fetchType == AppConstants.USE_ADDRESS_NAME) {
            profileList = intent.getParcelableArrayListExtra(AppConstants.LOCATION_NAME_DATA_EXTRA);
            if (profileList != null && !profileList.isEmpty()) {
                int size = profileList.size();
                for (int j = 0 ; j < size ; j++) {

                    try {
                        Profile profile = profileList.get(j);
                        addresses = geocoder.getFromLocationName(profile.getComplexionAddress(), 1);

                        if (addresses == null || addresses.isEmpty()) {
                            if (errorMessage.isEmpty()) {
                                errorMessage = "Not Found";
                                Log.e(TAG, errorMessage);
                            }
                           // deliverResultToReceiver(AppConstants.FAILURE_RESULT, errorMessage, null);
                        } else {
                            for (Address address : addresses) {
                                String outputAddress = "";
                                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                                    outputAddress += " --- " + address.getAddressLine(i);
                                }
                                Log.e(TAG, outputAddress);
                            }
                            Address address = addresses.get(0);
                            ArrayList<String> addressFragments = new ArrayList<>();

                            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                                addressFragments.add(address.getAddressLine(i));
                            }
                            Log.i(TAG, "Address Found");
                            profileList.get(j).setLatitude(address.getLatitude());
                            profileList.get(j).setLongitude(address.getLongitude());
                        }
                    } catch (IOException e) {
                        errorMessage = "Service not available";
                        Log.e(TAG, errorMessage, e);
                    }
                }
            }

        } else if(fetchType == AppConstants.USE_ADDRESS_LOCATION) {
            double latitude = intent.getDoubleExtra(AppConstants.LOCATION_LATITUDE_DATA_EXTRA, 0);
            double longitude = intent.getDoubleExtra(AppConstants.LOCATION_LONGITUDE_DATA_EXTRA, 0);

            try {
                addresses = geocoder.getFromLocation(latitude, longitude, 1);
            } catch (IOException ioException) {
                errorMessage = "Service Not Available";
                Log.e(TAG, errorMessage, ioException);
            } catch (IllegalArgumentException illegalArgumentException) {
                errorMessage = "Invalid Latitude or Longitude Used";
                Log.e(TAG, errorMessage + ". " +
                        "Latitude = " + latitude + ", Longitude = " +
                        longitude, illegalArgumentException);
            }
        }
        else {
            errorMessage = "Unknown Type";
            Log.e(TAG, errorMessage);
        }

        deliverResultToReceiver(AppConstants.SUCCESS_RESULT, profileList);
    }


    private void deliverResultToReceiver(int resultCode, List<Profile> profileList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(AppConstants.RESULT_ADDRESS, (ArrayList<? extends Parcelable>) profileList);
        resultReceiver.send(resultCode, bundle);
    }

}
