package com.kalyanamela.android.ui.home;

import com.kalyanamela.android.ui.base.MvpPresenter;


public interface HomeMvpPresenter<V extends HomeMvpView> extends MvpPresenter<V> {
    void getTopProfileList();
}
