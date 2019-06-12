package com.example.mypractice.network;

import com.example.mypractice.models.PhotoList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConfig {

    @GET("?key=yourKey&q=success&image_type=photo")
    Call<PhotoList> getPhotos();
}
