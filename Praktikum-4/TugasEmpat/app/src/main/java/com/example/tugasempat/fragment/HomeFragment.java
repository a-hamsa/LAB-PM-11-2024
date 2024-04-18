package com.example.tugasempat.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tugasempat.DataSource;
import com.example.tugasempat.People;
import com.example.tugasempat.PostAdapter;
import com.example.tugasempat.R;

public class HomeFragment extends Fragment {

    public static final String EXTRA_INSTAGRAM = "extra_instagram";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPostingan = view.findViewById(R.id.rv_home);
        rvPostingan.setHasFixedSize(true);
        PostAdapter postinganAdapter = new PostAdapter(DataSource.data);
        rvPostingan.setAdapter(postinganAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            People people = bundle.getParcelable(EXTRA_INSTAGRAM);
            if (people != null) {
                DataSource.data.add(0, people);
                postinganAdapter.notifyDataSetChanged();
            }
        }

        ImageView iv_posting = view.findViewById(R.id.nav_post);
        ImageView iv_profile = view.findViewById(R.id.nav_profile);

        iv_posting.setOnClickListener(v -> {
            PostFragment postFragment = new PostFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, postFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_profile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}