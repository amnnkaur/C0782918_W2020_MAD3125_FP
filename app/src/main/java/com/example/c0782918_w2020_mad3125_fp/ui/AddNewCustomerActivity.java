package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityAddNewCustomerBinding;

public class AddNewCustomerActivity extends AppCompatActivity {

    ActivityAddNewCustomerBinding addNewCustomerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       addNewCustomerBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_customer);
    }
}
