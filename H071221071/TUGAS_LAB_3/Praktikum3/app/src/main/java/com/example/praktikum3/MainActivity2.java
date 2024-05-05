package com.example.praktikum3;

import static com.example.praktikum3.DataSource.storyModeles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {



    private TextView tv_user;

    private ImageView tv_profile , iv_back_btn;


    private  ImageView iv_post;
    private  TextView tv_user2;

    private  TextView tv_pengikut;

    private  TextView tv_mengikuti;

    private  TextView tv_biodata;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        Post posts = intent.getParcelableExtra("Post");
        StoryModel storyModels = intent.getParcelableExtra("storyModels");

        Log.d("Data_main2 :", String.valueOf(storyModels));

        tv_profile = findViewById(R.id.iv_profile);
        tv_user = findViewById(R.id.tv_user);
        tv_user2 = findViewById(R.id.tv_user2);
        iv_post = findViewById(R.id.iv_post);
        tv_pengikut = findViewById(R.id.tv_pengikut);
        tv_mengikuti = findViewById(R.id.tv_mengikuti);
        tv_biodata = findViewById(R.id.tv_biodata);
        iv_back_btn = findViewById(R.id.back_btn_profile);

        Log.d("data image", String.valueOf(posts.getProfile()));
        int image = posts.getProfile();

        String user = posts.getUser();
        String user2 = posts.getUser2();
        int post = posts.getPost();
        String pengikut = posts.getPengikut();
        String mengikuti = posts.getMengikuti();
        String biodata = posts.getBiodata();




        tv_profile.setImageResource(image);
        tv_user.setText(user);
        tv_user2.setText(user2);
        iv_post.setImageResource(post);
        tv_pengikut.setText(pengikut);
        tv_mengikuti.setText(mengikuti);
        tv_biodata.setText(biodata);

        iv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("Post", posts);
                startActivity(intent);
            }
        });

        tv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("storyModels", storyModels);
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
