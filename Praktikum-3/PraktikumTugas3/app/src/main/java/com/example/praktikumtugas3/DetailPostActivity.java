package com.example.praktikumtugas3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailPostActivity extends AppCompatActivity {

    ImageView actdp_profile, actdp_post;
    TextView actdp_username, actdp_caption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_post);

        actdp_profile = findViewById(R.id.actdp_profile);
        actdp_username = findViewById(R.id.actdp_username);
        actdp_post = findViewById(R.id.actdp_post);
        actdp_caption = findViewById(R.id.actdp_caption);

        int profile = getIntent().getIntExtra("kirim_profile", 0);
        int story = getIntent().getIntExtra("kirim_story",0);
        String username = getIntent().getStringExtra("kirim_username");
        int post = getIntent().getIntExtra("kirim_post",0);
        String caption = getIntent().getStringExtra("kirim_caption");
        int followers = getIntent().getIntExtra("kirim_followers",0);
        int following = getIntent().getIntExtra("kirim_following",0);

        actdp_profile.setImageResource(profile);
        actdp_username.setText(username);
        actdp_post.setImageResource(post);
        actdp_caption.setText(caption);

        actdp_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        actdp_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStory = new Intent(DetailPostActivity.this, StoryActivity.class);
                toStory.putExtra("kirim_story", story);
                toStory.putExtra("kirim_profile", profile);
                toStory.putExtra("kirim_post", post);
                toStory.putExtra("kirim_caption", caption);
                toStory.putExtra("kirim_username", username);
                toStory.putExtra("kirim_followers", followers);
                toStory.putExtra("kirim_following", following);
                startActivity(toStory);
                finish();
            }
        });

    }
}