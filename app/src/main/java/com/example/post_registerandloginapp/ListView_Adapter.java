package com.example.post_registerandloginapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListView_Adapter extends BaseAdapter {

    Categories_Class categories_class;
    String[] listcategory;
    public ListView_Adapter(Categories_Class categories_class, String[] listcategory) {
        this.categories_class = categories_class;
        this.listcategory = listcategory;
    }

    @Override
    public int getCount() {
        return listcategory.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(categories_class).inflate(R.layout.listview_item,parent,false);
        TextView textView = convertView.findViewById(R.id.listtext);
        textView.setText(listcategory[position]);
        return convertView;
    }
}