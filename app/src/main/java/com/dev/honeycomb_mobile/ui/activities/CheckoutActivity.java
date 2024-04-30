package com.dev.honeycomb_mobile.ui.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.ui.fragments.AddressDialog;
import com.dev.honeycomb_mobile.ui.fragments.AddressDialog.AddressDialogListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckoutActivity extends AppCompatActivity implements AddressDialogListener {

    private Button checkout;
    Dialog dialog;
    CardView cash;
    CardView card;
    CardView paypal;
    CardView mpesa;
    String deliveryAdd;
    ListView listView;
    TextView shippingAmount;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        checkout = findViewById(R.id.chkButton);
        cash = findViewById(R.id.cash);
        paypal = findViewById(R.id.paypal);
        mpesa = findViewById(R.id.mpesa);
        card = findViewById(R.id.credit);

        Intent intent = getIntent();
        ArrayList<String> fd = (ArrayList<String>) intent.getSerializableExtra("details");
        Log.e("TAG","Array"+fd);
        listView= findViewById(R.id.list);
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(fd);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);


        cash.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                cash.setCardBackgroundColor(getColor(R.color.teal_700));
                openDialog();
            }
        });
        mpesa.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                mpesa.setCardBackgroundColor(getColor(R.color.teal_700));
                cash.setCardBackgroundColor(getColor(R.color.white));
                Intent intendss = new Intent(CheckoutActivity.this, PaymentActivity.class);
                startActivity(intendss);
            }
        });
        paypal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                paypal.setCardBackgroundColor(getColor(R.color.teal_700));
            }
        });
        card.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                card.setCardBackgroundColor(getColor(R.color.teal_700));
            }
        });

        dialog = new Dialog(CheckoutActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dailog_background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        Button ok = dialog.findViewById(R.id.btn_okay);
        Button cancel = dialog.findViewById(R.id.btn_cancel);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckoutActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        shippingAmount = findViewById(R.id.shippingAmt);
        total = findViewById(R.id.total);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                Toast.makeText(CheckoutActivity.this, "Delivery Address:"+ " " +deliveryAdd, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openDialog() {
        AddressDialog addressDialog = new AddressDialog();
        addressDialog.show(getSupportFragmentManager(),"address dialog");
    }

    @Override
    public void applyText(String address) {
        deliveryAdd= address;
        String amount = "Ksh.0.00";
        if (Objects.equals(address, "Nairobi")){
            amount= "100";
        }else if (Objects.equals(address, "Kisumu")){
            amount = "500";
        }else if (Objects.equals(deliveryAdd, "Kiambu")){
            amount = "150";
        }
        shippingAmount.setText(amount);
        int t= Integer.parseInt(shippingAmount.getText().toString());
        String ant = String.valueOf((t +400));
        total.setText("Ksh." + ant);
    }
}