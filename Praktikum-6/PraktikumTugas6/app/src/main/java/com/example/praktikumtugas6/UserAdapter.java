package com.example.praktikumtugas6;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    public List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.setData(user);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout li_ll;
        private ImageView li_iv_profile;
        private TextView li_tv_name;
        private TextView li_tv_email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            li_iv_profile = itemView.findViewById(R.id.li_iv_profile);
            li_tv_name = itemView.findViewById(R.id.li_tv_name);
            li_tv_email = itemView.findViewById(R.id.li_tv_email);
            li_ll = itemView.findViewById(R.id.li_ll);
            li_ll.setOnClickListener(v->{
                if (isConnected()) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        User clickedUser = userList.get(position);
                        Context context = itemView.getContext();
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("user", clickedUser.getId());
                        context.startActivity(intent);
                    }
                }
            });
        }

        private boolean isConnected() {
            ConnectivityManager connectivityManager = (ConnectivityManager) itemView.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
                if (activeNetwork != null) {
                    return activeNetwork.isConnected() || activeNetwork.isConnectedOrConnecting();
                }
            }
            return false;
        }

        public void setData(User user) {
            Picasso.get().load(user.getAvatar()).into(li_iv_profile);
            li_tv_name.setText(user.getFirst_name() + " " + user.getLast_name());
            li_tv_email.setText(user.getEmail());
        }
    }

}
