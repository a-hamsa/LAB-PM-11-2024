package com.example.tugaslima;

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

    private ArrayList<People> data;

    public PostAdapter(ArrayList<People> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        People people = data.get(position);

        holder.tv_username.setText(people.getUsername());
        holder.tv_name.setText(people.getName());
        holder.ivProfile.setImageResource(people.getImageprofile());
        holder.ivFeed.setImageResource(people.getImagepost());
        holder.IV_FotoPostingan.setImageURI(people.getSelectedImageUri());
        holder.tv_caption.setText(people.getCaption());

        holder.ivProfile.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("people", people);
            holder.context.startActivity(intent);
        });

        holder.tv_name.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("people", people);
            holder.context.startActivity(intent);
        });
        holder.tv_username.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("people", people);
            holder.context.startActivity(intent);
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_username, tv_name, tv_caption;
        ImageView ivProfile, IV_FotoPostingan, ivFeed;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFeed = itemView.findViewById(R.id.post_image);
            IV_FotoPostingan = itemView.findViewById(R.id.post_image);
            ivProfile = itemView.findViewById(R.id.nav_profile);
            tv_caption = itemView.findViewById(R.id.post_caption);
            tv_username = itemView.findViewById(R.id.post_username);
            tv_name = itemView.findViewById(R.id.post_name);
            context = itemView.getContext();
        }
    }
}