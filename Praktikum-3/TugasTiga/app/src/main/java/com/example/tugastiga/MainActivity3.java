package com.example.tugastiga;

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

public class MainActivity3 extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_post;
    private TextView tv_nama, tv_followers, tv_following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();

        People people = intent.getParcelableExtra("people");


        // Inisialisasi views
        iv_profile = findViewById(R.id.iv_profile3);
        iv_post = findViewById(R.id.iv_post2);
        tv_nama = findViewById(R.id.tv_nama3);
        tv_followers = findViewById(R.id.tv_followers);
        tv_following = findViewById(R.id.tv_following);

        // Menampilkan data people pada views
        iv_profile.setImageResource(people.getImageprofile());
        iv_post.setImageResource(people.getImagepost());
        tv_nama.setText(people.getNama());
        tv_followers.setText(people.getFollowers().toString());
        tv_following.setText(people.getFollowing().toString());

        iv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("people", people);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("people", people);
                startActivity(intent);
            }
        });
    }
}