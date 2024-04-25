package com.example.praktikumtugas5;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    public static final String PARCEL_ACCOUNT = "parcel_data";
    Account getAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ImageView ap_iv_profile = findViewById(R.id.ap_iv_profile);
        TextView ap_tv_name = findViewById(R.id.ap_tv_name);
        TextView ap_tv_username = findViewById(R.id.ap_tv_username);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        ap_iv_profile.setVisibility(View.GONE);
        ap_tv_name.setVisibility(View.GONE);
        ap_tv_username.setVisibility(View.GONE);

        progressBar.setVisibility(View.VISIBLE);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()->{
            try {
                Thread.sleep(2000);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            runOnUiThread(()->{
                ap_iv_profile.setVisibility(View.VISIBLE);
                ap_tv_name.setVisibility(View.VISIBLE);
                ap_tv_username.setVisibility(View.VISIBLE);

                progressBar.setVisibility(View.GONE);

                getAccount = getIntent().getParcelableExtra(PARCEL_ACCOUNT);
                ap_tv_username.setText(getAccount.getUsername());
                ap_tv_name.setText(getAccount.getName());
                ap_iv_profile.setImageResource(getAccount.getProfile());
            });
        });

    }
}