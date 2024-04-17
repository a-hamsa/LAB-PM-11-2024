package com.example.praktikumtugas4;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.praktikumtugas4.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_navigation;

    HomeFragment homeFragment;
    PostFragment postFragment;
    ProfileFragment profileFragment;
    TextView tb_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottom_navigation = findViewById(R.id.bottom_navigation);
        tb_tv = findViewById(R.id.tb_tv);

        // Initialize your fragments
        homeFragment = new HomeFragment();
        postFragment = new PostFragment();
        profileFragment = new ProfileFragment();

        // Set the initial fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();

        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
                    tb_tv.setText("Home");
                } else if (itemId == R.id.posting) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, postFragment).commit();
                    tb_tv.setText("Posting");
                } else if (itemId == R.id.profile) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, profileFragment).commit();
                    tb_tv.setText("Profile");
                }
                return true;
            }
        });
    }
}
