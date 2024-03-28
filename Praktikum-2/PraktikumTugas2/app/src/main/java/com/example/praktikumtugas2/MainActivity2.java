package com.example.praktikumtugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText et_judul;
    EditText et_isi;
    Button btn_simpan;

    Uri uriGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_judul = findViewById(R.id.et_judul);
        et_isi = findViewById(R.id.et_isi);
        btn_simpan = findViewById(R.id.btn_simpan);

        String nama = getIntent().getStringExtra("kirim_nama");
        String username = getIntent().getStringExtra("kirim_username");

        if (getIntent().hasExtra("kirim_gambar")){
            String uriString = getIntent().getStringExtra("kirim_gambar");
            uriGambar = Uri.parse(uriString);
        }


        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = et_judul.getText().toString().trim();
                String isi = et_isi.getText().toString().trim();

                if (judul.length() == 0) {
                    et_judul.setError("Judul wajib diisi");
                } else if (isi.length() == 0) {
                    et_isi.setError("Isi konten wajib diisi");
                } else {
                    Intent toActivity3 = new Intent(MainActivity2.this, MainActivity3.class);
                    toActivity3.putExtra("kirim_nama", nama);
                    toActivity3.putExtra("kirim_username", username);
                    toActivity3.putExtra("kirim_gambar", uriGambar.toString());
                    toActivity3.putExtra("kirim_judul", judul);
                    toActivity3.putExtra("kirim_isi",isi);
                    startActivity(toActivity3);
                }
            }
        });
    }
}