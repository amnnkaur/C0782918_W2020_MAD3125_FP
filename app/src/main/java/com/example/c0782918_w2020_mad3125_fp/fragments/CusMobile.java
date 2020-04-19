package com.example.c0782918_w2020_mad3125_fp.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.MobileAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusHydroBinding;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusMobileBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;
import com.example.c0782918_w2020_mad3125_fp.ui.ShowBillDetailsActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CusMobile extends Fragment {

    private MobileAdapter mobileAdapter;
    static private ArrayList<Mobile> mobileArrayList;
    FragmentCusMobileBinding cusMobileBinding;
    private RecyclerView mobileRv;


    public CusMobile() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cus_mobile,container,false);
        return view ;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShowBillDetailsActivity fragObject = (ShowBillDetailsActivity) getActivity();

        mobileRv = view.findViewById(R.id.rvCusMobile);
//        DataStorage.getInstance().loadData();
        populateMobileBill();
    }
    public void populateMobileBill(){

        mobileArrayList = new ArrayList<>();
        if(DataStorage.getInstance().getAllMobile().size() == 0){
            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
        }else{
            mobileArrayList = DataStorage.getInstance().getAllMobile();
            mobileAdapter = new MobileAdapter(mobileArrayList);

            mobileRv.setAdapter(mobileAdapter);
        }
    }
}