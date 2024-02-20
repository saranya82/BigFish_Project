package com.example.bigfish1.FreshArraivals;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigfish1.R;
import com.example.bigfish1.Recipes1.RecipesAdapter;
import com.example.bigfish1.Recipes1.RecipesItemActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class NewAdapter extends RecyclerView.Adapter<com.example.bigfish1.FreshArraivals.NewAdapter.ViewHolder> {

    private static final String TAG = "NewAdapter";
    private ArrayList<HashMap<String, String>> listdata;

    public NewAdapter(ArrayList<HashMap<String, String>> listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public com.example.bigfish1.FreshArraivals.NewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.activity_new_item, parent, false);
        return new com.example.bigfish1.FreshArraivals.NewAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.bigfish1.FreshArraivals.NewAdapter.ViewHolder holder, int position) {
        final HashMap<String, String> itemData = listdata.get(position);
        holder.product_id1.setText(itemData.get("product_id"));
        holder.weight_class1.setText(itemData.get("weight_class"));
        holder.size_text1.setText(itemData.get("size_text"));
        holder.name1.setText(itemData.get("name"));
        holder.price1.setText(itemData.get("price"));
        holder.stock_status1.setText(itemData.get("stock_status"));
        // Load image using Glide
        String imageUrl = itemData.get("image");
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(holder.itemView.getContext())
                    .load(imageUrl)
                    .placeholder(R.drawable.image) // optional placeholder
                    .error(R.drawable.img_1) // optional error placeholder
                    .into(holder.imageView33);
        } else {
            // Handle the case where the image URL is null or empty (optional)
            // You can set a default image or hide the ImageView
            holder.imageView33.setImageResource(R.drawable.img_6);
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
        TextView stock_status1, price1, name1, size_text1, weight_class1,product_id1;
        ImageView imageView33;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.product_id1 = itemView.findViewById(R.id.product_id1);
            this.weight_class1 =  itemView.findViewById(R.id.weight_class1);
            this.size_text1 = itemView.findViewById(R.id.size_text1);
            this.name1 = itemView.findViewById(R.id.name1);
            this.price1 = itemView.findViewById(R.id.price1);
            this.stock_status1 = itemView.findViewById(R.id.stock_status1);
            this.imageView33 = itemView.findViewById(R.id.imageView33);
        }
    }
}

