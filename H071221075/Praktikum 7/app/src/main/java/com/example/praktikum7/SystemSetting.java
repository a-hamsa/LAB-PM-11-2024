package com.example.praktikum7;

import android.content.Context;
import android.os.Bundle;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SystemSetting extends AppCompatActivity {
    private Switch sw_tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_system_setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sw_tema = findViewById(R.id.sw_tema);
        sw_tema.setChecked(Database.getSystemMode(this));

        sw_tema.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Database.setSystemMode(this, isChecked);
            setAppTheme(this);
        });
    }

    public static void setAppTheme(Context context) {
        boolean isDarkMode = Database.getSystemMode(context);
        int nightMode = isDarkMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO;
        AppCompatDelegate.setDefaultNightMode(nightMode);
    }
}

