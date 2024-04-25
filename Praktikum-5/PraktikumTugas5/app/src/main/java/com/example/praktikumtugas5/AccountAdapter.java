package com.example.praktikumtugas5;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikumtugas5.Fragment.HomeFragment;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    private final ArrayList<Account> accounts;

    public AccountAdapter(ArrayList<Account> accounts) {
        this.accounts = accounts;

    }

    @NonNull
    @Override
    public AccountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountAdapter.ViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.setData(account);
        holder.pl_ll_profile.setOnClickListener(new View.OnClickListener() {
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
        LinearLayout pl_ll_profile;
        ImageView pl_iv_profile, pl_iv_post;
        TextView pl_tv_name, pl_tv_username, pl_tv_caption;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pl_ll_profile = itemView.findViewById(R.id.pl_ll_profile);
            pl_iv_profile = itemView.findViewById(R.id.pl_iv_profile);
            pl_iv_post = itemView.findViewById(R.id.pl_iv_post);
            pl_tv_name = itemView.findViewById(R.id.pl_tv_name);
            pl_tv_username = itemView.findViewById(R.id.pl_tv_username);
            pl_tv_caption = itemView.findViewById(R.id.pl_tv_caption);
        }

        public void setData(Account account) {
            if (account.getUriPost() != null){
                pl_iv_post.setImageURI(account.getUriPost());
            } else {
                pl_iv_post.setImageResource(account.getPost());
            }
            pl_iv_profile.setImageResource(account.getProfile());
            pl_tv_name.setText(account.getName());
            pl_tv_username.setText(account.getUsername());
            pl_tv_caption.setText(account.getCaption());
        }
    }
}
