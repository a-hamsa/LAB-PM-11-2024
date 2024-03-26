package com.example.tugasdua;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Button btn;
    private EditText etText1;
    private EditText etText2;
    private String textFromEt1;
    private String textFromEt2;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.imageView);
        btn = findViewById(R.id.btnSubmit);
        etText1 = findViewById(R.id.nama);
        etText2 = findViewById(R.id.username);

        iv.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        btn.setOnClickListener(view -> {
            textFromEt1 = etText1.getText().toString().trim();
            textFromEt2 = etText2.getText().toString().trim();

            if(textFromEt1.isEmpty()) {
                etText1.setError("field ini tidak boleh kosong");
            } else if(textFromEt2.isEmpty()) {
                etText2.setError("field ini tidak boleh kosong");
            } else if(imageUri == null) {
                Toast.makeText(this, "Gambar tidak boleh kosong", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("textFromEt1", textFromEt1);
                intent.putExtra("textFromEt2", textFromEt2);
                intent.putExtra("imageUri", imageUri.toString());
                startActivity(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if(data != null) {
                        imageUri = data.getData();
                        iv.setImageURI(imageUri);
                    }
                }
            }
    );
}