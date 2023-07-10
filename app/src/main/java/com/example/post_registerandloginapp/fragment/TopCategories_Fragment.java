package com.example.post_registerandloginapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.post_registerandloginapp.Recyclerview_Adapter;
import com.example.post_registerandloginapp.R;

public class TopCategories_Fragment extends Fragment {
    RecyclerView recyclerView;
    Recyclerview_Adapter recyclerview_adapter;
    String gridcategory[] = {"Kurtas","Sarees","Polos & Tees","Ethnic Gowns","Headphones & Headsets","Casual Shirts","Smart Watches",
            "Lenhenga Choils","Kitchen Strorage","Dresses","Jeans & Jeggings","Jeans","Track Pants","Nightwear","Sports Shoes & Sneakers"};
    int image[] = {R.drawable.kurtas,R.drawable.sarees,R.drawable.polos_tees,R.drawable.ethnic_gowns,R.drawable.headphones,R.drawable.casual_shirts,R.drawable.smart_watches,
            R.drawable.lenhenga_choils,R.drawable.kitchen_strorage,R.drawable.dresses,R.drawable.jeans_jeggings,
            R.drawable.jeans,R.drawable.track_pants,R.drawable.nightwear,R.drawable.sports_shoes_sneakers};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_topcategories,container,false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerview_adapter = new Recyclerview_Adapter(TopCategories_Fragment.this,gridcategory,image);
//        int numofcolums = 3;
        GridLayoutManager manager = new GridLayoutManager(getContext(),3);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(recyclerview_adapter);
        return view;
    }
}