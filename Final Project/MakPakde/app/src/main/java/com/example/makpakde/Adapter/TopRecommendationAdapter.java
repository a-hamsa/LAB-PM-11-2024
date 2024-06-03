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
import com.example.makpakde.Model.Recipe;
import com.example.makpakde.Database.DatabaseHelper;
import com.example.makpakde.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopRecommendationAdapter extends RecyclerView.Adapter<TopRecommendationAdapter.ViewHolder> {
    public List<Recipe> recipeList;

    public TopRecommendationAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public TopRecommendationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_toprecommendation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRecommendationAdapter.ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.setData(recipe);


    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView li_tr_iv_image;
        TextView li_tr_tv_label;
        TextView li_tr_tv_totalTime;
        TextView li_tr_tv_mealType;
        ImageButton li_tr_ib_bookmark;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            li_tr_iv_image = itemView.findViewById(R.id.li_tr_iv_image);
            li_tr_tv_label = itemView.findViewById(R.id.li_tr_tv_label);
            li_tr_tv_totalTime = itemView.findViewById(R.id.li_tr_tv_totalTime);
            li_tr_tv_mealType = itemView.findViewById(R.id.li_tr_tv_mealType);
            li_tr_ib_bookmark = itemView.findViewById(R.id.li_tr_ib_bookmark);
            itemView.setOnClickListener(new View.OnClickListener() {
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
                        databaseHelper.insertRecentRecipe(clickedRecipe.getUri(), userId);

                        Intent toDetail = new Intent(context, DetailActivity.class);
                        toDetail.putExtra("recipe", clickedRecipe.getUri());
                        toDetail.putExtra("label", clickedRecipe.getLabel());
                        context.startActivity(toDetail);
                    }
                }
            });
            li_tr_ib_bookmark.setOnClickListener(new View.OnClickListener() {
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
            String formatTolalTime = String.format("%.0f",recipe.getTotalTime());

            Picasso.get().load(recipe.getImage()).into(li_tr_iv_image);
            li_tr_tv_label.setText(recipe.getLabel());
            li_tr_tv_totalTime.setText(formatTolalTime + " Minute");
            li_tr_tv_mealType.setText(formatListToString(recipe.getMealType()));
        }
        private String formatListToString(List<String> list) {
            if (list == null || list.isEmpty()) {
                return "";
            }
            StringBuilder formattedString = new StringBuilder();
            for (String item : list) {
                formattedString.append(item).append(", ");
            }
            if (formattedString.length() > 0) {
                formattedString.setLength(formattedString.length() - 2);
            }
            return formattedString.toString();
        }
    }
}
