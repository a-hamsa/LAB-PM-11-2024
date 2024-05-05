package com.example.tugas5;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {
    Integer imgProfile;
    Integer imgPost;
    Uri uriImgPost;
    String namaLengkap;
    String nickName;
    String desc;

    public Data(Integer imgProfile, Integer imgPost, String namaLengkap, String nickName, String desc) {
        this.imgProfile = imgProfile;
        this.imgPost = imgPost;
        this.namaLengkap = namaLengkap;
        this.nickName = nickName;
        this.desc = desc;
    }
    public Data(Integer imgProfile, Uri imgPost, String namaLengkap, String nickName, String desc) {
        this.imgProfile = imgProfile;
        this.uriImgPost = imgPost;
        this.namaLengkap = namaLengkap;
        this.nickName = nickName;
        this.desc = desc;
    }
//    public Data(Integer imgProfile,String namaLengkap, String nickName) {
//        this.imgProfile = imgProfile;
//        this.namaLengkap = namaLengkap;
//        this.nickName = nickName;
//    }


    protected Data(Parcel in) {
        if (in.readByte() == 0) {
            imgProfile = null;
        } else {
            imgProfile = in.readInt();
        }
        if (in.readByte() == 0) {
            imgPost = null;
        } else {
            imgPost = in.readInt();
        }
        uriImgPost = in.readParcelable(Uri.class.getClassLoader());
        namaLengkap = in.readString();
        nickName = in.readString();
        desc = in.readString();
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

    public Uri getUriImgPost() {
        return uriImgPost;
    }

    public void setUriImgPost(Uri uriImgPost) {
        this.uriImgPost = uriImgPost;
    }

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

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        if (imgProfile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imgProfile);
        }
        if (imgPost == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imgPost);
        }
        dest.writeParcelable(uriImgPost, flags);
        dest.writeString(namaLengkap);
        dest.writeString(nickName);
        dest.writeString(desc);
    }


}
