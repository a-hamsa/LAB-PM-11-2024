package com.example.praktikum_2;

import com.bumptech.glide.Glide;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    EditText username;
    ImageView image;
    Uri uri;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        image.setOnClickListener(this);


        name = findViewById(R.id.name);
        username = findViewById(R.id.username);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit) {
            submitForm();
        } else if (view.getId() == R.id.image) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        }
    }

    private void submitForm() {
        if (uri == null) {
            Toast.makeText(this, "Please pick a profile image first!", Toast.LENGTH_SHORT).show();
            return;
        }

        String nama = name.getText().toString().trim();
        if (nama.isEmpty()) {
            name.setError("Field ini tidak boleh kosong");
            return;
        }

        String usernama = username.getText().toString().trim();
        if (usernama.isEmpty()) {
            username.setError("Field ini tidak boleh kosong");
            return;
        }

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("keyname", nama);
        intent.putExtra("keyusername", usernama);
        intent.putExtra("keyimage", uri.toString());
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 1 && data != null) {
            uri = data.getData();
            image.setImageURI(uri);

            Glide.with(this)
                    .load(uri)
                    .override(500, 400)
                    .into(image);

        }

    }


}