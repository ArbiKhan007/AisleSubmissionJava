
package com.example.aislesubmissionjava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Invites {

    @SerializedName("invites")
    @Expose
    private Invites__1 invites;
    @SerializedName("likes")
    @Expose
    private Likes likes;

    public Invites__1 getInvites() {
        return invites;
    }

    public void setInvites(Invites__1 invites) {
        this.invites = invites;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

}
