package com.examen.mvpsample.data.network;

import com.examen.mvpsample.data.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FakeApiInterface {
    @Headers("Content-Type: application/json")
    @POST("api/Users")
    Call<User> loginUser(@Body User user);
    // get users list in jsonarray
}
