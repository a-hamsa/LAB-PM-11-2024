package com.example.tugas3praktikum;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter2 extends RecyclerView.Adapter<DataAdapter2.ViewHolder> {
    private final ArrayList<Data> datas;


    public DataAdapter2(ArrayList<Data> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public DataAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_postingann,parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DataAdapter2.ViewHolder holder, int position) {
        Data data = datas.get(position);
        holder.setData(data);

        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStory = new Intent(holder.itemView.getContext(), MainActivity2.class);
                toStory.putExtra(MainActivity2.PARCEL_DATA, data);
                holder.itemView.getContext().startActivity(toStory);
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toProfile = new Intent(holder.itemView.getContext(), MainActivity3.class);
                toProfile.putExtra(MainActivity3.PARCEL_DATA, data);
                holder.itemView.getContext().startActivity(toProfile);
            }
        });
    }




    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgProfile;
        private final ImageView imgPost;
        private final TextView name;
        private final TextView descPost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            imgPost = itemView.findViewById(R.id.imgPost);
            name = itemView.findViewById(R.id.name);
            descPost = itemView.findViewById(R.id.desc);
        }

        public void setData(Data data) {
            imgProfile.setImageResource(data.getImgProfile());
            imgPost.setImageResource(data.getImgPost());
            name.setText(data.getName());
            descPost.setText(data.getDesc());
        }

    }

}
