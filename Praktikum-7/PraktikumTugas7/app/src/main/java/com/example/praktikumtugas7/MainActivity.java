package com.example.praktikumtugas7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    private final static String PREFERENCES = "my_pref";
    private final static String PREF_USERNAME = "username";
    private final static String PREF_PASSWORD = "password";
    private final static String PREF_LOGIN = "login";

    TextView main_tv_username;
    Button main_btn_logout;
    Button main_btn_settings;

    SharedPreferences preferences;
    SharedPreferences preferencesLogin;
    String getUsername;
    String getPassword;
    Boolean cekLogin;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        main_tv_username = findViewById(R.id.main_tv_username);
        main_btn_logout = findViewById(R.id.main_btn_logout);
        main_btn_settings = findViewById(R.id.main_btn_settings);


        preferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        getUsername = preferences.getString(PREF_USERNAME, "");
//        getPassword = preferences.getString(PREF_PASSWORD, "");


        preferencesLogin = getSharedPreferences("logincheck", MODE_PRIVATE);
        cekLogin = preferencesLogin.getBoolean(PREF_LOGIN, false);

        main_tv_username.setText(getUsername + "!");

        if (!cekLogin){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        main_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor= preferencesLogin.edit();
                editor.putBoolean(PREF_LOGIN, false);
                editor.apply();
                getUsername = "";
                getPassword = "";
                Intent toLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(toLogin);
                finish();
            }
        });

        main_btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(toSettings);
            }
        });

        SharedPreferences preferencesTheme = getSharedPreferences("my_preftheme", MODE_PRIVATE);
        Boolean dark_mode = preferencesTheme.getBoolean("darkmode", false);

        if (dark_mode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }


    }
}