package com.dev.honeycomb_mobile.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.dev.honeycomb_mobile.R;

public class Onboarding2Activity extends AppCompatActivity {

    Handler h = new Handler();
    TextView skip;
    TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Onboarding2Activity.this, Onboarding3Activity.class);
                startActivity(intent);
                finish();
            }
        },2500);
        skip = findViewById(R.id.skp);
        next= findViewById(R.id.nxt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboarding2Activity.this, Onboarding3Activity.class);
                startActivity(intent);
            }
        });
    }
}