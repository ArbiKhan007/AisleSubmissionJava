package com.example.aislesubmissionjava.services;

import com.example.aislesubmissionjava.Constants;
import com.example.aislesubmissionjava.interfaces.AisleAPIInterface;
import com.example.aislesubmissionjava.model.Invites;
import com.example.aislesubmissionjava.model.MobileStatusReq;
import com.example.aislesubmissionjava.model.Profile;
import com.example.aislesubmissionjava.model.Status;
import com.example.aislesubmissionjava.model.TokenGenReq;
import com.example.aislesubmissionjava.model.TokenResponse;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientService {
    static RetrofitClientService retrofitClientService;

    private RetrofitClientService() {
    }

    OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
            .addInterceptor(
                    chain -> {
                        Request request = chain.request().newBuilder()
                                .addHeader("Accept", "Application/JSON").build();
                        return chain.proceed(request);
                    }).build();


    private final AisleAPIInterface aisleApiService = new Retrofit.Builder()
            .client(defaultHttpClient)
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(AisleAPIInterface.class);

    public static RetrofitClientService getInstance() {
        if (retrofitClientService == null) {
            return new RetrofitClientService();
        }

        return retrofitClientService;
    }

    public Single<Profile> getListOfProfiles(String authToken) {
        return aisleApiService.getProfiles(authToken);
    }

    public Single<Status> getUserStatus(MobileStatusReq mobileStatusReq){
        return aisleApiService.getUserStatus(mobileStatusReq);
    }

    public Single<TokenResponse> getToken(TokenGenReq tokenGenReq) {
        return aisleApiService.getToken(tokenGenReq);
    }

    public Single<Invites> getInvites(String token) {
        return aisleApiService.getInvites(token);
    }
}
