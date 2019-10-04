package com.dorvis.mvvm.data.network;

import com.dorvis.mvvm.data.model.User;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RepoService {
    @Headers("Content-Type: application/json")
    @POST("api/Users")
    Single<User>registerUser(@Body User user);

}
