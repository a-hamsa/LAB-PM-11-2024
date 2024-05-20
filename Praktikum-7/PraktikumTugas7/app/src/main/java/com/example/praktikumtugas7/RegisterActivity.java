package com.example.praktikumtugas7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private final static String PREFERENCES = "my_pref";
    private final static String PREF_USERNAME = "username";
    private final static String PREF_PASSWORD = "password";
    private final static String PREF_LOGIN = "login";

    EditText register_et_username;
    EditText register_et_password;
    Button register_btn_register;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        register_et_username = findViewById(R.id.register_et_username);
        register_et_password = findViewById(R.id.register_et_password);
        register_btn_register = findViewById(R.id.register_btn_register);

        register_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = register_et_username.getText().toString();
                String password = register_et_password.getText().toString();

                if (username.isEmpty()){
                    register_et_username.setError("Isi Username");
                } else if (password.isEmpty()) {
                    register_et_password.setError("Isi Password");
                } else {
                    preferences = RegisterActivity.this.getSharedPreferences(PREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(PREF_USERNAME, username);
                    editor.putString(PREF_PASSWORD, password);
//                    editor.putBoolean(PREF_LOGIN, true);
                    editor.apply();

                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                }


            }
        });

    }
}