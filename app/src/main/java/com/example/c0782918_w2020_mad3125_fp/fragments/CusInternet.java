package com.example.c0782918_w2020_mad3125_fp.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.InternetAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusInternetBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CusInternet extends Fragment {
    private InternetAdapter internetAdapter;
    private ArrayList<Internet> internetArrayList;

    public CusInternet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentCusInternetBinding cusInternetBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_cus_internet,container,false);

        internetAdapter = new InternetAdapter(internetArrayList);
        cusInternetBinding.rvCusInternet.setAdapter(internetAdapter);
        DataStorage.getInstance().loadData();
        populateInternetBill();

        return inflater.inflate(R.layout.fragment_cus_internet, container, false);
    }

    public void populateInternetBill(){
        internetArrayList = new ArrayList<>();

        if(DataStorage.getInstance().getAllCustomers().size() == 0){
            Toast.makeText(getContext(), "Null", Toast.LENGTH_SHORT).show();
        }else{
            internetArrayList = DataStorage.getInstance().getAllInternet();}


    }
}
