package com.dev.honeycomb_mobile.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.honeycomb_mobile.R;
import com.dev.honeycomb_mobile.models.FormAndDosage;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrugAdapter extends RecyclerView.Adapter<DrugAdapter.MyViewHolder> {
    private Context mContext;
    private List<FormAndDosage> formAndDosages;
    private final RecyclerViewInterface recyclerViewInterface;

    public DrugAdapter(Context mContext, List<FormAndDosage> formAndDosages, RecyclerViewInterface recyclerViewInterface) {
        this.mContext = mContext;
        this.formAndDosages = formAndDosages;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public DrugAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drug_item, parent, false);
        DrugAdapter.MyViewHolder myHolder = new DrugAdapter.MyViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DrugAdapter.MyViewHolder holder, int position) {
        holder.bindDrug(formAndDosages.get(position));
    }

    @Override
    public int getItemCount() {
        return formAndDosages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.drgName)
        TextView mForm;
        @BindView(R.id.drgImg)
        ImageView mImage;
        @BindView(R.id.drgPrice) TextView mprice;
        @BindView(R.id.drgQty) TextView mqty;
        ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
        public void bindDrug(FormAndDosage formAndDosage){
            Picasso.get().load(formAndDosage.getImageUrl()).into(mImage);
            mForm.setText(formAndDosage.getForm());
            mprice.setText(formAndDosage.getStrength());
            mqty.setText(formAndDosage.getDefaultQty().toString() + " "+ "pills");
        }
    }
}