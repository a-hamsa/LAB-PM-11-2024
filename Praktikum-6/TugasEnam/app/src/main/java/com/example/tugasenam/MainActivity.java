package com.example.tugasenam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    TextView connecterror;
    ProgressBar progressBar;
    Button btnretry;
    Button btnloadmore;
    AdapterUsers adapterUsers;
    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        connecterror = findViewById(R.id.connecterror);
        progressBar = findViewById(R.id.progressBar);
        btnretry = findViewById(R.id.btnretry);
        btnloadmore = findViewById(R.id.btnloadmore);

        adapterUsers = new AdapterUsers(new ArrayList<>());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapterUsers);

        calling(currentPage);

        btnloadmore.setOnClickListener(v -> {
            currentPage++;
            loadMore();
        });
    }

    public void calling(int page) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        connecterror.setVisibility(View.GONE);
        btnretry.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        btnloadmore.setVisibility(View.GONE);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Call<DataResponse> client = ApiConfig.getApiService().getData(String.valueOf(currentPage));
                client.enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                ArrayList<User> user = response.body().getData();
                                adapterUsers.addData(user);
                                progressBar.setVisibility(View.GONE);
                                btnloadmore.setVisibility(View.VISIBLE);
                            }
                        } else {
                            if (response.body() != null) {
                                Log.e("MainActivity", "onFailure: " + response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        connecterror.setVisibility(View.VISIBLE);
                        btnretry.setVisibility(View.VISIBLE);

                        btnretry.setOnClickListener(v -> {
                            progressBar.setVisibility(View.VISIBLE);
                            connecterror.setVisibility(View.GONE);
                            btnretry.setVisibility(View.GONE);

                            calling(currentPage);
                        });
                    }
                });
            }
        });
    }

    private  void loadMore() {
        calling(currentPage);
    }
}