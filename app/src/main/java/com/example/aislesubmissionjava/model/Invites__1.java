
package com.example.aislesubmissionjava.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Invites__1 {

    @SerializedName("profiles")
    @Expose
    private List<Profile> profiles;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("pending_invitations_count")
    @Expose
    private Integer pendingInvitationsCount;

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPendingInvitationsCount() {
        return pendingInvitationsCount;
    }

    public void setPendingInvitationsCount(Integer pendingInvitationsCount) {
        this.pendingInvitationsCount = pendingInvitationsCount;
    }

}
