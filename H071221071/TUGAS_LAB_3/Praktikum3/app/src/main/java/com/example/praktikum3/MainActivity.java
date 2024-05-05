package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.praktikum3.Adapter.PostAdapter;
import com.example.praktikum3.Adapter.StoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }
    private static int ADD_STORY_TYPE=0;
    private static int ALL_STORY_TYPE=1;

    StoryAdapter adapter;

    List<StoryModel> modelList = new ArrayList<>();
    RecyclerView rv_story, rv_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_story = findViewById(R.id.story_RecycleView_id);
        rv_post = findViewById(R.id.rv_posts);


        rv_story = findViewById(R.id.story_RecycleView_id);
        rv_post = findViewById(R.id.rv_posts);

        rv_story.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_post.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_story.setHasFixedSize(true);
        rv_post.setHasFixedSize(true);

        StoryAdapter storyAdapter = new StoryAdapter(DataSource.storyModeles);
        rv_story.setAdapter(storyAdapter);

        PostAdapter postAdapter = new PostAdapter(DataSource.posts);
        rv_post.setAdapter(postAdapter);




    }
}