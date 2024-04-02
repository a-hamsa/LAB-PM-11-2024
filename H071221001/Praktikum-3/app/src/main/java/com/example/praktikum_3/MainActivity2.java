package com.example.praktikum_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ImageView img, img1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = findViewById(R.id.is_user);
        img1 = findViewById(R.id.is_gambar);
        tv = findViewById(R.id.is_username);


        Intent intent = getIntent();
        Model story = intent.getParcelableExtra("model");

        tv.setText(story.getUsername());
        img.setImageResource(story.getImageUser());
        img1.setImageResource(story.getImage2());

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ProfileActivity.class);
                intent.putExtra("model",story);

                startActivity(intent);

            }
        });




    }

}