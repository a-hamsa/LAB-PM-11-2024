package com.example.praktikumtugas4;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Player> players = generateDummyPlayers();

    private static ArrayList<Player> generateDummyPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Rey Mysterio",
                "619iamlucha",
                "Lorem ipsum dolor amet",
                R.drawable.rey_post,
                R.drawable.rey_profile,
                null));
        players.add(new Player("Shane Mcmahon",
                "theshanemcmahon",
                "Lorem ipsum dolor amet",
                R.drawable.shane_post,
                R.drawable.shane_profile,
                null));
        players.add(new Player("John Cena",
                "johncena",
                "Lorem ipsum dolor amet",
                R.drawable.john_post,
                R.drawable.john_profile,
                null));
        players.add(new Player("Roman Reigns",
                "romanreigns",
                "Lorem ipsum dolor amet",
                R.drawable.roman_post,
                R.drawable.roman_profile,
                null));
        players.add(new Player("Big E",
                "wwebige",
                "Lorem ipsum dolor amet",
                R.drawable.bige_post,
                R.drawable.bige_profile,
                null));
        players.add(new Player("Triple H",
                "tripleh",
                "Lorem ipsum dolor amet",
                R.drawable.tripleh_post,
                R.drawable.tripleh_profile,
                null));
        return players;
    }
}
