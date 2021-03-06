package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.ui.ShowBillDetailsActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HydAdapter extends RecyclerView.Adapter<HydAdapter.HydroViewHolder> {

    private ArrayList<Hydro> hydroArrayList;

    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

    public static int lastIndex = 2;

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
        holder.date.setText(String.valueOf(hydroObject.getBillDate()));
        holder.agencyName.setText(hydroObject.getAgencyName());
        holder.unitsConsumed.setText(hydroObject.getUnitsConsumed() + " Units");
        holder.amount.setText(defaultFormat.format(hydroObject.getBillTotal()));

    }



    @Override
    public int getItemCount() {
        return lastIndex+1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class HydroViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView date;
        TextView agencyName;
        TextView unitsConsumed;
        TextView amount;

        public HydroViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txtHydBillID);
            date = itemView.findViewById(R.id.txtHydBillDate);
            agencyName = itemView.findViewById(R.id.txtAgencyName);
            unitsConsumed = itemView.findViewById(R.id.txtUnits);
            amount = itemView.findViewById(R.id.txtHydBillAmount);

        }
    }

}

//
//    public static ArrayList<Hydro> removeDuplicates(ArrayList<Hydro> list)
//    {
//
//        // Create a new ArrayList
//        ArrayList<Hydro> newList = new ArrayList<Hydro>();
//
//        // Traverse through the first list
//        for (Hydro element : list) {
//
//            // If this element is not present in newList
//            // then add it
//            if (!newList.contains(element)) {
//
//                newList.add(element);
//            }
//        }
//
//        // return the new list
//        return newList;
//    }