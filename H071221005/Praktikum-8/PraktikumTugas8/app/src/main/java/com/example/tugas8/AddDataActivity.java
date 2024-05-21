package com.example.tugas8;

import static com.example.tugas8.DataSource.datas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class AddDataActivity extends AppCompatActivity {
    Toolbar btnBack;
    Button btnSubmitCreate;
    TextInputEditText judul,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DBConfig db = new DBConfig(this);
        btnSubmitCreate = findViewById(R.id.btnSubmitCreate);
        btnBack = findViewById(R.id.btnBack);
        judul = findViewById(R.id.inputan_judul);
        desc = findViewById(R.id.inputan_desc);
        btnSubmitCreate.setOnClickListener(v -> {
            if(judul.getText().toString().isEmpty()){
                judul.setError("Isi Judul");
            }else if (desc.getText().toString().isEmpty()){
                desc.setError("Isi Deskripsi");
            }else{
                db.insertRecord(judul.getText().toString(), desc.getText().toString());
                Intent toMain = new Intent(this, MainActivity.class);
                startActivity(toMain);
                finish();
            }
        });
        btnBack.setOnClickListener(v -> {
            dialogKembali();
        });
        // memunculkan dialog ketika menekan tombol back di hp
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                dialogKembali();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }


    public void dialogKembali(){
        new AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin kembali?")
                .setPositiveButton("Ya", (dialog, which) -> {
                    dialog.dismiss();
                    Intent toMain = new Intent(this, MainActivity.class);
                    startActivity(toMain);
                    finish();

                })
                .setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

}
