package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryView extends AppCompatActivity {
    private TextView username;
    private LinearLayout main;

    private CircleImageView photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.username_story);
        photo = findViewById(R.id.fp_pengguna);
        main = findViewById(R.id.main);

        int imageResId = getIntent().getIntExtra("image", 0);

        username.setText(getIntent().getStringExtra("username"));
        photo.setImageResource(imageResId);
        main.setBackgroundResource(imageResId);

        Log.i("ayam", getIntent().getStringExtra("username"));

    }

    public void profile(View view){
        Intent intent = new Intent(this, Profile.class);


        intent.putExtra("caption", getIntent().getStringExtra("caption"));
        intent.putExtra("image",getIntent().getIntExtra("image", 0));
        intent.putExtra("username", getIntent().getStringExtra("username"));

        startActivity(intent);
    }
}