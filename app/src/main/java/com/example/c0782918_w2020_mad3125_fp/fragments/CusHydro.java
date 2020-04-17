package com.example.c0782918_w2020_mad3125_fp.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydroAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusHydroBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;
import com.example.c0782918_w2020_mad3125_fp.ui.CustomerListActivity;

import java.util.ArrayList;


public class CusHydro extends Fragment {

    private HydroAdapter hydroAdapter;
    private ArrayList<Hydro> hydroArrayList;

    public CusHydro() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentCusHydroBinding fragmentCusHydroBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cus_hydro,container, false);
        hydroAdapter = new HydroAdapter(hydroArrayList);
        fragmentCusHydroBinding.rvCusHydro.setAdapter(hydroAdapter);
        DataStorage.getInstance().loadData();
        populateHydroBill();

        return inflater.inflate(R.layout.fragment_cus_hydro, container, false);
    }

    public void populateHydroBill(){
        hydroArrayList = new ArrayList<>();

        if(DataStorage.getInstance().getAllCustomers().size() == 0){
            Toast.makeText(getContext(), "Null", Toast.LENGTH_SHORT).show();
        }else{
            hydroArrayList = DataStorage.getInstance().getAllHydro();}


    }
}
