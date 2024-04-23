package com.example.praktikumtugas5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikumtugas5.Fragment.SearchFragment;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private ArrayList<Account> accounts;


    public SearchAdapter(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.setData(account);
        holder.sl_ll_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toProfileActivity = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                toProfileActivity.putExtra(ProfileActivity.PARCEL_ACCOUNT, account);
                holder.itemView.getContext().startActivity(toProfileActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout sl_ll_profile;
        ImageView sl_iv_profile;
        TextView sl_tv_name, sl_tv_username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sl_ll_profile = itemView.findViewById(R.id.sl_ll_profile);
            sl_iv_profile = itemView.findViewById(R.id.sl_iv_profile);
            sl_tv_name = itemView.findViewById(R.id.sl_tv_name);
            sl_tv_username = itemView.findViewById(R.id.sl_tv_username);
        }

        public void setData(Account account) {
            sl_tv_username.setText(account.getUsername());
            sl_tv_name.setText(account.getName());
            sl_iv_profile.setImageResource(account.getProfile());
        }
    }

    public void setFilteredList (ArrayList<Account> filteredList){
        this.accounts = filteredList;
        notifyDataSetChanged();
    }
}
