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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private ArrayList<Data> dataSearch;

    public SearchAdapter(ArrayList<Data> dataSearch) {
        this.dataSearch = dataSearch;
    }


    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_search_result, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Data data = dataSearch.get(position);
        holder.setData(data);

        holder.btnLihatAkun.setOnClickListener(v -> {
            Intent toAkun = new Intent(holder.itemView.getContext(), MainActivity2.class);
            toAkun.putExtra(MainActivity2.PARCEL_DATA, data);
            holder.itemView.getContext().startActivity(toAkun);
        });



    }

    @Override
    public int getItemCount() {
        return dataSearch.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgProfile;
        private final TextView namaLengkap;
        private final TextView nickName;
        private final LinearLayout btnLihatAkun;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            namaLengkap = itemView.findViewById(R.id.namaLengkap);
            nickName = itemView.findViewById(R.id.nickName);
            btnLihatAkun = itemView.findViewById((R.id.akunClick));
        }

        public void setData(Data data) {
            imgProfile.setImageResource(data.getImgProfile());
            namaLengkap.setText(data.getNamaLengkap());
            nickName.setText(data.getNickName());
        }
    }
}
