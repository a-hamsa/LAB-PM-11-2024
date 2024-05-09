package com.example.praktikum7;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrasi extends AppCompatActivity {
    EditText inputNim, inputPass;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrasi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNim = findViewById(R.id.nim_input_register);
        inputPass =  findViewById(R.id.pass_input_register);
        register = findViewById(R.id.register_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = inputNim.getText().toString();
                String pass = inputPass.getText().toString();
                if (validateInputs()) {
                    if (checkUser(nim)) {
                        Database.saveUserData(Registrasi.this, nim, pass);
                        Intent intent = new Intent(Registrasi.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Registrasi.this, "Nim Telah Digunakan!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registrasi.this, "Isi Data Untuk Login!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(inputNim.getText().toString())) {
            inputNim.setError("Silahkan Isi NIM!");
            return false;
        }

        if (TextUtils.isEmpty(inputPass.getText().toString())) {
            inputPass.setError("Silahkan Isi Password");
            return false;
        }

        return true;
    }
    private boolean checkUser(String nim){
        Account account = Database.getUserData(this);
        return account.getNim() == null;
    }
}