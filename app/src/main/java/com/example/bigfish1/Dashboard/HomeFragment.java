package com.example.bigfish1.Dashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bigfish1.FreshArraivals.NewArrivals;
import com.example.bigfish1.FreshArraivals.NewItemActivity;
import com.example.bigfish1.FreshFish.FreshFish1;
import com.example.bigfish1.R;
import com.example.bigfish1.SeaWaterFish.SeaFishItem;

public class HomeFragment extends Fragment {
TextView fresh;
    private ImageView Combo,seer;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

       Combo = view.findViewById(R.id.Combo);
        seer = view.findViewById(R.id.seer);
fresh =view.findViewById(R.id.fresh);
        seer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeaFishItem.class);
                startActivity(intent);
            }
        });

        Combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ComboItem.class);
                startActivity(intent);
            }
        });
        fresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewArrivals.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager manager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}
