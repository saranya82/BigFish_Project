package com.example.bigfish1.PasswordUpdation;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UpdationApi {
    @FormUrlEncoded
    @POST("index.php?route=api/completeapi/updateProfile&api_token")
    Call<JsonObject> Update(@Field("user_id") String user_id,
                            @Field("firstname") String firstname,
                            @Field("lastname") String lastname,
                            @Field("email") String email,
                            @Field("telephone") String telephone,
                            @Field("key") String key);
}
