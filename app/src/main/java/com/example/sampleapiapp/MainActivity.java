package com.example.sampleapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getUserList(View view){
        ApiManager.getInstance().getUserList(new ApiManager.NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Log.d("ApiLog", response);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    public void getResourceList(View view){
        ApiManager.getInstance().getResourceList(new ApiManager.NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Log.d("ApiLog", response);
            }

            @Override
            public void onFailure() {

            }
        });
    }

}