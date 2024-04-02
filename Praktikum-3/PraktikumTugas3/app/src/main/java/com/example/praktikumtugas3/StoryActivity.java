package com.example.praktikumtugas3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StoryActivity extends AppCompatActivity {
    ImageView acts_profile;
    ImageView acts_story;
    TextView acts_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story);

        acts_profile = findViewById(R.id.acts_profile);
        acts_story = findViewById(R.id.acts_story);
        acts_username = findViewById(R.id.acts_username);

        int profile = getIntent().getIntExtra("kirim_profile", 0);
        int post = getIntent().getIntExtra("kirim_post", 0);
        String caption = getIntent().getStringExtra("kirim_caption");
        int followers = getIntent().getIntExtra("kirim_followers", 0);
        int following = getIntent().getIntExtra("kirim_following", 0);
        int story = getIntent().getIntExtra("kirim_story",0);
        String username = getIntent().getStringExtra("kirim_username");

        acts_profile.setImageResource(profile);
        acts_story.setImageResource(story);
        acts_username.setText(username);

        acts_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDetaiLPost = new Intent(StoryActivity.this, DetailActivity.class);
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