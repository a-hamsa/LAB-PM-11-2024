package com.example.tugaslab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText); //deklarasi value, pemanggilan menggunakan id

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                TextView newTextView = new TextView(MainActivity.this); //newTextView untuk buat objeknya
                newTextView.setText(text); //ini untuk simpan textnya dilinear layout supaya muncul yg sudah diinput
                newTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
                newTextView.setTextColor(Color.BLACK);
                newTextView.setBackgroundColor(Color.TRANSPARENT);

                LinearLayout layout = findViewById(R.id.layoutlinear);
                layout.addView(newTextView); 

                editText.setText("");
            }
        });
    }
}