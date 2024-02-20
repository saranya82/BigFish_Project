package com.example.bigfish1.About;

import android.content.Context;
import android.util.Log;

import com.example.bigfish1.Dashboard.RetrofitClass;
import com.example.bigfish1.Recipes1.Apiinterface2;
import com.example.bigfish1.Recipes1.RecipesCall;
import com.example.bigfish1.Recipes1.RecipesCallBack;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AboutController implements AboutCall {


    private static final String TAG = "Controller";

    Context context;
    AboutCallBack callback2;


    public AboutController(Context context, AboutCallBack callback2) {
        this.context = context;
        this.callback2 = callback2;

    }

    ArrayList<HashMap<String, String>>Aboutlist = new ArrayList<>();

    @Override
    public void getAboutData(String user_id, String key) {

        Retrofit retrofit = RetrofitClass.getClient();
        ApiSeviceInterface4 apiinterface4 = retrofit.create(ApiSeviceInterface4.class);

        apiinterface4.datapost(user_id, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc")
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        if (response.isSuccessful()) {

                            JsonObject jsonObject = response.body();

                            String status = jsonObject.get("status").getAsString();
                            String title = jsonObject.get("title").getAsString();

                            JsonArray jarray = jsonObject.getAsJsonArray("data");
                            for (int i = 0; i < jarray.size(); i++) {

                                JsonObject dataobj2 = jarray.get(i).getAsJsonObject();
                                String id = dataobj2.get("id").getAsString();
                                String name = dataobj2.get("name").getAsString();
                                String position = dataobj2.get("position").getAsString();
                                String about = dataobj2.get("about").getAsString();
                                String image = dataobj2.get("image").getAsString();
                                String user_id = dataobj2.get("user_id").getAsString();
                                String staff_name = dataobj2.get("staff_name").getAsString();
                                String position_id = dataobj2.get("position_id").getAsString();


                                HashMap<String, String> contactlist = new HashMap<>();

                                contactlist.put("id", id);
                                contactlist.put("name", name);
                                contactlist.put("position", position);
                                contactlist.put("about", about);
                                contactlist.put("image", image);
                                contactlist.put("user_id", user_id);
                                contactlist.put("staff_name", staff_name);
                                contactlist.put("position_id", position_id);


                                Aboutlist.add(contactlist);
                                Log.d(TAG, "onResponse: ID: " + id + ", Name: " + name + ", Position: " + position + ", About: " + about +",Image:"+ image +",User_id:"+user_id+",Staff_Name:"+staff_name+",Position_id:"+position+ contactlist);
                            }

                            callback2.getResponse(Aboutlist);
                        }


                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                        Log.e(TAG, "Request failed: " + t.getMessage());

                    }
                });

    }
}

