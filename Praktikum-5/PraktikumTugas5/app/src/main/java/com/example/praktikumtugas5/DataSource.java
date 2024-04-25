package com.example.praktikumtugas5;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Account> accounts = generateDummyAccounts();

    private static ArrayList<Account> generateDummyAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Kojiro Hyuga",
                "@kojirohyuga9",
                "現地から応援いただいた皆様も、雨の中、たくさんのご声援をありがとうございました\uD83C\uDF38\uD83C\uDF38",
                R.drawable.kojirohyuga_profile,
                R.drawable.kojirohyuga_post,
                null));
        accounts.add(new Account("Masao Kazuo Tachibana",
                "@tachibanabrothers",
                "#名古屋グランパス 戦に向けて前日トレーニング\uD83D\uDCAA",
                R.drawable.masaokazuotachibana_profile,
                R.drawable.masaokazuotachibana_post,
                null));
        accounts.add(new Account("Genzo Wakabayashi",
                "@wakabayashi22",
                "別アングルシーンをお届け\uD83D\uDC40",
                R.drawable.genzowakabayashi_profile,
                R.drawable.genzowakabayashi_post,
                null));
        accounts.add(new Account("Hajime Taki",
                "@takihajime4",
                "本日誕生日を迎えた #舩木翔 選手をセレッソファミリーがバースデーソングで祝福\uD83C\uDF82",
                R.drawable.hajimetaki_profile,
                R.drawable.hajimetaki_post,
                null));
        accounts.add(new Account("Karl Heinz Schneider",
                "@khschneiderr",
                "Signature moves on and off the pitch – with the all-new, fully electric Audi Q6 e-tron. ✨\uD83D\uDC40",
                R.drawable.karlheinzschneider_profile,
                R.drawable.karlheinzschneider_post,
                null));
        accounts.add(new Account("Ken Wakashimazu",
                "@kwakash1mazu",
                "CLEAN SHEET\uD83D\uDCAA\uD83D\uDCAA\uD83D\uDCAA\uD83D\uDCAA\uD83D\uDCAA",
                R.drawable.kenwakashimazu_profile,
                R.drawable.kenwakashimazu_post,
                null));
        accounts.add(new Account("Ryo Ishizaki",
                "@ryoishizaki",
                "\\uD83D\\uDCF7\\n\" + \"ホーム G大阪戦まで、あと5日。",
                R.drawable.ryoishizaki_profile,
                R.drawable.ryoishizaki_post,
                null));
        accounts.add(new Account("Taro Misaki",
                "@misaki8",
                "【#大畑歩夢 U-23日本代表選出\uD83C\uDDEF\uD83C\uDDF5】\n" +
                        "AFC U23アジアカップ カタール2024に臨むU-23日本代表メンバーに、大畑歩夢が選出されました。",
                R.drawable.taromisaki_profile,
                R.drawable.taromisaki_post,
                null));
        accounts.add(new Account("Jun Misugi",
                "@4junmisugi",
                "\uD83D\uDC51新記録樹立\uD83D\uDC51\n" +
                        "#興梠慎三 J1リーグ18年連続ゴール達成",
                R.drawable.junmisugi_profile,
                R.drawable.junmisugi_post,
                null));
        return accounts;
    }

}
