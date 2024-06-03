package com.example.makpakde.Adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makpakde.Activities.DetailActivity;
import com.example.makpakde.Database.DatabaseHelper;
import com.example.makpakde.Model.Recipe;
import com.example.makpakde.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    public List<Recipe> recipeList;
    public Context context;

    public SearchAdapter(List<Recipe> recipeList, Context context) {
        this.recipeList = recipeList;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.setData(recipe);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView li_search_iv_image;
        ImageButton li_search_ib_bookmark;
        TextView li_search_tv_label;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            li_search_iv_image = itemView.findViewById(R.id.li_search_iv_image);
            li_search_ib_bookmark = itemView.findViewById(R.id.li_search_ib_bookmark);
            li_search_tv_label = itemView.findViewById(R.id.li_search_tv_label);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        Recipe clickedRecipe =recipeList.get(position);
                        Context context = itemView.getContext();
                        Intent toDetail = new Intent(context, DetailActivity.class);
                        toDetail.putExtra("recipe", clickedRecipe.getUri());
                        toDetail.putExtra("label", clickedRecipe.getLabel());
                        context.startActivity(toDetail);
                    }
                }
            });


            li_search_ib_bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        DatabaseHelper databaseHelper = new DatabaseHelper(itemView.getContext());
                        Context context = itemView.getContext();

                        SharedPreferences preferencesUsername = context.getSharedPreferences("preferencesUsername", MODE_PRIVATE);
                        String usernameLogin = preferencesUsername.getString("usernameLogin", "");

                        Recipe clickedRecipe =recipeList.get(position);
                        int userId = databaseHelper.getIdLoginUser(usernameLogin);
                        databaseHelper.insertBookmarkRecipe(clickedRecipe.getUri(), userId);
                        Toast.makeText(context, "Recipes added to bookmarks", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

        public void setData(Recipe recipe) {
            Picasso.get().load(recipe.getImage()).into(li_search_iv_image);
            li_search_tv_label.setText(recipe.getLabel());
        }
    }

    public void setFilteredList (List<Recipe> filteredList){
        this.recipeList = filteredList;
        notifyDataSetChanged();
    }
}
