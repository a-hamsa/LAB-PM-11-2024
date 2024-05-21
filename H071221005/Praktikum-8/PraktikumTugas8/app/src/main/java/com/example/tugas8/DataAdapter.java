package com.example.tugas8;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private ArrayList<Data>datas;
    public DataAdapter(ArrayList<Data> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_catatan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        Data data = datas.get(position);
        holder.setData(data);

        holder.klikCatatan.setOnClickListener(v -> {
            Intent toEditActivity = new Intent(holder.itemView.getContext(), EditDataActivity.class);
            toEditActivity.putExtra(EditDataActivity.EXTRA_POSITION, position);
            toEditActivity.putExtra(EditDataActivity.EXTRA_DATA, data);
            holder.itemView.getContext().startActivity(toEditActivity);
            //melakukan finish pada halaman MainActivity
            if (holder.itemView.getContext() instanceof Activity) {
                ((Activity) holder.itemView.getContext()).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_created_updated;
        private final TextView tv_judul;
        private final TextView tv_desc;
        private final LinearLayout klikCatatan ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_created_updated = itemView.findViewById(R.id.tv_created_updated_at);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            klikCatatan = itemView.findViewById(R.id.klikCatatan);
        }
        public void setData(Data data) {
            if(data.getUpdate_at() == null){
                tv_created_updated.setText("Created at "+data.getCreated_at());
            }else{
                tv_created_updated.setText("Updated at "+data.getUpdate_at());
            }
            tv_judul.setText(data.getJudul());
            tv_desc.setText(data.getDesc());
        }
    }
}
