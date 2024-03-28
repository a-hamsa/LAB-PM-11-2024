package com.example.praktikum2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    TextView nameUsername, title, deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nameUsername = findViewById(R.id.textView5);
        title = findViewById(R.id.textView3);
        deskripsi = findViewById(R.id.textView10);
        ImageView imageView = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String username = intent.getStringExtra("username");
            String tit = intent.getStringExtra("title");
            String deskripsit = intent.getStringExtra("deskripsi");

  
            nameUsername.setText(name + " - " + username);
            title.setText(tit);
            deskripsi.setText(deskripsit);

            String imageUriString = intent.getStringExtra("imageUri");
            if (imageUriString != null) {
                Uri imageUri = Uri.parse(imageUriString);
                imageView.setImageURI(imageUri);
            }
        }
    }
}