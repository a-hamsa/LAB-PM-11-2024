package com.example.tugas7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    EditText et_nim,et_pass;
    Button btn_register;
    SharedPreferences preferences;
    private boolean darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bg_RegisterActivty), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et_nim = findViewById(R.id.et_nim);
        et_pass = findViewById(R.id.et_password);
        btn_register = findViewById(R.id.btn_submit_register);
        btn_register.setOnClickListener(v -> {
            String nim = et_nim.getText().toString();
            String pass = et_pass.getText().toString();

            //mode private artinya tidak bisa diakses dgn app lain
            preferences = RegisterActivity.this.getSharedPreferences("user_pref",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nim",nim);
            editor.putString("pass",pass);
            editor.apply();

            Intent toMainActivity = new Intent(this,MainActivity.class);
            startActivity(toMainActivity);
            finish();
        });
    }
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