package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityAddNewCustomerBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;

public class AddNewCustomerActivity extends AppCompatActivity {

    ActivityAddNewCustomerBinding addNewCustomerBinding;

    private NewCustomerHandler newCustomerHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addNewCustomerBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_customer);

        newCustomerHandler = new NewCustomerHandler(this);

        addNewCustomerBinding.setNewCustomerHandler(newCustomerHandler);

    }

    public class NewCustomerHandler {

        Context context;

        public NewCustomerHandler(Context context) {
            this.context = context;
        }

        public void onSaveBtnClicked(View view){

            Customer cust = new Customer(Integer.parseInt(addNewCustomerBinding.txtID.getText().toString()),R.drawable.male,addNewCustomerBinding.txtFirstName.getText().toString(),addNewCustomerBinding.txtLastName.getText().toString(),addNewCustomerBinding.txtEmailAddress.getText().toString(),addNewCustomerBinding.txtMobile.getText().toString());
            DataStorage.getInstance().addCustomer(cust);

            Intent custIntent = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
            startActivity(custIntent);
            return;
        }
    }

}
