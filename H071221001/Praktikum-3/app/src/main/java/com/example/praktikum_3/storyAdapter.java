package com.example.praktikum_3;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
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

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.ViewHolder> {
    private ArrayList<Model> stories;
    public storyAdapter(ArrayList<Model> stories) {
        this.stories = stories;
    }


    @NonNull
    @Override
    public storyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull storyAdapter.ViewHolder holder, int position) {
        Model story = stories.get(position);
        holder.image.setImageResource(story.getImageUser());
        holder.name.setText(story.getUsername());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, MainActivity2.class);
                intent.putExtra("model", story);
                holder.context.startActivity(intent);
            }
        });


    }
    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView name;
        private Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image1);
            name = itemView.findViewById(R.id.name1);
            context = itemView.getContext();
        }
    }
}
