package com.example.praktikum3.Adapter;


import static com.example.praktikum3.DataSource.storyModeles;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum3.MainActivity2;
import com.example.praktikum3.MainActivity3;
import com.example.praktikum3.Post;
import com.example.praktikum3.R;
import com.example.praktikum3.StoryModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private final ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.setData(post);

        StoryModel storyModels = storyModeles.get(position);

        holder.tvUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.context, MainActivity2.class);
                intent.putExtra("Post", post);
                intent.putExtra("storyModels", storyModels);
                holder.context.startActivity(intent);
            }
        });

        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.context, MainActivity3.class);
                intent.putExtra("storyModels", storyModels);
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivProfile;
        private final TextView tvUser;
        private final ImageView ivPost;
        private final TextView tvUser2;
        private final TextView tvCaption;
        Context context;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tvUser = itemView.findViewById(R.id.tv_user_profile);
            ivPost = itemView.findViewById(R.id.iv_image_post);
            tvUser2 = itemView.findViewById(R.id.tv_user_profile2);
            tvCaption = itemView.findViewById(R.id.tv_caption);
            context = itemView.getContext();

        }

        public void setData(Post post) {
            ivProfile.setImageResource(post.getProfile());
            tvUser.setText(post.getUser());
            ivPost.setImageResource(post.getPost());
            tvUser2.setText(post.getUser2());
            tvCaption.setText(post.getCaption());
        }
    }
}