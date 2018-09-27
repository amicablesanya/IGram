package com.example.abcplusd.igram.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InstaAPI {
    String BASE_URL = "https://api.unsplash.com/users/fableandfolk/collections";

    @GET("photos")
    Call<List<String>> getPhotos();
}
