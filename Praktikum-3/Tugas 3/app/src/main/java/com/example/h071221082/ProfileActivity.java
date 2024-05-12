package com.example.h071221082;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        if (intent != null) {
            int profile = intent.getIntExtra("profile", 0);
            String username = intent.getStringExtra("username");
            String follower = intent.getStringExtra("follower");
            String following = intent.getStringExtra("following");
            String describe = intent.getStringExtra("describe");
            int image = intent.getIntExtra("image", 0);
            int story = intent.getIntExtra("story", 0);

            CircleImageView storyProfile = findViewById(R.id.story_profile);
            TextView storyUsername = findViewById(R.id.story_username);
            TextView followerTextView = findViewById(R.id.follower);
            TextView followingTextView = findViewById(R.id.following);

            ImageView postImage = findViewById(R.id.image);
            LinearLayout storyImageLayout = findViewById(R.id.story);

            storyProfile.setImageResource(profile);
            storyUsername.setText(username);
            followerTextView.setText(follower);
            followingTextView.setText(following);
            postImage.setImageResource(image);

            storyProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProfileActivity.this, StoryActivity.class);
                    intent.putExtra("profile", profile);
                    intent.putExtra("username", username);
                    intent.putExtra("follower", follower);
                    intent.putExtra("following", following);
                    intent.putExtra("describe", describe);
                    intent.putExtra("image", image);
                    intent.putExtra("story", story);
                    startActivity(intent);
                }
            });

            postImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProfileActivity.this, PostActivity.class);
                    intent.putExtra("profile", profile);
                    intent.putExtra("username", username);
                    intent.putExtra("image", image);
                    intent.putExtra("story", story);
                    intent.putExtra("follower", follower);
                    intent.putExtra("following", following);
                    intent.putExtra("describe", describe);
                    startActivity(intent);
                }
            });
        }
    }
}
