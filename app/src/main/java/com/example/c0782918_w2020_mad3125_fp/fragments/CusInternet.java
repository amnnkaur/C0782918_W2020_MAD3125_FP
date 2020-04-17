package com.example.c0782918_w2020_mad3125_fp.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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
    View view;
    private InternetAdapter internetAdapter;
    private ArrayList<Internet> internetArrayList;

    FragmentCusInternetBinding cusInternetBinding;

    public CusInternet() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cus_internet,container,false);
        internetAdapter = new InternetAdapter(internetArrayList);
        cusInternetBinding.rvCusInternet.setLayoutManager(new LinearLayoutManager(getActivity()));
        cusInternetBinding.rvCusInternet.setAdapter(internetAdapter);
        DataStorage.getInstance().loadData();
        populateInternetBill();

        return view;
    }

    public void populateInternetBill(){
        internetArrayList = new ArrayList<>();

        if(DataStorage.getInstance().getAllCustomers().size() == 0){
            Toast.makeText(getContext(), "Null", Toast.LENGTH_SHORT).show();
        }else{
            internetArrayList = DataStorage.getInstance().getAllInternet();}


    }
}
