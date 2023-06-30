package com.example.post_registerandloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.post_registerandloginapp.Modals.LoginData;
import com.example.post_registerandloginapp.Modals.RegisterData;

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

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InstanceClass.CallApi().registerUser(name.getText().toString(),email.getText().toString(),password.getText().toString()).enqueue(new Callback<RegisterData>() {
                    @Override
                    public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {

                        if (response.body().getResult() == 1) {
                            if (response.body().getResult() == 1) {
                                Log.d("TTT", "onResponse: " + response.body().getConnection());
                                Toast.makeText(MainActivity.this, "Register Sucessfuly", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.d("TTT", "onResponse: "+response.body().getConnection());
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                        }
                    }
                    @Override
                    public void onFailure(Call<RegisterData> call, Throwable t) {
                        Log.e("TTT", "onFailure: "+t.getLocalizedMessage());
                    }
                });
            }
        });

        InstanceClass.CallApi().loginUser(email.getText().toString(),password.getText().toString()).enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {

                if (response.body().getResult() == 1) {
                    if (response.body().getResult() == 1) {
                        Log.d("TTT", "onResponse: " + response.body().getConnection());
                        Toast.makeText(MainActivity.this, "Register Sucessfuly", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d("TTT", "onResponse: "+response.body().getConnection());
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                Log.e("TTT", "onFailure: "+t.getLocalizedMessage());
            }
        });

    }
}