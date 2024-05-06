package com.example.fragment;

import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SeenData {
    private Integer image;
    private String username;

    public SeenData(Integer image, String username) {
        this.image = image;
        this.username = username;
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
}
