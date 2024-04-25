package com.example.tugas5.fragment;

import static com.example.tugas5.DataSource.datas;
import static com.example.tugas5.SearchSource.dataSearch;

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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tugas5.Data;
import com.example.tugas5.R;
import com.example.tugas5.SearchAdapter;
import com.example.tugas5.SearchSource;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private SearchView searchView;
    private ProgressBar progressBar;


    //sisa loadingnya




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv = view.findViewById(R.id.rv_search);
        progressBar = view.findViewById(R.id.loading);

        rv.setHasFixedSize(true);

        progressBar.setVisibility(View.GONE);
        Handler handler = new Handler(Looper.getMainLooper());

        searchView = view.findViewById((R.id.searchView));
        searchView.clearFocus();
        SearchAdapter adapter = new SearchAdapter(dataSearch);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                dataSearch.clear();

                if(text.isEmpty()){
                    progressBar.setVisibility(View.GONE);

                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.GONE);
                    for (Data item : datas) {

                        String namaLengkap = item.getNamaLengkap().toLowerCase();
                        String nickName = item.getNickName().toLowerCase();
                        if (namaLengkap.contains(text.toLowerCase()) || nickName.contains(text.toLowerCase())) {
                            dataSearch.add(item);
                        }
                    }

                }
                rv.setAdapter(adapter);


                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        handler.post(() -> {
                            rv.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        });
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();


                return true;
            }




        });


    }
}