package com.kalyanamela.android.ui.profile;

import com.kalyanamela.android.data.DataManager;
import com.kalyanamela.android.ui.base.BasePresenter;
import com.kalyanamela.android.ui.splash.SplashMvpPresenter;
import com.kalyanamela.android.ui.splash.SplashMvpView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ProfilePresenter<V extends ProfileMvpView> extends BasePresenter<V> implements ProfileMvpPresenter<V>{

    @Inject
    public ProfilePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }
}
