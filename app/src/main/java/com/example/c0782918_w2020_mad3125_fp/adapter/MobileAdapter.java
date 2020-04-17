package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ItemMobileBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;

import java.util.ArrayList;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MobileViewHolder> {

    private ArrayList<Mobile> mobileArrayList;

    public MobileAdapter(ArrayList<Mobile> mobileArrayList) {
        this.mobileArrayList = mobileArrayList;
    }

    @NonNull
    @Override
    public MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemMobileBinding itemMobileBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_mobile,parent,false);

        MobileViewHolder mobileViewHolder = new MobileViewHolder(itemMobileBinding);
        return mobileViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MobileViewHolder holder, int position) {

        Mobile mobile = this.mobileArrayList.get(position);
        holder.itemMobileBinding.setMobile(mobile);


    }

    @Override
    public int getItemCount() {
        return this.mobileArrayList.size();
    }

    public class MobileViewHolder extends RecyclerView.ViewHolder {

        ItemMobileBinding itemMobileBinding;
        public MobileViewHolder(@NonNull ItemMobileBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
