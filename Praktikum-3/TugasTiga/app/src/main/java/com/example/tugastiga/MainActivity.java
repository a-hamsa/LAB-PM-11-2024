package com.example.tugastiga;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_story;
    private RecyclerView rv_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_story = findViewById(R.id.rv_story);
        rv_post = findViewById(R.id.rv_post);

        rv_story.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_post.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_story.setHasFixedSize(true);
        rv_post.setHasFixedSize(true);

        StoryAdapter storyAdapter = new StoryAdapter(DataSource.data);
        rv_story.setAdapter(storyAdapter);

        PostAdapter postAdapter = new PostAdapter(DataSource.data);
        rv_post.setAdapter(postAdapter);
    }
}