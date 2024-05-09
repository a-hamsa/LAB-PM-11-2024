package com.example.praktikum2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText deskripsi, title;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.editTextDescription);
        deskripsi = findViewById(R.id.editTextDescription1);
        nextButton = findViewById(R.id.button);
        ImageView imageView = findViewById(R.id.imageView);

        Uri newImage = Uri.parse(getIntent().getStringExtra("imageUri"));
        imageView.setImageURI(newImage);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tit = title.getText().toString();
                String des = deskripsi.getText().toString();

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("title", tit);
                intent.putExtra("deskripsi",des);
                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("username", getIntent().getStringExtra("username"));
                intent.putExtra("imageUri", getIntent().getStringExtra("imageUri"));

                startActivity(intent);
            }
        });
    }
}