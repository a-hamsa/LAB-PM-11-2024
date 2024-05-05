package com.example.tugas6;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ApiService apiService;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> users;
    boolean cekHasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.recyclerView);
        Button btnMuatLebih = view.findViewById(R.id.btnMuatLebih);
        ProgressBar progressBar = view.findViewById(R.id.loadingHome);
        ProgressBar progressBar2 = view.findViewById(R.id.loadingHome2);


        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        progressBar.setVisibility(View.GONE);
        progressBar2.setVisibility(View.GONE);
        Handler handler = new Handler(Looper.getMainLooper());


        //memunculkan loading setelah memencet tombol refres
        Bundle bundle = getArguments();
        if (bundle != null) {
            cekHasil = bundle.getBoolean("cekInternet");
            if(cekHasil){
                progressBar.setVisibility(View.VISIBLE);

                recyclerView.setVisibility(View.GONE);
                btnMuatLebih.setVisibility(View.GONE);
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        handler.post(() -> {
                            // Menampilkan RecyclerView dan menyembunyikan ProgressBar
                            progressBar.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                            btnMuatLebih.setVisibility(View.VISIBLE);

                        });
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }
        apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<UserResponse> call = apiService.getUsers(1);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    users = response.body().getData();
                    userAdapter = new UserAdapter(users,getParentFragmentManager());
                    recyclerView.setAdapter(userAdapter);
                }
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
        btnMuatLebih.setOnClickListener(v -> {
            if(!MainActivity.adaInternet()){
                FragmentManager fragmentManager = getParentFragmentManager();
                ConnectionFragment connectionFragment = new ConnectionFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, connectionFragment)
                        .commit();
            }else{
                progressBar2.setVisibility(View.VISIBLE);

                btnMuatLebih.setVisibility(View.GONE);
                new Thread(() -> {
                    try {
                        Thread.sleep(160);
                        handler.post(() -> {
                            // Menampilkan RecyclerView dan menyembunyikan ProgressBar
                            progressBar2.setVisibility(View.GONE);

                        });
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
                Call<UserResponse> call1 = apiService.getUsers(2);
                call1.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.isSuccessful()) {
                            List<User> userTambahan = response.body().getData();
                            users.addAll(userTambahan);
                            userAdapter = new UserAdapter(users,getParentFragmentManager());
                            recyclerView.setAdapter(userAdapter);
                        }
                    }
                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                    }
                });
            }

        });


    }
}