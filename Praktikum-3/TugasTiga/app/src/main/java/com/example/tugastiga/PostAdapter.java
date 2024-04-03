package com.example.tugastiga;

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

    public PostAdapter(ArrayList<People> data){this.data = data;}

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {

        People people = data.get(position);

        holder.tv_namaProfile.setText(people.getNama());
        holder.ivProfile.setImageResource(people.getImageprofile());
        holder.ivPost.setImageResource(people.getImagepost());
        holder.tv_caption.setText(people.getCaption());

        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.context, MainActivity2.class);

                intent.putExtra("people", people);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_namaProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Membuat intent
                Intent intent = new Intent(holder.context, MainActivity3.class);
                // Mengirim data melalui intent
                intent.putExtra("people", people);

                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPost, ivProfile;
        TextView tv_caption, tv_namaProfile;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPost = itemView.findViewById(R.id.iv_post);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tv_namaProfile = itemView.findViewById(R.id.tv_namaprofile);
            tv_caption = itemView.findViewById(R.id.tv_caption);
            context = itemView.getContext();

        }
    }
}