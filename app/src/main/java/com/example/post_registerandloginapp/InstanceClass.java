package com.example.post_registerandloginapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstanceClass {
    public static Interface_Class CallApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shreyecommerce.000webhostapp.com/MySite/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Interface_Class service = retrofit.create(Interface_Class.class);
        return service;
    }
}
