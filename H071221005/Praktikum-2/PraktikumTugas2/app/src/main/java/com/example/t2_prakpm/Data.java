package com.example.t2_prakpm;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {
    String nama;
    String username;
    Uri alamatImage;

    public Uri getAlamatImage() {
        return alamatImage;
    }

    public void setAlamatImage(Uri alamatImage) {
        this.alamatImage = alamatImage;
    }

    Data(){}
    protected Data(Parcel in) {
        nama = in.readString();
        username = in.readString();
        alamatImage = in.readParcelable(Uri.class.getClassLoader());
        title = in.readString();
        coontent = in.readString();
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

    public String getCoontent() {
        return coontent;
    }

    public void setCoontent(String coontent) {
        this.coontent = coontent;
    }

    public String getNama() {
        return nama;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    String title;
    String coontent;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(username);
        dest.writeParcelable(alamatImage, flags);
        dest.writeString(title);
        dest.writeString(coontent);

    }
}
