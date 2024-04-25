package com.example.tugaslima;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class People implements Parcelable {
    private String username, name, caption;
    private int imageprofile, imagepost;
    private Uri selectedImageUri;

    public People(String username, String name, String caption, int imageprofile, int imagepost) {
        this.username = username;
        this.name = name;
        this.caption = caption;
        this.imageprofile = imageprofile;
        this.imagepost = imagepost;
    }

    public People(String username, String name, String konten, int profile, Uri selectedImageUri) {
        this.username = username;
        this.name = name;
        this.caption = konten;
        this.imageprofile = profile;
        this.selectedImageUri = selectedImageUri;
    }

    protected People(Parcel in) {
        username = in.readString();
        name = in.readString();
        caption = in.readString();
        imageprofile = in.readInt();
        imagepost = in.readInt();
        selectedImageUri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(caption);
        dest.writeInt(imageprofile);
        dest.writeInt(imagepost);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getImageprofile() {
        return imageprofile;
    }

    public void setImageprofile(int imageprofile) {
        this.imageprofile = imageprofile;
    }

    public int getImagepost() {
        return imagepost;
    }

    public void setImagepost(int imagepost) {
        this.imagepost = imagepost;
    }

    public Uri getSelectedImageUri() {
        return selectedImageUri;
    }

    public void setSelectedImageUri(Uri selectedImageUri) {
        this.selectedImageUri = selectedImageUri;
    }
}