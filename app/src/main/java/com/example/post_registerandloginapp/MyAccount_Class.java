package com.example.post_registerandloginapp;

import static com.example.post_registerandloginapp.Splash_Image.editor;
import static com.example.post_registerandloginapp.Splash_Image.sharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.post_registerandloginapp.databinding.ActivityMyAccountClassBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MyAccount_Class extends AppCompatActivity {

    ActivityMyAccountClassBinding binding;
    private static final int CAMERA_REQUEST = 100;
    String imagepath,imagename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAccountClassBinding.inflate(LayoutInflater.from(getApplicationContext()));
        View view = binding.getRoot();
        setContentView(view);

        binding.nameTxt.setText(sharedPreferences.getString("name","1"));
        binding.emailTxt.setText(sharedPreferences.getString("email","2"));

        binding.profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RRR", "onClick: image view Clicked");
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, CAMERA_REQUEST);
            }
        });

        binding.singout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccount_Class.this, LogIn_Page.class);
                editor.putInt("login",0);
                editor.commit();
                startActivity(intent);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            binding.profileimage.setImageBitmap(bitmap);
            imagepath = saveToInternalStorage(bitmap);
        }
    }
    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        imagename = "img"+new Random().nextInt(100000)+".png";
        File mypath=new File(directory,imagename);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }
    private static String loadImageFromStorage(String path, ImageView imageView)
    {
        try {
            File f=new File(path);
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            imageView.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return path;
    }
}