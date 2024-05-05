package com.example.tugas3praktikum;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity2 extends AppCompatActivity {
    public static final String PARCEL_DATA = "parcel_data";
    Data objData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_isi_story);

        TextView name = findViewById(R.id.name);
        ImageView imgProfile = findViewById(R.id.imgProfile);
        ConstraintLayout background = findViewById(R.id.imgPost);

        objData = getIntent().getParcelableExtra(PARCEL_DATA);
        name.setText(objData.getName());
        imgProfile.setImageResource(objData.getImgProfile());
        background.setBackgroundResource(objData.getImgPost());
    }
}