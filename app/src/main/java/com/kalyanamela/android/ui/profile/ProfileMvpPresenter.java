package com.kalyanamela.android.ui.profile;

import com.kalyanamela.android.di.PerActivity;
import com.kalyanamela.android.ui.base.MvpPresenter;

@PerActivity
public interface ProfileMvpPresenter <V extends ProfileMvpView> extends MvpPresenter<V>{

}
