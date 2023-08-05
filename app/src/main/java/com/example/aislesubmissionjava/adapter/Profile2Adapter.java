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
import com.example.aislesubmissionjava.model.Profile__1;

import java.util.List;

public class Profile2Adapter extends RecyclerView.Adapter<Profile2Adapter.Profile2ViewHolder> {

    private Context context;
    private List<Profile__1> profileList;

    public Profile2Adapter(Context context, List<Profile__1> profileList) {
        this.context = context;
        this.profileList = profileList;
    }

    @Override
    public Profile2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_2_item, parent, false);
        return new Profile2ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Profile2ViewHolder holder, int position) {
        Profile__1 profile = profileList.get(position);
        String name = profile.getFirstName();
        // Load the image using Glide
        Glide.with(context)
                .load(profile.getAvatar())
                .placeholder(R.drawable.default_profile)
                .into(holder.imageView);
        holder.textViewName.setText(name);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public class Profile2ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;

        public Profile2ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }

    public void setProfileList(List<Profile__1> profileList){
        this.profileList.clear();
        this.profileList.addAll(profileList);
    }
}
