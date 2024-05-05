package com.example.tugas6;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;

    public static boolean adaInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) instance.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ProgressBar progressBar = findViewById(R.id.loading);
        if(!adaInternet()){
            progressBar.setVisibility(View.GONE);
            ConnectionFragment connectionFragment = new ConnectionFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, connectionFragment)
                    .commit();


        }else{
            Handler handler = new Handler(Looper.getMainLooper());
            FrameLayout fl = findViewById(R.id.frame_layout);
            fl.setVisibility(View.GONE);
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    handler.post(() -> {
                        // Menampilkan RecyclerView dan menyembunyikan ProgressBar
                        progressBar.setVisibility(View.GONE);
                        fl.setVisibility(View.VISIBLE);

                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, homeFragment)
                    .commit();

        }

    }
}