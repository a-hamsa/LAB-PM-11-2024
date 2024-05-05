package com.example.praktikum3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {
    private Integer profile;
    private String user;
    private Integer post;
    private String user2;
    private String caption;

    private String pengikut;

    private String mengikuti;

    private String biodata;

    public String getPengikut() {
        return pengikut;
    }

    public void setPengikut(String pengikut) {
        this.pengikut = pengikut;
    }

    public String getMengikuti() {
        return mengikuti;
    }

    public void setMengikuti(String mengikuti) {
        this.mengikuti = mengikuti;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }



    public Post(Integer profile, String user, Integer post, String user2, String caption, String pengikut , String mengikuti, String biodata) {
        this.profile = profile;
        this.user = user;
        this.post = post;
        this.user2 = user2;
        this.caption = caption;
        this.pengikut = pengikut;
        this.mengikuti = mengikuti;
        this.biodata = biodata;
    }

    protected Post(Parcel in) {
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        user = in.readString();
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        user2 = in.readString();
        caption = in.readString();
        pengikut = in.readString();
        mengikuti = in.readString();
        biodata = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        dest.writeString(user);
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        dest.writeString(user2);
        dest.writeString(caption);
        dest.writeString(pengikut);
        dest.writeString(mengikuti);
        dest.writeString(biodata);
    }
}