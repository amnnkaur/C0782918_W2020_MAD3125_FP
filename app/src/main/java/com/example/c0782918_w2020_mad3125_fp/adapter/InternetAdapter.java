package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ItemInternetBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;

import java.util.ArrayList;

public class InternetAdapter  extends RecyclerView.Adapter<InternetAdapter.InternetViewHolder> {

    private ArrayList<Internet> internetArrayList;

    public InternetAdapter(ArrayList<Internet> internetArrayList) {
        this.internetArrayList = internetArrayList;
    }


    @NonNull
    @Override
    public InternetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemInternetBinding itemInternetBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_internet,parent,false);

        InternetViewHolder internetViewHolder = new InternetViewHolder(itemInternetBinding);
        return internetViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull InternetViewHolder holder, int position) {

        Internet internet = this.internetArrayList.get(position);
        holder.itemInternetBinding.setInternet(internet);

    }

    @Override
    public int getItemCount() {
        return this.internetArrayList.size();
    }

    public class InternetViewHolder extends RecyclerView.ViewHolder {

        ItemInternetBinding itemInternetBinding;
        public InternetViewHolder(@NonNull ItemInternetBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
