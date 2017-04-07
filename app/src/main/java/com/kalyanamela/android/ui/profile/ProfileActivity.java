package com.kalyanamela.android.ui.profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kalyanamela.android.R;
import com.kalyanamela.android.data.model.Profile;
import com.kalyanamela.android.ui.base.BaseActivity;
import com.kalyanamela.android.ui.home.HomeMvpPresenter;
import com.kalyanamela.android.ui.home.HomeMvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity implements ProfileMvpView {

    @Inject
    ProfileMvpPresenter<ProfileMvpView> mPresenter;

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.nameHeaderTextView)
    TextView nameHeaderTextView;
    @BindView(R.id.cityHeaderTextView)
    TextView cityHeaderTextView;
    @BindView(R.id.nameTextView)
    TextView nameTextView;
    @BindView(R.id.ageTextView)
    TextView ageTextView;
    @BindView(R.id.genderTextView)
    TextView genderTextView;
    @BindView(R.id.dobTextView)
    TextView dobTextView;
    @BindView(R.id.aboutMeTextView)
    TextView aboutMeTextView;
    @BindView(R.id.residenceCityTextView)
    TextView residenceCityTextView;
    @BindView(R.id.mobileNumberTextView)
    TextView mobileNumberTextView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setUp();
    }
    private void setToolbarStyles() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setTitle("");
            toolbar.setSubtitle("");
            toolbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }


    private void setUiValues(Profile profile) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        if (profile != null) {
            nameHeaderTextView.setText(profile.getName());
            nameTextView.setText(profile.getName());
            cityHeaderTextView.setText(profile.getResidencyCity());
            ageTextView.setText(profile.getAge());
            genderTextView.setText(profile.getGender());
            dobTextView.setText(profile.getDob());
            String sb = "" + profile.getReligion() +
                    " - " +
                    profile.getCaste() +
                    " - " +
                    profile.getSubcaste() +
                    " - " +
                    profile.getRasi() +
                    " - " +
                    profile.getStarsign();
            aboutMeTextView.setText(sb);
            mobileNumberTextView.setText(profile.getMobileNo());
            residenceCityTextView.setText(profile.getResidencyCity());
            String fullPosterPath = profile.getProfileThump();
            toolbar.setTitle(profile.getName());
            Glide.with(this)
                    .load(fullPosterPath)
                    .placeholder(R.mipmap.ic_launcher)
                    .thumbnail(0.1f)
                    .into(image);
        }
    }

    @Override
    protected void setUp() {
        Bundle b = getIntent().getExtras();
        Profile profile = b.getParcelable("profile");
        setToolbarStyles();
        setUiValues(profile);
    }
    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

}
