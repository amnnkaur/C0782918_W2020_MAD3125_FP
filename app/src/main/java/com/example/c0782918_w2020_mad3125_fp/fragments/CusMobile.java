package com.example.c0782918_w2020_mad3125_fp.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydroAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.MobileAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusMobileBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CusMobile extends Fragment {

    private MobileAdapter mobileAdapter;
    private ArrayList<Mobile> mobileArrayList;

    public CusMobile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentCusMobileBinding cusMobileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_cus_mobile,container,false);

        cusMobileBinding.rvCusMobile.setLayoutManager(new LinearLayoutManager(getActivity()));

        mobileAdapter = new MobileAdapter(mobileArrayList);
        cusMobileBinding.rvCusMobile.setAdapter(mobileAdapter);
        DataStorage.getInstance().loadData();
        populateMobileBill();

        return inflater.inflate(R.layout.fragment_cus_mobile, container, false);
    }

    public void populateMobileBill(){
         mobileArrayList= new ArrayList<>();

        if(DataStorage.getInstance().getAllCustomers().size() == 0){
            Toast.makeText(getContext(), "Null", Toast.LENGTH_SHORT).show();
        }else{
            mobileArrayList = DataStorage.getInstance().getAllMobile();}


    }
}
