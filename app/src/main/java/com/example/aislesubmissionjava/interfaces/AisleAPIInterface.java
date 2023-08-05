package com.example.aislesubmissionjava.interfaces;

import com.example.aislesubmissionjava.model.Invites;
import com.example.aislesubmissionjava.model.MobileStatusReq;
import com.example.aislesubmissionjava.model.Profile;
import com.example.aislesubmissionjava.model.Status;
import com.example.aislesubmissionjava.model.TokenGenReq;
import com.example.aislesubmissionjava.model.TokenResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AisleAPIInterface {
    @GET("users/test_profile_list")
    public Single<Profile> getProfiles(@Header("Authorization") String authToken);

    @POST("users/phone_number_login")
    public Single<Status> getUserStatus(@Body MobileStatusReq mobileStatusReq);

    @POST("users/verify_otp")
    Single<TokenResponse> getToken(@Body TokenGenReq tokenGenReq);

    @GET("users/test_profile_list")
    Single<Invites> getInvites(@Header("Authorization") String authHeader);
}
