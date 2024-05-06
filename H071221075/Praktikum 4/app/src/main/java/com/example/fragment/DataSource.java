package com.example.fragment;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Story> stories = generateDummyStudents();

    private static ArrayList<Story> generateDummyStudents(){
        ArrayList<Story> stories = new ArrayList<>();
        stories.add(new Story(false, R.drawable.img, "riooorante", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "rio", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "ayambesar", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "kucingkecil", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "makanayam", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "anjinggalak", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "asugila", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "minumsusu", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "ayamhitam", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "jambiru", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "rodsteward", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));

        return stories;

    }
}
