package com.example.praktikumtugas4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    public static final String EXTRA_CONTENT = "extra_content";
    public static final String EXTRA_POST = "extra_post";

    private ArrayList<Player> players;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvPlayers = view.findViewById(R.id.fh_rv);
        players = new ArrayList<>();
        PlayerAdapter playerAdapter = new PlayerAdapter(DataSource.players,this);
        rvPlayers.setAdapter(playerAdapter);

        if (getArguments() != null) {
            ArrayList<Player> receivedPlayer = getArguments().getParcelableArrayList("players");
            if (receivedPlayer != null){
                DataSource.players.addAll(0,receivedPlayer);
                playerAdapter.notifyDataSetChanged();
            }

        }


    }
}