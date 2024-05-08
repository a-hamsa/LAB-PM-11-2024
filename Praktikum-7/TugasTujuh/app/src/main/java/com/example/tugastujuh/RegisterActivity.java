package com.example.tugastujuh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etnim, etpassword;
    Button btnregisterbaru;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etnim = findViewById(R.id.etnimregister);
        etpassword = findViewById(R.id.etpasswordregister);
        btnregisterbaru = findViewById(R.id.btnregisterbaru);

        sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);

        btnregisterbaru.setOnClickListener(v -> {
            String nim = etnim.getText().toString();
            String password = etpassword.getText().toString();

            if (nim.isEmpty()) {
                etnim.setError("Please fill this field");
                return;
            }

            if (password.isEmpty()) {
                etpassword.setError("Please fill this field");
                return;
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("NIM", nim);
            editor.putString("Password", password);
            editor.apply();

            Toast.makeText(RegisterActivity.this, "Berhasil membuat akun", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        });
    }
}