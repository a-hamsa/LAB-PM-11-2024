package com.example.h071221082;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        if (intent != null) {
            int profile = intent.getIntExtra("profil", 0);
            String fullname = intent.getStringExtra("fullname");
            String username = intent.getStringExtra("username");

            CircleImageView profileImage = findViewById(R.id.profile);
            TextView profileFullname = findViewById(R.id.fullname);
            TextView profileUsername = findViewById(R.id.username);

            profileImage.setImageResource(profile);
            profileFullname.setText(fullname);
            profileUsername.setText(username);
        }

    }
}