package com.example.praktikumtugas3;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Account> accounts = generateDummyStudents();

    private static ArrayList<Account> generateDummyStudents() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(
                new Account("badminton.ina",
                        R.drawable.fp_badmintonina,
                        234,
                        5,
                        R.drawable.story_badmintonina,
                        R.drawable.post_badmintonina,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("folkative",
                        R.drawable.fp_folkative,
                        999,
                        20,
                        R.drawable.story_folkative,
                        R.drawable.post_folkative,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("gojekindonesia",
                        R.drawable.fp_gojekindonesia,
                        428,
                        10,
                        R.drawable.story_gojekindonesia,
                        R.drawable.post_gojekindonesia,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("ikn_id",
                        R.drawable.fp_ikn_id,
                        451,
                        2,
                        R.drawable.story_ikn_id,
                        R.drawable.post_ikn_id,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("kopikenangan.id",
                        R.drawable.fp_kopikenanganid,
                        620,
                        50,
                        R.drawable.story_kopikenanganid,
                        R.drawable.post_kopikenangan_id,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("lambe_turah",
                        R.drawable.fp_lambe_turah,
                        888,
                        0,
                        R.drawable.story_lambe_turah,
                        R.drawable.post_lambe_turah,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("laravelnews",
                        R.drawable.fp_laravelnews,
                        699,
                        7,
                        R.drawable.story_laravelnews,
                        R.drawable.post_laravelnews,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("leomessi",
                        R.drawable.fp_leomessi,
                        999,
                        5,
                        R.drawable.story_leomessi,
                        R.drawable.post_leomessi,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("makassar_iinfo",
                        R.drawable.fp_makassar_iinfo,
                        800,
                        15,
                        R.drawable.story_makassar_iinfo,
                        R.drawable.post_makassar_iinfo,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("mpl.id.official",
                        R.drawable.fp_mplidofficial,
                        789,
                        50,
                        R.drawable.story_mplidofficial,
                        R.drawable.post_mplidofficial,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("prabowo",
                        R.drawable.fp_prabowo,
                        998,
                        1,
                        R.drawable.story_prabowo,
                        R.drawable.post_prabowo,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("sainsunhas",
                        R.drawable.fp_sainsunhas,
                        500,
                        50,
                        R.drawable.story_sainsunhas,
                        R.drawable.post_sainsunhas,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("sandhikagalih",
                        R.drawable.fp_sandhikagalih,
                        700,
                        12,
                        R.drawable.story_sandhikagalih,
                        R.drawable.post_sandhikagalih,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("sisteminformasi.unhas",
                        R.drawable.fp_sisteminformasiunhas,
                        534,
                        8,
                        R.drawable.story_sisteminformasiunhas,
                        R.drawable.post_sisteminformasiunhas,
                        "Lorem Ipsum dolor amet"));
        accounts.add(
                new Account("unounhas",
                        R.drawable.fp_unounhas,
                        234,
                        20,
                        R.drawable.story_unounhas,
                        R.drawable.post_unounhas,
                        "Lorem Ipsum dolor amet"));
        return accounts;
    }
}
