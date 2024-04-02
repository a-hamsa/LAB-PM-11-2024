package com.example.praktikumtugas3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final ArrayList<Account> accounts;
    private final Context context;

    public PostAdapter(ArrayList<Account> accounts, Context context) {
        this.accounts = accounts;
        this.context = context;

    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.setData(account);
        holder.li2_iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION){
                    Intent toStory = new Intent(context, StoryActivity.class);
                    toStory.putExtra("kirim_story", accounts.get(position).getStory());
                    toStory.putExtra("kirim_profile", accounts.get(position).getProfile());
                    toStory.putExtra("kirim_username", accounts.get(position).getUsername());
                    context.startActivity(toStory);
                }
            }
        });
        holder.li2_tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent toDetail = new Intent(context, DetailActivity.class);
                    toDetail.putExtra("kirim_story", accounts.get(position).getStory());
                    toDetail.putExtra("kirim_profile", accounts.get(position).getProfile());
                    toDetail.putExtra("kirim_username", accounts.get(position).getUsername());
                    toDetail.putExtra("kirim_followers", accounts.get(position).getFollowers());
                    toDetail.putExtra("kirim_following", accounts.get(position).getFollowing());
                    toDetail.putExtra("kirim_post", accounts.get(position).getPost());
                    toDetail.putExtra("kirim_caption", accounts.get(position).getCaption());
                    context.startActivity(toDetail);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView li2_iv_profile, li2_iv_posts;
        TextView li2_tv_username, li2_tv_caption;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            li2_iv_profile = itemView.findViewById(R.id.li2_iv_profile);
            li2_tv_username = itemView.findViewById(R.id.li2_tv_username);
            li2_iv_posts = itemView.findViewById(R.id.li2_iv_posts);
            li2_tv_caption = itemView.findViewById(R.id.li2_tv_caption);
        }

        public void setData(Account account) {
            li2_iv_profile.setImageResource(account.getProfile());
            li2_tv_username.setText(account.getUsername());
            li2_iv_posts.setImageResource(account.getPost());
            li2_tv_caption.setText(account.getCaption());
        }
    }
}
