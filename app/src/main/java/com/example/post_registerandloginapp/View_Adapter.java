package com.example.post_registerandloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.post_registerandloginapp.Modal.Productdatum;
import com.example.post_registerandloginapp.Modal.RegisterData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class View_Adapter extends RecyclerView.Adapter<View_Adapter.view_holder> {

    Context context;
    List<Productdatum> productdata;


    public View_Adapter(Context context, List<Productdatum> productdata) {
        this.context = context;
        this.productdata = productdata;
    }

    @NonNull
    @Override
    public View_Adapter.view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_view_item, parent, false);
        view_holder holder = new view_holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, @SuppressLint("RecyclerView") int position) {
        holder.pname.setText("Name : " +"" + productdata.get(position).getProName());
        holder.pprise.setText("Price : " +"" + productdata.get(position).getProPrice());
        holder.pdes.setText("Des. : " +"" + productdata.get(position).getProDes());

//        Glide.with(context)
//                .load("https://shreyecommerce.000webhostapp.com/MySite/"+productdata.get(position).getProImage())
//                .centerCrop()
//                .into(holder.imageView);

        Glide.with(context.getApplicationContext())
                .load("https://shreyecommerce.000webhostapp.com/MySite/"+productdata.get(position).getProImage())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(holder.imageView);
        Log.d("KKK", "onBindViewHolder: " + productdata.get(position).getProImage());

//        Picasso.with(context)
//                .load("https://shreyecommerce.000webhostapp.com/MySite/"+productdata.get(position).getProImage())
//                .networkPolicy(NetworkPolicy.NO_CACHE)
//                .memoryPolicy(MemoryPolicy.NO_CACHE)
////                .placeholder(R.drawable.placeholder)
//                .into(holder.imageView);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, PaymentActivity.class);
                intent.putExtra("name",productdata.get(position).getProName());
                intent.putExtra("price",productdata.get(position).getProPrice());
                context.startActivity(intent);
                return true;
            }
        });

        holder.morevert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.update) {
                            Intent intent = new Intent(context, Add_Product_Class.class);
                            intent.putExtra("button", "update");
                            Splash_Image.editor.putString("id", productdata.get(position).getId());
                            Splash_Image.editor.commit();
                            intent.putExtra("name", productdata.get(position).getProName());
                            intent.putExtra("price", productdata.get(position).getProPrice());
                            intent.putExtra("des", productdata.get(position).getProDes());
                            intent.putExtra("image", productdata.get(position).getProImage());
                            context.startActivity(intent);
                        }
                        if (item.getItemId() == R.id.delete) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setTitle("DELETE...");
                            builder.setMessage("Are You Sure?");
                            builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    InstanceClass.CallApi().deleteProductUser(Integer.valueOf(productdata.get(position).getId())).enqueue(new Callback<RegisterData>() {
                                        @Override
                                        public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {
                                            if (response.body().getConnection() == 1) {
                                                if (response.body().getResult() == 1) {
                                                    Log.d("JJJ", "onResponse: Delete");
                                                    Toast.makeText(context, "Product Deleted", Toast.LENGTH_LONG).show();
                                                    productdata.remove(position);
                                                    notifyDataSetChanged();
                                                    notifyDataSetChanged();
                                                } else {
                                                    Toast.makeText(context, "Product Not Deleted", Toast.LENGTH_LONG).show();
                                                }
                                            } else {
                                                Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_LONG).show();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<RegisterData> call, Throwable t) {
                                            Log.e("JJJ", "onFailure: " + t.getLocalizedMessage());
                                        }
                                    });
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productdata.size();
    }

    public class view_holder extends RecyclerView.ViewHolder {
        ImageView imageView, morevert;
        TextView pname, pprise, pdes;

        public view_holder(@NonNull View itemView) {
            super(itemView);
            morevert = itemView.findViewById(R.id.moreverts);
            imageView = itemView.findViewById(R.id.viwe_image);
            pname = itemView.findViewById(R.id.pname1);
            pprise = itemView.findViewById(R.id.pprice1);
            pdes = itemView.findViewById(R.id.pdes1);
        }
    }
}