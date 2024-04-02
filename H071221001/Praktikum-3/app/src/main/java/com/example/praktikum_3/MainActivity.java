package com.example.praktikum_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_story, rv_feeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_story = findViewById(R.id.rv_story);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rv_story.setLayoutManager(linearLayoutManager);

        storyAdapter StoryAdapter = new storyAdapter(DataSource.models);
        rv_story.setAdapter(StoryAdapter);

        rv_feeds = findViewById(R.id.rv_feeds);
        rv_feeds.setLayoutManager(new LinearLayoutManager(this));

        FeedAdapter feedAdapter = new FeedAdapter(DataSource.models);
        rv_feeds.setAdapter(feedAdapter);


    }
}