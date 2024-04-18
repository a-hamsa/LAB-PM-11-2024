package com.example.tugasempat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView ivProfile = findViewById(R.id.iv_profile);
        TextView tvName = findViewById(R.id.name);
        TextView tvUsername = findViewById(R.id.username);

        Intent intent = getIntent();
        People people = intent.getParcelableExtra("people");

        ivProfile.setImageResource(people.getImageprofile());
        tvName.setText(people.getName());
        tvUsername.setText(people.getUsername());
    }
}