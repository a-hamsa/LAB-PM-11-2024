package com.example.praktikum_5;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private TextInputEditText searchEditText;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SearchAdapter searchAdapter;
    private Handler handler = new Handler(Looper.getMainLooper());


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchEditText = view.findViewById(R.id.searchInput);
        recyclerView = view.findViewById(R.id.search_rv);
        progressBar = view.findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        searchAdapter = new SearchAdapter(new ArrayList<>());
        recyclerView.setAdapter(searchAdapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                handler.postDelayed(() -> filterList(s.toString()), 1000);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void filterList(String text) {
        if (TextUtils.isEmpty(text)) {
            recyclerView.setVisibility(View.GONE);
            searchAdapter.filteredList(new ArrayList<>());
            progressBar.setVisibility(View.GONE);
            return;
        }

        ArrayList<Model> filteredList = new ArrayList<>();

        for (Model model : DataSource.models) {
            if (model.getName().toLowerCase().contains(text.toLowerCase()) || model.getUsername().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(model);
            }
        }

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        searchAdapter.filteredList(filteredList);
    }


}
