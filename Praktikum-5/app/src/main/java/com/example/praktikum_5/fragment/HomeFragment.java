package com.example.praktikum_5.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.praktikum_5.DataSource;
import com.example.praktikum_5.Instagram;
import com.example.praktikum_5.PostinganAdapter;
import com.example.praktikum_5.R;

public class HomeFragment extends Fragment {
    public static final String EXTRA_INSTAGRAM = "extra_instagram";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPostingan = view.findViewById(R.id.rv_post);
        rvPostingan.setHasFixedSize(true);

        PostinganAdapter postinganAdapter = new PostinganAdapter(DataSource.instagrams);
        rvPostingan.setAdapter(postinganAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Instagram instagram = bundle.getParcelable(EXTRA_INSTAGRAM);
            if (instagram != null) {
                DataSource.instagrams.add(0, instagram);
            }
        }
    }
}