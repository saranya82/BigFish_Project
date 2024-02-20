package com.example.bigfish1;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface ApiServiceInterface {

    @FormUrlEncoded
    @POST("index.php?route=api/register&api_token=")
    Call<JsonObject> datapost(@Field("firstname") String firstname,
                              @Field("lastname") String lastname,
                              @Field("email") String email,
                              @Field("telephone") String telephone,
                              @Field("password") String password,
                              @Field("type") String type,
                              @Field("referal_code") String referal_code,
                              @Field("key") String key);

}