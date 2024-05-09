package com.example.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile_ extends AppCompatActivity {
    private TextView nama_pengguna_profile;
    private CircleImageView gambar;
    private ProgressBar progressBar;
    private Executor executor = Executors.newSingleThreadExecutor();
    private ConstraintLayout constraintLayout;

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nama_pengguna_profile = findViewById(R.id.nama_pengguna_profile);
        gambar = findViewById(R.id.fp_pengguna);
        progressBar = findViewById(R.id.pb_profile);
        constraintLayout = findViewById(R.id.constrain_profile);

        executor.execute(() ->{
            progressBar.setVisibility(View.VISIBLE);
            nama_pengguna_profile.setText(getIntent().getStringExtra("username"));
            int id = getIntent().getIntExtra("image", 0);
            gambar.setImageResource(id);

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }

            handler.post(() -> {
                progressBar.setVisibility(ProgressBar.GONE);
                constraintLayout.setVisibility(ConstraintLayout.VISIBLE);

            });
        });

    }
}