package com.example.praktikum_8;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvSearch;
    private TextView tvNoData;
    private SearchView searchView;
    private DBConfig dbConfig;
    private List<DataModel> dataList;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbConfig = new DBConfig(this);
        rvSearch = findViewById(R.id.rv_search);
        tvNoData = findViewById(R.id.tv_no_data);
        searchView = findViewById(R.id.search);
        FloatingActionButton fabAdd = findViewById(R.id.fab_add);

        dataList = new ArrayList<>();
        dataAdapter = new DataAdapter(this, dataList);
        rvSearch.setAdapter(dataAdapter);
        rvSearch.setLayoutManager(new GridLayoutManager(this, 1)); // Adjust the span count as needed

        loadData("");

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                loadData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                loadData(newText);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData(searchView.getQuery().toString());
    }

    private void loadData(String query) {
        dataList.clear();
        Cursor cursor;
        if (query.isEmpty()) {
            cursor = dbConfig.getAllRecord();
        } else {
            cursor = dbConfig.searchByTitle(query);
        }

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(dbConfig.getColumnId()));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnTitle()));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnDescription()));
                long createdAt = cursor.getLong(cursor.getColumnIndexOrThrow(dbConfig.getColumnCreatedAt()));
                long updatedAt = cursor.getLong(cursor.getColumnIndexOrThrow(dbConfig.getColumnUpdatedAt()));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String createdAtStr = sdf.format(new Date(createdAt));
                String updatedAtStr = sdf.format(new Date(updatedAt));

                String timestamp = "Created at " + createdAtStr;
                if (createdAt != updatedAt) {
                    timestamp = "Updated at " + updatedAtStr;
                }

                dataList.add(new DataModel(id, title, description, timestamp));
            } while (cursor.moveToNext());
            cursor.close();
        }

        if (dataList.isEmpty()) {
            tvNoData.setVisibility(View.VISIBLE);
            rvSearch.setVisibility(View.GONE);
        } else {
            tvNoData.setVisibility(View.GONE);
            rvSearch.setVisibility(View.VISIBLE);
        }

        dataAdapter.notifyDataSetChanged();
    }
}
