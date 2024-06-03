package com.example.makpakde.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.makpakde.Database.DatabaseHelper;
import com.example.makpakde.R;

public class RegisterActivity extends AppCompatActivity {

    EditText signin_et_fullname;
    EditText signin_et_username;
    EditText signin_et_password;
    EditText signin_et_confirmPassword;
    Button signin_btn_submit;
    TextView signin_tv_toLogin;


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

        signin_et_fullname = findViewById(R.id.signin_et_fullname);
        signin_et_username = findViewById(R.id.signin_et_username);
        signin_et_password = findViewById(R.id.signin_et_password);
        signin_et_confirmPassword = findViewById(R.id.signin_et_confirmPassword);
        signin_btn_submit = findViewById(R.id.signin_btn_submit);
        signin_tv_toLogin = findViewById(R.id.signin_tv_toLogin);

        signin_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(RegisterActivity.this);

                String fullname = signin_et_fullname.getText().toString();
                String username = signin_et_username.getText().toString();
                String password = signin_et_password.getText().toString();
                String confirmPassword = signin_et_confirmPassword.getText().toString();

                if (fullname.isEmpty() || username.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please enter the field", Toast.LENGTH_SHORT).show();
                } else {
                    if (databaseHelper.checkUsername(username)){
                        Toast.makeText(RegisterActivity.this, "Username Already Exists", Toast.LENGTH_SHORT).show();
                    } else {
                        if (password.equalsIgnoreCase(confirmPassword)){
                            databaseHelper.insertDataUser(fullname,username,password);
                            Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(toLogin);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Your confirm password is not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }




            }
        });

        signin_tv_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(toLogin);
                finish();
            }
        });




    }
}