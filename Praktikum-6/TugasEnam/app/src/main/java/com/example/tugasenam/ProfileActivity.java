package com.example.tugasenam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    ImageView profile;
    Button btnretry;
    TextView name, email, connecterror;
    ProgressBar progressBar;
    CardView cvprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.profile);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        cvprofile = findViewById(R.id.cvprofile);
        progressBar = findViewById(R.id.progressBar);
        btnretry = findViewById(R.id.btnretry);
        connecterror = findViewById(R.id.connecterror);

        calling();
    }

    public void calling() {
        String id = getIntent().getStringExtra("id");

        connecterror.setVisibility(View.GONE);
        btnretry.setVisibility(View.GONE);
        cvprofile.setVisibility(View.GONE);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Call<ProfileResponse> client = ApiConfig.getApiService().getUser(id);
                client.enqueue(new Callback<ProfileResponse>() {
                    @Override
                    public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                User user = response.body().getData();

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        name.setText(user.getFirst_name() + " " + user.getLast_name());
                                        email.setText(user.getEmail());
                                        Picasso.get().load(user.getAvatar()).into(profile);

                                        progressBar.setVisibility(View.GONE);
                                        cvprofile.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        } else {
                            if (response.body() != null) {
                                Log.e("MainActivity", "onFailure1: " + response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ProfileResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        connecterror.setVisibility(View.VISIBLE);
                        btnretry.setVisibility(View.VISIBLE);

                        btnretry.setOnClickListener(v -> {
                            progressBar.setVisibility(View.VISIBLE);
                            connecterror.setVisibility(View.GONE);
                            btnretry.setVisibility(View.GONE);
                            calling();
                        });
                    }
                });
            }
        });
    }
}