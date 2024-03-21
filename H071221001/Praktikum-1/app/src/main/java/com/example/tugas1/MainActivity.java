package com.example.tugas1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView Saved;
    ArrayList<String> inputan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btn1);
        Saved = findViewById(R.id.Saved);

        inputan = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String inputText = editText.getText().toString();

            Saved.setText(inputText);

            inputan.add(inputText);

            updateTextView();

            editText.setText("");
        }
    });
}
    private void updateTextView() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String input : inputan) {
            stringBuilder.append(input).append("\n");
        }
        Saved.setText(stringBuilder.toString());
    }
}