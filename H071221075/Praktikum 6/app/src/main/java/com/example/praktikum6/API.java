package com.example.praktikum6;

import com.example.praktikum6.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface API {
    @GET("api/users")
    Call<UserResponse> getUsers(@Query("page") int page);

    @GET("api/users/{id}")
    Call<ResponseUser> getUser(@Path("id") int id);
}
