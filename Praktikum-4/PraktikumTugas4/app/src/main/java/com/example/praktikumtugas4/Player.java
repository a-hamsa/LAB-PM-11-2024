package com.example.praktikumtugas4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Player implements Parcelable {
    private String name;
    private String username;
    private String caption;
    private Integer post;
    private Integer profile;
    private Uri uriPost;

    public Player(String name, String username, String caption, Integer post, Integer profile, Uri uriPost) {
        this.name = name;
        this.username = username;
        this.caption = caption;
        this.post = post;
        this.profile = profile;
        this.uriPost = uriPost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Uri getUriPost() {
        return uriPost;
    }

    public void setUriPost(Uri uriPost) {
        this.uriPost = uriPost;
    }

    protected Player(Parcel in) {
        name = in.readString();
        username = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        uriPost = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(caption);
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        dest.writeParcelable(uriPost, flags);
    }

}
