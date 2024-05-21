package com.example.tugas8;

import static com.example.tugas8.DataSource.datas;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class EditDataActivity extends AppCompatActivity {
    public static String EXTRA_POSITION = "extra_position";
    public static String EXTRA_DATA = "extra_data";
    ImageView btnBack,btnDelete;
    Button btnUpdate;
    TextInputEditText judul,desc;
    int indexData;
    Data objData;
    DBConfig db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        db = new DBConfig(this);

        btnBack = findViewById(R.id.btnBack);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnSubmitUpdate);
        judul = findViewById(R.id.inputan_judul);
        desc = findViewById(R.id.inputan_desc);

        objData = getIntent().getParcelableExtra(EXTRA_DATA);
        indexData = getIntent().getIntExtra(EXTRA_POSITION,0);

        judul.setText(objData.getJudul());
        desc.setText(objData.getDesc());

        btnBack.setOnClickListener(v -> {
            dialogKembali();
        });
        btnDelete.setOnClickListener(v -> {
            dialogDelete();
        });
        btnUpdate.setOnClickListener(v -> {
            if(judul.getText().toString().isEmpty()){
                judul.setError("Isi Judul");
            }else if (desc.getText().toString().isEmpty()){
                desc.setError("Isi Deskripsi");
            }else{
                db.updateRecord(objData.getId(), judul.getText().toString(),desc.getText().toString());
                Intent toMain = new Intent(this, MainActivity.class);
                startActivity(toMain);
                finish();
            }
        });
        // memunculkan dialog ketika menekan tombol back hp
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
    public void dialogDelete(){
        new AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin menghapus catatan ini?")
                .setPositiveButton("Ya", (dialog, which) -> {
                    dialog.dismiss();
                    db.deleteRecord(objData.getId());
                    Intent toMain = new Intent(this, MainActivity.class);
                    startActivity(toMain);
                    finish();
                })
                .setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}