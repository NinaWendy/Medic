package com.dev.honeycomb_mobile.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.Bookings;
import com.dev.honeycomb_mobile.models.Doctor;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppointmentsActivity extends AppCompatActivity {
    private CalendarView mCalendarView;
    private Button appointmentTime;
    private Button appointmentTime2;
    private Button appointmentTime3;
    private Button appointmentTime4;
    private Button appointmentTime5;
    private Button booking;
    String date;
    String time;
    TextView drHosp;
    @BindView(R.id.drAPName)
    TextView drName;
    @BindView(R.id.drApPrac)
    TextView doctorPrac;
    @BindView(R.id.drRatings)
    TextView doctorRatings;
    @BindView(R.id.drAp)
    ImageView drProf;
    @BindView(R.id.bcc)
    ImageView bcck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        ButterKnife.bind(this);
        mCalendarView = findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth+"/"+ (month+1) + "/"+year;
                Log.e("TAG", "onSelectedDayChange: "+ date);
            }
        });
        Intent intends = getIntent();
        Doctor doctor = (Doctor) intends.getSerializableExtra("data");
        drName.setText(String.format("Dr. %s %s", doctor.getFirstName(), doctor.getLastName()));
        doctorRatings.setText(doctor.getRating().toString());
        doctorPrac.setText(doctor.getSpecialization());
        Picasso.get().load(doctor.getImage()).into(drProf);
        bcck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intens = new Intent(AppointmentsActivity.this, DoctorDetailActivity.class);
                startActivity(intens);
            }
        });
        appointmentTime = findViewById(R.id.am10);
        appointmentTime2 = findViewById(R.id.am11);
        appointmentTime3 = findViewById(R.id.am1);
        appointmentTime4 = findViewById(R.id.am2);
        appointmentTime5 = findViewById(R.id.am3);


        appointmentTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appointmentTime.setBackgroundColor(Color.parseColor("#21D0B2"));
                time = (String) appointmentTime.getText();
                Log.e("TAG", "Time"+time);
            }
        });
        appointmentTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appointmentTime2.setBackgroundColor(Color.parseColor("#21D0B2"));
                time = (String) appointmentTime2.getText();
                Log.e("TAG", "Time"+time);
            }
        });
        appointmentTime3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appointmentTime3.setBackgroundColor(Color.parseColor("#21D0B2"));
                time = (String) appointmentTime3.getText();
                Log.e("TAG", "Time"+time);
            }
        });
        appointmentTime4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appointmentTime4.setBackgroundColor(Color.parseColor("#21D0B2"));
                time = (String) appointmentTime4.getText();
                Log.e("TAG", "Time"+time);
            }
        });
        appointmentTime5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appointmentTime5.setBackgroundColor(Color.parseColor("#21D0B2"));
                time = (String) appointmentTime5.getText();
                Log.e("TAG", "Time"+time);
            }
        });
        booking = findViewById(R.id.book);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AppointmentsActivity.this, "Booked Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AppointmentsActivity.this, BookingsActivity.class);
                intent.putExtra("dateBooked",date);
                intent.putExtra("timeBooked",time);
                Bookings bookings = new Bookings(date,time,"Dr." +" "+ doctor.getFirstName()+ " "+ doctor.getLastName(), doctor.getHospital());
                FirebaseDatabase.getInstance().getReference("Appointments").push().child("Booking").setValue(bookings);
                startActivity(intent);
            }
        });
    }

}