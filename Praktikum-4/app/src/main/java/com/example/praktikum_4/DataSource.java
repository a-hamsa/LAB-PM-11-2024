package com.example.praktikum_4;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("abouthify", "abouthifyyyyy"
                , "adakah? siap sedia 24 jam xixi", R.drawable.pp_abouthify, R.drawable.post_abouthify));

        instagrams1.add(new Instagram("elv.tg", "elvaaaaprili"
                , "hiling itu perlu!", R.drawable.pp_elva, R.drawable.post_elva));

        instagrams1.add(new Instagram("sisfouh22", "Sistem Informasi UH 2022"
                , "sistem informasi berbagi takjil part 2" +
                "#sibaji2024", R.drawable.pp_sisfo, R.drawable.post_sisfo));

        instagrams1.add(new Instagram("150cm", "satumapuluh"
                , "let's gooooooo" +
                "#software engineering courses", R.drawable.pp_satumapuluh, R.drawable.post_satumapuluh));

        instagrams1.add(new Instagram("ahhmantap_5520", "Mantappkalii"
                , "last ceremony! jaya slalu♡", R.drawable.pp_ahhmantap, R.drawable.post_ahhmantap));

        instagrams1.add(new Instagram("mv", "moodvibest"
                , "don't forget!", R.drawable.pp_moodvibest, R.drawable.post_moodvibest));
        return instagrams1;
    }
}
