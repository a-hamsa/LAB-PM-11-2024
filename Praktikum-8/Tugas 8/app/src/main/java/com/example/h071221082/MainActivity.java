package com.example.h071221082;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private List<Note> noteList;
    private DatabaseHelper db;
    private TextView tv_nodata;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = new DatabaseHelper(this);

        tv_nodata = findViewById(R.id.tv_nodata);
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchNotes(newText);
                return true;
            }
        });


        ImageView btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddNoteActivity.class)));

        loadNotes();
    }

    private void loadNotes() {
        noteList = db.getAllNotes();
        if (noteList.isEmpty()) {
            tv_nodata.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            tv_nodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            notesAdapter = new NotesAdapter(this, noteList);
            recyclerView.setAdapter(notesAdapter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }

    private void searchNotes(String query) {
        if (!TextUtils.isEmpty(query)) {
            List<Note> filteredList = new ArrayList<>();
            for (Note note : noteList) {
                if (note.getTitle().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(note);
                }
            }
            if (filteredList.isEmpty()) {
                tv_nodata.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            } else {
                tv_nodata.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
            notesAdapter.filterList(filteredList);
        } else {
            tv_nodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            notesAdapter.filterList(noteList);
        }
    }
}
