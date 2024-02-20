package com.example.bigfish1.FreshFish;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.bigfish1.About.AboutUs;
import com.example.bigfish1.Contacts.Contact;
import com.example.bigfish1.Dashboard.FishCategories;
import com.example.bigfish1.Dashboard.HomeFragment;
import com.example.bigfish1.Dashboard.SettingsFragment;
import com.example.bigfish1.PasswordUpdation.EditProfile;
import com.example.bigfish1.R;
import com.example.bigfish1.Recipes1.Recipes;
import com.example.bigfish1.ReferAndEarn;
import com.example.bigfish1.login.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class FreshFish1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerlayout;

    BottomNavigationView bottomNavigationView;

    HomeFragment fragment1 = new HomeFragment();
    FishCategories fragment2 = new FishCategories();

    SettingsFragment fragment3 = new SettingsFragment();

    Toolbar toolbar;

    NavigationView navigation;

    ActionBarDrawerToggle actionBarDrawerToggle;

    ImageView imageView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        setNavigationDrawer();


        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.page_1);

        imageView = findViewById(R.id.cart);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(com.example.bigfish1.FreshFish.FreshFish1.this, FreshFish1.class);
                startActivity(intent);

            }
        });

    }


    private boolean setNavigationDrawer() {
        drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);


        return false;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.page_1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment1)
                    .commit();
            return true;
        } else if (itemId == R.id.page_2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment2)
                    .commit();
            return true;
        } else if (itemId == R.id.page_3) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment3)
                    .commit();
            return true;
        }
        return false;
    }

}