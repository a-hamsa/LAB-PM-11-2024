package com.example.fragment;

import android.net.Uri;

public class Story {

    private boolean seen;
    private Integer image;
    private String username;
    private String caption;
    private Uri imageUri;

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public Story(boolean seen, Integer image, String username, String caption) {
        this.seen = seen;
        this.image = image;
        this.username = username;
        this.caption = caption;
    }
    public Story(boolean seen, Uri image, String username, String caption) {
        this.seen = seen;
        this.imageUri = image;
        this.username = username;
        this.caption = caption;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
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
}
