package com.example.tugas6;

import android.content.Intent;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
        return new UserViewHolder(view);
    }
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);

        holder.detailUser.setOnClickListener(v -> {
            if(!MainActivity.adaInternet()){
                ConnectionFragment connectionFragment = new ConnectionFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, connectionFragment)
                        .commit();
            }else{
                Intent toDetailUserActivity = new Intent(holder.itemView.getContext(), MainActivity2.class);
                toDetailUserActivity.putExtra(MainActivity2.PARCEL_DATA, user.getId());
                holder.itemView.getContext().startActivity(toDetailUserActivity);
            }

        });

    }
    public int getItemCount() {
        return userList.size();
    }
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatarImageView;
        private TextView nameTextView;
        private TextView emailTextView;
        private LinearLayout detailUser;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            detailUser = itemView.findViewById(R.id.detailUser);
        }
        public void bind(User user) {
            Picasso.get().load(user.getAvatar()).into(avatarImageView);
            nameTextView.setText(user.getFirst_name() + " " + user.getLast_name());
            emailTextView.setText(user.getEmail());
        }
    }
}