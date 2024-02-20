package com.example.bigfish1.SeaWaterFish;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bigfish1.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SeaFishItem extends AppCompatActivity {

        ImageView image1;
        TextView seawater,seaid;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sea_fish_item);

            image1 = findViewById(R.id.image1);
            seawater = findViewById(R.id.seawater);
            seaid = findViewById(R.id.seaid);

            String imageUrl = "image";
            String name = "Sea Water FIsh";

            // Load image using BitmapFactory
            Bitmap bitmap = getBitmapFromURL(imageUrl);
            image1.setImageBitmap(bitmap);

            seawater.setText(name);

        }

        private Bitmap getBitmapFromURL(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                return BitmapFactory.decodeStream(input);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }