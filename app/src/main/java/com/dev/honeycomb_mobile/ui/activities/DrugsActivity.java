package com.dev.honeycomb_mobile.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.DrugList;
import com.dev.honeycomb_mobile.models.FormAndDosage;
import com.dev.honeycomb_mobile.network.Interfaces.DrugApi;
import com.dev.honeycomb_mobile.network.clients.DrugClient;
import com.dev.honeycomb_mobile.ui.adapters.DrugAdapter;
import com.dev.honeycomb_mobile.ui.adapters.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrugsActivity extends AppCompatActivity  implements RecyclerViewInterface {
    @BindView(R.id.drugRecycler) RecyclerView mRecyclerView;
    @BindView(R.id.drugSearch)
    SearchView drugTxt;
    @BindView(R.id.number)
    TextView itmNo;
    @BindView(R.id.drugQuery)
    TextView drug;
    List<FormAndDosage> form;
    ArrayList<String> orders = new ArrayList<String>();
    FormAndDosage formAndDosage;
    String slug;

    @BindView(R.id.cart) ImageView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs);
        ButterKnife.bind(this);

        slug = "Xanax";
        drug.setText(slug);
        DrugApi client = DrugClient.getClient();
        initRecycler();
        Call<DrugList> call = client.getInfo(slug);

        call.enqueue(new Callback<DrugList>(){

            @Override
            public void onResponse(@NonNull Call<DrugList> call,  Response<DrugList> response) {
                if(response.isSuccessful()){
                    if (response!= null) {
                        Log.e("TAG", call.request().url().toString());
                        Log.e("TAG", "res" + response.body().toString());
                        form = response.body().getData().getBrand().getFormAndDosages();
                        init();

                    }else
                        Toast.makeText(DrugsActivity.this, "No such drug", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getBaseContext(), "Drug does not exist", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<DrugList> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });

        drugTxt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                slug = query;
                drug.setText(slug);
                Call<DrugList> call = client.getInfo(slug);
                call.enqueue(new Callback<DrugList>(){

                    @Override
                    public void onResponse(@NonNull Call<DrugList> call,  Response<DrugList> response) {
                        if(response.isSuccessful()){
                            if (response!= null) {
                                Log.e("TAG", call.request().url().toString());
                                Log.e("TAG", "res" + response.body().toString());
                                form = response.body().getData().getBrand().getFormAndDosages();
                                init();

                            }else
                                Toast.makeText(DrugsActivity.this, "No such drug", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getBaseContext(), "Drug does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<DrugList> call, Throwable t) {
                        Toast.makeText(getBaseContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ints = new Intent(DrugsActivity.this, CheckoutActivity.class);
                Log.e("TAG", "List: "+orders );
                ints.putExtra("details",orders);
                startActivity(ints);
            }
        });

    }

    private void initRecycler() {
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(DrugsActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);;
    }
    private void init(){
        DrugAdapter drugAdapter = new DrugAdapter(mRecyclerView.getContext(), form, this);
        mRecyclerView.setAdapter(drugAdapter);
    }

    @Override
    public void onItemClick(int position) {
        int amt= Integer.parseInt(itmNo.getText().toString());
        String amount = String.valueOf((amt +1));
        itmNo.setText(amount);
        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
        String strn = drug.getText().toString() + " " + form.get(position).getStrength();
        orders.add(strn);
        Log.e("TAG", "onItemClick: "+ orders );
        Log.e("TAG", "onItem: "+ strn );
        Log.e("TAG", "onItemPos: "+ form.get(position) );
    }
}