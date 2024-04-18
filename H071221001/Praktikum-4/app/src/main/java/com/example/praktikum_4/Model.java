package com.example.praktikum_4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    public static final Creator<Model> CREATOR = new Creator<Model>() {
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
    private String name, username, description;
    private int profileImg;
    private Uri img;

    public Model(String name2, String username2, int profileImg2, Uri img2, String description2) {
        this.name = name2;
        this.username = username2;
        this.profileImg = profileImg2;
        this.img = img2;
        this.description = description2;
    }

    public Model(String name2, String username2, int profileImg2) {
        this.name = name2;
        this.username = username2;
        this.profileImg = profileImg2;
    }

    protected Model(Parcel in) {
        this.name = in.readString();
        this.username = in.readString();
        this.profileImg = in.readInt();
        this.img = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.description = in.readString();
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.username);
        parcel.writeInt(this.profileImg);
        parcel.writeParcelable(this.img, i);
        parcel.writeString(this.description);
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username2) {
        this.username = username2;
    }

    public int getProfileImg() {
        return this.profileImg;
    }

    public void setProfileImg(int profileImg2) {
        this.profileImg = profileImg2;
    }

    public Uri getImg() {
        return this.img;
    }

    public void setImg(Uri img2) {
        this.img = img2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

}