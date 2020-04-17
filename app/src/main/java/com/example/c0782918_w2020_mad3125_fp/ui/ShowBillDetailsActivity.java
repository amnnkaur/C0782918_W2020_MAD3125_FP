package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydroAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.InternetAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.MobileAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.PagerAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityShowBillDetailsBinding;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusHydro;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusInternet;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusMobile;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ShowBillDetailsActivity extends AppCompatActivity {

    ActivityShowBillDetailsBinding showBillDetailsBinding;

    private HydroAdapter hydroAdapter;
    private InternetAdapter internetAdapter;
    private MobileAdapter mobileAdapter;
    public PagerAdapter pagerAdapter;

    private ArrayList<Hydro> hydroArrayList;
    private ArrayList<Mobile> mobileArrayList;
    private ArrayList<Internet> internetArrayList;

    Bundle fetch;
    Customer object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBillDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_show_bill_details);


        Intent myIntent = getIntent();
        fetch = myIntent.getBundleExtra("object");
        object = (Customer) fetch.getSerializable("customerDetail");

        showBillDetailsBinding.setCustomer(object);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        CusHydro cusHydro = new CusHydro();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragment2, cusHydro, "HYDRO");
        mFragmentTransaction.commit();


        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),showBillDetailsBinding.tabCusBills.getTabCount());
        showBillDetailsBinding.vpBills.setAdapter(pagerAdapter);

        showBillDetailsBinding.tabCusBills.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                FragmentManager mFragmentManager = getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();


                showBillDetailsBinding.vpBills.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    CusHydro cusHydro = new CusHydro();
                    Toast.makeText(ShowBillDetailsActivity.this, "Hydro", Toast.LENGTH_SHORT).show();
                    pagerAdapter.notifyDataSetChanged();
                    mFragmentTransaction.replace(R.id.fragment2, cusHydro);

                }
                else if(tab.getPosition() == 1){
                    CusInternet cusInternet = new CusInternet();
                    Toast.makeText(ShowBillDetailsActivity.this, "Internet", Toast.LENGTH_SHORT).show();
                    pagerAdapter.notifyDataSetChanged();
                    mFragmentTransaction.replace(R.id.fragment2, cusInternet);
                }
                else if(tab.getPosition() == 2){
                    CusMobile cusMobile = new CusMobile();
                    Toast.makeText(ShowBillDetailsActivity.this, "Mobile", Toast.LENGTH_SHORT).show();
                    pagerAdapter.notifyDataSetChanged();
                    mFragmentTransaction.replace(R.id.fragment2, cusMobile);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        showBillDetailsBinding.vpBills.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(showBillDetailsBinding.tabCusBills));
    }
}
