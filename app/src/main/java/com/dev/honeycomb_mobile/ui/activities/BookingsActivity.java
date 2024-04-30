package com.dev.honeycomb_mobile.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.Bookings;
import com.dev.honeycomb_mobile.ui.adapters.BookingAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookingsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    BookingAdapter bookingAdapter;
    ArrayList<Bookings> bookingsList;
    ImageView gbck;
    TextView bc;
    TextView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        recyclerView = findViewById(R.id.bkRecycler);
        databaseReference= FirebaseDatabase.getInstance().getReference("Appointments");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookingsList= new ArrayList<>();
        bookingAdapter = new BookingAdapter(this,bookingsList);
        recyclerView.setAdapter(bookingAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    bookingsList.add(dataSnapshot.child("Booking").getValue(Bookings.class));
                }
                bookingAdapter.notifyItemInserted(bookingsList.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        gbck= findViewById(R.id.gbck);
        bc= findViewById(R.id.bcg);
        home= findViewById(R.id.hm);
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnds = new Intent(BookingsActivity.this,AppointmentsActivity.class);
                startActivity(intnds);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intinds = new Intent(BookingsActivity.this,HomeActivity.class);
                startActivity(intinds);
            }
        });
        gbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bc.setVisibility(View.VISIBLE);
                home.setVisibility(View.VISIBLE);
            }
        });

    }
}