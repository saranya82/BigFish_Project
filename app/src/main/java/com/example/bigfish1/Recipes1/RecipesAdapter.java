package com.example.bigfish1.Recipes1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigfish1.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private static final String TAG = "RecipesAdapter";
    private ArrayList<HashMap<String, String>> listdata;

    public RecipesAdapter(ArrayList<HashMap<String, String>> listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.activity_recipes_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HashMap<String, String> itemData = listdata.get(position);
        holder.recipeid.setText(itemData.get("id"));
        holder.FishCurry.setText(itemData.get("name"));
        holder.ingredients2.setText(itemData.get("ingredients"));
        holder.description2.setText(itemData.get("description"));
        holder.time2.setText(itemData.get("time"));
        holder.cal2.setText(itemData.get("calories"));
        // Load image using Glide
        String imageUrl = itemData.get("image");
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(holder.itemView.getContext())
                    .load(imageUrl)
                    .placeholder(R.drawable.image) // optional placeholder
                    .error(R.drawable.error_image) // optional error placeholder
                    .into(holder.imageView33);
        } else {
            // Handle the case where the image URL is null or empty (optional)
            // You can set a default image or hide the ImageView
            holder.imageView33.setImageResource(R.drawable.default_image);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), RecipesItemActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView FishCurry, time2, cal2, ingredients2, description2,recipeid;
        ImageView imageView33;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.FishCurry = itemView.findViewById(R.id.FishCurry);
            this.recipeid =  itemView.findViewById(R.id.recipeid);
            this.ingredients2 = itemView.findViewById(R.id.ingredients2);
            this.description2 = itemView.findViewById(R.id.description2);
            this.time2 = itemView.findViewById(R.id.timeTextView);
            this.cal2 = itemView.findViewById(R.id.cal2);
            this.imageView33 = itemView.findViewById(R.id.imageView33);
        }
    }
}
