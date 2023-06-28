package com.example.post_registerandloginapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface Interface_Class {
    @FormUrlEncoded
    @POST("Register.php")
    Call<Modal_Class> registerUser(@Field("Name") String name,@Field("Email") String email,@Field("Password") String password);
}
