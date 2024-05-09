package com.example.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private SearchAdapter itemAdapter;
    private ProgressBar progressBar;
    private List<Story> stories;

    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        stories = DataSource.stories;

        progressBar = rootView.findViewById(R.id.progressBar);

        recyclerView = rootView.findViewById(R.id.search_);

        itemAdapter = new SearchAdapter(this);
        searchView = rootView.findViewById(R.id.SV_search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                handler.removeCallbacksAndMessages(null);
                if (newText.isEmpty()) {
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            filterList(newText);
                        }
                    }, 1000);
                }

                return true;
            }


        });

        return rootView;
    }

    private void filterList(final String text) {
        executor.execute(new Runnable() {
            @Override
            public void run() {

                recyclerView.setVisibility(View.GONE);
                ArrayList<Story> filteredList = new ArrayList<>();
                for (Story story : stories) {
                    if (story.getUsername().toLowerCase().contains(text.toLowerCase())) {
                        filteredList.add(story);
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        progressBar.setVisibility(View.GONE);
                        if (filteredList.isEmpty()) {
                            recyclerView.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Data Tidak Ditemukan!", Toast.LENGTH_SHORT).show();
                        } else {
                            itemAdapter.setFilteredList(filteredList);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            recyclerView.setAdapter(itemAdapter);
                            recyclerView.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });
    }

}
