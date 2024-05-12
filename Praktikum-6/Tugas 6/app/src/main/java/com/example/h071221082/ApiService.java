package com.example.h071221082;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<Users> getUsers(@Query("page") int page);
    @GET("api/users/{userId}")
    Call<UserId> getIdUsers(@Path("userId") int userId);

}
