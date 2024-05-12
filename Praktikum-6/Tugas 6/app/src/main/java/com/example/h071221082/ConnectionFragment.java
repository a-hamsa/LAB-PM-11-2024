package com.example.h071221082;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.concurrent.TimeUnit;

public class ConnectionFragment extends Fragment {

    private View retryBtn;

    private boolean adaInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        retryBtn = view.findViewById(R.id.retryBtn);
        FragmentManager fragmentManager = getParentFragmentManager();
        retryBtn.setOnClickListener(v -> {
            if (adaInternet()) {
                showHomeFragment();
            }
        });
    }

    private void showHomeFragment() {
        long startTime = System.nanoTime();

        new Handler(Looper.getMainLooper()).post(() -> {
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            long delayMillis = Math.max(0, TimeUnit.NANOSECONDS.toMillis(elapsedTime));

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Bundle bundle = new Bundle();
                bundle.putBoolean("internetCheck", true);
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .commit();
            }, delayMillis);
        });
    }
}
