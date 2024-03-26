package com.example.tugasdua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText etText3;
    private EditText etText4;
    private Button btn2;
    private String textFromEt3;
    private String textFromEt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etText3 = findViewById(R.id.title);
        etText4 =findViewById(R.id.content);
        btn2 = findViewById(R.id.button2);

        btn2.setOnClickListener(view -> {
            textFromEt3 = etText3.getText().toString().trim();
            textFromEt4 = etText4.getText().toString().trim();

            if(textFromEt3.isEmpty()){
                etText3.setError("field ini tidak boleh kosong");
            } else if(textFromEt4.isEmpty()){
                etText4.setError("field ini tidak boleh kosong");
            } else {
                Intent intent = new Intent(this, MainActivity3.class);

                intent.putExtra("textFromEt1", getIntent().getStringExtra("textFromEt1"));
                intent.putExtra("textFromEt2", getIntent().getStringExtra("textFromEt2"));
                intent.putExtra("textFromEt3", textFromEt3);
                intent.putExtra("textFromEt4", textFromEt4);
                intent.putExtra("imageUri", getIntent().getStringExtra("imageUri"));
                startActivity(intent);
            }
        });
    }
}