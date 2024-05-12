package com.example.h071221082;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProfile extends RecyclerView.Adapter<AdapterProfile.ViewHolder>{
    private ArrayList<Account> accounts;
    public AdapterProfile(ArrayList<Account> accounts){
        this.accounts = accounts;
    };

    @NonNull
    @Override
    public AdapterProfile.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_profile, parent, false);
        return new AdapterProfile.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProfile.ViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.story_profile.setImageResource(account.getProfile());
        holder.story_username.setText(account.getUsername());
        holder.story.setImageResource(account.getStory());
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView story_profile, story;
        private TextView story_username;

        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            story_profile = itemView.findViewById(R.id.story_profile);
            story = itemView.findViewById(R.id.story);
            story_username = itemView.findViewById(R.id.story_username);
        }
    }
}

