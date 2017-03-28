package com.kalyanamela.android.ui.splash;

import com.kalyanamela.android.di.PerActivity;
import com.kalyanamela.android.ui.base.MvpPresenter;
@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
}
