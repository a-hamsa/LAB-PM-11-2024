package com.example.tugastiga;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<People> data;

    public StoryAdapter(ArrayList<People> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        People people = data.get(position);

        holder.ivStoryProfile.setImageResource(people.getImageprofile());
        holder.tv_name.setText(people.getNama());

        holder.ivStoryProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.context, MainActivity2.class);
                intent.putExtra("people", people);
                holder.context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivStoryProfile;
        TextView tv_name;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStoryProfile = itemView.findViewById(R.id.iv_storyprofile);
            tv_name = itemView.findViewById(R.id.tv_nama);
            context = itemView.getContext();

        }
    }
}