
package com.example.aislesubmissionjava.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Likes {

    @SerializedName("profiles")
    @Expose
    private List<Profile__1> profiles;
    @SerializedName("can_see_profile")
    @Expose
    private Boolean canSeeProfile;
    @SerializedName("likes_received_count")
    @Expose
    private Integer likesReceivedCount;

    public List<Profile__1> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile__1> profiles) {
        this.profiles = profiles;
    }

    public Boolean getCanSeeProfile() {
        return canSeeProfile;
    }

    public void setCanSeeProfile(Boolean canSeeProfile) {
        this.canSeeProfile = canSeeProfile;
    }

    public Integer getLikesReceivedCount() {
        return likesReceivedCount;
    }

    public void setLikesReceivedCount(Integer likesReceivedCount) {
        this.likesReceivedCount = likesReceivedCount;
    }

}
