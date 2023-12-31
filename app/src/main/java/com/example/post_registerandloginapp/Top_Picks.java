package com.example.post_registerandloginapp;

import static com.example.post_registerandloginapp.Splash_Image.sharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.post_registerandloginapp.Modal.ViewProductData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Top_Picks extends AppCompatActivity {

    View_Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_picks);
        recyclerView = findViewById(R.id.productrecyclerview);

        InstanceClass.CallApi().viewProductUser(sharedPreferences.getInt("uid",0)).enqueue(new Callback<ViewProductData>() {
            @Override
            public void onResponse(Call<ViewProductData> call, Response<ViewProductData> response) {
                if(response.body().getConnection() == 1 && response.body().getResult()==1){
                    adapter = new View_Adapter(Top_Picks.this,response.body().getProductdata());
                    LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                    manager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                    Log.d("TTTT", "onResponse: "+response.body().getConnection());
                }
                else {
                    Log.d("TTTT", "onResponse: Connection Failed");
                }
            }

            @Override
            public void onFailure(Call<ViewProductData> call, Throwable t) {
                Log.e("TTTT", "onFailure: "+t.getLocalizedMessage() );
            }
        });
    }
}