package com.example.aislesubmissionjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aislesubmissionjava.R;
import com.example.aislesubmissionjava.model.Profile;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    private Context context;
    private List<Profile> profileList;

    public ProfileAdapter(Context context, List<Profile> profileList) {
        this.context = context;
        this.profileList = profileList;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item, parent, false);
        return new ProfileViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        String nameAge = profile.getGeneralInformation().getFirstName() + ", " + profile.getGeneralInformation().getAge();
        // Load the image using Glide
        Glide.with(context)
                .load(profile.getPhotos()) // You should have the image URL in TileData, or you can use the resource ID with Glide if needed.
                .placeholder(R.drawable.default_profile) // Placeholder image while loading
                .into(holder.imageView);
        holder.textViewName.setText(nameAge);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }

    public void setProfileList(List<Profile> profileList){
        this.profileList.clear();
        this.profileList.addAll(profileList);
    }
}
