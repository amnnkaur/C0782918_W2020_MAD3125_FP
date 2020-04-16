package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.c0782918_w2020_mad3125_fp.DataBinderMapperImpl;
import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.CustomerAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityCustomerListBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

    ActivityCustomerListBinding customerListBinding;

    private CustomerAdapter customerAdapter;

    private ArrayList<Customer> customerArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customerListBinding = DataBindingUtil.setContentView(this, R.layout.activity_customer_list);

        customerListBinding.rvCustomerList.setLayoutManager(new LinearLayoutManager(this));

        DataStorage.getInstance().loadData();
        populateCustomers();

        customerAdapter = new CustomerAdapter(customerArrayList);
        customerListBinding.rvCustomerList.setAdapter(customerAdapter);

        customerListBinding.fabAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fIntent = new Intent(CustomerListActivity.this,AddNewCustomerActivity.class);
                startActivity(fIntent);
            }
        });

    }
    public void populateCustomers(){
        customerArrayList = new ArrayList<>();

        if(DataStorage.getInstance().getAllCustomers().size() == 0){
            Toast.makeText(CustomerListActivity.this, "Null", Toast.LENGTH_SHORT).show();
        }else{
            customerArrayList = DataStorage.getInstance().getAllCustomers();}

      //  customerArrayList.add();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customer,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_aboutUs:
                /*Intent abtIntent = new Intent(CustomerListActivity.this,AddNewCustomerActivity.class);
                startActivity(abtIntent);*/
                break;
            case R.id.menu_contactUs:
               /* Intent conIntent = new Intent(CustomerListActivity.this,LoginActivity.class);
                startActivity(conIntent);*/
                break;
            case R.id.menu_logout:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(CustomerListActivity.this);
                alertBuilder.setTitle("Logout");
                alertBuilder.setMessage("Are you sure you want to Logout?");
                alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent backIntent = new Intent(CustomerListActivity.this,LoginActivity.class);
                        startActivity(backIntent);
                    }

                });
                alertBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })

                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
