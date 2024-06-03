package com.example.praktikum_8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private Context context;
    private List<DataModel> dataList;

    public DataAdapter(Context context, List<DataModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataModel data = dataList.get(position);
        holder.tvTitle.setText(data.getTitle());
        holder.tvDescription.setText(data.getDescription());
        holder.tvTimestamp.setText(data.getTimestamp());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("record_id", data.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription, tvTimestamp;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_desc);
            tvTimestamp = itemView.findViewById(R.id.tv_timestamp);
        }
    }
}
