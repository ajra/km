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

import java.util.List;


public class ProfileListAdapter extends RecyclerView.Adapter<ProfileListAdapter.HomeViewAdapter> {

    private LayoutInflater layoutInflater;
    private List<Profile> profileResultList;
    private Context context;
    Boolean isClicked = true;

    public ProfileListAdapter(Context context, List<Profile> profileResultList) {
        this.context = context;
        this.profileResultList = profileResultList;
        layoutInflater = LayoutInflater.from(context);
        setHasStableIds(true);

    }

    @Override
    public ProfileListAdapter.HomeViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.profile_list_item, parent, false);
        return new ProfileListAdapter.HomeViewAdapter(itemView);

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
    public void onBindViewHolder(final ProfileListAdapter.HomeViewAdapter holder, int position) {
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
                .into(holder.profileImageView);
        show(holder);
    }

    private void show(ProfileListAdapter.HomeViewAdapter viewAdapter) {
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
        ImageView profileImageView;
        TextView birthPlaceTextView;
        TextView complexionAddressTextView;
        TextView nameTextView;
        TextView ageTextView;
        CardView bannerCardView;

        private HomeViewAdapter(View itemView) {
            super(itemView);
            bannerCardView = (CardView) itemView.findViewById(R.id.bannerCardView);
            profileImageView = (ImageView) itemView.findViewById(R.id.profileImageView);
            birthPlaceTextView = (TextView) itemView.findViewById(R.id.placeTextView);
            complexionAddressTextView = (TextView) itemView.findViewById(R.id.complexionAddressTextView);
            ageTextView = (TextView) itemView.findViewById(R.id.ageTextView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }
    }
}

