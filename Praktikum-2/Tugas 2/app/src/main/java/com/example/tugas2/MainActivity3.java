package com.example.tugas2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        String nama = getIntent().getStringExtra("nama");
        String username = getIntent().getStringExtra("username");
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        String imageUri = getIntent().getStringExtra("imageUri");

        TextView namaTextView = findViewById(R.id.nama);
        TextView usernameTextView = findViewById(R.id.username);
        TextView titleTextView = findViewById(R.id.title);
        TextView contentTextView = findViewById(R.id.content);
        ImageView imageView = findViewById(R.id.gambar);

        namaTextView.setText(nama);
        usernameTextView.setText(username);
        titleTextView.setText(title);
        contentTextView.setText(content);
        imageView.setImageURI(Uri.parse(imageUri));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}