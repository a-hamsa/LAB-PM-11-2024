package com.example.praktikum_4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private ClickListener clickListener;
    private final Context context;
    private final ArrayList<Model> models;

    public interface ClickListener {
        void onDeleteButtonClicked(Model model);
    }

    public PostAdapter(ArrayList<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    public void setOnDeleteButtonClickedListener(ClickListener clickListener) {
        this.clickListener = clickListener;
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
        holder.deleteBtn.setOnClickListener(new PostAdapter2(this, model));
        holder.profileContainer.setOnClickListener(new PostAdapter3(this, model));
    }

    public void onDeleteButtonClicked(Model model) {
        if (clickListener != null) {
            clickListener.onDeleteButtonClicked(model);
        }
    }

    public void onProfileContainerClicked(Model model) {
        Intent i = new Intent(this.context, DetailActivity.class);
        i.putExtra(ProfileFragment.EXTRA_USER, model);
        this.context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return this.models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageButton deleteBtn;
        TextView descriptionTv, nameTv,usernameTv;
        ImageView imgPostIv, imgProfileIv;
        LinearLayout profileContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imgProfileIv = itemView.findViewById(R.id.image_view);
            this.imgPostIv = itemView.findViewById(R.id.image_view2);
            this.usernameTv = itemView.findViewById(R.id.text_view1);
            this.nameTv = itemView.findViewById(R.id.text_view2);
            this.descriptionTv = itemView.findViewById(R.id.text_view3);
            this.deleteBtn = itemView.findViewById(R.id.image_button_trash);
            this.profileContainer = itemView.findViewById(R.id.linear_layout1);
            this.context = itemView.getContext();
        }
    }

    public static class PostAdapter2 implements View.OnClickListener {
        public final PostAdapter postAdapter;
        public final Model model;

        public PostAdapter2(PostAdapter postAdapter, Model model) {
            this.postAdapter = postAdapter;
            this.model = model;
        }

        public final void onClick(View view) {
            this.postAdapter.onDeleteButtonClicked(this.model);
        }
    }

    public static class PostAdapter3 implements View.OnClickListener {
        public final PostAdapter postAdapter;
        public final Model model;

        public PostAdapter3(PostAdapter postAdapter, Model model) {
            this.postAdapter = postAdapter;
            this.model = model;
        }

        public final void onClick(View view) {
            this.postAdapter.onProfileContainerClicked(this.model);
        }
    }
}
