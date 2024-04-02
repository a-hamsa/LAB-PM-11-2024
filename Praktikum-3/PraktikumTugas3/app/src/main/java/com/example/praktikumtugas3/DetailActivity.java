package com.example.praktikumtugas3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView actd_username, actd_followers, actd_following;
    ImageView actd_profile, actd_post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        actd_username = findViewById(R.id.actd_username);
        actd_followers = findViewById(R.id.actd_followers);
        actd_following = findViewById(R.id.actd_following);
        actd_profile = findViewById(R.id.actd_profile);
        actd_post = findViewById(R.id.actd_post);

        int profile = getIntent().getIntExtra("kirim_profile", 0);
        int story = getIntent().getIntExtra("kirim_story",0);
        String username = getIntent().getStringExtra("kirim_username");
        int followers = getIntent().getIntExtra("kirim_followers",0);
        int following = getIntent().getIntExtra("kirim_following",0);
        int post = getIntent().getIntExtra("kirim_post",0);
        String caption = getIntent().getStringExtra("kirim_caption");

        actd_profile.setImageResource(profile);
        actd_username.setText(username);
        actd_following.setText(String.valueOf(following));
        actd_followers.setText(String.valueOf(followers));
        actd_post.setImageResource(post);

        actd_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStory = new Intent(DetailActivity.this, StoryActivity.class);
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
        actd_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDetaiLPost = new Intent(DetailActivity.this, DetailPostActivity.class);
                toDetaiLPost.putExtra("kirim_story", story);
                toDetaiLPost.putExtra("kirim_profile", profile);
                toDetaiLPost.putExtra("kirim_post", post);
                toDetaiLPost.putExtra("kirim_caption", caption);
                toDetaiLPost.putExtra("kirim_username", username);
                toDetaiLPost.putExtra("kirim_followers", followers);
                toDetaiLPost.putExtra("kirim_following", following);
                startActivity(toDetaiLPost);
                finish();
            }
        });
    }
}