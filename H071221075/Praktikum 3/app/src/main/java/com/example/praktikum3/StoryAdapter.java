package com.example.praktikum3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    private final ArrayList<Story> data;
    private final Context context;

    public StoryAdapter(ArrayList<Story> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.story_item, parent, false);
        StoryViewHolder viewHolder = new StoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        if (data.get(position).isSeen()) {
//            holder.storyOutline.setCardBackgroundColor(context.getResources().getColor(R.color.grey));
//        }

        holder.story.setImageResource(data.get(position).getImage());
        holder.username.setText(data.get(position).getUsername());

        holder.story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StoryView.class);

                intent.putExtra("image", data.get(position).getImage());




                context.startActivity(intent);
                holder.storyOutline.setCardBackgroundColor(context.getResources().getColor(R.color.grey));
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        ImageView story;
        private final CardView storyOutline;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);

            storyOutline = itemView.findViewById(R.id.story_outline);
            story = itemView.findViewById(R.id.story_image);
            username = itemView.findViewById(R.id.story_username);
        }
    }
}
