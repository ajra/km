package com.kalyanamela.android.di.component;

import com.kalyanamela.android.di.PerActivity;
import com.kalyanamela.android.di.module.ActivityModule;
import com.kalyanamela.android.ui.home.HomeActivity;
import com.kalyanamela.android.ui.profile.ProfileActivity;
import com.kalyanamela.android.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component( dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity splashActivity);

    void inject(HomeActivity homeActivity);

    void inject(ProfileActivity profileActivity);
}
