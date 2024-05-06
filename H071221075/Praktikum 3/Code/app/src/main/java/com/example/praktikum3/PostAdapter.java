package com.example.praktikum3;

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

    private ArrayList<Story> stories;

    private Context context;

    public PostAdapter(ArrayList<Story> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.caption.setText(stories.get(position).getCaption());
        holder.username1.setText(stories.get(position).getUsername());
        holder.username2.setText(stories.get(position).getUsername());
        holder.photo.setImageResource(stories.get(position).getImage());
        holder.iv.setImageResource(stories.get(position).getImage());

        holder.username1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Profile.class);

                intent.putExtra("image", stories.get(position).getImage());
                intent.putExtra("username", stories.get(position).getUsername());

                context.startActivity(intent);



            }
        });

        holder.username2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Profile.class);

                intent.putExtra("image", stories.get(position).getImage());
                intent.putExtra("username", stories.get(position).getUsername());
                intent.putExtra("caption", stories.get(position).getCaption());

                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView username1, username2, caption;
        ImageView photo,iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username1 = itemView.findViewById(R.id.username_1);
            username2 = itemView.findViewById(R.id.username2);
            caption =  itemView.findViewById(R.id.caption1);
            photo = itemView.findViewById(R.id.photo_post);
            iv = itemView.findViewById(R.id.fp_post);
        }
    }
}
