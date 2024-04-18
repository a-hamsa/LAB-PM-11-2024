package com.example.praktikum_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        HomeFragment.super.onViewCreated(view, savedInstanceState);
        if (!(getActivity() == null || ((AppCompatActivity) getActivity()).getSupportActionBar() == null)) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");
        }

        this.postRecyclerView = view.findViewById(R.id.recyclerView);
        this.noData = (TextView) view.findViewById(R.id.textViewNoPosts);
        this.models = DataSource.models;
        this.postAdapter = new PostAdapter(this.models, getActivity());
        this.postAdapter.setOnDeleteButtonClickedListener(new HomeFragment3 (this));
        if (getArguments() != null) {
            this.models.add(0, getArguments().getParcelable(EXTRA_POST));
            Toast.makeText(getActivity(), "Post Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            MainActivity mainActivity = (MainActivity) getActivity();
            if (mainActivity != null) {
                 mainActivity.isActiveHomeMenu(true);
                 mainActivity.isActivePostMenu(false);
                 mainActivity.isActiveProfileMenu(false);
            }

        }
        checkDataEmpty();
        this.postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.postRecyclerView.setHasFixedSize(true);
        this.postRecyclerView.setAdapter(this.postAdapter);
    }

    public void HomeFragment3 (Model model) {
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment();
        confirmDialogFragment.show(getChildFragmentManager(), ConfirmDialogFragment.class.getSimpleName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("model", model);
        confirmDialogFragment.setArguments(bundle);
        confirmDialogFragment.setOnClickDeleteButtonListener(new HomeFragment2(this, model));
    }

    public void HomeFragment2 (Model model) {
        this.models.remove(model);
        this.postAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
        checkDataEmpty();
    }

    public void checkDataEmpty() {
        System.out.println(this.models.isEmpty());
        if (this.models.isEmpty()) {
            this.noData.setVisibility(View.VISIBLE);
        } else {
            this.noData.setVisibility(View.GONE);
        }
    }
}