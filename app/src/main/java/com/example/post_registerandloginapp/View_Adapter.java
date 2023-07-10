package com.example.post_registerandloginapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.post_registerandloginapp.Modal.Productdatum;

import java.util.List;

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
        View view = LayoutInflater.from(context).inflate(R.layout.activity_view_item,parent,false);
        view_holder holder = new view_holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Adapter.view_holder holder, int position) {
        holder.pname.setText(""+productdata.get(position).getProName());
        holder.pprise.setText(""+productdata.get(position).getProPrice());
        holder.pdes.setText(""+productdata.get(position).getProDes());

        Glide.with(context)
                .load("https://shreyecommerce.000webhostapp.com/MySite/"+productdata.get(position).getProImage())
                .centerCrop()
                .into(holder.imageView);

        holder.morevert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.update){

                        }
                        if(item.getItemId()==R.id.delete){

                        }
                        return true;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return productdata.size();
    }

    public class view_holder extends RecyclerView.ViewHolder {
        ImageView imageView,morevert;
        TextView pname,pprise,pdes;
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