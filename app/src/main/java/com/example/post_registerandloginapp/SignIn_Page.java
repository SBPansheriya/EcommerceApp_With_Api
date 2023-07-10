package com.example.post_registerandloginapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.post_registerandloginapp.Modal.RegisterData;
import com.example.post_registerandloginapp.databinding.SigninPageBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn_Page extends AppCompatActivity {
        SigninPageBinding binding;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = SigninPageBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);

            binding.signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InstanceClass.CallApi().registerUser(binding.name.getText().toString(),binding.email1.getText().toString(),binding.password1.getText().toString()).enqueue(new Callback<RegisterData>() {
                        @Override
                        public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {

                            if (response.body().getConnection() == 1) {
                                if (response.body().getResult() == 1) {
                                    Intent intent = new Intent(SignIn_Page.this, MainActivity.class);
                                    startActivity(intent);
                                    Log.d("TTT", "onResponse: " + response.body().getConnection());
                                    Toast.makeText(SignIn_Page.this, "Register Sucessfuly", Toast.LENGTH_SHORT).show();
                                } else {
                                    Log.d("TTT", "onResponse: "+response.body().getConnection());
                                    Toast.makeText(SignIn_Page.this, "Register Failed", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(SignIn_Page.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<RegisterData> call, Throwable t) {
                            Log.e("TTT", "onFailure: "+t.getLocalizedMessage());
                        }
                    });
                }
            });
        }
}
