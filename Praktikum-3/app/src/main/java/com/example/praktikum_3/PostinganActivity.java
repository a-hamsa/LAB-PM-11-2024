package com.example.praktikum_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PostinganActivity extends AppCompatActivity {
    private ImageView iv_profile;
    private ImageView iv_feed;
    private TextView tv_nama, tv_caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postingann);

        Intent intent = getIntent();
        Instagram instagram = intent.getParcelableExtra("instagram");

        iv_profile = findViewById(R.id.pp);
        tv_nama = findViewById(R.id.username);
        iv_feed = findViewById(R.id.postingan);
        tv_caption = findViewById(R.id.caption);

        iv_profile.setImageResource(instagram.getFotoProfile());
        iv_feed.setImageResource(instagram.getFotoPostingan());
        tv_nama.setText(instagram.getUsername());
        tv_caption.setText(String.valueOf(instagram.getDeskripsi()));

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostinganActivity.this, ProfilActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostinganActivity.this, StoryActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });


    }
}