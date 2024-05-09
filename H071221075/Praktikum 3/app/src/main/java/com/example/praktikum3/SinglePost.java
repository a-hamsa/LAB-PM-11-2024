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

public class SinglePost extends AppCompatActivity {
    private TextView username1, username2, caption;
    private CircleImageView fp;
    private ImageView post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_single_post);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    username1 = findViewById(R.id.username_1);
    username2 = findViewById(R.id.username2);
    fp = findViewById(R.id.fp_post);
    post = findViewById(R.id.photo_post);
    caption = findViewById(R.id.caption1);

    int id = getIntent().getIntExtra("image",0);

    fp.setImageResource(id);
    post.setImageResource(id);
    username2.setText(getIntent().getStringExtra("username"));
    username1.setText(getIntent().getStringExtra("username"));
    caption.setText(getIntent().getStringExtra("caption"));

    }

    public void story(View view){
        Intent intent = new Intent(this, StoryView.class);



        intent.putExtra("image",getIntent().getIntExtra("image", 0));
        intent.putExtra("username", getIntent().getStringExtra("username"));
        intent.putExtra("caption", getIntent().getStringExtra("caption"));

        startActivity(intent);
    }

    public void profilepost(View view){
        Intent intent = new Intent(this, Profile.class);

        intent.putExtra("image", getIntent().getIntExtra("image",0) );
        intent.putExtra("username", getIntent().getStringExtra("username"));
        intent.putExtra("caption", getIntent().getStringExtra("caption"));

        startActivity(intent);
    }
}