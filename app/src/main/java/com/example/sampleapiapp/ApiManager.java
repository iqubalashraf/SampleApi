package com.example.sampleapiapp;

import android.util.Log;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {

    ApiService service = ApiConfig.getApiConfig().create(ApiService.class);

    private static ApiManager instance = null;

    public static ApiManager getInstance(){
        if(instance == null){
            instance = new ApiManager();
        }
        return instance;
    }

    public void getUserList(final NetworkCallback callback){
        Call<JsonObject> call = service.getUserList("1");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NotNull Call<JsonObject> call, @NotNull Response<JsonObject> response) {
                if(callback != null){
                    callback.onSuccess(response.body().toString());
                }
            }

            @Override
            public void onFailure(@NotNull Call<JsonObject> call, @NotNull Throwable t) {
                if(callback != null){
                    callback.onFailure();
                }
            }
        });
    }

    public void getResourceList(final NetworkCallback callback){
        Call<JsonObject> call = service.getResourceList();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NotNull Call<JsonObject> call, @NotNull Response<JsonObject> response) {
                if(callback != null){
                    callback.onSuccess(response.body().toString());
                }
            }

            @Override
            public void onFailure(@NotNull Call<JsonObject> call, @NotNull Throwable t) {
                if(callback != null){
                    callback.onFailure();
                }
            }
        });
    }












    public interface NetworkCallback{
        void onSuccess(String response);
        void onFailure();
    }
}
