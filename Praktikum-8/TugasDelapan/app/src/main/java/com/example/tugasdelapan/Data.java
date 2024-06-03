package com.example.tugasdelapan;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {
    private  int id;
    private String title;
    private String desc;
    private long createdTimestamp;
    private long updatedTimestamp;

    public Data() {

    }
    public Data(int id, String title, String desc, long createdTimestamp, long updatedTimestamp) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    protected Data(Parcel in) {
        id = in.readInt();
        title = in.readString();
        desc = in.readString();
        createdTimestamp = in.readLong();
        updatedTimestamp = in.readLong();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public long getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(long updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public boolean isNew() {
        return createdTimestamp == updatedTimestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(desc);
        dest.writeLong(createdTimestamp);
        dest.writeLong(updatedTimestamp);
    }
}
