package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ItemInternetBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;

import java.text.NumberFormat;
import java.util.ArrayList;

public class InternetAdapter  extends RecyclerView.Adapter<InternetAdapter.InternetViewHolder> {

    private ArrayList<Internet> internetArrayList;
    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

    public InternetAdapter(ArrayList<Internet> internetArrayList) {
        this.internetArrayList = internetArrayList;
    }


    @NonNull
    @Override
    public InternetAdapter.InternetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_internet,
                parent,
                false);
        InternetViewHolder internetViewHolder = new InternetAdapter.InternetViewHolder(mView);

        return internetViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull InternetAdapter.InternetViewHolder holder, int position) {

        Internet internet = this.internetArrayList.get(position);
        holder.id.setText(internet.getBillID());
        holder.date.setText(String.valueOf(internet.getBillDate()));
        holder.providerName.setText(internet.getProviderName());
        holder.internetGBUsed.setText(internet.getInternetGBUsed() + " GB");
        holder.amount.setText(defaultFormat.format(internet.getBillTotal()));

    }

    @Override
    public int getItemCount() {
        return this.internetArrayList.size();
    }

    public class InternetViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView date;
        TextView providerName;
        TextView internetGBUsed;
        TextView amount;

        public InternetViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txtIntBillID);
            date = itemView.findViewById(R.id.txtIntBillDate);
            providerName = itemView.findViewById(R.id.txtProviderName);
            internetGBUsed = itemView.findViewById(R.id.txtInternetGB);
            amount = itemView.findViewById(R.id.txtInternetBillAmount);
        }
    }
}
