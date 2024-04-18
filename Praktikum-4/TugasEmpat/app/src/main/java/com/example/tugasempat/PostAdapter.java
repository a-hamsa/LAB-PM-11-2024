package com.example.tugasempat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
        holder.IVFeed.setImageURI(people.getSelectedImageUri());
        holder.tv_caption.setText(people.getCaption());

        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("people", people);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("people", people);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("people", people);
                holder.context.startActivity(intent);
            }
        });

        holder.ivDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
            builder.setTitle("Konfirmasi");
            builder.setMessage("Apakah Anda yakin ingin menghapus postingan ini?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        data.remove(adapterPosition);
                        notifyItemRemoved(adapterPosition);
                    }
                }
            });

            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFeed, ivProfile, ivDelete, IVFeed;
        TextView tv_caption, tv_username, tv_name;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFeed = itemView.findViewById(R.id.post_image);
            IVFeed = itemView.findViewById(R.id.post_image);
            ivProfile = itemView.findViewById(R.id.nav_profile);
            ivDelete = itemView.findViewById(R.id.post_delete);
            tv_caption = itemView.findViewById(R.id.post_caption);
            tv_username = itemView.findViewById(R.id.post_username);
            tv_name = itemView.findViewById(R.id.post_name);
            context = itemView.getContext();
        }
    }
}