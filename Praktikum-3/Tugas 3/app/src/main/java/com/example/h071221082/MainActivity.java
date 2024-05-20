package com.example.h071221082;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_story, rv_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_story = findViewById(R.id.rv_story);
        rv_story.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        AdapterStory adapterStory = new AdapterStory(DataSource.accounts);
        rv_story.setAdapter(adapterStory);

        rv_post = findViewById(R.id.rv_post);
        rv_post.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Account> postAccounts = new ArrayList<>(DataSource.accounts);
        AdapterPost adapterPost = new AdapterPost(postAccounts);
        rv_post.setAdapter(adapterPost);
    }

}
