package com.kalyanamela.android.ui.home.adapter;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.kalyanamela.android.R;
import com.kalyanamela.android.data.model.Profile;
import com.kalyanamela.android.ui.map.MapsActivity;
import com.kalyanamela.android.utils.AppConstants;

import java.util.List;


public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.HomeViewAdapter> {

    private LayoutInflater layoutInflater;
    private List<Profile> profileResultList;
    private Context context;
    Boolean isClicked = true;

    public ProfileAdapter(Context context, List<Profile> profileResultList) {
        this.context = context;
        this.profileResultList = profileResultList;
        layoutInflater = LayoutInflater.from(context);
        setHasStableIds(true);

    }

    @Override
    public HomeViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item_profile, parent, false);
        return new HomeViewAdapter(itemView);

    }
    ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
        @Override
        public void animate(View view) {
            view.setAlpha( 0f );
            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
            fadeAnim.setDuration(2000);
            fadeAnim.start();
        }
    };

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final HomeViewAdapter holder, int position) {
        final Profile profileResult = profileResultList.get(position);
        holder.birthPlaceTextView.setText(profileResult.getBirthPlace());
        holder.ageTextView.setText(profileResult.getAge());
        holder.complexionAddressTextView.setText(profileResult.getComplexionAddress());
        holder.nameTextView.setText(profileResult.getName());
        String fullPosterPath = profileResult.getProfileThump();
        Glide.with(context)
                .load(fullPosterPath)
                .placeholder(R.mipmap.ic_launcher)
                .thumbnail(0.1f)
                .animate(animationObject)
                .into(holder.bannerImageView);
        show(holder);

        holder.locationMarkerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra(AppConstants.EXTRA_ADDRESS, profileResult.getComplexionAddress());
                context.startActivity(intent);
            }
        });
    }

    private void show(HomeViewAdapter viewAdapter) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator stateListAnimator = AnimatorInflater
                    .loadStateListAnimator(context, R.animator.lift_on_touch);
            viewAdapter.bannerCardView.setStateListAnimator(stateListAnimator);
        }

    }


    @Override
    public int getItemCount() {
        return profileResultList.size();
    }

    class HomeViewAdapter extends RecyclerView.ViewHolder {
        ImageView bannerImageView;
        TextView birthPlaceTextView;
        TextView complexionAddressTextView;
        TextView nameTextView;
        TextView ageTextView;
        CardView bannerCardView;
        CheckBox bookmarkCheckBox;
        ImageView locationMarkerImageView;

        private HomeViewAdapter(View itemView) {
            super(itemView);
            bannerCardView = (CardView) itemView.findViewById(R.id.bannerCardView);
            bannerImageView = (ImageView) itemView.findViewById(R.id.bannerImageView);
            birthPlaceTextView = (TextView) itemView.findViewById(R.id.birthPlaceTextView);
            complexionAddressTextView = (TextView) itemView.findViewById(R.id.complexionAddressTextView);
            locationMarkerImageView = (ImageView)itemView.findViewById(R.id.locationMarkerImageView);
            bookmarkCheckBox = (CheckBox)itemView.findViewById(R.id.bookmarkCheckBox);
            ageTextView = (TextView) itemView.findViewById(R.id.ageTextView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }
    }
}

