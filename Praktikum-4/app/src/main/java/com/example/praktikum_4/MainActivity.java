package com.example.praktikum_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.praktikum_4.fragment.HomeFragment;
import com.example.praktikum_4.fragment.PostinganFragment;
import com.example.praktikum_4.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment)
                    .commit();
        }

        BottomNavigationView bottomNav = findViewById(R.id.navmenu);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if(item.getItemId() == R.id.homebtn){
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.postbtn) {
                selectedFragment = new PostinganFragment();
            } else if (item.getItemId() == R.id.profilebtn) {
                selectedFragment = new ProfileFragment();
            }

            if(selectedFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_container, selectedFragment)
//                        .addToBackStack(null)
                        .commit();

                return true;
            } else {
                return false;
            }
        });
    }
}