package com.example.post_registerandloginapp;

import com.example.post_registerandloginapp.Modals.LoginData;
import com.example.post_registerandloginapp.Modals.RegisterData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface Interface_Class {
    @FormUrlEncoded
    @POST("Register.php")
    Call<RegisterData> registerUser(@Field("Name") String name, @Field("Email") String email, @Field("Password") String password);

    @FormUrlEncoded
    @POST("Login.php")
    Call<LoginData> loginUser(@Field("Email") String email, @Field("Password") String password);
}
