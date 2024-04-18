package com.example.tugasempat;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<People> data = generateDummyData();

    private static ArrayList<People> generateDummyData() {
        ArrayList<People> data = new ArrayList<>();
        data.add(new People("Zhong Chenle", "Chenle", "Don’t be too hard on yourself, because it’s okay to do something wrong", R.drawable.chenle2, R.drawable.chenle2));
        data.add(new People("Lee Seokmin", "DK", "No matter what other people say, the main character in your life is you. So, believe in yourself and go for it!", R.drawable.dk, R.drawable.dk));
        data.add(new People("Kim Seokjin", "Jin", "Your presence can give happiness. I hope you remember that", R.drawable.jin, R.drawable.jin));
        data.add(new People("Kim Jennie", "Jennie", "Don't stop trying. Never be afraid to challenge yourself to do new things", R.drawable.jennie, R.drawable.jennie));
        data.add(new People("Kim Jisoo", "Jisoo", "Life is not easy, there will definitely be crossroads. That's our life", R.drawable.jisoo, R.drawable.jisoo));
        data.add(new People("Park JongSeong", "Jay", "Coba kenali diri sendiri untuk menjalani hidup yang lebih baik dan lebih bahagia", R.drawable.jay, R.drawable.jay));
        data.add(new People("Huang Renjun", "Renjun", "Semuanya membutuhkan keberanian untuk hasil yang baik", R.drawable.renjunnct, R.drawable.renjunnct));
        data.add(new People("Roseanne Park", "Rose", "Singing is kind of like stress relief and everything just kind of makes sense when I'm doing this", R.drawable.rose, R.drawable.rose));
        data.add(new People("Lalisa Manoban", "Lisa", "Jika kamu percaya pada diri sendiri dan berjuang sampai akhir, impianmu akan menjadi kenyataan", R.drawable.lalisa, R.drawable.lalisa));
        data.add(new People("Ariana Grande", "Ariana", "\"Berbahagialah dengan menjadi dirimu. Cintai kekuranganmu. Miliki kebiasaan Anda sendiri. Dan ketahuilah bahwa Anda sama sempurna dengan orang lain, persis seperti Anda", R.drawable.ariana, R.drawable.ariana));

        return data;
    }
}
