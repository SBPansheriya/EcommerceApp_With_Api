package com.example.post_registerandloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Image extends AppCompatActivity {

    ImageView imageView;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_image);
        imageView = findViewById(R.id.splash);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        imageView.setAnimation(animation);
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Image.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable,5000);
    }
}
