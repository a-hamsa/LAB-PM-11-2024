package com.example.h071221082;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profile;
    private TextView fullname, username;
    Account userprofile;
    ProgressBar spinner;
    LinearLayout profilelayout;
    Handler handler = new Handler(Looper.getMainLooper());

    public static final String PROFILE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.profile);
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        spinner = findViewById(R.id.spinner);
        profilelayout = findViewById(R.id.profilelayout);

        userprofile = getIntent().getParcelableExtra(PROFILE_DATA);
        profilelayout.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                spinner.setVisibility(View.GONE);
                profilelayout.setVisibility(View.VISIBLE);

                profile.setImageResource(userprofile.getProfile());
                fullname.setText(userprofile.getFullname());
                username.setText(userprofile.getUsername());
            }
        }, 2000);

    }
}