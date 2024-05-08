package com.example.tugastujuh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    TextView tvselamatdatang;
    Button btnlogout, btnsetting;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvselamatdatang = findViewById(R.id.tvselamatdatang);
        btnlogout = findViewById(R.id.btnlogout);
        btnsetting = findViewById(R.id.btnsetting);

        sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);

        String nim = sharedPreferences.getString("NIM", "");
        tvselamatdatang.setText("Selamat datang " + nim);

        btnlogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();

            startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            finish();
        });

        btnsetting.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, SettingActivity.class));
        });
    }
}