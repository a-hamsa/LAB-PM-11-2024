package com.example.praktikum_5;

import android.net.Uri;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Model> models = generateDummyModel();
    public static Model user = new Model("Farah Dwi", "frhdwi", R.drawable.p7);

    public static ArrayList<Model> generateDummyModel() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model("Kasein Nitrate", "kay111", R.drawable.p1,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p1"), "This is Cat 1"));
        models.add(new Model("Kayden Break", "kayden2", R.drawable.p2,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p2"), "This is Cat 2"));
        models.add(new Model("Melanie M", "melanie3", R.drawable.p3,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p3"), "This is Cat 3 "));
        models.add(new Model("william ham", "william", R.drawable.p4,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p4"), "This is Cat 4"));
        models.add(new Model("cambridge 555", "cambridge5", R.drawable.p5,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p5"), "This is Cat 5"));
        models.add(new Model("Natalie jane", "cat6", R.drawable.p6,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p6"), "This is Cat 6"));
        return models;
    }
}
