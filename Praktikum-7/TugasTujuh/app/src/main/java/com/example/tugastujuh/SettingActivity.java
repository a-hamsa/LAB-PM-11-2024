package com.example.tugastujuh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {
    Switch switchtema;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        switchtema = findViewById(R.id.switchtema);

        sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);

        int theme = sharedPreferences.getInt("theme", 0);
        switchtema.setChecked(theme == 1);

        switchtema.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            editor.putInt("theme", isChecked ? 1 : 0);
            editor.apply();
        });
    }
}