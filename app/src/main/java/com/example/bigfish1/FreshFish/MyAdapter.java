package com.example.bigfish1.FreshFish;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigfish1.Dashboard.FishCategories;
import com.example.bigfish1.R;
import com.example.bigfish1.SeaWaterFish.SeaFish;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Seafish();
        } else if (position == 1) {
            return new BackWaterFish();
        } else if (position == 2) {
            return new FreshFishHome();
        } else {
            return null;
        }
    }

    // this counts the total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}

