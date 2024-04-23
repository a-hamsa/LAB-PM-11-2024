package com.example.praktikumtugas5.Fragment;

import static com.example.praktikumtugas5.DataSource.accounts;

import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.praktikumtugas5.Account;
import com.example.praktikumtugas5.DataSource;
import com.example.praktikumtugas5.R;
import com.example.praktikumtugas5.SearchAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SearchFragment extends Fragment {

    SearchAdapter searchAdapter;
    RecyclerView recyclerView;
    ArrayList<Account> accountsList;

    Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SearchView fs_sv_search = view.findViewById(R.id.fs_sv_search);
        recyclerView = view.findViewById(R.id.rv_search);

        accountsList = new ArrayList<>();

        searchAdapter = new SearchAdapter(accounts);
        searchAdapter.setFilteredList(accountsList);
        recyclerView.setAdapter(searchAdapter);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        fs_sv_search.clearFocus();
        fs_sv_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                progressBar.setVisibility(view.GONE);
                ExecutorService executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());
                executor.execute(()->{
                    ArrayList<Account> filteredList = new ArrayList<>();
                    if (!newText.isEmpty()){
                        for (Account account : DataSource.accounts){
                            if (account.getName().toLowerCase().contains(newText.toLowerCase())){
                                filteredList.add(account);
                            }
                        }
                    }


                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    handler.post(()->{
                        progressBar.setVisibility(View.GONE);
                        accountsList.clear();
                        if (!newText.isEmpty()){
                            accountsList.addAll(filteredList);
                        }
                        searchAdapter.notifyDataSetChanged();
                    });
                });
                return true;
            }




        });
    }
}