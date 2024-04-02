package com.example.praktikum_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        ImageView ivProfile = findViewById(R.id.photoprofile);
        TextView tvProfile = findViewById(R.id.usernameprofil);
        TextView tvAngkaFollowers = findViewById(R.id.jmlflowers);
        TextView tvAngkaFollowing = findViewById(R.id.jmlflowing);
        ImageView ivPost = findViewById(R.id.gambarpost);

        Intent intent = getIntent();
        Instagram instagram = intent.getParcelableExtra("instagram");

        ivProfile.setImageResource(instagram.getFotoProfile());
        ivPost.setImageResource(instagram.getFotoPostingan());
        tvProfile.setText(instagram.getUsername());
        tvAngkaFollowers.setText(String.valueOf(instagram.getFollowers()));
        tvAngkaFollowing.setText(String.valueOf(instagram.getFollowing()));

        ivPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, PostinganActivity.class);
                intent.putExtra("instagram",instagram);
                startActivity(intent);
            }
        });

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, StoryActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });

    }
}