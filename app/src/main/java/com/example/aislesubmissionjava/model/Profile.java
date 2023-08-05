
package com.example.aislesubmissionjava.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Profile {

    @SerializedName("general_information")
    @Expose
    private GeneralInformation generalInformation;
    @SerializedName("approved_time")
    @Expose
    private Double approvedTime;
    @SerializedName("disapproved_time")
    @Expose
    private Double disapprovedTime;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos;
    @SerializedName("user_interests")
    @Expose
    private List<Object> userInterests;
    @SerializedName("work")
    @Expose
    private Work work;
    @SerializedName("preferences")
    @Expose
    private List<Preference> preferences;
    @SerializedName("instagram_images")
    @Expose
    private Object instagramImages;
    @SerializedName("last_seen_window")
    @Expose
    private String lastSeenWindow;
    @SerializedName("is_facebook_data_fetched")
    @Expose
    private Boolean isFacebookDataFetched;
    @SerializedName("icebreakers")
    @Expose
    private Object icebreakers;
    @SerializedName("story")
    @Expose
    private Object story;
    @SerializedName("meetup")
    @Expose
    private Object meetup;
    @SerializedName("verification_status")
    @Expose
    private String verificationStatus;
    @SerializedName("has_active_subscription")
    @Expose
    private Boolean hasActiveSubscription;
    @SerializedName("show_concierge_badge")
    @Expose
    private Boolean showConciergeBadge;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("last_seen")
    @Expose
    private Object lastSeen;
    @SerializedName("online_code")
    @Expose
    private Integer onlineCode;
    @SerializedName("profile_data_list")
    @Expose
    private List<ProfileData> profileDataList;

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public Double getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(Double approvedTime) {
        this.approvedTime = approvedTime;
    }

    public Double getDisapprovedTime() {
        return disapprovedTime;
    }

    public void setDisapprovedTime(Double disapprovedTime) {
        this.disapprovedTime = disapprovedTime;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Object> getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(List<Object> userInterests) {
        this.userInterests = userInterests;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public Object getInstagramImages() {
        return instagramImages;
    }

    public void setInstagramImages(Object instagramImages) {
        this.instagramImages = instagramImages;
    }

    public String getLastSeenWindow() {
        return lastSeenWindow;
    }

    public void setLastSeenWindow(String lastSeenWindow) {
        this.lastSeenWindow = lastSeenWindow;
    }

    public Boolean getIsFacebookDataFetched() {
        return isFacebookDataFetched;
    }

    public void setIsFacebookDataFetched(Boolean isFacebookDataFetched) {
        this.isFacebookDataFetched = isFacebookDataFetched;
    }

    public Object getIcebreakers() {
        return icebreakers;
    }

    public void setIcebreakers(Object icebreakers) {
        this.icebreakers = icebreakers;
    }

    public Object getStory() {
        return story;
    }

    public void setStory(Object story) {
        this.story = story;
    }

    public Object getMeetup() {
        return meetup;
    }

    public void setMeetup(Object meetup) {
        this.meetup = meetup;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Boolean getHasActiveSubscription() {
        return hasActiveSubscription;
    }

    public void setHasActiveSubscription(Boolean hasActiveSubscription) {
        this.hasActiveSubscription = hasActiveSubscription;
    }

    public Boolean getShowConciergeBadge() {
        return showConciergeBadge;
    }

    public void setShowConciergeBadge(Boolean showConciergeBadge) {
        this.showConciergeBadge = showConciergeBadge;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Object getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Object lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Integer getOnlineCode() {
        return onlineCode;
    }

    public void setOnlineCode(Integer onlineCode) {
        this.onlineCode = onlineCode;
    }

    public List<ProfileData> getProfileDataList() {
        return profileDataList;
    }

    public void setProfileDataList(List<ProfileData> profileDataList) {
        this.profileDataList = profileDataList;
    }

}
