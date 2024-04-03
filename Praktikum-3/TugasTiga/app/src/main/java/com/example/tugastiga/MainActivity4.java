package com.example.tugastiga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity4 extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_post;
    private TextView tv_nama, tv_caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();

        People people = intent.getParcelableExtra("people");

        iv_profile = findViewById(R.id.iv_profile4);
        iv_post = findViewById(R.id.iv_post3);
        tv_nama = findViewById(R.id.tv_namaprofile);
        tv_caption = findViewById(R.id.tv_caption2);

        iv_profile.setImageResource(people.getImageprofile());
        iv_post.setImageResource(people.getImagepost());
        tv_nama.setText(people.getNama());
        tv_caption.setText(people.getCaption().toString());

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                intent.putExtra("people", people);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                intent.putExtra("people", people);
                startActivity(intent);
            }
        });
    }
}