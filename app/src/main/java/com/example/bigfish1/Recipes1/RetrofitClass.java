package com.example.bigfish1.Recipes1;


import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass extends Application {

    public static final String BASE_URL = "https://iroidtechnologies.in/healthyfish/";

    static OkHttpClient.Builder httpClient = null;
    private static Retrofit retrofit = null;

    public void onCreate() {

        super.onCreate();
    }

    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .build();

    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(buildClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
