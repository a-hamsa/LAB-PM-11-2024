package com.example.praktukimlab2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ImageView imageView = findViewById(R.id.imageView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView commentTextView = findViewById(R.id.commentTextView);

        Button buttonEditProfil = findViewById(R.id.buttonEditProfil);
        buttonEditProfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }

        });

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String username = intent.getStringExtra("username");
            String comment = intent.getStringExtra("comment");

            // Tampilkan data yang diterima dari MainActivity2
            nameTextView.setText(name);
            usernameTextView.setText(username);
            commentTextView.setText(comment);

            // Tampilkan gambar yang diterima dari MainActivity di ImageView
            String imageUriString = intent.getStringExtra("imageUri");
            if (imageUriString != null) {
                Uri imageUri = Uri.parse(imageUriString);
                imageView.setImageURI(imageUri);
            }
        }
    }
}
