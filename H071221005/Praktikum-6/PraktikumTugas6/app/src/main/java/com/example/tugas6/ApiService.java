package com.example.tugas6;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<UserResponse> getUsers(@Query("page") int page);
    @GET("api/users/{userId}")
    Call<UserResponse2> getIdUsers(@Path("userId") int userId);

}

