package com.example.c0782918_w2020_mad3125_fp.fragments;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.FragmentCusHydroBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;
import com.example.c0782918_w2020_mad3125_fp.ui.ShowBillDetailsActivity;
import java.util.ArrayList;


public class CusHydro extends Fragment {

    private HydAdapter hydroAdapter;
    static private ArrayList<Hydro> hydroArrayList;
    FragmentCusHydroBinding cusHydroBinding;
    private RecyclerView hydroRV;

    public static String customerid;

    public CusHydro() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cus_hydro,container,false);
        return view ;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShowBillDetailsActivity fragObject = (ShowBillDetailsActivity) getActivity();

        hydroRV = view.findViewById(R.id.rvCusHydro);
        hydroRV.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
//        DataStorage.getInstance().loadData();
        populateHydroBill();
    }
    public void populateHydroBill(){

        hydroArrayList = new ArrayList<>();
        if(DataStorage.getInstance().getAllHydro().size() == 0){
            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
        }else{

            ArrayList<Hydro> sortedHydroArrayList = new ArrayList<>();
            hydroArrayList = DataStorage.getInstance().getAllHydro();
            for(int i = 0;i<hydroArrayList.size();i++){
                if(hydroArrayList.get(i).getCustomerId().equals(customerid)){
                    sortedHydroArrayList.add(hydroArrayList.get(i));
                }
            }
            hydroAdapter = new HydAdapter(sortedHydroArrayList);

            hydroRV.setAdapter(hydroAdapter);
        }
    }
}