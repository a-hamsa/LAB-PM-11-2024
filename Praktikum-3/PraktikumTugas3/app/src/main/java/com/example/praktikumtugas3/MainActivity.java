package com.example.praktikumtugas3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_stories, rv_posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_stories = findViewById(R.id.rv_stories);
        rv_stories.setHasFixedSize(true);
        StoryAdapter storyAdapter = new StoryAdapter(DataSource.accounts, this);
        rv_stories.setAdapter(storyAdapter);

        rv_posts = findViewById(R.id.rv_posts);
        rv_posts.setHasFixedSize(true);
        PostAdapter postAdapter = new PostAdapter(DataSource.accounts, this);
        rv_posts.setAdapter(postAdapter);

    }
}