package com.example.praktikum3.Adapter;

import static com.example.praktikum3.DataSource.posts;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.example.praktikum3.StoryModel;
import com.example.praktikum3.R;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    public static final int ADD_STORY_TYPE = 0;
    public static final int ALL_STORY_TYPE = 1;
    private ArrayList<StoryModel> storyModeles;



    public StoryAdapter(ArrayList<StoryModel> storyModeles) {
        this.storyModeles = storyModeles;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == ADD_STORY_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item_add, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        StoryModel storyModels = storyModeles.get(position);
        Post post = posts.get(position);


        int viewType = getItemViewType(position);

        if (viewType == ADD_STORY_TYPE) {
            String uid = storyModels.getUid();
            int image = storyModels.getImage();
            holder.setAddStory(uid, image);
        } else {
            String name = storyModels.getName();
            int image = storyModels.getImage();
            holder.setStory(name, image);
        }

        holder.profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.context, MainActivity3.class);
                intent.putExtra("storyModels", storyModels);
                intent.putExtra("Post", post);
                holder.context.startActivity(intent);
            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("data sa : ", String.valueOf(post));

                Intent intent = new Intent(holder.context, MainActivity2.class);
                intent.putExtra("Post", post);
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyModeles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? ADD_STORY_TYPE : ALL_STORY_TYPE;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView profile_img;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_id);
            profile_img = itemView.findViewById(R.id.userProfile_id);
            context = itemView.getContext();
        }

        public void setAddStory(String uid, int image) {
            title.setText("Cerita Anda");
            profile_img.setImageResource(image);
        }

        public void setStory(String name, int image) {
            title.setText(name);
            profile_img.setImageResource(image);
        }
    }
}
