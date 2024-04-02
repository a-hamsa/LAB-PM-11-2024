package com.example.praktikum_3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Model implements Parcelable {
    private Integer imageUser, imageFeeds, image2;
    private String username,caption, followers,following;

    public Model(Integer imageUser, Integer imageFeeds, String username, String caption, Integer image2, String followers, String following) {
        this.imageUser = imageUser;
        this.imageFeeds = imageFeeds;
        this.username = username;
        this.caption = caption;
        this.image2 = image2;
        this.followers = followers;
        this.following = following;
    }

    protected Model(Parcel in) {
        if (in.readByte() == 0) {
            imageUser = null;
        } else {
            imageUser = in.readInt();
        }
        if (in.readByte() == 0) {
            imageFeeds = null;
        } else {
            imageFeeds = in.readInt();
        }
        if (in.readByte() == 0) {
            image2 = null;
        } else {
            image2 = in.readInt();
        }
        username = in.readString();
        caption = in.readString();
        followers = in.readString();
        following = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public Integer getImageUser() {
        return imageUser;
    }

    public void setImageUser(Integer imageUser) {
        this.imageUser = imageUser;
    }

    public Integer getImageFeeds() {
        return imageFeeds;
    }

    public void setImageFeeds(Integer imageFeeds) {
        this.imageFeeds = imageFeeds;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (imageUser == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageUser);
        }
        if (imageFeeds == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageFeeds);
        }
        if (image2 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image2);
        }
        dest.writeString(username);
        dest.writeString(caption);
        dest.writeString(followers);
        dest.writeString(following);
    }

    public Integer getImage2() {
        return image2;
    }

    public void setImage2(Integer image2) {
        this.image2 = image2;
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
}
