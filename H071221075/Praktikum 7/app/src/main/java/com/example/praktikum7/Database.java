package com.example.praktikum7;

import android.content.Context;
import android.content.SharedPreferences;

public class Database {
    private static final String DB_Name = "APP_DB";

    public static void saveUserData(Context context, String nim, String PASS){
        SharedPreferences.Editor editor = context.getSharedPreferences(DB_Name, Context.MODE_PRIVATE).edit();
        editor.putString("nim", nim);
        editor.putString("pass", PASS);
        editor.apply();
    }

    public static Account getUserData(Context context){
        SharedPreferences data = context.getSharedPreferences(DB_Name, Context.MODE_PRIVATE);
        String nim = data.getString("nim", null);
        String pass = data.getString("pass", null);
        Account account = new Account(nim, pass);
        return account;
    }

    public static void setUserLogged(Context context, String nim){
        SharedPreferences.Editor editor = context.getSharedPreferences(DB_Name, Context.MODE_PRIVATE).edit();
        editor.putString("NIM_USER_LOGIN", nim);
        editor.apply();
    }

    public static String getUserLogged(Context context){
        SharedPreferences data = context.getSharedPreferences(DB_Name, Context.MODE_PRIVATE);
        return data.getString("NIM_USER_LOGIN", null);
    }

    public static void setSystemMode(Context context, Boolean isdark){
        SharedPreferences.Editor editor = context.getSharedPreferences(DB_Name, Context.MODE_PRIVATE).edit();
        editor.putBoolean("SYSTEM_MODE", isdark);
        editor.apply();
    }

    public static Boolean getSystemMode(Context context){
        SharedPreferences data = context.getSharedPreferences(DB_Name, Context.MODE_PRIVATE);
        return data.getBoolean("SYSTEM_MODE", false);
    }
}
