package com.example.h071221082;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    Button loginBtn, registerBtn;
    EditText inputNim, inputPassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNim = findViewById(R.id.inputNim);
        inputPassword = findViewById(R.id.inputPassword);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        checkLoginStatus();

        registerBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            inputNim.setText("");
            inputPassword.setText("");
        });

        loginBtn.setOnClickListener(view -> {
            String nim = inputNim.getText().toString().trim();
            String password = inputPassword.getText().toString().trim();

            if (!nim.isEmpty() && !password.isEmpty()) {
                boolean isValid = isValidLogin(nim, password);
                if (isValid) {
                    saveLoginStatus(true);
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "NIM atau Password Salah", Toast.LENGTH_SHORT).show();
                }
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

    private void checkLoginStatus() {
        sharedPreferences = this.getSharedPreferences("user_pref", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean isValidLogin(String nim, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        String storedPassword = sharedPreferences.getString("password", "");
        String storedNim = sharedPreferences.getString("nim", "");

        return storedNim.equals(nim) && storedPassword.equals(password);
    }

    private void saveLoginStatus(boolean isLoggedIn) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }
}
