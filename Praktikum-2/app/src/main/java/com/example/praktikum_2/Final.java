package com.example.praktikum_2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        imageView = findViewById(R.id.gambar);
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.note1);
        textView4 = findViewById(R.id.note2);

        textView1.setText(getIntent().getStringExtra("name"));
        textView2.setText(getIntent().getStringExtra("username"));
        textView3.setText(getIntent().getStringExtra("note1"));
        textView4.setText(getIntent().getStringExtra("note2"));
        String imageUriString = getIntent().getStringExtra("image");

        if(imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            imageView.setImageURI(imageUri);
        }
    }
}