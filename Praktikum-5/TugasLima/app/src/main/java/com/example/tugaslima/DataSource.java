package com.example.tugaslima;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<People> data = generateDummyData();

    private static ArrayList<People> generateDummyData() {
        ArrayList<People> data = new ArrayList<>();
        data.add(new People("Zhong Chenle", "Chenle", "Don’t be too hard on yourself", R.drawable.chenle2, R.drawable.chenle2));
        data.add(new People("Lee Seokmin", "Seokmin", "No matter what other people say", R.drawable.dk, R.drawable.dk));
        data.add(new People("Park JongSeong", "Jay", "Don't stop trying", R.drawable.jay, R.drawable.jay));
        data.add(new People("Roseanne Park", "Rose", "Life is not easy", R.drawable.rose, R.drawable.rose));
        data.add(new People("Kim Seokjin", "Seokjin", "Your presence can give happiness", R.drawable.jin, R.drawable.jin));

        return data;
    }

}
