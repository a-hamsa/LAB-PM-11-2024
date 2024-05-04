package com.example.praktikum_6;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private ApiService apiService;
    private ImageView detailIMG;
    private TextView detailName,detailEmail;
    ProgressBar detailPB;
    LinearLayout dtlLayoutt;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailIMG = findViewById(R.id.detail_IMG);
        detailName = findViewById(R.id.detail_name);
        detailEmail = findViewById(R.id.detail_email);
        detailPB = findViewById(R.id.detail_PB);
        dtlLayoutt = findViewById(R.id.detail_layout);
        apiService = RetrofitClient.getClient().create(ApiService.class);


        dtlLayoutt.setVisibility(View.GONE);
        detailPB.setVisibility(View.VISIBLE);

       userId = getIntent().getIntExtra("id", -1);
       getDetailUsers();
    }


    private void getDetailUsers() {
            Call<UserDetailResponse> call = apiService.getDetailUser(userId);
            call.enqueue(new Callback<UserDetailResponse>() {
                @Override
                public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                    if (response.isSuccessful()) {
                        User user = response.body().getData();
                        detailPB.setVisibility(View.GONE);
                        dtlLayoutt.setVisibility(View.VISIBLE);

                        Picasso.get().load(user.getAvatar()).into(detailIMG);
                        detailName.setText(user.getFirst_name() + " " + user.getLast_name());
                        detailEmail.setText(user.getEmail());

                    } else {
                        Toast.makeText(DetailActivity.this, "Failed to get user details", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserDetailResponse> call, Throwable t) {
                    Toast.makeText(DetailActivity.this, "Tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
                    switchToErrorActivity();
                }
            });
    }


    private void switchToErrorActivity() {
        Intent intent = new Intent(DetailActivity.this, ErrorActivity.class);
        intent.putExtra("DetailActivity", DetailActivity.class.getName());
        intent.putExtra("id", userId);
        startActivity(intent);
        finish();
    }

}

