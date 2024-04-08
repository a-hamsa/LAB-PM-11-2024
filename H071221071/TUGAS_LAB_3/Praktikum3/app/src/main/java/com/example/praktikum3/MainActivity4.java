package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    private ImageView iv_profil, iv_postingan;
    private TextView tv_username1, tv_username2, tv_caption;
    private ImageView iv_back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        Post posts = intent.getParcelableExtra("Post");

        if (posts != null) {
            iv_profil = findViewById(R.id.iv_profile_user);
            tv_username1 = findViewById(R.id.tv_posts_user);
            iv_postingan = findViewById(R.id.iv_user_post);
            tv_username2 = findViewById(R.id.tv_posts_user2);
            tv_caption = findViewById(R.id.tv_caption_user);
            iv_back_btn = findViewById(R.id.back_btn);


            iv_profil.setImageResource(posts.getProfile());
            iv_postingan.setImageResource(posts.getPost());
            tv_username1.setText(posts.getUser());
            tv_username2.setText(posts.getUser());
            tv_caption.setText(posts.getCaption());

            tv_username1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                    intent.putExtra("Post", posts);
                    startActivity(intent);
                }
            });

            iv_back_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }
    }
}
