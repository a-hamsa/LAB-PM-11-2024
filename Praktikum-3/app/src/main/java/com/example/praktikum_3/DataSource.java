package com.example.praktikum_3;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyPostingans();

    private static ArrayList<Instagram> generateDummyPostingans() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("sisfouh22", "SIBER'2024 jangan ada syntax error diantara kita", R.drawable.pp_sisfo, R.drawable.post_sisfo, R.drawable.sg_sisfo, "116", "1"));
        instagrams1.add(new Instagram("satumapuluh", "cissss", R.drawable.pp_satumapuluh, R.drawable.post_satumapuluh, R.drawable.sg_satumapuluh, "271 T", "5"));
        instagrams1.add(new Instagram("miasatu'22","sesi 1 corona", R.drawable.pp_miasatu, R.drawable.post_miasatu, R.drawable.sg_miasatu, "2019", "33"));
        instagrams1.add(new Instagram("ahhmantap_5520", "last ceremony!", R.drawable.pp_ahhmntap, R.drawable.post_ahhmntap, R.drawable.sg_ahhmntap, "46", "24"));
        instagrams1.add(new Instagram("marshandalaluhann_", "apa yahh", R.drawable.pp_acha, R.drawable.post_acha, R.drawable.sg_acha, "772", "776"));
        instagrams1.add(new Instagram("heyyo.rhantytl", "grow up!", R.drawable.pp_rhanty, R.drawable.post_rhanty, R.drawable.sg_rhanty, "760", "667"));
        instagrams1.add(new Instagram("ameliaa_sti", "pantai molino~", R.drawable.pp_siamel, R.drawable.post_siamel, R.drawable.sg_siamel, "585", "530"));
        instagrams1.add(new Instagram("allandipp", "........", R.drawable.pp_alip, R.drawable.post_alip, R.drawable.sg_alip, "229", "391"));
        instagrams1.add(new Instagram("noellfnt.o", "simple..", R.drawable.pp_noel, R.drawable.post_noel, R.drawable.sg_noel, "565", "548"));
        instagrams1.add(new Instagram("abouthify", "sehat-sehat semua orang", R.drawable.pp_abouthify, R.drawable.post_abouthify, R.drawable.sg_abouthify, "942 RB", "O"));
        instagrams1.add(new Instagram("urraaaaa", "janlupa makan", R.drawable.pp_urra, R.drawable.post_urra, R.drawable.sg_urra, "80 RB", "8"));
        instagrams1.add(new Instagram("elva_timang", "hello world!", R.drawable.pp_elva, R.drawable.post_elva, R.drawable.sg_elva, "1556", "784"));
        return instagrams1;

    }
}