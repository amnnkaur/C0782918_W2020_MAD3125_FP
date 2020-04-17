package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.PagerAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityShowBillDetailsBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ShowBillDetailsActivity extends AppCompatActivity {

    ActivityShowBillDetailsBinding showBillDetailsBinding;

    public PagerAdapter pagerAdapter;

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

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),showBillDetailsBinding.tabCusBills.getTabCount());
        showBillDetailsBinding.vpBills.setAdapter(pagerAdapter);

        showBillDetailsBinding.tabCusBills.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                showBillDetailsBinding.vpBills.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }
                else if(tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
                else if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
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
