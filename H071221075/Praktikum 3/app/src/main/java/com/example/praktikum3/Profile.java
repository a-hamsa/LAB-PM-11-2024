package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {
    private TextView username;
    private CircleImageView gambar;
    private ImageView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.nama_pengguna_profile);
        post = findViewById(R.id.post_profile);
        gambar = findViewById(R.id.fp_pengguna);

        username.setText(getIntent().getStringExtra("username"));
        int id = getIntent().getIntExtra("image", 0);
        post.setImageResource(id);
        gambar.setImageResource(id);


    }

    public void fp(View view) {
        Intent intent = new Intent(this, StoryView.class);

        intent.putExtra("image", getIntent().getIntExtra("image", 0));
        intent.putExtra("username", getIntent().getStringExtra("username"));

        intent.putExtra("caption", getIntent().getStringExtra("caption"));

        startActivity(intent);
    }

    public void singlepost(View view) {
        Intent intent = new Intent(this, SinglePost.class);

        intent.putExtra("image", getIntent().getIntExtra("image", 0));
        intent.putExtra("username", getIntent().getStringExtra("username"));
        intent.putExtra("caption", getIntent().getStringExtra("caption"));

        startActivity(intent);
    }

}