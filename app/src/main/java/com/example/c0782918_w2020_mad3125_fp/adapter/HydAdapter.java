package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;

import java.text.NumberFormat;
import java.util.ArrayList;

public class HydAdapter extends RecyclerView.Adapter<HydAdapter.HydroViewHolder> {

    private ArrayList<Hydro> hydroArrayList;
    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

    public HydAdapter(ArrayList<Hydro> hydroArrayList) {
        this.hydroArrayList = hydroArrayList;
    }

    @NonNull
    @Override
    public HydAdapter.HydroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hydro,
                parent,
                false);
        HydroViewHolder myHydroViewHolder = new HydroViewHolder(mView);

        return myHydroViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HydAdapter.HydroViewHolder holder, int position) {
        Hydro hydroObject = this.hydroArrayList.get(position);
        holder.id.setText(hydroObject.getBillID());
        holder.agencyName.setText(hydroObject.getAgencyName());
        holder.unitsConsumed.setText(hydroObject.getUnitsConsumed() + " Units");



    }



    @Override
    public int getItemCount() {
        return hydroArrayList.size();
    }


    public class HydroViewHolder extends RecyclerView.ViewHolder{

        TextView id;

        TextView agencyName;
        TextView unitsConsumed;

        public HydroViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txtHydBillID);

            agencyName = itemView.findViewById(R.id.txtAgencyName);
            unitsConsumed = itemView.findViewById(R.id.txtUnits);

        }
    }
}

