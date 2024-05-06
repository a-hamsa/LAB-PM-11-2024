package com.example.fragment;

import static com.example.fragment.DataSource.stories;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class PostFragment extends Fragment {
    private static final int PICK_IMAGE = 100;
    private TextView caption;
    private ImageView photo;
    private Uri imageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        caption = view.findViewById(R.id.insertCaption);
        photo = view.findViewById(R.id.addPhoto);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        Button saveButton = view.findViewById(R.id.button5);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    if (imageUri == null) {
                        Toast.makeText(getActivity(), "Anda Belum Memilih Gambar!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    stories.add(0, new Story(false, imageUri, "riooorante", caption.getText().toString()));
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.frameLayout, new HomeFragment());
                    transaction.commit();

                } else {
                    Toast.makeText(getActivity(), "Isi data sebelum lanjut!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(caption.getText().toString())) {
            caption.setError("Caption Tidak Boleh Kosong!");
            return false; }

        return true;
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == -1 && data != null) {
            imageUri = data.getData();
        }
    }
}