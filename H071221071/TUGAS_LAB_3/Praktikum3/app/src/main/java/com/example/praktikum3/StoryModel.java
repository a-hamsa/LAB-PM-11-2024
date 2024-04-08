package com.example.praktikum3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class StoryModel implements Parcelable {
    String uid, sid, name;
    int image;
    int type;
    int imageStory;

    public int getImageStory() {
        return imageStory;
    }

    public void setImageStory(int imageStory) {
        this.imageStory = imageStory;
    }

    public StoryModel(int type, String uid, String sid, String name, int image, int imageStory) {
        this.type = type;
        this.uid = uid;
        this.sid = sid;
        this.name = name;
        this.image = image;
        this.imageStory = imageStory;

    }

    public StoryModel( int type,String uid, int image, int imageStory) {
        this.type = type;
        this.uid = uid;
        this.image = image;
        this.imageStory = imageStory;

    }


    protected StoryModel(Parcel in) {
        uid = in.readString();
        sid = in.readString();
        name = in.readString();
        image = in.readInt();
        type = in.readInt();
        imageStory = in.readInt();
    }

    public static final Creator<StoryModel> CREATOR = new Creator<StoryModel>() {
        @Override
        public StoryModel createFromParcel(Parcel in) {
            return new StoryModel(in);
        }

        @Override
        public StoryModel[] newArray(int size) {
            return new StoryModel[size];
        }
    };

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(sid);
        dest.writeString(name);
        dest.writeInt(image);
        dest.writeInt(type);
        dest.writeInt(imageStory);
    }
}
