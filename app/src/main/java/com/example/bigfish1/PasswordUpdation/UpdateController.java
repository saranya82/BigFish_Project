package com.example.bigfish1.PasswordUpdation;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UpdateController implements UpdationCall {

    Context context;
    UpdationCallBack updateCallback;

    public UpdateController(Context context, UpdationCallBack updateCallback) {
        this.context = context;
        this.updateCallback = updateCallback;
    }

    @Override
    public void getUpdatedata(String user_id, String firstname, String lastname, String email, String telephone, String key) {
        Retrofit retrofit = RetrofitClass.getClient();
        UpdationApi updateApi = retrofit.create(UpdationApi.class);
        updateApi.Update(user_id, firstname, lastname, email, telephone, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc")
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonObject jsonObject = (JsonObject)response.body();
                        String status = jsonObject.get("status").getAsString();
                        String message = jsonObject.get("message").getAsString();

                        updateCallback.getUpdateResponse(status, message);
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
