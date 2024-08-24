package com.dev.honeycomb_mobile.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.Constants;
import com.dev.honeycomb_mobile.models.Doctor;
import com.dev.honeycomb_mobile.models.DoctorDto;
import com.dev.honeycomb_mobile.network.clients.DoctorClient;
import com.dev.honeycomb_mobile.network.interfaces.DoctorApi;
import com.dev.honeycomb_mobile.network.interfaces.RecyclerViewInterface;
import com.dev.honeycomb_mobile.ui.adapters.DoctorsRecyclerAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements RecyclerViewInterface  {
    RecyclerView recyclerView;
    RecyclerViewInterface recyclerViewInterface;
    DoctorsRecyclerAdapter doctorsRecyclerAdapter;
    List<Doctor> doctorList = new ArrayList<>();
    Doctor doctor;
    DoctorApi client = DoctorClient.getClient();
    DoctorClient doctorClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuOrders:
                        Intent intent = new Intent(HomeActivity.this, MedicineActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.menuNotifications:
                        Intent intents = new Intent(HomeActivity.this, BookingsActivity.class);
                        startActivity(intents);
                        break;
                    case R.id.menuHome:
                        Intent intens = new Intent(HomeActivity.this, HomeActivity.class);
                        startActivity(intens);

                        break;
                    case R.id.menuProfile:
                        Intent inte = new Intent(HomeActivity.this, Onboarding3Activity.class);
                        startActivity(inte);
                        break;
                    case R.id.menuLogout:
                        startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                        Toast.makeText(HomeActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        recyclerView = findViewById(R.id.doctorsRecycler);
        initRecycler();
        Call<List<Doctor>> call = client.getResults();
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>>  call, Response<List<Doctor>> response) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    doctorList= response.body().stream().collect(Collectors.toList());
//                }
                doctorList = Constants.dummyDoctors;
                init(doctorList);
                Log.d("Doctors", " " + doctorList);
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Something went wrong. Please check your Internet connection and try again later",
                        Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }
    private  void initRecycler(){
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
    }
    public void init(List<Doctor> doctorList){
        doctorsRecyclerAdapter = new DoctorsRecyclerAdapter(this, HomeActivity.this, Constants.dummyDoctors);
        recyclerView.setAdapter(doctorsRecyclerAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DoctorDetailActivity.class);
        Log.v("wiiiiiiiiiiiiiiiiiiii",String.valueOf(doctorList));
        intent.putExtra("details",doctorList.get(position));
        startActivity(intent);
    }
}