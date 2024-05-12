package com.example.h071221082;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    public List<User> userList;
    private FragmentManager fragmentManager;

    public UserAdapter(List<User> userList, FragmentManager fragmentManager) {
        this.userList = userList;
        this.fragmentManager = fragmentManager;
    }
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user, parent, false);
        return new UserViewHolder(view);
    }
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);

        holder.userLinear.setOnClickListener(v -> {
            if(!MainActivity.adaInternet()){
                ConnectionFragment connectionFragment = new ConnectionFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, connectionFragment)
                        .commit();
            }else{
                Intent toDetailUserActivity = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                toDetailUserActivity.putExtra(ProfileActivity.PARCEL_DATA, user.getId());
                holder.itemView.getContext().startActivity(toDetailUserActivity);
            }

        });

    }
    public int getItemCount() {
        return userList.size();
    }
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView profile;
        private TextView username;
        private TextView email;
        private LinearLayout userLinear;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            userLinear = itemView.findViewById(R.id.userLinear);
        }
        public void bind(User user) {
            Picasso.get().load(user.getAvatar()).into(profile);
            username.setText(user.getFirst_name() + " " + user.getLast_name());
            email.setText(user.getEmail());
        }

    }
}