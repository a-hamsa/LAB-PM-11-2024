package com.example.praktikum1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.util.TypedValue;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.view.Gravity;
import android.graphics.Color;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private LinearLayout inputsContainer;
    private EditText editTextInput;

    public ArrayList<String> myFavorites = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void VoiceCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:081243365810");
        intent.setData(uri);
        startActivity(intent);
    }

    public void Message(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:081243365810"));
        intent.putExtra("sms_body", "Anu... pinjam dulu seratus");
        startActivity(intent);
    }
    public void addInputItem(View v) {
        inputsContainer = findViewById(R.id.inputsContainer);
        editTextInput = findViewById(R.id.editText);
        String inputText = editTextInput.getText().toString();

        TextView textView = new TextView(this);
        textView.setText(inputText);
        textView.setBackgroundResource(R.drawable.orange_top_buttons);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 100);
        params.setMargins(16, 16, 16, 16);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor("#FF0000"));
        textView.setPadding(20,20,20,20);
        inputsContainer.addView(textView);
        editTextInput.getText().clear();
    }


}