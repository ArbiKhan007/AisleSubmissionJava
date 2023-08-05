package com.example.aislesubmissionjava.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aislesubmissionjava.model.Invites;
import com.example.aislesubmissionjava.model.MobileStatusReq;
import com.example.aislesubmissionjava.model.Status;
import com.example.aislesubmissionjava.model.TokenGenReq;
import com.example.aislesubmissionjava.model.TokenResponse;
import com.example.aislesubmissionjava.services.RetrofitClientService;

import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private final RetrofitClientService retrofitClientService = RetrofitClientService.getInstance();
    private final MutableLiveData<Status> userStatus = new MutableLiveData<>(null);
    private final MutableLiveData<Invites> invitesLiveData = new MutableLiveData<>(null);
    private final MutableLiveData<TokenResponse> token = new MutableLiveData<>(null);
    private final MutableLiveData<String> mobileNumberLiveData = new MutableLiveData<>(null);
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void getUserStatus(MobileStatusReq mobileStatusReq) {
        compositeDisposable.add(
                retrofitClientService.getUserStatus(mobileStatusReq)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Status>() {

                            @Override
                            public void onSuccess(Status status) {
                                userStatus.postValue(status);
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }
                        }));
    }

    public MutableLiveData<Status> getUserStatus() {
        return userStatus;
    }

    public void setMobileNumber(String mobileNumber) {
        mobileNumberLiveData.postValue(mobileNumber);
    }

    public MutableLiveData<String> getMobileNumberLiveData() {
        return mobileNumberLiveData;
    }

    public void getUserToken(TokenGenReq tokenGenReq) {
        compositeDisposable.add(
                retrofitClientService.getToken(tokenGenReq)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<TokenResponse>() {
                            @Override
                            public void onSuccess(TokenResponse tokenResponse) {
                                token.postValue(tokenResponse);
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }
                        })
        );
    }

    public void getInvites() {
        String token = Objects.requireNonNull(getToken().getValue()).getToken();

        compositeDisposable.add(
                retrofitClientService.getInvites(String.valueOf(token))
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Invites>() {
                            @Override
                            public void onSuccess(Invites invites) {
                                invitesLiveData.postValue(invites);
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }
                        })
        );
    }

    public MutableLiveData<TokenResponse> getToken() {
        return token;
    }

    public MutableLiveData<Invites> getInvitesLiveData() {
        return invitesLiveData;
    }
}
