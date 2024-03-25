package com.example.praktikumtugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText et1;
    ArrayList<String> list_text;
    ArrayAdapter<String> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        et1 = findViewById(R.id.et1);
        listView = findViewById(R.id.lv);

        list_text = new ArrayList<String>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list_text);
        listView.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_text = et1.getText().toString().trim();
                if (!input_text.isEmpty()){
                    list_text.add(input_text);
                    adapter.notifyDataSetChanged();
                    et1.setText("");
                }
            }
        });
    }


}