package com.example.tugas7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    TextView tv_kata;
    Button btn_logout,btn_setting;
    boolean darkMode;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bg_LoginActivty), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_kata = findViewById(R.id.tv_kata);
        btn_logout = findViewById(R.id.btn_logout);
        btn_setting = findViewById(R.id.btn_setting);


        preferences = this.getSharedPreferences("user_pref",MODE_PRIVATE);
        String nim = preferences.getString("nim","-");
        tv_kata.setText("Selamat Datang, "+nim);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("sudahLogin",true);
        editor.apply();

        btn_logout.setOnClickListener(v -> {
            editor.putBoolean("sudahLogin",false);
            editor.apply();
            Intent toMainActivity = new Intent(this, MainActivity.class);
            startActivity(toMainActivity);
            finish();

        });

        btn_setting.setOnClickListener(v -> {
            Intent toSettingActivity = new Intent(this, SettingActivity.class);
            startActivity(toSettingActivity);
        });


    }
//ketika menekan tombol back  tampilan di loginActivity akan lgsng berubah
    @Override
    protected void onResume() {
        super.onResume();
        preferences = this.getSharedPreferences("user_pref",MODE_PRIVATE);
        darkMode = preferences.getBoolean("darkMode",false);

        if(darkMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}