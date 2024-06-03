package com.example.h071221082;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNoteActivity extends AppCompatActivity {

    private EditText et_title, et_description;
    private TextView btn_submit;
    private DatabaseHelper db;
    private int noteId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        btn_submit = findViewById(R.id.btn_submit);
        db = new DatabaseHelper(this);

        if (getIntent().hasExtra("note_id")) {
            noteId = getIntent().getIntExtra("note_id", -1);
            loadNoteData(noteId);
            getSupportActionBar().setTitle("Edit Note");
        } else {
            getSupportActionBar().setTitle("Create Note");
        }

        btn_submit.setOnClickListener(v -> {
            String title = et_title.getText().toString();
            String description = et_description.getText().toString();

            if (title.isEmpty()) {
                et_title.setError("Field tidak boleh kosong");
            } else {
                if (noteId == -1) {
                    db.insertNote(title, description);
                } else {
                    Note note = db.getNote(noteId);
                    note.setTitle(title);
                    note.setDescription(description);
                    db.updateNote(note);
                }
                finish();
            }
        });

    }

    private void loadNoteData(int noteId) {
        Note note = db.getNote(noteId);
        et_title.setText(note.getTitle());
        et_description.setText(note.getDescription());
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_note, menu);
        if (noteId == -1) {
            MenuItem deleteItem = menu.findItem(R.id.action_delete);
            deleteItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            showCancelConfirmationDialog();
            return true;
        } else if (item.getItemId() == R.id.action_delete) {
            showDeleteConfirmationDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showCancelConfirmationDialog();
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah anda yakin ingin menghapusnya?")
                .setPositiveButton("Ya", (dialog, id) -> {
                    db.deleteNote(noteId);
                    finish();
                })
                .setNegativeButton("Tidak", (dialog, id) -> {
                });
        builder.create().show();
    }

    private void showCancelConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah anda ingin membatalkan penambahan atau perubahan pada form?")
                .setPositiveButton("Ya", (dialog, id) -> finish())
                .setNegativeButton("Tidak", (dialog, id) -> {
                });
        builder.create().show();
    }
}