package com.example.t2_prakpm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    public static final String PARCEL_DATA = "parcel_data";
    EditText inputTitle;
    EditText inputContent;

    Data objData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        objData = getIntent().getParcelableExtra(PARCEL_DATA);
    }

    public void btnSave(View view) {
        inputTitle = findViewById(R.id.title);
        inputContent = findViewById(R.id.content);
        Intent toActivity3 = new Intent(MainActivity2.this, MainActivity3.class);
        Data data = new Data();
        data.setAlamatImage(objData.getAlamatImage());
        data.setNama(objData.getNama());
        data.setUsername(objData.getUsername());
        data.setTitle(inputTitle.getText().toString());
        data.setCoontent(inputContent.getText().toString());
        toActivity3.putExtra(MainActivity3.PARCEL_DATA,data);
        if(inputTitle.getText().toString().isEmpty()){
            inputTitle.setError("Inputan Tidak Boleh Kosong !");
        }else if(inputContent.getText().toString().isEmpty()){
            inputContent.setError("Inputan Tidak Boleh Kosong !");
        }else{
            startActivity(toActivity3);
        }
    }
}