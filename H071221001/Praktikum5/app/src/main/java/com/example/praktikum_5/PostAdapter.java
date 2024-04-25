package com.example.praktikum_5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final ArrayList<Model> models;
    public PostAdapter(ArrayList<Model> models) {
        this.models = models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = this.models.get(position);
        holder.imgProfileIv.setImageResource(model.getProfileImg());
        holder.usernameTv.setText(model.getUsername());
        holder.nameTv.setText(model.getName());
        holder.descriptionTv.setText(model.getDescription());
        holder.imgPostIv.setImageURI(model.getImg());

        holder.profileContainer.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), DetailActivity.class);
            i.putExtra(ProfileFragment.EXTRA_USER, model);
            v.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return this.models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTv, nameTv, usernameTv;
        ImageView imgPostIv, imgProfileIv;
        LinearLayout profileContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProfileIv = itemView.findViewById(R.id.image_view);
            imgPostIv = itemView.findViewById(R.id.image_view2);
            usernameTv = itemView.findViewById(R.id.text_view1);
            nameTv = itemView.findViewById(R.id.text_view2);
            descriptionTv = itemView.findViewById(R.id.text_view3);
            profileContainer = itemView.findViewById(R.id.linear_layout1);
        }
    }
}
