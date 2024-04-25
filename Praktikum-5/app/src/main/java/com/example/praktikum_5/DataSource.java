package com.example.praktikum_5;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("flow.id","flowerssss","sunset♡",R.drawable.pp_bunga,R.drawable.post_bunga));
        instagrams1.add(new Instagram("sisfo22uh", "SISTEM INFORMASI 2022","bakar-bakar part 2.",R.drawable.pp_sisfo,R.drawable.post_sisfo));
        instagrams1.add(new Instagram("ahhmantap_5520", "mantapppkalii","jumpa lagi!",R.drawable.pp_ahhmantap, R.drawable.post_ahhmantap));
        instagrams1.add(new Instagram("150", "satumapuluh","heyyo",R.drawable.pp_satumapuluh,R.drawable.pp_satumapuluh));
        instagrams1.add(new Instagram("MV","moodvibest","yuhuuuu",R.drawable.pp_moodvibest, R.drawable.post_moodvibest));
        return instagrams1;
    }

    public static ArrayList<Instagram> getInstagrams() {
        return instagrams;
    }
}
