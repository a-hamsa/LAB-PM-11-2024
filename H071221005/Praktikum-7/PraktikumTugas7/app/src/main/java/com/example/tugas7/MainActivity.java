package com.example.tugas7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et_nim,et_pass;
    Button btn_login,btn_register,btn_hapusData;
    String inputNim,inputPass;
    SharedPreferences preferences;
    boolean sudahLogin;
    private boolean darkMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bg_MainActivty), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        preferences = this.getSharedPreferences("user_pref",MODE_PRIVATE);
        sudahLogin = preferences.getBoolean("sudahLogin",false);
        if(sudahLogin){
            Intent toLogin = new Intent(this,LoginActivity.class);
            startActivity(toLogin);
            finish();

        }
        et_nim = findViewById(R.id.et_nim);
        et_pass = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_hapusData = findViewById(R.id.btn_hapusData);

        btn_login.setOnClickListener(v -> {
            inputNim = et_nim.getText().toString();
            inputPass = et_pass.getText().toString();
            if(inputNim.isEmpty()){
                et_nim.setError("Masukan NIM !!");
            }else if(inputPass.isEmpty()){
                et_pass.setError("Masukkan Password !!");
            }else{
                String nim = preferences.getString("nim","-");
                String pass = preferences.getString("pass","-");
                if(inputNim.equals(nim) && inputPass.equals(pass)){
                    Intent toLogin = new Intent(this,LoginActivity.class);
                    startActivity(toLogin);
                    finish();
                }else{
                    Toast.makeText(this, "NIM atau Password Salah !", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btn_register.setOnClickListener(v -> {
                Intent toRegister = new Intent(this,RegisterActivity.class);
                startActivity(toRegister);
        });
        btn_hapusData.setOnClickListener(v -> {
            preferences = this.getSharedPreferences("user_pref",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();
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