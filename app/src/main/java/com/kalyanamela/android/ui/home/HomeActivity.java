package com.kalyanamela.android.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kalyanamela.android.R;
import com.kalyanamela.android.data.model.Profile;
import com.kalyanamela.android.data.model.ProfileResponse;
import com.kalyanamela.android.ui.base.BaseActivity;
import com.kalyanamela.android.ui.home.adapter.ProfileAdapter;
import com.kalyanamela.android.ui.home.adapter.ProfileListAdapter;
import com.kalyanamela.android.utils.AppConstants;
import com.kalyanamela.android.utils.GeocodeAddressIntentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.kalyanamela.android.R.id.image;
import static com.kalyanamela.android.R.id.profileImageView;

public class HomeActivity extends BaseActivity implements HomeMvpView, OnMapReadyCallback , GoogleMap.OnMarkerClickListener{

    @Inject
    HomeMvpPresenter<HomeMvpView> mPresenter;
    static final float COORDINATE_OFFSET = 0.00002f;
    List<Profile> profileList = new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.listImageButton)
    ImageButton listImageButton;
    @BindView(R.id.cardImageButton)
    ImageButton cardImageButton;
    @BindView(R.id.mapViewImageButton)
    ImageButton mapViewImageButton;
    @BindView(R.id.mapContraintLayout)
    ConstraintLayout mapContraintLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private ProfileAdapter profileAdapter;
    private Context context = HomeActivity.this;
    private GoogleMap mMap;
    String address;
    AddressResultReceiver mResultReceiver;
    boolean fetchAddress;
    int fetchType = AppConstants.USE_ADDRESS_NAME;
    SupportMapFragment mapFragment;
    HashMap<String, String> markerLocation = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(HomeActivity.this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && fab.isShown())
                    fab.hide();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        // googleMapView.getMapAsync(this);
        mResultReceiver = new AddressResultReceiver(null);
        mPresenter.getTopProfileList();

    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    private void setAdapter() {
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.getItemAnimator().setChangeDuration(0);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // listButtonEnabled();
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    public void setProfileListAdapter(ProfileResponse profileResponse) {
        if (profileResponse != null && !profileResponse.getResult().isEmpty()) {
            profileList = profileResponse.getResult();
            setAdapter();
            if (!profileList.isEmpty())
                address = profileList.get(0).getComplexionAddress();
            listButtonEnabled();
        }

    }

    @OnClick({R.id.listImageButton, R.id.cardImageButton, R.id.mapViewImageButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.listImageButton:
                listButtonEnabled();
                break;
            case R.id.cardImageButton:
                listImageButton.setEnabled(true);
                cardImageButton.setEnabled(false);
                mapViewImageButton.setEnabled(true);
                ProfileAdapter homeAdapter = new ProfileAdapter(context, profileList);
                recyclerView.setAdapter(homeAdapter);
                homeAdapter.notifyDataSetChanged();
                recyclerView.setVisibility(View.VISIBLE);
                mapContraintLayout.setVisibility(View.GONE);
                break;
            case R.id.mapViewImageButton:
                listImageButton.setEnabled(true);
                cardImageButton.setEnabled(true);
                mapViewImageButton.setEnabled(false);
                recyclerView.setVisibility(View.GONE);
                mapContraintLayout.setVisibility(View.VISIBLE);
                if (address != null)
                    getLatitudeAndLongitude();
                break;
            default:
        }
    }

    private void listButtonEnabled() {
        listImageButton.setEnabled(false);
        cardImageButton.setEnabled(true);
        mapViewImageButton.setEnabled(true);

        ProfileListAdapter profileListAdapter = new ProfileListAdapter(context, profileList);
        recyclerView.setAdapter(profileListAdapter);
        profileListAdapter.notifyDataSetChanged();
        recyclerView.setVisibility(View.VISIBLE);
        mapContraintLayout.setVisibility(View.GONE);
    }


    private void getLatitudeAndLongitude() {
        mResultReceiver = new AddressResultReceiver(null);
        showLoading(true);
        Intent intent = new Intent(this, GeocodeAddressIntentService.class);
        intent.putExtra(AppConstants.RECEIVER, mResultReceiver);
        intent.putExtra(AppConstants.FETCH_TYPE_EXTRA, fetchType);
        if (fetchType == AppConstants.USE_ADDRESS_NAME) {
            if (address.length() == 0) {
                Toast.makeText(this, "Please enter an address name", Toast.LENGTH_LONG).show();
                return;
            }
            //intent.putExtra(AppConstants.LOCATION_NAME_DATA_EXTRA, address);
            intent.putParcelableArrayListExtra(AppConstants.LOCATION_NAME_DATA_EXTRA, (ArrayList<? extends Parcelable>) profileList);
        }
        startService(intent);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (address != null) {
           // getLatitudeAndLongitude();
        }
    }

    private void setMarkersValues(GoogleMap googleMap, List<Profile> profileList) {
        if (profileList != null && mMap != null) {//Controls to ensure it is right address such as country etc.
            // Set a listener for marker click.
            mMap.setOnMarkerClickListener(this);
            markerLocation.clear();
            for (final Profile profile : profileList) {
                double longitude = profile.getLongitude();
                double latitude = profile.getLatitude();
                if (latitude != 0.0 && longitude != 0.0) {
                    // Add a marker in Sydney and move the camera
                    final LatLng sydney = new LatLng(latitude, longitude);
                    String[] location =  coordinateForMarker((float)latitude, (float)longitude);
                    markerLocation.put(String.valueOf(location[0]), String.valueOf(location[1]));
                    Glide.with(this)
                            .load(profile.getProfileThump())
                            .asBitmap()
                            .into(new SimpleTarget<Bitmap>(100,100) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                                    MarkerOptions markerOptions = new MarkerOptions()
                                            .position(sydney)
                                            .title(profile.getName());
                                    mMap.addMarker(markerOptions).setIcon(BitmapDescriptorFactory.fromBitmap(resource));
                                }
                            });
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                    //Move the camera to the user's location and zoom in!
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 20.0f));
                    CameraUpdate cameraUpdate;
                    cameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 16);
                    MapsInitializer.initialize(this);
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(sydney));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                    mMap.animateCamera(cameraUpdate);

                }
            }
            hideLoading();
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
// Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    // Check if any marker is displayed on given coordinate. If yes then decide
// another appropriate coordinate to display this marker. It returns an
// array with latitude(at index 0) and longitude(at index 1).
    private String[] coordinateForMarker(float latitude, float longitude) {

        String[] location = new String[2];
        int size = profileList.size();

        for (int i = 0; i <= size; i++) {

            if (mapAlreadyHasMarkerForLocation((latitude + i
                    * COORDINATE_OFFSET)
                    + "," + (longitude + i * COORDINATE_OFFSET))) {

                // If i = 0 then below if condition is same as upper one. Hence, no need to execute below if condition.
                if (i == 0)
                    continue;

                if (mapAlreadyHasMarkerForLocation((latitude - i
                        * COORDINATE_OFFSET)
                        + "," + (longitude - i * COORDINATE_OFFSET))) {

                    continue;

                } else {
                    location[0] = latitude - (i * COORDINATE_OFFSET) + "";
                    location[1] = longitude - (i * COORDINATE_OFFSET) + "";
                    break;
                }

            } else {
                location[0] = latitude + (i * COORDINATE_OFFSET) + "";
                location[1] = longitude + (i * COORDINATE_OFFSET) + "";
                break;
            }
        }

        return location;
    }

    // Return whether marker with same location is already on map
    private boolean mapAlreadyHasMarkerForLocation(String location) {
        return (markerLocation.containsValue(location));
    }

    private class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, final Bundle resultData) {
            if (resultCode == AppConstants.SUCCESS_RESULT) {
                //final Address address = resultData.getParcelable(AppConstants.RESULT_ADDRESS);
                final List<Profile> profileList = resultData.getParcelableArrayList(AppConstants.RESULT_ADDRESS);
                if (profileList != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setMarkersValues(mMap, profileList);
                        }
                    });
                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      //  Toast.makeText(HomeActivity.this, resultData.getString(AppConstants.RESULT_DATA_KEY), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
}
