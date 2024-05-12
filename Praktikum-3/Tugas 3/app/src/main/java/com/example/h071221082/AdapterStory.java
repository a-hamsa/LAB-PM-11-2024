package com.example.h071221082;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.ViewHolder> {

    private ArrayList<Account> accounts;
    public AdapterStory(ArrayList<Account> accounts){
        this.accounts = accounts;
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.story_profile.setImageResource(account.getProfile());
        holder.story_username.setText(account.getUsername());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), StoryActivity.class);
            intent.putExtra("profile", account.getProfile());
            intent.putExtra("username", account.getUsername());
            intent.putExtra("story", account.getStory());
            intent.putExtra("image", account.getImage());
            intent.putExtra("follower", account.getFollower());
            intent.putExtra("following", account.getFollowing());
            intent.putExtra("describe", account.getDescribe());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView story_profile;
        private TextView story_username;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            story_profile = itemView.findViewById(R.id.story_profile);
            story_username = itemView.findViewById(R.id.story_username);
        }
    }
}