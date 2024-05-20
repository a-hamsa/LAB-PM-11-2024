package com.example.h071221082;

import android.app.Activity;
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
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class PostingFragment extends Fragment {

    private EditText inputKonten;
    private ImageView selectedImage;
    private Button postButton;
    private boolean isImageChanged = false;
    private Uri image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewpost = inflater.inflate(R.layout.fragment_posting, container, false);
        inputKonten = viewpost.findViewById(R.id.input_konten);
        selectedImage = viewpost.findViewById(R.id.image);
        postButton = viewpost.findViewById(R.id.postingBtn);

        selectedImage.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        postButton.setOnClickListener(view -> {
            if (inputKonten.getText().toString().trim().isEmpty()) {
                Toast.makeText(getActivity(), "Content is Empty!", Toast.LENGTH_SHORT).show();
                return;
            } if (!isImageChanged) {
                Toast.makeText(getActivity(), "Select an Image Please!!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Account newPost = new Account(image, R.drawable.profil, "Zulfikri Sadrah", "Zul", inputKonten.getText().toString());
                DataSource.accounts.add(0, newPost);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new HomeFragment())
                        .commit();
                Toast.makeText(getActivity(), "Content Posted!", Toast.LENGTH_SHORT).show();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.menu_home);
            }
        });

        return viewpost;

    } ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    image = data.getData();
                    selectedImage.setImageURI(image);
                    isImageChanged = true;
                }
            }
    );
}
