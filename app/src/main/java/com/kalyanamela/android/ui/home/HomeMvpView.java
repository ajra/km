package com.kalyanamela.android.ui.home;

import com.kalyanamela.android.data.model.ProfileResponse;
import com.kalyanamela.android.ui.base.MvpView;

public interface HomeMvpView extends MvpView {
    void setProfileListAdapter(ProfileResponse profileResponse);
}
