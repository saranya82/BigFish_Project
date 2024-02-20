package com.example.bigfish1.FreshArraivals;

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

public class NewController implements NewCall {


    private static final String TAG = "Controller";

    Context context;
    NewCallBack callback2;


    public NewController(Context context, NewCallBack callback2) {
        this.context = context;
        this.callback2 = callback2;

    }

    ArrayList<HashMap<String, String>> Newlist = new ArrayList<>();

    @Override
    public void getRegisterdata(String user_id, String category_id,String key) {

        Retrofit retrofit = RetrofitClass.getClient();
        ApiInterface4 apiinterface4 = retrofit.create(ApiInterface4.class);

        apiinterface4.datapost(user_id,category_id, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc")
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.d(TAG, "onResponse: qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+response);
                        if (response.isSuccessful()) {

                            JsonObject jsonObject = response.body();

                            String status = jsonObject.get("status").getAsString();
                            String notificationCount = jsonObject.get("notification_count").getAsString();

                            JsonArray jarray = jsonObject.getAsJsonArray("data");
                            for (int i = 0; i < jarray.size(); i++) {

                                JsonObject dataobj2 = jarray.get(i).getAsJsonObject();
                                String product_id = dataobj2.get("product_id").getAsString();
                                String name = dataobj2.get("name").getAsString();
                                String weight_class = dataobj2.get("weight_class").getAsString();
                                String image = dataobj2.get("image").getAsString();
                                String size_text = dataobj2.get("size_text").getAsString();
                                String price = dataobj2.get("price").getAsString();
                                String stock_status = dataobj2.get("stock_status").getAsString();


                                HashMap<String, String> contactlist = new HashMap<>();

                                contactlist.put("product_id", product_id);
                                contactlist.put("name", name);
                                contactlist.put("weight_class", weight_class);
                                contactlist.put("image", image);
                                contactlist.put("size_text", size_text);
                                contactlist.put("price", price);
                                contactlist.put("stock_status", stock_status);

                                Newlist.add(contactlist);
                                Log.d(TAG, "onResponse: ID: " + product_id + ", Name: " + name + ", Weight_Class: " + weight_class + ", Size_Text: " + size_text +",Price:"+price +",Stock_Status:" + stock_status+ contactlist);
                            }

                            callback2.getResponse(Newlist);
                        }


                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                        Log.e(TAG, "Request failed: " + t.getMessage());

                    }
                });

    }
}

