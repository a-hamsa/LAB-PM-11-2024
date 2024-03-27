package com.example.t2_prakpm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean gambarTerpilih;
    Uri alamatImage;
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
    }

    public void btnUploadImg(View view) {
        Intent galeriOpen = new Intent(Intent.ACTION_GET_CONTENT);
        galeriOpen.setType("image/*");
        openGallery.launch(Intent.createChooser(galeriOpen, "Choose your picture"));
    }

    public void btnSubmit(View view) {
        EditText inputanNama = findViewById(R.id.inputanNama);
        EditText inputanUsername = findViewById(R.id.inputanUsername);
        Intent toActivity2 = new Intent(MainActivity.this, MainActivity2.class);
        Data data = new Data();
        data.setAlamatImage(alamatImage);
        data.setNama(inputanNama.getText().toString());
        data.setUsername(inputanUsername.getText().toString());
        toActivity2.putExtra(MainActivity2.PARCEL_DATA,data);




        if(!gambarTerpilih){
            Toast.makeText(getApplicationContext(),"Pilih Gambar Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        } else if (inputanNama.getText().toString().isEmpty()) {
            inputanNama.setError("Inputan Tidak Boleh Kosong !");
        } else if (inputanUsername.getText().toString().isEmpty()) {
            inputanUsername.setError("Inputan Tidak Boleh Kosong !");
        } else {

            startActivity(toActivity2);
        }

    }
    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent ambilImg = result.getData();
                    if(ambilImg != null){
                        //untuk ditampilkan di activity 3
                        alamatImage = ambilImg.getData();

                        //untuk ditampilkan di activity1
                        ImageView imageView = findViewById(R.id.imageView);
                        imageView.setImageURI(ambilImg.getData());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        imageView.setAdjustViewBounds(true);
                        gambarTerpilih = true;


                    }
                }
            }
    );
}



