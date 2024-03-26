package com.example.tugasdua;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private ImageView iv;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        iv = findViewById(R.id.imageView2);
        tv1 = findViewById(R.id.textNama);
        tv2 = findViewById(R.id.textUsername);
        tv3 = findViewById(R.id.textTitle);
        tv4 = findViewById(R.id.textContent);

        String image = getIntent().getStringExtra("imageUri");
        String text1 = getIntent().getStringExtra("textFromEt1");
        String text2 = getIntent().getStringExtra("textFromEt2");
        String text3 = getIntent().getStringExtra("textFromEt3");
        String text4 = getIntent().getStringExtra("textFromEt4");

        Uri imageUri = Uri.parse(image);
        iv.setImageURI(imageUri);
        tv1.setText(text1);
        tv2.setText(text2);
        tv3.setText(text3);
        tv4.setText(text4);
    }
}