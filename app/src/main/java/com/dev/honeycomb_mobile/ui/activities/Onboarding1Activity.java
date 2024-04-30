package com.dev.honeycomb_mobile.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.dev.honeycomb_mobile.R;

public class Onboarding1Activity extends AppCompatActivity {


        TextView skip;
        TextView next;
        Handler h = new Handler();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_onboarding1);
            skip = findViewById(R.id.skp);
            next= findViewById(R.id.nxt);
            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Onboarding1Activity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });

            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Onboarding1Activity.this, Onboarding2Activity.class);
                    startActivity(intent);
                    finish();
                }
            },2500);

        }
    }
