package com.dev.honeycomb_mobile.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.Doctor;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorDetailActivity extends AppCompatActivity {
    ImageView back;
    @BindView(R.id.dr)
    TextView drName;
    @BindView(R.id.prc)
    TextView drPrc;
    @BindView(R.id.rate)
    TextView drRate;
    @BindView(R.id.abt)
    TextView drAbout;
    @BindView(R.id.hosp)
    TextView drHosp;
    @BindView(R.id.exp)
    TextView drExp;
    @BindView(R.id.appointment)
    Button appoint;
    @BindView(R.id.drAp)
    ImageView drProf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        ButterKnife.bind(this);
        Intent intend = getIntent();
        Doctor doctor = (Doctor) intend.getSerializableExtra("details");
        drName.setText(String.format("Dr. %s %s", doctor.getFirstName(), doctor.getLastName()));
        drRate.setText(doctor.getRating().toString());
        drPrc.setText(doctor.getSpecialization());
        drAbout.setText(doctor.getAbout());
        drExp.setText(String.format("%s years", doctor.getExperience().toString()));
        drHosp.setText(doctor.getHospital());
        Picasso.get().load(doctor.getImage()).into(drProf);
        appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DoctorDetailActivity.this,AppointmentsActivity.class );
                in.putExtra("data",doctor);
                startActivity(in);
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorDetailActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}