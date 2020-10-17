package com.example.sampleapiapp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiConfig {

    private static final String BASE_URL = "https://reqres.in/";

    public static Retrofit getApiConfig(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        Retrofit.Builder rBuilder = new Retrofit.Builder();
        try {
            rBuilder.baseUrl(BASE_URL);
        }catch (Exception e){
            e.printStackTrace();
        }

        Retrofit retrofit = rBuilder
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        return retrofit;
    }
}
