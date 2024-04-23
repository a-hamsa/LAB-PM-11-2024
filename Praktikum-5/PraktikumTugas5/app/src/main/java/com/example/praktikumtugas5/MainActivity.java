package com.example.praktikumtugas5;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.praktikumtugas5.Fragment.HomeFragment;
import com.example.praktikumtugas5.Fragment.PostFragment;
import com.example.praktikumtugas5.Fragment.ProfileFragment;
import com.example.praktikumtugas5.Fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
    ImageView menubar_home, menubar_search, menubar_post, menubar_profile;
    TextView titlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        menubar_home = findViewById(R.id.menubar_home);
        menubar_search = findViewById(R.id.menubar_search);
        menubar_post = findViewById(R.id.menubar_post);
        menubar_profile = findViewById(R.id.menubar_profile);
        titlebar = findViewById(R.id.titlebar);

        SearchFragment searchFragment = new SearchFragment();
        PostFragment postFragment = new PostFragment();
        HomeFragment homeFragment = new HomeFragment();
        ProfileFragment profileFragment = new ProfileFragment();

        menubar_home.setOnClickListener(v->{
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, homeFragment, HomeFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
            menubar_home.setColorFilter(getResources().getColor(R.color.blue));
            menubar_search.setColorFilter(null);
            menubar_post.setColorFilter(null);
            menubar_profile.setColorFilter(null);
            titlebar.setText("Home");

        });
        menubar_search.setOnClickListener(v->{
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, searchFragment, SearchFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
            menubar_search.setColorFilter(getResources().getColor(R.color.blue));
            menubar_home.setColorFilter(null);
            menubar_post.setColorFilter(null);
            menubar_profile.setColorFilter(null);
            titlebar.setText("Search");
        });
        menubar_post.setOnClickListener(v->{
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, postFragment, PostFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
            menubar_post.setColorFilter(getResources().getColor(R.color.blue));
            menubar_search.setColorFilter(null);
            menubar_profile.setColorFilter(null);
            menubar_home.setColorFilter(null);
            titlebar.setText("Post");
        });
        menubar_profile.setOnClickListener(v->{
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, profileFragment, ProfileFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
            menubar_profile.setColorFilter(getResources().getColor(R.color.blue));
            menubar_search.setColorFilter(null);
            menubar_home.setColorFilter(null);
            menubar_post.setColorFilter(null);
            titlebar.setText("Profile");
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, homeFragment, HomeFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
        menubar_home.setColorFilter(getResources().getColor(R.color.blue));
        titlebar.setText("Home");

    }
}