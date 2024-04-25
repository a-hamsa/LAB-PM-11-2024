package com.example.praktikum_5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<Model> models;

    public SearchAdapter(ArrayList<Model> models) {
        this.models = models;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = models.get(position);

        holder.IV_Search.setImageResource(model.getProfileImg());
        holder.tv_username.setText(model.getUsername());
        holder.tv_name.setText(model.getName());

        holder.searchlayout.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), DetailActivity.class);
            i.putExtra(ProfileFragment.EXTRA_USER, model);
            v.getContext().startActivity(i);
        });
    }


    public void filteredList(ArrayList<Model> filteredList) {
        models.clear();
        models.addAll(filteredList);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView IV_Search;
        TextView tv_username, tv_name;
        Context context;
        LinearLayout searchlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_Search = itemView.findViewById(R.id.itemsearchIV);
            tv_username = itemView.findViewById(R.id.itemsearchTV1);
            tv_name = itemView.findViewById(R.id.itemsearchTV2);
            searchlayout = itemView.findViewById(R.id.searchLL2);
            context = itemView.getContext();
        }
    }

}
