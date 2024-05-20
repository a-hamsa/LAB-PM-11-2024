package com.example.h071221082;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PathDashPathEffect;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.ViewHolder> {

    private ArrayList<Account> accounts;

    public AdapterPost(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPost.ViewHolder holder, int position) {
        Account account = accounts.get(position);

        Integer image = account.getImage();
        Uri image2 = account.getAddPost();

        if (image != null) {
            holder.image.setImageResource(account.getImage());
        } else if (image2 != null) {
            holder.image.setImageURI(account.getAddPost());
        }

        holder.profile.setImageResource(account.getProfile());
        holder.profile.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ProfileActivity.class);
            intent.putExtra("profil", account.getProfile());
            intent.putExtra("fullname", account.getFullname());
            intent.putExtra("username", account.getUsername());
            intent.putExtra("konten", account.getKonten());
            view.getContext().startActivity(intent);
        });

        holder.fullname.setText(account.getFullname());
        holder.fullname.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ProfileActivity.class);
            intent.putExtra("profil", account.getProfile());
            intent.putExtra("fullname", account.getFullname());
            intent.putExtra("username", account.getUsername());
            intent.putExtra("konten", account.getKonten());
            view.getContext().startActivity(intent);
        });

        holder.username.setText(account.getUsername());
        holder.username.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ProfileActivity.class);
            intent.putExtra("profil", account.getProfile());
            intent.putExtra("fullname", account.getFullname());
            intent.putExtra("username", account.getUsername());
            intent.putExtra("konten", account.getKonten());
            view.getContext().startActivity(intent);
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPostition = holder.getAdapterPosition();
                if (adapterPostition != RecyclerView.NO_POSITION){
                    showDeleteConfirmationDialog(holder.itemView.getContext(), adapterPostition);
                }
            }
        });

        holder.konten.setText(account.getKonten());
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image, profile;
        private TextView fullname, username, konten;

        ImageView deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            profile = itemView.findViewById(R.id.profile);
            fullname = itemView.findViewById(R.id.fullname);
            username = itemView.findViewById(R.id.username);
            konten = itemView.findViewById(R.id.konten);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }

    private void showDeleteConfirmationDialog(Context context, int position) {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_delete_post);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_dialog_bg));

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        Button btnDelete = dialog.findViewById(R.id.btn_delete);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accounts.remove(position);
                notifyItemRemoved(position);
                dialog.dismiss();
                Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
}
