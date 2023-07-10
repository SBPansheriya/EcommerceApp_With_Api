package com.example.post_registerandloginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.post_registerandloginapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    View_Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        Log.d("VVV", "onCreate: id"+sharedPreferences.getInt("uid",4));
//        InstanceClass.CallApi().viewProductUser(sharedPreferences.getInt("uid",4)).enqueue(new Callback<ViewProductData>() {
//            @Override
//            public void onResponse(Call<ViewProductData> call, Response<ViewProductData> response) {
//                if(response.body().getConnection()==1){
//                    if(response.body().getResult()==1){
//                        Log.d("TTTT", "onResponse: product data  = "+response.body().getProductdata());
//                    }else {
//                        Log.d("TTTT", "onResponse: responce result not ");
//                    }
//                }else
//                {
//                    Log.d("TTTT", "onResponse: connection error");
//                }
//            }
//            @Override
//            public void onFailure(Call<ViewProductData> call, Throwable t) {
//                Log.e("TTTT", "onFailure: "+t.getLocalizedMessage() );
//            }
//        });

        binding.toppickes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(MainActivity.this, Top_Picks.class);
                startActivity(intent);
            }
        });

        binding.categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(MainActivity.this,Categories_Class.class);
                startActivity(intent);
            }
        });

        binding.myaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyAccount_Class.class);
                startActivity(intent);
            }
        });

        binding.addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Add_Product_Class.class);
                startActivity(intent);
            }
        });
    }
}





//        Toolbar toolbar = binding.appAndTool.toolbar;
//        setSupportActionBar(toolbar);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,binding.drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
//        binding.drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        View headerView = binding.navView.getHeaderView(0);
//        profileImage=headerView.findViewById(R.id.imageView1);
//        profileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("RRR", "onClick: image view Clicked");
//                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(takePicture, CAMERA_REQUEST);
//            }
//        });

//        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if(item.getItemId() == R.id.imageView1){
//                    System.out.println("1234");
//                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(takePicture, CAMERA_REQUEST);
//                }
//                return true;
//            }
//        });
//        loadImageFromStorage(imagepath,imageView);