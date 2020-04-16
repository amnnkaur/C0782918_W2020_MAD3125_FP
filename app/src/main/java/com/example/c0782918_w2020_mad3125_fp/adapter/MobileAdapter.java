package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MobileViewHolder> {
    @NonNull
    @Override
    public MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MobileViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MobileViewHolder extends RecyclerView.ViewHolder {
        public MobileViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
