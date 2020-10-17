package com.example.sampleapiapp;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/users")
    Call<JsonObject> getUserList(@Query("page") String query);

    ///api/unknown

    @GET("api/unknown")
    Call<JsonObject> getResourceList();
}
