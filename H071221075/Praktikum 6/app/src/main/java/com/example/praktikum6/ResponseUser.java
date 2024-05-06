package com.example.praktikum6;

import com.example.praktikum6.User;
import com.google.gson.annotations.SerializedName;

public class ResponseUser {

    @SerializedName("data")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
