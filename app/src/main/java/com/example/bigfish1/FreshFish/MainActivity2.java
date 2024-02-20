package com.example.bigfish1.FreshFish;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.bigfish1.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager2;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        tabLayout.addTab(tabLayout.newTab().setText("SEA FISH"));
        tabLayout.addTab(tabLayout.newTab().setText("BACKWATER FISH"));
        tabLayout.addTab(tabLayout.newTab().setText("FRESH FISH"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Create the adapter only once and reuse it

        MyAdapter myAdapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager2.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}

