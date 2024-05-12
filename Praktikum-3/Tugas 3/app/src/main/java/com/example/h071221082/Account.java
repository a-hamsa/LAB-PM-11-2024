package com.example.h071221082;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

@SuppressLint("ParcelCreator")
public class Account implements Parcelable {
    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getStory() {
        return story;
    }

    public void setStory(Integer story) {
        this.story = story;
    }

    private Integer image, profile, story;
    private String username, follower, following, describe;

    public Account(Integer profile, Integer image, Integer story, String username, String follower, String following, String describe) {
        this.profile = profile;
        this.image = image;
        this.story = story;
        this.username = username;
        this.follower = follower;
        this.following = following;
        this.describe = describe;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(profile);
        dest.writeInt(image);
        dest.writeInt(story);
        dest.writeString(username);
        dest.writeString(follower);
        dest.writeString(following);
        dest.writeString(describe);
    }
}
