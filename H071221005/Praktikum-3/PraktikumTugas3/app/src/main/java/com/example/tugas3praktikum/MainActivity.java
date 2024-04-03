package com.example.tugas3praktikum;

import static com.example.tugas3praktikum.DataSource.datas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvDatas = findViewById(R.id.rv_home);
        RecyclerView rvDatas2 = findViewById(R.id.rv_home2);
        rvDatas.setHasFixedSize(true);
        rvDatas2.setHasFixedSize(true);
        DataAdapter adapter = new DataAdapter((datas));
        DataAdapter2 adapter2 = new DataAdapter2((datas));

        rvDatas.setAdapter(adapter);
        rvDatas2.setAdapter(adapter2);

        };


}

