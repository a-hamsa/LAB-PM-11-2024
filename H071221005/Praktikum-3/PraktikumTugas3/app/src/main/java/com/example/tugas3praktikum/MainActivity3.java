package com.example.tugas3praktikum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    public static final String PARCEL_DATA = "parcel_data";
    Data objData;

    TextView name;
    ImageView imgProfile;
    ImageView imgPost;
    TextView followers;
    TextView following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_isi_profile);

        name = findViewById(R.id.name);
        imgProfile = findViewById(R.id.imgProfile);
        imgPost = findViewById(R.id.imgPost);
        followers = findViewById(R.id.followers);
        following = findViewById(R.id.following);

        objData = getIntent().getParcelableExtra(PARCEL_DATA);
        name.setText(objData.getName());
        imgProfile.setImageResource(objData.getImgProfile());
        imgPost.setImageResource(objData.getImgPost());
        followers.setText(objData.getFollowers());
        following.setText(objData.getFollowing());

    }

    public void toStory(View view) {
        Intent toStory = new Intent(MainActivity3.this, MainActivity2.class);

        toStory.putExtra(MainActivity2.PARCEL_DATA,objData);
        startActivity(toStory);
    }

    public void toPostingan(View view) {
        Intent toPostingan = new Intent(MainActivity3.this, MainActivity4.class);
        toPostingan.putExtra(MainActivity4.PARCEL_DATA,objData);
        startActivity(toPostingan);
    }
}