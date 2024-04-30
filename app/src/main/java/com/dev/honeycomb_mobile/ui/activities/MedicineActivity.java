package com.dev.honeycomb_mobile.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.ui.adapters.CategoryRecyclerAdapter;

import com.dev.honeycomb_mobile.models.Category;

import java.util.ArrayList;

public class MedicineActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Category> catList;
    private CategoryRecyclerAdapter adapter;
    TextView shop;
    Button order;
    ImageView pharm1;
    private int[] myImageList = new int[]{R.drawable.consult, R.drawable.medicine,R.drawable.tst, R.drawable.ref,R.drawable.hh};
    private String[] myImageNameList = new String[]{"Consultation","Medicines" ,"Lab Tests","Refill","Other"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);

        catList = setCategory();
        adapter = new CategoryRecyclerAdapter(this, catList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        shop = findViewById(R.id.shp);
        order = findViewById(R.id.ordButton);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicineActivity.this, DrugsActivity.class);
                startActivity(intent);
            }
        });
        pharm1 = findViewById(R.id.pharm1);
        pharm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates an implicit Intent that will load a map to search for pharmacy nearby
                Uri gmmIntentUri = Uri.parse("geo:-1.286389,36.817223?q=farmasipharmacy");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

    private ArrayList<Category> setCategory() {
        ArrayList<Category> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Category category = new Category();
            category.setName(myImageNameList[i]);
            category.setImage_drawable(myImageList[i]);
            list.add(category);
        }

        return list;
    }
}