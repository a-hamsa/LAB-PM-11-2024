package com.example.tugas3praktikum;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {
    private Integer imgProfile;
    private Integer imgPost;
    private String name;
    private String desc;
    private String followers;
    private String following;

    public Data(Integer imgProfile, Integer imgPost, String name, String desc, String followers, String following) {
        this.imgProfile = imgProfile;
        this.imgPost = imgPost;
        this.name = name;
        this.desc = desc;
        this.followers = followers;
        this.following = following;
    }

    protected Data(Parcel in) {
        if(in.readByte() == 0){
            imgProfile = null;
            imgPost = null;
        }else{
            imgProfile = in.readInt();
            imgPost = in.readInt();
        }
        name = in.readString();
        desc = in.readString();
        followers = in.readString();
        following= in.readString();
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

    public Data() {}

    public Integer getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(Integer imgProfile) {
        this.imgProfile = imgProfile;
    }

    public Integer getImgPost() {
        return imgPost;
    }

    public void setImgPost(Integer imgPost) {
        this.imgPost = imgPost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if(imgProfile == null || imgPost == null){
            parcel.writeByte((byte) 0);
        }else{
            parcel.writeByte((byte) 1);
            parcel.writeInt(imgProfile);
            parcel.writeInt(imgPost);

        }
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeString(followers);
        parcel.writeString(following);
    }


}
