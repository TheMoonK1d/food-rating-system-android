package com.example.rate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.rate.databinding.ActivityHomeBinding;
import com.example.rate.databinding.ActivitySignupBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Objects.requireNonNull(getSupportActionBar())
                .setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.bk)));
        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if(item.getItemId()== R.id.home)
                {
                    fragment = new HomeFragment();
                }
                if(item.getItemId()== R.id.food)
                {
                    fragment = new FoodFragment();
                }
                if(item.getItemId()== R.id.profile)
                {
                    fragment = new ProfileFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });
        binding.bottomNavigationView.setSelectedItemId(R.id.home);
    }
}