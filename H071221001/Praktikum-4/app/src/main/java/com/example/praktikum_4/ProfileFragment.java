package com.example.praktikum_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    public static String EXTRA_USER = "extra_user";
    private ImageView imgProfileIv;
    private TextView nameTv, usernameTv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Model model;
        ProfileFragment.super.onViewCreated(view, savedInstanceState);
        changeActionBarTitle();
        this.imgProfileIv = (ImageView) view.findViewById(R.id.image_view);
        this.nameTv = (TextView) view.findViewById(R.id.text_fullname);
        this.usernameTv = (TextView) view.findViewById(R.id.text_username);
        if (getArguments() != null) {
            model = (Model) getArguments().getParcelable(EXTRA_USER);
        } else {
            model = DataSource.user;
        }
        this.imgProfileIv.setImageResource(model.getProfileImg());
        this.nameTv.setText(model.getName());
        this.usernameTv.setText(model.getUsername());
    }

    public void changeActionBarTitle() {
        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle("Profile");
            }
        }
    }
}