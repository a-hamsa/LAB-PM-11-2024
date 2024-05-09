package com.example.tugastujuh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etnim, etpassword;
    Button btnlogin, btnregister;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnim = findViewById(R.id.etnim);
        etpassword = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnregister = findViewById(R.id.btnregister);

        sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        }

        btnlogin.setOnClickListener(v -> {
            String nim = etnim.getText().toString();
            String password = etpassword.getText().toString();

            if (nim.isEmpty()) {
                etnim.setError("Please fill this field");
                return;
            }

            if (password.isEmpty()) {
                etpassword.setError("Please fill this field");
                return;
            }

            String userNIM = sharedPreferences.getString("NIM", "");
            String userPassword = sharedPreferences.getString("Password", "");

            if (nim.equals(userNIM) && password.equals(userPassword)) {
                Toast.makeText(MainActivity.this, "Selamat datang " + nim, Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.apply();

                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                finish();
            } else {
                Toast.makeText(MainActivity.this, "NIM atau Password salah", Toast.LENGTH_SHORT).show();
            }
        });

        btnregister.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            finish();
        });

        int theme = sharedPreferences.getInt("theme", 0);
        if (theme == 1) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}