package com.example.c0782918_w2020_mad3125_fp.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.InternetAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusHydroBinding;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusInternetBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;
import com.example.c0782918_w2020_mad3125_fp.ui.ShowBillDetailsActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CusInternet extends Fragment {

    private InternetAdapter internetAdapter;
    static private ArrayList<Internet> internetArrayList;
    FragmentCusInternetBinding cusInternetBinding;
    private RecyclerView internetRV;

    public static String customerid;

    public CusInternet() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cus_internet,container,false);
        return view ;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShowBillDetailsActivity fragObject = (ShowBillDetailsActivity) getActivity();

        internetRV = view.findViewById(R.id.rvCusInternet);
        internetRV.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
//        DataStorage.getInstance().loadData();
        populateInternetBill();
    }
    public void populateInternetBill(){

        internetArrayList = new ArrayList<>();
        if(DataStorage.getInstance().getAllInternet().size() == 0){
            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
        }else{
            ArrayList<Internet> sortedInternetArrayList = new ArrayList<>();
            internetArrayList = DataStorage.getInstance().getAllInternet();
            for(int i = 0;i<internetArrayList.size();i++){
                if(internetArrayList.get(i).getCustomerId().equals(customerid)){
                    sortedInternetArrayList.add(internetArrayList.get(i));
                }
            }
            internetAdapter = new InternetAdapter(sortedInternetArrayList);

            internetRV.setAdapter(internetAdapter);
        }
    }
}