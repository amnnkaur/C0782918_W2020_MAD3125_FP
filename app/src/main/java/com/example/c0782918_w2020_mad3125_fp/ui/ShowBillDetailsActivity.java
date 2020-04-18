package com.example.c0782918_w2020_mad3125_fp.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityShowBillDetailsBinding;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusHydro;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.google.android.material.tabs.TabLayout;


public class ShowBillDetailsActivity extends AppCompatActivity {

    ActivityShowBillDetailsBinding showBillDetailsBinding;

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

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


        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragment_2, new CusHydro());
        mFragmentTransaction.commit();
        Fragment fragValue = null;
        fragValue = new CusHydro();
        mFragmentTransaction.replace(R.id.fragment_2, fragValue);

        showBillDetailsBinding.tabCusBills.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                Fragment fragValue = null;
                switch(tab.getPosition()){
                    case 0:
                        fragValue = new CusHydro();
                        mFragmentTransaction.replace(R.id.fragment_2, fragValue);
                        break;
                    case 1:
//                        fragValue = new CusHydro();
//                        mFragmentTransaction.replace(R.id.fragment_2, fragValue);
                        break;
                    case 2:
//                        fragValue = new CusHydro();
//                        mFragmentTransaction.replace(R.id.fragment_2, fragValue);
                        break;
                }
                mFragmentTransaction.commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
}