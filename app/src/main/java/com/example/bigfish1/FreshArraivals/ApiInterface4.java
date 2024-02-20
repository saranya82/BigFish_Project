package com.example.bigfish1.FreshArraivals;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface4 {

    @FormUrlEncoded
    @POST("index.php?route=api/completeapi/categoryProducts&api_token=")
    Call<JsonObject> datapost(@Field("user_id")String user_id,
                              @Field("category_id")String category_id,
                              @Field("key")String key);
}
