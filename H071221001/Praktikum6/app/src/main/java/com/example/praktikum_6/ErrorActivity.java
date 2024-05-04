package com.example.praktikum_6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ErrorActivity extends AppCompatActivity {
    RelativeLayout errorLayout;
    ProgressBar pb;
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        errorLayout = findViewById(R.id.error_layout);
        pb = findViewById(R.id.error_PB);
        retryButton = findViewById(R.id.retryBTN);

        retryButton.setOnClickListener(v -> {
            errorLayout.setVisibility(View.GONE);
            pb.setVisibility(View.VISIBLE);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                pb.setVisibility(View.GONE);
                retryConnection();
            }, 500);
        });
    }

    private void retryConnection() {
        if (isNetworkAvailable()) {
            Intent intent = getIntent();
            String mainActivity = intent.getStringExtra("MainActivity");
            String detailActivity = intent.getStringExtra("DetailActivity");
            int userId = intent.getIntExtra("id", -1);

            if (mainActivity != null) {
                    startActivity(new Intent(ErrorActivity.this, MainActivity.class));
            } else if (detailActivity != null) {
                Intent detailIntent = new Intent(ErrorActivity.this, DetailActivity.class);
                detailIntent.putExtra("id", userId);
                startActivity(detailIntent);
            } else {
                startActivity(new Intent(ErrorActivity.this, MainActivity.class));
            }
            finish();
        } else {
            errorLayout.setVisibility(View.VISIBLE);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
