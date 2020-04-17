package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ItemHydroBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;

import java.util.ArrayList;

public class HydroAdapter extends RecyclerView.Adapter<HydroAdapter.HydroViewHolder> {

    private ArrayList<Hydro> hydroArrayList;

    public HydroAdapter(ArrayList<Hydro> hydroArrayList) {
        this.hydroArrayList = hydroArrayList;
    }
    @NonNull
    @Override
    public HydroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemHydroBinding itemHydroBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_hydro,parent,false);

        HydroViewHolder hydroViewHolder = new HydroViewHolder(itemHydroBinding);
        return hydroViewHolder ;


    }

    @Override
    public void onBindViewHolder(@NonNull HydroViewHolder holder, int position) {

        Hydro hydro = this.hydroArrayList.get(position);
        holder.itemHydroBinding.setHydro(hydro);

    }

    @Override
    public int getItemCount() {
        return this.hydroArrayList.size();
    }

    public class HydroViewHolder extends RecyclerView.ViewHolder {

        ItemHydroBinding itemHydroBinding;

        public HydroViewHolder(@NonNull ItemHydroBinding itemView) {
            super(itemView.getRoot());
            this.itemHydroBinding = itemView;
        }
    }
}
