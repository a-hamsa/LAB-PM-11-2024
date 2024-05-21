package com.example.tugas8;

import static com.example.tugas8.DataSource.datas;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnAddData;
    LinearLayout tv_no_data,ll_rv;
    SearchView searchView;
    ArrayList<Data> dataSearch;
    RecyclerView rv_home;
    DataAdapter adapterSearch;
    int id ;
    String judul,desc,created_at,updated_at ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rv_home = findViewById(R.id.rv);
        tv_no_data = findViewById(R.id.ll_nodata);
        ll_rv = findViewById(R.id.ll_rv);
        btnAddData = findViewById(R.id.btnAddData);
        searchView = findViewById(R.id.btnSearch);
        searchView.clearFocus();

        //merefres arraylist nya
        datas.clear();

        dataSearch = new ArrayList<>();
        adapterSearch = new DataAdapter(dataSearch);

        DBConfig db = new DBConfig(this);
        Cursor cursor = db.getAllRecord();

        //buat perulangan untuk mengambil semua datany
        //dicek apakah cursor bisa bergerak, kalau bisa berarti ada datanya(tidak kosong),
        // makany pakai do while agar ketika datanya cuman datanya 1 akan tetap berjalan terus akan berulangan ketika cursor masih bisa move
        if(cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                judul = cursor.getString(cursor.getColumnIndexOrThrow("judul"));
                desc = cursor.getString(cursor.getColumnIndexOrThrow("descr"));
                created_at = cursor.getString(cursor.getColumnIndexOrThrow("created_at"));
                updated_at = cursor.getString(cursor.getColumnIndexOrThrow("updated_at"));

                boolean adaData = false;
                for (Data item : datas) {
                    if (item.getId() == id) {
                        adaData = true;
                        break;
                    }
                }
                if (!adaData) {
                    datas.add(0,new Data(id, judul, desc, created_at, updated_at));
                }
            } while (cursor.moveToNext());
        }


        rv_home.setHasFixedSize(true);
        DataAdapter adapterDatas = new DataAdapter(datas);
        rv_home.setAdapter(adapterDatas);
        if(!datas.isEmpty()){
            tv_no_data.setVisibility(View.GONE);
        }

        btnAddData.setOnClickListener(v -> {
            Intent toAddDataActivity = new Intent(this, AddDataActivity.class);
            startActivity(toAddDataActivity);
            finish();
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                dataSearch.clear();

                if(text.isEmpty()) {
                    rv_home.setAdapter(adapterDatas);
                    if(!datas.isEmpty()){
                        tv_no_data.setVisibility(View.GONE);

                    }else{
                        tv_no_data.setVisibility(View.VISIBLE);
                    }
                }else{
                    for (Data item : datas) {
                        String judul = item.getJudul().toLowerCase();
                        if (judul.contains(text.toLowerCase())) {
                            dataSearch.add(item);
                        }
                    }
                    if(dataSearch.isEmpty()){
                        tv_no_data.setVisibility(View.VISIBLE);
                    }else{
                        rv_home.setAdapter(adapterSearch);
                    }

                }

                return true;
            }

        });

    }

}