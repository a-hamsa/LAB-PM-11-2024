package com.example.tugas6;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


public class ConnectionFragment extends Fragment {

    private View btnRefresh;
    private boolean adaInternet() {
            ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ;
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
        btnRefresh = view.findViewById(R.id.btnRefresh);
        FragmentManager fragmentManager = getParentFragmentManager();
        btnRefresh.setOnClickListener(v -> {
            if(adaInternet()){
                //kirim
                Bundle bundle = new Bundle();
                bundle.putBoolean("cekInternet", true);
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .commit();
            }

        });
    }
}