package com.example.tugas3praktikum;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private final ArrayList<Data> datas;

    public DataAdapter(ArrayList<Data> datas) {
        this.datas = datas;
    }


    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_story,parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        //menangani item
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
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgProfile;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            name = itemView.findViewById(R.id.name);
        }

        public void setData(Data data) {
            imgProfile.setImageResource(data.getImgProfile());
            name.setText(data.getName());

        }

    }

}
