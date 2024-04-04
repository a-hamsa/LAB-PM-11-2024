package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private ImageView iv_profile ;

    private ImageView iv_story;
    private TextView tv_user_profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.d("data: ", "onCreate: test1");

        Intent intent = getIntent();
        Post posts = intent.getParcelableExtra("Post");
        StoryModel storyModels = intent.getParcelableExtra("storyModels");

        Log.d("data: ", String.valueOf(storyModels));

        iv_profile = findViewById(R.id.iv_profile);
        iv_story = findViewById(R.id.iv_story);
        tv_user_profile = findViewById(R.id.tv_user_profile);

        int image = storyModels.getImage();
        int imageStory = storyModels.getImageStory();
        String name = storyModels.getName();

        iv_profile.setImageResource(image);
        iv_story.setImageResource(imageStory);
        tv_user_profile.setText(name);

        tv_user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Data : tv_user", String.valueOf(storyModels));
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("storyModels", storyModels);
                intent.putExtra("Post", posts);

                startActivity(intent);
            }
        });
    }
}