package com.example.praktikumtugas2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    ImageButton ib_gambar;
    EditText et_nama;
    EditText et_username;
    Button btn_masuk;
    Uri uriGambar;

    Boolean cekGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ib_gambar = findViewById(R.id.btn_gambar);
        et_nama = findViewById(R.id.et_nama);
        et_username = findViewById(R.id.et_username);
        btn_masuk = findViewById(R.id.btn_masuk);
        cekGambar = false;

        ActivityResultLauncher<Intent> intentLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        uriGambar = result.getData().getData();
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(uriGambar);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            ib_gambar.setImageBitmap(bitmap);
                            cekGambar = true;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Gagal memuat gambar", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        ib_gambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGaleri = new Intent(Intent.ACTION_PICK);
                toGaleri.setType("image/*");
                intentLaunch.launch(toGaleri);
            }
        });

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = et_nama.getText().toString().trim();
                String username = et_username.getText().toString().trim();

                if (cekGambar == false){
                    Toast.makeText(MainActivity.this, "Silahkan pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else if (nama.length() == 0){
                    et_nama.setError("Nama wajib diisi");
                } else if (username.length() == 0){
                    et_username.setError("Username wajib diisi");
                } else {
                    Intent toActivity2 = new Intent(MainActivity.this, MainActivity2.class);
                    toActivity2.putExtra("kirim_nama", nama);
                    toActivity2.putExtra("kirim_username", username);
                    toActivity2.putExtra("kirim_gambar", uriGambar.toString());

                    startActivity(toActivity2);
                }


            }
        });
    }


}
