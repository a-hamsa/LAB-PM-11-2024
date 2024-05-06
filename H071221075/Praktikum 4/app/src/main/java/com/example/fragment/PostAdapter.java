package com.example.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Story> stories;

    private HomeFragment context;

    public PostAdapter(ArrayList<Story> stories, HomeFragment context) {
        this.stories = stories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.caption.setText(stories.get(position).getCaption());
        holder.username1.setText(stories.get(position).getUsername());
        holder.username2.setText(stories.get(position).getUsername());

        if (stories.get(position).getImage() != null ){
            holder.photo.setImageResource(stories.get(position).getImage());
        } else {
            holder.photo.setImageURI(stories.get(position).getImageUri());
        }

        holder.username1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Profile.class);

                intent.putExtra("image", stories.get(position).getImage());
                intent.putExtra("username", stories.get(position).getUsername());

                context.startActivity(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Hapus Postingan");
                builder.setMessage("Apakah anda yakin untuk menghapus?");

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        stories.remove(holder.getAdapterPosition());
                        notifyItemRemoved(position);
                    }
                });

                builder.setNegativeButton("Batal", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        holder.username2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Profile.class);

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
        Button delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username1 = itemView.findViewById(R.id.username_caption);
            username2 = itemView.findViewById(R.id.main_username);
            caption =  itemView.findViewById(R.id.caption1);
            photo = itemView.findViewById(R.id.photo_post);
            iv = itemView.findViewById(R.id.fp_post);
            delete =  itemView.findViewById(R.id.delete);
        }
    }
}
