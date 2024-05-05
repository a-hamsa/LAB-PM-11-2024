package com.example.tugas5;

import static com.example.tugas5.DataSource.datas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tugas5.fragment.HomeFragment;
import com.example.tugas5.fragment.ProfileFragment;
import com.example.tugas5.fragment.SearchFragment;
import com.example.tugas5.fragment.UploadFragment;

public class MainActivity extends AppCompatActivity {
    TextView btnProfile;
    TextView btnHome;
    TextView btnUpload;

    TextView btnSearch;

    Uri alamatImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if(!(fragment instanceof HomeFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout,homeFragment)
                    .commit();
        }
        btnProfile = findViewById(R.id.btnProfile);
        btnHome = findViewById(R.id.btnHome);
        btnUpload = findViewById(R.id.btnUpload);
        btnSearch = findViewById(R.id.btnSearch);

        btnHome.setOnClickListener(v -> {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,homeFragment)
                    .commit();
        });

        btnProfile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,profileFragment)
                    .commit();
        });
        btnUpload.setOnClickListener(v -> {
            UploadFragment uploadFragment = new UploadFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, uploadFragment)
                    .commit();
        });

        btnSearch.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, searchFragment)
                    .commit();
        });
    }
    public void btnUpload(View view) {
        Intent galeriOpen = new Intent(Intent.ACTION_GET_CONTENT);
        galeriOpen.setType("image/*");
        openGallery.launch(Intent.createChooser(galeriOpen, "Choose your picture"));

    }

    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    UploadFragment uploadFragment = (UploadFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout);
                    Intent ambilImg = result.getData();
                    if(ambilImg != null){
                        alamatImage = ambilImg.getData();
                        ImageView imageView = findViewById(R.id.kotakImgUpload);
                        imageView.setImageURI(ambilImg.getData());
                        assert uploadFragment != null;
                        uploadFragment.ambilAlamatImg(ambilImg.getData());
                        uploadFragment.cekUpload(true);


                    }
                }
            }
    );
}