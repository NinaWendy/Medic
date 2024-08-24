package com.dev.honeycomb_mobile.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.Doctor;
import com.dev.honeycomb_mobile.models.DoctorDto;
import com.dev.honeycomb_mobile.network.interfaces.RecyclerViewInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DoctorsRecyclerAdapter extends RecyclerView.Adapter<DoctorsRecyclerAdapter.ViewHolder>  {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    List<Doctor> doctorsList;

    public DoctorsRecyclerAdapter(RecyclerViewInterface recyclerViewInterface, Context context, List<Doctor> doctorsList) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
        this.doctorsList = doctorsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.doctorName.setText("Dr."+ " "+ doctorsList.get(position).getFirstName()+ " "+ doctorsList.get(position).getLastName());
        holder.practice.setText(doctorsList.get(position).getSpecialization());
        holder.rating.setText(doctorsList.get(position).getRating().toString());
        Picasso.get().load(doctorsList.get(position).getImage()).into(holder.profile);
    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView doctorName;
        TextView practice;
        TextView rating;
        TextView hours;
        ImageView profile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorName = itemView.findViewById(R.id.drName);
            practice = itemView.findViewById(R.id.practice);
            rating = itemView.findViewById(R.id.rating);
            hours = itemView.findViewById(R.id.hours);
            profile= itemView.findViewById(R.id.doctorImg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            Log.v("hapaaaaaaaaaaaaaa",String.valueOf(pos));
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
