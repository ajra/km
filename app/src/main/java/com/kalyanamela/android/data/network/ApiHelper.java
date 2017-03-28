package com.kalyanamela.android.data.network;


import com.kalyanamela.android.data.model.ProfileResponse;

public interface ApiHelper {

    io.reactivex.Observable<ProfileResponse> doGetTopProfile();
}
