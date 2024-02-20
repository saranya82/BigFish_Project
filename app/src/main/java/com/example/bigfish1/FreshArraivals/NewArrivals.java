package com.example.bigfish1.FreshArraivals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.bigfish1.R;
import com.example.bigfish1.Recipes1.RecipesAdapter;
import com.example.bigfish1.Recipes1.RecipesCall;
import com.example.bigfish1.Recipes1.RecipesCallBack;
import com.example.bigfish1.Recipes1.RecipesController;

import java.util.ArrayList;


public class NewArrivals extends AppCompatActivity implements NewCallBack {

    private static final String TAG = "NewArrivals";
    private NewCall call2;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_arraivals);
        Log.d(TAG, "onCreate: jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");

        recyclerView = findViewById(R.id.id);

        call2 = new NewController(getApplicationContext(), this);
        call2.getRegisterdata("397", "63","koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc");
    }

    @Override
    public void getResponse(ArrayList list) {

        Log.d(TAG, "getResponse: llllllllllllllllllllllllllllllllllllllll"+list);
        NewAdapter adapter = new NewAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}