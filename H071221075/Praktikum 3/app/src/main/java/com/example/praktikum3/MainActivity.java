package com.example.praktikum3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView storyBar, post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
    }

    private void init(){
        storyBar = findViewById(R.id.story_bar);

        StoryAdapter storyAdapter = new StoryAdapter(DataSource.stories, this);
        storyBar.setAdapter(storyAdapter);
        storyBar.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        post = findViewById(R.id.post);
        post.setLayoutManager(new LinearLayoutManager(this));

        PostAdapter postAdapter = new PostAdapter(DataSource.stories, this);
        post.setAdapter(postAdapter);


    }
}