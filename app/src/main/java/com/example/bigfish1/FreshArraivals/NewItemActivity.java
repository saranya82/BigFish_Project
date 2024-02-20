package com.example.bigfish1.FreshArraivals;

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

public class NewItemActivity extends AppCompatActivity {

    ImageView imageView33;
    TextView stock_status1, price1, name1, size_text1, weight_class1, product_id1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        imageView33 = findViewById(R.id.imageView33);
        product_id1 = findViewById(R.id.product_id1);
        weight_class1 = findViewById(R.id.weight_class1);
        size_text1 = findViewById(R.id.size_text1);
        name1 = findViewById(R.id.name1);
        price1 = findViewById(R.id.price1);
        stock_status1 = findViewById(R.id.stock_status1);

        String imageUrl = "image";
        String name = "Mackerel";
        String weight_class = "500gm";
        String size_text = "Whole Price";
        String price = "132.67";
        String stock_status = "In Stock";


        // Load image using BitmapFactory
        Bitmap bitmap = getBitmapFromURL(imageUrl);
        imageView33.setImageBitmap(bitmap);

        name1.setText(name);
        weight_class1.setText(Html.fromHtml(weight_class));
        stock_status1.setText(Html.fromHtml(stock_status));
        size_text1.setText(size_text);
        price1.setText(price);
        size_text1.setText(size_text);
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
