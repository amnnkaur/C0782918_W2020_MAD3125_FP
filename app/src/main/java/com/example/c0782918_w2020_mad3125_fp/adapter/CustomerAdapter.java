package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ItemCustomerBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private ArrayList<Customer> customerArrayList;

    public CustomerAdapter(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemCustomerBinding itemCustomerBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_customer,parent,false);

        CustomerViewHolder customerViewHolder = new CustomerViewHolder(itemCustomerBinding);
        return customerViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.customerArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        public CustomerViewHolder(@NonNull ItemCustomerBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
