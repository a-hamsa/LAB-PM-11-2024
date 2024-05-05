package com.example.praktukimlab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast; // Import kelas Toast
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText commentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        commentEditText = findViewById(R.id.commentEditText);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentEditText.getText().toString();

                // Periksa apakah bio tidak kosong
                if (comment.trim().isEmpty()) {
                    // Jika bio kosong, tampilkan pesan eror
                    Toast.makeText(MainActivity2.this, "Bio tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika bio tidak kosong, lanjutkan ke MainActivity3
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("comment", comment);

                    // Teruskan data yang diterima dari MainActivity ke MainActivity3
                    intent.putExtra("name", getIntent().getStringExtra("name"));
                    intent.putExtra("username", getIntent().getStringExtra("username"));
                    intent.putExtra("imageUri", getIntent().getStringExtra("imageUri"));

                    startActivity(intent);
                }
            }
        });
    }
}

