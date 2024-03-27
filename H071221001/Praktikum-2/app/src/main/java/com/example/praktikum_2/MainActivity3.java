package com.example.praktikum_2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity3 extends AppCompatActivity {
    TextView svname;
    TextView svusername;
    TextView svtitle;
    TextView svcontent;
    ImageView svimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        svimage = findViewById(R.id.svimage);
        svname = findViewById(R.id.svname);
        svusername = findViewById(R.id.svusername);
        svtitle = findViewById(R.id.svtitle);
        svcontent = findViewById(R.id.svcontent);

        String name = getIntent().getStringExtra("keyname");
        String username = getIntent().getStringExtra("keyusername");
        String title = getIntent().getStringExtra("keytitle");
        String content = getIntent().getStringExtra("keycontent");
        String image = getIntent().getStringExtra("keyimage");

        Glide.with(this)
                .load(image)
                .override(500, 400)
                .into(svimage);
        svname.setText(name);
        svusername.setText(username);
        svtitle.setText(title);
        svcontent.setText(content);
    }
}