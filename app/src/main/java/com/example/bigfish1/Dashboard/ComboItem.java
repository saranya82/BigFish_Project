package com.example.bigfish1.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bigfish1.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ComboItem extends AppCompatActivity {

    ImageView image1;
    TextView combooffer,comboid;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_item);

        image1 = findViewById(R.id.image1);
        combooffer = findViewById(R.id.combooffer);
        comboid = findViewById(R.id.comboid);

        String imageUrl = "image";
        String name = "Combo Offer";

        // Load image using BitmapFactory
        Bitmap bitmap = getBitmapFromURL(imageUrl);
        image1.setImageBitmap(bitmap);

        combooffer.setText(name);

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