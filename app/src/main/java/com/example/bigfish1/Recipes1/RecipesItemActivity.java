package com.example.bigfish1.Recipes1;
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
import java.net.MalformedURLException;
import java.net.URL;

public class RecipesItemActivity extends AppCompatActivity {

    ImageView imageView33;
    TextView FishCurry, time2, cal2, ingredients2, description2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_item);

        imageView33 = findViewById(R.id.imageView33);
        FishCurry = findViewById(R.id.FishCurry);
        ingredients2 = findViewById(R.id.ingredients2);
        description2 = findViewById(R.id.description2);
        time2 = findViewById(R.id.timeTextView);
        cal2 = findViewById(R.id.cal2);

        String imageUrl = "image";
        String name = "Fish Curry";
        String ingredients = "<p>Fish ( any fish ) - 5 medium pieces</p><p>Gambooge - 2 pieces</p><p>Garlic - 6 clove(sliced)</p><p>Ginger - 1 inch piece ( sliced )</p><p>Green chilies - 3 nos slitted</p><p>Kashmiri chilli powder - 1 1/2 tsp</p><p>Turmeric powder - 1/4 tsp</p><p>Coriander powder - 1 tsp</p><p>Curry leaves - 2 stalks</p><p>Mustard seeds - 1 tsp</p><p>Fenugreek seeds - 1/2 tsp</p><p>Shallots ( small onions) - 5 nos ( sliced )</p><p>Coconut oil - 4 tsp</p><p>Water - 2 cup</p>";
        String description = "<ul><li>Clean the fish with water and cut them into medium pieces.</li><li>Soak Kudampuli in a cup of water and set aside.</li><li><li>Take the earthen Pot (meen chatti), heat coconut oil and add mustard seeds. When they splutter add fenugreek seeds, curry leaves, small onions, sliced ginger and garlic and saute for 3 minutes.</li><li><li>Add kashmiri chilly powder, coriander powder and turmeric powder and fry it for 2 minutes.</li><li><li>Add the soaked kudampuli along with water and combine well. Add fish pieces and salt to this</li><li><li>Cover and cook for around 15 minutes on law flame and bring it to a boil. Do not stir the fish pieces with a spatula&nbsp; this might cause it to break. So the best way is to rotate the pan so that the fishes get coated in the masala without breaking.</li><li><li>After 15 minutes cook uncovered for some more time till the fish gets cooked.</li><li>Tasty Red Fish Curry&nbsp; is ready. Serve hot with rice.</li></li></li></li></li></li></ul>";
        String time = "35 min";
        String cals = "10 cals";

        // Load image using BitmapFactory
        Bitmap bitmap = getBitmapFromURL(imageUrl);
        imageView33.setImageBitmap(bitmap);

        FishCurry.setText(name);
        ingredients2.setText(Html.fromHtml(ingredients));
        description2.setText(Html.fromHtml(description));
        time2.setText(time);
        cal2.setText(cals);
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