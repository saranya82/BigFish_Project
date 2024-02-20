package com.example.bigfish1.FishItems;
import android.annotation.SuppressLint;
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

public class MyListAdapter2 extends RecyclerView.Adapter<MyListAdapter2.ViewHolder2> {

    private static final String TAG = "ListAdapter";
    private ArrayList<HashMap<String, String>> listdata2;

    public MyListAdapter2(ArrayList<HashMap<String, String>> listdata) {
        this.listdata2 = listdata;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_fish, parent, false);
        return new ViewHolder2(listItem);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        final HashMap<String, String> itemData = listdata2.get(position);
        holder.textView01.setText(itemData.get("product_id"));
        holder.textView02.setText(itemData.get("name"));
        holder.textView03.setText(itemData.get("price"));

        Glide.with(holder.itemView.getContext())
                .load(itemData.get("image"))
                .into(holder.imageView01);

        holder.linearlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Fishquantity.class);
                i.putExtra("product_id", itemData.get("product_id"));
                i.putExtra("name", itemData.get("name"));
                i.putExtra("price", itemData.get("price"));
                i.putExtra("image", itemData.get("image"));
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata2.size();
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        public ImageView imageView01;
        public TextView textView01, textView02, textView03;
        public LinearLayout linearlayout2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            this.imageView01 = itemView.findViewById(R.id.imageView1);
            this.textView01 = itemView.findViewById(R.id.textView1);
            this.textView02 = itemView.findViewById(R.id.textView22);
            this.textView03 = itemView.findViewById(R.id.textView33);
            this.linearlayout2 = itemView.findViewById(R.id.linearlayout2);
        }
    }
}
