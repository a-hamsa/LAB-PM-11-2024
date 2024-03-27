package com.example.praktikum_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    EditText title;
    EditText content;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);

        save = findViewById(R.id.save);
        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        saveForm();
    }

    private void saveForm() {
        String title1 = title.getText().toString().trim();
        if (title1.isEmpty()) {
            title.setError("Field ini tidak boleh kosong");
            return;
        }

        String content1 = content.getText().toString().trim();
        if (content1.isEmpty()) {
            content.setError("Field ini tidak boleh kosong");
            return;
        }

        String title2 = title.getText().toString();
        String content2= content.getText().toString();
        String name1 = getIntent().getStringExtra("keyname");
        String username1 = getIntent().getStringExtra("keyusername");
        String image1 = getIntent().getStringExtra("keyimage");

        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("keytitle", title2);
        intent.putExtra("keycontent", content2);
        intent.putExtra("keyname", name1);
        intent.putExtra("keyusername", username1);
        intent.putExtra("keyimage", image1);
        startActivity(intent);
    }
}
