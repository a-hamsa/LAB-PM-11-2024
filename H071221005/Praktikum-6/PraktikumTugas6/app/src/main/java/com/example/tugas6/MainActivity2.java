package com.example.tugas6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    public static String PARCEL_DATA = "parcel_data";
    private LinearLayout infoUser;
    private ProgressBar progressBar;
    ImageView imgUser;
    TextView name,email;
    private ApiService apiService;
    private UserAdapter userAdapter;
    private List<User> users;
    int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        imgUser = findViewById(R.id.imgUser);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        infoUser = findViewById(R.id.infoUser);
        progressBar = findViewById(R.id.loading);
        infoUser.setVisibility(View.GONE);

        Handler handler = new Handler(Looper.getMainLooper());
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                handler.post(() -> {
                    // Menampilkan RecyclerView dan menyembunyikan ProgressBar
                    progressBar.setVisibility(View.GONE);
                    infoUser.setVisibility(View.VISIBLE);

                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        idUser = getIntent().getIntExtra(PARCEL_DATA,0);
        apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<UserResponse2> call = apiService.getIdUsers(idUser);
        call.enqueue(new Callback<UserResponse2>() {
            @Override
            public void onResponse(Call<UserResponse2> call, Response<UserResponse2> response) {
                if (response.isSuccessful()) {
                    User objUser = response.body().getDataId();
                    Picasso.get().load(objUser.getAvatar()).into(imgUser);
                    name.setText(objUser.getFirst_name() + " " + objUser.getLast_name());
                    email.setText(objUser.getEmail());
                }
            }
            @Override
            public void onFailure(Call<UserResponse2> call, Throwable t) {

            }
        });



    }
}