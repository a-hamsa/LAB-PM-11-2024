package com.example.h071221082;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.os.PatternMatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFragment extends Fragment {

    private RecyclerView rv_search;
    private EditText searchprofile;
    private SearchAdapter adapter;
    private ArrayList<Account> filteredUsers;
    private ProgressBar searchspinner;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewsearch = inflater.inflate(R.layout.fragment_search, container, false);
        rv_search = viewsearch.findViewById(R.id.rv_search);
        searchprofile = viewsearch.findViewById(R.id.searchprofile);
        searchspinner = viewsearch.findViewById(R.id.searchspinner);

        rv_search.setVisibility(View.GONE);
        searchspinner.setVisibility(View.GONE);

        adapter = new SearchAdapter(DataSource.accounts);
        rv_search.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_search.setHasFixedSize(true);
        rv_search.setAdapter(adapter);

        filteredUsers = new ArrayList<>(DataSource.accounts);

        searchprofile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        return viewsearch;
    }

    private void filter(String text) {
        filteredUsers.clear();
        if (text.isEmpty()) {
            rv_search.setVisibility(View.GONE);
        } else {
            for (Account user : DataSource.accounts) {
                if (user.getFullname().toLowerCase().contains(text.toLowerCase()) ||
                        user.getUsername().toLowerCase().contains(text.toLowerCase())) {
                    filteredUsers.add(user);
                    searchspinner.setVisibility(View.VISIBLE);
                    rv_search.setVisibility(View.GONE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            searchspinner.setVisibility(View.GONE);
                            rv_search.setVisibility(View.VISIBLE);
                        }
                    }, 1000);
                }
            }
        }
        adapter.setFilteredUsers(filteredUsers);
    }

}
