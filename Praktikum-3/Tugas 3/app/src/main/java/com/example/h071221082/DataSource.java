package com.example.h071221082;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Account> accounts = generateDummyChats();
    private static ArrayList<Account> generateDummyChats(){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(R.drawable.profil1, R.drawable.worldafterthefall, R.drawable.sg1 ,"Jaehwan", "156", "12", "Meskipun hidup kalian kelam, lihatlah ke angkasa agar dapat tercerahkan"));
        accounts.add(new Account(R.drawable.profil2, R.drawable.tbate, R.drawable.sg2 ,"Arthur", "255", "8", "Adakah lawan yang seimbang bosqu?"));
        accounts.add(new Account(R.drawable.profil3, R.drawable.solev, R.drawable.sg3, "Sung Jin-Woo", "999", "20", "Ganteng maksimal seperti biasa ygy :)"));
        accounts.add(new Account(R.drawable.profil4, R.drawable.solomax, R.drawable.sg4, "Jinhyuk", "363", "32", "1 tangan aja cukup kalau lawannya orang cupu seperti kalian"));
        accounts.add(new Account(R.drawable.profil5, R.drawable.magician, R.drawable.sg5,"Otto", "156", "12", "kemarilah wahai anak muda... bersama kita membantai para monster-monster"));
        accounts.add(new Account(R.drawable.profil6, R.drawable.mercenary, R.drawable.sg6, "Ijin", "362", "41", "Infokan lapangan latihan bro"));
        accounts.add(new Account(R.drawable.profil7, R.drawable.limit, R.drawable.sg7, "Ki-Bong", "211", "35", "Puh... sepuh... ampun sepuhh...."));
        accounts.add(new Account(R.drawable.profil8, R.drawable.boxer, R.drawable.sg8, "Yu", "82", "8", "Undangan.apk"));
        accounts.add(new Account(R.drawable.profil9, R.drawable.blade, R.drawable.sg9, "Mu-Won", "744", "623", "Dinginnyeeee..."));
        accounts.add(new Account(R.drawable.profil10, R.drawable.iron, R.drawable.sg10, "Bichir", "130", "52", "Menyala abangkuhhh"));
       return accounts;
    }


}
