package com.example.tugas7;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingActivity extends AppCompatActivity {
    SharedPreferences preferences;
    boolean darkMode;
    Switch switchDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainSetting), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        preferences = this.getSharedPreferences("user_pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        switchDarkMode = findViewById(R.id.switch_dark_mode);
        //switch akan tetap on ketika menekan tombol back
        darkMode = preferences.getBoolean("darkMode",false);
        if(darkMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchDarkMode.setChecked(true);
        }

        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                editor.putBoolean("darkMode",true);
                editor.apply();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            }else{
                editor.putBoolean("darkMode",false);
                editor.apply();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });


    }

}