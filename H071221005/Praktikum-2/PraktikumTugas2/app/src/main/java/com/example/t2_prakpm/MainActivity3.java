package com.example.t2_prakpm;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    public  static final String PARCEL_DATA = "extra_data";
    ImageView cetakInputImage;
    TextView cetakInputNama;
    TextView cetakInputUsername;
    TextView cetakInputTitle;
    TextView cetakInputContent;

    Data objData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        objData = getIntent().getParcelableExtra(PARCEL_DATA);
        cetakInputImage = findViewById(R.id.hasilInputImage);
        cetakInputNama = findViewById(R.id.hasilInputNama);
        cetakInputUsername = findViewById(R.id.hasilInputUsername);

        cetakInputTitle = findViewById(R.id.hasilInputTitle);
        cetakInputContent= findViewById(R.id.hasilInputContent);

        cetakInputImage.setImageURI(objData.getAlamatImage());
        cetakInputNama.setText(objData.getNama());
        cetakInputUsername.setText(objData.getUsername());
        cetakInputTitle.setText(objData.getTitle());
        cetakInputContent.setText(objData.getCoontent());


    }
}