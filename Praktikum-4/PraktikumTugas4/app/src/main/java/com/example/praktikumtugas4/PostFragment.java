package com.example.praktikumtugas4;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class PostFragment extends Fragment {

    EditText fpost_et_content;
    ImageButton fpost_ib_post;
    Button fpost_btn_post;
    TextView fprofile_tv_name;
    TextView fprofile_tv_username;
    Boolean cekGambar = false;

    Uri uriGambar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fpost_et_content = view.findViewById(R.id.fpost_et_content);
        fpost_ib_post = view.findViewById(R.id.fpost_iv_post);
        fpost_btn_post = view.findViewById(R.id.fpost_btn_post);
        fprofile_tv_name = view.findViewById(R.id.fprofile_tv_name);
        fprofile_tv_username = view.findViewById(R.id.fprofile_tv_username);



        ActivityResultLauncher<Intent> intentLaunch =registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){
                        uriGambar = result.getData().getData();
                        fpost_ib_post.setImageURI(uriGambar);
                        cekGambar = true;

                    }
                }
        );

        fpost_ib_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGallery = new Intent(Intent.ACTION_PICK);
                toGallery.setType("image/*");
                intentLaunch.launch(toGallery);
            }
        });


        fpost_btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = fpost_et_content.getText().toString().trim();
                if (content.isEmpty()) {
                    Toast.makeText(getActivity(), "Silahkan isi content", Toast.LENGTH_SHORT).show();
                } else if (cekGambar == false) {
                    Toast.makeText(getActivity(), "Silahkan pilih gambar", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayList<Player> players = new ArrayList<>();
                    players.add(new Player("Undertaker",
                            "theundertaker",
                            fpost_et_content.getText().toString(),
                            0,
                            R.drawable.undertaker_profile,
                            uriGambar));

                    HomeFragment homeFragment = new HomeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("players", players);
                    homeFragment.setArguments(bundle);

                    FragmentManager fragmentManager = getParentFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, homeFragment, HomeFragment.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();

                }



            }
        });




    }
}