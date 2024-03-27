package com.example.praktikumtugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity3 extends AppCompatActivity {

    ImageView iv_gambar;
    TextView tv_nama, tv_username, tv_judul, tv_isi;


    Uri uriGambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        iv_gambar = findViewById(R.id.iv_gambar);
        tv_nama = findViewById(R.id.tv_nama);
        tv_username = findViewById(R.id.tv_username);
        tv_judul = findViewById(R.id.tv_judul);
        tv_isi = findViewById(R.id.tv_isi);


        String uriString = getIntent().getStringExtra("kirim_gambar");
        if (uriString != null) {
            try {
                Uri uriGambar = Uri.parse(uriString);
                InputStream inputStream = getContentResolver().openInputStream(uriGambar);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                iv_gambar.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Gagal memuat gambar", Toast.LENGTH_SHORT).show();
            }
        }

        String nama = getIntent().getStringExtra("kirim_nama");
        String username = getIntent().getStringExtra("kirim_username");
        String judul = getIntent().getStringExtra("kirim_judul");
        String isi = getIntent().getStringExtra("kirim_isi");

        tv_nama.setText(nama);
        tv_username.setText("@" + username);
        tv_judul.setText(judul);
        tv_isi.setText(isi);
    }
}