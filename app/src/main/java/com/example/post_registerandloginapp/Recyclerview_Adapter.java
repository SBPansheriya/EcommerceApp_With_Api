package com.example.post_registerandloginapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.post_registerandloginapp.fragment.TopCategories_Fragment;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.RecyclerviewHolder> {

    TopCategories_Fragment topCategories_fragment;
    String[] gridcategory;
    int[] image;
    public Recyclerview_Adapter(TopCategories_Fragment topCategories_fragment, String[] gridcategory, int[] image) {
        this.topCategories_fragment = topCategories_fragment;
        this.gridcategory = gridcategory;
        this.image = image;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        Recyclerview_Adapter.RecyclerviewHolder holder = new RecyclerviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.RecyclerviewHolder holder, int position) {
        holder.imageView.setImageResource(image[position]);
        holder.textView.setText(gridcategory[position]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.gridimage);
            textView=itemView.findViewById(R.id.gridtext);
        }
    }
}