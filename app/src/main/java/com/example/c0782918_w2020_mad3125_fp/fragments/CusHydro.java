package com.example.c0782918_w2020_mad3125_fp.fragments;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
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
import com.example.c0782918_w2020_mad3125_fp.ui.ShowBillDetailsActivity;
import java.util.ArrayList;
import java.util.zip.Inflater;
import static androidx.recyclerview.widget.LinearLayoutManager.*;
public class CusHydro extends Fragment {
    private HydroAdapter hydroAdapter;
    private ArrayList<Hydro> hydroArrayList;
    FragmentCusHydroBinding cusHydroBinding;
    private RecyclerView hydroRV;
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
//        fragObject.toastString = "Activity: From Red Fragment";
        hydroRV = view.findViewById(R.id.rvCusHydro);
//        hydroAdapter = new HydroAdapter(hydroArrayList);
//        cusHydroBinding.rvCusHydro.setLayoutManager(new LinearLayoutManager(getActivity()));
//        cusHydroBinding.rvCusHydro.setAdapter(hydroAdapter);
        DataStorage.getInstance().loadData();
        populateHydroBill();
    }
    public void populateHydroBill(){
//        Toast.makeText(getContext(),"HydroFrag",Toast.LENGTH_SHORT).show();
        hydroArrayList = new ArrayList<>();
        if(DataStorage.getInstance().getAllHydro().size() == 0){
            Toast.makeText(getContext(), String.valueOf(DataStorage.getInstance().getAllHydro().size()), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(),String.valueOf(DataStorage.getInstance().getAllHydro().get(2).getBillID()),Toast.LENGTH_SHORT).show();
            hydroArrayList = DataStorage.getInstance().getAllHydro();
            hydroAdapter = new HydroAdapter(hydroArrayList);
//            hydroRV.setLayoutManager();
            hydroRV.setAdapter(hydroAdapter);
        }
    }
}