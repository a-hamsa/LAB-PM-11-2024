package com.example.praktikumtugas4;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    private final ArrayList<Player> players;
    private final HomeFragment context;

    public PlayerAdapter(ArrayList<Player> players, HomeFragment context) {
        this.players = players;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.ViewHolder holder, int position) {
        Player player = players.get(position);
        holder.setData(player);
        holder.ll_li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION){
                    ProfileFragment profileFragment = new ProfileFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(ProfileFragment.EXTRA_NAME, players.get(position).getName());
                    bundle.putString(ProfileFragment.EXTRA_USERNAME, players.get(position).getUsername());
                    bundle.putInt(ProfileFragment.EXTRA_PROFILE, players.get(position).getProfile());
                    profileFragment.setArguments(bundle);
                    FragmentManager fragmentManager = context.getParentFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, profileFragment,ProfileFragment.class.getSimpleName()).addToBackStack(null).commit();
                }
            }
        });
        holder.li_ib_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionDialogFragment optionDialogFragment  = new OptionDialogFragment();
                FragmentManager fragmentManager = context.getChildFragmentManager();
                optionDialogFragment.show(fragmentManager,OptionDialogFragment.class.getSimpleName());

                optionDialogFragment.setOnDialogOptionSelectedListener(new OptionDialogFragment.OnDialogOptionSelectedListener() {
                    @Override
                    public void onOptionSelected(boolean isDeleteSelected) {
                        if (isDeleteSelected) {
                            int position = holder.getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                players.remove(position);
                                notifyItemRemoved(position);
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return players.size()   ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView li_iv_profile;
        TextView li_tv_name;
        TextView li_tv_username;
        ImageView li_iv_post;
        TextView li_tv_caption;
        ImageButton li_ib_delete;
        LinearLayout ll_li;
        Uri uriPost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            li_iv_profile = itemView.findViewById(R.id.li_iv_profile);
            li_tv_name = itemView.findViewById(R.id.li_tv_name);
            li_tv_username = itemView.findViewById(R.id.li_tv_username);
            li_iv_post = itemView.findViewById(R.id.li_iv_post);
            li_tv_caption = itemView.findViewById(R.id.li_tv_caption);
            li_ib_delete = itemView.findViewById(R.id.li_ib_delete);
            ll_li = itemView.findViewById(R.id.li_ll);
        }

        public void setData(Player player) {
            li_iv_profile.setImageResource(player.getProfile());
            li_tv_name.setText(player.getName());
            if (player.getUriPost() != null){
                li_iv_post.setImageURI(player.getUriPost());
            } else {
                li_iv_post.setImageResource(player.getPost());
            }
            li_tv_username.setText(player.getUsername());

            li_tv_caption.setText(player.getCaption());

        }
    }
}
