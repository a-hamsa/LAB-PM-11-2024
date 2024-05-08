package com.example.praktikum_7;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.SharedPreferences;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingActivity extends AppCompatActivity {

    Switch sw_tema;
    TextView tv_mode;
    SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sw_tema = findViewById(R.id.sw_tema);
        tv_mode = findViewById(R.id.tv_mode);
        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
        setTheme(isDarkTheme);
        sw_tema.setChecked(isDarkTheme);
        tv_mode.setText(isDarkTheme ? "Dark Theme" : "Light Theme");
        sw_tema.setThumbResource(isDarkTheme ? R.drawable.moon : R.drawable.sun);

        sw_tema.setOnCheckedChangeListener((buttonView, isChecked) -> {
            setTheme(isChecked);
            editor.putBoolean("is_dark_theme", isChecked);
            editor.apply();
        });

    }

    private void setTheme(boolean isDark) {
        AppCompatDelegate.setDefaultNightMode(isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
    }
}
