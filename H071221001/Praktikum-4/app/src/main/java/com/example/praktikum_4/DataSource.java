package com.example.praktikum_4;

import android.net.Uri;
import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Model> models = generateDummyModel();
    public static Model user = new Model("Farah Dwi", "frhdwi", R.drawable.p1);

    public static ArrayList<Model> generateDummyModel() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model("Cat 1", "cat1", R.drawable.p1,Uri.parse("android.resource://com.example.praktikum_4/drawable/" + "p1"), "This is Cat 1"));
        models.add(new Model("Cat 2", "cat2", R.drawable.p2,Uri.parse("android.resource://com.example.praktikum_4/drawable/" + "p2"), "This is Cat 2"));
        models.add(new Model("Cat 3", "cat3", R.drawable.p3,Uri.parse("android.resource://com.example.praktikum_4/drawable/" + "p3"), "This is Cat 3 "));
        models.add(new Model("Cat 4", "cat4", R.drawable.p4,Uri.parse("android.resource://com.example.praktikum_4/drawable/" + "p4"), "This is Cat 4"));
        models.add(new Model("Cat 5", "cat5", R.drawable.p5,Uri.parse("android.resource://com.example.praktikum_4/drawable/" + "p5"), "This is Cat 5"));
        models.add(new Model("Cat 6", "cat6", R.drawable.p6,Uri.parse("android.resource://com.example.praktikum_4/drawable/" + "p6"), "This is Cat 6"));
        return models;
    }
}
