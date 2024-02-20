package com.example.bigfish1.Dashboard;

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
import java.util.ArrayList;
import java.util.HashMap;

public class ComboAdapter extends RecyclerView.Adapter<com.example.bigfish1.Dashboard.ComboAdapter.ViewHolder> {

    private static final String TAG = "ComboAdapter";
    private ArrayList<HashMap<String, String>> listdata;

    public ComboAdapter(ArrayList<HashMap<String, String>> listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public com.example.bigfish1.Dashboard.ComboAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.activity_combo_item, parent, false);
        return new com.example.bigfish1.Dashboard.ComboAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.bigfish1.Dashboard.ComboAdapter.ViewHolder holder, int position) {
        final HashMap<String, String> itemData = listdata.get(position);
        holder.comboid.setText(itemData.get("category_id"));
        holder.combooffer.setText(itemData.get("name"));

        // Load image using Glide
        String imageUrl = itemData.get("image");
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(holder.itemView.getContext())
                    .load(imageUrl)
                    .placeholder(R.drawable.image) // optional placeholder
                    .error(R.drawable.error_image) // optional error placeholder
                    .into(holder.image1);
        } else {
            // Handle the case where the image URL is null or empty (optional)
            // You can set a default image or hide the ImageView
            holder.image1.setImageResource(R.drawable.default_image);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ComboItem.class);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView combooffer,comboid;
        ImageView image1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.comboid = itemView.findViewById(R.id.comboid);
            this.combooffer =  itemView.findViewById(R.id.combooffer);
            this.image1 = itemView.findViewById(R.id.image1);
        }
    }
}
