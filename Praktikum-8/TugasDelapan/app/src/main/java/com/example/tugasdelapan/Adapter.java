package com.example.tugasdelapan;

import static com.example.tugasdelapan.MainActivity.REQUEST_CODE_UPDATE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Data> data;

    public Adapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Data info = data.get(position);
        holder.tv_title.setText(info.getTitle());
        holder.tv_desc.setText(info.getDesc());

        String formattedTimestamp;
        if (info.isNew()) {
            formattedTimestamp = "Created at " + formatDate(info.getCreatedTimestamp());
        } else {
            formattedTimestamp = "Updated at " + formatDate(info.getUpdatedTimestamp());
        }
        holder.tv_time.setText(formattedTimestamp);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), UpdateActivity.class);

            int dataa = data.get(holder.getAdapterPosition()).getId();
            String id = Integer.toString(dataa);
            intent.putExtra("id", id);
            intent.putExtra("title", info.getTitle());
            intent.putExtra("desc", info.getDesc());
            ((MainActivity) context).startActivityForResult(intent, REQUEST_CODE_UPDATE);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_desc, tv_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Date date = new Date(timestamp);
        return sdf.format(date);
    }
}
