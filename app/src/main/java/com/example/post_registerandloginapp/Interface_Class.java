package com.example.post_registerandloginapp;

import com.example.post_registerandloginapp.Modal.AddProductData;
import com.example.post_registerandloginapp.Modal.Login_Data;
import com.example.post_registerandloginapp.Modal.RegisterData;
import com.example.post_registerandloginapp.Modal.ViewProductData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface Interface_Class {
    @FormUrlEncoded
    @POST("Register.php")
    Call<RegisterData> registerUser(@Field("Name") String name, @Field("Email") String email, @Field("Password") String password);

    @FormUrlEncoded
    @POST("login.php")
    Call<Login_Data> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("addProduct.php")
    Call<AddProductData> addProductUser(@Field("userid") int userid, @Field("pname") String pname, @Field("pprize") String pprize, @Field("pdes") String pdes, @Field("productimage") String imagedata);

    @FormUrlEncoded
    @POST("viewProduct.php")
    Call<ViewProductData> viewProductUser(@Field("userid") int userid);

    @FormUrlEncoded
    @POST("updateproduct.php")
    Call<RegisterData> updateProductUser(@Field("id") int id, @Field("name") String name, @Field("price") String prize,
                     @Field("description") String description, @Field("imagedata") String imagedata,@Field("imagename") String imagename);

    @FormUrlEncoded
    @POST("deleteproduct.php")
    Call<RegisterData> deleteProductUser(@Field("id") int id);

}

