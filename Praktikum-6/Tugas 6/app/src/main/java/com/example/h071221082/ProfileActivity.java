package com.example.h071221082;

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

import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    public static String PARCEL_DATA = "parcel_data";
    private LinearLayout infoUser;
    private ProgressBar progressBar;
    ImageView profile;
    TextView username, email;
    private ApiService apiService;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        progressBar = findViewById(R.id.progressBar);
        infoUser = findViewById(R.id.profileLayout);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        profile = findViewById(R.id.profile);
        infoUser.setVisibility(View.GONE);

        long startTime = System.nanoTime();

        userId = getIntent().getIntExtra(PARCEL_DATA, 0);
        apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<UserId> call = apiService.getIdUsers(userId);
        call.enqueue(new Callback<UserId>() {
            @Override
            public void onResponse(Call<UserId> call, Response<UserId> response) {
                if (response.isSuccessful()) {
                    User objUser = response.body().getDataId();
                    Picasso.get().load(objUser.getAvatar()).into(profile);
                    username.setText(objUser.getFirst_name() + " " + objUser.getLast_name());
                    email.setText(objUser.getEmail());

                    long endTime = System.nanoTime();
                    long elapsedTime = endTime - startTime;
                    long elapsedTimeMillis = TimeUnit.NANOSECONDS.toMillis(elapsedTime);

                    new Handler(Looper.getMainLooper()).post(() -> {
                        progressBar.setVisibility(View.GONE);
                        infoUser.setVisibility(View.VISIBLE);
                    });
                }
            }

            @Override
            public void onFailure(Call<UserId> call, Throwable t) {
            }
        });
    }
}
