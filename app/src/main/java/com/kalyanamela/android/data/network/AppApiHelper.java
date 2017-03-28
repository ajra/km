package com.kalyanamela.android.data.network;

import com.kalyanamela.android.data.model.ProfileResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHelper mApiHelper;

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Observable<ProfileResponse> doGetTopProfile() {

        return Rx2AndroidNetworking.get(ApiEndPoint.PROFILE_LIST_URL).build().getObjectObservable(ProfileResponse.class);
    }
}
