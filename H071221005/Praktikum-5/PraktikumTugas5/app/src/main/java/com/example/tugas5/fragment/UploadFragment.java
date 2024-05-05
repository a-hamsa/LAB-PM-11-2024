package com.example.tugas5.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugas5.Data;
import com.example.tugas5.DataSource;
import com.example.tugas5.R;

public class UploadFragment extends Fragment {
    Button btnPosting;
    boolean gambarTerpilih;
    Uri alamatImg;
    public void ambilAlamatImg(Uri uri){
        alamatImg = uri;
    }


    public void cekUpload(boolean periksa){
        gambarTerpilih = periksa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();

        EditText desc = view.findViewById(R.id.descUpload);

        btnPosting = view.findViewById(R.id.btnPosting);
        btnPosting.setOnClickListener(v -> {
            if(desc.getText().toString().isEmpty()){
                Toast.makeText(getContext(),"Masukan Konten Dahulu",Toast.LENGTH_SHORT).show();
            }else if(!gambarTerpilih){
                Toast.makeText(getContext(),"Pilih Gambar Terlebih Dahulu",Toast.LENGTH_SHORT).show();
            }else{
                DataSource.datas.add(0,new Data(R.drawable.gambarpp,alamatImg,"Raehan Ramadhan Hamzah","raehan17",desc.getText().toString()));
                Toast.makeText(getContext(),"Data berhasil ditambahkan",Toast.LENGTH_SHORT).show();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,homeFragment)
                        .commit();
            }
        });

    }

}