package com.example.bigfish1.SeaWaterFish;

import android.content.Context;
import android.util.Log;

import com.example.bigfish1.Dashboard.ComboCall;
import com.example.bigfish1.Dashboard.ComboCallBack;
import com.example.bigfish1.Dashboard.RetrofitClass;
import com.example.bigfish1.Recipes1.Apiinterface2;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SeaController implements SeaCall {


    private static final String TAG = "Controller";

    Context context;
    SeaCallBack callback2;


    public SeaController(Context context, SeaCallBack callback2) {
        this.context = context;
        this.callback2 = callback2;

    }

    ArrayList<HashMap<String, String>> Sealist = new ArrayList<>();

    @Override
    public void getRegisterdata(String user_id, String key) {

        Retrofit retrofit = RetrofitClass.getClient();
        Apiinterface2 apiinterface2 = retrofit.create(Apiinterface2.class);

        apiinterface2.datapost(user_id, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc")
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        if (response.isSuccessful()) {

                            JsonObject jsonObject = response.body();

                            String status = jsonObject.get("status").getAsString();
                            String notificationCount = jsonObject.get("notification_count").getAsString();

                            JsonArray jarray = jsonObject.getAsJsonArray("data");
                            for (int i = 0; i < jarray.size(); i++) {

                                JsonObject dataobj2 = jarray.get(i).getAsJsonObject();
                                String category_id = dataobj2.get("category_id").getAsString();
                                String name = dataobj2.get("name").getAsString();
                                String image = dataobj2.get("image").getAsString();



                                HashMap<String, String> contactlist = new HashMap<>();

                                contactlist.put("Category_id", category_id);
                                contactlist.put("name", name);
                                contactlist.put("image", image);

                                Sealist.add(contactlist);
                                Log.d(TAG, "onResponse: Category_id: " + category_id + ", Name: " + name + contactlist);
                            }

                            callback2.getResponse(Sealist);
                        }


                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                        Log.e(TAG, "Request failed: " + t.getMessage());

                    }
                });

    }
}

