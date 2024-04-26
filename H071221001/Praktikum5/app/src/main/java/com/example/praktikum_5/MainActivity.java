package com.example.praktikum_5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, new HomeFragment())
                .commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.home_layout) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.posting_layout) {
                selectedFragment = new PostFragment();
            } else if (item.getItemId() == R.id.profile_layout) {
                selectedFragment = new ProfileFragment();
            }else if (item.getItemId() == R.id.search_layout) {
                selectedFragment = new SearchFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, selectedFragment)
                        .commit();
                return true;
            } else {
                return false;
            }
        });
    }
}