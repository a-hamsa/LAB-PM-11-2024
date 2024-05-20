package com.example.h071221082;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Account> accounts = generateDummyChats();
    private static ArrayList<Account> generateDummyChats(){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(R.drawable.image1,R.drawable.profil1, "Rahmat Hidayat", "Mamat", "Ini postingan 1"));
        accounts.add(new Account(R.drawable.image2,R.drawable.profil2, "Kim Go Eun", "Go eun", "Ini postingan 2"));
        accounts.add(new Account(R.drawable.image3,R.drawable.profil3, "Park Shin Hye", "Park", "Ini postingan 3"));
        accounts.add(new Account(R.drawable.image4,R.drawable.profil4, "Irfan Ramadhan", "Erpan", "Ini postingan 4"));
        accounts.add(new Account(R.drawable.image5,R.drawable.profil5, "Reza Cahyadi", "Reza", "Ini postingan 5"));
        return accounts;
    }

}
