package com.example.praktikum_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_story;
    private TextView tv_nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        Instagram instagram = intent.getParcelableExtra("instagram");

        iv_profile = findViewById(R.id.pp);
        tv_nama = findViewById(R.id.username);
        iv_story = findViewById(R.id.story);

        iv_profile.setImageResource(instagram.getFotoProfile());
        iv_story.setImageResource(instagram.getFotoStory());
        tv_nama.setText(instagram.getUsername());

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryActivity.this, ProfilActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });
    }
}