package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    private RecyclerView storyBar, post;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView){
        storyBar = rootView.findViewById(R.id.story_bar);
        storyBar.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        StoryAdapter storyAdapter = new StoryAdapter(DataSource.stories, HomeFragment.class);
        storyBar.setAdapter(storyAdapter);

        post = rootView.findViewById(R.id.post);
        post.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        PostAdapter postAdapter = new PostAdapter(DataSource.stories, this);
        post.setAdapter(postAdapter);
    }
}
