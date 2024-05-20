package com.example.h071221082;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class RegisterActivity extends AppCompatActivity {

    EditText inputNim, inputPassword;
    Button registerBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputNim = findViewById(R.id.inputNim);
        inputPassword = findViewById(R.id.inputPassword);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(view -> {
            String nim = String.valueOf(inputNim.getText());
            String password = String.valueOf(inputPassword.getText());

            if (!nim.isEmpty() && !password.isEmpty()) {
                sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                editor.putString("nim", nim);
                editor.putString("password", password);
                editor.apply();

                finish();
            } else if (!nim.isEmpty()) {
                inputPassword.setError("Please fill this field");
                return;
            } else {
                inputNim.setError("Please fill this field");
                return;
            }
        });

        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}