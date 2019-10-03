package com.examen.mvpsample.ui.login;

import com.examen.mvpsample.data.models.User;
import com.examen.mvpsample.data.network.FakeApiInterface;
import com.examen.mvpsample.data.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetLoginIntractorImpl implements LoginContract.GetLoginInIntractor {

    private String email,password;
    private int iD;

    public GetLoginIntractorImpl(String email, String password,int iD) {
        this.email = email;
        this.password = password;
        this.iD =iD;
    }

    @Override
    public void getLoginInfoData(final OnLoginInFinishedListener loginInFinishedListener) {
        FakeApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(FakeApiInterface.class);
        Call<User> userCall = apiInterface.loginUser(new User(email,password,iD));
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                loginInFinishedListener.onLoginFinished(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
               loginInFinishedListener.onLoginFailure(t);
            }
        });

    }
}
