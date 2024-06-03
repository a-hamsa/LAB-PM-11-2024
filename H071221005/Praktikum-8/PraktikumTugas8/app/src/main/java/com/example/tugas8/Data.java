package com.example.tugas8;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {
    String judul,desc,created_at,update_at;
    int id;


    public Data(int id,String judul, String desc, String created_at, String update_at) {
        this.id = id;
        this.judul = judul;
        this.desc = desc;
        this.created_at = created_at;
        this.update_at = update_at;
    }
    public Data(String judul, String desc, String created_at, String update_at) {
        this.judul = judul;
        this.desc = desc;
        this.created_at = created_at;
        this.update_at = update_at;
    }


    protected Data(Parcel in) {
        judul = in.readString();
        desc = in.readString();
        created_at = in.readString();
        update_at = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(desc);
        dest.writeString(created_at);
        dest.writeString(update_at);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
