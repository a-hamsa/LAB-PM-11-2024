package com.example.tugas5;

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

public class DataAdapter extends  RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private ArrayList<Data> datas;

    public DataAdapter(ArrayList<Data> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_postingan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        Data data = datas.get(position);
        holder.setData(data);

        holder.btnLihatProfile.setOnClickListener(v -> {
            Intent toProfile = new Intent(holder.itemView.getContext(), MainActivity2.class);
            toProfile.putExtra(MainActivity2.PARCEL_DATA, data);
            holder.itemView.getContext().startActivity(toProfile);
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgProfile;
        private final ImageView imgPost;
        private final TextView namaLengkap;
        private final TextView nickName;
        private final TextView desc;
        private final LinearLayout btnLihatProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            imgPost = itemView.findViewById(R.id.imgPost);
            namaLengkap = itemView.findViewById(R.id.namaLengkap);
            nickName = itemView.findViewById(R.id.nickName);
            desc = itemView.findViewById(R.id.desc);
            btnLihatProfile = itemView.findViewById((R.id.profileClick));

        }

        public void setData(Data data) {
            imgProfile.setImageResource(data.getImgProfile());

            if (data.getImgPost() != null) {
                imgPost.setImageResource(data.getImgPost());
            } else if (data.getUriImgPost() != null) {
                imgPost.setImageURI(data.getUriImgPost());
            }

            namaLengkap.setText(data.getNamaLengkap());
            nickName.setText(data.getNickName());
            desc.setText(data.getDesc());
        }
    }
}
