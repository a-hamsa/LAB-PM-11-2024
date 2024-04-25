package com.example.tugas5;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    public static String PARCEL_DATA = "parcel_data";
    Data objData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        LinearLayout layout_profile = findViewById(R.id.layout_profile);
        TextView namaLengkap = findViewById(R.id.iniNamaLengkap);
        TextView nickName = findViewById(R.id.iniNickName);
        ImageView imgProfile= findViewById(R.id.imgProfile);
        ProgressBar progressBar = findViewById(R.id.loading);

        objData = getIntent().getParcelableExtra(PARCEL_DATA);
        namaLengkap.setText(objData.getNamaLengkap());
        nickName.setText(objData.getNickName());
        imgProfile.setImageResource(objData.getImgProfile());


        layout_profile.setVisibility(View.GONE);
        Handler handler = new Handler(Looper.getMainLooper());
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                handler.post(() -> {
                    // Menampilkan RecyclerView dan menyembunyikan ProgressBar
                    progressBar.setVisibility(View.GONE);
                    layout_profile.setVisibility(View.VISIBLE);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }
}