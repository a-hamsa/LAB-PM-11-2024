package com.example.praktikum_3;

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

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private ArrayList<Model> feeds;
    public FeedAdapter(ArrayList<Model>feeds){
        this.feeds = feeds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model feed = feeds.get(position);
        holder.iv_user.setImageResource(feed.getImageUser());
        holder.iv_feeds.setImageResource(feed.getImageFeeds());
        holder.tv_username.setText(feed.getUsername());
        holder.tv_caption.setText(feed.getCaption());

        holder.iv_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, MainActivity2.class);
                intent.putExtra("model",feed);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("model",feed);
                holder.context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_user, iv_feeds;
        private TextView tv_username, tv_caption;
        private Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user = itemView.findViewById(R.id.iv_user);
            iv_feeds = itemView.findViewById(R.id.iv_feeds);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_caption = itemView.findViewById(R.id.tv_caption);
            context = itemView.getContext();
        }
    }
}
