package com.example.h071221082;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;

    public static boolean adaInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) instance.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ProgressBar progressBar = findViewById(R.id.progressBar);
        if (!adaInternet()) {
            progressBar.setVisibility(View.GONE);
            ConnectionFragment connectionFragment = new ConnectionFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, connectionFragment)
                    .commit();
        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            FrameLayout frameLayout = findViewById(R.id.frame_layout);
            frameLayout.setVisibility(View.GONE);

            long startTime = System.nanoTime();

            new Handler(Looper.getMainLooper()).post(() -> {
                long endTime = System.nanoTime();
                long elapsedTime = endTime - startTime;

                long delayMillis = Math.max(0, TimeUnit.NANOSECONDS.toMillis(elapsedTime));

                handler.postDelayed(() -> {
                    progressBar.setVisibility(View.GONE);
                    frameLayout.setVisibility(View.VISIBLE);
                }, delayMillis);
            });

            HomeFragment homeFragment = new HomeFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, homeFragment)
                    .commit();
        }
    }
}
