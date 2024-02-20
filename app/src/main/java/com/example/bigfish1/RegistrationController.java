package com.example.bigfish1;

import android.content.Context;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegistrationController implements RegisterCall {

    Context context;
    RegistrationCallBack registrationCallBack;

    public RegistrationController(Context context, RegistrationCallBack registrationCallBack) {
        this.context = context;
        this.registrationCallBack = registrationCallBack;


    }


    @Override
    public void getRegisterdata(String firstname, String lastname, String email, String telephone, String password, String type, String referal_code, String key) {
        Retrofit retrofit = RetrofitClass.getClient();  //checks whether base part is there
        ApiServiceInterface service  = retrofit.create(ApiServiceInterface.class);  //checks end part
        //posting, telling service to create full api(base +end)
        service.datapost(firstname, lastname, email, telephone, password, "0", "0", "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc").enqueue(new Callback<JsonObject>() {
            @Override
            //eneque-Asynchronously send the request and notify callback of its response or if an
            // error occurred talking to the server, creating the request, or processing the response.
            //eneque looks response-posting error or parameter error
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if (response.isSuccessful()){
                    Log.d("Data response", response.body().toString());

                    JsonObject jsonObject = response.body();
                    String status = jsonObject.get("status").getAsString();
                    String msg = jsonObject.get("message").getAsString();
/*                    JsonObject jsonObject1 = jsonObject.getAsJsonObject("data");
                    String id = jsonObject1.get("id").getAsString();
                    String name = jsonObject1.get("name").getAsString();
                    String email = jsonObject1.get("email").getAsString();
                    String mobile = jsonObject1.get("mobile").getAsString();
                    String password = jsonObject1.get("password").getAsString();

                   /* String msg = jsonObject.get("message").getAsString();
                    String id = jsonObject.get("data").getAsString(); //json parsing*/


                    registrationCallBack.getResponse(msg,status);

                }
                else {
                    Toast.makeText(context.getApplicationContext(), "Error",Toast.LENGTH_SHORT);
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();

            }
        });
    }
}


