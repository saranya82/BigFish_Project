package com.example.bigfish1.login;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;


import android.util.Log;
import android.widget.Toast;

import com.example.bigfish1.RetrofitClass;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginController implements LoginCall {

    Context context;
    LoginCallBack loginCallBack;

    public LoginController(Context context, LoginCallBack loginCallBack) {
        this.context = context;
        this.loginCallBack = loginCallBack;
    }

    @Override
    public void getLoginData(String email, String password) {
        Retrofit retrofit = RetrofitClass.getClient();  //checks whether base part is there
        ApiServiceInterface2 service  = retrofit.create(ApiServiceInterface2.class);
        service.datapost2(email, password, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc").enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    Log.d("Data response", response.body().toString());

                    JsonObject jsonObject = response.body();
                    String status = jsonObject.get("status").getAsString();
                    String msg = jsonObject.get("message").getAsString();
                    loginCallBack.getResponse(msg,status);
                }
                else {
                    Toast.makeText(context.getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: "+t.toString());
            }
        });
    }
}
