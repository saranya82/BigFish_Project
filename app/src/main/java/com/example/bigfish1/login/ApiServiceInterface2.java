package com.example.bigfish1.login;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceInterface2{

    @FormUrlEncoded
    @POST("index.php?route=api/login&api_token=")
    Call<JsonObject> datapost2(@Field("email") String email,
                              @Field("password") String password,
            @Field("key")String key);


}

