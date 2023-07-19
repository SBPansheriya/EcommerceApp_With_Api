package com.example.post_registerandloginapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Image extends AppCompatActivity {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    ImageView imageView;
    Runnable runnable;
    int login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_image);
//        imageView = findViewById(R.id.splash);

        sharedPreferences = getSharedPreferences("myperf",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        login = sharedPreferences.getInt("login",0);

//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
//        imageView.setAnimation(animation);
        runnable = new Runnable() {
            @Override
            public void run() {
                if(login==0) {
                    Intent intent = new Intent(getApplicationContext(), LogIn_Page.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable,5000);
    }
}
