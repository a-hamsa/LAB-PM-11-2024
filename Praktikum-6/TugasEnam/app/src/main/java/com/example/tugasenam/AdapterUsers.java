package com.example.tugasenam;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.ViewHolder> {
    ArrayList<User> users;

    public AdapterUsers(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.tv_name.setText(user.getFirst_name() + " " + user.getLast_name());
        holder.tv_email.setText(user.getEmail());
        Picasso.get().load(user.getAvatar()).into(holder.ivprofile);

        holder.itemView.setOnClickListener(v -> {
            int data = users.get(holder.getAdapterPosition()).getId();
            String id = Integer.toString(data);
            Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
            intent.putExtra("id", id);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void addData(List<User> newData) {
        int startPosition = users.size();
        users.addAll(newData);
        notifyItemRangeInserted(startPosition, newData.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivprofile;
        TextView tv_name, tv_email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivprofile = itemView.findViewById(R.id.profile);
            tv_name = itemView.findViewById(R.id.name);
            tv_email = itemView.findViewById(R.id.email);
        }
    }
}