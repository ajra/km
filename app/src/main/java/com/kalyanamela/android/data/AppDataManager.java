
package com.kalyanamela.android.data;


import android.content.Context;

import com.kalyanamela.android.data.model.ProfileResponse;
import com.kalyanamela.android.data.network.ApiHelper;
import com.kalyanamela.android.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper) {
        mContext = context;
        mApiHelper = apiHelper;
    }

    @Override
    public Observable<ProfileResponse> doGetTopProfile() {
        return mApiHelper.doGetTopProfile();
    }
}
