package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.c0782918_w2020_mad3125_fp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();



    }

     Handler handler = new Handler(){

         @Override
         public void handleMessage(@NonNull Message msg) {
             super.handleMessage(msg);
            
         }
     };
}
