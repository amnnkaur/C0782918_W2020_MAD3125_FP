package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ItemCustomerBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.ui.ShowBillDetailsActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private ArrayList<Customer> customerArrayList;

    public CustomerAdapter(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer,
                parent,
                false);
       CustomerViewHolder customerViewHolder = new CustomerAdapter.CustomerViewHolder(mView);

        return customerViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerViewHolder holder, final int position) {

        Customer customer = this.customerArrayList.get(position);
        holder.fullName.setText(customer.getFullName());
        holder.email.setText(customer.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Customer pos = customerArrayList.get(position);
                Bundle myBundle = new Bundle();
                myBundle.putSerializable("customerDetail", (Serializable) pos);

                Intent cusIntent = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
                cusIntent.putExtra("object", myBundle);
                holder.itemView.getContext().startActivity(cusIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.customerArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView fullName;
        TextView email;

        public CustomerViewHolder(@NonNull View itemView) {

            super(itemView);

            fullName = itemView.findViewById(R.id.textViewName);
            email = itemView.findViewById(R.id.textViewEmail);

        }
    }
}
