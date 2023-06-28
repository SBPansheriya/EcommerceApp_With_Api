package com.example.post_registerandloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText name,email,password;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin);

            InstanceClass.CallApi().registerUser("Deep","Deep@gmail.com","Deep@123").enqueue(new Callback<Modal_Class>() {
            @Override
            public void onResponse(Call<Modal_Class> call, Response<Modal_Class> response) {
                Log.d("TTT", "onResponse: "+response.body().getConnection());
            }

            @Override
            public void onFailure(Call<Modal_Class> call, Throwable t) {
                Log.d("TTT", "onFailure: "+t.getLocalizedMessage());
            }
        });
    }
}