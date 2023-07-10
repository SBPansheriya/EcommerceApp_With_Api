package com.example.post_registerandloginapp;

import static com.example.post_registerandloginapp.Splash_Image.editor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.post_registerandloginapp.Modal.Login_Data;
import com.example.post_registerandloginapp.databinding.LoginPageBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn_Page extends AppCompatActivity {

    LoginPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InstanceClass.CallApi().loginUser(binding.email.getText().toString(), binding.password.getText().toString()).enqueue(new Callback<Login_Data>() {
                    @Override
                    public void onResponse(Call<Login_Data> call, Response<Login_Data> response) {
                        if (response.body().getConnection() == 1) {
                            if (response.body().getResult() == 1) {
                                Intent intent = new Intent(LogIn_Page.this, MainActivity.class);
                                editor.putInt("login",1);
                                editor.putInt("uid", Integer.parseInt(response.body().getUserdata().getId()));
                                editor.putString("name",response.body().getUserdata().getName());
                                editor.putString("email",response.body().getUserdata().getEmail());
                                editor.commit();
                                startActivity(intent);
                                Log.d("TTT", "onResponse: " + response.body().getConnection());
                                Toast.makeText(LogIn_Page.this, "Logging Sucessfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(LogIn_Page.this, SignIn_Page.class);
                                startActivity(intent);
                                Toast.makeText(LogIn_Page.this, "Logging Failed", Toast.LENGTH_SHORT).show();
                                Log.d("TTT", "onResponse: " + response.body().getConnection());
                            }
                        } else {
                            Toast.makeText(LogIn_Page.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Login_Data> call, Throwable t) {
                        Log.e("TTT", "onFailure: "+t.getLocalizedMessage() );
                    }
                });
            }
        });
    }
}
