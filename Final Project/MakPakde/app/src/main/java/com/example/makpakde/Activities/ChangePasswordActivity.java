package com.example.makpakde.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.makpakde.Database.DatabaseHelper;
import com.example.makpakde.R;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText change_et_password;
    EditText change_et_confirmPassword;
    Button change_btn_changePassword;
    LinearLayout change_ll_connect;
    LinearLayout change_ll_disconnect;
    Button change_btn_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password);

        change_et_password = findViewById(R.id.change_et_password);
        change_et_confirmPassword = findViewById(R.id.change_et_confirmPassword);
        change_btn_changePassword = findViewById(R.id.change_btn_changePassword);
        change_ll_connect = findViewById(R.id.change_ll_connect);
        change_ll_disconnect = findViewById(R.id.change_ll_disconnect);
        change_btn_load = findViewById(R.id.change_btn_load);





        change_btn_changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()){
                    change_ll_disconnect.setVisibility(View.GONE);
                    change_ll_connect.setVisibility(View.VISIBLE);
                    firstCall();
                } else {
                    change_ll_disconnect.setVisibility(View.VISIBLE);
                    change_ll_connect.setVisibility(View.GONE);
                }
            }
        });

        change_btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()){
                    change_ll_disconnect.setVisibility(View.GONE);
                    change_ll_connect.setVisibility(View.VISIBLE);
                    firstCall();
                }
            }
        });

    }

    private void firstCall(){
        String newPassword = change_et_password.getText().toString().trim();
        String confrimNewPassword = change_et_confirmPassword.getText().toString().trim();



        if (newPassword.equalsIgnoreCase(confrimNewPassword)){
            AlertDialog.Builder builder = new AlertDialog.Builder(ChangePasswordActivity.this);
            builder.setTitle("Change Password")
                    .setMessage("Are you sure you want to change your password?")
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseHelper databaseHelper = new DatabaseHelper(ChangePasswordActivity.this);

                            SharedPreferences preferencesUsername = ChangePasswordActivity.this.getSharedPreferences("preferencesUsername", MODE_PRIVATE);
                            String usernameLogin = preferencesUsername.getString("usernameLogin", "");

                            int userId = databaseHelper.getIdLoginUser(usernameLogin);
                            databaseHelper.updateRecordUserPassword(userId, confrimNewPassword);
                            Toast.makeText(ChangePasswordActivity.this, "Success change password", Toast.LENGTH_SHORT).show();
                            Intent toMain = new Intent(ChangePasswordActivity.this, MainActivity.class);
                            startActivity(toMain);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).show();
        } else {
            Toast.makeText(ChangePasswordActivity.this, "Confirm your password", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            if (activeNetwork != null) {
                return activeNetwork.isConnected() || activeNetwork.isConnectedOrConnecting();
            }
        }
        return false;
    }
}