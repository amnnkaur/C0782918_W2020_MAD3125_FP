package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityAddNewBillBinding;

public class AddNewBillActivity extends AppCompatActivity {

    ActivityAddNewBillBinding addNewBillBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addNewBillBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_bill);
    }
}
