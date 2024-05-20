package com.example.h071221082;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Account implements Parcelable {

    private Integer image, profile;
    private String fullname, username, konten;
    private Uri addPost;
    public Account(Integer image, Integer profile, String fullname, String username, String konten) {
        this.image = image;
        this.profile = profile;
        this.fullname = fullname;
        this.username = username;
        this.konten = konten;
    }
    public Account(Uri addPost, Integer profile, String fullname, String username, String konten) {
        this.addPost = addPost;
        this.profile = profile;
        this.fullname = fullname;
        this.username = username;
        this.konten = konten;
    }
    protected Account(Parcel in) {
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        fullname = in.readString();
        username = in.readString();
        konten = in.readString();
        addPost = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public Uri getAddPost() {
        return addPost;
    }

    public void setAddPost(Uri addPost) {
        this.addPost = addPost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (image == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image);
        }
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        dest.writeString(fullname);
        dest.writeString(username);
        dest.writeString(konten);
        dest.writeParcelable(addPost, flags);
    }
}
