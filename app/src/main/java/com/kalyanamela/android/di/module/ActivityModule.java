package com.kalyanamela.android.di.module;

import android.app.Activity;
import android.content.Context;

import com.kalyanamela.android.di.ActivityContext;
import com.kalyanamela.android.di.PerActivity;
import com.kalyanamela.android.ui.home.HomeMvpPresenter;
import com.kalyanamela.android.ui.home.HomeMvpView;
import com.kalyanamela.android.ui.home.HomePresenter;
import com.kalyanamela.android.ui.profile.ProfileMvpPresenter;
import com.kalyanamela.android.ui.profile.ProfileMvpView;
import com.kalyanamela.android.ui.profile.ProfilePresenter;
import com.kalyanamela.android.ui.splash.SplashMvpPresenter;
import com.kalyanamela.android.ui.splash.SplashMvpView;
import com.kalyanamela.android.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView>
                                                                     presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeMvpView> provideHomePresenter(HomePresenter<HomeMvpView>
                                                                     presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ProfileMvpPresenter<ProfileMvpView> provideProfilePresenter(ProfilePresenter<ProfileMvpView>
                                                               presenter) {
        return presenter;
    }
}
