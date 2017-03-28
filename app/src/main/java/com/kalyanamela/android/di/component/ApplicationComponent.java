package com.kalyanamela.android.di.component;

import android.app.Application;
import android.content.Context;

import com.kalyanamela.android.MvpApp;
import com.kalyanamela.android.data.DataManager;
import com.kalyanamela.android.di.ApplicationContext;
import com.kalyanamela.android.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component( modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp mvpApp);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
