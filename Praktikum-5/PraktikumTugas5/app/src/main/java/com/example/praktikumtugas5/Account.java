package com.example.praktikumtugas5;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    String name;
    String username;
    String caption;
    Integer profile;
    Integer post;

    Uri uriPost;

    public Account(String name, String username, String caption, Integer profile, Integer post, Uri uriPost) {
        this.name = name;
        this.username = username;
        this.caption = caption;
        this.profile = profile;
        this.post = post;
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

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Uri getUriPost() {
        return uriPost;
    }

    public void setUriPost(Uri uriPost) {
        this.uriPost = uriPost;
    }

    protected Account(Parcel in) {
        name = in.readString();
        username = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        uriPost = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(caption);
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        dest.writeParcelable(uriPost, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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
}
