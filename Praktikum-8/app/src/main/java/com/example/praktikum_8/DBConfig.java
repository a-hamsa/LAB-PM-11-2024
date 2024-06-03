package com.example.praktikum_8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConfig extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "praktikum_8";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_table";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "judul";
    private static final String COLUMN_DESCRIPTION = "deskripsi";
    private static final String COLUMN_CREATED_AT = "created_at";
    private static final String COLUMN_UPDATED_AT = "updated_at";

    public DBConfig(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " ("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COLUMN_TITLE + " TEXT,"
                        + COLUMN_DESCRIPTION + " TEXT,"
                        + COLUMN_CREATED_AT + " INTEGER,"
                        + COLUMN_UPDATED_AT + " INTEGER)"
        );
    }

    public void insertRecord(String judul, @Nullable String deskripsi) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, judul);
        values.put(COLUMN_DESCRIPTION, deskripsi);
        long currentTime = System.currentTimeMillis();
        values.put(COLUMN_CREATED_AT, currentTime);
        values.put(COLUMN_UPDATED_AT, currentTime);
        db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAllRecord() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public Cursor searchByTitle(String title) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TITLE + " LIKE ?", new String[]{"%" + title + "%"});
    }

    public void updateRecord(int id, String judul, @Nullable String deskripsi) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, judul);
        values.put(COLUMN_DESCRIPTION, deskripsi);
        values.put(COLUMN_UPDATED_AT, System.currentTimeMillis());
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void deleteRecord(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getColumnId() {
        return COLUMN_ID;
    }

    public String getColumnTitle() {
        return COLUMN_TITLE;
    }

    public String getColumnDescription() {
        return COLUMN_DESCRIPTION;
    }

    public String getColumnCreatedAt() {
        return COLUMN_CREATED_AT;
    }

    public String getColumnUpdatedAt() {
        return COLUMN_UPDATED_AT;
    }
}
