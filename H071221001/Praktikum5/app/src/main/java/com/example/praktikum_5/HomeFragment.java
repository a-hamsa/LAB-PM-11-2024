package com.example.praktikum_5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public static String EXTRA_POST = "extra_post";
    private TextView noData;
    PostAdapter postAdapter;
    private RecyclerView postRecyclerView;
    private ArrayList<Model> models = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!(getActivity() == null || ((AppCompatActivity) getActivity()).getSupportActionBar() == null)) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");
        }
        postRecyclerView = view.findViewById(R.id.home_rv);
        noData = view.findViewById(R.id.textViewNoPosts);
        models = DataSource.models;
        postAdapter = new PostAdapter(models);
        if (getArguments() != null) {
            models.add(0, getArguments().getParcelable(EXTRA_POST));
            Toast.makeText(getActivity(), "Post Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();

        }
        checkDataEmpty();
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        postRecyclerView.setHasFixedSize(true);
        postRecyclerView.setAdapter(this.postAdapter);
    }

    public void checkDataEmpty() {
        System.out.println(models.isEmpty());
        if (models.isEmpty()) {
            noData.setVisibility(View.VISIBLE);
        } else {
            noData.setVisibility(View.GONE);
        }
    }
}

