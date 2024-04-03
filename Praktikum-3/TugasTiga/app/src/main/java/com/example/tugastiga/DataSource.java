package com.example.tugastiga;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<People> data = generateDummyData();

    private static ArrayList<People> generateDummyData() {
        ArrayList<People> data = new ArrayList<>();
        data.add(new People("Lalisa Manoban", "Sometimes life doesn’t give you what you want, not because you don’t deserve it, but because you deserve so much more", R.drawable.lalisa, R.drawable.beruang, R.drawable.belanda, 5000000, 0));
        data.add(new People("Taylor Swift", "Never regret a day in your life; good days give happiness, bad days give experiences, worst days give lessons, and best days give memories", R.drawable.taylor, R.drawable.tupai, R.drawable.jepang, 6000000, 10));
        data.add(new People("Park Jong Seong", "Loving yourself starts with liking yourself, which starts with respecting yourself, which starts with thinking of yourself in positive ways", R.drawable.jay, R.drawable.burung_hantu, R.drawable.indonesia, 7000000, 20));
        data.add(new People("Kim Jennie", "Love, it could make you sad. It could even make you lonely sometimes. But that love can also make you happier than you’ll ever be", R.drawable.jennie, R.drawable.macan, R.drawable.finlandia, 8000000, 30));
        data.add(new People("Roseanne Park", "Today is a lesson, for a tomorrow that is certainly more hopeful", R.drawable.rose, R.drawable.harimau, R.drawable.swiss, 9000000, 40));
        data.add(new People("Ariana Grande", "You’re yours yourself not theirs or anyone else", R.drawable.ariana, R.drawable.kelinci, R.drawable.swedia, 10000000, 50));
        data.add(new People("Huang Renjun", "Some people experience the days of their life differently", R.drawable.renjun, R.drawable.kucing, R.drawable.korea, 11000000, 60));
        data.add(new People("Lee Seokmin", "Being single is the time to think for you and grow", R.drawable.dk, R.drawable.panda, R.drawable.hongkong, 12000000, 70));
        data.add(new People("Kim Seokjin", "Life is a journey to be experienced, not a problem to be solved", R.drawable.jin, R.drawable.serigala, R.drawable.denmark, 13000000, 80));
        data.add(new People("Kim Jisoo", "The best view comes after the hardest climb", R.drawable.jisoo, R.drawable.siberian, R.drawable.usa, 14000000, 90));
        return data;
    }
}