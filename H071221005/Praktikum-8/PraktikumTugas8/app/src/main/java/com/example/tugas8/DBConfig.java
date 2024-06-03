package com.example.tugas8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBConfig extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_JUDUL = "judul";
    private static final String COLUMN_DESC = "descr";
    private static final String COLUMN_CREATED_AT = "created_at";
    private static final String COLUMN_UPDATED_AT = "updated_at";
    public DBConfig(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // oncretae untuk membuat table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " ("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_JUDUL + " TEXT, "
                        + COLUMN_DESC + " TEXT, "
                        + COLUMN_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                        + COLUMN_UPDATED_AT + " TIMESTAMP  DEFAULT NULL )"
        );
    }

    //Create Data
    public void insertRecord(String judul, String desc){
        //buat database / panggil databaseny
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_JUDUL, judul);
        values.put(COLUMN_DESC, desc);
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        values.put(COLUMN_CREATED_AT, currentDateTime);
        db.insert(TABLE_NAME, null, values);
    }

    //get Data - gunanya Cursor untuk ngambil data nya
//    public Cursor getRecordById(int id_data){
//        SQLiteDatabase db = getReadableDatabase();
//        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[]{String.valueOf(id_data)});
//    }
    public Cursor getAllRecord(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Update
    public  void updateRecord(int id,String judul, String desc){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_JUDUL, judul);
        values.put(COLUMN_DESC, desc);
        // Mendapatkan waktu saat ini dalam format datetime
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        values.put(COLUMN_UPDATED_AT, currentDateTime);
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?" , new String[]{String.valueOf(id)});
    }

    //Delete
    public void deleteRecord(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = "+id, null);
    }
}
