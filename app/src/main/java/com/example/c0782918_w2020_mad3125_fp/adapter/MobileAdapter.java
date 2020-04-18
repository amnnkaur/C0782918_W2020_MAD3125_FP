package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ItemMobileBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MobileViewHolder> {

    private ArrayList<Mobile> mobileArrayList;
    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

    public MobileAdapter(ArrayList<Mobile> mobileArrayList) {
        this.mobileArrayList = mobileArrayList;
    }

    @NonNull
    @Override
    public MobileAdapter.MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile,
                parent,
                false);
        MobileAdapter.MobileViewHolder mobileViewHolder = new MobileAdapter.MobileViewHolder(mView);

        return mobileViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MobileAdapter.MobileViewHolder holder, int position) {

        Mobile mobile = this.mobileArrayList.get(position);
        holder.id.setText(mobile.getBillID());
        holder.date.setText(String.valueOf(mobile.getBillDate()));
        holder.mobileManfName.setText(mobile.getMobileManfName());
        holder.planName.setText(mobile.getPlanName());
        holder.internetGBUsed.setText(mobile.getInternetUsed() + " GB");
        holder.minutesUsed.setText(mobile.getMinuteUsed() + " Minutes");
        holder.amount.setText(defaultFormat.format(mobile.getBillTotal()));

    }

    @Override
    public int getItemCount() {
        return this.mobileArrayList.size();
    }

    public class MobileViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView date;
        TextView mobileManfName;
        TextView planName;
        TextView internetGBUsed;
        TextView minutesUsed;
        TextView amount;

        public MobileViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txtHydBillID);
            date = itemView.findViewById(R.id.txtHydBillDate);
            mobileManfName = itemView.findViewById(R.id.txtManf);
            planName = itemView.findViewById(R.id.txtPlanName);
            internetGBUsed = itemView.findViewById(R.id.txtMobIntGB);
            minutesUsed = itemView.findViewById(R.id.txtMinutes);
            amount = itemView.findViewById(R.id.txtHydBillAmount);
        }
    }
}
