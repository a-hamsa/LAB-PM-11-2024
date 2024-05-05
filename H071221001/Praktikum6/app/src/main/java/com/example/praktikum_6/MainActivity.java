package com.example.praktikum_6;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private int page = 1;
    private Button loadMoreButton;
    private ProgressBar mainPB, morePB;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        morePB = findViewById(R.id.loadmore_PB);
        mainPB = findViewById(R.id.main_PB);
        mainLayout = findViewById(R.id.mainLayout);


        mainLayout.setVisibility(View.GONE);
        mainPB.setVisibility(View.VISIBLE);
        getUser();

        loadMoreButton = findViewById(R.id.loadmoreBTN);
        loadMoreButton.setOnClickListener(v -> loadMoreData());

    }

    private void getUser() {
            Call<UserResponse> call = apiService.getUsers(page);
            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse( Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.isSuccessful()) {
                        List<User> users = response.body().getData();
                        if (userAdapter == null) {
                            userAdapter = new UserAdapter(users);
                            recyclerView.setAdapter(userAdapter);
                            mainPB.setVisibility(View.GONE);
                            mainLayout.setVisibility(View.VISIBLE);
                            morePB.setVisibility(View.GONE);
                        } else {
                            userAdapter.addUsers(users);
                            userAdapter.notifyDataSetChanged();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
                    switchToErrorActivity();
                }
            });
    }

    private void loadMoreData() {
        loadMoreButton.setVisibility(View.GONE);
        morePB.setVisibility(View.VISIBLE);
        page++;
        getUser();

    }

    private void switchToErrorActivity() {
        Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
        intent.putExtra("MainActivity", MainActivity.class.getName());
        startActivity(intent);
        finish();
    }
}
