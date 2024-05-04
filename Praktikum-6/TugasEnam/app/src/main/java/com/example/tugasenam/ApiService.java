package com.example.tugasenam;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<DataResponse> getData(@Query("page") String page);

    @GET("api/users/{id}")
    Call<ProfileResponse> getUser(@Path("id") String id);
}