package com.example.tugas_lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textTampil;
    Button btnsubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTampil = (TextView) findViewById(R.id.textViewEdit);
        editText = (EditText) findViewById(R.id.editTextLainnya);
        btnsubmit = (Button) findViewById(R.id.button);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strInput = editText.getText().toString();

                textTampil.setText(strInput);

            }
        });
    }
}