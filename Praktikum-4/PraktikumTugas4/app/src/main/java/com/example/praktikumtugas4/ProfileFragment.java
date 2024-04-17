package com.example.praktikumtugas4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_PROFILE = "extra_profile";

    ImageView fprofile_iv_profile;
    TextView fprofile_tv_name;
    TextView fprofile_tv_username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fprofile_iv_profile = view.findViewById(R.id.fprofile_iv_profile);
        fprofile_tv_name = view.findViewById(R.id.fprofile_tv_name);
        fprofile_tv_username = view.findViewById(R.id.fprofile_tv_username);

        if (getArguments() != null){
            fprofile_iv_profile.setImageResource(getArguments().getInt(EXTRA_PROFILE));
            fprofile_tv_name.setText(getArguments().getString(EXTRA_NAME));
            fprofile_tv_username.setText(getArguments().getString(EXTRA_USERNAME));
        }
    }
}