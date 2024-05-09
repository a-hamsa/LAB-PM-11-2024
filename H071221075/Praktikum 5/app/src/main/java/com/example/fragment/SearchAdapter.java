package com.example.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<Story> stories;
    private SearchFragment context;

    public SearchAdapter(SearchFragment context) {
        this.stories = new ArrayList<>();
        this.context = context;
    }


    public void setFilteredList (ArrayList<Story> filteredList) {
        this.stories = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.username.setText(stories.get(position).getUsername());

        if (stories.get(position).getImage() != null ){
            holder.imageView.setImageResource(stories.get(position).getImage());
        } else {
            holder.imageView.setImageURI(stories.get(position).getImageUri());
        }

        holder.username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSource.seenData.add(new SeenData(stories.get(position).getImage(), stories.get(position).getUsername()));

                Intent intent = new Intent(v.getContext(), Profile_.class);

                intent.putExtra("image", stories.get(position).getImage());
                intent.putExtra("username", stories.get(position).getUsername());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView username;
        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.fp_search);
            username =  view.findViewById(R.id.TV_username_search);

        }
    }
}
