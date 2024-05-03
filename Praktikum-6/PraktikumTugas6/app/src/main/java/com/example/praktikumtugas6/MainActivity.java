package com.example.praktikumtugas6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private LinearLayout main_ll_disconnect;
    private Button main_btn_retry;
    private ProgressBar main_progressBar;
    private Button main_btn_loadmore;
    private List<User> allUsers = new ArrayList<>();

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
        apiService = RetrofitClient.getClient();
        main_progressBar = findViewById(R.id.main_progressBar);
        main_ll_disconnect = findViewById(R.id.main_ll_disconnect);
        main_btn_retry = findViewById(R.id.main_btn_retry);
        main_btn_loadmore = findViewById(R.id.main_btn_loadMore);
        recyclerView = findViewById(R.id.rv_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        checkNetworkAndFetchData(true);
    }
    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            if (activeNetwork != null) {
                return activeNetwork.isConnected() || activeNetwork.isConnectedOrConnecting();
            }
        }
        return false;
    }

    private void checkNetworkAndFetchData(boolean isFirstCall) {
        if (isConnected()) {
            main_progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            main_btn_loadmore.setVisibility(View.GONE);
            main_ll_disconnect.setVisibility(View.GONE);
            if (isFirstCall) {
                main_btn_loadmore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadMoreData();
                    }
                });
            }
            Call<UserResponse> call = apiService.getUsers(1);
            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.isSuccessful()) {
                        allUsers.clear();
                        List<User> users = response.body().getData();
                        allUsers.addAll(users);
                        userAdapter = new UserAdapter(allUsers);
                        recyclerView.setAdapter(userAdapter);
                        main_btn_loadmore.setVisibility(View.VISIBLE);
                        main_progressBar.setVisibility(View.GONE);
                    } else {
                        main_progressBar.setVisibility(View.GONE);

                    }
                }
                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {

                }
            });
        } else {
            main_ll_disconnect.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            main_btn_loadmore.setVisibility(View.GONE);
            main_btn_retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkNetworkAndFetchData(true);
                }
            });
        }
    }
    private void loadMoreData() {
        if (isConnected()) {
            main_progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            main_btn_loadmore.setVisibility(View.GONE);

            Call<UserResponse> call = apiService.getUsers(2);
            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.isSuccessful()) {
                        List<User> users = response.body().getData();
                        allUsers.addAll(users);
                        if (userAdapter == null) {
                            userAdapter = new UserAdapter(allUsers);
                            recyclerView.setAdapter(userAdapter);
                        } else {
                            userAdapter.notifyDataSetChanged();
                        }
                        main_progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        main_btn_loadmore.setVisibility(View.VISIBLE);
                    } else {
                        main_progressBar.setVisibility(View.GONE);
                        main_btn_loadmore.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                }
            });
        } else {
            recyclerView.setVisibility(View.GONE);
            main_btn_loadmore.setVisibility(View.GONE);
            main_ll_disconnect.setVisibility(View.VISIBLE);
        }
    }
}