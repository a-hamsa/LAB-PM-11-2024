package com.example.praktikum3;

import static com.example.praktikum3.Adapter.StoryAdapter.ADD_STORY_TYPE;
import static com.example.praktikum3.Adapter.StoryAdapter.ALL_STORY_TYPE;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Post> posts = generateDummyPosts();
    public static ArrayList<StoryModel> storyModeles = generateDummyStory();

    private static ArrayList<Post> generateDummyPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.morphraxxa_profile, "morphraxxa", R.drawable.post1_morphraxxa, "Monochrome", "sedikit tidur banyak mimpi" , "66" , "78" , "nanti di warnai kalau ingat...."));
        posts.add(new Post(R.drawable.brighterwithds, "brighterwithds", R.drawable.post_bwds, "Brighter with Down Syndrome", "[ OPEN FUNRAISING ]" , "170" , "0" , "Community\n" +
                "Empowering and unveiling the beauty within Down Syndrome to shine their brightest light! One story at a time \uD83D\uDCD6\uD83D\uDC6B\uD83C\uDFFB\n" +
                "#ProjectInclusion #ShineOnDS"));
        posts.add(new Post(R.drawable.geniusstand, "geniusstand", R.drawable.post_1, "Pemilar Learning Center", "[ COMING SOON | BIMBINGAN BELAJAR 2024 ]", "609" , "95" , "Pemilar Learning Center \nEducation\nLembaga Sayap Pendidikan PP \n'PEMILAR PEMILAR LEARNING CENTER'\n📍Jl. Toddopuli 1, setapak 13 No. 66. Makassar📥 \nEmail : geniusstand18@gmail.com \npenaplc.wordpress.com"));
        posts.add(new Post(R.drawable.himatika, "himatikafmipaunhas", R.drawable.inau, "Himatika FMIPA Unhas", "INAGUGURASI 2022 REGISTRASI" , "1.715" , "469" , "FACEBOOK : Himatika FMIPA Unhas\n" + "Twitter : himatikafmipauh\n" + "YouTube : Himatika FMIPA Unhas\n" + "tiktok : himatika FMIPA Unhas\n" + "www.himatika-unhas.org"));
        posts.add(new Post(R.drawable.uhesport, "unhas_esport", R.drawable.unhasesport, "UKM Unhas Esports", "CAMPUS AMBASADOR" , "1.541" , "90" , "Esports Team\n" + "Divisi : PUBGM | MLBB | FF | Lol Wildrift | Lokapala | Valorant\n" + "Part of : @mlbb_studentleader , @pubgm.jawara @unipincommunity @hasanuddin_univ\n" + "linktr.ee/unhasesport"));
        posts.add(new Post(R.drawable.mathevent, "matevent_xxiv", R.drawable.post_math, "Mathematics Event XXIV", "YUK RAMAIKAN TWIBBON MATHEVENT XXIV" , "2,891" , "430" , "Education\n" + "Himatika FMIPA Unhas\n" + "Contact Person : 0813-3799-3787 (Rifqi)\n" + "Untuk informasi lebih lanjut kunjungi web ME XXIV ⬇" + "register.mathevent-unhas.com"));
        posts.add(new Post(R.drawable.buckslogo, "bucks", R.drawable.post_bucks, "Milwaukee Bucks", "Human highlight reel." , "5.5JT" , "281" , "#FearTheDeer\n" + "@bucksinsix\n" + "@bucksproshop\n" + "Watch on YouTube for more access\n" + "youtube.com/bucks"));
        posts.add(new Post(R.drawable.sunslogo, "suns", R.drawable.post_suns, "Phoenix Suns", "8TH ALL-TIME.Congrats, KD, on passing @SHAQ on the @NBA all-time scoring list!" , "3,6JT" , "181" , "#ComingInHot\n" + "Follow ➡@phxoffcourt\n" + "linktr.ee/suns"));
        posts.add(new Post(R.drawable.sisfo22, "sisfouh22", R.drawable.post_sisfo, "Sistem Informasi UH 2022", "[SELAMAT HARI BATIK]" , "116" , "1" , "Official Account \nSistem Informasi 2022 \n Universitas Hasanuddin"));
        posts.add(new Post(R.drawable.pandora, "pandora.corp", R.drawable.post_pandora, "Pandora Corp.", "Jika @pandoracybercafe buka cabang baru, dimana kira kira lokasi cabang baru kami? \uD83D\uDE33\uD83E\uDD14 Komen dibawah gengz!\uD83D\uDC47\n" +
                "\n" +
                "\uD83D\uDFE5 Youtube : Pandora Gaming TV\n" +
                "\uD83D\uDFE5 IG Fanpage : Pandora. Corp\n" +
                "\uD83D\uDFE6 FB Fanpage : Pandora. Corp\n" +
                "⚫ Tiktok : pandora.corp\n" +
                "\n" +
                "#BeProBePandora\uD83D\uDD35⚫ #ggpandora #esport #esporteam #esportnews #gamingpage #gamingchannel #gamingpost #gaming #warnet" , "15,6RB" , "209" , "Esports Professional Consultant\n" +
                "Pandora Esports\n" +
                "Pandora Gaming TV\n" +
                "@pandoracybercafe\n" +
                "@pandora.organizer.id\n" +
                "@pandora.communityroom\n" +
                "lynk.id/pandoracorp"));
        return posts;
    }

    private static ArrayList<StoryModel> generateDummyStory() {
        ArrayList<StoryModel> storyModeles = new ArrayList<>();

        storyModeles.add(new StoryModel(ADD_STORY_TYPE, "0" , R.drawable.profile1 , R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "1" ,"11","brighterwithds", R.drawable.brighterwithds, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "5" ,"14","geniusstand", R.drawable.geniusstand, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "3" ,"12","himatika", R.drawable.himatika, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "6" ,"15","unhas_esport", R.drawable.uhesport, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "8" ,"17","mathevent_xxiv", R.drawable.mathevent, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "10" ,"19","bucks", R.drawable.buckslogo, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "9" ,"18","suns", R.drawable.sunslogo, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "4" ,"13","sisfouh22", R.drawable.sisfo22, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "11" ,"20","pandora.corp", R.drawable.pandora, R.drawable.story_bwds));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "7" ,"16","morphraxxa", R.drawable.morphraxxa_profile, R.drawable.story_bwds));

        return storyModeles;
    }
}