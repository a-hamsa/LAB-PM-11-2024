package com.example.praktikum2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast; 
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private ImageView imageView;
    private EditText inputnama, inputusername;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView4);
        inputnama = findViewById(R.id.inputnama);
        inputusername = findViewById(R.id.inputusername);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        Button nextButton = findViewById(R.id.button2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String name = inputnama.getText().toString();
                    String username = inputusername.getText().toString();
                    if (imageUri == null) {
                        Toast.makeText(getActivity(), "Anda Belum Memilih Gambar!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", name);
                    intent.putExtra("username", username);
                    if (imageUri != null) {
                        intent.putExtra("imageUri", imageUri.toString());
                    }
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Isi data sebelum lanjut!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(inputnama.getText().toString())) {
            inputnama.setError("Silahkan Isi Nama");
            return false;
        }

        if (TextUtils.isEmpty(inputusername.getText().toString())) {
            inputusername.setError("Silahkan Isi Username");
            return false;
        }

        return true;
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}