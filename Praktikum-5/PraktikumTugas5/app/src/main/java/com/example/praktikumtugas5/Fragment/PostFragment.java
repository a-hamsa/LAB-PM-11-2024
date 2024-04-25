package com.example.praktikumtugas5.Fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.praktikumtugas5.Account;
import com.example.praktikumtugas5.R;

import java.util.ArrayList;

public class PostFragment extends Fragment {
    Uri uriPost;
    Boolean cekGambar = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton fp_ib_postimage = view.findViewById(R.id.fp_ib_postimage);
        EditText fp_et_caption = view.findViewById(R.id.fp_et_caption);
        Button fp_btn_post = view.findViewById(R.id.fp_btn_post);

        ActivityResultLauncher<Intent> intentLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result->{
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){
                        uriPost = result.getData().getData();
                        fp_ib_postimage.setImageURI(uriPost);
                        cekGambar = true;
                    }
                });

        fp_ib_postimage.setOnClickListener(v->{
            Intent toGallery = new Intent(Intent.ACTION_PICK);
            toGallery.setType("image/*");
            intentLaunch.launch(toGallery);
        });
        
        fp_btn_post.setOnClickListener(v->{
            String content = fp_et_caption.getText().toString().trim();
            if (content.isEmpty()){
                Toast.makeText(getActivity(), "Silahkan isi caption terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else if (cekGambar == false) {
                Toast.makeText(getActivity(), "Silahkan pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                ArrayList<Account> accounts = new ArrayList<>();
                accounts.add(new Account("Tsubasa Ozora",
                        "@tsubasaozora10",
                        content,
                        R.drawable.tsubasaozora,
                        0,
                        uriPost));

                HomeFragment homeFragment = new HomeFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("accounts", accounts);
                homeFragment.setArguments(bundle);

                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, homeFragment, HomeFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();


            }
        });

    }
}