package com.example.praktikum_5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class DetailActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private FrameLayout frameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        frameLayout = findViewById(R.id.frame_detail);
        progressBar = findViewById(R.id.detail_PB);

        frameLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        new Thread(() -> {
            try {
                Thread.sleep(1000);

                new Handler(Looper.getMainLooper()).post(() -> {
                    progressBar.setVisibility(View.GONE);
                    frameLayout.setVisibility(View.VISIBLE);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        FragmentManager fragmentManager = getSupportFragmentManager();
        ProfileFragment profileFragment = new ProfileFragment();
        Intent getExtra = getIntent();
        if (getExtra != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(ProfileFragment.EXTRA_USER, getExtra.getParcelableExtra(ProfileFragment.EXTRA_USER));
            profileFragment.setArguments(bundle);
        }

        fragmentManager.beginTransaction().add(R.id.frame_detail, profileFragment, ProfileFragment.class.getSimpleName()).commit();
    }
}
