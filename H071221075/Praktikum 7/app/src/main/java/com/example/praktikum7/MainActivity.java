package com.example.praktikum7;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class MainActivity extends AppCompatActivity {
    EditText inputNim, inputPass;
    Button buttonLogin, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SystemSetting.setAppTheme(this);
        if (Database.getUserLogged(this) != null) {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();
        }

        inputNim = findViewById(R.id.nim_input_login);
        inputPass = findViewById(R.id.pass_input_login);
        buttonLogin = findViewById(R.id.login_button);
        buttonRegister = findViewById(R.id.register_button);

        buttonLogin.setOnClickListener(v -> {
            String nim = inputNim.getText().toString();
            String password = inputPass.getText().toString();

            if (validateInputs()){
                if (loginAuth(nim, password)){
                    Database.setUserLogged(this, nim);
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Gagal!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Isi Data Untuk Login!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Registrasi.class);
            startActivity(intent);
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

    private boolean loginAuth(String nim, String pass){
        Account account = Database.getUserData(this);
        return account.getPassword() != null && account.getPassword().equals(pass);
    }
}