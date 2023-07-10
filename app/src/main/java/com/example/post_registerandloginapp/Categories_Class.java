package com.example.post_registerandloginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.example.post_registerandloginapp.fragment.Fragment_Adapter;
import com.example.post_registerandloginapp.fragment.Men_Fragment;
import com.example.post_registerandloginapp.fragment.TopCategories_Fragment;
import com.example.post_registerandloginapp.fragment.Women_Fragment;
import com.google.android.material.tabs.TabLayout;

public class Categories_Class extends AppCompatActivity {

    Fragment_Adapter adapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    GridView gridView;
    ListView listView;
    Recyclerview_Adapter gridViewAdapter;
    ListView_Adapter listViewAdapter;
    String listcategory[] = {"Top Categories","Women","Men"};
    String gridcategory[] = {"Kurtas","Sarees","Polos & Tees","Ethnic Gowns","Headphones & Headsets","Casual Shirts","Smart Watches",
    "Lenhenga Choils","Kitchen Strorage","Dresses","Jeans & Jeggings","Jeans","Track Pants","Nightwear","Sports Shoes & Sneakers"};
    int image[] = {R.drawable.kurtas,R.drawable.sarees,R.drawable.polos_tees,R.drawable.ethnic_gowns,R.drawable.headphones,R.drawable.casual_shirts,R.drawable.smart_watches,
            R.drawable.lenhenga_choils,R.drawable.kitchen_strorage,R.drawable.dresses,R.drawable.jeans_jeggings,R.drawable.jeans,R.drawable.track_pants,R.drawable.nightwear,R.drawable.sports_shoes_sneakers};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_class);
//        listView = findViewById(R.id.listview);
//        gridView = findViewById(R.id.gridview);
//        listViewAdapter = new ListView_Adapter(Categories_Class.this,listcategory);
//        listView.setAdapter(listViewAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

        adapter = new Fragment_Adapter(getSupportFragmentManager());
        adapter.addFragment(new TopCategories_Fragment(),"Top Categories");
        adapter.addFragment(new Women_Fragment(),"Women");
        adapter.addFragment(new Men_Fragment(),"Men");

        viewPager=findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}