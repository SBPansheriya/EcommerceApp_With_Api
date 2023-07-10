package com.example.post_registerandloginapp;

import static com.example.post_registerandloginapp.Splash_Image.editor;
import static com.example.post_registerandloginapp.Splash_Image.sharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.post_registerandloginapp.Modal.AddProductData;
import com.example.post_registerandloginapp.databinding.ActivityAddProductClassBinding;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_Product_Class extends AppCompatActivity {

    ActivityAddProductClassBinding binding;
//    ImageView addimage;
    Button submitproduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductClassBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
//        addimage = findViewById(R.id.addimage);
//        submitproduct = findViewById(R.id.submitproduct);

        binding.addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ZZZ", "onClick: 1234");
//                CropImage.activity()
//                        .setGuidelines(CropImageView.Guidelines.ON)
//                        .start(Add_Product_Class.this);
                pickFromGallery();
            }
        });


        binding.submitproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable) binding.addimage.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, baos);
                byte[] byteArray = baos.toByteArray();

                String imagedata = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    imagedata = Base64.getEncoder().encodeToString(byteArray);
                }

                InstanceClass.CallApi().addProductUser(sharedPreferences.getInt("uid",0),binding.productname.getText().toString(),binding.productprice.getText(),binding.discription.getText().toString(),imagedata).enqueue(new Callback<AddProductData>() {
                    @Override
                    public void onResponse(Call<AddProductData> call, Response<AddProductData> response) {
                        if (response.body().getConnection() == 1) {
                            if (response.body().getProductaddd() == 1) {
                                Intent intent = new Intent(Add_Product_Class.this, Top_Picks.class);
                                startActivity(intent);
                                Toast.makeText(Add_Product_Class.this, "Item Added Successfully", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Add_Product_Class.this, "Item Not Added", Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(Add_Product_Class.this, "Somthing Went Wrong", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<AddProductData> call, Throwable t) {
                        Log.e("TTT", "onFailure: "+t.getLocalizedMessage() );
                    }
                });
            }
        });
    }

    private void pickFromGallery() {
//        CropImage.activity().start(Add_Product_Class.this);
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                binding.addimage.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}