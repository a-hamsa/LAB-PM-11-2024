package com.example.praktikum_2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton photo;

    EditText editText;

    EditText editText2;

    Button btnsubmit;
    private Uri image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = findViewById(R.id.selectphoto);
        editText = findViewById(R.id.inputnama);
        editText2 = findViewById(R.id.inputuser);
        btnsubmit = findViewById(R.id.buttonsubmit);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bukagaleri = new Intent(Intent.ACTION_GET_CONTENT);
                bukagaleri.setType("image/*");
                openGallery.launch(Intent.createChooser(bukagaleri, "Choose your picture"));
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String username = editText2.getText().toString();

                if (image != null) {
                    if (!name.isEmpty()) {
                        if (!username.isEmpty()) {
                            Intent intent = new Intent(MainActivity.this, Note.class);
                            intent.putExtra("name", name);
                            intent.putExtra("username", username);
                            intent.putExtra("image", image.toString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Username harus di isi", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Nama harus di isi", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Tambahkan gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        image = data.getData();
                        photo.setImageURI(image);
                    }

                }
            }
    );
}