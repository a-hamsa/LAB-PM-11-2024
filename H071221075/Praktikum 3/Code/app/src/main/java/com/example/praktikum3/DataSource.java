package com.example.praktikum3;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Story> stories = generateDummyStudents();

    private static ArrayList<Story> generateDummyStudents(){
        ArrayList<Story> stories = new ArrayList<>();
        stories.add(new Story(false, R.drawable.img, "riooorante", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img1, "rio", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "ayambesar", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img1, "kucingkecil", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "makanayam", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img1, "anjinggalak", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "asugila", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img1, "minumsusu", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "ayamhitam", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img1, "jambiru", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));
        stories.add(new Story(false, R.drawable.img, "rodsteward", "Hari ini saya makan ayam betina bakar, rasanya enak sekali!"));

        return stories;

    }
}
