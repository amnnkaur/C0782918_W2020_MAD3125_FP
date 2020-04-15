package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityShowBillDetailsBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;

public class ShowBillDetailsActivity extends AppCompatActivity {

    ActivityShowBillDetailsBinding showBillDetailsBinding;

    Bundle fetch;

    Customer object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBillDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_show_bill_details);

        Intent myIntent = getIntent();
        fetch = myIntent.getBundleExtra("object");
        object = (Customer) fetch.getSerializable("customerDetail");

      //  showBillDetailsBinding.setCustomer(object);

    }
}
