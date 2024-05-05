package com.example.praktikum_5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class PostFragment extends Fragment implements View.OnClickListener {
    private EditText descriptionEt;
    private ImageView imgContentIv;
    private Button postingBtn;
    private Uri selectedImg;

    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == AppCompatActivity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        selectedImg = data.getData();
                        imgContentIv.setImageURI(selectedImg);
                    } else {
                        Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (requireActivity() != null && ((AppCompatActivity) requireActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle("Add Post");
        }
        descriptionEt = view.findViewById(R.id.descriptionEt);
        imgContentIv = view.findViewById(R.id.imgContentIv);
        postingBtn = view.findViewById(R.id.postingBtn);
        imgContentIv.setOnClickListener(this);
        postingBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgContentIv) {
            openGallery();
        } else if (v.getId() == R.id.postingBtn) {
            postContent();
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        openGallery.launch(intent);
    }

    private void postContent() {
        if (descriptionEt.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Konten Masih Kosong", Toast.LENGTH_LONG).show();
        } else if (selectedImg == null) {
            Toast.makeText(getActivity(), "Pilih Gambar Terlebih Dahulu", Toast.LENGTH_LONG).show();
        } else {
            HomeFragment homeFragment = new HomeFragment();
            Model newPost = new Model(
                    DataSource.user.getName(),
                    DataSource.user.getUsername(),
                    DataSource.user.getProfileImg(),
                    selectedImg,
                    descriptionEt.getText().toString()
            );
            Bundle bundle = new Bundle();
            bundle.putParcelable(HomeFragment.EXTRA_POST, newPost);
            homeFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction().replace(((ViewGroup) getView().getParent()).getId(), homeFragment, HomeFragment.class.getSimpleName()).commit();
        }
    }
}
