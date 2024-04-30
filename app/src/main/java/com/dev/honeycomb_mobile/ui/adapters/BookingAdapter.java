package com.dev.honeycomb_mobile.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.Bookings;

import java.util.ArrayList;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyHolder>{
    Context context;
    ArrayList<Bookings> bookingList;

    public BookingAdapter(Context context, ArrayList<Bookings> bookingList) {
        this.context = context;
        this.bookingList = bookingList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.booked_item,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.date.setText(bookingList.get(position).getDate());
        holder.time.setText(bookingList.get(position).getTime());
        holder.doctor.setText(bookingList.get(position).getDoctor());
        holder.hospital.setText(bookingList.get(position).getHospital());
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView time;
        TextView doctor;
        TextView hospital;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.dateBkd);
            time = itemView.findViewById(R.id.timeBkd);
            doctor = itemView.findViewById(R.id.drBooked);
            hospital = itemView.findViewById(R.id.hospBkd);
        }
    }

}
