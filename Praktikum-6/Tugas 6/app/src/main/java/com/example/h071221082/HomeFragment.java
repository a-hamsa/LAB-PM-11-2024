package com.example.h071221082;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ApiService apiService;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> users;
    boolean internet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_user);
        Button loadBtn = view.findViewById(R.id.loadBtn);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        ProgressBar progressBar2 = view.findViewById(R.id.progressBar2);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        progressBar.setVisibility(View.GONE);
        progressBar2.setVisibility(View.GONE);
        Handler handler = new Handler(Looper.getMainLooper());


        Bundle bundle = getArguments();
        if (bundle != null) {
            internet = bundle.getBoolean("internetCheck");
            if(internet){
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                loadBtn.setVisibility(View.GONE);

                long startTime = System.nanoTime();

                new Handler(Looper.getMainLooper()).post(() -> {
                    long endTime = System.nanoTime();
                    long elapsedTime = endTime - startTime;

                    long delayMillis = Math.max(0, TimeUnit.NANOSECONDS.toMillis(elapsedTime));

                    handler.postDelayed(() -> {
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        loadBtn.setVisibility(View.VISIBLE);
                    }, delayMillis);
                });
            }
        }
        apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<Users> call = apiService.getUsers(1);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {
                    users = response.body().getData();
                    userAdapter = new UserAdapter(users, getParentFragmentManager());
                    recyclerView.setAdapter(userAdapter);
                }
            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
        loadBtn.setOnClickListener(v -> {
            if (!MainActivity.adaInternet()) {
                FragmentManager fragmentManager = getParentFragmentManager();
                ConnectionFragment connectionFragment = new ConnectionFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, connectionFragment)
                        .commit();
            } else {
                progressBar2.setVisibility(View.VISIBLE);
                loadBtn.setVisibility(View.GONE);

                long startTime = System.nanoTime();

                new Handler(Looper.getMainLooper()).post(() -> {
                    long endTime = System.nanoTime();
                    long elapsedTime = endTime - startTime;

                    long delayMillis = Math.max(0, TimeUnit.NANOSECONDS.toMillis(elapsedTime));

                    handler.postDelayed(() -> {
                        progressBar2.setVisibility(View.GONE);
                    }, delayMillis);
                });

                Call<Users> call2 = apiService.getUsers(2);
                call2.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()) {
                            List<User> loadUser = response.body().getData();
                            users.addAll(loadUser);
                            userAdapter = new UserAdapter(users, getParentFragmentManager());
                            recyclerView.setAdapter(userAdapter);
                        }
                    }
                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                    }
                });
            }
        });
    }
}
