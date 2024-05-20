package com.example.h071221082;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();
        if (intent != null) {
            int profile = intent.getIntExtra("profile", 0);
            String username = intent.getStringExtra("username");
            int story = intent.getIntExtra("story", 0);
            int image = intent.getIntExtra("image", 0);
            String follower = intent.getStringExtra("follower");
            String following = intent.getStringExtra("following");
            String describe = intent.getStringExtra("describe");

            CircleImageView storyProfile = findViewById(R.id.story_profile);
            ImageView postImage = findViewById(R.id.image);
            TextView usernameTextView = findViewById(R.id.story_username);
            TextView describeTextView = findViewById(R.id.describe);

            storyProfile.setImageResource(profile);
            storyProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent profileIntent = new Intent(PostActivity.this, StoryActivity.class);
                    profileIntent.putExtra("profile", profile);
                    profileIntent.putExtra("username", username);
                    profileIntent.putExtra("image", image);
                    profileIntent.putExtra("story", story);
                    profileIntent.putExtra("follower", follower);
                    profileIntent.putExtra("following", following);
                    profileIntent.putExtra("describe", describe);
                    startActivity(profileIntent);
                }
            });

            postImage.setImageResource(image);
            usernameTextView.setText(username);
            describeTextView.setText(describe);

            usernameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
