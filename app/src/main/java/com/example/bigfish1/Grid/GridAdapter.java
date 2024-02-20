package com.example.bigfish1.Grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bigfish1.R;

import java.util.List;

public class GridAdapter extends BaseAdapter {

        private Context context;
        private List<GridItem> gridItems;

        public GridAdapter(Context context, List<GridItem> gridItems) {
            this.context = context;
            this.gridItems = gridItems;

        }

        @Override
        public int getCount() {
            return gridItems.size();
        }

        @Override
        public Object getItem(int position) {
            return gridItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View gridItemView;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                gridItemView = inflater.inflate(R.layout.gridview_item, null);
            } else {
                gridItemView = convertView;
            }

            ImageView imageView = gridItemView.findViewById(R.id.gridItemImageView);
            TextView textView = gridItemView.findViewById(R.id.gridItemTextView);

            GridItem item = gridItems.get(position);
            imageView.setImageResource(item.getImageId());
            //picasso set url to image view
        /*Picasso.with(this)
                .load(item.getimageurl)
                .into(imageView);*/
            textView.setText(item.getText());

            return gridItemView;
        }
    }

