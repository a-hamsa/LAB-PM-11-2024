package com.example.tugas3praktikum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    public static final String PARCEL_DATA = "parcel_data";
    Data objData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_postingann);
        TextView name = findViewById(R.id.name);
        ImageView imgProfile = findViewById(R.id.imgProfile);
        ImageView imgPost = findViewById(R.id.imgPost);
        TextView desc = findViewById(R.id.desc);

        objData = getIntent().getParcelableExtra(PARCEL_DATA);
        name.setText(objData.getName());
        imgProfile.setImageResource(objData.getImgProfile());
        imgPost.setImageResource(objData.getImgPost());
        desc.setText(objData.getDesc());
    }


    public void toStory(View view) {
        Intent toStory = new Intent(MainActivity4.this, MainActivity2.class);

        toStory.putExtra(MainActivity2.PARCEL_DATA,objData);
        startActivity(toStory);
    }

    public void toProfile(View view) {
        Intent toProfile = new Intent(MainActivity4.this, MainActivity3.class);
        toProfile.putExtra(MainActivity3.PARCEL_DATA,objData);
        startActivity(toProfile);
    }
}